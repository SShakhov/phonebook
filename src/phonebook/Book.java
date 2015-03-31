package phonebook;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Book
{
	private HashMap<Integer, BookEntry> list = 
			new HashMap<Integer, BookEntry>();
	private Integer maxEntries = 42;
	
	private Integer getHash(String s)
	{
		return s.hashCode() % maxEntries;
	}
	
	private void isEntry(String name) throws EntryNotFoundException
	{
		if(list.get(getHash(name)) == null)
			throw new EntryNotFoundException(name + " not found");
	}
	
	public void newEntry(String name, String number)
	{
		//Add return true on success
		list.put(getHash(name), new BookEntry(name, number));
	}
	
	public void editEntry(String name, String newNumber) throws EntryNotFoundException
	{
			isEntry(name);
			newEntry(name, newNumber);
	}
	
	public void removeEntry(String name) throws EntryNotFoundException
	{
			isEntry(name);
			list.remove(getHash(name));
	}
	
	public BookEntry getEntry(String name) throws EntryNotFoundException
	{
			isEntry(name);
			return list.get(getHash(name));
	}
	
	@Override
	public String toString()
	{
		String str = "";
		Iterator<Map.Entry<Integer, BookEntry>> iter = list.entrySet().iterator();

		while(iter.hasNext())
		{
			str += iter.next().getValue().toString();
			str += "\n";
		}
		
		return str.trim();
	}
}