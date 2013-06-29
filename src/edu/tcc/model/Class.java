package edu.tcc.model;

import java.util.ArrayList;
import java.util.List;

import edu.tcc.visitor.Visitable;
import edu.tcc.visitor.Visitor;

/**
 * @author diego.pinho
 */

public class Class implements Visitable {

	private String name;
	private String ancestorClassName;
	private List<Method> methods;
	
	/**
	 * Class constructor
	 */
	public Class() {
		methods = new ArrayList<Method>();
	}

	
	/**
	 * @return the value of name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Verify if the class has an ancestor
	 * @return true or false
	 */
	public boolean hasAncestor() {
		if(ancestorClassName == null) return false;
		else return true;
	}

	
	/**
	 * Set a new value for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the value of fatherClassName
	 */
	public String getAncestorClassName() {
		return ancestorClassName;
	}


	/**
	 * Set a new value for fatherClassName
	 * @param fatherClassName
	 */
	public void setAncestorClassName(String fatherClassName) {
		this.ancestorClassName = fatherClassName;
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
	 * Return the size of methods list
	 * @return the size
	 */
	public int getMethodCount() {
		return methods.size();
	}
	
	
	/**
	 * Accept the visitor on all methods
	 * @param Visitor
	 */
	public void acceptOnAllMethods(Visitor v) {
		for (Method m : methods) {
			m.accept(v);
		}
	}
	
	
	/**
	 * Add a method to the list methods
	 * @param m
	 */
	public void addMethod(Method m){
		methods.add(m);
	}

}
