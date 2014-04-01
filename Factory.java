import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Factory 
{
	public Factory()
	{
	}
	
	
	public ArrayList<Librarian> createLibrarians() throws IOException
	{
		ArrayList<Librarian> librarians = new ArrayList<Librarian>();
		
		File file = new File("librarians.l");
		
		Scanner inputFile = new Scanner(file);
		
		while(inputFile.hasNext())
		{
			String line = inputFile.nextLine();
			if(line.equals("#"))
			{
				String[] temp = new String[3];
				for(int i = 0; i < 3; i++)
				{
					temp[i] = inputFile.nextLine();
				}
				librarians.add(new Librarian(temp[0], temp[1], temp[2]));
			}
		}
		
		inputFile.close();
		
		return librarians;
	}
	
	public ArrayList<GeneralUser> createGeneralUsers() throws IOException
	{
		ArrayList<GeneralUser> generalUsers = new ArrayList<GeneralUser>();
		
		File file = new File("generalUsers.gu");
		
		Scanner inputFile = new Scanner(file);
		
		while(inputFile.hasNext())
		{
			String line = inputFile.nextLine();
			if(line.equals("#"))
			{
				String[] temp = new String[3];
				for(int i = 0; i < 3; i++)
				{
					temp[i] = inputFile.nextLine();
				}
				generalUsers.add(new GeneralUser(temp[0], temp[1], temp[2]));
			}
		}
		
		inputFile.close();
		
		return generalUsers;
	}
	
	public ArrayList<Book> createBooks() throws IOException
	{
		ArrayList<Book> books = new ArrayList<Book>();
		
		File file = new File("books.b");
		
		Scanner inputFile = new Scanner(file);
		
		while(inputFile.hasNext())
		{
			String line = inputFile.nextLine();
			if(line.equals("#"))
			{
				String[] temp = new String[6];
				for(int i = 0; i < 6; i++)
				{
					temp[i] = inputFile.nextLine();
				}
				books.add(new Book(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]));
			}
		}
		
		inputFile.close();
		
		return books;
	}
	
	public ArrayList<Magazine> createMagazines() throws IOException
	{
		ArrayList<Magazine> magazines = new ArrayList<Magazine>();
		
		File file = new File("magazines.m");
		
		Scanner inputFile = new Scanner(file);
		
		while(inputFile.hasNext())
		{
			String line = inputFile.nextLine();
			if(line.equals("#"))
			{
				ArrayList<String> contributingWriters = new ArrayList<String>();
				String[] temp = new String[4];
				for(int i = 0; i < 4; i++)
				{
					temp[i] = inputFile.nextLine();
				}
				String str;
				while(inputFile.hasNext() && !(str = inputFile.nextLine()).contains("#"))
				{
					contributingWriters.add(str);
				}
				magazines.add(new Magazine(temp[0], temp[1], temp[2], temp[3], contributingWriters));
			}
		}
		
		inputFile.close();
		
		return magazines;
	}
}
