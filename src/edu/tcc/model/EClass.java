package edu.tcc.model;

import java.util.ArrayList;
import java.util.List;

import edu.tcc.visitor.Visitable;
import edu.tcc.visitor.Visitor;

/**
 * @author diego.pinho
 */

public class EClass implements Visitable {

	private String name;
	private String ancestorClassName;
	private List<EMethod> methods;
	private List<EAttribute> attributes;
	
	/**
	 * Class constructor
	 */
	public EClass() {
		this.methods = new ArrayList<EMethod>();
		this.setAttributes(new ArrayList<EAttribute>());
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
		for (EMethod m : methods) {
			m.accept(v);
		}
	}
	
	
	/**
	 * Add a method to the list methods
	 * @param m
	 */
	public void addMethod(EMethod m){
		methods.add(m);
	}


	/**
	 * @return methods
	 */
	public List<EMethod> getMethods() {
		return methods;
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
	 * @param methods
	 */
	public void setMethods(List<EMethod> methods) {
		this.methods = methods;
	}


	/**
	 * @return attributes
	 */
	public List<EAttribute> getAttributes() {
		return attributes;
	}


	/**
	 * @param attributes
	 */
	public void setAttributes(List<EAttribute> attributes) {
		this.attributes = attributes;
	}

}
