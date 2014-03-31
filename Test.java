import java.io.*;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args)throws IOException{
		User al = new User("Al", "A1i3n", "Random");
		Book Teri = new Book("123-456-789-1234", "Random author", "Bridge to Teribithia", "3rd", "Fantasy", "English");
		Newspapers news = new Newspapers("Chronicle", "02/02/02", "01/02/02");
		al.reserveItem(Teri);
		al.reserveItem(news);
		System.out.println(al.printReservationList());
		
		
		
		SystemManager sys = new SystemManager();
		
		System.out.println(sys.searchBook("J R R Tolkien", "Author"));
		System.out.println(sys.searchBook("Paul Harold Kocher", "Author"));
		System.out.println(sys.searchBook("Fiction", "Genre"));
		System.out.println(sys.searchBook("The two towers : being the second part of the Lord of the rings", "Title"));
		
		BookFactory f = new BookFactory();
		
		ArrayList<Magazine> m = f.createMagazines();
		
		System.out.println(m);
	}
}
