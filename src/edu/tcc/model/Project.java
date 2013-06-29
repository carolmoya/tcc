package edu.tcc.model;

import java.util.LinkedList;
import java.util.List;

import edu.tcc.visitor.Visitable;
import edu.tcc.visitor.Visitor;

/**
 * @author hugo.hennies
 */

public class Project implements Visitable{

	private List<Class> classes;

	/**
	 * Class constructor
	 */
	public Project(){
		classes = new LinkedList<Class>();
	}

	
	/**
	 * Add a class into list classes
	 * @param c - the class 
	 */
	public void addClass (Class c){
		classes.add(c);
	}

	
	/**
	 * Given a list of classes, add them all to classes list
	 * @param cls - the list of classes
	 */
	public void addAllClasses(List<Class> cls){
		classes.addAll(cls);
	}
	
	
	/**
	 * Remove a class from the list given an index
	 * @param index
	 */
	public void removeClass(int index){
		classes.remove(index);
	}
	
	
	/**
	 * Remove a class from the list given the object
	 * @param cls 
	 */
	public void removeClass(Class cls){
		classes.remove(cls);
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
	 * Accept a visitor on all classes
	 * @param Visitor
	 */
	public void acceptOnAllClasses(Visitor v)
	{
		for (Class cls : classes) {
			cls.accept(v);
		}
	}

}
