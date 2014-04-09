import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class BookFactory 
{
	public BookFactory()
	{
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
				String[] temp = new String[5];
				for(int i = 0; i < 5; i++)
				{
					temp[i] = inputFile.nextLine();
				}
				books.add(new Book(temp[0], temp[1], temp[2], temp[3], temp[4]));
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
