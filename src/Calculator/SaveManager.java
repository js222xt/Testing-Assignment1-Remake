package Calculator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {

	private List<String> results;
	
	public SaveManager(List<String> results){
		this.results = results;
	}
	
	/**
	 * Läs sparad data från fil.
	 */
	public List<String> readFromDisk(String filename)
	{
		try 
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			results = (List<String>) in.readObject();
		    in.close();
		    return results;
		}
	    catch (Exception ex) 
	    {
			System.out.println("Error: " + ex.toString());
		}
		return results;
	}
	
	/**
	 * Spara listan med information till fil.
	 */
	public void saveToDisk(String filename, List<String> results)
	{
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
		    out.writeObject(results);
		    out.close();
		} 
		catch (Exception ex) 
		{
			System.out.println("Error: " + ex.toString());
		}
	}
	
}
