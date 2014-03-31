
public class Library {
	//the following may not even be necessary; I'll check with Srini
	/*private String streetAddress;
	private String city;
	private String provinceState;
	private String country;
	private String postalCode;*/
	private int bookCapacity;
	
	public Library(){
		
	}
	public Library(int b){
		bookCapacity = b;
	}
	public void setBookCapacity(int b){
		bookCapacity = b;
	}
	public int getBookCapacity(){
		return bookCapacity;
	}
}
