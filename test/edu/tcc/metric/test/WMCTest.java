package edu.tcc.metric.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import edu.tcc.model.Class;
import edu.tcc.model.Method;
import edu.tcc.model.Project;
import edu.tcc.visitor.Visitor;
import edu.tcc.visitor.WMC;

/**
 * @author diego.pinho
 */

public class WMCTest {

	@Test
	public void testWMC(){
		
		Project p = new Project();
		Class c = new Class();
		c.setName("a1");
		c.setAncestorClassName(null);
		
		int i;
		for(i=1;i<=10;i++){
			Method m = new Method();
			c.addMethod(m);
		}
		
		p.addClass(c);
		
		Visitor v = new WMC();
		p.accept(v);
		
		Map<String, Number> meh = ((WMC) v).getmapWMC();
		Number number = meh.get("a1");
		assertEquals(10,number);
	}

}
