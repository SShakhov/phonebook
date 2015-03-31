package phonebook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Book implements Serializable
{
	private static final long serialVersionUID = -4336066641849188538L;	
	
	private Integer maxEntries = 42;
	
	private HashMap<Integer, ArrayList<BookEntry>> list = 
			new HashMap<Integer, ArrayList<BookEntry>>(maxEntries);
	
	private Integer getHash(String s)
	{
		return s.toLowerCase().hashCode() % maxEntries;
	}
	
	private void isEntry(Name name) throws EntryNotFoundException
	{
		if(list.get(getHash(name.getLastName())) == null)
			throw new EntryNotFoundException(name + " not found");
	}
	
	public void newEntry(Name name, String number) throws EntryAlreadyExistsException
	{
		Integer hash = getHash(name.getLastName());

		if(list.get(hash) == null)
			//No such entry in HashMap yet
			list.put(hash, new ArrayList<BookEntry>());
		
		ArrayList<BookEntry> array = list.get(hash);
		
		for(BookEntry be : array)
			if(be.getName().equals(name))
				throw new EntryAlreadyExistsException(be.getName() + " already exists");
		
		array.add(new BookEntry(name, number));
	}
	
	public void editEntry(Name name, String newNumber, int deleteNumber) throws EntryNotFoundException
	{
		isEntry(name);
		ArrayList<BookEntry> array = list.get(getHash(name.getLastName()));
		
		for(BookEntry be : array)
			if(be.getName().equals(name))
			{
				be.addNumber(newNumber);
				be.removeNumber(deleteNumber);
				return;
			}
		
		throw new EntryNotFoundException(name + " not found");
	}
	
	public void removeEntry(Name name) throws EntryNotFoundException
	{
			isEntry(name);
			ArrayList<BookEntry> array = list.get(getHash(name.getLastName()));
			
			for(int i = 0; i < array.size(); i++)
				if(array.get(i).getName().equals(name))
				{
					array.remove(i);
					
					if(array.size() == 0)
						//Removed the last person, removing entry
						list.remove(getHash(name.getLastName()));
					
					return;
				}
			throw new EntryNotFoundException(name + " not found");
	}
	
	public BookEntry getEntry(Name name) throws EntryNotFoundException
	{
			isEntry(name);
			ArrayList<BookEntry> array = list.get(getHash(name.getLastName()));
			
			for(BookEntry be : array)
				if(be.getName().equals(name))
					return be;
			
			throw new EntryNotFoundException(name + " not found");
	}
	
	@Override
	public String toString()
	{
		String str = "";
		
		ArrayList<BookEntry> sorted = new ArrayList<BookEntry>();
		Iterator<Entry<Integer, ArrayList<BookEntry>>> mapIter = list.entrySet().iterator();

		while(mapIter.hasNext())
		{
			Iterator <BookEntry> listIter = mapIter.next().getValue().iterator();
			while(listIter.hasNext())
			{
				sorted.add(listIter.next());
			}
		}
		
		Collections.sort(sorted, new Comparator<BookEntry>()
				{
					@Override
					public int compare(BookEntry o1, BookEntry o2)
					{
						int lastNames = 
								o1.getName().getLastName().toLowerCase().compareTo(o2.getName().getLastName().toLowerCase());
						int firstNames = 
								o1.getName().getFirstName().toLowerCase().compareTo(o2.getName().getFirstName().toLowerCase());
						
						if(lastNames != 0)
							return lastNames;
						else
							return firstNames;
					}
				});
		
		Iterator<BookEntry> sortIter = sorted.iterator();
		
		while(sortIter.hasNext())
		{
			str += sortIter.next();
			str += "\n";
		}
		
		return str.trim();
	}
}