import java.util.ArrayList;

public class Library {
	//the following may not even be necessary; I'll check with Srini
	/*private String streetAddress;
	private String city;
	private String provinceState;
	private String country;
	private String postalCode;*/
	private int bookCapacity;
	Section[] allSections;
	
	public Library(){
		
	}
	public Library(int b){
		bookCapacity = b;
		allSections = new Section[1];
		
		allSections[0] = new Section("Fiction");
	}
	public void setBookCapacity(int b){
		bookCapacity = b;
	}
	public int getBookCapacity(){
		return bookCapacity;
	}
	
	public ArrayList<Book> searchBook(String ISBN, String author, String title, String edition, String language, String genre)
	{
		ArrayList<Book> books = new ArrayList<Book>();
		for(int i = 0; i < allSections.length; i++)
		{
			if(allSections[i].getGenre().equals(genre))
				books = allSections[i].findBook(ISBN, author, title, edition, language);
		}
		return books;
	}
}
