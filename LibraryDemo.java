import java.util.ArrayList;
import java.io.*;
import java.util.ArrayList;

public class LibraryDemo 
{
	public static void main(String[] args) throws IOException
	{
		BookFactory f = new BookFactory();
		Book[] books = f.createBooks();
		
		Section s = new Section("Fiction");
		for(int i = 0; i < books.length; i++)
		{
			s.addBook(books[i]);
		}
		
		ArrayList<Book> booksByAuthor = s.findBook("0261103288-9780261103283", null, null, null, null);
		
		for(int i = 0; i < booksByAuthor.size(); i++)
		{
			System.out.println(booksByAuthor.get(i));
		}
		
		booksByAuthor = s.findBook(null, "J R R Tolkien", null, null, null);
		
		for(int i = 0; i < booksByAuthor.size(); i++)
		{
			System.out.println(booksByAuthor.get(i));
		}
		
		booksByAuthor = s.findBook(null, "Paul Harold Kocher", null, null, null);
		System.out.println();
		for(int i = 0; i < booksByAuthor.size(); i++)
		{
			System.out.println(booksByAuthor.get(i));
		}
		
		booksByAuthor = s.findBook(null, null, "The two towers : being the second part of the Lord of the rings", null, null);
		System.out.println();
		for(int i = 0; i < booksByAuthor.size(); i++)
		{
			System.out.println(booksByAuthor.get(i));
		}
		
		booksByAuthor = s.findBook(null, "J R R Tolkien", null, "2nd", null);
		System.out.println();
		for(int i = 0; i < booksByAuthor.size(); i++)
		{
			System.out.println(booksByAuthor.get(i));
		}
		
		booksByAuthor = s.findBook(null, "J R R Tolkien", null, "2nd", "Russian");
		System.out.println();
		for(int i = 0; i < booksByAuthor.size(); i++)
		{
			System.out.println(booksByAuthor.get(i));
		}
		
		booksByAuthor = s.findBook(null, "J R R Tolkien", "The two towers : being the second part of the Lord of the rings", null, null);
		System.out.println();
		for(int i = 0; i < booksByAuthor.size(); i++)
		{
			System.out.println(booksByAuthor.get(i));
		}
		
		booksByAuthor = s.findBook(null, "J R R Tolkien", "The two towers : being the second part of the Lord of the rings", "2nd", null);
		System.out.println();
		for(int i = 0; i < booksByAuthor.size(); i++)
		{
			System.out.println(booksByAuthor.get(i));
		}
		
		booksByAuthor = s.findBook(null, "J R R Tolkien", "The two towers : being the second part of the Lord of the rings", "2nd", "English");
		System.out.println();
		for(int i = 0; i < booksByAuthor.size(); i++)
		{
			System.out.println(booksByAuthor.get(i));
		}
	}
}
