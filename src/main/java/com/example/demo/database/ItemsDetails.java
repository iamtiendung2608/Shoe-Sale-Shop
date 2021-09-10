package com.example.demo.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemsDetails {
	@Id
	private String Name;
	@ManyToOne
	private Items item;
	private int Number;
	private long Price;
	private long Total;
	private int Remain;
	private String Origin;
	public ItemsDetails(Items item, int number, long price, int remain, String origin) {
		this.item = item;
		Number = number;
		Price = price;
		Remain = remain;
		Origin = origin;
	}
	public ItemsDetails(long price, int remain, String origin) {
		super();
		Price = price;
		Remain = remain;
		Origin = origin;
	}
	public String getName() {
		return Name;
	}
	public void setName() {
		Name = item.getDescription();
	}
	public Items getItem() {
		return item;
	}
	public void setItem(Items item) {
		this.item = item;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public long getPrice() {
		return Price;
	}
	public void setPrice(long price) {
		Price = price;
	}
	public long getTotal() {
		return Total;
	}
	public void setTotal() {
		Total = Price*Number;
	}
	public int getRemain() {
		return Remain;
	}
	public void setRemain(int remain) {
		Remain = remain;
	}
	public String getOrigin() {
		return Origin;
	}
	public void setOrigin(String origin) {
		Origin = origin;
	}
	public static List<ItemsDetails>getItems(){
		List<ItemsDetails> ItemsList=new ArrayList<>();
		try {
			File file=new File("C:\\Users\\Admin\\eclipse-workspace\\TestShopee\\src\\main\\java\\com\\example\\demo\\database\\Info.txt");
					FileReader reader=new FileReader(file);
					BufferedReader BReader=new BufferedReader(reader);
					String line=null;
			while((line=BReader.readLine())!=null) {
				String[]Details=line.split(" ");
				ItemsList.add(new ItemsDetails(Long.parseLong(Details[0]), Integer.parseInt(Details[1]), Details[2]));
			}
			BReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ItemsList;
	}
}
