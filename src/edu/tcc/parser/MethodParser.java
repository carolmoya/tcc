package edu.tcc.parser;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

import edu.tcc.model.EMethod;

/**
 * @author diego.pinho
 */

public class MethodParser {

	/**
	 * @param method
	 */
	public EMethod parseMethod(Method method){
		EMethod populateMethod = new edu.tcc.model.EMethod(); 
		populateMethod.setName(method.getName());
		populateMethod.setType(method.getReturnType().getName());
		
		this.populateMethodModifiers(populateMethod,method);
		this.defineMethodLevel(populateMethod);		
		
		return populateMethod;
	}

	
	/**
	 * @param populateMethod
	 * @param method
	 */
	private void populateMethodModifiers(EMethod populateMethod, Method method){
		Map<String, Boolean> modifiers = populateMethod.getModifiers();
		modifiers.put("static", this.isStatic(method)); // static
		modifiers.put("private", this.isPrivate(method)); // private
		modifiers.put("public", this.isPublic(method)); //public
		modifiers.put("protected", this.isProtected(method)); //protected
		
		populateMethod.setModifiers(modifiers);
	}
	
	/**
	 * @param method
	 */
	private void defineMethodLevel(EMethod method){
		String level = "";
		Map<String, Boolean> modifiers = method.getModifiers();
		if(modifiers.get("public")) level = "public";
		else if(modifiers.get("private")) level = "private";
		else if(modifiers.get("protected")) level = "protected";
		else level = "protected";
		method.setAccessLevel(level);
	}
	
	
	/**
	 * @param method
	 */
	public boolean isStatic(Method method) {
		return Modifier.isStatic(method.getModifiers());
	}
	
	/**
	 * @param method
	 */
	private boolean isPrivate(Method method){
		return Modifier.isPrivate(method.getModifiers());
	}
	
	/**
	 * @param method
	 */
	private boolean isPublic(Method method){
		return Modifier.isPublic(method.getModifiers());
	}
	
	/**
	 * @param method
	 */
	private boolean isProtected(Method method){
		return Modifier.isProtected(method.getModifiers());
	}
}
