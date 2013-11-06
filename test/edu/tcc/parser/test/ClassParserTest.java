package edu.tcc.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import edu.tcc.model.EClass;
import edu.tcc.parser.ClassParser;
import edu.tcc.parser.FileParser;

/**
 * @author diego.pinho
 */
public class ClassParserTest {

	private FileParser fileParser;
	private ClassParser classParser;
	
	@Before
	public void setUpTestScenario(){
		this.classParser = new ClassParser();
		this.fileParser = new FileParser();
	}
	
	@Test
	public void testClassParser(){
		String root = "/teste";
		File file = new File(root,"edu/tcc/teste/AEAEAE.java");
		Class<? extends Object> classInstanceFromFile = this.fileParser.getClassInstanceFromFile(file);
		
		EClass parseClass = this.classParser.parseClass(classInstanceFromFile);
		assertNotNull(parseClass);
		assertEquals("edu.tcc.teste.AEAEAE",parseClass.getName());
//		assertNull(parseClass.getAncestorClassName()); //FIXME
		assertEquals(3,parseClass.getAttributes().size());
		assertEquals(13,parseClass.getMethods().size());
	}
	
}
