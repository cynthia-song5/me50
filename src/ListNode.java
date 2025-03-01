
public class ListNode {
	private String name, desc, image;
    private String reps;
    private ListNode next;
    
    public ListNode() {
    	next = null;
    }
    
    public ListNode (String s, ListNode n) {
    	name = s;
    	next = n;
    }
    public ListNode (String s, String n) {
    	name = s;
    	reps = n;
    }
    public ListNode(String a, String d, String i) //exercise name, description, image rep #, --> next
    {
        name = a;
        desc = d;
        image = i;
        next = null;
    }
    public ListNode(String a, String d, String r, String i) //exercise name, description, image rep #, --> next
    {
        name = a;
        desc = d;
        image = i;
        reps = r;
        next = null;
    }
    public void setNext(ListNode a) {
    	next = a;
    }
    /*public void set(String a, String d, String r, String i) {
    	name = a;
        desc = d;
        image = i;
        reps = r;
        next = null;
    }*/
    public String getName() {
    	return name;
    }
    public String getDesc() {
    	return desc;
    }
    public String getImage() {
    	return image;
    }
    public String getReps() {
    	return reps;
    }
    public ListNode getNext() {
    	return next;
    }
}
