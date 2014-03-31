import java.util.ArrayList;

public class SystemManager {
	
	private Library library;
	private ArrayList<Librarian> librarians;
	private ArrayList<GeneralUser> generalUsers;
	boolean userIsLoggedIn; // not sure if it's necessary. Need to implement set and get.
	/*maybe create a Librarian and GeneralUser. One of them stores the current user, the other one is null, 
	 *then some methods will be accessed only by the correct type of user 
	*/
	
	public SystemManager()
	{
	}
	
	public SystemManager(Library library, ArrayList<Librarian> librarians, ArrayList<GeneralUser> generalUsers)
	{
		this.library = library;
		this.librarians = librarians;
		this.generalUsers = generalUsers;
	}
	
	public void setLibrary(Library library)
	{
		this.library = library;
	}
	
	public void setLibrarians(ArrayList<Librarian> librarians)
	{
		this.librarians = librarians;
	}
	
	public void setGeneralUsers(ArrayList<GeneralUser> generalUsers)
	{
		this.generalUsers = generalUsers;
	}
	
	public Library getLibrary()
	{
		return library;
	}
	
	public String getLibrarians()
	{
		return "" + librarians;
	}
	
	public String getGeneralUsers()
	{
		return "" + generalUsers;
	}
	
	public boolean checkLoginGeneralUser(String userId, String password)
	{
		for(int i = 0; i < generalUsers.size(); i++)
		{
			if(generalUsers.get(i).getName().equals(userId))
			{
				if(generalUsers.get(i).getPassword() == password)
					return userIsLoggedIn = true;
				else
					return userIsLoggedIn = false;
			}
		}
		return false;
	}
	
	public boolean checkLoginLibrarian(String librarianId, String password)
	{
		for(int i = 0; i < librarians.size(); i++)
		{
			if(librarians.get(i).getName().equals(librarianId))
			{
				if(librarians.get(i).getPassword() == password)
					return userIsLoggedIn = true;
				else
					return userIsLoggedIn = false;
			}
		}
		return false;
	}
	
}
