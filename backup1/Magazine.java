import java.util.ArrayList;

public class Magazine {
	private String ISBN;
	private String title;
	private String issue;
	private String language; 
	private ArrayList<String> contributingWriters; 

	public Magazine()
	{

	}

	public Magazine(String ISBN, String title, String issue, String language, ArrayList<String> contributingWriters)
	{
		this.ISBN = ISBN;
		this.title = title;
		this.issue = issue;
		this.language = language;
		this.contributingWriters = contributingWriters;
	}

	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setIssue(String issue)
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

	public String getISBN()
	{
		return ISBN;
	}

	public String getTitle()
	{
		return title;
	}

	public String getIssue()
	{
		return issue;
	}

	public String getLanguage()
	{
		return language;
	}

	public String getContributingWriters()
	{
		return contributingWriters.toString();
	}
}