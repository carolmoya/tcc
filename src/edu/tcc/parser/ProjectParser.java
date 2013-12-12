package edu.tcc.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import edu.tcc.model.EClass;
import edu.tcc.model.EProject;

/**
 * @author hugo.hennies
 */

public class ProjectParser {
	
	/**
	 * 
	 * @param directory - name of the directory
	 * @return a project
	 * @throws FileNotFoundException
	 * @since 1.0
	 */
	public EProject parseProject(String directory) throws FileNotFoundException
	{
		FileParser fileParser = new FileParser();
		EProject project = new EProject();
		File root = new File(directory);
		List<File> fila = new ArrayList<File>();
		File f;
		File[] tempFiles;
		fila.add(root);
		while(!fila.isEmpty()) {
			f = fila.get(0);
			tempFiles =  f.listFiles();
			for (File file : tempFiles) {
				if(file.isDirectory()) fila.add(file);
				else if(!file.isHidden()){
					EClass parseClass = fileParser.parseFile(file);
					project.addClass(parseClass);
				}
			}
			fila.remove(0);
		}
		return project;
	}

}
