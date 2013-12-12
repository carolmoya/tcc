package edu.tcc.model;

import java.util.HashMap;
import java.util.Map;

import edu.tcc.visitor.Visitable;
import edu.tcc.visitor.Visitor;

/**
 * @author diego.pinho
 */

public class EAttribute implements Visitable {

	private String name;
	private String type;
	private String accessLevel;
	private Map<String, Boolean> modifiers;

	public EAttribute() {
		this.setModifiers(new HashMap<String, Boolean>());
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param String
	 *            name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return accessLevel
	 */
	public String getAccessLevel() {
		return accessLevel;
	}

	/**
	 * @param accessLevel
	 */
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	/**
	 * @param Visitor
	 */
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	/**
	 * @return modifiers
	 */
	public Map<String, Boolean> getModifiers() {
		return modifiers;
	}

	/**
	 * @param modifiers
	 */
	public void setModifiers(Map<String, Boolean> modifiers) {
		this.modifiers = modifiers;
	}

}
