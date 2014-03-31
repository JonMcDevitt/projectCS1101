
public class Test {
	public static void main(String[] args){
		User al = new User("Al", "A1i3n", "Random");
		Book Teri = new Book("123-456-789-1234", "Random author", "Bridge to Teribithia", "3rd", "Fantasy", "English");
		Newspapers news = new Newspapers("Chronicle", "02/02/02", "01/02/02");
		al.reserveItem(Teri);
		al.reserveitem(news);
		al.printReservationList();
	}
}
