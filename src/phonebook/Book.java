package phonebook;

//import java.util.ArrayList;
import java.util.HashMap;

public class Book
{
	private HashMap<Integer, BookEntry> list = 
			new HashMap<Integer, BookEntry>();
	
	private Integer getHash(String s)
	{
		return s.hashCode();
	}
	
	public void newEntry(String name, String number)
	{
		//Add return true on success
		list.put(getHash(name), new BookEntry(name, number));
	}
	
	public void editEntry(String name, String newNumber)
	{
		
	}
	
	public void removeEntry(String name)
	{
		
	}
	
	public BookEntry getEntry(String name)
	{
		//Add return null on failure
		return list.get(getHash(name));
	}
}