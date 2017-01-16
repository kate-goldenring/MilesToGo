package mtg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RestartWidget extends JPanel implements ActionListener{
	FileEditor fe;
	public RestartWidget(FileEditor fe){
		this.fe=fe;
		JButton restart = new JButton("Reset Miles Run to 0");
		restart.setActionCommand("restart");
		add(restart);
		restart.addActionListener(this);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		fe.resetMiles();
	}

}
