import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public void addBook(Book book) throws IOException
	{
		for(int i = 3; i < allSections.length; i++)
		{
			if(allSections[i].getGenre().equals(book.getGenre()))
			{
				allSections[i].addBook(book);
				FileWriter fwriter = new FileWriter("books.b", true);
				PrintWriter outputFile = new PrintWriter(fwriter);
				outputFile.println("");
				outputFile.println("#");
				outputFile.println(book.getISBN());
				outputFile.println(book.getAuthor());
				outputFile.println(book.getTitle());
				outputFile.println(book.getEdition());
				outputFile.println(book.getGenre());
				outputFile.println(book.getLanguage());
				
				outputFile.close();
				break;
			}
		}
	}
	
	public boolean removeBook(String isbn) throws IOException
	/* Try to remove book
	 * 
	 * Parameter:
	 * isbn: book's isbn of book to be removed
	 * 
	 * Return values:
	 * true: book removed successfully
	 * false: book not found
	 */
	{
		Book book;
		String output = "";
		
		// search for book in each section until find it in the right section and remove book 
		for(int i = 3; i < allSections.length; i++)
		{
			book = allSections[i].findBookByISBN(isbn);
			
			if(book != null)
			{
				allSections[i].getAllBooks().remove(book);
				
				// remove book from database (stored in a text file). It writes every book into the text file, except for removed book
				File file = new File("books.b");
				Scanner inputFile = new Scanner(file);
				
				// read all the books written into books.b and store them into String 'output', except for removed book
				while(inputFile.hasNext())
				{
					String line = inputFile.nextLine();
					if(line.equals("#"))
					{
						String v_isbn = inputFile.nextLine();
						if(!v_isbn.equals(isbn))
						{
							output += "#\n";
							output += v_isbn + "\n";
							for(int j = 0; j < 4; j++)
							{
								output += inputFile.nextLine() + "\n";
							}
							output += inputFile.nextLine();
						}
					}
				}
				inputFile.close();
				
				// write the String 'output' (which has all the books except for removed book) into books.b 
				PrintWriter outputFile = new PrintWriter("books.b");
				outputFile.print(output);
				
				outputFile.close();
				return true;
			}
		}
		return false;
	}
}
