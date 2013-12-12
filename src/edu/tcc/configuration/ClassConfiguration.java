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
	
	public boolean shouldCalculateDIT()
	{
		boolean shouldCalculateDIT = false;
		for (MetricConfiguration metric : metricsConfiguration) {
			shouldCalculateDIT = shouldCalculateDIT || metric.getName().equals("DIT");
		}
		return shouldCalculateDIT;
	}
	
	public boolean shouldCalculateLCOM()
	{
		boolean shouldCalculateLCOM = false;
		for (MetricConfiguration metric : metricsConfiguration) {
			shouldCalculateLCOM = shouldCalculateLCOM || metric.getName().equals("LCOM");
		}
		return shouldCalculateLCOM;
	}
	
	public boolean shouldCalculateNOC()
	{
		boolean shouldCalculateNOC = false;
		for (MetricConfiguration metric : metricsConfiguration) {
			shouldCalculateNOC = shouldCalculateNOC || metric.getName().equals("NOC");
		}
		return shouldCalculateNOC;
	}
	
	public boolean shouldCalculateWMC()
	{
		boolean shouldCalculateWMC = false;
		for (MetricConfiguration metric : metricsConfiguration) {
			shouldCalculateWMC = shouldCalculateWMC || metric.getName().equals("WMC");
		}
		return shouldCalculateWMC;
	}

}
