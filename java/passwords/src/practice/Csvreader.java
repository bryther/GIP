package practice;

import java.io.Reader;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Csvreader {
	String[] At_risks = new String[100];

	public static void main(String[] args) {
		Csvreader reader = new Csvreader();
		reader.uitlezen();
		reader.schrijven();
	}

	public void uitlezen() {
		int i = 0;
		try {
			BufferedReader lezer = new BufferedReader(
					new FileReader("C:\\Users\\DELL\\Desktop\\stage project\\RiskyUsers.csv"));
			String row;
			while ((row = lezer.readLine()) != null) {
				String[] data = row.split(",");
				/*
				 * JOptionPane.showMessageDialog(null, data[0]); System.out.print(data[2] +
				 * data[4]); System.out.println();
				 */
				if (data[4] == '"' + "Hoog" + '"') {
					At_risks[i] = data[2];
				}
				i++;
			}
			lezer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void schrijven() {
		for (int i = 0; i < At_risks.length; i++) {
			System.out.println(At_risks[i]);
		}

	}
}
