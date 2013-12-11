package edu.tcc.xml.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.tcc.configuration.ClassConfiguration;
import edu.tcc.configuration.Configuration;
import edu.tcc.configuration.MethodConfiguration;
import edu.tcc.configuration.MetricConfiguration;
import edu.tcc.configuration.ParameterConfiguration;
import edu.tcc.xml.XMLProcessor;

/**
 * @author diego.pinho
 */
public class XMLProcessorTest {

	private static final String XMLFILENAME = "configurationFile.xml";

	private XMLProcessor xmlReader;

	@Before
	public void setUp() {
		this.xmlReader = new XMLProcessor();
	}

	@Test
	public void testReadConfigurationFile() {
		
		Configuration configurationObject = this.xmlReader.processConfigurationFile(XMLFILENAME);
		assertNotNull(configurationObject);
		
		List<ClassConfiguration> classesConfiguration = configurationObject.getClassesConfiguration();
		assertNotNull(classesConfiguration);
		assertEquals(1,classesConfiguration.size());
		
		ClassConfiguration classConfiguration = classesConfiguration.iterator().next();
		assertEquals("br.edu.exemplo.Exemplo",classConfiguration.getClassPath());
		
		List<MetricConfiguration> metricsConfiguration = classConfiguration.getMetricsConfiguration();
		assertEquals(3, metricsConfiguration.size());
		assertEquals("DIT", metricsConfiguration.get(0).getName());
		assertEquals("CBO", metricsConfiguration.get(1).getName());
		assertEquals("WWC", metricsConfiguration.get(2).getName());
		
		List<MethodConfiguration> methodsConfiguration = classConfiguration.getMethodsConfiguration();
		assertEquals(1,methodsConfiguration.size());
	
		MethodConfiguration methodConfiguration = methodsConfiguration.iterator().next();
		assertEquals("executar(int a, int b)", methodConfiguration.getName());
		assertEquals("int",methodConfiguration.getExpectedResultConfiguration().getType());
		assertEquals("9",methodConfiguration.getExpectedResultConfiguration().getValue());
		
		List<ParameterConfiguration> parametersConfiguration = methodConfiguration.getParametersConfiguration();
		assertEquals(2,parametersConfiguration.size());
		
		for (ParameterConfiguration parameterConfiguration : parametersConfiguration) {
			assertEquals("int", parameterConfiguration.getType());
			assertEquals("3", parameterConfiguration.getValue());
		}
	}

}
