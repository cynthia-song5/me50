import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Exercise {
	   //private ListNode front;

	protected static Map<String, String[]> exercises;
	public static LinkedList<ListNode> e;
	public Exercise() throws IOException
	{
	    exercises = new TreeMap<String, String []>();
	    e = new LinkedList<ListNode>();
		String line = "";  
	
    File f = new File ("src/w.csv");
	BufferedReader br = new BufferedReader(new FileReader(f));  
	while ((line = br.readLine()) != null)   
	{
		String[] eInfo = line.split(",");    
		String[] desc = new String[]{eInfo[1], eInfo[2]};
		ListNode neu = new ListNode(eInfo[0], eInfo[1], eInfo[2]);
		e.add(neu);
		exercises.put(eInfo[0], desc);
	}
	String listOfExercises = "";
	for (Map.Entry<String, String[]> entry : exercises.entrySet()) {
		listOfExercises += entry.getKey() + ", ";
	}

	}

	
	public boolean contains (String s) {
		for (int i = 0; i < e.size(); i++) {
			//System.out.println(e.get(i).getName());
			//System.out.println("j" + s);
			if (e.get(i).getName().equals(s)) {
				
				return true;
			}
		}
		if (exercises.containsValue(s)) {
			return true;
		}
		return false;
	}
	
	public String getDesc (String s) {
		return exercises.get(s)[0];
	}
	public String getImage (String s) {
		return exercises.get(s)[1];
	}
	public String toString() {
		String listOfExercises = "";
		for (Map.Entry<String, String[]> entry : exercises.entrySet()) {
			listOfExercises += entry.getKey() + ", ";
		     //System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
		}
		//System.out.println(listOfExercises);
		return listOfExercises;
	}

}

