package edu.tcc.parser;

import edu.tcc.model.ProjectComponent;

/**
 * @author hugo.hennies
 */

public abstract class AbstractParser {
	
	protected AbstractParser m_successor;
	
	public void setSuccessor(AbstractParser successor) {
		m_successor = successor;
	}

	public abstract ProjectComponent parse(String s);

}
