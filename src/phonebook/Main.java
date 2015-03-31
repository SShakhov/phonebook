package phonebook;

public class Main
{
	public static void main(String[] args)
	{
		Book test = new Book();
		try
		{
			test.newEntry("John Doe", "7915123456");
			test.newEntry("Eugene Safronov", "79153296981");
		
		
			System.out.println(test.getEntry("John Doe"));
		
			test.editEntry("John Doe", "7915654321");
			System.out.println(test.getEntry("John Doe"));
		
			System.out.println("\n" + test + "\n");
		
			test.removeEntry("John Doe");
		
			System.out.println(test.getEntry("John Doe"));
		}
		catch(EntryNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e);
		}
	}
}