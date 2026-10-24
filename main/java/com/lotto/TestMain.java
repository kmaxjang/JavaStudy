package com.lotto;

public class TestMain {

	
	
	public static void main(String[] age){
		
		int[][] numbers ={
				{2,9,12,29,32,45},
				{8,10,24,28,39,41},
				{9,10,18,23,29,31},
				{14,17,21,29,30,37},
				{2,5,15,22,26,37}};
		NumberCount nc = new NumberCount();
		
		for(int i =0; i < numbers.length; i++){
			nc.count(numbers[i]);
		}
		
		nc.countPrint();
	}
}
