package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import Calculator.*;

public class tests {

	// Reflection
	private Method m;
    private Class[] parameterTypes;
    private Object[] parameters;
	private ByteArrayOutputStream outContent;
    
	@Before
	public void initiate() throws Exception
	{
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void shouldTestChoiceAndSpy() throws Exception{
		List<String> results = new ArrayList<String>();
		results.add("Add: 3.0+4.0 = 7.0");
		SaveManager sm = new SaveManager(results);
		SaveManager spy = spy(sm);
		
		//SaveManager smMock = mock(SaveManager.class);
		Calculator cMock = mock(Calculator.class);
		CalculatorManager cm = new CalculatorManager(sm,"mock.mock", new Scanner(System.in), cMock);
		
		doReturn(results).when(spy).readFromDisk("mock.mock");
		
		// reflection
		parameterTypes = new Class[1];
        parameterTypes[0] = java.lang.Integer.class;
        m = cm.getClass().getDeclaredMethod("choice", parameterTypes);
        m.setAccessible(true);        
        parameters = new Object[1];
        
        parameters[0] = 1;
		m.invoke(cm, parameters);
		verify(cMock).divide(0,0);
		
		parameters[0] = 2;
		m.invoke(cm, parameters);
		verify(cMock).add(0,0);
		
		parameters[0] = 3;
		m.invoke(cm, parameters);
		verify(cMock).sub(0,0);
		
		parameters[0] = 4;
		m.invoke(cm, parameters);
		verify(cMock).multiply(0,0);
		
		parameters[0] = 5;
		m.invoke(cm, parameters);
		verify(cMock).pyth(0,0);
		
		parameters[0] = 6;
		m.invoke(cm, parameters);
		assertTrue(outContent.toString().contains("Invalid"));
	}

}
