package edu.tcc.parser.test;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import edu.tcc.model.EClass;
import edu.tcc.parser.FileParser;

/**
 * @author diego.pinho
 */
public class FileParserTest {

	FileParser fileParser;
	
	@Before
	public void setUpTestScenario(){
		this.fileParser = new FileParser();
	}
	
	@Test
	public void testFileParser(){
		String root = "/teste";
		File file = new File(root,"edu/tcc/teste/AEAEAE.java");
		EClass parseFile = this.fileParser.parseFile(file);
		assertNotNull(parseFile);
	}
	
}
