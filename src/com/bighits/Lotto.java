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
		Numbers nums = new Numbers();
		nums.setNumber(5);
		nums.deleteNumber(5);
		nums.setNumber(in);
		nums.deleteNumber(2);
		nums.changeNumber(1, 44);
		nums.change(45444342414039L);

		int[] bak = nums.getNumbers();
		if (bak == null) {
			msg("null 등록번호 없다");
		} else {
			for (int i = 0; i < bak.length; i++)
				System.out.println("Limet" + nums.getLimet() + " " + bak.length + " " + bak[i] + "  " + nums.change());
		}

//    Chain.getChain().link(0);
		ByteBuffer bb = ByteBuffer.allocate(1024);
		msg(bb.toString());
	}
}