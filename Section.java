import java.util.ArrayList;

public class Section 
{
	private String genre;
	private ArrayList<Book> allBooks;
	private ArrayList<Journals_Anthologies> allJournals_Anthologies;
	private ArrayList<Magazine> allMagazines;
	private ArrayList<Newspapers> allNewsPapers;
	
	public Section(String genre)
	{
		this.genre = genre;
		allBooks = new ArrayList<Book>();
		allJournals_Anthologies = new ArrayList<Journals_Anthologies>();
		allMagazines = new ArrayList<Magazine>();
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
	
	private Book findBookByISBN(String ISBN)
	// search for book with the specific ISBN
	{
		for(int i = 0; i < allBooks.size(); i++)
		{
			if(allBooks.get(i).getISBN().equals(ISBN))
				return allBooks.get(i);
		}
		return null;
	}
	
	private ArrayList<Book> findBookByAuthor(String author)
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
	
	private ArrayList<Book> findBookByTitle(String title)
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
	
	public ArrayList<Book> findBook(String ISBN, String author, String title, String edition, String language)
	/* 
	 * Try to find book with more than one refinements. 'author' or 'title' or both must be not null
	 * Return value:
	 * book: ArrayList<Book> with books matched by the refinement
	 */
	{
		// books found by Author
		ArrayList<Book> booksAuthor = new ArrayList<Book>();
		
		// books found by Title
		ArrayList<Book> booksTitle = new ArrayList<Book>();
		
		// books to return
		ArrayList<Book> books = new ArrayList<Book>();
		
		if(ISBN != null)
		{
			books.add(findBookByISBN(ISBN));
			return books;
		}
			
		/* if author and title are not null, then find books with same author and title.
		 * Otherwise, check which one is not null
		 */
		if(author != null && title != null)
		{
			// get books found by author
			booksAuthor = findBookByAuthor(author);
			
			// get books found by title
			booksTitle = findBookByTitle(title);
			
			// search for books with same author and title
			for(int i = 0; i < booksAuthor.size(); i++)
			{
				Book book = booksAuthor.get(i);
				for(int j = 0; j < booksTitle.size(); j++)
				{
					if(book.equals(booksTitle.get(j))) // not sure if it works, maybe it should compare authors and titles instead
						books.add(book);
				}
			}
		}
		else if(author != null)
				books = findBookByAuthor(author);
		else 
			books = findBookByTitle(title);
		
		// remove books with different edition of 'edition' parameter
		if(edition != null)
		{
			for(int i = books.size() - 1; i >= 0; i--)
			{
				if(!books.get(i).getEdition().equals(edition))
					books.remove(i);
			}
		}
		
		// remove books with different language of 'language' parameter
		if(language != null)
		{
			for(int i = books.size() - 1; i >= 0; i--)
			{
				if(!books.get(i).getLanguage().equals(language))
					books.remove(i);
			}
		}
		
		return books;
	}
	
}
