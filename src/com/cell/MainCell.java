package com.cell;

public class MainCell {

    public static void msg(String msg) {
	System.out.println(msg);
    }

    private final int size = 100;
    private int[] databox = new int[size];
    private int startloop;

    public void setRandomBox() {
	for (int i = 0; i < size; i++) {
	    databox[i] = i + 1;
	}
	java.util.Random random = new java.util.Random(781203);
	// random.setSeed(781203);
	// random.setSeed(System.currentTimeMillis());
	int tmp = 0, change;
	for (int i = 0; i < size; i++) {
	    change = random.nextInt(size);
	    if (i != change) {
		tmp = databox[i];
		databox[i] = databox[change];
		databox[change] = tmp;
	    }
	}
    }

    public void print() {
	StringBuffer print = new StringBuffer();
	print.append("DataBox\n");
	for (int i = 0; i < size; i++) {
	    print.append("[");
	    print.append(databox[i]);
	    print.append("]");
	}
	print.append("End");
	System.out.println(print);
    }

    public static void main(String[] args) {
	msg("자바 연습");
	MainCell mc = new MainCell();
	mc.setRandomBox();
	mc.print();
    }

}

// Cell.signal(); -> 