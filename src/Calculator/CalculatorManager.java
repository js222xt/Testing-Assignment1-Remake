package Calculator;

import java.util.List;
import java.util.Scanner;

import Calculator.Calculator;
import Calculator.SaveManager;

public class CalculatorManager {

	private Calculator calc;
	private double num1, num2;
	private List<String> results;
	private SaveManager sm;
	private String filename;
	private Scanner scanner;
	
	/**
	 * Konstruktor
	 */
	public CalculatorManager(SaveManager sm, String filename, Scanner scanner, Calculator calc)
	{
		this.scanner = scanner;
		this.sm = sm;
		this.filename = filename;
		this.calc = calc;
		num1 = 0;
		num2 = 0;
		results = this.sm.readFromDisk(this.filename);
	}

	public void start()
	{
		int choosen = 0;
		printInfo();
		boolean correct = false;
		while(!correct){
			String str = this.scanner.nextLine();
			if (str.toLowerCase().matches("p"))
			{
				System.out.println("\nPrevious results:");
				for (String string : results) 
				{
					System.out.println(string);
				}
				printInfo();
			}
			else if (str.toLowerCase().matches("q"))
			{
				correct = true;
				return;
			}
			else 
			{
				try{
					choosen = Integer.parseInt(str);
					// Bestämmer och aktiverar valet
					if(choosen == 1 || choosen == 2 || choosen == 3 || choosen == 4 || choosen == 5)
					{
						correct = true;
						System.out.println("Enter first number");
						num1 = getDouble();
						System.out.println("Enter second number");
						num2 = getDouble();
						choice(choosen);
					}
					else
					{
						System.out.println("Wrong number.");
					}
				}
				catch(Exception e){
					System.out.println("Wrong number.");
				}	
			}
		}		
	}
	
	/**
	 * Skriver ut informationen till användaren
	 */
	private void printInfo()
	{
		System.out.println("Calculator");
		System.out.println("1. Divide");
		System.out.println("2. Add");
		System.out.println("3. Substract");
		System.out.println("4. Multiply");
		System.out.println("5. Pythagoras quest");
		System.out.println("To quit press: Q");
		System.out.println("Previous results press: P");
	}
	
	private double getDouble() {
		double p1 = 0;
		boolean isDouble = false;
		while(!isDouble){
			try{
				p1 = Double.valueOf(this.scanner.nextLine());
				isDouble = true;
			}
			catch(Exception e){
				p1 = 0;
				System.out.println("Not double, try again\n:");
				System.out.println("Error: " + e.toString());
			}
		}
		return p1;
	}
	
	private void choice(Integer choice)
	{
		switch (choice) {
		case 1:
			calculate("divide", calc);
			break;
		case 2:
			calculate("add", calc);
			break;
		case 3:
			calculate("sub", calc);
			break;
		case 4:			
			calculate("multiply", calc);
			break;
		case 5:	
			calculate("pyth", calc);
			break;
		default:
			System.out.println("Choice Invalid");
		}
	}
	
	public double calculate(String method, Calculator calc)
	{
		double result = 0;
		try
		{ 
			if (method.equals("divide"))
			{
				result = calc.divide(num1, num2);
				saveResult("Divide: " + num1 + "/" + num2 +" = " + result);
			}
			else if (method.equals("multiply"))
			{
				result = calc.multiply(num1, num2);
				saveResult("Multiply: " + num1 + "*" + num2 +" = " + result);
			}
			else if (method.equals("add"))
			{
				result = calc.add(num1, num2);
				saveResult("Add: " + num1 + "+" + num2 +" = " + result);
			}
			else if (method.equals("sub"))
			{
				result = calc.sub(num1, num2);
				saveResult("Substraction: " + num1 + "-" + num2 +" = " + result);
			}
			else if (method.equals("pyth"))
			{
				result = calc.pyth(num1, num2);
				saveResult("Pythagoras: " + num1 + " " + num2 +" = " + result);
			}
			else
			{
				throw new RuntimeException("Error. No such method for calculate.");
			}
		}
		catch (Exception ex) 
		{
			System.out.println("Error: " + ex.toString());
		}
		return result;
	}
	
	private void saveResult(String saveStr)
	{
		// Skriver ut till användaren
		System.out.println(saveStr);
		// Lägger till strängen till listan
		results.add(saveStr);
		// Sparar strängen till fil
		this.sm.saveToDisk(this.filename, results);
	}
}
