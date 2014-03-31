import java.io.*;
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
	public Library(int b) throws IOException
	{
		bookCapacity = b;
		allSections = new Section[4];
		
		allSections[0] = new Section("Magazines");
		allSections[1] = new Section("Journals");
		allSections[2] = new Section("Newspapers");
		allSections[3] = new Section("Fiction");
	}
	public void setBookCapacity(int b){
		bookCapacity = b;
	}
	public int getBookCapacity(){
		return bookCapacity;
	}
	
	public ArrayList<Book> searchBook(String userInput, String option)
	{
		ArrayList<Book> books = new ArrayList<Book>();
		
		// return all books with the specific genre
		if(option.equals("Genre"))
		{
			// It starts searching the genre at index 3, since the 3 first sections are Magazines, Newspapers and Journals 
			for(int i = 3; i < allSections.length; i++)
			{
				if(allSections[i].getGenre().equals(option))
					books = allSections[i].getAllBooks();
			}
		}
		else if(option.equals("Author"))
		{
			// search for books by Author's name on each Section
			for(int i = 0; i < allSections.length; i++)
			{
				books = allSections[i].findBookByAuthor(userInput);
			}
		}
		// search for books by Title's name on each Section
		else if(option.equals("Title"))
		{
			for(int i = 0; i < allSections.length; i++)
			{
				books = allSections[i].findBookByTitle(userInput);
		
			}
		}
		
		return books;
	}
	
	/*public String searchMagazine(String userInput, String option)
	{
		String magazines = "";
		
		if(option.equals("Title"))
		{
			for(int i = 0; i < allSections.length; i++)
			{
				if(allSections[i].getGenre().equals(option))
					magazines = allSections[i].getAllBooks();
			}
		}
		return magazines;
	}*/
}
