import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhysicalTherapist extends Person{

	String name, password;
	Scanner keyboard = new Scanner(System.in);
	int id;
	File file = new File("src/users.txt");
	ArrayList<String> allPatients = new ArrayList<String>();
	String exercises = "";
	//Map<String, int[]> completed = new TreeMap<String, int[]> ();
	
	public PhysicalTherapist() {
		name = "";
		password  = "";
		id = 0;
	}
	public PhysicalTherapist(String n, String p) {
		name = n;
		password = p;
		id = 0;
	}
	public ArrayList<String> getPatients(){
		return allPatients;
	}
	public String getExercises(){
		return exercises;
	}
	public void addWorkout(String s, ArrayList<String> p) throws IOException{
		//Exercise t = new Exercise();
		//t.toString();
		exercises = s;
		allPatients = p;
		BufferedReader br = new BufferedReader(new FileReader(file));

		//Workout w = new Workout();
		//System.out.println("Who would you like to assign? Here are the available patients: " + p);
		//String patient = keyboard.nextLine();

		//System.out.println("Here are the available exercises: "+ s);
		//System.out.println("How many exercises would you like to add to the workout?");
	/*	int count = keyboard.nextInt();
		for (int i = 1; i < count+1; i++) {
			System.out.println("What is the #" +i+ " exercise you would like to add?");
			keyboard.nextLine();
			String e = keyboard.nextLine();
			System.out.println("How many reps do you want to assign?");
			int r = keyboard.nextInt();
			ListNode n = new ListNode(e, r+"");
			//System.out.println(n.toString() + " " + n.getName());
			w.addExercise(n);
		}
		System.out.println("What is the intensity of this workout?");
		int intensity = keyboard.nextInt();

		String line;
		while ((line = br.readLine()) != null) {
			String[] e = line.split(",");
			if (e[0].equals(patient)){
				System.out.println("available");
				File f = new File ("src/premade.csv");
				FileWriter fWriter = new FileWriter(f, true);
		        fWriter.write("\n"+patient + "*,"+intensity+"," +w.getSize() +w.toString()); //change patient to id later
		        //make intensity calculator maybe
		        fWriter.close();
			}
		}
		
		//toString();
		System.out.println("Completed!");
		//System.out.println(w.toString());

*/
	}
	public void subWorkout(String pa, int in, Workout w) throws IOException{
		String line;
		String []par = pa.split(": ");
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((line = br.readLine()) != null) {
			String[] g = line.split(",");
			if (g[0].equals(par[0])){
				//System.out.println("available");
				File f = new File ("src/premade.csv");
				FileWriter fWriter = new FileWriter(f, true);
		        fWriter.write("\n"+pa +in+"," +w.getSize() +w.toString()); //change 1 to actual intensity
		        //make intensity calculator maybe
		        fWriter.close();
			}
		}
	}

}
