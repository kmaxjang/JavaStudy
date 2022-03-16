package com.lotto.io;

public interface Streams {

	public enum Edit{ CHANGE, INSERT};
	public void setNumbers(int[] numbers);	
	public void setNumbers(int sp, int[] numbers, Edit edit);
	public void setNumbers(int[][] numbers);	
	public void setNumbers(int sp, int[][] numbers, Edit edit);	
	public int[] getNumbers();	
	public int[] getNumbers(int sp);	
	public int[][] getNumbers(int sp, int ep);
	public int getSize();
	public boolean delete(int sp, int ep);
}
