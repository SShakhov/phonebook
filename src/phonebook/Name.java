package phonebook;

import java.io.Serializable;

public class Name implements Serializable
{
	private static final long serialVersionUID = -7942702521289918791L;

	private String firstName;
	private String lastName;
	
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
	
	public Name (String firstName, String lastName)
	{
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = processName(firstName);
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = processName(lastName);
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	@Override
	public String toString()
	{
		return lastName + " " + firstName;
	}
	
	@Override
	public boolean equals(Object name)
	{
		if(!(name instanceof Name))
			return false;
		if(((Name)name).getFirstName().toLowerCase().equals(this.firstName.toLowerCase()) && 
				((Name)name).getLastName().toLowerCase().equals(this.lastName.toLowerCase()))
			return true;
		
		return false;
	}
}
