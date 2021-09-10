package com.example.demo.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Items {
	@Id
	private String Source;
	private String Description;
	private int Details;
	public Items(String source, String description, int details) {
		super();
		Source = source;
		Description = description;
		Details = details;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String descrpition) {
		Description = descrpition;
	}
	public int getDetails() {
		return Details;
	}
	public void setDetails(int details) {
		Details = details;
	}
	public static List<Items> getImage() {
		List<Items> Source=new ArrayList<>();
		try {
			File file=new File("C:\\Users\\Admin\\eclipse-workspace\\TestShopee\\src\\main\\java\\com\\example\\demo\\database\\sourceImage.txt");
					FileReader reader=new FileReader(file);
					BufferedReader BReader=new BufferedReader(reader);
					String line=null;
			while((line=BReader.readLine())!=null) {
				String[]Details=line.split(" ");
				Source.add(new Items(Details[0],Details[1]+" "+Details[2]+" "+Details[3],Integer.parseInt(Details[4])));
			}
			BReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Source;
	}
	@Override
	public String toString() {
		return "Items [Source=" + Source + ", Description=" + Description + ", Details=" + Details + "]";
	}
	public Items() {}
}
