package edu.tcc.visitor;

import java.util.HashMap;
import java.util.Map;

import edu.tcc.model.Attribute;
import edu.tcc.model.Class;
import edu.tcc.model.Method;
import edu.tcc.model.Project;

/**
 * @author diego.pinho
 */

public class WMC implements Visitor {
	
	private Map<String, Number> mapWMC;

	
	/**
	 * Class constructor
	 */
	public WMC(){
		mapWMC = new HashMap<String,Number>();
	}
	
	
	/**
	 * Visit the project
	 */
	@Override
	public void visit(Project pjt) {
		pjt.acceptOnAllClasses(this);
	}

	
	/**
	 * Visit the class
	 * @param Class
	 */
	@Override
	public void visit(Class cls) {
		mapWMC.put(cls.getName(), cls.getMethodCount());
	}
	
	
	/**
	 * Returns the mapWMC
	 * @return Map<String,Number>
	 */
	public Map<String,Number> getmapWMC(){
		return this.mapWMC;
	}

	
	@Override
	public void visit(Method mtd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Attribute atb) {
		// TODO Auto-generated method stub
		
	}

}
