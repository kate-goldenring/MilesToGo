package mtg;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer{
private FileEditor fe;
private View view;

Controller(FileEditor fe, View view){
	this.fe = fe;
	this.view= view;
	this.fe.addObserver(this);
}
	@Override
	public void update(Observable o, Object arg) {
		view = new View(new ComponentImage(fe.getMiles()), fe);
		
	}

}
