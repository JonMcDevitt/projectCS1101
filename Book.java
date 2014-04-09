public class Book extends Reservation{
	private String ISBN;
	private String author;
	private String title;
	private String genre;
	private String language;

	public Book()
	{
	}
	public Book(String i, String a, String t, String g, String l)
	{ //add in an isValid method and a corresponding while loop
		ISBN=i;
		author=a;
		title=t;
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
	public String getGenre()
	{
		return genre;
	}
	public String getLanguage()
	{
		return language;
	}
	
	public boolean isValid()
	{
		int count = 0;
		for(int i = 0; i < ISBN.length(); i++)
		{
			if(ISBN.charAt(i)!= '-')
				count++;
		}
		if((count == 10) || (count == 13))
			return true;
		else
			return false;
	}

	public String toString()
	{
		return "ISBN: " + ISBN + "\nAuthor: " + author + "\nTitle: " + title + "\nGenre: " + 
				genre + "\nLanguage: " + language + "\nReservation date: " + this.getDateReserved() + "\nDue date: " + this.getDateDue(); 
	}

}