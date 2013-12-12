package edu.tcc.screen;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.tcc.Auditor;
import edu.tcc.configuration.ClassConfiguration;
import edu.tcc.configuration.Configuration;
import edu.tcc.configuration.ExpectedResultConfiguration;
import edu.tcc.configuration.MethodConfiguration;
import edu.tcc.configuration.ParameterConfiguration;
import edu.tcc.model.EProject;
import edu.tcc.parser.ProjectParser;
import edu.tcc.visitor.DIT;
import edu.tcc.visitor.LCOM;
import edu.tcc.visitor.NOC;
import edu.tcc.visitor.WMC;
import edu.tcc.xml.XMLProcessor;

/**
 * @author hugo.hennies
 */
public class ScreenController {

	private URI projectURL;
	private URI configurationFilePath;
	private ScreenModel model;

	public ScreenController(ScreenModel model) {
		this.model = model;
	}

	public void setProjectDirectory(URI directory) {
		projectURL = directory;
	}

	public void setConfigurationFilePath(URI filePath) {
		configurationFilePath = filePath;
	}

	public void runTestsAndMetrics() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
		ProjectParser parser = new ProjectParser();
		try {
			EProject project = parser.parseProject(projectURL.getPath());
			
			//metricas
			
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
			
			List<Class<?>> classesFound = parser.getClasses();
			List<ClassConfiguration> classesConfiguration = configuration.getClassesConfiguration();
			boolean result = false;
			
			for (ClassConfiguration classConfiguration : classesConfiguration) {
				if (classConfiguration.shouldCalculateDIT()) {
					model.addMessage("DIT" + classConfiguration.getClassPath() + ": " + mapDIT.get(classConfiguration.getClassPath()));
				}
				if (classConfiguration.shouldCalculateLCOM()) {
					model.addMessage("LCOM" + classConfiguration.getClassPath() + ": " + mapLCOM.get(classConfiguration.getClassPath()));
				}
				if (classConfiguration.shouldCalculateNOC()) {
					model.addMessage("NOC" + classConfiguration.getClassPath() + ": " + mapNOC.get(classConfiguration.getClassPath()));
				}
				if (classConfiguration.shouldCalculateWMC()) {
					model.addMessage("WMC" + classConfiguration.getClassPath() + ": " + mapWMC.get(classConfiguration.getClassPath()));
				}
				
				Class<?> c = null;
				int i = 0;
				String classFoundPath = classesFound.get(i).getName();
				while (classesFound.size() > i && !classFoundPath.equals(classConfiguration.getClassPath())) {
					i++;
					classFoundPath = classesFound.get(i).getName();
				}
				c = classesFound.get(i);
				if (c == null) throw new RuntimeException();
				
				Auditor auditor = Auditor.auditorFromClass(c);
				List<MethodConfiguration> methodsConfiguration = classConfiguration.getMethodsConfiguration();		
				for (MethodConfiguration methodConfiguration : methodsConfiguration) {
					List<ParameterConfiguration> parametersConfiguration = methodConfiguration.getParametersConfiguration();
					Object[] parameters = configurationParametersToObject(parametersConfiguration);
					Object expectedValue = expectedValueToObject(methodConfiguration.getExpectedResultConfiguration());
					result = auditor.audit(methodConfiguration.getName(), parameters, expectedValue);
					if (result) {
						model.addMessage("Class: " + classesFound.get(i) + "Method: " + methodConfiguration.getName() + " SUCCESS");
					}
					else {
						model.addMessage("Class: " + classesFound.get(i) + "Method: " + methodConfiguration.getName() + " FAIL");
					}
				}
				
			}
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
		private Object[] configurationParametersToObject(List<ParameterConfiguration> parameters)
		{
			List<Object> objects = new LinkedList<Object>();
			for (ParameterConfiguration parameter : parameters) 
			{
				if(parameter.getType().equals("int"))
				{
					objects.add(new Integer(parameter.getValue()));
				}
				else if(parameter.getType().equals("double"))
				{
					objects.add(new Double(parameter.getValue()));
				}
				else if(parameter.getType().equals("float"))
				{
					objects.add(new Float(parameter.getValue()));
				}
				else if(parameter.getType().equals("String"))
				{
					objects.add(parameter.getValue());
				}
				else if(parameter.getType().equals("boolean"))
				{
					objects.add(new Boolean(parameter.getValue()));
				}
				
			}
			return objects.toArray();
		}
		
		private Object expectedValueToObject(ExpectedResultConfiguration expectedResultConfiguration) {
			if(expectedResultConfiguration.getType().equals("int"))
			{
				return new Integer(expectedResultConfiguration.getValue());
			}
			else if(expectedResultConfiguration.getType().equals("double"))
			{
				return new Double(expectedResultConfiguration.getValue());
			}
			else if(expectedResultConfiguration.getType().equals("float"))
			{
				return new Float(expectedResultConfiguration.getValue());
			}
			else if(expectedResultConfiguration.getType().equals("String"))
			{
				return expectedResultConfiguration.getValue();
			}
			else if(expectedResultConfiguration.getType().equals("boolean"))
			{
				return new Boolean(expectedResultConfiguration.getValue());
			}
			return null;
		}

}
