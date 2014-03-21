
public class Book {
	private String ISBN;
	private String author;
	private String title;
	private String edition;
	private String genre;
	private String language;
	
	public Book()
	{
	}
	public Book(String i, String a, String t, String e, String g, String l) //int i?
	{ //add in an isValid method and a corresponding while loop
		ISBN=i;
		author=a;
		title=t;
		edition=e;
		genre=g;
		language=l;
	}
	
	public void setISBN(String i)
	{ //add in 'isValid method'
		ISBN=i;
	}
	public void setAuthor(String a)
	{
		author=a;
	}
	public void setTitle(String t)
	{
		title=t;
	}
	public void setEdition(String e)
	{
		edition=e;
	}
	public void setGenre(String g)
	{
		genre=g;
	}
	public void setLanguage(String l)
	{
		language=l;
	}
	
	public String getISBN()
	{
		return ISBN;
	}
	public String getAuthor()
	{
		return author;
	}
	public String getTitle()
	{
		return title;
	}
	public String getEdition()
	{
		return edition;
	}
	public String getGenre()
	{
		return genre;
	}
	public String getLanguage()
	{
		return language;
	}
	
	public String toString()
	{
		return "[" + ISBN + ", " + author + ", " + title + ", " + edition + ", " + genre + ", " + language + "]"; 
	}
}
