package edu.tcc.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import edu.tcc.ClassContainer;
import edu.tcc.compiler.ProjectCompiler;
import edu.tcc.model.EClass;
import edu.tcc.model.EProject;

/**
 * @author hugo.hennies
 */

public class ProjectParser {
	
	private ProjectCompiler compiler;
	private FileParser fileParser;
	private ClassContainer classContainer;
	
	/**
	 * Class Constructor
	 */
	public ProjectParser(){
		this.compiler = new ProjectCompiler();
		this.classContainer = new ClassContainer();
		this.fileParser = new FileParser(this.classContainer);
	}
	
	/**
	 * @param directory - name of the directory
	 * @return a project
	 * @throws FileNotFoundException
	 */
	public EProject parseProject(String directory) throws FileNotFoundException {
		List<File> filesDetected = this.identifyFilesFromDirectory(directory); // find
		this.sendFilesToBeCompile(filesDetected); // compile
		EProject project = this.sendFilesToFileParser(filesDetected); // parse
		
		return project;
	}

	private List<File> identifyFilesFromDirectory(String directory) {
		File root = new File(directory);
		List<File> fila = new ArrayList<File>();
		File f;
		File[] tempFiles;
		fila.add(root);
		
		List<File> filesDetected = new ArrayList<File>(); //array para guardar files para compilar
		
		while(!fila.isEmpty()) {
			f = fila.get(0);
			tempFiles =  f.listFiles();
			for (File file : tempFiles) {
				if(file.isDirectory()) fila.add(file);
				else if(!file.isHidden()){
					 if(isJavaExtensionFileType(file)){
						 filesDetected.add(file);
					 }
				}
			}
			fila.remove(0);
		}
		return filesDetected;
	}
	
	private void sendFilesToBeCompile(List<File> filesToBeCompile){
		this.compiler.compileFiles(filesToBeCompile);
	}
	
	private EProject sendFilesToFileParser(List<File> filesToBeParser){
		EProject project = new EProject();
		// parse file by file
		for (File file : filesToBeParser) {
			EClass eclass = this.fileParser.parseFile(file);
			project.addClass(eclass);
		}
		return project;
	}
	
	private boolean isJavaExtensionFileType(File file){
		String path = file.getPath();
		if(path.contains("java")) return true;
		else return false;
	}
	
	/**
	 * @return classes
	 */
	public List<Class<?>> getClasses() {
		return classContainer.getClasses();
	}
}
