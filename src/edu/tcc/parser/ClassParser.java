package edu.tcc.parser;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import edu.tcc.model.EClass;

/**
 * @author diego.pinho
 */

public class ClassParser {
	
	private MethodParser methodParser;
	private AttributeParser attributeParser;
	
	/**
	 * Constructor
	 */
	public ClassParser(){
		this.methodParser = new MethodParser();
		this.attributeParser = new AttributeParser();
	}
	
	/**
	 * @param klass
	 * @return edu.tcc.model.Class
	 */
	public EClass parseClass(Class<? extends Object> klass){
		EClass populateKlass = new EClass();
		populateKlass.setName(klass.getName()); 
		
		if(klass.getSuperclass() != null) {
			populateKlass.setAncestorClassName(klass.getSuperclass().getName());
		}
		
		Method[] methods = klass.getMethods();
		for (Method method : methods) {
			edu.tcc.model.EMethod populateMethod = this.methodParser.parseMethod(method);
			populateKlass.getMethods().add(populateMethod);
		}
		
		Field fieldlist[] = klass.getDeclaredFields();
		for (Field field : fieldlist) {
			edu.tcc.model.EAttribute populateAttribute = this.attributeParser.parseAttribute(field);
			populateKlass.getAttributes().add(populateAttribute);
		}
		
		return populateKlass;
	}

}