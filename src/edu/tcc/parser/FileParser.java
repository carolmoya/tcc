package edu.tcc.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.tcc.model.Class;

/**
 * @author hugo.hennies
 */

public class FileParser {
	
	/**
	 * 
	 * @param f - file that must be parsed
	 * @return classes - return the classes in file 
	 * @throws FileNotFoundException
	 * @since 1.0
	 */
	public List<Class> Parsefile(File f) throws FileNotFoundException
	{
		String s = stringfy(f);
		Pattern extendsPattern = Pattern.compile("[};]?[^}, ;]* [c]lass [^{]*\\{");//Arrumar expressao
		Matcher m = extendsPattern.matcher(s);
		ClassParser cp = new ClassParser();
		List<Class> classes = new LinkedList<Class>();
		while (m.find()) {
			classes.add(cp.parseClass(m.group()));
	        System.out.println(m.group());
	    }
		return classes;
	}
	
	/**
	 * Transform a File into a string
	 * @param f - file
	 * @return String
	 * @throws FileNotFoundException
	 * @since 1.0
	 */
	private String stringfy(File f) throws FileNotFoundException
	{
		Scanner sc = new Scanner(f);
		StringBuffer tempString = new StringBuffer();
		while(sc.hasNext())
		{
			tempString.append(sc.next()+ " ");
		}
		sc.close();
		return tempString.toString();
	}
	
	/**
	 * Find the end of a class
	 * @param initialBracePosition - the inicial brace position
	 * @param s - the string
	 * @return endBrace
	 * @since 1.0
	 */
	public int findClassEnd(int initialBracePosition, String s)
	{
		Pattern extendsPattern = Pattern.compile("[{|}]");
		Matcher m = extendsPattern.matcher(s);
		m.region(initialBracePosition,s.length());
		int counter = 0;
		int endBrace = 0;
		while (m.find()) 
		{
			if(m.group().equals("{")) counter++;
			else if (counter == 0) endBrace = m.start();
				else counter-- ;
	    }
		return endBrace;
	}

}
