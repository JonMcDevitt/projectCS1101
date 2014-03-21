import java.util.ArrayList;
public class LibraryDemo 
{
	public static void main(String[] args)
	{
		SystemManager sys = new SystemManager(new Library());
		
		ArrayList<GeneralUser> a = new ArrayList<GeneralUser>();
		
		GeneralUser b, c, d;
		
		b = new GeneralUser("B", "B", "B");
		c = new GeneralUser("C", "C", "C");
		
		a.add(b);
		a.add(c);
		
		d = b;
		
		System.out.println("" + a.get(0).getName());
		d.setName("d");
		System.out.println("" + a.get(0).getName());
		d = null;
		System.out.println("" + a.get(0).getName());
		//System.out.println("" + d.getName());
	}
}
