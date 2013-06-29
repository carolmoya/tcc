package edu.tcc.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.tcc.model.Attribute;
import edu.tcc.parser.AttributeParser;

/**
 * @author diego.pinho
 */

public class AttributeParserTest {
	
	private AttributeParser ap = new AttributeParser();
	private Attribute t = new Attribute();
	
	String test = "public String teste";
	String testTwo = "public    String    teste";
	String testThree = "  protected  int   number   ";
	
	@Test
	public void testParseAttributeWithPerfectFormat(){
		t = ap.parseAttribute(test);
		assertEquals("public",t.getAccessLevel());
		assertEquals("String",t.getType());
		assertEquals("teste",t.getName());
	}
	
	@Test
	public void testParseAttributeWithSpaceBetweenWords(){
		t = ap.parseAttribute(testTwo);
		assertEquals("public",t.getAccessLevel());
		assertEquals("String",t.getType());
		assertEquals("teste",t.getName());
	}
	
	@Test
	public void testParseAttributeWithSpaceBetweenWordsAndLateralSpaces(){
		t = ap.parseAttribute(testThree);
		assertEquals("protected",t.getAccessLevel());
		assertEquals("int",t.getType());
		assertEquals("number",t.getName());
	}
	
}
