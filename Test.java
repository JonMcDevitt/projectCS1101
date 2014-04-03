import java.io.*;
import java.util.ArrayList;
import java.text.ParseException;

public class Test {
	public static void main(String[] args)throws IOException, ParseException{
		Frame f = new Frame();
		User al = new User("Al", "A1i3n", "Random");
		Book Teri = new Book("123-456-789-1234", "Random author", "Bridge to Teribithia", "3rd", "Fantasy", "English");
		Newspapers news = new Newspapers("Chronicle", "02/02/02", "01/02/02");
		al.reserveItem(Teri);
		al.reserveItem(news);
		System.out.println(al.printReservationList());

		if(SystemManager.login("aaaaaa", "password", "GeneralUser") == 0)
		{
			System.out.println(SystemManager.getGeneralUser().getName() + " logged in");
			
			System.out.println(SystemManager.getGeneralUser().getName() + " is searching for a book by author...");
			// user searches book by author
			ArrayList<Book> books = SystemManager.searchBook("J R R Tolkien", "Author");
			
			// user reserves first book found
			if(books.size() == 0)
				System.out.println("Book not found!");
			else
			{
				System.out.println("Book found!");
				SystemManager.reserveBook(books.get(0));
				
				System.out.println(SystemManager.getGeneralUser());
				
				System.out.println("Returning book...");
				
				SystemManager.returnBook("0261103288-9780261103283");
				
				System.out.println(SystemManager.getGeneralUser());
				
				System.out.println("\nPaying $1 of fines...");
				
				SystemManager.payFine(1.0);
				
				System.out.println(SystemManager.getGeneralUser());
			}
			
			System.out.println("Logging out...");
			if(SystemManager.logout())
				System.out.println("Logged out successfully");
			else
				System.out.println("Failure to logout");
		}
		else
			System.out.println("Fail to log in user");
		
		
		
		
		/*System.out.println(sys.searchBook("J R R Tolkien", "Author"));
		System.out.println(sys.searchBook("Paul Harold Kocher", "Author"));
		System.out.println(sys.searchBook("Fiction", "Genre"));
		System.out.println(sys.searchBook("The two towers : being the second part of the Lord of the rings", "Title"));
		
		BookFactory f = new BookFactory();
		
		ArrayList<Magazine> m = f.createMagazines();
		
		System.out.println(m);*/
	}
}
