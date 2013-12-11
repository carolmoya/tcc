package edu.tcc.configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author diego.pinho
 */
public class ClassConfiguration {

	private String classPath;
	private List<MetricConfiguration> metricsConfiguration;
	private List<MethodConfiguration> methodsConfiguration;

	/** Constructor **/
	public ClassConfiguration() {
		this.setMetricsConfiguration(new ArrayList<MetricConfiguration>());
		this.setMethodsConfiguration(new ArrayList<MethodConfiguration>());
	}

	/**
	 * @return classPath
	 */
	public String getClassPath() {
		return classPath;
	}

	/**
	 * @param classPath
	 */
	public void setClassPath(String classPath) {
		this.classPath = classPath;
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

}
