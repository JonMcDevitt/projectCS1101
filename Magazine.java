import java.util.ArrayList;

public class Magazine {
	private int ISBN;
	private String title;
	private int issue;
	private String language; // enum???
	private ArrayList<String> contributingWriters; // ArrayList??
	public enum Languages{english, portuguese, chinese, french};
	public Languages lang;
	
	public Magazine()
	{
		
	}
	
	public Magazine(int ISBN, String title, int issue, String language, ArrayList<String> contributingWriters)
	{
		this.ISBN = ISBN;
		this.title = title;
		this.issue = issue;
		this.language = language;
		this.contributingWriters = contributingWriters; // deep or shallow copy?
	}
	
	public void setISBN(int ISBN)
	{
		this.ISBN = ISBN;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setIssue(int issue)
	{
		this.issue = issue;
	}
	
	public void setLanguage(String language)
	{
		this.language = language;
	}
	
	public void setContributingWriters(ArrayList<String> contributingWriters)
	{
		this.contributingWriters = contributingWriters;
	}
	
	public int getISBN()
	{
		return ISBN;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public int getIssue()
	{
		return issue;
	}
	
	public String getLanguage()
	{
		return language;
	}
	
	public ArrayList<String> getContributingWriters()
	{
		return contributingWriters;
	}
}
