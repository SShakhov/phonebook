package phonebook;

public class EntryAlreadyExistsException extends Exception 
{
	private static final long serialVersionUID = -1163686879716394777L;

	public EntryAlreadyExistsException() {}
	
	public EntryAlreadyExistsException(String msg)
	{
		super(msg);
	}
}
