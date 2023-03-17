package com.bighits;

import java.nio.ByteBuffer;

public class Lotto {

	public static void msg(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {

		ByteClass bc = new ByteClass();

		bc.setInteger(46);
		bc.setInteger(44);
		bc.setInteger(43);
		bc.setInteger(42);
		bc.setInteger(41);
		bc.setInteger(40);
		bc.setInteger(0);
		bc.setChange(2, 2);
		msg("" + 0 % 100);

		msg("================" + bc.getInteger() + "\npoint" + bc.get(1) + "\nsimple" + bc.getSimple(3));

		int[] in = {
		    1,
		    2,
		    14,
		    56,
		    45,
		    14,
		    11,
		    26,
		    33,
		    4,
		    17,
		    19,
		    23,
		    34,
		    42,
		    39,
		    27,
		    18,
		    3,
		    4,
		    6
		};
		NumbersBuild nums = new NumbersBuild();
		nums.set(5);
		nums.delete(5);
		nums.set(in);
		nums.delete(2);
		nums.change(1, 44);
		nums.set(45444342414039L);

		int[] bak = nums.get();
		if (bak == null) {
			msg("null 등록번호 없다");
		} else {
			for (int i = 0; i < bak.length; i++)
				System.out.println("Limet" + nums.getCount() + " " + bak.length + " " + bak[i] + "  " + nums.get());
		}

//    Chain.getChain().link(0);
		ByteBuffer bb = ByteBuffer.allocate(1024);
		msg(bb.toString());
		int[] num1 = {1,3,5,7,9,11};
		int[] num2 = {2,4,6,8,10,12};
		Numbers number1 = new Numbers(num1);
		Numbers number2 = new Numbers(num2);
		msg("확인 1"+number1.compare(4));
		msg("확인 2"+number2.compare(4));
		int comper = number1.compare(number2);
		msg("비교"+comper);
	}
}