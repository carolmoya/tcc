package edu.tcc.app;

import edu.tcc.model.EProject;
import edu.tcc.model.EClass;
import edu.tcc.model.EMethod;

/**
 * @author diego.pinho
 */

public class ProjectScenarioFabric {
	
	/**
	 * Creates a scenario to be used in demonstrations (metrics)
	 * @return Project
	 */
	public EProject createProject(){
		EProject p = new EProject();
		
		EClass a = new EClass();
		a.setName("ClassOne");
		EMethod m = new EMethod();
		m.addAtribute("attribute0");
		m.addAtribute("attribute1");
		a.addMethod(m);
		m = new EMethod();
		m.addAtribute("attribute0");
		m.addAtribute("attribute1");
		a.addMethod(m);
		p.addClass(a);
		
		a = new EClass();
		a.setName("ClassTwo");
		a.setAncestorClassName("ClassOne");
		m = new EMethod();
		a.addMethod(m);
		m = new EMethod();
		a.addMethod(m);
		m = new EMethod();
		a.addMethod(m);
		p.addClass(a);
		
		a = new EClass();
		a.setName("ClassThree");
		a.setAncestorClassName("ClassOne");
		p.addClass(a);
		
		a = new EClass();
		a.setName("ClassFour");
		a.setAncestorClassName("ClassTwo");
		m = new EMethod();
		m.addAtribute("attribute2");
		a.addMethod(m);
		m = new EMethod();
		a.addMethod(m);
		m = new EMethod();
		m.addAtribute("attribute2");
		m.addAtribute("attribute3");
		a.addMethod(m);
		p.addClass(a);
		
		a = new EClass();
		a.setName("ClassFive");
		m = new EMethod();
		a.addMethod(m);
		m = new EMethod();
		a.addMethod(m);
		m = new EMethod();
		a.addMethod(m);
		p.addClass(a);
		
		a = new EClass();
		a.setName("ClassSix");
		a.setAncestorClassName("ClassFive");
		p.addClass(a);
		
		return p;
	}
}
