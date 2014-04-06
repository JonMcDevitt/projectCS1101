import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.*;

public class SystemManager {
	
	private static Library library;
	private static ArrayList<Librarian> allLibrarians;					// stores all registered Librarians
	private static ArrayList<GeneralUser> allGeneralUsers; 				//stores all registered GeneralUsers
	private static GeneralUser generalUser = null;						// stores the logged in GeneralUser. It is null if no user is logged in
	private static Librarian librarian = null;							// stores the logged in Librarian. It is null if no librarian is logged in
	
	static {
	     Library temp1 = null;
	     ArrayList<Librarian> temp2 = null;
	     ArrayList<GeneralUser> temp3 = null;
	     try {
	       temp1 = new Library(1000);
	       temp2 = Factory.createLibrarians();
	       temp3 = Factory.createGeneralUsers();
	     } catch (IOException e) {
	    	 throw new RuntimeException("Class initialization failed due to IOException", e);
	     }
	     library = temp1;
	     allLibrarians = temp2;
	     allGeneralUsers = temp3;
	}
	
	
	public SystemManager() throws IOException
	{
	}
	
	/*public SystemManager() throws IOException
	{
		//Factory f = new Factory();
		
		/*library = new Library(20000);
		allGeneralUsers = Factory.createGeneralUsers();
		allLibrarians = Factory.createLibrarians();*/
		
		// set to no generalUser or librarian logged in
		/*generalUser = null;
		librarian = null;
	}*/
	
	/*       --------------------------------------------------------------------
	 *      |                         LOGIN/LOGOUT METHODS                       |
	 *       --------------------------------------------------------------------
	 */
	
	public static int login(String userID, String password, String userType)
	/*
	 * Try to login user
	 * Return values:
	 *  0: Logged in successfully
	 * -1: There is another user logged in
	 * -2: User does not exist
	 * -3: Password invalid
	 */
	{
		if(userType == "GeneralUser")
			return loginGeneralUser(userID, password);
		else if(userType == "Librarian")
			return loginLibrarian(userID, password);
		
		return -2; 
	}
	
	private static int loginGeneralUser(String userId, String password)
	/*
	 * Try to login GeneralUser
	 * Return values:
	 *  0: Logged in successfully
	 * -1: There is another user logged in
	 * -2: User does not exist
	 * -3: Password invalid
	 */
	{
		// index of GeneralUser with id 'id'
		int index;
		
		// check if there is another user logged in, otherwise try do log in
		if(generalUser != null || librarian != null)
			return -1;
		else
		{
			// get user's index. -1 if user does not exist
			index = findGeneralUser(userId);
			
			// check if user does not exist or password is invalid, otherwise log in user
			if(index == -1)
				return -2;
			else if(!allGeneralUsers.get(index).getPassword().equals(password))
				return -3;
			else
			{
				generalUser = allGeneralUsers.get(index);
				return 0;
			}
		}
	}
	
	public static int loginLibrarian(String librarianId, String password)
	/*
	 * Try to login Librarian
	 * Return values:
	 *  0: Logged in successfully
	 * -1: There is another user logged in
	 * -2: User does not exist
	 * -3: Password invalid
	 */
	{
		// index of GeneralUser with id 'id'
		int index;
		
		// check if there is another user logged in, otherwise try do log in
		if(generalUser != null || librarian != null)
			return -1;
		else
		{
			// get user's index
			index = findLibrarian(librarianId);
			
			// check if user does not exist and password is invalid, otherwise logs user
			if(index == -1)
				return -2;
			else if(!allLibrarians.get(index).getPassword().equals(password))
				return -3;
			else
			{
				librarian = allLibrarians.get(index);
				return 0;
			}
		}
	}
	
	public static boolean logout()
	/* Try to logout user
	 * Return values:
	 * false: No user logged in
	 * true: Log out successfully
	 */
	{
		// check if there is no any user logged in, otherwise log out user
		if(generalUser == null && librarian == null)
			return false;
		else
		{
			generalUser = null;
			librarian = null;
			return true;
		}
	}
	
	
	
	
	/*       --------------------------------------------------------------------
	 *      |                        GENERAL USER METHODS                        |
	 *       --------------------------------------------------------------------
	 */
	
	public static ArrayList<Book> searchBook(String userInput, String option)
	/* Search book 
	 * 
	 * Parameters:
	 * userInput: 	input from user to search for (e.g. book's title)
	 * option: 		type of search (search by: title, or author, or genre)
	 * 
	 * Return value:
	 * ArrayList with all books found in the library
	 */
	{
		return library.searchBook(userInput, option);
	}
	
	public static int reserveBook(Book book)
	/* Reserve book and add book to user's list of reserved books
	 * 
	 * Parameter:
	 * book: book to be reserved
	 * 
	 * Return values:
	 *  0: book reserved successfully
	 * -1: user already has 8 books reserved
	 * -2: user has outstanding fines
	 */
	{
		if(generalUser.getTotalOfReservations() == 8)
			return -1;
		else if(generalUser.getOutstandingFine() > 0.0)
			return -2;
		else
		{
			
			String dateReserved, dueDate;
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); 
			//c.add(Calendar.DATE, 14); // adjust due date by adding 2 weeks of current date
			c.add(Calendar.DATE, -2);
			
			dateReserved = sdf.format(Calendar.getInstance().getTime());
			dueDate = sdf.format(c.getTime());
			
			book.setDateReserved(dateReserved);
			book.setDateDue(dueDate);
			
			//add book to user's list of reserved books
			generalUser.reserveItem(book);
			
			return 0;
			
		}
	}
	
	public static boolean payFine(double amount)
	/* Try to pay user's outstanding fines
	 * 
	 * Parameter:
	 * amount: amount of fine to be paid
	 * 
	 * Return values:
	 * true: fine paid successfully
	 * false: amount to be paid is greater than total fine
	 */
	{
		if(amount > generalUser.getOutstandingFine())
			return false;
		else
		{
			generalUser.payFine(amount);
			return true;
		}
	}
	
	public static int returnBook(String isbn) throws ParseException
	/* Return book and apply fine if it is necessary
	 * 
	 * Parameter:
	 * book: book to be received
	 * 
	 * Return values:
	 *  0: book received at the exact due date
	 * -1: book not found 					
	 * value greater than 0: 	total of days late 
	 */
	{
		Book book = generalUser.returnBook(isbn);
		
		if(book == null)
			return -1;
		else
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dueDate = sdf.parse(book.getDateDue());
			Date currentDate = Calendar.getInstance().getTime();
			
			int days = (int)(currentDate.getTime() - dueDate.getTime())/ (24 * 60 * 60 * 1000);
			
			// apply fine
			if(days > 0)
				generalUser.addFine(days); 
			else
				days = 0;
			
			book.setDateReserved("");
			book.setDateDue("");
			
			return days;
		}
		
		
	}
	
	// to check status ????????
	public static GeneralUser getGeneralUser()
	{
		return generalUser;
	}
	
	
	
	
	/*       --------------------------------------------------------------------
	 *      |                           LIBRARIAN METHODS                        |
	 *       --------------------------------------------------------------------
	 */
	
	public static boolean addBook(Book book) throws IOException
	/* Try to add book
	 * 
	 * Parameter:
	 * book: book to be added
	 * 
	 * Return values:
	 * true: book added successfully
	 * false: invalid ISBN
	 */
	{
		if(!book.isValid())
			return false;
		else
			library.addBook(book);
			return true;
	}
	
	public static boolean removeBook(String isbn) throws IOException
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
		return library.removeBook(isbn);
	}
	
	/*       --------------------------------------------------------------------
	 *      |                           AUXILIARY METHODS                        |
	 *       --------------------------------------------------------------------
	 */
	
	public static int findGeneralUser(String id)
	/* Search for GeneralUser with id 'id'
	 * Return values:
	 * -1: GeneralUser not found
	 *  i: index of GeneralUser
	 */
	{
		for(int i = 0; i < allGeneralUsers.size(); i++)
		{
			if(allGeneralUsers.get(i).getUserID().equals(id))
				return i;
		}
		return -1;
	}
	
	public static int findLibrarian(String id)
	/* Search for Librarian with id 'id'
	 * Return values:
	 * -1: Librarian not found
	 *  i: index of Librarian
	 */
	{
		
		for(int i = 0; i < allLibrarians.size(); i++)
		{
			if(allLibrarians.get(i).getUserID().equals(id))
				return i;
		}
		return -1;
	}
	
	public static String getallLibrarians()
	{
		return "" + allLibrarians;
	}
	
	public static String getallGeneralUsers()
	{
		return "" + allGeneralUsers;
	}
	
	public static int addGeneralUser(String name, String id, String passwd)
	/* Try do add new GeneralUser
	 * Return values:
	 *  0: new GeneralUser added successfully
	 * -1: logged in user is not a librarian
	 * -2: invalid id (does not match ID pattern)
	 * -3: id already exists 
	 * -4: invalid password (does not match password pattern)
	 */
	{
		if(librarian == null)
			return -1;
		else 
		{
			GeneralUser newGeneralUser = new GeneralUser(name, id, passwd);
			if(!newGeneralUser.userIdIsValid())
				return -2;
			else 
			{
				/* Check whether there is a GeneralUser with same id and/or password is invalid,
				 * otherwise add new Librarian
				 */
				if(findGeneralUser(id) >= 0)
					return -3;
				else if(!newGeneralUser.passwordIsValid())
					return -4;
				else
				{
					allGeneralUsers.add(newGeneralUser);
					return 0;
				}
			}		
		}
	}
	
	public static int addLibrarian(String name, String id, String passwd)
	/* Try do add new Librarian
	 * Return values:
	 *  0: new Librarian added successfully
	 * -1: logged in user is not a librarian
	 * -2: invalid id (does not match ID pattern)
	 * -3: id already exists 
	 * -4: invalid password (does not match password pattern)
	 */
	{
		if(librarian == null)
			return -1;
		else 
		{
			Librarian newLibrarian = new Librarian(name, id, passwd);
			if(!newLibrarian.userIdIsValid())
				return -2;
			else 
			{
				/* Check whether there is a Librarian with same id and/or password is invalid,
				 * otherwise add new Librarian
				 */
				if(findLibrarian(id) >= 0)
					return -3;
				else if(!newLibrarian.passwordIsValid())
					return -4;
				else
				{
					allLibrarians.add(newLibrarian);
					return 0;
				}
			}		
		}
	}
}

