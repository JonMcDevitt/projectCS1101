import java.util.ArrayList;
public class User{
	private String name;
	private String userID;
	private String password;
	private ArrayList <Object> reservations;
	private double outstandingFine;
	
	public User(){
		
	}
	public User(String n, String u, String p){
		name = n;
		userID = u;
		password = p; //check if PW has numeric characters
		reservations = new ArrayList <Object>();
		outstandingFine = 0.0;
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
	
	public void setOutstandingFine(double of)
	{
		outstandingFine = of;
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
	
	public double getOutstandingFine()
	{
		return outstandingFine;
	}
	
	public int getTotalOfReservations()
	{
		return reservations.size();
	}
	public boolean userIdIsValid()
	{
		return true; // delete afterward
	}
	
	// check password pattern
	public boolean passwordIsValid()
	{
		return true; // delete afterward
	}
	
	public void reserveItem(Object a){
		reservations.add(a);
	}
	
	public Book returnBook(String isbn)
	/* Return book, if it is found
	 * 
	 * Parameters:
	 * isbn: isbn of the book to be returned
	 * 
	 * Return values:
	 * book found: book returned (removed)
	 * null: book not found
	 */
	{
		for(int i = 0; i < reservations.size(); i++)
		{
			Object current = reservations.get(i);
			if(current instanceof Book)
			{
				if(((Book)current).getISBN().equals(isbn))
				{
					reservations.remove(i);
					return (Book)current;
				}
			}
		}
		return null;
	}
	
	public String printReservationList(){
		if(reservations.size() == 0)
			return "No reservations";
		String message = "";
		for (int i=0; i<reservations.size(); i++){
			message += reservations.get(i).toString() + "\n";
		}
		return message;
	}
	
	public void payFine(double amount)
	{
		outstandingFine -= amount;
	}
	
	public void addFine(double amount)
	{
		outstandingFine += amount;
	}
	
	public String toString()
	{
		return "Name: " + name + "\nID: " + userID + "\nOutstanding fines: " + outstandingFine + "\nReserved books:\n" + printReservationList(); 
	}
}
