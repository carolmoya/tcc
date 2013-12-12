package edu.tcc.parser;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import edu.tcc.model.EClass;

/**
 * @author diego.pinho
 */
public class FileParser {

	private JavaCompiler compiler;
	private ClassParser classParser;

	/**
	 * Class constructor
	 */
	public FileParser() {
		System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_02");
		this.classParser = new ClassParser();
	}

	/**
	 * @param file
	 */
	public EClass parseFile(File file) {
		Class<? extends Object> klass = getClassInstanceFromFile(file);
		EClass Eklass = this.getEClassFromClass(klass);
		return Eklass;
	}
	
	/**
	 * @param file
	 * @return Class<? extends Object>
	 */
	public Class<? extends Object> getClassInstanceFromFile(File file){
		this.compiler = ToolProvider.getSystemJavaCompiler();
		this.compiler.run(null, null, null, file.getPath());
		
		String root = this.getFileRoot(file);
		File rootFile = new File(root);
		
		try {
			URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { rootFile.toURI().toURL() });
			Class<?> cls = Class.forName(this.getCompleteClassName(file), true, classLoader);
			Object instance = cls.newInstance();
			Class<? extends Object> klass = instance.getClass();
			return klass;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * @param klass
	 * @return EClass
	 */
	public EClass getEClassFromClass(Class<? extends Object> klass){
		EClass Eklass = this.classParser.parseClass(klass); 
		return Eklass;
	}

	/**
	 * @param file
	 * @return finalAbsolutePath
	 */
	private String getCompleteClassName(File file) {
		String message = file.getAbsolutePath();
		int indexOf = message.indexOf("src");
		message = message.substring(indexOf+3);
		String[] split = message.split("\\\\");
		String classpath = "";
		for (String string : split) {
			classpath = classpath + string + ".";
		}
		int indexOfJavaWord = classpath.indexOf("java");
		classpath = classpath.substring(1, indexOfJavaWord - 1);
		
		return classpath;
	}

	/**
	 * @param file
	 * @return fileRoot
	 */
	private String getFileRoot(File file) {
		String filePath = file.getPath();
		int indexOfSrcWorld = filePath.indexOf("src");
		return filePath.substring(0,indexOfSrcWorld+4);
	}
}
