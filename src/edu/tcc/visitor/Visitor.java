package edu.tcc.visitor;

import edu.tcc.model.*;
import edu.tcc.model.EClass;

/**
 * @author hugo.hennies
 */

public interface Visitor {
	
	public void visit (EProject pjt);
	public void visit (EClass cls);
	public void visit (EMethod mtd);
	public void visit (EAttribute atb);

}
