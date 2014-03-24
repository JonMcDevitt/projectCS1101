import java.util.ArrayList;

public class SystemManager {
	
	private Library library;
	private ArrayList<Librarian> allLibrarians;		// stores all registered Librarians
	private ArrayList<GeneralUser> allGeneralUsers;	// stores all registered GeneralUsers
	GeneralUser generalUser;						// stores the logged in GeneralUser. It is null if no user is logged in
	Librarian librarian;							// stores the logged in Librarian. It is null if no librarian is logged in
	
	public SystemManager()
	{
	}
	
	public SystemManager(Library library)
	{
		this.library = library;
		allGeneralUsers = new ArrayList<GeneralUser>();
		allLibrarians = new ArrayList<Librarian>();
		
		// set to no generalUser or librarian logged in
		generalUser = null;
		librarian = null;
	}
	
	public void setLibrary(Library library)
	{
		this.library = library;
	}
	
	public String getallLibrarians()
	{
		return "" + allLibrarians;
	}
	
	public String getallGeneralUsers()
	{
		return "" + allGeneralUsers;
	}
	
	public int addGeneralUser(String name, String id, String passwd)
	/* Try do add new GeneralUser
	 * Return values:
	 *  0: new GeneralUser added successfully
	 * -1: logged in user is not a librarian
	 * -2: invalid id
	 * -3: id already exists 
	 * -4: invalid password
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
	
	public int addLibrarian(String name, String id, String passwd)
	/* Try do add new Librarian
	 * Return values:
	 *  0: new Librarian added successfully
	 * -1: logged in user is not a librarian
	 * -2: invalid id
	 * -3: id already exists 
	 * -4: invalid password
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
	
	public int loginGeneralUser(String userId, String password)
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
			// get user's index
			index = findGeneralUser(userId);
			
			// check if user does not exist and password is invalid, otherwise logs user
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
	
	public int loginLibrarian(String librarianId, String password)
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
	
	public boolean logout()
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
	
	public int findGeneralUser(String id)
	/* Search for GeneralUser with id 'id'
	 * Return values:
	 * -1: GeneralUser not found
	 *  i: index of GeneralUser
	 */
	{
		for(int i = 0; i < allGeneralUsers.size(); i++)
		{
			if(allGeneralUsers.get(i).getUserID().equals("id"))
				return i;
		}
		return -1;
	}
	
	public int findLibrarian(String id)
	/* Search for Librarian with id 'id'
	 * Return values:
	 * -1: Librarian not found
	 *  i: index of Librarian
	 */
	{
		for(int i = 0; i < allLibrarians.size(); i++)
		{
			if(allLibrarians.get(i).getUserID().equals("id"))
				return i;
		}
		return -1;
	}
	
	public ArrayList<Book> searchBook(String ISBN, String author, String title, String edition, String language, String genre)
	// not sure if returns String or ArrayList<Book>;
	{
		return library.searchBook(ISBN, author, title, edition, language, genre);
	}
}
