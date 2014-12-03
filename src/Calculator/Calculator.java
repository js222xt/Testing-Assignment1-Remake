package Calculator;


public class Calculator 
{ 
	/**
	 * Adds two numbers - rj222dq
	 * @param num1 number 1
	 * @param num2 number 2
	 * @return result of adding the two numbers
	 * @throws Exception 
	 */
	public double add(double num1, double num2) throws Exception
	{
		if (!Double.isInfinite(num1 + num2))
		{ 
			return num1 + num2;
		}
		throw new Exception("Error.");
	}
	
	/**
	 * Divide to numbers - rj222dq
	 * @param numerator
	 * @param denominator
	 * @return result
	 */
	public double divide(double numerator, double denominator)
	{
		try
		{ 
			if (denominator == 0)
			{
				throw new RuntimeException("Denominator is zero!");
			}
			return numerator/denominator;
		}
		catch (Exception ex)
		{
			throw new RuntimeException("Error: " + ex.toString());
		}
	}
	
	
	//js222xt
	public double multiply(double a, double b){
		try{ 
			if(!Double.isInfinite(a * b)){
				return a * b;
			}
			else{
				throw new RuntimeException("Double is Infinite");
			}			
		}
		catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}		
	}

	//js222xt
	public double sub(double a, double b) {
		if(!Double.isInfinite(a - b)){
			return a - b;
		}
		else{
			throw new RuntimeException("Double is Infinite");
		}
	}
	
	//js222xt
	public double pyth(double a, double b) {
		double res = Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2) );
		if(!Double.isInfinite(res)){
			return res;
		}
		else{
			throw new RuntimeException("Double is Infinite");
		}
	}
}

