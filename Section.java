import java.util.ArrayList;
import java.io.*;

public class Section 
{
	private String genre;
	private ArrayList<Book> allBooks;
	private ArrayList<Journals_Anthologies> allJournals_Anthologies;
	private ArrayList<Magazine> allMagazines;
	private ArrayList<Newspapers> allNewsPapers;
	
	public Section(String genre) throws IOException
	{
		Factory factory= new Factory();
		
		
		this.genre = genre;
		allBooks = factory.createBooks();
		allJournals_Anthologies = new ArrayList<Journals_Anthologies>();
		allMagazines = factory.createMagazines();
		allNewsPapers = new ArrayList<Newspapers>();
	}
	
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public ArrayList<Book> getAllBooks()
	{
		return allBooks;
	}
	public void addBook(Book book)
	{
		allBooks.add(book);
	}
	
	public void addJournals_Anthologies(Journals_Anthologies journals_anthologies)
	{
		allJournals_Anthologies.add(journals_anthologies);
	}
	
	public void addMagazine(Magazine magazine)
	{
		allMagazines.add(magazine);
	}
	
	public void addNewsPapers(Newspapers newsPaper)
	{
		allNewsPapers.add(newsPaper);
	}
	
	public Book findBookByISBN(String ISBN)
	// search for book with the specific ISBN
	{
		for(int i = 0; i < allBooks.size(); i++)
		{
			if(allBooks.get(i).getISBN().equals(ISBN))
				return allBooks.get(i);
		}
		return null;
	}
	
	public ArrayList<Book> findBookByAuthor(String author)
	// search for books with specific author and return only one occurrence of each of them
	{
		// not sure if return ArrayList or String
		ArrayList<Book> books = new ArrayList<Book>();
		for(int i = 0; i < allBooks.size(); i++)
		{															
			if(allBooks.get(i).getAuthor().equals(author) && !books.contains(allBooks.get(i))) // not sure if the second expression works
				books.add(allBooks.get(i));
		}
		return books;
	}
	
	public ArrayList<Book> findBookByTitle(String title)
	// search for books with specific title and return only one occurrence of each of them
	{
		// not sure if return ArrayList or String
		ArrayList<Book> books = new ArrayList<Book>();
		for(int i = 0; i < allBooks.size(); i++)
		{
			if(allBooks.get(i).getTitle().equals(title) && !books.contains(allBooks.get(i))) // not sure if the second expression works
				books.add(allBooks.get(i));
		}
		return books;
	}
	
	public ArrayList<Magazine> findMagazineByTitle(String title)
	// search for magazines with specific title and return only one occurrence of each of them
	{
		// not sure if return ArrayList or String
		ArrayList<Magazine> magazines = new ArrayList<Magazine>();
		for(int i = 0; i < allBooks.size(); i++)
		{
			if(allMagazines.get(i).getTitle().equals(title) && !magazines.contains(allMagazines.get(i))) // not sure if the second expression works
				magazines.add(allMagazines.get(i));
		}
		return magazines;
	}
}
