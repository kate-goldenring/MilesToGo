package mtg;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("365 Miles in 365 Days");

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		FileEditor fe = new FileEditor();

		View view = new View(new ComponentImage(fe.getMiles()), fe);
		f.add(view);
	
		f.pack();
		f.setVisible(true);


	}

}
