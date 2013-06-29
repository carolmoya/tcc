package edu.tcc.model;

import java.util.HashSet;
import java.util.Set;

import edu.tcc.visitor.Visitable;
import edu.tcc.visitor.Visitor;

/**
 * @author hugo.hennies
 */

public class Method implements Visitable {
	
	private String name;
	private String type;
	private String accessLevel;
	private Set<String> atributesBeingUsed;

	
	/**
	 * Class Constructor
	 */
	public Method() {
		atributesBeingUsed = new HashSet<String>();
	}
	
	
	/**
	 * get the value of atributesBeingUsed
	 * @return A Set of attributes
	 */
	public Set<String> getAtributesBeingUsed() {
		return atributesBeingUsed;
	}

	
	/**
	 * Returns the Set atributesBeingUsed
	 * @param atributesBeingUsed
	 */
	public void setAtributesBeingUsed(Set<String> atributesBeingUsed) {
		this.atributesBeingUsed = atributesBeingUsed;
	}

	
	/**
	 * Accept a visitor
	 * @param Visitor
	 */
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	
	/**
	 * Add an attribute to set attributes
	 * @param s
	 */
	public void addAtribute(String s) {
		atributesBeingUsed.add(s);
	}


	/**
	 * Get the value of name
	 * @return string name
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
	 * @param accessLevel
	 */
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

}
