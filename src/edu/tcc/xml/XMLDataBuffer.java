package edu.tcc.xml;

import java.util.ArrayList;
import java.util.List;

import edu.tcc.configuration.ClassConfiguration;
import edu.tcc.configuration.ExpectedResultConfiguration;
import edu.tcc.configuration.MethodConfiguration;
import edu.tcc.configuration.MetricConfiguration;
import edu.tcc.configuration.ParameterConfiguration;

/**
 * @author diego.pinho
 */
public class XMLDataBuffer {

	/** Class Configuration **/
	private List<ClassConfiguration> classesConfiguration;
	private ClassConfiguration currentClassConfiguration;

	/** Metrics Configuration **/
	private List<MetricConfiguration> metricsConfiguration;
	private MetricConfiguration currentMetricConfiguration;

	/** Methods Configuration **/
	private List<MethodConfiguration> methodsConfiguration;
	private MethodConfiguration currentMethodConfiguration;

	/** Parameters Configuration **/
	private List<ParameterConfiguration> parametersConfiguration;
	private ParameterConfiguration currentParameterConfiguration;

	/** ExpectedResult Configuration **/
	private ExpectedResultConfiguration currentExpectedResultConfiguration;

	/** Constructor **/
	XMLDataBuffer() {
		this.classesConfiguration = new ArrayList<ClassConfiguration>();
		this.metricsConfiguration = new ArrayList<MetricConfiguration>();
		this.methodsConfiguration = new ArrayList<MethodConfiguration>();
		this.parametersConfiguration = new ArrayList<ParameterConfiguration>();
	}

	/**
	 * @return metricsConfiguration
	 */
	public List<MetricConfiguration> getMetricsConfiguration() {
		return metricsConfiguration;
	}

	/**
	 * @param metricsConfiguration
	 */
	public void setMetricsConfiguration(
			List<MetricConfiguration> metricsConfiguration) {
		this.metricsConfiguration = metricsConfiguration;
	}

	/**
	 * @return methodsConfiguration
	 */
	public List<MethodConfiguration> getMethodsConfiguration() {
		return methodsConfiguration;
	}

	/**
	 * @param methodsConfiguration
	 */
	public void setMethodsConfiguration(
			List<MethodConfiguration> methodsConfiguration) {
		this.methodsConfiguration = methodsConfiguration;
	}

	/**
	 * @return currentMethodConfiguration
	 */
	public MethodConfiguration getCurrentMethodConfiguration() {
		return currentMethodConfiguration;
	}

	/**
	 * @param currentMethodConfiguration
	 */
	public void setCurrentMethodConfiguration(
			MethodConfiguration currentMethodConfiguration) {
		this.currentMethodConfiguration = currentMethodConfiguration;
	}

	/**
	 * @return parametersConfiguration
	 */
	public List<ParameterConfiguration> getParametersConfiguration() {
		return parametersConfiguration;
	}

	/**
	 * @param parametersConfiguration
	 */
	public void setParametersConfiguration(
			List<ParameterConfiguration> parametersConfiguration) {
		this.parametersConfiguration = parametersConfiguration;
	}

	/**
	 * @return classesConfiguration
	 */
	public List<ClassConfiguration> getClassesConfiguration() {
		return classesConfiguration;
	}

	/**
	 * @param classesConfiguration
	 */
	public void setClassesConfiguration(
			List<ClassConfiguration> classesConfiguration) {
		this.classesConfiguration = classesConfiguration;
	}

	/**
	 * @return currentClassConfiguration
	 */
	public ClassConfiguration getCurrentClassConfiguration() {
		return currentClassConfiguration;
	}

	/**
	 * @param currentClassConfiguration
	 */
	public void setCurrentClassConfiguration(
			ClassConfiguration currentClassConfiguration) {
		this.currentClassConfiguration = currentClassConfiguration;
	}

	/**
	 * @return currentExpectedResultConfiguration
	 */
	public ExpectedResultConfiguration getCurrentExpectedResultConfiguration() {
		return currentExpectedResultConfiguration;
	}

	/**
	 * @param currentExpectedResultConfiguration
	 */
	public void setCurrentExpectedResultConfiguration(
			ExpectedResultConfiguration currentExpectedResultConfiguration) {
		this.currentExpectedResultConfiguration = currentExpectedResultConfiguration;
	}

	/**
	 * @return currentParameterConfiguration
	 */
	public ParameterConfiguration getCurrentParameterConfiguration() {
		return currentParameterConfiguration;
	}

	/**
	 * @param currentParameterConfiguration
	 */
	public void setCurrentParameterConfiguration(
			ParameterConfiguration currentParameterConfiguration) {
		this.currentParameterConfiguration = currentParameterConfiguration;
	}

	/**
	 * @return currentMetricConfiguration
	 */
	public MetricConfiguration getCurrentMetricConfiguration() {
		return currentMetricConfiguration;
	}

	/**
	 * @param currentMetricConfiguration
	 */
	public void setCurrentMetricConfiguration(
			MetricConfiguration currentMetricConfiguration) {
		this.currentMetricConfiguration = currentMetricConfiguration;
	}

}
