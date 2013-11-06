package edu.tcc.parser;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

import edu.tcc.model.EAttribute;

/**
 * @author diego.pinho
 */

public class AttributeParser {
	
	public EAttribute parseAttribute(Field field){
		EAttribute attribute = new EAttribute();
		attribute.setName(field.getName());
		attribute.setType(field.getType().getName());
		this.populateFieldModifiers(attribute, field);
		this.defineFieldLevel(attribute);
		
		return attribute;
	}
	
	private void populateFieldModifiers(EAttribute attribute, Field field){
		Map<String, Boolean> modifiers = attribute.getModifiers();
		modifiers.put("static", this.isStatic(field)); // static
		modifiers.put("private", this.isPrivate(field)); // private
		modifiers.put("public", this.isPublic(field)); //public
		modifiers.put("protected", this.isProtected(field)); //protected
		
		attribute.setModifiers(modifiers);
	}
	
	private void defineFieldLevel(EAttribute attribute){
		String level = "";
		Map<String, Boolean> modifiers = attribute.getModifiers();
		if(modifiers.get("public")) level = "public";
		else if(modifiers.get("private")) level = "private";
		else if(modifiers.get("protected")) level = "protected";
		else level = "protected";
		attribute.setAccessLevel(level);
	}
	
	public boolean isStatic(Field field) {
		return Modifier.isStatic(field.getModifiers());
	}
	
	/**
	 * @param method
	 */
	private boolean isPrivate(Field field){
		return Modifier.isPrivate(field.getModifiers());
	}
	
	/**
	 * @param method
	 */
	private boolean isPublic(Field field){
		return Modifier.isPublic(field.getModifiers());
	}
	
	/**
	 * @param method
	 */
	private boolean isProtected(Field field){
		return Modifier.isProtected(field.getModifiers());
	}
	
}
