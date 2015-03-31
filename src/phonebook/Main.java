package phonebook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
	public static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		Book book = new Book();
		
		while(true)
		{
			System.out.println();
			
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
				System.out.println("\n" + e.getMessage());
			}
			catch(EntryAlreadyExistsException e)
			{
				System.out.println("\n" + e.getMessage());
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("\n" + e.getMessage());
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please choose one of the listed options");
				s.nextLine();
			}
		}
	}
	
	public static void createNewEntry(Book book, Scanner s) throws EntryAlreadyExistsException
	{
		s.nextLine();
		
		System.out.print("Enter first name: ");
		String firstName = s.nextLine();
		
		System.out.print("Enter last name: ");
		String lastName = s.nextLine();
		
		Name name = new Name(firstName, lastName);
		
		System.out.print("Enter a phone number: ");
		String number = s.nextLine();
		
		book.newEntry(name, number);
	}
	
	public static void updateEntry(Book book, Scanner s) throws EntryNotFoundException
	{
		s.nextLine();
		
		System.out.print("Enter first name of a person to update: ");
		String firstName = s.nextLine();
		
		System.out.print("Enter last name of a person to update: ");
		String lastName = s.nextLine();
		
		Name name = new Name(firstName, lastName);
		
		System.out.println(book.getEntry(name));
		System.out.print("Enter new phone number: ");
		String newNumber = s.nextLine();
			
		book.editEntry(name, newNumber);
	}
	
	public static void removeEntry(Book book, Scanner s) throws EntryNotFoundException
	{
		s.nextLine();
		
		System.out.print("Enter first name of a person to delete: ");
		String firstName = s.nextLine();
		
		System.out.print("Enter last name of a person to delete: ");
		String lastName = s.nextLine();
		
		Name name = new Name(firstName, lastName);
		
		System.out.println(book.getEntry(name));
		System.out.println("Do you want to remove this entry? (y/n)");
			
		String answer = s.nextLine();
		answer = answer.trim();
		answer = answer.toLowerCase();
			
		if(answer.equals("y"))
			book.removeEntry(name);
	}
}