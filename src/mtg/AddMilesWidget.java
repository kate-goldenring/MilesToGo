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
	
	private JTextField milesToday;
	private JButton add_miles_button;
	private FileEditor fe;
	private JLabel totalMiles;
	private MileCounterWidget mcw;

	public AddMilesWidget(FileEditor fe){
		this.fe = fe;

		milesToday = new JTextField(5);
		add(new JLabel("Add Miles Run: "));
		add(milesToday);

		add_miles_button = new JButton("Enter");
		add_miles_button.setActionCommand("enter");
		add(add_miles_button);

		add_miles_button.addActionListener(this);
		}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		Double miles_to_add = Double.parseDouble(milesToday.getText());
		//print miles to file editor 
		fe.addMiles(miles_to_add);
		milesToday.setText("");
		
	
	}

}
