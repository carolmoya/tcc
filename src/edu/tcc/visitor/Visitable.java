package edu.tcc.visitor;

/**
 * @author hugo.hennies
 */

public interface Visitable {
	
	public void accept(Visitor v);

}
