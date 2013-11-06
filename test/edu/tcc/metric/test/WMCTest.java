package edu.tcc.metric.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import edu.tcc.model.EClass;
import edu.tcc.model.EMethod;
import edu.tcc.model.EProject;
import edu.tcc.visitor.Visitor;
import edu.tcc.visitor.WMC;

/**
 * @author diego.pinho
 */

public class WMCTest {

	@Test
	public void testWMC(){
		
		EProject p = new EProject();
		EClass c = new EClass();
		c.setName("a1");
		c.setAncestorClassName(null);
		
		int i;
		for(i=1;i<=10;i++){
			EMethod m = new EMethod();
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
