package phonebook;

public class EntryNotFoundException extends Exception
{
	private static final long serialVersionUID = -8933980287031929320L;
	
	public EntryNotFoundException() {}
	
	public EntryNotFoundException(String msg) 
	{
		super(msg);
	}
}
