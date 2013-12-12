package edu.tcc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author diego.pinho
 */
public class ClassContainer {

	private List<Class<?>> classes;

	/**
	 * Class Construtor
	 */
	public ClassContainer() {
		this.setClasses(new ArrayList<Class<?>>());
	}

	/**
	 * @param cls
	 */
	public void saveClassObject(Class<?> cls) {
		this.classes.add(cls);
	}

	/**
	 * @param cls
	 */
	public void removeClassObject(Class<?> cls) {
		this.classes.remove(cls);
	}

	/**
	 * @return classes
	 */
	public List<Class<?>> getClasses() {
		return classes;
	}

	/**
	 * @param classes
	 */
	public void setClasses(List<Class<?>> classes) {
		this.classes = classes;
	}

	
	
}
