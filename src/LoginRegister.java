import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginRegister{
	static Exercise ex;
	static String type = "";
	static String input = "";
	static boolean a = false;
	static JLabel panel;
	static JFrame frame;
	//Scanner fileIn = new Scanner(new File(file));
	//PrintWriter fileOut = new PrintWriter(file);
	//BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    //FileReader fr = new FileReader(file);
	//FileWriter writer = new FileWriter(file);
	Scanner keyboard = new Scanner(System.in);
	File file = new File("src/users.txt");
	PrintWriter out1 = new PrintWriter(new FileWriter(file, true));
	BufferedReader br = new BufferedReader(new FileReader(file));
	boolean pt = false;
	File database = null;

	public LoginRegister() throws IOException {
		/* ORIGINAL CODE <3
		System.out.println ("Login or Register: ");
		String input = keyboard.next();
		if (input.equals("r")) {
			Register();
		}
		if (input.equals("l")) {
			Login();
		}
        */
		ex = new Exercise();
	}
		public PhysicalTherapist RegisterPT (String name, String password) throws IOException {
			FileWriter fWriter;
				 fWriter = new FileWriter("src/pt.txt", true);
				 fWriter.write("\n"+name + "," + password);
		         fWriter.close();
		         PhysicalTherapist v;
		         try (Scanner scanner = new Scanner(file)) {
		         	ArrayList<String> available = new ArrayList<String>();
		             String line;
		             //boolean hasNextLine = false;
		             while (scanner.hasNextLine()) {
		             	line = scanner.nextLine();
		                 String[] e = line.split(",");
		         		available.add(e[0]);		   
		             }
		              v = new PhysicalTherapist(name, password);
	         			v.addWorkout(ex.toString(), available);
		         }
	         return v;
		}
		public void RegisterP (String name, String password, int intensity) throws IOException {
			FileWriter fWriter;
			try (Scanner scanner = new Scanner("src/users.txt")) {
				int c = 0;
				String line;
	             //boolean hasNextLine = false;
	             while (scanner.hasNextLine()) {
	             	line = scanner.nextLine();
	             	c++;
	             }
			 fWriter = new FileWriter("src/users.txt", true);
			 fWriter.write("\n"+name + "," + password + "," + intensity);
	         fWriter.close();
		}
	}

	public void Register(String type, String name, String password, int intensity) throws IOException {
	
		if (type.equals("p")) {
		}
		if (type.equals("pt")) {
			database = new File("src/pt.txt");
			pt = true;
		}
		
		out1.println(name + "," + password +","+intensity + "\n");
			
	        //out1.append(name + "," + password + "," + intensity+"\n");
			FileWriter fWriter;
			if (pt == true) {
				 fWriter = new FileWriter("src/pt.txt", true);
				 fWriter.write(name + "," + password + "," + intensity+"\n");
		         fWriter.close();
				 
		         try (Scanner scanner = new Scanner(file)) {
		         	ArrayList<String> available = new ArrayList<String>();
		             String line;
		             //boolean hasNextLine = false;
		             while (scanner.hasNextLine()) {
		             	line = scanner.nextLine();
		                 String[] e = line.split(",");
		         		available.add(e[0]);		   
		             }
		             PhysicalTherapist v = new PhysicalTherapist(name, password);
	         			v.addWorkout(ex.toString(), available);
		           }
		         }
			
			else {
				try (Scanner scanner = new Scanner("src/users.txt")) {
					int c = 0;
					String line;
		             //boolean hasNextLine = false;
		             while (scanner.hasNextLine()) {
		             	line = scanner.nextLine();
		             	c++;
		             }
				 fWriter = new FileWriter("src/users.txt", true);
				 fWriter.write("\n"+name + "," + password + "," + intensity);
		         fWriter.close();
		         //Patient neu = new Patient (name, password, intensity, c);
		         //PHome n = new PHome(neu);
		         //moved to GUI
			}
	 
	            
	          
	
		}}
	//login vs
	public Patient LoginP(String type, String name, String password) throws IOException {

		String line;
		Scanner s = new Scanner(file);  
		int c = 0;
		Patient neu = null;
		boolean inDatabase = false;

		while(s.hasNextLine()) {
		line = s.nextLine();
		c++;
		String[] e = line.split(",");
		if (e[0].equals(name) && e[1].equals(password)){
	        neu = new Patient (name, password, Integer.parseInt(e[2]));
	        inDatabase = true;
	        if (e.length == 4) {
	        	neu.setCompleted(Integer.parseInt(e[3]));
	        }
		}}
		if (inDatabase == false) {
			return null;
		}
		return neu;
	}
	public PhysicalTherapist LoginPT(String type, String name, String password) throws IOException {
		database = new File("src/pt.txt");
		pt = true;
	    PhysicalTherapist v = null;
	
	    try (Scanner scanner = new Scanner(file)) {
	    ArrayList<String> available = new ArrayList<String>();
	    String line;
	    while (scanner.hasNextLine()) {
	    	line = scanner.nextLine();
	    	String[] e = line.split(",");
	    	available.add(e[0]);
	    }
	    Scanner s = new Scanner(database);  
    	while(s.hasNextLine()) {
    	line = s.nextLine();
    	String[] e = line.split(",");
		if (e[0].equals(name) && e[1].equals(password)){
			v = new PhysicalTherapist(name, password);
			v.addWorkout(ex.toString(), available);
		}
    	}
	    }
	    return v;
	}

	public void Login(String type, String name, String password) throws IOException {
		if (type.equals("p")) {
		}
		if (type.equals("pt")) {
			database = new File("src/pt.txt");
			pt = true;
		}
		
if (pt == true) {
	
try (Scanner scanner = new Scanner(file)) {
	ArrayList<String> available = new ArrayList<String>();
    String line;
    //boolean hasNextLine = false;
    while (scanner.hasNextLine()) {
    	line = scanner.nextLine();
        String[] e = line.split(",");
		available.add(e[0]);
    }
    Scanner s = new Scanner(database);  
    	while(s.hasNextLine()) {
      line = s.nextLine();
      String[] e = line.split(",");
		//System.out.println(e[0]+e[1]);
		if (e[0].equals(name) && e[1].equals(password)){
			//System.out.println("Login Successful!");
			PhysicalTherapist v = new PhysicalTherapist(name, password);
			v.addWorkout(ex.toString(), available);
     // System.out.println(line);
    }
  }
}
}
else {
	String line;
	Scanner s = new Scanner(file);  
	int c = 0;
	while(s.hasNextLine()) {
  line = s.nextLine();
  c ++;
  String[] e = line.split(",");
	//System.out.println(e[0]+e[1]);
	if (e[0].equals(name) && e[1].equals(password)){
		//System.out.println("Login Successful!");
        Patient neu = new Patient (name, password, Integer.parseInt(e[2]));
        PHome n = new PHome(neu);
}
}
	}
	}
	
}
