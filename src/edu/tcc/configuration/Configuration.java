package edu.tcc.configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author diego.pinho
 */
public class Configuration {

	private List<ClassConfiguration> classesConfiguration;

	/**
	 * Constructor
	 */
	public Configuration() {
		this.setClassesConfiguration(new ArrayList<ClassConfiguration>());
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

}
