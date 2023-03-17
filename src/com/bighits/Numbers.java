package com.bighits;

import java.util.Iterator;

public class Numbers {

	private int[] numbers = new int[6];
	private int bonus = 0;

	public Numbers(int[] number) {
		System.arraycopy(number, 0, numbers, 0, numbers.length);
	}

	public Numbers(int[] number, int bonus) {
		this(number);
		this.bonus = bonus;
	}

	public int length() {
		return numbers.length;
	}
	
	public int getBouns() {
		return bonus;
	}
	
	public int get(int point) {
		return numbers[point];
	}

	public Iterator<Integer> get() {
		Iterator<Integer> iter = new Iterator<>() {

			private int count = 0;

			@Override
			public boolean hasNext() {
				return (count < numbers.length);
			}

			@Override
			public Integer next() {
				int num = numbers[count];
				count++;
				return num;
			}
		};
		return iter;
	}

	public int compare(int number) {		
		for(int c =0; c < numbers.length; c++) {
			if(numbers[c] == number) {
				return c;
			}
		}	
		return -1;
	}
	
	public int compare(Numbers number) {
		int compercount = 0;
		int compare;
		Iterator<Integer> iter1 = get();
		Iterator<Integer> iter2 = number.get();
		
		Integer num1 = iter1.next();
		Integer num2 = iter2.next();
		
		while (true){
			compare = num1.compareTo(num2);
			System.out.println(" "+compare +" <"+ num1 + " ==" + num2);
			if (compare > 0) {
				if (!iter2.hasNext()) {
					break;
				}
				num2 = iter2.next();
			} else if (compare == 0) {	
				compercount++;
				if (!iter1.hasNext() || !iter2.hasNext()) {
					break;
				}
				num1 = iter1.next();
				num2 = iter2.next();
			} else if(compare < 0) {
				if (!iter1.hasNext()) {
					break;
				}
				num1 = iter1.next();
			}
		}
		return compercount;
	}
}