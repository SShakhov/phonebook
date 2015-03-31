package phonebook;

public class Main
{
	public static void main(String[] args)
	{
		Book test = new Book();
		
		test.newEntry("John Doe", "+7915123456");
		
		System.out.println(test.getEntry("John Doe"));
	}
}