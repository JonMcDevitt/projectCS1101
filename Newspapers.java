import java.util.ArrayList;
public class Newspapers {
	private String company;
	private String paperDate;
	private String newsDate;
	private ArrayList <String> journalists;
	
	public Newspapers(){
		journalists = new ArrayList <String>();
	}
	public Newspapers(String c, String p, String n){
		company = c;
		paperDate = p;
		newsDate = n;
		journalists = new ArrayList <String>();
	}
	public void setCompany(String c){
		company = c;
	}
	public void setPaperDate(String p){
		paperDate = p;
	}
	public void setNewsDate(String n){
		newsDate = n;
	}
	public void addJournalist(String j){
		journalists.add(j);
	}
	public String getCompany(){
		return company;
	}
	public String getPaperDate(){
		return paperDate;
	}
	public String getNewsDate(){
		return newsDate;
	}
	public String getJournalist(int index){
		if (journalists.isEmpty()){
			return "No journalists are listed.";
		}
		else{
			return journalists.get(index);
		}
	}
	public String getAllJournalists(){
		if (journalists.isEmpty()){
			return "No journalists are listed.";
		}
		else{
			return journalists.toString();
		}
	}
	public String toString(){
		return company + "\nDate: " + paperDate; 
	}
}
