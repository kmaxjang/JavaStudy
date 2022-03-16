package com.lotto.tools;

public class Chance {

	private int length;
	private int[] numbers;
	private int max_number;
	private int min_number;
	
	public Chance(){
		
		
	}
	
	public void number(int[] numbers){
		int length = 6;
		int[] sixball = new int[length];
		int[] sixball_point = new int[length];
		int[] sixball_max = new int[length];		
		int count =0;
		int point = length-1;
		boolean flag = true;
		
		for(int cycle=0; cycle < sixball.length; cycle++){
			sixball_point[cycle] = cycle;
			sixball_max[cycle] = (numbers.length-(sixball.length-cycle));
		}
		print("�ʱ��ڸ���ġ", sixball_point);
		print("�ڸ��� �ִ����", sixball_max);
do{		
		for(int cycle=0; cycle < sixball.length; cycle++){
			sixball[cycle] = numbers[sixball_point[cycle]];
		}
		count++;
		print("��ȣ���("+count+")",sixball);
		
		while(flag && (point >= 0)){
			if(sixball_point[point] >= sixball_max[point]){
				point--;
			}else{
				sixball_point[point]++;
				for(; point < length-1; point++){
					sixball_point[point+1]= sixball_point[point]+1;
				}					
				flag = false;
			}			
		}
		if(count <1004){
			flag = true;
		}
//		print(point+"Cycle+point", sixball_point);
 }while(flag && (point >= 0));

		print("�����ڸ� ������", sixball_point);
		print("ī����( "+count+" ) ���������: ",sixball);		
	}
	
	public void print(String title, int[] number){
		System.out.println(title);
		for(int i= 0; i< number.length; i++){			
			System.out.print("["+number[i]+"]");
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args){
		
		Chance chance = new Chance();
		
		int[] number = new int[10];
		for(int i= 0; i< number.length; i++){
			number[i] = i+1;			
		}
		chance.print("ball", number);
		
		chance.number(number);
		
		
	}


}
