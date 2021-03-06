package edu.tcc.configuration;

/**
 * @author diego.pinho
 */
public class ParameterConfiguration {

	private String type;
	private String value;
	
	/** Constructor **/
	public ParameterConfiguration(){
		//nothing
	}
	
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
