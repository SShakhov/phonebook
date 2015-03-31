package phonebook;

public class EntryNotFoundException extends Exception
{
	public EntryNotFoundException() {}
	public EntryNotFoundException(String msg) 
	{
		super(msg);
	}
}
