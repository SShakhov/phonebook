package phonebook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
	private static Scanner s = new Scanner(System.in);
	private static String bookName;
	
	public static void main(String[] args)
	{
		System.out.println("1: Create new phone book");
		System.out.println("2: Load existing phone book");
		System.out.println("3: Exit");
		
		int input = s.nextInt();
		s.nextLine();
		
		Book book = null;
		
		switch (input)
		{
		case 1:
			System.out.print("Enter book name: ");
			bookName = s.nextLine();
			
			book = new Book();
			break;
			
		case 2:
			System.out.print("Enter book name: ");
			bookName = s.nextLine();
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
			try
			{
				fis = new FileInputStream(bookName);
				ois = new ObjectInputStream(fis);
			
				book = (Book)ois.readObject();
				
				fis.close();
				ois.close();
			}
			catch(FileNotFoundException e)
			{
				System.out.println("\n" + e.getMessage());
			}
			catch(IOException e)
			{
				System.out.println("\n" + e.getMessage());
			}
			catch(ClassNotFoundException e)
			{
				System.out.println("\n" + e.getMessage());
			}
			finally
			{
				try
				{
					fis.close();
					ois.close();
				}
				catch(IOException e)
				{
					System.out.println("\n" + e.getMessage());
				}
			}
			break;

		default:
			return;
		}
		
		
		
		while(true)
		{
			System.out.println();
			
			System.out.println("1: Create new entry");
			System.out.println("2: Update existing entry");
			System.out.println("3: Remove entry");
			System.out.println("4: Find entry");
			System.out.println("5: Print phone book");
			System.out.println("6: Save phone book");
			System.out.println("7: Exit");
			
			input = s.nextInt();
			s.nextLine();
			
			try
			{
				switch (input) 
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
					System.out.println(book.getEntry(formName(book, s)));
					break;
					
				case 5:
					System.out.println(book);
					break;
					
				case 6:
					savePhoneBook(book, s);
					break;
					
				case 7:
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
			catch(IndexOutOfBoundsException e)
			{
				System.out.println("\n" + e.getMessage());
			}
		}
	}
	
	public static void createNewEntry(Book book, Scanner s) throws EntryAlreadyExistsException
	{	
		Name name = formName(book, s);
		
		System.out.print("Enter a phone number: ");
		String number = s.nextLine();
		
		book.newEntry(name, number);
	}
	
	public static void updateEntry(Book book, Scanner s) throws EntryNotFoundException
	{
		Name name = formName(book, s);
		
		BookEntry be = book.getEntry(name);
		System.out.println(be);
		
		System.out.println("1: Add new number");
		System.out.println("2: Delete Existing number");
		System.out.println("3: Return to main menu");
		
		int input = s.nextInt();
		s.nextLine();
		
		switch (input)
		{
		case 1:
			System.out.print("Enter new number: ");
			book.editEntry(name, s.nextLine(), -1);
			break;
			
		case 2:
			ArrayList<String> array = be.getNumbers();
			if(array.size() == 1)
			{
				System.out.print(be.getName() + " has only one phone number. Do you want to update it (y/n)? ");
				String answer = s.nextLine();
				answer = answer.trim();
				answer = answer.toLowerCase();
				
				if(answer.equals("y"))
				{
					System.out.print("Enter new phone number: ");
					book.editEntry(name, s.nextLine(), 0);
				}
				
				break;
			}
			
			System.out.println("Select which number to delete: ");
			
			for(int i = 0; i < array.size(); i++)
				System.out.println(i + 1 + ": " + array.get(i));
			
			book.editEntry(name, null, s.nextInt() - 1);
			s.nextLine();
			break;

		default:
			break;
		}
	}
	
	public static void removeEntry(Book book, Scanner s) throws EntryNotFoundException
	{	
		Name name = formName(book, s);
		
		System.out.println(book.getEntry(name));
		System.out.print("Do you want to remove this entry (y/n)? ");
			
		String answer = s.nextLine();
		answer = answer.trim();
		answer = answer.toLowerCase();
			
		if(answer.equals("y"))
			book.removeEntry(name);
	}
	
	public static Name formName(Book book, Scanner s)
	{
		System.out.print("Enter first name: ");
		String firstName = s.nextLine();
		
		System.out.print("Enter last name: ");
		String lastName = s.nextLine();
		
		Name name = new Name(firstName, lastName);
		
		return name;
	}
	
	public static void savePhoneBook(Book book, Scanner s)
	{
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try
		{
			fos = new FileOutputStream(bookName);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(book);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("\n" + e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("\n" + e.getMessage());
		}
		finally
		{
			try
			{
				fos.close();
				oos.close();
			}
			catch(IOException e)
			{
				System.out.println("\n" + e.getMessage());
			}
		}
	}
}