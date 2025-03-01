import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.sound.midi.SysexMessage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PHome extends Exercise{
	File f = new File ("src/premade.csv");
	BufferedReader br = new BufferedReader(new FileReader(f)); 
	ArrayList<Workout> intensityvs = new ArrayList<Workout>();
	ArrayList<String> vs = new ArrayList<String>();
	ArrayList<String> re = new ArrayList<String>();
	ArrayList<String> fi = new ArrayList<String>();

	ArrayList<Integer> vsCount = new ArrayList<Integer>();

	Patient P = new Patient();
	private JFrame frame;
	private  JLabel wIcon;
	private boolean hard = false;
	public PHome(Patient p) throws NumberFormatException, IOException {
	
		
	//System.out.println("Welcome Home!");
		String line;  
		String splitBy = ",";  
	P = p;
	Scanner keyboard = new Scanner(System.in);

	//System.out.print("Workouts Based on Your Intensity Level: ");
	//ArrayList<Workout> intensityvs = new ArrayList<Workout>();
	String desc;
	String img;
	int count = 0;
	while ((line = br.readLine()) != null)   //returns a Boolean value  
	{
		count ++;
		//System.out.println(count);
		String[] employee = line.split(","); 
		//System.out.println (employee.length); 
		//test.putEntry(employee[0], employee[1], employee[2]);
		String i = employee[2];
		boolean level = false;
		String empl [] = employee[0].split(": ");
		//System.out.println(empl[0]);
		if (empl[0].equals(P.getId())) {
		
		//	System.out.print("\nWorkouts Recommended By Your Physical Therapist: ");
			re.add(employee[0]);
			vs.add(employee[0]);
		//	System.out.print(employee[0]+", ");
			//System.out.println("Workouts Based on Your Intensity Level: ");
			vsCount.add(count);

		}
		else {
		if (i.equals((int)p.getIntensity()+"")) {
			//if (!employee[0].contains("*")) {
		//	System.out.print(employee[0]+", ");
			level = true;
			vs.add(employee[0]);
			vsCount.add(count);
			//}
		}}
		/*if (employee.length > 5 && level == true) {
			ne = new Workout();
			Workout ge = new Workout();
//problem was with the first line!!
		for (int j = 3; j < employee.length; j+=2) {
			//System.out.println(employee[j] + employee[j+1]);
			if (employee[j]!= null && super.contains(employee[j])) {
				//System.out.println("e");

				desc = (String)super.getDesc(employee[j]);
				img = (String)super.getImage(employee[j]);
				//intensityvs.add(employee[0]);
				ListNode neu = new ListNode(employee[j], desc, employee[j+1], img);
				//System.out.println(neu.toString());
//		neu.setNext(null);
				ne.addExercise(neu);
			}
		}		ne.setName(employee[0]);
		

		//ListNode neu = new ListNode(employee[0], employee[1], employee[2]);
	    //intensityvs.add(neu);
		ge = ne;
		String s = ne.toString();
		
		intensityvs.add(ge);
		vs.add(s);
		//databaseI(ne);
		System.out.println(ne.toString());
		level = false;
		}//add scanner}
		*/
		
		
}
	
	//System.out.println(vs.toString());
	//System.out.println(vsCount.toString());

	//System.out.println("\nRecommended Exercises:");
	//workoutMode(vs, vsCount);
	//if (intensityvs != null) {
		//System.out.print("workouts: ");

	//	for (int i = 0; i < intensityvs.size(); i++) {
		
	//System.out.print(intensityvs.get(i).toString() + "_");
		}
		//workoutMode(intensityvs);
		//}
		//intensityvs.clear();
public int check() {
	int i = P.getCompleted();
	if (i % 30 == 0) {
		i = i/30;
		return i;
	}
	else {
		return 0;
	}
	/*
	if (P.getCompleted() >= 30) {
		//String rr = P.getPrevCompleted();
		return 1;
			/*P.setIntensity(P.getIntensity() + 0.1);
			System.out.println("\nCongrats! You've completed" + P.getCompleted() +" workouts! Would you like to increase your intensity level?");
			//String dec = keyboard.next();
			if (dec.equals("y")) {
				System.out.println("\nYour workouts will now have 1 extra rep!");
				hard = true;
			}
	}
	if (P.getCompleted() >= 60) {
		return 2;
	}
	else {
		return 0;
	}
	*/
}
	//System.out.println (exercises.toString()); 
	//System.out.println ("vs"+vs.toString());  //OMG I SAVED HELL YEAH}
	public void Home(Patient p) throws IOException{
		
		br.close();
	    br = new BufferedReader(new FileReader(f));	
		//System.out.println("Welcome Home!");
		String line;  
		String splitBy = ",";  
	P = p;
	vs = new ArrayList<String>();
	re = new ArrayList<String>();
	fi = new ArrayList<String>();
	String desc;
	String img;
	int count = 0;
	while ((line = br.readLine()) != null)    
	{
		count ++;
		String[] workoutInfo = line.split(","); 
		String i = workoutInfo[2];
		boolean level = false;
		String fWorkoutInfo [] = workoutInfo[0].split(": ");
		//recommeded by physical therapist
		if (fWorkoutInfo[0].equals(P.getId())) {
			re.add(workoutInfo[0]);
			vs.add(workoutInfo[0]);
			vsCount.add(count);

		}
		//completed workouts
		else if (workoutInfo[0].contains("Completed:")) {
			//System.out.println("\nRecently Completed Workouts:");
			String[] g = line.split(";"); 
				for (int n = 1; n < g.length; n+=2) {
					fi.add(g[n]);
					vs.add(g[n]);
				}
			vsCount.add(count);
		}
		//intensity workouts
		else {
		if (i.equals((int)p.getIntensity()+"")) {
			if (!workoutInfo[0].contains("*")) {
			level = true;
			vs.add(workoutInfo[0]);
			vsCount.add(count);
			}
		}}
		/*if (employee.length > 5 && level == true) {
			ne = new Workout();
			Workout ge = new Workout();
//problem was with the first line!!
		for (int j = 3; j < employee.length; j+=2) {
			//System.out.println(employee[j] + employee[j+1]);
			if (employee[j]!= null && super.contains(employee[j])) {
				//System.out.println("e");

				desc = (String)super.getDesc(employee[j]);
				img = (String)super.getImage(employee[j]);
				//intensityvs.add(employee[0]);
				ListNode neu = new ListNode(employee[j], desc, employee[j+1], img);
				//System.out.println(neu.toString());
//		neu.setNext(null);
				ne.addExercise(neu);
			}
		}		ne.setName(employee[0]);
		

		//ListNode neu = new ListNode(employee[0], employee[1], employee[2]);
	    //intensityvs.add(neu);
		ge = ne;
		String s = ne.toString();
		
		intensityvs.add(ge);
		vs.add(s);
		//databaseI(ne);
		System.out.println(ne.toString());
		level = false;
		}//add scanner}
		*/
		
		
}
	//System.out.println(vs.toString());
	//System.out.println(vsCount.toString());

	//workoutMode(vs, vsCount);
	}
	public int getExerciseCount (){
		int count = 0;
		for (int i = 0; i < vsCount.size(); i++) {
			count ++;
		}
		return count;
	}
	public String getIntensityExercises(){
		String workouts = "";
		for (int i = 0; i < vs.size(); i++) {
			if (!vs.get(i).contains(P.getId())) {
				workouts += vs.get(i)+",";
			}
		}
		return workouts;
	}
	public String getRecommendedExercises() {
		String workouts = "";
		for (int i = 0; i < re.size(); i++) {
			workouts += re.get(i)+",";
		}
		return workouts;
	}
	public String getCompletedExercises (){
		String workouts = "";
		for (int i = 0; i < fi.size(); i++) {
			workouts += fi.get(i)+",";
		}
		return workouts;
	}
	
	public void workoutMode(ArrayList<String> i, ArrayList<Integer> c) throws IOException {
		//System.out.println (i.toString()); 
		Scanner keyboard = new Scanner(System.in);
		//System.out.println ("\nChoose a Workout"); 
		
		String workout = keyboard.next();
		boolean completed = false;
		/*frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,500);
		frame.setVisible(true);*/
		
		for (int j = 0; j < i.size(); j++) { //i = 0 booo
			if (workout.equals(i.get(j))) {
				Workout ne = new Workout();
				int count = 0;
				try {
					br.close();
				    br = new BufferedReader(new FileReader(f));					
				    for(int k = 0; k < c.get(j)-1; k++) {
						br.readLine();
					} 
					String lineIWant = br.readLine();
					if (lineIWant.contains("Completed:")) {
						completed = true;
					}
					String[] employee = lineIWant.split(","); 
					//System.out.println(Arrays.toString(employee));
				    //count = (employee.length-3)/2;
					//System.out.println(employee[0] + employee[1] + employee[2] +employee[3] + employee[4]);
					for (int n = 3; n < employee.length; n+=2) {
						//System.out.println(employee[j] + employee[j+1]);
						//System.out.println(employee[j]);
						if (employee[n]!= null && super.contains(employee[n])) { //Problem 		//SUPER.CONTAINS --> CAST AS LOWERCASE (ADD LATER!!!!!)

//System.out.println("e[n]"+employee[n]);
							String desc = (String)super.getDesc(employee[n]);
							String img = (String)super.getImage(employee[n]);
							//intensityvs.add(employee[0]);
							ListNode neu = new ListNode(employee[n], desc, employee[n+1], img); //+1
							//System.out.println(neu.toString());
//					neu.setNext(null);
							ne.addExercise(neu);
							count++;
						}
					}		
					ne.setName(employee[0]);
					//System.out.println(ne.toString());

				}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//System.out.println("Beginning Workout. Press any key & enter to go on to the next exercise");					
				//System.out.println(ne.toString());	

				for (int h = 1; h < count+1; h++) {
				//	System.out.println(ne.getExercise(h));	
					 try
					    {	
						 //do the splitting thing
						 String p = ne.get(h);
						 p = p.toLowerCase();
					     p = p.replaceAll("\\s", "");
 						 BufferedImage pic = ImageIO.read((new File("src/"+p+".png")));//src/cafe_winterscene_prev_ui.png

 						 JLabel label = new JLabel (ne.getExercise(h));
 						label.setBounds(10, 20, 1000, 25);
 						frame.add(label);
 						
						   wIcon = new JLabel();
						   wIcon.setBounds(25,25,100,100);
						   wIcon.setIcon(new ImageIcon(pic));
						    //System.out.println("success");
					       frame.getContentPane().add(wIcon);
						   frame.setVisible(true);
					    }
					 catch (IOException e)
					   	{
							e.printStackTrace();
					    }

					//System.out.println(ne.get(h).getImage());	

					//ImageIcon icon = new ImageIcon(ne.get(h).getImage());
					//JLabel label = new JLabel(icon);
					//frame.add(label);
					String n = keyboard.next();
				}
			//	System.out.println("Workout Complete! Good Job!");
			//	System.out.print ("Rate the Workout on Enjoyment (1-5):");
				int enjoy = keyboard.nextInt();
			//	System.out.print("Rate the Workout on Difficulty (1-5):");
				int diff = keyboard.nextInt();
				//int[] r = new int[] {enjoy, diff};
				P.setRating(i.get(j), enjoy, diff);
			//	System.out.println( "Would you like to do another workout/go to the main page or exit?");
				String cont = keyboard.next();
				if (cont.equals("y")) {
					Home(P);
				}
				else {
					System.out.println("yes");
					//j = i.size() + 10;
					workout = "";
					//welp gotta create a temporary file :')
					 try {

				            File file = File.createTempFile("abc", ".txt");
				            File p = new File("src/users.txt");
				            //BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				            //System.out.println(file)
				            //BufferedReader br = new BufferedReader(new FileReader(p));
					 		FileWriter fWriter = new FileWriter(file, true);

				            try (Scanner scanner = new Scanner(p)) {
								String line;
					             boolean cont1 = true;
					             while (scanner.hasNextLine()) {
					            	 line = scanner.nextLine(); //&& cont == true

					            	 if (hard = true && line.contains(P.getId())) {
					            		 fWriter.write(P.getId() +","+ P.getIntensity() +"," + P.getPassword());
					            	 }
					            	 else {
										fWriter.write(line);
					            	 }

					            	 if (line.contains(P.getId())) {
					             		//cont1 = false;
					             		if (!completed) {
											fWriter.write(",Completed:" + P.getNewRatings()); //writes to end oopsies
										}
										else{
											fWriter.write(P.getNewRatings());
										}
					             	}
										//fWriter.write(P.getNewRatings());

					             }    
					         fWriter.close();
				            }
					       //maybe rewrite every line ick
					         fWriter = new FileWriter(p, false);
					         try (Scanner s = new Scanner(file)) {
									String lines;
						             while (s.hasNextLine()) {
						            	 lines = s.nextLine();
											fWriter.write(lines);
						             }
						     }
					         fWriter.close();

					         // writes few lines
				           
				            

				        } catch (IOException e) {
				            e.printStackTrace();
				        }
					//File file = File.createTempFile("temp", ".txt", new File("/Users/me/Desktop/Folder/"));
				 
				        // Printing the path of the directory where the file
				        // is created
				        //System.out.println(file.getAbsolutePath());
				        //System.out.print(/Users/mayanksolanki/Desktop/Folder/);
				 
				        // Deleting the file while exiting the program
				        //file.deleteOnExit();
					
					
					/*FileWriter fWriter = new FileWriter("src/users.txt", true);
					if (!completed) {
						fWriter.write(",Completed:" + P.getNewRatings()); //writes to end oopsies
					}
					else{
						fWriter.write(P.getNewRatings());
					}
			        fWriter.close(); */
				}

			}}
		
	}
	
	
	
	public String workoutMode(String s) throws IOException { //RETURN THINGS SO THEY CAN BE DISPLAYED ON GUI??
		//System.out.println (i.toString()); 
	
		/*frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,500);
		frame.setVisible(true);*/
		boolean completed = false;
				Workout ne = new Workout();
				int count = 0;
				try {
					br.close();
				    br = new BufferedReader(new FileReader(f));	
				    String lineIWant = br.readLine();
					String[] employee = lineIWant.split(","); 
				    while (!(employee[0]).equals(s)) { //doesn't acocunt for completed though...
				    	lineIWant = br.readLine();
				    	employee = lineIWant.split(","); 
					} 
					if (lineIWant.contains("Completed:")) {
						completed = true;
					}
				//	System.out.println(Arrays.toString(employee));
				    //count = (employee.length-3)/2;
					//System.out.println(employee[0] + employee[1] + employee[2] +employee[3] + employee[4]);
					for (int n = 3; n < employee.length; n+=2) {
						//System.out.println(employee[j] + employee[j+1]);
						//System.out.println(employee[j]);
						if (employee[n]!= null && super.contains(employee[n])) { //Problem 		//SUPER.CONTAINS --> CAST AS LOWERCASE (ADD LATER!!!!!)

//System.out.println("e[n]"+employee[n]);
							String desc = (String)super.getDesc(employee[n]);
							String img = (String)super.getImage(employee[n]);
							//intensityvs.add(employee[0]);
							ListNode neu = new ListNode(employee[n], desc, employee[n+1], img); //+1
							//System.out.println(neu.toString());
//					neu.setNext(null);
							ne.addExercise(neu);
							count++;
						}
					}		
					ne.setName(employee[0]);
					//System.out.println(ne.toString());

				}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//System.out.println("Beginning Workout. Press any key & enter to go on to the next exercise");					
				//System.out.println(ne.toString());	
				String total = "";
				for (int h = 1; h < count+1; h++) {
					total += ne.getExercise(h)+"&";	
					 //do the splitting thing
					 String p = ne.get(h);
					 p = p.toLowerCase();
					 p = p.replaceAll("\\s", "");
					 total += p +"&";
	/*	 BufferedImage pic = ImageIO.read((new File("src/"+p+".png")));//src/cafe_winterscene_prev_ui.png

					 JLabel label = new JLabel (ne.getExercise(h));
					label.setBounds(10, 20, 1000, 25);
					frame.add(label);
					
					   wIcon = new JLabel();
					   wIcon.setBounds(25,25,100,100);
					   wIcon.setIcon(new ImageIcon(pic));
					    //System.out.println("success");
					   frame.getContentPane().add(wIcon);
					   frame.setVisible(true); */

					//System.out.println(ne.get(h).getImage());	

					//ImageIcon icon = new ImageIcon(ne.get(h).getImage());
					//JLabel label = new JLabel(icon);
					//frame.add(label);			
				}
			//	System.out.println("total:" + total);
				return total;
	}
	public boolean complete(Patient prick, String workout, int enjoy, int difficult, boolean cont) {
		boolean completed = false;
		P = prick;
		P.setRating(workout, enjoy, difficult);
		//System.out.println( "Would you like to do another workout/go to the main page or exit?");
		if (cont) {
			return true;
			/*try {
				Home(P);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		else {
			//j = i.size() + 10;
			workout = "";
			//System.out.println("okay");

			//welp gotta create a temporary file :')
			 try {

		            File file = File.createTempFile("abc", ".txt"); //.tmp
		           // System.out.println(file);

		            File p = new File("src/users.txt");
		            //BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		            //System.out.println(file)
		            //BufferedReader br = new BufferedReader(new FileReader(p));
			 		FileWriter fWriter = new FileWriter(file, true);
					//System.out.println("okay2");
					ArrayList<String> content = new ArrayList<String>();
					//Scanner scanner;
		            Scanner ss = new Scanner(p); //once it reaches a write, it stops looping (too long?)
						String line;
			             //boolean cont1 = true;
			            // while (ss.hasNextLine()) {
						for (int i = 0; i < 5; i++) {
			            	 line = ss.nextLine(); //&& cont == true
								String e[] = line.split(",");

			            	 if (hard = true && line.contains(P.getId())) {
			            	//	 System.out.println("1:"+P.getId() +","+ P.getPassword()+ ","+P.getIntensity());
			            		 //fWriter.write(P.getId() +","+ P.getIntensity() +"," + P.getPassword());
			            		 if (e.length == 4) {
					            		int iig = Integer.parseInt(e[3]) + 1;
					             		//content.add(iig+"");
					            		 content.add(P.getId() +"," + P.getPassword()+","+P.getIntensity()+","+iig);

					            	 }
			            		 else
				            	 	{
				            		 content.add(P.getId() +"," + P.getPassword()+","+P.getIntensity()+","+1);
				            	 	}
			            		 //content.add(P.getId() +"," + P.getPassword()+","+P.getIntensity());
			            		 
			            	 }
			            	 else {
//			            		 System.out.println("2:"+line);

			            		 //fWriter.write(line);
			                     //fileWriter.flush();
			            		 content.add(line);
			            	 }
			            	 
			            	
			             	
			            	 /*
			            	  * //cont1 = false;
			             		if (!completed) { //instead of tracking workouts, just count the number??
				            		// System.out.println("3:"+",Completed:" + P.getNewRatings1());
			             			//content.add(",Completed:" + P.getNewRatings1());
			             			content.add(","+1);
								}
								else{
				            		 System.out.println("4:"+P.getNewRatings1());

									//fWriter.write(P.getNewRatings());
									//content.add(P.getNewRatings1());
//									content.add(e[3]+P.getNewRatings1());

									int iig = Integer.parseInt(e[3]) + 1;
									//content.add
								} */
								//fWriter.write(P.getNewRatings());
				            	}    
		            
		            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		                for (String s : content) {
		                    bw.write(s);
		                    bw.write(System.lineSeparator()); // new line
		                }
		            }
		        //read the temp file
		            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		                String line4;
		                while ((line4 = br.readLine()) != null) {
		        //            System.out.println(line4);
		                }
		            } 
				//	System.out.println("okay3");

			       //maybe rewrite every line ick
			         fWriter = new FileWriter(p, false);
			         try (Scanner s = new Scanner(file)) {
							String lines;
				             while (s.hasNextLine()) {
				            	 lines = s.nextLine();
				            	/* if (lines.contains(P.getId())){
										fWriter.write(lines);
				            	 } */
				            	// else {
									fWriter.write(lines + "\n");
				            	// }
				             }
				     }
			         fWriter.close();
					//	System.out.println("okay4");

			         // writes few lines
		           
		            

		        } catch (IOException e) {
		            e.printStackTrace();
		        }

	} return false;
}
	}
