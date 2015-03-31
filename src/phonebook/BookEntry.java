package phonebook;

public class BookEntry
{
	private String number;
	private Name name;
	
	public BookEntry(Name name, String number)
	{
		this.name = name;
		setNumber(number);
	}
	
	public void setNumber(String number)
	{
		for(Character c : number.toCharArray())
			if(!Character.isDigit(c))
				throw new IllegalArgumentException("Phone number contains invalid characters");

		this.number = number;
	}
	
	public Name getName()
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