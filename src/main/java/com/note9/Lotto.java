package com.note9;

public class Lotto {

	// 삼각형그리기
	public void setAngel(int layer) {

		StringBuffer str = new StringBuffer();
		str.append("Layer : " + layer + "\n");
		int step = layer;
		do {
			for (int spese = 1; spese <= step; spese++) {
				str.append(" ");
			}
			for (int angel = 1; angel <= (layer - step); angel++) {
				str.append("▲");
			}
			str.append("\n");
		} while ((step--) > 0);
		for (int angel = 0; angel < layer; angel++) {
			str.append("*");
		}
		str.append("\n");
		scr(str.toString());
	}

	// 화면 출력 간단히
	public static void scr(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {

		/*
		 * FileSystem fs = FileSystems.getDefault(); for(FileStore st :
		 * fs.getFileStores()){ scr("파일명" + st.name()); scr("타입" + st.type()); try{
		 * scr("용량" + st.getTotalSpace()); scr("============="); }catch(Exception e){
		 * 
		 * } }
		 */

		ByteClass bc = new ByteClass();
		bc.set(46);
		bc.set(44);
		bc.set(43);
		bc.set(42);
		bc.set(41);
		bc.set(40);
		bc.set(0);
		bc.setChange(2, 2);
		scr("" + 0 % 100);
		scr("================" + bc.getSerialNumber() + "\npoint" + bc.get(1) + "\nsimple" + bc.getSimple(3));

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
		nums.set(5);
		nums.delete(5);
		nums.set(in);
		nums.delete(2);
		nums.change(1, 44);
		nums.setSerialNumber(304050607);

		int[] bak = nums.get();
		if (bak == null) {
			scr("null �벑濡앸쾲�샇 �뾾�떎");
		} else {
			for (int i = 0; i < bak.length; i++)
				System.out.println(
				        "Limet" + nums.getLimet() + " " + bak.length + " " + bak[i] + "  " + nums.getSerialNumber());
		}
	}
}
