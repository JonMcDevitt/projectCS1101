import java.util.ArrayList;
public class Sections {
	private ArrayList<String> genre;
	
	public Sections(){
		
	}
	public Sections(ArrayList<String> genre){
		this.genre = genre;
	}
	public void setgenre(ArrayList<String> s){
		genre = s;
	}
	public String getgenre(){
		return genre.toString();
	}
}
