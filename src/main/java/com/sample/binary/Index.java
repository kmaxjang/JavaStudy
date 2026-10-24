package com.sample.binary;

public class Index {

	public static  void main(String[] args) {
		int p = 10;
		int[] array = new int[p];
		{
			while (p > 0) {
				p--;
				array[p] = p;
			}
		}
		Sort.random(array);
		Sort.screen("배열", array);
		
		TreeKind root = new TreeKind(array[0], null,0);
		TreeKind tmp = null;
		int count = 1;
		while(count < array.length) {			
			tmp = root.addKind(array[count]);
			if(tmp != null) {
				root = tmp;
			}
			count++;
		}
		root.getPrint();
	}
	
}
