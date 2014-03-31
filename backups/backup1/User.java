
public class User extends Person{
	private String userID;
	private String password;
	
	public User(){
		
	}
	public User(String u, String p){
		userID = u;
		password = p; //check if PW has numeric characters
	}
	public void setUserID(String u){
		userID = u;
	}
	public void setPassword(String p){
		password = p; //check if PW has numeric characters
	}
	public String getUserID(){
		return userID;
	}
	public String getPassword(){
		return password;
	}
}
