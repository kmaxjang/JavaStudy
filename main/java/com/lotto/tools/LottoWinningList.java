package com.lotto.tools;

import java.util.Iterator;

public class LottoWinningList {

	private boolean cycle = false;
	private int max_week = 15;
	private int max_ball = 7;
	private int[][] list = new int[max_week][max_ball];
	private int point = 0;

	public LottoWinningList() {
		int[] number = new int[45];
		int random = 0;
		for (int i = 0; i < number.length; i++) {
			number[i] = i + 1;
		}
		int count = 0;
		while (100 > count) {
			for (int i = 0; i < number.length; i++) {
				random = (int) (Math.random() * 45);
				if (i != random) {
					number[i] += number[random];
					number[random] = number[i] - number[random];
					number[i] -= number[random];
				}
			}
			count++;
		}

		for (; point < max_week; point++) {
			System.out.print("list["+point+"]");
			for (int i = 0; i < list[point].length; i++) {

				random = (int) (Math.random() * 45);

				list[point][i] = number[random];
				System.out.print(" "+number[random]);
			}
			System.out.println(" ");
		}
		pointplus();
		
		System.out.println("Cycle    ="+ cycle);
		System.out.println("Max_week ="+max_week);
		System.out.println("Max_ball ="+max_ball);
		System.out.println("Point    ="+point);		

	}

	public void addWinningNumbers(int[] numbers, int bonus) {		
		if (chack2(numbers))
			return;		
		for (int p = 0; p < numbers.length; p++) {
			list[point][p] = numbers[p];
		}
		list[point][max_ball - 1] = bonus;
		pointplus();		
	}

	public void setWinningNumbers(int spoint, int[] numbers, int bonus) {		
		if (chack1(spoint))
			return;
		if (chack2(numbers))
			return;		
		for (int p = 0; p < numbers.length; p++) {
			list[spoint][p] = numbers[p];
		}
		list[spoint][max_ball - 1] = bonus;
		System.out.println(""+spoint);
		for(int e: list[spoint])
		System.out.print(" "+e);
	}

	public int[] getWinningNumbers(int point) {
		if (chack1(point))
			return null;
		int[] numbers = new int[max_ball];
		System.arraycopy(list[point], 0, numbers, 0, list[point].length);
		return numbers;
	}

	public Iterator<int[]> getWinningNumbers() {
		
		return new numberlist();
	}

	public void Save() {

	}

	public void Load() {

	}

	private boolean chack1(int cpoint) {
		return (cpoint < 0 || (cycle) ? (cpoint >= max_week) : (cpoint >= point));
	}

	private boolean chack2(int[] numbers) {		
		return (numbers == null || numbers.length != (max_ball - 1)) ? true : false;
	}

	private void pointplus() {
		if (point >= (max_week )) {
			cycle = true;
			point = 0;
		} else {
			point++;
		}
		System.out.println("PPPPP =="+point);
	}

	private class numberlist implements Iterator<int[]> {

		private boolean flag = true;
		private int cp = 0;

		public numberlist(){
			cp = (cycle) ? point : 0;
			System.out.println(cp+" =="+point);
		}
		
		public boolean hasNext() {
			if (!cycle && point == 0)
				return false;			
			
			return flag;
		}

		public int[] next() {
			int bp = cp;
			System.out.println(cp+" =="+point);
			cpplus();
			return list[bp];
		}

		private void cpplus() {
			if (cp >= (max_week -1)) {
				cp = 0;
			} else {
				cp++;
			}
			if(cp == point){
				flag = false;
			}
		}

	}
	
	public static void main(String[] arg){
		
		LottoWinningList lwl = new LottoWinningList();
///*		
		int[] win ={1,2,3,4,5,6};
		lwl.addWinningNumbers(win, 7000);
		lwl.addWinningNumbers(win, 7000);
		lwl.addWinningNumbers(win, 7000);
		lwl.addWinningNumbers(win, 7000);
		lwl.setWinningNumbers(0, win, 0);
		lwl.setWinningNumbers(1, win, 100);
		lwl.setWinningNumbers(2, win, 200);
		lwl.setWinningNumbers(3, win, 300);
		lwl.setWinningNumbers(4, win, 400);
		lwl.setWinningNumbers(5, win, 500);
		lwl.setWinningNumbers(6, win, 600);
		lwl.setWinningNumbers(7, win, 700);
//		/*		
		System.out.println("���� ");
		Iterator<int[]> list = lwl.getWinningNumbers();
		while(list.hasNext()){
			win = list.next();
			for(int i= 0; i < win.length; i++)
				System.out.print("["+win[i]+"] ");
			System.out.println(" ");
		}
///*		
		System.out.println("����2 ");
		lwl.setWinningNumbers(0, win, 7);
		lwl.addWinningNumbers(win, 7);
		lwl.addWinningNumbers(win, 7);
		lwl.addWinningNumbers(win, 7);
		lwl.addWinningNumbers(win, 7);
		
		list = lwl.getWinningNumbers();
		while(list.hasNext()){
			win = list.next();
			for(int i= 0; i < win.length; i++)
				System.out.print("["+win[i]+"] ");
			System.out.println(" ");
		}
//*/		
		
		
		
		
	}

}
