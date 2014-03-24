import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class BookFactory 
{
	public BookFactory()
	{
	}
	
	public Book[] createBooks() throws IOException
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
		
		Book[] allBooks = new Book[books.size()];
		
		for(int i = 0; i < books.size(); i++)
		{
			allBooks[i] = books.get(i);
		}
		
		return allBooks;
	}
}
