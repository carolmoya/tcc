package edu.tcc.model;

import edu.tcc.visitor.Visitable;
import edu.tcc.visitor.Visitor;

/**
 * @author diego.pinho
 */

public class Attribute implements Visitable {

	private String name;
	private String type;
	private String accessLevel;
	
	
	/**
	 * Get the value of name
	 * @return String
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * Set a new value for name
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * Get the value of type
	 * @return String type
	 */
	public String getType() {
		return type;
	}

	
	/**
	 * Set a new value for type
	 * @param String type
	 */
	public void setType(String type) {
		this.type = type;
	}

	
	/**
	 * Get the value of accessLevel
	 * @return String
	 */
	public String getAccessLevel() {
		return accessLevel;
	}

	
	/**
	 * Set a new value for accessLevel
	 * @param Strin accessLevel
	 */
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	
	/**
	 * Accept a visitor
	 * @param Visitor
	 */
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}