package mtg;

import javax.swing.JLabel;


public class MileCounterWidget extends JLabel{

	private double miles;
	public MileCounterWidget(FileEditor fe){
		
		miles = fe.getMiles();
		if(miles<1){
			this.setText("Can you outrun coyote by running 365 miles in 365 days?");
		
		}else if(miles<365){
		this.setText("Miles to Go: " + Double.toString(365-miles));
			
		}else{// ran more than 365
			this.setText("You outran coyote at " + Double.toString(miles) +" miles! Reset to start over!");
			
		}
		
	}

	
	public void updateText(FileEditor fe) {
		if(fe.getMiles()<1){
			this.setText("Can you outrun coyote by running 365 miles in 365 days?");
		
		}else if(fe.getMiles()<365){
		this.setText("Miles to Go: " + Double.toString(365-fe.getMiles()));
			
		}else{// ran more than 365
			this.setText("You outran coyote at " + Double.toString(fe.getMiles()) +" miles! Reset to start over!");
			
		}
		
	}


}
