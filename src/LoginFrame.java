import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class LoginFrame extends JFrame implements ActionListener
{

	private double time=0.0;
	//private BufferedImage pic;
  	 long start = System.currentTimeMillis();
	long  timeElapsed = 0;
	int count= 0;
	int walk = 0;
	int swalk = 0;
	public String type = "";
	//trials :P
	 Image image;
	private Image cafe;
    private BufferedImage pic = null;
    private boolean pH = false;
    public static LoginRegister h;
    public static Patient neu;
    public static PHome n1;
    public static PhysicalTherapist v;
    String patients = "";
    ArrayList<String> em = new ArrayList<String>();
    String pa = ""; //pateint to be assigned
	Workout w = new Workout();
	String text = "";
	boolean populated = false;
	int varibale = 0;
	public static AudioInputStream audioInput;
	public static Clip clip;
	boolean doe = false;
	
	//Login Screen GUI
	Container type1Container = getContentPane();
	JLabel p1 = new JLabel();
	JFrame f1 = new JFrame();
	JButton p = new JButton ("Patient");
	JButton pt = new JButton ("Physical Therapist");
	
	Container type2Container = getContentPane();
	JLabel p2 = new JLabel();
	JButton l = new JButton ("Login");
	JButton r = new JButton ("Register");
	
	Container loginContainer = getContentPane();
	JLabel LpromptName = new JLabel("Name:");
	JLabel LpromptPassword = new JLabel("Password:");
	JTextField Lname = new JTextField();
	JTextField Lpassword = new JTextField();
	JButton Lsubmit = new JButton ("Next");
	//Patient Home gUI
	
	Container registerContainer = getContentPane();
	JLabel RpromptName = new JLabel("Name:");
	JLabel RpromptPassword = new JLabel("Password:");
	JLabel RpromptIntensity = new JLabel("Intensity:");
	JTextField Rname = new JTextField();
	JTextField Rpassword = new JTextField();
	JTextField intensity = new JTextField();
	JButton Rsubmit = new JButton ("Next");

	Container pHomeContainer = getContentPane();
	JLabel info = new JLabel("Select a Workout");
	//JLabel  = new JLabel();
	ArrayList<String> available = new ArrayList<String>();
	String[] array;
	//= available.toArray(new String[available.size()]);
	JComboBox petList = new JComboBox();;
	//= new JComboBox(array);
	JButton choiceSubmit = new JButton ("Select");

	//workoutMode GUI
	Container workoutContainer = getContentPane();
	String selected = "";
	JLabel display = new JLabel();
	JButton wNext = new JButton ("Next Exercise");
	int count1 = 0;
	String[] ex;
	JButton music = new JButton ("Play");
	static File musicPath = new File ("src/ChillingMusic.wav");
	int click = 0;
	BufferedImage pic1;
	JLabel wIcon = new JLabel();

	
	Container rateContainer = getContentPane();
	JLabel rateIntstruct = new JLabel("Rate your workout from 1-5");
	JLabel enjoyI = new JLabel("Enjoyment:");
	JTextField enjoy = new JTextField();
	JLabel difficultI = new JLabel("Difficulty:");
	JTextField difficult = new JTextField();
	JButton rSubmit = new JButton ("Submit");
	
	
	Container exitContainer = getContentPane();
	JLabel exitIntstruct = new JLabel("Would you like to do another workout?");
	JButton y = new JButton ("Yes");
	JButton n = new JButton ("No");
	
	//phycial therapist Home gUI
	Container ptHomeContainer = getContentPane();
	JLabel selectPatient = new JLabel("Select a Patient to Assign a Workout to");
	JComboBox xList = new JComboBox();
	JButton xSubmit = new JButton ("Select");
	
	Container makeWorkoutContainer = getContentPane();
	JComboBox exList = new JComboBox();
	JLabel repsInfo = new JLabel("Enter the number of reps:");
	JTextField reps = new JTextField();
	JButton exSubmit = new JButton ("Add Exercise");
	JButton completeSubmit = new JButton ("Complete Workout");

	Container assignIntContainer = getContentPane();
	JLabel input = new JLabel("Rate the Workout's Intensity:");
	JTextField inputField = new JTextField();
	JLabel input1 = new JLabel("Provide a short description of the workout:");
	JTextField inputField1 = new JTextField();
	JButton assignIntSubmit = new JButton ("Submit");
	
	Container askContainer = getContentPane();
	JLabel congrats = new JLabel();
	JLabel askQ = new JLabel("Would you like to increase the intensity level of your workouts?");
	JButton y2 = new JButton ("Yes");
	JButton n2 = new JButton ("No");
	
	Container resultContainer = getContentPane();
	JLabel result = new JLabel();	
	JButton undo = new JButton ("Undo");
	JButton next = new JButton ("Next");
	
	public LoginFrame() {
		setLayoutManagerLogin();
		addActionEvent();
		setLocationAndSizeType1();
		addComponentsToContainerType1(true);
		//cal methods insider ocnstructor  
	}
	public static LoginFrame frame;
	public static void main (String[] a){
		try {
			h = new LoginRegister();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame = new LoginFrame();
		//frame.setTitle("Exercise");
		frame.setBounds(10,10,550,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setVisible(true);
		try {
			if (musicPath.exists()) {
				audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = (Clip) AudioSystem.getClip();
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setLayoutManagerLogin() {
		type1Container.setLayout(null);
		type2Container.setLayout(null);
		loginContainer.setLayout(null);
		registerContainer.setLayout(null);
		pHomeContainer.setLayout(null);
		ptHomeContainer.setLayout(null);
		workoutContainer.setLayout(null);
		rateContainer.setLayout(null);
		exitContainer.setLayout(null);
		makeWorkoutContainer.setLayout(null);
		assignIntContainer.setLayout(null);
		askContainer.setLayout(null);
		resultContainer.setLayout(null);
	}
	public void setLocationAndSizeType1() {
		f1.setBounds(10,20,400,100);
		
		p1.setText("Are you a patient or a physical therapist?");
		p1.setBounds(10, 20, 300, 25);
		p.setBounds(10, 50, 200, 30);
		pt.setBounds(10, 80, 200, 30);
	}
	public void addComponentsToContainerType1(boolean vis) {
		type1Container.add(p1);
		type1Container.add(p);
		type1Container.add(pt);
		
		p1.setVisible(vis);
		p.setVisible(vis);
		pt.setVisible(vis);
	}

	public void setLocationAndSizeType2() {
		p2.setText("Would you like to login or register?");
		p2.setBounds(10, 20, 300, 25);
		l.setBounds(10, 50, 200, 30);
		r.setBounds(10, 80, 200, 30);
	}
	public void addComponentsToContainerType2(boolean vis) {
		type1Container.add(p2);
		type1Container.add(l);
		type1Container.add(r);
		
		p2.setVisible(vis);
		l.setVisible(vis);
		r.setVisible(vis);
	}
	public void setLocationAndSizeLogin() {
		//f1.setBounds(10,20,400,100);
		LpromptName.setBounds(10, 50, 75, 25);
		LpromptPassword.setBounds(10, 80, 75, 25);
		//LpromptIntensity.setBounds(0, 50, 120, 25);
		Lname.setBounds(100, 50, 200, 25);
		Lpassword.setBounds(100, 80, 200, 25);
		//intensity.setBounds(50, 110, 200, 25);
		Lsubmit.setBounds(50, 120, 100, 30);
	}
	public void addComponentsToContainerLogin(boolean vis) {
		loginContainer.add(Lname);
		loginContainer.add(Lpassword);
		//loginContainer.add(intensity);
		loginContainer.add(Lsubmit);
		loginContainer.add(LpromptName);
		loginContainer.add(LpromptPassword);

		Lname.setVisible(vis);
		Lpassword.setVisible(vis);
		//intensity.setVisible(vis);
		Lsubmit.setVisible(vis);
		LpromptName.setVisible(vis);
		LpromptPassword.setVisible(vis);
	}
	public void setLocationAndSizeRegister() {
		//f1.setBounds(10,20,400,100);
		RpromptName.setBounds(10, 50, 75, 25);
		RpromptPassword.setBounds(10, 80, 75, 25);
		Rname.setBounds(100, 50, 200, 25);
		Rpassword.setBounds(100, 80, 200, 25);
		if (type.equals("p")) {
		intensity.setBounds(100, 120, 200, 25);
		RpromptIntensity.setBounds(10, 120, 75, 25);
		}
		Rsubmit.setBounds(50, 180, 100, 30);
	}
	public void addComponentsToContainerRegister(boolean vis) {
		registerContainer.add(Rname);
		registerContainer.add(Rpassword);
		registerContainer.add(intensity);
		registerContainer.add(Rsubmit);
		registerContainer.add(RpromptName);
		registerContainer.add(RpromptPassword);

		if (type.equals("p")) {
			registerContainer.add(intensity);
			registerContainer.add(RpromptIntensity);
			intensity.setVisible(vis);
			RpromptIntensity.setVisible(vis);
		}
		Rname.setVisible(vis);
		Rpassword.setVisible(vis);
		Rsubmit.setVisible(vis);
		RpromptName.setVisible(vis);
		RpromptPassword.setVisible(vis);
	}
	public void setLocationAndSizepHome() { //SET COMBOBOXES VISIBLE OR NOT FOR CUSTOM AND COMPLETED!!
		info.setBounds(50, 30, 200, 25);
		petList.setBounds(50, 50, 400, 25);
		if(populated == false) {
		String intensity = n1.getIntensityExercises();
		String[] employee = intensity.split(","); 
		for (int i = 0; i < employee.length; i++) {
			//available.add(employee[i]);
			petList.addItem("Based on Your Intensity: "+employee[i]);
		} 
		String personal = n1.getRecommendedExercises();
		if (!personal.equals("")) {
		employee = personal.split(","); 
		for (int i = 0; i < employee.length; i++) {
			//available.add(employee[i]);
			petList.addItem("Workout Made by Your Physical Therapist: "+employee[i]);
		} }}
		choiceSubmit.setBounds(50, 120, 200, 25);
	}
	public void addComponentsToContainerpHome(boolean vis) {

		//array = available.toArray(new String[available.size()]);
		pHomeContainer.add(petList);
		pHomeContainer.add(choiceSubmit);
		pHomeContainer.add(info);

		petList.setVisible(vis);
		choiceSubmit.setVisible(vis);
		info.setVisible(vis);
	}
	public void setLocationAndSizeworkout() { //recall until count = 
		ex = selected.split("&"); 
		if (count1 != ex.length) {
			display.setText(ex[count1]);
		}
		display.setBounds(10, 20, 400, 25);
		wNext.setBounds(10, 50, 200, 30);
		count1 ++;
		music.setBounds(50, 100, 60, 25);
		String p = ex[count1];
		count1++;
		p = p.toLowerCase();
		p = p.replaceAll("\\s", "");
		try {
			pic1 = ImageIO.read((new File("src/"+p+".png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//src/cafe_winterscene_prev_ui.png
		wIcon.setIcon(new ImageIcon(pic1));
		wIcon.setBounds(25,200,400,400);
		    //System.out.println("success");
	}
	public void addComponentsToContainerworkout(boolean vis) {

		//array = available.toArray(new String[available.size()]);
		workoutContainer.add(display);
		workoutContainer.add(wNext);
		workoutContainer.add(music);
		workoutContainer.add(wIcon);
		
		//frame.setVisible(vis);
		display.setVisible(vis);
		wNext.setVisible(vis);
		music.setVisible(vis);
		wIcon.setVisible(vis);
		//workoutContainer.setVisible(vis);

		//workoutContainer.setVisible(vis);
	}
	public void setLocationAndSizerate() { //recall until count = 
		rateIntstruct.setBounds(50, 30, 200, 25);
		enjoyI.setBounds(10, 50, 100, 25);
		enjoy.setBounds(85, 50, 200, 25);
		difficultI.setBounds(10, 80, 100, 25);
		difficult.setBounds(85, 80, 200, 25);

		rSubmit.setBounds(50, 110, 200, 25);
	}
	public void addComponentsToContainerrate(boolean vis) {
		rateContainer.add(enjoy);
		rateContainer.add(difficult);
		rateContainer.add(rSubmit);
		rateContainer.add(rateIntstruct);
		rateContainer.add(enjoyI);
		rateContainer.add(difficultI);
		
		//frame.setVisible(vis);
		enjoy.setVisible(vis);
		difficult.setVisible(vis);
		rSubmit.setVisible(vis);
		rateIntstruct.setVisible(vis);
		enjoyI.setVisible(vis);
		difficultI.setVisible(vis);

		}
	public void setLocationAndSizeexit() { //recall until count = 
		//FINISH
		if (type.equals("pt")) {
			exitIntstruct.setText("Would you like to create another workout?");
		}
		if (type.equals("p")) {
			exitIntstruct.setText("Would you like to do another workout?");
		}
		exitIntstruct.setBounds(50, 40, 400, 50);
		y.setBounds(50, 90, 80, 30);
		n.setBounds(120, 90, 80, 30);
	}
	public void addComponentsToContainerexit(boolean vis) {
		exitContainer.add(exitIntstruct);
		exitContainer.add(y);
		exitContainer.add(n);
		
		//frame.setVisible(vis);
		exitIntstruct.setVisible(vis);
		y.setVisible(vis);
		n.setVisible(vis);
	}
	public void setLocationAndSizeptHome() {
		selectPatient.setBounds(50, 20, 400, 25);
		xList.setBounds(50, 50, 200, 25);
		em = v.getPatients();
		if(xList.getItemCount() == 0) {
			xList.addItem("Select Patient"); //add exception so not chosen
		}
		if (doe == false) {
		for (int i = 0; i < em.size(); i++) {
			//available.add(employee[i]);
			xList.addItem(em.get(i));
		}
		
		} 
		xSubmit.setBounds(50, 120, 200, 25);
		

	}
	public void addComponentsToContainerptHome(boolean vis) {
		patients = v.getExercises();
		
		//array = available.toArray(new String[available.size()]);
		ptHomeContainer.add(xList);
		ptHomeContainer.add(xSubmit);
		ptHomeContainer.add(selectPatient);

		xList.setVisible(vis);
		xSubmit.setVisible(vis);
		selectPatient.setVisible(vis);

	}
	public void setLocationAndSizemakeWorkout() { //recall until count = 
		patients = v.getExercises();
		String[] employee = patients.split(","); 
		if(exList.getItemCount() == 0) {
			exList.addItem("Select Exercise"); //add exception so not chosen
		}
		if (doe == false) {
		for (int i = 0; i < employee.length; i++) {
			//available.add(employee[i]);
			exList.addItem(employee [i]);
			if (i == employee.length-1) {
				doe = true;
			}	
		} }
		exList.setBounds(50, 50, 200, 25);
		exSubmit.setBounds(50, 120, 200, 25);
		completeSubmit.setBounds(50, 200, 200, 25);
		//reps.setText("Enter the number of reps");
		repsInfo.setBounds(310, 25, 200, 25);
		reps.setBounds(300, 50, 200, 25);
		//frame.getContentPane();

	}
	public void addComponentsToContainermakeWorkout(boolean vis) {
		makeWorkoutContainer.add(exList);
		makeWorkoutContainer.add(exSubmit);
		makeWorkoutContainer.add(reps);
		makeWorkoutContainer.add(completeSubmit);
		makeWorkoutContainer.add(repsInfo);

		reps.setText("");
		exList.setSelectedIndex(0);
		exList.setVisible(vis);
		exSubmit.setVisible(vis);
		reps.setVisible(vis);
		repsInfo.setVisible(vis);
		completeSubmit.setVisible(vis);	
	}
	
	public void setLocationAndSizeassignInt() {
		input.setBounds(50, 50, 200, 25);
		inputField.setText("");
		inputField1.setText("");

		inputField.setBounds(325, 50, 30, 25);
		input1.setBounds(50, 100, 300, 25);
		inputField1.setBounds(50, 130, 150, 25);
		assignIntSubmit.setBounds(50, 170, 200, 25);
		//HERE !!
/*
JLabel input = new JLabel();
JTextField inputField = new JTextField();
JButton assignIntSubmit = new JButton ("Submit Rating");	
*/
	}
	public void addComponentsToContainerassignInt(boolean vis) {
		ptHomeContainer.add(input);
		ptHomeContainer.add(inputField);
		ptHomeContainer.add(input1);
		ptHomeContainer.add(inputField1);
		ptHomeContainer.add(assignIntSubmit);
		
		input.setVisible(vis);
		inputField.setVisible(vis);
		input1.setVisible(vis);
		inputField1.setVisible(vis);
		assignIntSubmit.setVisible(vis);
	}
	public void setLocationAndSizeask() {
		//JLabel congrats = new JLabel();
		//JLabel askQ = new JLabel("Would you like to increase the intensity level of your workouts?");
		if (varibale >= 1) {
			congrats.setText("Congrats! You've completed " + neu.getCompleted() + " workouts!");
		}
		congrats.setBounds(50, 50, 350, 25);
		askQ.setBounds(50, 120, 400, 25);
		y2.setBounds(50, 90, 80, 30);
		n2.setBounds(120, 90, 80, 30);
	}
	public void addComponentsToContainerask(boolean vis) {
		askContainer.add(congrats);
		askContainer.add(askQ);
		askContainer.add(y2);
		askContainer.add(n2);

		congrats.setVisible(vis);
		askQ.setVisible(vis);
		y2.setVisible(vis);
		n2.setVisible(vis);
	}
	public void setLocationAndSizeresult(boolean co) {
		/*
	JLabel result = new JLabel();	
	JButton undo = new JButton ("Undo");
	JButton next = new JButton ("Next");
	*/
		if (co == true) {
			result.setText("Your intensity level is now " + neu.getIntensity() + "!");
			undo.setBounds(50, 90, 80, 30);
		}
		else {
			result.setText("Your intensity level is still " + neu.getIntensity() + "!");
			undo.setBounds(0,0,0,0);
		}
		result.setBounds(50, 50, 350, 25);
		//askQ.setBounds(50, 120, 350, 25);
		next.setBounds(120, 90, 80, 30);
	}
	public void addComponentsToContainerresult(boolean vis) {
		resultContainer.add(result);
		resultContainer.add(undo);
		resultContainer.add(next);

		result.setVisible(vis);
		undo.setVisible(vis);
		next.setVisible(vis);
	}
	public void addActionEvent() {
		p.addActionListener(this);
		pt.addActionListener(this);
		r.addActionListener(this);
		l.addActionListener(this);
		Lsubmit.addActionListener(this);
		Rsubmit.addActionListener(this);
		choiceSubmit.addActionListener(this);
		wNext.addActionListener(this);
		rSubmit.addActionListener(this);
		music.addActionListener(this);
		xSubmit.addActionListener(this);
		exSubmit.addActionListener(this);
		completeSubmit.addActionListener(this);
		assignIntSubmit.addActionListener(this);
		y.addActionListener(this);
		n.addActionListener(this);
		y2.addActionListener(this);
		n2.addActionListener(this);
		undo.addActionListener(this);
		next.addActionListener(this);
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource() == p) {
		setLayoutManagerLogin();
		addComponentsToContainerType1(false);
		setLocationAndSizeType2();
		addComponentsToContainerType2(true);
		type = "p";
		//System.out.println("success");
	}
	if (e.getSource() == pt) {
		setLayoutManagerLogin();
		addComponentsToContainerType1(false);
		setLocationAndSizeType2();
		addComponentsToContainerType2(true);
		type = "pt";
		//System.out.println("success");

	}
	if (e.getSource() == l) { //figure out login!!
		setLayoutManagerLogin();
		addComponentsToContainerType2(false);
		setLocationAndSizeLogin();
		addComponentsToContainerLogin(true);
		//h.Login(type,)
	}
	if (e.getSource() == Lsubmit) {
		String n = Lname.getText();
		String p = Lpassword.getText();
		if (type.equals("p")) {
			try {
				neu = h.LoginP(type, n, p);
				if (neu == null) {
					JOptionPane.showMessageDialog(frame,"Please check your name and password or register!");
					setLayoutManagerLogin();
					addComponentsToContainerLogin(false);
					setLocationAndSizeLogin();
					addComponentsToContainerLogin(true);

				}
					
				//System.out.println("successssss");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		
        try {
			n1 = new PHome(neu);
			
			
				//make a screen for asking 
			
			
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			//System.out.println("try again");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
        varibale = n1.check();;
		if (varibale >= 1) {
		 setLayoutManagerLogin();
		addComponentsToContainerLogin(false);
		setLocationAndSizeask();
		addComponentsToContainerask(true);
	}
		else {
		    setLayoutManagerLogin();
			addComponentsToContainerLogin(false);
			setLocationAndSizepHome();
			addComponentsToContainerpHome(true);	
		}
		}
        else
        {
        	try {
				v = h.LoginPT(type, n, p);
				

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	setLayoutManagerLogin();
			addComponentsToContainerLogin(false);
			setLocationAndSizeptHome();
			addComponentsToContainerptHome(true);
			//System.out.println("K");
        }
		
		//h.Login(type,)
	}

	if (e.getSource() == r) {
		setLayoutManagerLogin();
		addComponentsToContainerType2(false);
		setLocationAndSizeRegister();
		addComponentsToContainerRegister(true);
	}
	if (e.getSource() == Rsubmit) {
		String n = Rname.getText();
		String p = Rpassword.getText();
		int i = 0;
		if (type.equals("p")) {
		i = Integer.parseInt(intensity.getText());
		}
		try {
			h.Register(type, n, p, i);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (type.equals("p")) {
			neu = new Patient (n, p, i); //ummm only applies to patient
        try {
			n1 = new PHome(neu);
			h.RegisterP (n,p,i);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        setLayoutManagerLogin();
		addComponentsToContainerRegister(false);
		setLocationAndSizepHome();
		addComponentsToContainerpHome(true);
		}
		if (type.equals("pt")) {
			
			try {
				v = h.RegisterPT(n, p);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		setLayoutManagerLogin();
		addComponentsToContainerRegister(false);
		setLocationAndSizeptHome();
		addComponentsToContainerptHome(true);	
		}
        
		
	}	
	if (e.getSource() == choiceSubmit) {
		text = (String)petList.getSelectedItem();
		String r[] = text.split(": ");
		if (r.length > 2) {
			text = r[1] + ": " + r[2];
		}
		else {
			text = r[1];
		}
		//System.out.println("text:"+ text);
		try {
			selected = n1.workoutMode(text);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		count1 = 0;
		setLayoutManagerLogin();
		addComponentsToContainerpHome(false);
		setLocationAndSizeworkout();
		addComponentsToContainerworkout(true);
		
	}
	if (e.getSource() == wNext) {
		//setLayoutManagerLogin();

		if (ex.length > count1) {
		setLayoutManagerLogin();
		addComponentsToContainerworkout(false);
		setLocationAndSizeworkout();
		addComponentsToContainerworkout(true);
		}
		else {
		populated = true;
		try {
			audioInput.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		clip.close();
		setLayoutManagerLogin();
		addComponentsToContainerworkout(false);
		setLocationAndSizerate();
		addComponentsToContainerrate(true);
		}
	}
	
	if (e.getSource() == music) {
		click++;
		//System.out.println(click);
		try {
		    //ileInputStream input = new FileInputStream("src/music.mp3"); 
			if (musicPath.exists()) {
				
			if (click % 2 == 1) {
				clip.open(audioInput);
				clip.start();
			//clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			if (click % 2 == 0) {
				clip.stop();
				audioInput.close();
				clip.close();
			}
			}}
			
		 catch (IOException k) {
			// TODO Auto-generated catch block
			k.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	if (e.getSource() == xSubmit) {
		pa = (String)xList.getSelectedItem(); 
		if (pa.equals("Select Patient")) {
			JOptionPane.showMessageDialog(frame,"Please select a valid patient!");
			setLayoutManagerLogin();
			addComponentsToContainerptHome(false);
			setLocationAndSizeptHome();
			addComponentsToContainerptHome(true);
		}
		setLayoutManagerLogin();
		addComponentsToContainerptHome(false);
		setLocationAndSizemakeWorkout();
		addComponentsToContainermakeWorkout(true); 
		}
	if (e.getSource() == exSubmit) {
		String fe = (String)exList.getSelectedItem(); 
		if (fe.equals("Select Exercise")) {
			JOptionPane.showMessageDialog(frame,"Eggs are not supposed to be green.");
			setLayoutManagerLogin();
			addComponentsToContainermakeWorkout(false);
			setLocationAndSizemakeWorkout();
			addComponentsToContainermakeWorkout(true);
		}
		int r = Integer.parseInt(reps.getText());
		if (r == 0) {
			JOptionPane.showMessageDialog(frame,"Please enter a value greater than or equal to 1");
			setLayoutManagerLogin();
			addComponentsToContainermakeWorkout(false);
			setLocationAndSizemakeWorkout();
			addComponentsToContainermakeWorkout(true);
		}
		//pa = (String)exList.getSelectedItem(); 
		ListNode n = new ListNode(fe, r+"");
		w.addExercise(n);

		setLayoutManagerLogin();
		addComponentsToContainermakeWorkout(false);
		setLocationAndSizemakeWorkout();
		addComponentsToContainermakeWorkout(true);
		}
	if (e.getSource() == completeSubmit) {
//		File file = new File("src/users.txt");

		setLayoutManagerLogin();
		addComponentsToContainermakeWorkout(false);
		setLocationAndSizeassignInt();
		addComponentsToContainerassignInt(true);
		}
	if (e.getSource() == assignIntSubmit) {
		int in = Integer.parseInt(inputField.getText());
		String title = inputField1.getText();
		try {
			v.subWorkout(pa + ": "+title,in,w);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setLayoutManagerLogin();
		addComponentsToContainerassignInt(false);
		setLocationAndSizeexit();
		addComponentsToContainerexit(true);
		}
	if (e.getSource() == rSubmit) {
		setLayoutManagerLogin();
		addComponentsToContainerrate(false);
		setLocationAndSizeexit();
		addComponentsToContainerexit(true);
		
		int en = Integer.parseInt(enjoy.getText());
		int di = Integer.parseInt(difficult.getText());
		boolean next = n1.complete(neu, text, en, di, false);
		enjoy.setText("");
		difficult.setText("");
		if (next) {
			//add arraylist
			setLayoutManagerLogin();
			addComponentsToContainerrate(false);
			setLocationAndSizepHome();
			addComponentsToContainerpHome(true);
		}
	}
	if (e.getSource() == y) {
		if (type.equals("p")) {
		setLayoutManagerLogin();
		addComponentsToContainerexit(false);
		setLocationAndSizepHome();
		addComponentsToContainerpHome(true);
		}
		if (type.equals("pt")) {
			setLayoutManagerLogin();
			addComponentsToContainerexit(false);
			setLocationAndSizeptHome();
			addComponentsToContainerptHome(true);
		}
		}
	if (e.getSource() == n) {
		System.exit(0);
		}
	if (e.getSource() == y2) {
		neu.setIntensity((int) (neu.getIntensity() + 1));
		setLayoutManagerLogin();
		addComponentsToContainerask(false);
		setLocationAndSizeresult(true);
		addComponentsToContainerresult(true);
	}
	if (e.getSource() == n2) {
		setLayoutManagerLogin();
		addComponentsToContainerask(false);
		setLocationAndSizepHome();
		addComponentsToContainerpHome(true);
	}
	if (e.getSource() == undo) {
		try {
			n1.Home(neu);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		neu.setIntensity((int)(neu.getIntensity() - 1));
		setLayoutManagerLogin();
		addComponentsToContainerresult(false);
		setLocationAndSizeresult(false);
		addComponentsToContainerresult(true);
	}
	if (e.getSource() == next) {
		try {
			n1.Home(neu);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setLayoutManagerLogin();
		addComponentsToContainerresult(false);
		setLocationAndSizepHome();
		addComponentsToContainerpHome(true);
		}

}

}