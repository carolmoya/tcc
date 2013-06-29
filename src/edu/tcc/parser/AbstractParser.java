package edu.tcc.parser;


/**
 * @author hugo.hennies
 */

public abstract class AbstractParser {
	
	protected AbstractParser m_successor;
	
	public void setSuccessor(AbstractParser successor) {
		m_successor = successor;
	}


}
