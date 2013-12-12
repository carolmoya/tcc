package edu.tcc.visitor;

import java.util.HashMap;
import java.util.Map;

import edu.tcc.model.EAttribute;
import edu.tcc.model.EClass;
import edu.tcc.model.EMethod;
import edu.tcc.model.EProject;

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
	public void visit(EProject pjt) {
		pjt.acceptOnAllClasses(this);
	}

	
	/**
	 * Visit the class
	 * @param EClass
	 */
	@Override
	public void visit(EClass cls) {
		mapWMC.put(cls.getName(), cls.getMethodCount());
	}
	
	
	/**
	 * Returns the mapWMC
	 * @return Map<String,Number>
	 */
	public Map<String,Number> getResults(){
		return this.mapWMC;
	}

	
	@Override
	public void visit(EMethod mtd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(EAttribute atb) {
		// TODO Auto-generated method stub
		
	}

}
