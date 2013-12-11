package edu.tcc.auditor;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import edu.tcc.Auditor;

public class AuditorTest {
	
	@Test
	public void testAuditor() throws SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
	{
		Auditor auditor = Auditor.auditorFromClass(TestClass.class);
		Integer[] integerParameters = { new Integer(2) };
		assertTrue(auditor.audit("dobro", integerParameters, new Integer(4)));
		
		assertFalse(auditor.audit("triplo", integerParameters, new Integer(4)));
		
		String[] stringParameters = { "echo" };
		assertTrue(auditor.audit("echo", stringParameters, "echo"));
		
		assertFalse(auditor.audit("triplo", stringParameters, new Integer(4)));
	}

}
