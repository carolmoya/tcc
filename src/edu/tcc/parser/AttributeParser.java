package edu.tcc.parser;

import edu.tcc.model.Attribute;

/**
 * @author diego.pinho
 */

public class AttributeParser {
	
	/**
	 * Parse a line and build an Attribute object
	 * @param line with format "<accessLevel> <type> <name>"
	 * @return an Attribute object
	 * @since 1.0
	 */
	public Attribute parseAttribute(String line){
		Attribute t = new Attribute();
		String[] s = line.trim().split("\\s+");
		t.setAccessLevel(s[0]);
		t.setType(s[1]);
		t.setName(s[2]);
		return t;
	}
	
}
