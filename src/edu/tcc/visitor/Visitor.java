package edu.tcc.visitor;

import edu.tcc.model.*;
import edu.tcc.model.Class;

/**
 * @author hugo.hennies
 */

public interface Visitor {
	
	public void visit (Project pjt);
	public void visit (Class cls);
	public void visit (Method mtd);
	public void visit (Attribute atb);

}
