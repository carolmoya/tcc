package edu.tcc.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import edu.tcc.model.EAttribute;
import edu.tcc.model.EClass;
import edu.tcc.model.EMethod;
import edu.tcc.model.EProject;

/**
 * @author hugo.hennies
 */

public class DIT implements Visitor {

	private Map<String,Number> meh;
	private Map<String, String> inheritanceTree;

	public DIT(){
		meh = new HashMap<String,Number>();
		inheritanceTree = new HashMap<String, String>();
	}

	@Override
	public void visit(EProject pjt) {
		pjt.acceptOnAllClasses(this);

		for (Entry<String,String> v : inheritanceTree.entrySet()) {
			if(v.getValue() == null) meh.put(v.getKey(), 0);
			else {
				String ancestorName = v.getValue();
				int counter = 0;
				while(ancestorName != null) {
					ancestorName = inheritanceTree.get(ancestorName);
					counter++;
				}
				meh.put(v.getKey(), counter);
			}
		}
	}


	@Override
	public void visit(EClass cls) {
		String ancestorName = null;
		if (cls.hasAncestor()) ancestorName = cls.getAncestorClassName();
		inheritanceTree.put(cls.getName(), ancestorName);
	}

	public Map<String,Number> getProle(){
		return meh;
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
