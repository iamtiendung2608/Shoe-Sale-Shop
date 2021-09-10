package com.example.demo.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class UserInfo {
	@Id
	@NotNull
	@Size(min=4,message="Name must have more than 4 characters long")
	private String Name;
	@Min(value=18,message="You must older than 18")
	private int Age;
	@NotNull()
	@Size(min=4,message="Gender must not be null")
	private String Gender;
	public UserInfo(String name, int age, String gender) {
		super();
		Name = name;
		Age = age;
		Gender = gender;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	@Override
	public String toString() {
		return "UserInfo [Name=" + Name + ", Age=" + Age + ", Gender=" + Gender + "]";
	}
	public UserInfo() {};
}
