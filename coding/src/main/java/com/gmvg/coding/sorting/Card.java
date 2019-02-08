package com.gmvg.coding.sorting;

import java.util.Comparator;


public class Card implements Comparable<Card> {
	private String name ;
	private int number ;
	
	public Card(String name,int number) {
		this.name = name ;
		this.number = number;
	}
	
	public String getName( ) {
		return this.name;
	}
	public int getNumber() {
		return number ;
	}
	
	@Override
	public int compareTo(Card c) {
	 return Comparator.comparing(Card::getName)
				.thenComparingInt(Card::getNumber)
				.compare(this, c);
				
	}
}