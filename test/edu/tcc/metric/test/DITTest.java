package edu.tcc.metric.test;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import edu.tcc.model.Class;
import edu.tcc.model.Project;
import edu.tcc.visitor.DIT;
import edu.tcc.visitor.Visitor;

/**
 * @author diego.pinho
 */

public class DITTest {
	
	@Test
	public void testDIT(){
		
		Project p = new Project();
		
		Class a = new Class();
		a.setName("a1");
		p.addClass(a);
		
		a = new Class();
		a.setName("b2");
		a.setAncestorClassName("a1");
		p.addClass(a);
		
		a = new Class();
		a.setName("c3");
		a.setAncestorClassName("b1");
		p.addClass(a);
		
		a = new Class();
		a.setName("b1");
		a.setAncestorClassName("a1");
		p.addClass(a);
		
		a = new Class();
		a.setName("c4");
		a.setAncestorClassName("b2");
		p.addClass(a);
		
		a = new Class();
		a.setName("c1");
		a.setAncestorClassName("b1");
		p.addClass(a);
		
		a = new Class();
		a.setName("c2");
		a.setAncestorClassName("b1");
		p.addClass(a);
		
		Visitor v = new DIT();
		p.accept(v);
		
		Map<String, Number> classes = ((DIT) v).getProle();
		
		//check the number of classes
		assertEquals(7,classes.size());
		
		//check the number of children by class
		assertEquals(0,classes.get("a1"));
		assertEquals(1,classes.get("b1"));
		assertEquals(1,classes.get("b2"));
		assertEquals(2,classes.get("c1"));
		assertEquals(2,classes.get("c2"));
		assertEquals(2,classes.get("c3"));
		assertEquals(2,classes.get("c4"));
		
	}

}
