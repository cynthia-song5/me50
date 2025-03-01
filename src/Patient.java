import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Patient extends Person {

	String name, password, id;
	int line = 0;
	int completedCount = 0;
	int intensity;
	public Map<String, int[]> completed = new TreeMap<String, int[]> ();
	public ArrayList<String[]> completed1 = new ArrayList<String[]> ();

	public ArrayList<String[]> completed2 = new ArrayList<String[]> ();
	//maybe a queue instead?
	public Patient() {
		name = "";
		password  = "";
		intensity = 0;
		id = "0";
	}
	public Patient(String n, String p, int i) {
		name = n;
		password = p;
		intensity = i;
		id = n;
		
	}
	public Patient(String n, String p) {
		name = n;
		password = p;
		id = n;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public int getIntensity() {
		return intensity;
	}
	public void setIntensity(int i) {
		intensity = i;
	}
	public int getLine() {
		return line;
	}
	public void setCompleted(int c) {
		completedCount = c;
	}
	public int getCompleted() {
		return completedCount;
	}
	public void setRating(String w, int e, int d) {
		int[] r = new int[] {e, d};
		completed.put(w, r);
		String[] all = new String[] {w, ""+e, ""+d};
		completed1.add(all);
	}
	
	public String getNewRatings1() {
		String total = "";
		for (int i = 0; i < completed1.size(); i++) {
			total += Arrays.toString(completed1.get(i));
		}
		return total;
	}
	public String getNewRatings() { //prob getting stuck here
		//System.out.println("Map = "+completed);
	      Set keys = completed.keySet();
	      //Iterator i = keys.iterator();
	        Iterator i = completed.entrySet().iterator();

	      Collection getValues = completed.values();

	      String total = "";
	     // int count = 0;
	      while (i.hasNext()) {
	         //total += ";"+i.next() + "=" + Arrays.toString(completed.get(i.next()));
	        // count ++;
	      }
//	     String value = "";
//	      i = getValues.iterator();
//	      while (i.hasNext()) {
//	         value += i.next().toString() + " ";
//	      }
	     // String total = "";
	     // String[] list1 = key.split(" ");
	     // String[] list2 = value.split(" ");

//	      for (int j = 0; j < count; j++) {
//	    	  total += ";" + list1[j] +"=" +list2[j];
//	      }
	      Map.Entry mapElement = (Map.Entry)i.next();

      // Printing mark corresponding to string entries
      total += mapElement.getKey() + "=" + Arrays.toString((Object[]) mapElement.getValue());
      
      
      
	      System.out.println ("total:" + total);
		return total;
	}
	/*public void setCompleted(String w, String e, String d) {
		String[] all = new String[] {w, e, d};
		completed2.add(all);
	}
	public String getPrevCompleted() {
		String total = "";
		for (int i = 0; i < completed1.size(); i++) {
			total += Arrays.toString(completed1.get(i));
		}
		//System.out.println("TOTAL"+ total);
		return total;
	}*/
}
