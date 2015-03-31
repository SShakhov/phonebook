package phonebook;

import java.util.Scanner;

public class Main
{
	public static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		Book book = new Book();
		
		while(true)
		{
			System.out.println("1: Create new entry");
			System.out.println("2: Update existing entry");
			System.out.println("3: Remove entry");
			System.out.println("4: Print phonebook");
			System.out.println("5: Exit");	
			
			try
			{
				switch (s.nextInt()) 
				{
				case 1:
					createNewEntry(book, s);
					break;
					
				case 2:
					updateEntry(book, s);
					break;
					
				case 3:
					removeEntry(book, s);
					break;
					
				case 4:
					s.nextLine();
					System.out.println(book);
					break;
					
				case 5:
					s.close();
					return;
					
				default:
					s.nextLine();
					System.out.println("Please choose one of the listed options");
					break;
				}
			}
			catch(EntryNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			catch(IllegalArgumentException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void createNewEntry(Book book, Scanner s)
	{
		s.nextLine();
		
		System.out.print("Enter a name: ");
		String name = s.nextLine();
		
		System.out.print("Enter a phone number: ");
		String number = s.nextLine();
		
		book.newEntry(name, number);
	}
	
	public static void updateEntry(Book book, Scanner s) throws EntryNotFoundException
	{
		s.nextLine();
		
		System.out.print("Enter a name for update: ");
		String name = s.nextLine();
		
		System.out.println(book.getEntry(name));
		System.out.print("Enter new phone number: ");
		String newNumber = s.nextLine();
			
		book.editEntry(name, newNumber);
	}
	
	public static void removeEntry(Book book, Scanner s) throws EntryNotFoundException
	{
		s.nextLine();
		
		System.out.print("Enter a name for deletion: ");
		String name = s.nextLine();
		
		System.out.println(book.getEntry(name));
		System.out.println("Do you want to remove this entry? (y/n)");
			
		String answer = s.nextLine();
		answer = answer.trim();
		answer = answer.toLowerCase();
			
		if(answer.equals("y"))
			book.removeEntry(name);
	}
}