package edu.tcc.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import edu.tcc.model.Attribute;
import edu.tcc.model.Class;
import edu.tcc.model.Method;
import edu.tcc.model.Project;

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
	public void visit(Project pjt) {
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
	public void visit(Class cls) {
		String ancestorName = null;
		if (cls.hasAncestor()) ancestorName = cls.getAncestorClassName();
		inheritanceTree.put(cls.getName(), ancestorName);
	}

	public Map<String,Number> getProle(){
		return meh;
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
