package phonebook;

import java.util.ArrayList;
import java.util.Iterator;

public class BookEntry
{
	private ArrayList<String> numbers = new ArrayList<String>();
	private Name name;
	
	public BookEntry(Name name, String number)
	{
		this.name = name;
		addNumber(number);
	}
	
	public void addNumber(String number)
	{
		if(number == null)
			return;
		
		number = number.trim();
		for(Character c : number.toCharArray())
			if(!Character.isDigit(c))
				throw new IllegalArgumentException("Phone number contains invalid characters");

		this.numbers.add(number);
	}
	
	public void removeNumber(int i)
	{
		if(i < 0)
			return;
		numbers.remove(i);
	}
	
	public Name getName()
	{
		return name;
	}
	
	public ArrayList<String> getNumbers()
	{
		return numbers;
	}
	
	@Override
	public String toString()
	{
		String str = "";
		Iterator<String> iter = numbers.iterator();
		
		while(iter.hasNext())
		{
			str += iter.next();
			str += "; ";
		}
		
		return name + ":\t" + str;
	}
}