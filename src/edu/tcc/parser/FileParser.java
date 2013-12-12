package edu.tcc.parser;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import edu.tcc.ClassContainer;
import edu.tcc.model.EClass;

/**
 * @author diego.pinho
 */
public class FileParser {

	private ClassParser classParser;
	private ClassContainer classContainer;

	/**
	 * Class constructor
	 */
	public FileParser(ClassContainer classContainer) {
		this.classParser = new ClassParser();
		this.classContainer = classContainer;
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
		String root = this.getFileRoot(file);
		File rootFile = new File(root);
		try {
			Class<?> cls = this.getClassObjectAndSaveIt(file, rootFile);
			Class<? extends Object> klass = this.instanciateClass(cls);
			return klass;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	private Class<? extends Object> instanciateClass(Class<?> cls)
			throws InstantiationException, IllegalAccessException {
		Object instance = cls.newInstance();
		Class<? extends Object> klass = instance.getClass();
		return klass;
	}

	private Class<?> getClassObjectAndSaveIt(File file, File rootFile)
			throws MalformedURLException, ClassNotFoundException {
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { rootFile.toURI().toURL() });
		Class<?> cls = Class.forName(this.getCompleteClassName(file), true, classLoader);
		this.saveClassObject(cls); // save to be used on tests
		return cls;
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
		message = message.substring(indexOf + 3);
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
	
	/**
	 * @param cls
	 */
	private void saveClassObject(Class<?> cls){
		this.classContainer.saveClassObject(cls);
	}
	
}
