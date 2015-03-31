package phonebook;

public class BookEntry
{
	private String name;
	private String number;
	
	public static String processName(String name)
	{	
		if(name.isEmpty())
			throw new IllegalArgumentException("Name cannot be empty");

		name = name.trim();
		char[] buff = name.toCharArray();
		
		String str = "";
		for(int i = 0; i < buff.length; i++)
		{
			if(Character.isWhitespace(buff[i]))
			{
				if(Character.isWhitespace(buff[i-1]))
					continue;
				str += " ";
				continue;
			}
			else if(!Character.isAlphabetic(buff[i]))
				throw new IllegalArgumentException("Name contains invalid characters");
			
			str += buff[i];
		}
		
		return str;
	}
	
	public BookEntry(String name, String number)
	{
		setName(name);
		setNumber(number);
	}
	
	public void setName(String name)
	{
		this.name = processName(name);
	}
	
	public void setNumber(String number)
	{
		for(Character c : number.toCharArray())
			if(!Character.isDigit(c))
				throw new IllegalArgumentException("Phone number contains invalid characters");

		this.number = number;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	@Override
	public String toString()
	{
		return name + ":\t" + number;
	}
}