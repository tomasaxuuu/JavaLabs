public class Node {
	public String Name;
	public String lastName;
	public String middleName;
	public String gender;
	public Node next;
	public Node prev;
	
	public Node (String lastName, String Name, String middleName, String gender) {
		this.lastName = lastName;
        this.Name = Name;
        this.middleName = middleName;
        this.gender = gender;
	}
}
