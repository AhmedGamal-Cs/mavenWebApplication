package com.epsillon.Model;

public class Employee {
	int id;
	String fullName;
	String date;
	
	public Employee(int id, String fullName, String date, int salary) {
		this.id = id;
		this.fullName = fullName;
		this.date = date;
		Salary = salary;
	}
	
	int Salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	
}
