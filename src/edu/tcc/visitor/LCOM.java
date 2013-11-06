package edu.tcc.visitor;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.tcc.model.EAttribute;
import edu.tcc.model.EClass;
import edu.tcc.model.EMethod;
import edu.tcc.model.EProject;

/**
 * @author hugo.hennies
 */

public class LCOM implements Visitor {

	private List<Set<String>> sets;
	private Map<String, Number> meh;

	/**
	 * Class constructor
	 */
	public LCOM() {
		sets = new LinkedList<Set<String>>();
		meh = new HashMap<String, Number>();
	}

	@Override
	public void visit(EProject pjt) {
		pjt.acceptOnAllClasses(this);

	}

	@Override
	public void visit(EClass cls) { 
		cls.acceptOnAllMethods(this);

		int sCounter=0;
		for (Set<String> s : sets) {
			for (Set<String> s2 :sets){
				if(!s.isEmpty() && !s2.isEmpty() && Collections.disjoint(s, s2)) {
					sCounter++;
				}
			}
		}
		meh.put(cls.getName(), sCounter);
		sets.removeAll(sets);
	}

	
	/**
	 * Returns the map meh
	 * @return
	 */
	public Map<String, Number> getMeh() {
		return meh;
	}

	@Override
	public void visit(EMethod mtd) {
		sets.add(mtd.getAtributesBeingUsed());

	}

	@Override
	public void visit(EAttribute atb) {
		// TODO Auto-generated method stub

	}

}
