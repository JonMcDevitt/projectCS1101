
public class Reservation {
	private String dateReserved;
	private String dateDue;
	
	public Reservation(){
		
	}
	public Reservation(String d1, String d2){
		dateReserved = d1;
		dateDue = d2;
	}
	public void setDateReserved(String dateReserved){
		this.dateReserved = dateReserved;
	}
	public void setDateDue(String dateDue){
		this.dateDue = dateDue;
	}
	public String getDateReserved(){
		return dateReserved;
	}
	public String getDateDue(){
		return dateDue;
	}
}
