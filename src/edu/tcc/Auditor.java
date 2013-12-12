package edu.tcc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hugo.hennies
 */
public class Auditor {

	private Class<?> classToAudit;

	private Auditor() {
		// nothing
	}

	public static Auditor auditorFromClass(Class<?> cls) {
		Auditor auditor = new Auditor();
		auditor.classToAudit = cls;
		return auditor;
	}

	/**
	 * @param methodName
	 * @param parameters
	 * @param expectedValue
	 * @return
	 * 
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	public boolean audit(String methodName, Object[] parameters,
			Object expectedValue) throws ClassNotFoundException,
			SecurityException, NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {

		int numberOfParameters = parameters.length;
		Class<?>[] parameterTypes = new Class[numberOfParameters];

		for (int i = 0; i < numberOfParameters; i++) {
			parameterTypes[i] = parameters[i].getClass();
		}
		Method method = getMatchingAccessibleMethod(methodName, parameterTypes);

		if (method != null) {
			return method.invoke(classToAudit.newInstance(), parameters)
					.equals(expectedValue);
		}
		return false;
	}

	private Method getMatchingAccessibleMethod(String methodName, Class<?>[] parameterTypes) {
		try {
			Method method = classToAudit.getMethod(methodName, parameterTypes);
			return method;

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		int paramSize = parameterTypes.length;
		Method[] methods = classToAudit.getMethods();
		for (int i = 0, size = methods.length; i < size; i++) {
			if (methods[i].getName().equals(methodName)) {
				Class<?>[] methodsParams = methods[i].getParameterTypes();
				int methodParamSize = methodsParams.length;
				if (methodParamSize == paramSize) {
					boolean match = true;
					for (int n = 0; n < methodParamSize; n++) {
						if (!isAssignmentCompatible(methodsParams[n],
								parameterTypes[n])) {
							match = false;
							break;
						}
					}

					if (match) {
						Method method = methods[i];
						if (method != null) {
							return method;
						}
					}
				}
			}
		}

		return null;
	}

	private boolean isAssignmentCompatible(Class<?> parameterType, Class<?> parameterization) {

		if (parameterType.isAssignableFrom(parameterization)) {
			return true;
		}

		if (parameterType.isPrimitive()) {
			if (boolean.class.equals(parameterType)) {
				return Boolean.class.equals(parameterization);
			}
			if (float.class.equals(parameterType)) {
				return Float.class.equals(parameterization);
			}
			if (long.class.equals(parameterType)) {
				return Long.class.equals(parameterization);
			}
			if (int.class.equals(parameterType)) {
				return Integer.class.equals(parameterization);
			}
			if (double.class.equals(parameterType)) {
				return Double.class.equals(parameterization);
			}
		}

		return false;
	}
}
