package edu.tcc.parser;

import edu.tcc.model.Class;

/**
 * @author diego.pinho
 */

public class ClassParser extends AbstractParser{
	
	Class parseClass(String classText){
		return null;
	}

	
	
//	public void findName(){
//		String nomeDaClasse = "";
//		String paiDaClasse = "";
//		
//		
//		String t = "public class Project extends Iterable<String>";
//		String s = "";
//		String [] elements = t.split(" ");
//		
//		for (String element : elements) {
//			element.trim();
//			if(s.equals("class")){
//				nomeDaClasse = element;
//			}
//			else{
//				if(s.equals("extends")){
//					paiDaClasse = element;
//				}
//			}
//			s = element;
//			
//		}
//		
//		System.out.println("Nome da classe: " + nomeDaClasse);
//		System.out.println("Pai da classe: " + paiDaClasse);
//	}
	
	
//	Pattern p = Pattern.compile("");
//	
//	Class parseClass(String s)
//	{
//		Class c;
//		Pattern extendsPattern = Pattern.compile("");
//		Matcher m = extendsPattern.matcher(s);
//		return null;
//	}
	
	/*
	 * oq essa classe vai fazer:
	 * achar o nome da classe e armazenar no objeto classe;
	 * while ele encontrar metodos, jogar pro MethodParser, e guardar no objeto classe o objeto metodo retornado
	 * mesma coisa que o de cima so q com os atributs
	 */
	
	/*
	 * criar expressao para procurar metodo da seguinte maneira:
	 * -antes de {
	 * -depois de ; ou {
	 */
	
	/*
	 * criar expressao para procurar atributo da seguinte maneira:
	 * -antes de ;
	 * -depois de ; ou {
	 */

}