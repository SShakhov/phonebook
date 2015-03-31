package phonebook;

public class EntryAlreadyExistsException extends Exception 
{
	public EntryAlreadyExistsException() {}
	
	public EntryAlreadyExistsException(String msg)
	{
		super(msg);
	}
}
