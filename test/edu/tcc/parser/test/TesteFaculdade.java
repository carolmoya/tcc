package edu.tcc.parser.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.junit.Before;
import org.junit.Test;

/**
 * @author diego.pinho
 */

public class TesteFaculdade {

	private File file;
	private File rootFile;
	private String root = "/teste";
	private String source = "edu/tcc/teste/AEAEAE.java";
	private JavaCompiler compiler;
	
	@Before
	public void setUpTestScenario(){
		System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_02");
		this.rootFile = new File("/teste");
		this.file = new File(this.root,"edu/tcc/teste/AEAEAE.java");
	}
	
	@Test
	public void testFileParser() throws FileNotFoundException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		this.compiler = ToolProvider.getSystemJavaCompiler();
		this.compiler.run(null, null, null, this.file.getPath());
		
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { this.rootFile.toURI().toURL() });
		
		System.out.println("HERE:" + rootFile.toURI().toURL());
		
		Class<?> cls = Class.forName("edu.tcc.teste.AEAEAE", true, classLoader); // Should print "hello".
		Object instance = cls.newInstance(); // Should print "world".
		
		Class<? extends Object> klass = instance.getClass();
		
		System.out.println("Method Analytics");
		Method[] methods = klass.getMethods();
		for (Method method : methods) {
			System.out.println("Method name: " + method.getName());
			System.out.println("Return type: " + method.getReturnType());
			System.out.println("\n");
		}
		
		System.out.println("Fields Analytics");
		Field fieldlist[] = klass.getDeclaredFields();
		for (Field field : fieldlist) {
			System.out.println("Attribute Name: " + field.getName());
			System.out.println("Member of: " + field.getDeclaringClass());
			System.out.println("Type: " + field.getType());
			
			int modifiers = field.getModifiers();
			System.out.println("Modifiers:" + Modifier.toString(modifiers) );
			System.out.println("\n");
		}
		
		
		// ProjectParser projectParser = new ProjectParser();
		// Project parseProject = projectParser.parseProject("test-resources");
		// Class cls = parseProject.getClasses().iterator().next();
		// assertNull(cls);

		// fileParser.Parsefile(f)
	}
	
	
}
