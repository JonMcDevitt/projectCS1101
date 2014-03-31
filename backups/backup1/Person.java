
public abstract class Person {
	private String name;
	private String country;
	private String provinceState;
	private String city;
	
	public Person(){
		
	}
	public Person(String name, String country, String provinceState, String city){
		this.name = name;
		this.country = country;
		this.provinceState = provinceState;
		this.city = city;
	}
	public void setName(String n){
		name = n;
	}
	public void setCountry(String c){
		country = c;
	}
	public void setProvinceState(String ps){
		provinceState = ps;
	}
	public void setCity(String c){
		city = c;
	}
	public String getName(){
		return name;
	}
}
