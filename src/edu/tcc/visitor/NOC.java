package edu.tcc.visitor;

import java.util.HashMap;
import java.util.Map;

import edu.tcc.model.Attribute;
import edu.tcc.model.Class;
import edu.tcc.model.Method;
import edu.tcc.model.Project;

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
	 * @param Project
	 */
	@Override
	public void visit(Project pjt) {
		pjt.acceptOnAllClasses(this);
	}

	
	/**
	 * @param Class
	 * @since 1.0
	 */
	@Override
	public void visit(Class cls) {
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
	public Map<String,Number> getMapAncestorNumberOfChildren() {
		return mapAncestorNumberOfChildren;
	}
	
	
	@Override
	public void visit(Method mtd) {
		//empty method
	}

	@Override
	public void visit(Attribute atb) {
		//empty method
	}

}
