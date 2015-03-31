package phonebook;

public class BookEntry
{
	private String name;
	private String number;
	
	public BookEntry(String name, String number)
	{
		setName(name);
		setNumber(number);
	}
	
	public void setName(String name)
	{
		//Add checks
		this.name = name;
	}
	
	public void setNumber(String number)
	{
		//Add checks
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