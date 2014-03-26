import java.io.*;
import java.util.ArrayList;

public class LibraryDemo 
{
	public static void main(String[] args) throws IOException
	{	
		SystemManager sys = new SystemManager(new Library(20));
		
		System.out.println(sys.searchBook("J R R Tolkien", "Author"));
		System.out.println(sys.searchBook("Paul Harold Kocher", "Author"));
		System.out.println(sys.searchBook("Fiction", "Genre"));
		System.out.println(sys.searchBook("The two towers : being the second part of the Lord of the rings", "Title"));
		
		BookFactory f = new BookFactory();
		
		ArrayList<Magazine> m = f.createMagazines();
		
		System.out.println(m);
		
	}
}
