package com.test;
/*
Project: Solution that allows the business to dynamically generating product pricing from a set rules defined by the finance team.
The finance team has given you an initial set of rules on how to price the products, 
however, these rules could change at any time so we need to be able to update the rules easily and rerun the product pricing to see the new prices of the products. 
Date: February 18, 2020
PB
*/

import java.util.Scanner;

class Person{
	private int creditScore;
	private String state;
	
	
	public Person(int creditScore, String state) {
		this.creditScore = creditScore;
		this.state = state;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
}

class Product{
	private String name;
	private double intrestRate;
	private boolean disqualified;
	
	public Product(String name, double intrestRate) {
		this.name = name;
		this.intrestRate = intrestRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getIntrestRate() {
		return intrestRate;
	}

	public void setIntrestRate(double intrestRate) {
		this.intrestRate = intrestRate;
	}

	public boolean getDisqualified() {
		return disqualified;
	}

	public void setDisqualified(boolean disqualified) {
		this.disqualified = disqualified;
	}
	
	
	
	
}

class Rules {
	public void rule(Person person,Product product) {
		Scanner scanI = new Scanner(System.in);
		if (person.getState().equalsIgnoreCase("florida")) {
			product.setDisqualified(true);
		} else if(person.getCreditScore()>=720) {
			System.out.println("Enter Discount");
			double intrest = scanI.nextDouble()/10;
			
			
			product.setIntrestRate(product.getIntrestRate()-(product.getIntrestRate()*intrest));
		}else if (person.getCreditScore()<720 || product.getName().equals("7-1ARM")) {
			double intrest = scanI.nextDouble()/10;
			product.setIntrestRate(product.getIntrestRate()+(product.getIntrestRate()*intrest));
		}
	}
}


class RulesEngine{
	public void runRules(Person person,Product product,Rules rules) {
			rules.rule(person, product);
	}
}


public class Driver {

	public static void main(String[] args) {
		Scanner scanI = new Scanner(System.in);
		Scanner scanS = new Scanner(System.in);
		System.out.println("Enter Credit score");
		int creditScore = scanI.nextInt();
		System.out.println("Enter State");
		String state = scanS.nextLine();
		System.out.println("enter name");
		String name = scanS.nextLine();
		System.out.println("Enter Intrest rate");
		double intrestRate = scanI.nextDouble();
		Person person = new Person(creditScore, state);
		Product product = new Product(name, intrestRate);
		RulesEngine rulesEngine = new RulesEngine();
		Rules rules = new Rules();
		rulesEngine.runRules(person, product, rules);
		System.out.println("Intrest rate is : "+product.getIntrestRate());
		System.out.println("Product is disqualified : "+product.getDisqualified());
	}

}
