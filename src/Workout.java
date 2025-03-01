import java.util.LinkedList;

public class Workout {
	public static LinkedList<ListNode> collection;
	public String name;
	public static ListNode front;

	public Workout() {
		//collection = new LinkedList<ListNode>();
		front = null;
		//front = new ListNode();
	}
	
	public static void addExercise(ListNode e) {
	    if(front == null){
	    	//e.setNext(front);
	    	front = e;
	    	e.setNext(null);
		}
	    else {
	    ListNode temp = new ListNode();
		temp = front;
	    while (temp.getNext() != null) {
			temp = temp.getNext();
			//System.out.println(temp.getName());
		}
		temp.setNext(e);
		//front = temp;
		//System.out.println(front.getName());
	    }
	    }
	
	public static void setName(String s) {
		ListNode temp = new ListNode(s, front);
		front = temp;
	}
	public static String getExercise(int c) {
		ListNode temp = new ListNode();
		temp = front;
	    for (int i = 0; i < c; i++) {
	      temp = temp.getNext();
	    }
	    String output = temp.getName() + ": " + temp.getDesc() + " " + temp.getReps();
		return output;
	}
	public static String get(int c) {
		ListNode temp = new ListNode();
		temp = front;
	    for (int i = 0; i < c; i++) {
	      temp = temp.getNext();
	    }
		return temp.getName();
	}
	public static String getName() {
		return front.getName();
	}
	public static int getSize() {
		int count = 0;
		ListNode temp = new ListNode();
		temp = front;
		while (temp.getNext() != null) {
			temp = temp.getNext();
			count ++;
		}
		return count;
	}
	
	public String toString() {
		String output = "";
		ListNode temp = new ListNode();
		temp = front;
	    while (temp != null){
	      output += ","+temp.getName() + ","+temp.getReps();
	      temp = temp.getNext();
	    }
			return output;
	}
}
