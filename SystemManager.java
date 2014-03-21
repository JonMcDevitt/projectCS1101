import java.util.ArrayList;

public class SystemManager {
	
	private Library library;
	private ArrayList<Librarian> librarians;
	private ArrayList<GeneralUser> generalUsers;
	GeneralUser generalUser;						// stores the logged in GeneralUser. It is null if no user is logged in
	Librarian librarian;							// stores the logged in Librarian. It is null if no librarian is logged in
	
	public SystemManager()
	{
	}
	
	public SystemManager(Library library)
	{
		this.library = library;
		generalUser = null;
		librarian = null;
	}
	
	public void setLibrary(Library library)
	{
		this.library = library;
	}
	
	public String getLibrarians()
	{
		return "" + librarians;
	}
	
	public String getGeneralUsers()
	{
		return "" + generalUsers;
	}
	
	public int addGeneralUser(String name, String id, String passwd)
	/* Try do add new GeneralUser
	 * Return values:
	 * -1: logged in user is not a librarian
	 * -2: invalid id
	 * -3: id already exists 
	 * -4: invalid password
	 * 	0: new GeneralUser added successfully
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
					generalUsers.add(newGeneralUser);
					return 0;
				}
			}		
		}
	}
	
	public int addLibrarian(String name, String id, String passwd)
	/* Try do add new Librarian
	 * Return values:
	 * -1: logged in user is not a librarian
	 * -2: invalid id
	 * -3: id already exists 
	 * -4: invalid password
	 * 	0: new Librarian added successfully
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
					librarians.add(newLibrarian);
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
		int index;
		
		if(generalUser != null || librarian != null)
			return -1;
		else
		{
			index = findGeneralUser(userId);
			if(index == -1)
				return -2;
			else if(!generalUsers.get(index).getPassword().equals(password))
				return -3;
			else
			{
				generalUser = generalUsers.get(index);
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
		int index;
		
		if(generalUser != null || librarian != null)
			return -1;
		else
		{
			index = findLibrarian(librarianId);
			if(index == -1)
				return -2;
			else if(!librarians.get(index).getPassword().equals(password))
				return -3;
			else
			{
				librarian = librarians.get(index);
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
	/*
	 * Search for GeneralUser with id 'id'
	 * Return values:
	 * -1: GeneralUser not found
	 *  i: index of GeneralUser
	 */
	{
		for(int i = 0; i < generalUsers.size(); i++)
		{
			if(generalUsers.get(i).getUserID().equals("id"))
				return i;
		}
		return -1;
	}
	
	public int findLibrarian(String id)
	/*
	 * Search for Librarian with id 'id'
	 * Return values:
	 * -1: Librarian not found
	 *  i: index of Librarian
	 */
	{
		for(int i = 0; i < librarians.size(); i++)
		{
			if(librarians.get(i).getUserID().equals("id"))
				return i;
		}
		return -1;
	}
}
