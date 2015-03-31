package phonebook;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Book
{
	private HashMap<Integer, Map.Entry<String, String>> list = 
			new HashMap<Integer, Map.Entry<String, String>>();
	
	private Integer getHash(String s)
	{
		return s.hashCode();
	}
	
	public void newEntry(String name, String number)
	{
		
	}
	
	public void editEntry(String name, String newNumber)
	{
		
	}
	
	public void removeEntry(String name)
	{
		
	}
}