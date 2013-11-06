package edu.tcc.metric.test;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import edu.tcc.model.EClass;
import edu.tcc.model.EMethod;
import edu.tcc.model.EProject;
import edu.tcc.visitor.LCOM;
import edu.tcc.visitor.Visitor;


public class LCOMTest {
	
	@Test
	public void testLCOM(){
		
		EProject p = new EProject();
		
		EClass a = new EClass();
		a.setName("a1");
		
		EMethod m = new EMethod();
		m.addAtribute("1");
		m.addAtribute("2");
		a.addMethod(m);
		
		m = new EMethod();
		m.addAtribute("2");
		m.addAtribute("3");
		m.addAtribute("4");
		a.addMethod(m);
		
		m = new EMethod();
		m.addAtribute("5");
		m.addAtribute("4");
		a.addMethod(m);
		
		p.addClass(a);
		
		a = new EClass();
		a.setName("a2");
		
		m = new EMethod();
		m.addAtribute("1");
		m.addAtribute("2");
		a.addMethod(m);
		
		m = new EMethod();
		m.addAtribute("2");
		m.addAtribute("3");
		a.addMethod(m);
		
		m = new EMethod();
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
