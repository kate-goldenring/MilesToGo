package mtg;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel {
	private ComponentImage ci;
	private FileEditor fe;
	private double miles;

	public View(ComponentImage ci, FileEditor fe){
//		ci = new ComponentImage(fe.getMiles());
		this.fe = fe;
		setLayout(new BorderLayout());
		add(ci, BorderLayout.CENTER);
		JPanel buttons = new JPanel();
		AddMilesWidget add_miles_widget = new AddMilesWidget(fe);
		buttons.add(add_miles_widget);
		RestartWidget restart_widget = new RestartWidget(fe);
		buttons.add(restart_widget);
		add(buttons, BorderLayout.SOUTH);


	}


//	@Override
//	public void update(Observable o, Object arg) {
//		System.out.println("update called");
//		miles = fe.getMiles();
//		ci.getImage().flush();
//		ci = new ComponentImage(miles);
//	
////		ci.setMiles(miles);
//	
//
//	}

}
