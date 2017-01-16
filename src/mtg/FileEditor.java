package mtg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileEditor extends java.util.Observable{//Observable by component image
	private double miles;
	public FileEditor(){
		sumMiles();
//		System.out.println("miles in fe constructor set as: " + miles);
	}
	@SuppressWarnings("finally")
	public void sumMiles(){

		double sum = 0;
		String line = null;

		try {

			FileReader fileReader = 
					new FileReader("image/miles.txt");

			//wraping FileReader in BufferedReader for efficiency
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(" ");
				for(String s: words){
					sum += Double.parseDouble(s);
				}
			}   

			//close file
			bufferedReader.close(); 
			this.miles = sum;
//			System.out.println("new sum is:" + sum);
//			System.out.println("fe miles are: " + getMiles());



		}
		catch(FileNotFoundException ex) {
//			System.out.println(
//					"Unable to open file");                
		}
		catch(IOException ex) {
//			System.out.println(
//					"Error reading file");                  

		}
		setChanged();
		notifyObservers();
		this.miles= sum;

	}

	public void addMiles(double miles_to_add){
//		System.out.println("entered add miles method");
		if(miles_to_add<365 || miles_to_add>0){
			try(FileWriter fw = new FileWriter("image/miles.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw))
			{
				out.println(miles_to_add);

			} catch (IOException e) {
				//exception handling left as an exercise for the reader
			}
		}
		sumMiles();
	}

	public double getMiles(){
		return miles;
	}

	public void resetMiles(){
		try{
			PrintWriter writer = new PrintWriter("image/miles.txt");

			writer.print("");
			writer.print("0");
			writer.close();
			setChanged();
			notifyObservers();

		}catch (FileNotFoundException e) {
//			System.out.println(
//					"Unable to open file"); 
		}


	}
}



