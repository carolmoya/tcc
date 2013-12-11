package edu.tcc.screen;

import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;

import edu.tcc.model.EProject;
import edu.tcc.parser.ProjectParser;
import edu.tcc.visitor.DIT;

public class ScreenController {
	
	private URI projectURL;
	private URI configurationFilePath;
	private ScreenModel model;
	
	public ScreenController(ScreenModel model)
	{
		this.model = model;
	}
	
	public void setProjectDirectory(URI directory)
	{
		projectURL = directory;
	}
	
	public void setConfigurationFilePath(URI filePath)
	{
		configurationFilePath = filePath;
	}
	
	public void runTestsAndMetrics()
	{
		ProjectParser parser = new ProjectParser();
		try {
			EProject project = parser.parseProject(projectURL.getPath());
			DIT dit = new DIT();
			project.accept(dit);
			Map<String, Number> mapDIT = dit.getResults();
			for (Entry<String, Number> entry  : mapDIT.entrySet()) 
			{
				model.addMessage(entry.getKey());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//XMLProcessor xmlProcessor = new XMLProcessor();
		//Configuration configuration = xmlProcessor.processConfigurationFile(configurationFilePath.getPath());
		//model.addMessage(configuration.getClassesConfiguration().get(0).getClassPath());
	}

}
