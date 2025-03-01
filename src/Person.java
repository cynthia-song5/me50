
public class Person {

	public String name;
	public String password;
	public String id;
	
	public Person() {
		name = "";
		password = "";
		id = "";
	}
	public Person (String n, String p, String i) {
		name = n;
		password = p;
		id = i;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
}
