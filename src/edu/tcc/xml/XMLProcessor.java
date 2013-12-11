package edu.tcc.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import edu.tcc.configuration.ClassConfiguration;
import edu.tcc.configuration.Configuration;
import edu.tcc.configuration.ExpectedResultConfiguration;
import edu.tcc.configuration.MethodConfiguration;
import edu.tcc.configuration.MetricConfiguration;
import edu.tcc.configuration.ParameterConfiguration;

/**
 * @author diego.pinho
 */

public class XMLProcessor {

	/** Tags **/
	private static final String CONFIGURATION = "configuration";
	private static final String CLASS = "class";
	private static final String METRIC = "metric";
	private static final String METRICS = "metrics";
	private static final String METHOD = "method";
	private static final String PARAMETER = "parameter";
	private static final String EXPECTED_RESULT = "expectedResult";
	private static final String CLASSES = "classes";
	private static final String TEST_METHODS = "testMethods";
	private static final String PARAMETERS = "parameters";
	
	/** Properties Tags **/
	private static final String NAME = "name";
	private static final String TYPE = "type";
	private static final String VALUE = "value";
	private static final String CLASSPATH = "classpath";

	/** XML reader **/
	private XMLEventReader eventReader;
	
	/** XML dataBuffer **/
	private XMLDataBuffer dataBuffer;

	/** Constructor **/
	public XMLProcessor(){
		this.setDataBuffer(new XMLDataBuffer());
	}
	
	/**
	 * @param configurationXMLFileLocale
	 * @return Configuration
	 */
	public Configuration processConfigurationFile(String configurationXMLFileLocale) {
		try {
			this.initializeEventReader(configurationXMLFileLocale);
			while (this.eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					this.processStartElement(event);
				} else if(event.isEndElement()){
					EndElement endElement = event.asEndElement();
					if(endElement.getName().getLocalPart().equals(CONFIGURATION)){
						return this.finalizeConfigurationTagProcess();
					} else
						this.processEndElement(endElement);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void processEndElement(EndElement endElement) {
		if(endElement.getName().getLocalPart().equals(CLASSES)){
			//nothing
		}
		else if(endElement.getName().getLocalPart().equals(CLASS)){
			this.finalizeClassTagProcess();
		}
		else if(endElement.getName().getLocalPart().equals(METRICS)){
			this.finalizeMetricsTagProcessing();
		}
		else if(endElement.getName().getLocalPart().equals(METRIC)){
			this.finalizeMetricTagProcess();
		}
		else if(endElement.getName().getLocalPart().equals(TEST_METHODS)){
			this.finalizeTestMethodsTagProcess();
		}
		else if(endElement.getName().getLocalPart().equals(METHOD)){
			this.finalizeMethodTagProcess();
		}
		else if(endElement.getName().getLocalPart().equals(PARAMETERS)){
			this.finalizeParametersTagProcess();
		}
		else if(endElement.getName().getLocalPart().equals(PARAMETER)){
			this.finalizeParameterTagProcess();
		}
		else if(endElement.getName().getLocalPart().equals(EXPECTED_RESULT)){
			this.finalizeExpectedResultTagProcess();
		}
	}

	private Configuration finalizeConfigurationTagProcess() {
		Configuration configurationObject = new Configuration();
		configurationObject.setClassesConfiguration(this.dataBuffer.getClassesConfiguration());
		return configurationObject;
	}

	private void finalizeExpectedResultTagProcess() {
		ExpectedResultConfiguration expectedResultConfiguration = this.dataBuffer.getCurrentExpectedResultConfiguration();
		this.dataBuffer.getCurrentMethodConfiguration().setExpectedResultConfiguration(expectedResultConfiguration);
	}

	private void finalizeParameterTagProcess() {
		ParameterConfiguration parameterConfiguration = this.dataBuffer.getCurrentParameterConfiguration();
		this.dataBuffer.getParametersConfiguration().add(parameterConfiguration);
	}

	private void finalizeParametersTagProcess() {
		List<ParameterConfiguration> parametersConfiguration = this.dataBuffer.getParametersConfiguration();
		this.dataBuffer.getCurrentMethodConfiguration().setParametersConfiguration(parametersConfiguration);
	}

	private void finalizeMethodTagProcess() {
		MethodConfiguration methodConfiguration = this.dataBuffer.getCurrentMethodConfiguration();
		this.dataBuffer.getMethodsConfiguration().add(methodConfiguration);
	}

	private void finalizeTestMethodsTagProcess() {
		List<MethodConfiguration> methodsConfiguration = this.dataBuffer.getMethodsConfiguration();
		this.dataBuffer.getCurrentClassConfiguration().setMethodsConfiguration(methodsConfiguration);
	}

	private void finalizeMetricTagProcess() {
		MetricConfiguration metricConfiguration = this.dataBuffer.getCurrentMetricConfiguration();
		this.dataBuffer.getMetricsConfiguration().add(metricConfiguration);
	}

	private void finalizeMetricsTagProcessing() {
		List<MetricConfiguration> metricsConfiguration = this.dataBuffer.getMetricsConfiguration();
		this.dataBuffer.getCurrentClassConfiguration().setMetricsConfiguration(metricsConfiguration);
	}

	private void finalizeClassTagProcess() {
		ClassConfiguration classConfiguration = this.dataBuffer.getCurrentClassConfiguration();
		this.dataBuffer.getClassesConfiguration().add(classConfiguration);
	}

	private void processStartElement(XMLEvent event) {
		StartElement startElement = event.asStartElement();
		if (startElement.getName().getLocalPart().equals(CONFIGURATION)){
			//nothing
		}
		else{
			if(startElement.getName().getLocalPart().equals(CLASSES)){
				//nothing
			}
			else if(startElement.getName().getLocalPart().equals(CLASS)){
				initClassTagProcess(startElement);
			}
			else if(startElement.getName().getLocalPart().equals(METRICS)){
				//nothing
			}
			else if(startElement.getName().getLocalPart().equals(METRIC)){
				initMetricTagProcess(startElement);
			}
			else if(startElement.getName().getLocalPart().equals(TEST_METHODS)){
				// nothing
			}
			else if(startElement.getName().getLocalPart().equals(METHOD)){
				initMethodTagProcess(startElement);
			}
			else if(startElement.getName().getLocalPart().equals(PARAMETERS)){
				//nothing
			}
			else if(startElement.getName().getLocalPart().equals(PARAMETER)){
				initParameterTagProcess(startElement);
			}
			else if(startElement.getName().getLocalPart().equals(EXPECTED_RESULT)){
				initExpectResultTagProcess(startElement);
			}
		}
	}

	private void initExpectResultTagProcess(StartElement startElement) {
		ExpectedResultConfiguration expectedResultConfiguration = new ExpectedResultConfiguration();
		Iterator<Attribute> expectedResultsTagAttributes = startElement.getAttributes();
		while (expectedResultsTagAttributes.hasNext()) {
			 Attribute attribute = expectedResultsTagAttributes.next();
			 if (attribute.getName().toString().equals(TYPE)) {
				 expectedResultConfiguration.setType(attribute.getValue());
			 }
			 else if (attribute.getName().toString().equals(VALUE)) {
				 expectedResultConfiguration.setValue(attribute.getValue());
			 }
		}
		this.dataBuffer.setCurrentExpectedResultConfiguration(expectedResultConfiguration);
	}

	private void initParameterTagProcess(StartElement startElement) {
		ParameterConfiguration parameterConfiguration = new ParameterConfiguration();
		Iterator<Attribute> parameterTagAttributes = startElement.getAttributes();
		while (parameterTagAttributes.hasNext()) {
			 Attribute attribute = parameterTagAttributes.next();
			 if (attribute.getName().toString().equals(TYPE)) {
				 parameterConfiguration.setType(attribute.getValue());
			 }
			 else if (attribute.getName().toString().equals(VALUE)) {
				 parameterConfiguration.setValue(attribute.getValue());
			 }
		}
		this.dataBuffer.setCurrentParameterConfiguration(parameterConfiguration);
	}

	private void initMethodTagProcess(StartElement startElement) {
		MethodConfiguration methodConfiguration = new MethodConfiguration();
		Iterator<Attribute> methodTagAttributes = startElement.getAttributes();
		while (methodTagAttributes.hasNext()) {
			 Attribute attribute = methodTagAttributes.next();
			 if (attribute.getName().toString().equals(NAME)) {
				 methodConfiguration.setName(attribute.getValue());
			 }
		}
		this.dataBuffer.setCurrentMethodConfiguration(methodConfiguration);
	}

	private void initMetricTagProcess(StartElement startElement) {
		MetricConfiguration metricConfiguration = new MetricConfiguration();
		Iterator<Attribute> metricTagAttributes = startElement.getAttributes();
		while (metricTagAttributes.hasNext()) {
			 Attribute attribute = metricTagAttributes.next();
			 if (attribute.getName().toString().equals(NAME)) {
				 metricConfiguration.setName(attribute.getValue());
			 }
		}
		this.dataBuffer.setCurrentMetricConfiguration(metricConfiguration);
	}

	private void initClassTagProcess(StartElement startElement) {
		ClassConfiguration classConfiguration = new ClassConfiguration();
		Iterator<Attribute> classTagAttributes = startElement.getAttributes();
		 while (classTagAttributes.hasNext()) {
			 Attribute attribute = classTagAttributes.next();
			 if (attribute.getName().toString().equals(CLASSPATH)) {
				 classConfiguration.setClassPath(attribute.getValue());
			 }
		 }
		 this.dataBuffer.setCurrentClassConfiguration(classConfiguration);
	}

	private void initializeEventReader(String configurationXMLFileLocale)
			throws FactoryConfigurationError, FileNotFoundException, XMLStreamException {

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream in = new FileInputStream(configurationXMLFileLocale);
		this.eventReader = inputFactory.createXMLEventReader(in);
	}

	
	/**
	 * @return dataBuffer
	 */
	public XMLDataBuffer getDataBuffer() {
		return dataBuffer;
	}

	/**
	 * @param dataBuffer
	 */
	public void setDataBuffer(XMLDataBuffer dataBuffer) {
		this.dataBuffer = dataBuffer;
	}

}