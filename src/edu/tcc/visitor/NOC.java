package edu.tcc.visitor;

import java.util.HashMap;
import java.util.Map;

import edu.tcc.model.EAttribute;
import edu.tcc.model.EClass;
import edu.tcc.model.EMethod;
import edu.tcc.model.EProject;

/**
 * @author hugo.hennies
 */

public class NOC implements Visitor{

	private Map<String, Number> mapAncestorNumberOfChildren;

	/**
	 * Class constructor
	 */
	public NOC() {
		mapAncestorNumberOfChildren = new HashMap<String, Number>();
	}

	
	/**
	 * Accept a visitor
	 * @param EProject
	 */
	@Override
	public void visit(EProject pjt) {
		pjt.acceptOnAllClasses(this);
	}

	
	/**
	 * @param EClass
	 * @since 1.0
	 */
	@Override
	public void visit(EClass cls) {
		if(!mapAncestorNumberOfChildren.containsKey(cls.getName())){
			mapAncestorNumberOfChildren.put(cls.getName(), 0);
		}
		if(cls.hasAncestor()) {
			String ancestorName = cls.getAncestorClassName();
			if(mapAncestorNumberOfChildren.containsKey(ancestorName)) {
				Number filhos = mapAncestorNumberOfChildren.get(ancestorName);
				filhos = filhos.intValue() +1;
				mapAncestorNumberOfChildren.put(ancestorName, filhos);
			}
			else{
				mapAncestorNumberOfChildren.put(ancestorName, 1);
			}
		}
	}


	/**
	 * Returns the mapAncestorNumberOfChildren
	 * @return Map<String,Number>
	 */
	public Map<String,Number> getResults() {
		return mapAncestorNumberOfChildren;
	}
	
	
	@Override
	public void visit(EMethod mtd) {
		//empty method
	}

	@Override
	public void visit(EAttribute atb) {
		//empty method
	}

}
