package mtg;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;


public class ComponentImage extends Component  {//observer of FileEditor
	private BufferedImage mtn;
	private BufferedImage rr;
	private BufferedImage startImage;
	private BufferedImage endImage;
	private double miles;

	public ComponentImage(double miles){
		
		this.miles = miles;
		try {
			mtn = ImageIO.read(new File("image/mtfuji.jpg"));

		} catch (IOException e) {
		}
		
//		try {
//			mtn = ImageIO.read(new URL("http://onshirin.jp/en/introduction/images/image_07.jpg"));
//
//		} catch (IOException e) {
//		}
		
		try {
			rr = ImageIO.read(new File("image/rr2.png"));

		} catch (IOException e) {
		}
		
//		try {
//			rr = ImageIO.read(new URL("http://webcreationsbyjumpy.com/comics/comics_graphics/roadrunner/images/runner022.png"));
//
//		} catch (IOException e) {
//		}
		
//		try {
//			startImage = ImageIO.read(new URL("http://webcreationsbyjumpy.com/comics/comics_graphics/roadrunner/images/runner020.png"));
//
//		} catch (IOException e) {
//		}
		try {
			startImage = ImageIO.read(new File("image/candr.png"));

		} catch (IOException e) {
		}
		
//		try {
//			endImage = ImageIO.read(new URL("http://i.ebayimg.com/images/g/K-sAAOxyOalTbmhu/s-l400.jpg"));
//
//		} catch (IOException e) {
//		}
		try {
			endImage = ImageIO.read(new File("image/end.jpg"));

		} catch (IOException e) {
		}
	}
	public void setImage(BufferedImage image){
		mtn = image;
	}

	public BufferedImage getImage(){
		return mtn;
	}


	public Dimension getPreferredSize() {
		
		if (mtn == null) {
			return new Dimension(100,100);
		} else {
			return new Dimension(mtn.getWidth(null), mtn.getHeight(null));

		}
	}
	public double getMiles(){
		return miles;
	}
	public void setMiles(double miles){
		this.miles = miles;
//		System.out.println("miles set as in component: " + miles);
	}

	public void paint(Graphics g) {

		g.drawImage(mtn, 0, 0, null);
//		System.out.println("painting new bird");
		if(miles<1){
			g.drawImage(startImage, ((int)(miles*1.213))+ 1, mtn.getHeight()-120-((int)(miles*.34)), 50, 70, null, null);
		}else if(miles< 270){
		g.drawImage(rr, ((int)(miles*1.213))+ 1, mtn.getHeight()-120-((int)(miles*.34)), 50, 70, null, null);
		}else if(miles< 325){
			g.drawImage(rr, ((int)(miles*1.213))+ 1, mtn.getHeight()-120-((int)(miles*.38)), 50, 70, null, null);
		}else if(miles < 365){
			g.drawImage(rr, ((int)(miles*1.213))+ 1, mtn.getHeight()-120-((int)(miles*.42)), 50, 70, null, null);
		}else{
			g.drawImage(endImage, mtn.getWidth()/2-100, mtn.getHeight()/2-100, 200, 180, null, null);
		}
		}
	
	public void propertyChange(PropertyChangeEvent evt){
		System.out.println("prop change meth called");
		repaint();
	}
	 public void compImgUpdate(){
		 System.out.println("I am updating");
	 }




}
