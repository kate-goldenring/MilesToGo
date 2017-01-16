package mtg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class AddMilesWidget extends JPanel implements ActionListener{
	private int miles;
	private JTextField milesToday;
	private JButton add_miles_button;
	private FileEditor fe;

	public AddMilesWidget(FileEditor fe){
		this.fe = fe;

		milesToday = new JTextField(5);
		add(new JLabel("Add Miles Run: "));
		add(milesToday);

		add_miles_button = new JButton("Enter");
		add_miles_button.setActionCommand("enter");
		add(add_miles_button);

		add_miles_button.addActionListener(this);
		if(fe.getMiles()<1){
			JLabel totalMiles = new JLabel("Can you outrun coyote by running 365 miles in 365 days?");
			add(totalMiles);
		}else if(fe.getMiles()<365){
			JLabel totalMiles = new JLabel("Miles to Go: " + Double.toString(365-fe.getMiles()));
			add(totalMiles);
		}else{// ran more than 365
			JLabel totalMiles = new JLabel("You outran coyote at " + Double.toString(fe.getMiles()) +" miles! Reset to start over!");
			add(totalMiles);
		}



	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		Double miles_to_add = Double.parseDouble(milesToday.getText());
		fe.addMiles(miles_to_add);
		milesToday.setText("");

		try {
			restartApplication();
//			System.out.println("entered tryblock");
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//		try {
	//			   Runtime.getRuntime().exec("java -jar mtg.Main.jar");
	//			   System.exit(0);
	//			} catch (IOException e) {
	//			}
	//		
	//	}
	public void restartApplication() throws URISyntaxException, IOException
	{
		final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
		final File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());

		/* is it a jar file? */
		if(!currentJar.getName().endsWith(".jar"))
			return;

		/* Build command: java -jar application.jar */
		final ArrayList<String> command = new ArrayList<String>();
		command.add(javaBin);
		command.add("-jar");
		command.add(currentJar.getPath());
//		System.out.println(currentJar.getPath());
		final ProcessBuilder builder = new ProcessBuilder(command);
		builder.start();
		System.exit(0);
	}
}
