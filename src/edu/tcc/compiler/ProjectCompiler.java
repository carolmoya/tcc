package edu.tcc.compiler;

import java.io.File;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * @author diego.pinho
 */
public class ProjectCompiler {

	private static final String JAVA_HOME = "java.home";
	private static final String JAVA_HOME_DEFAULT = "C:\\Program Files\\Java\\jdk1.7.0_02";
	
	private JavaCompiler compiler;
	
	public ProjectCompiler(){
		System.setProperty(JAVA_HOME, JAVA_HOME_DEFAULT);
		this.compiler = ToolProvider.getSystemJavaCompiler();
	}
	
	/**
	 * @param filesToBeCompile
	 */
	public void compileFiles(List<File> filesToBeCompile){
		  StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		  String[] filesURI = this.getFilesURI(filesToBeCompile);
		Iterable compilationUnits = fileManager.getJavaFileObjects(filesURI);
		  CompilationTask task = compiler.getTask(null, fileManager, null, null, null, compilationUnits);
		  task.call();
	}
	
	
	private String[] getFilesURI(List<File> filesToBeCompile){
		String[] filesURI = new String[filesToBeCompile.size()]; 
		int i = -1;
		for (File file : filesToBeCompile) {
			filesURI[i+1] = file.getPath();
			i++;
		}
		this.showFilesURIOnConsole(filesURI); // log //FIXME
		return filesURI;
	}

	private void showFilesURIOnConsole(String[] filesURI) {
		System.out.println("========== FILES TO BE COMPILE ==========");
		int max = filesURI.length;
		for(int j=0;j<max;j++){
			System.out.println("["+j+"]" + ":" + filesURI[j]);
		}
		System.out.println("=====================================");
	}
	
//	//FIXME test
//	private String[] getFilesURIFAKE(List<File> filesToBeCompile){
//		String[] filesURI = { "C:\\teste\\Class1.java","C:\\teste\\Class2.java"};
//		return filesURI;
//	}
	
}
