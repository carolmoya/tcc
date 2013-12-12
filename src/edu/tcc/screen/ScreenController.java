package edu.tcc.screen;

import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Map;

import edu.tcc.configuration.ClassConfiguration;
import edu.tcc.configuration.Configuration;
import edu.tcc.model.EProject;
import edu.tcc.parser.ProjectParser;
import edu.tcc.visitor.DIT;
import edu.tcc.visitor.LCOM;
import edu.tcc.visitor.NOC;
import edu.tcc.visitor.WMC;
import edu.tcc.xml.XMLProcessor;

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
			
			LCOM lcom = new LCOM();
			project.accept(lcom);
			Map<String, Number> mapLCOM = lcom.getResults();
			
			NOC noc = new NOC();
			project.accept(noc);
			Map<String, Number> mapNOC = noc.getResults();
			
			WMC wmc = new WMC();
			project.accept(wmc);
			Map<String, Number> mapWMC = wmc.getResults();
			
			XMLProcessor xmlProcessor = new XMLProcessor();
			Configuration configuration = xmlProcessor.processConfigurationFile(configurationFilePath.getPath());
			for (ClassConfiguration c : configuration.getClassesConfiguration()) {
				if(c.shouldCalculateDIT())
				{
					model.addMessage("DIT" + c.getClassPath() + ": " + mapDIT.get(c.getClassPath()));
				}
				if(c.shouldCalculateLCOM())
				{
					model.addMessage("LCOM" + c.getClassPath() + ": " + mapLCOM.get(c.getClassPath()));
				}
				if(c.shouldCalculateNOC())
				{
					model.addMessage("NOC" + c.getClassPath() + ": " + mapNOC.get(c.getClassPath()));
				}
				if(c.shouldCalculateWMC())
				{
					model.addMessage("WMC" + c.getClassPath() + ": " + mapWMC.get(c.getClassPath()));
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
