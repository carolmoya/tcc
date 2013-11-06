package edu.tcc.parser.test;

/**
 * @author diego.pinho
 */
public class FakeClass {

	private String fieldOne;
	private Integer fieldTwo;
	private Boolean fieldThree;
	private Float fieldFour;
	private Double fieldFive;
	
	public void doSomething(){
		// nothing
	}
	
	public String doSomethingTwo(){
		return null;
	}
	
	public String doSomethingThree(String a, String b){
		return a+b;
	}
	
	public String getFieldOne() {
		return fieldOne;
	}
	public void setFieldOne(String fieldOne) {
		this.fieldOne = fieldOne;
	}
	public Integer getFieldTwo() {
		return fieldTwo;
	}
	public void setFieldTwo(Integer fieldTwo) {
		this.fieldTwo = fieldTwo;
	}
	public Boolean getFieldThree() {
		return fieldThree;
	}
	public void setFieldThree(Boolean fieldThree) {
		this.fieldThree = fieldThree;
	}
	public Float getFieldFour() {
		return fieldFour;
	}
	public void setFieldFour(Float fieldFour) {
		this.fieldFour = fieldFour;
	}
	public Double getFieldFive() {
		return fieldFive;
	}
	public void setFieldFive(Double fieldFive) {
		this.fieldFive = fieldFive;
	}
	
}
