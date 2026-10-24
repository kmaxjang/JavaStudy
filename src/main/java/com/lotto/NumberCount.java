package com.lotto;

public class NumberCount {

	private int[] numcount = new int[46];
	
	public void numbers(){
		for(int i =0; i < numcount.length; i++){
			numcount[i] = 0;
		}
	}
	
	
	public void count(int[] nums){
		for(int i =0; i < nums.length; i++){
			numcount[nums[i]]++;
		}
	}
	
	
	public void countPrint(){
		for(int i =0; i < numcount.length; i++){
			if(numcount[i] != 0){
				System.out.print(""+i+" ");
				System.out.println("["+numcount[i]+"]");
		}
		}
	}
}
/*
123456           1
12345(7~45)   39
1234(5~44)   
123(5

123456

12345
12346
12456
13456
23456

1234
1235
1236
1245
1246
1256
1345
1356
1456
2345
2346
2356
2456
3456

123
124
125
126
134
135
136
145
146
156
234
235
236
245
246
256
345
346
356
456






*/