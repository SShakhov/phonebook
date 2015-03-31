package phonebook;

//import java.util.ArrayList;
import java.util.HashMap;

public class Book
{
	private HashMap<Integer, BookEntry> list = 
			new HashMap<Integer, BookEntry>();
	private Integer maxEntries = 42;
	
	private Integer getHash(String s)
	{
		return s.hashCode() % maxEntries;
	}
	
	private boolean isEntry(String name)
	{
		if(list.get(getHash(name)) == null)
		{
			System.out.println("Error: " + name + " not found");
			
			return false;
		}
		
		return true;
	}
	
	public void newEntry(String name, String number)
	{
		//Add return true on success
		list.put(getHash(name), new BookEntry(name, number));
	}
	
	public void editEntry(String name, String newNumber)
	{
		if(!isEntry(name))
			return;
		
		newEntry(name, newNumber);
	}
	
	public void removeEntry(String name)
	{
		if(!isEntry(name))
			return;
		
		list.put(getHash(name), null);
	}
	
	public BookEntry getEntry(String name)
	{
		if(!isEntry(name))
			return null;
		
		return list.get(getHash(name));
	}
}