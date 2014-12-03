package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Calculator.CalculatorManager;
import Calculator.SaveManager;

public class MainCalculator {

	public static void main(String[] args) 
	{
		List<String> results = new ArrayList<String>();
		SaveManager sm = new SaveManager(results);
		CalculatorManager calc = new CalculatorManager(sm, "results.benja",	new Scanner(System.in), new Calculator());
		calc.start();
	}

}
