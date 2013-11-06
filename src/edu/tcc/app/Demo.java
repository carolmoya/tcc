package edu.tcc.app;

import java.util.Map;

import edu.tcc.model.EProject;
import edu.tcc.visitor.DIT;
import edu.tcc.visitor.LCOM;
import edu.tcc.visitor.NOC;
import edu.tcc.visitor.Visitor;
import edu.tcc.visitor.WMC;

/**
 * @author diego.martins
 */

public class Demo {
	
	private ProjectScenarioFabric psf;
	private EProject p;
	
	/**
	 * Class constructor
	 */
	Demo(){
		psf = new ProjectScenarioFabric();
		p = new EProject();
		p = psf.createProject();
	}
	
	/**
	 * Performs a simple demonstration of the functionality of the application (metrics)
	 */
	public void executeDemo(){
		Visitor vDit = new DIT();
		p.accept(vDit);
		Map<String, Number> mapDIT = ((DIT)vDit).getProle();
		System.out.println("\nDIT - Depth of Inheritance Tree");
		System.out.println("clsOne: " + mapDIT.get("ClassOne"));
		System.out.println("clsTwo: " + mapDIT.get("ClassTwo"));
		System.out.println("clsThree: " + mapDIT.get("ClassThree"));
		System.out.println("clsFour: " + mapDIT.get("ClassFour"));
		System.out.println("clsFive: " + mapDIT.get("ClassFive"));
		System.out.println("clsSix: " + mapDIT.get("ClassSix"));

		
		Visitor vLcom = new LCOM();
		p.accept(vLcom);
		Map<String, Number> mapLCOM = ((LCOM)vLcom).getMeh();
		System.out.println("\nLCOM - Lack of cohesion in methods");
		System.out.println("clsOne: " + mapLCOM.get("ClassOne"));
		System.out.println("clsTwo: " + mapLCOM.get("ClassTwo"));
		System.out.println("clsThree: " + mapLCOM.get("ClassThree"));
		System.out.println("clsFour: " + mapLCOM.get("ClassFour"));
		System.out.println("clsFive: " + mapLCOM.get("ClassFive"));
		System.out.println("clsSix: " + mapLCOM.get("ClassSix"));
		
		Visitor vNoc = new NOC();
		p.accept(vNoc);
		Map<String, Number> mapANC = ((NOC)vNoc).getMapAncestorNumberOfChildren();
		System.out.println("\nNOC - Number of Children");
		System.out.println("clsOne: " + mapANC.get("ClassOne"));
		System.out.println("clsTwo: " + mapANC.get("ClassTwo"));
		System.out.println("clsThree: " + mapANC.get("ClassThree"));
		System.out.println("clsFour: " + mapANC.get("ClassFour"));
		System.out.println("clsFive: " + mapANC.get("ClassFive"));
		System.out.println("clsSix: " + mapANC.get("ClassSix"));
		
		Visitor vWMC = new WMC();
		p.accept(vWMC);
		Map<String, Number> mapWMC = ((WMC)vWMC).getmapWMC();
		System.out.println("\nWMC - Weighted methods per class");
		System.out.println("clsOne: " + mapWMC.get("ClassOne"));
		System.out.println("clsTwo: " + mapWMC.get("ClassTwo"));
		System.out.println("clsThree: " + mapWMC.get("ClassThree"));
		System.out.println("clsFour: " + mapWMC.get("ClassFour"));
		System.out.println("clsFive: " + mapWMC.get("ClassFive"));
		System.out.println("clsSix: " + mapWMC.get("ClassSix"));
	}
}
