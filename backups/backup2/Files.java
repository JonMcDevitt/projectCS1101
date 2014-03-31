import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Files 
{
	public ArrayList<Book> loadBooks()
	{
		ArrayList<Book> books = new ArrayList<Book>();
		BufferedReader br = null;
		 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("D:/Dropbox/@Dalhousie/1st semester/Computer Science II/project/LibraryManagementSystem/src/books.b"));
			//br = new BufferedReader(new FileReader("books.txt"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				if(sCurrentLine.equals("#"))
				{
					String[] temp = new String[6];
					for(int i = 0; i < 6; i++)
					{
						temp[i] = br.readLine();
					}
					books.add(new Book(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
				{
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return books;
	}
}
