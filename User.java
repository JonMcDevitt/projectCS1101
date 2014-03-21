
public class User{
	private String name;
	private String userID;
	private String password;
	
	public User(){
		
	}
	public User(String n, String u, String p){
		name = n;
		userID = u;
		password = p; //check if PW has numeric characters
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setUserID(String u){
		userID = u;
	}
	public void setPassword(String p){
		password = p; //check if PW has numeric characters
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getUserID(){
		return userID;
	}
	public String getPassword(){
		return password;
	}
	
	public boolean userIdIsValid()
	{
		return true; // delete afterward
	}
	
	public boolean passwordIsValid()
	{
		return true; // delete afterward
	}
}
