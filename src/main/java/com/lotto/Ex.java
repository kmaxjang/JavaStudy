package com.lotto;

public class Ex {

	
	private int[] number = new int[46];

	public void setNumber(){
		for(int i =0; i< number.length; i++){
			number[i]=0;
		}
	}
	
	public void  input(int[] num){
		
		for(int i=0; i<num.length; i++){
			if(num[i] >= 1 && num[i] <=45){
				number[num[i]]++;				
			}
		}		
	}
	
	public void output(){
		
		for(int i =0, c =1; i< number.length; i++){
			if(number[i] == 0){
			System.out.println((c++)+" Number["+i+"] ="+ number[i]);			
			}
		}		
	}
	
	public void cycnum(int[] num){
		System.out.println("["+num[0]+"]["+num[1]+"]["+num[2]+"]["+num[3]+"]["+num[4]+"]["+num[5]+"]\n");
		
		for(int i = 1; i <= 44; i++){			
				num[0]++;
				num[1]++;
				num[2]++;
				num[3]++;
				num[4]++;
				num[5]++;
				if(num[5] > 45){					
					num[5] = num[4];
					num[4] = num[3];
					num[3] = num[2];
					num[2] = num[1];
					num[1] = num[0];
					num[0] =1;					
				}						
			System.out.println("["+num[0]+"]["+num[1]+"]["+num[2]+"]["+num[3]+"]["+num[4]+"]["+num[5]+"]");
		}

		
		
	}
	
	public static void main(String[] age){
		Ex ex = new Ex();
		ex.setNumber();
		int[][] n ={{8,12,15,20,33,42},
				{5,11,16,34,36,45},
				{9,20,23,26,32,33},
				{5,7,31,32,34,40},
				{9,16,20,26,27,35}
		};
		
		ex.input(n[0]);
		ex.input(n[1]);
		ex.input(n[2]);
		ex.input(n[3]);
		ex.input(n[4]);
		
		ex.output();
		
		ex.cycnum(n[1]);
	}
}
