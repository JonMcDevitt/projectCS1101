import java.util.ArrayList;
public class Journals_Anthologies {
	
	private String volume;
	private String issue;
	private String editor;
	private String title;
	private ArrayList<String> contributor;
	
	public Journals_Anthologies()
	{
		
	}
	public Journals_Anthologies(String volume, String issue, String editor, String title, ArrayList<String> contributor){
		this.volume = volume;
		this.issue = issue;
		this.editor = editor;
		this.title = title;
		this.contributor = contributor;
	}
	
	//set block
	public void setVolume(String v)
	{
		volume = v;
	}
	public void setIssue(String i)
	{
		issue = i;
	}
	public void setEditor(String e)
	{
		editor = e;
	}
	public void setTitle(String t)
	{
		title = t;
	}
	public void setContributor(ArrayList<String> c)
	{
		contributor = c;
	}
	
	//get block
	public String getVolue()
	{
		return volume;
	}
	public String getIssue()
	{
		return issue;
	}
	public String getEditor()
	{
		return editor;
	}
	public String getTitle()
	{
		return title;
	}
	public String getContributor()
	{
		return contributor.toString();
	}

}
