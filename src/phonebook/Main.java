package phonebook;

public class Main
{
	public static void main(String[] args)
	{
		Book test = new Book();
		
		test.newEntry("John Doe", "+7915123456");
		test.newEntry("Eugene Safronov", "+7lololol");
		
		System.out.println(test.getEntry("John Doe"));
		
		test.editEntry("John Doe", "+7915654321");
		System.out.println(test.getEntry("John Doe"));
		
		test.removeEntry("John Doe");
		
		System.out.println(test.getEntry("John Doe"));
	}
}