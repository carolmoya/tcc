package edu.tcc.metric.test;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import edu.tcc.model.Class;
import edu.tcc.model.Method;
import edu.tcc.model.Project;
import edu.tcc.visitor.LCOM;
import edu.tcc.visitor.Visitor;


public class LCOMTest {
	
	@Test
	public void testLCOM(){
		
		Project p = new Project();
		
		Class a = new Class();
		a.setName("a1");
		
		Method m = new Method();
		m.addAtribute("1");
		m.addAtribute("2");
		a.addMethod(m);
		
		m = new Method();
		m.addAtribute("2");
		m.addAtribute("3");
		m.addAtribute("4");
		a.addMethod(m);
		
		m = new Method();
		m.addAtribute("5");
		m.addAtribute("4");
		a.addMethod(m);
		
		p.addClass(a);
		
		a = new Class();
		a.setName("a2");
		
		m = new Method();
		m.addAtribute("1");
		m.addAtribute("2");
		a.addMethod(m);
		
		m = new Method();
		m.addAtribute("2");
		m.addAtribute("3");
		a.addMethod(m);
		
		m = new Method();
		m.addAtribute("5");
		m.addAtribute("4");
		a.addMethod(m);
		
		p.addClass(a);
		
		
		Visitor v = new LCOM();
		p.accept(v);
		
		Map<String, Number> classes = ((LCOM) v).getMeh();
		
		//check the number of classes
		assertEquals(2,classes.size());
		
		assertEquals(2,classes.get("a1"));
		assertEquals(4,classes.get("a2"));
		
	}

}
