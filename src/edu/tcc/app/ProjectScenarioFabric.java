package edu.tcc.app;

import edu.tcc.model.Project;
import edu.tcc.model.Class;
import edu.tcc.model.Method;

/**
 * @author diego.pinho
 */

public class ProjectScenarioFabric {
	
	/**
	 * Creates a scenario to be used in demonstrations (metrics)
	 * @return Project
	 */
	public Project createProject(){
		Project p = new Project();
		
		Class a = new Class();
		a.setName("ClassOne");
		Method m = new Method();
		m.addAtribute("attribute0");
		m.addAtribute("attribute1");
		a.addMethod(m);
		m = new Method();
		m.addAtribute("attribute0");
		m.addAtribute("attribute1");
		a.addMethod(m);
		p.addClass(a);
		
		a = new Class();
		a.setName("ClassTwo");
		a.setAncestorClassName("ClassOne");
		m = new Method();
		a.addMethod(m);
		m = new Method();
		a.addMethod(m);
		m = new Method();
		a.addMethod(m);
		p.addClass(a);
		
		a = new Class();
		a.setName("ClassThree");
		a.setAncestorClassName("ClassOne");
		p.addClass(a);
		
		a = new Class();
		a.setName("ClassFour");
		a.setAncestorClassName("ClassTwo");
		m = new Method();
		m.addAtribute("attribute2");
		a.addMethod(m);
		m = new Method();
		a.addMethod(m);
		m = new Method();
		m.addAtribute("attribute2");
		m.addAtribute("attribute3");
		a.addMethod(m);
		p.addClass(a);
		
		a = new Class();
		a.setName("ClassFive");
		m = new Method();
		a.addMethod(m);
		m = new Method();
		a.addMethod(m);
		m = new Method();
		a.addMethod(m);
		p.addClass(a);
		
		a = new Class();
		a.setName("ClassSix");
		a.setAncestorClassName("ClassFive");
		p.addClass(a);
		
		return p;
	}
}
