package edu.tcc.configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author diego.pinho
 */
public class MethodConfiguration {

	private String name;
	private List<ParameterConfiguration> parametersConfiguration;
	private ExpectedResultConfiguration expectedResultConfiguration;

	/** Constructor **/
	public MethodConfiguration() {
		this.setParametersConfiguration(new ArrayList<ParameterConfiguration>());
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return expectedResultConfiguration
	 */
	public ExpectedResultConfiguration getExpectedResultConfiguration() {
		return expectedResultConfiguration;
	}

	/**
	 * @param expectedResultConfiguration
	 */
	public void setExpectedResultConfiguration(
			ExpectedResultConfiguration expectedResultConfiguration) {
		this.expectedResultConfiguration = expectedResultConfiguration;
	}

}
