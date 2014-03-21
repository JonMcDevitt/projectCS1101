import java.util.ArrayList;
public class LibraryDemo 
{
	public static void main(String[] args)
	{
		SystemManager sys = new SystemManager(new Library());
		Files f = new Files();
		ArrayList<Book> books = f.loadBooks();
		System.out.println(books.get(0));
		System.out.println(books.get(1));
	}
}
