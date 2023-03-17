package com.screen;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class MainScreen {

    // 4k
    private final int x = 1920;
    private final int y = 1080;
    private int[][] screen = new int[x][y];
    private int wall_mark = 9;
    private int space_mark = 0;

    private StringBuffer view = new StringBuffer(x * (y+2));

    public MainScreen() {
	reset();
    }

    public void drow() {	
	screen();
    }

    public void reset() {
	for (int x = 0; x < screen.length; x++) {
	    for (int y = 0; y < screen[x].length; y++) {
		if (x == 0 || y == 0 || x == screen.length - 1 || y == screen[screen.length - 1].length - 1) {
		    screen[x][y] = wall_mark;		    
		} else {
		    screen[x][y] = space_mark;
		}
	    }
	}
    }

//    	screen[0][0] screen[1][0] screen[2][0]	    
//    		screen[0][1] screen[1][1] screen[2][1]
//    			screen[0][2] screen[1][2] screen[2][2]

    public void screen() {
	view.delete(0, view.length());
	for (int x = 0; x < screen.length; x++) {
	    for (int y = 0; y < screen[x].length; y++) {
		view.append(screen[x][y]);
	    }
	    view.append("\n");
	}
	System.out.println(view.length());
    }

    public static void main(String[] args) {
//	MainScreen ms = new MainScreen();
//
//	int count = 0;
//	long sleep = 0;
//	while (count < 10000) {
//	    sleep = System.currentTimeMillis();
//	    ms.drow();
//	    sleep = System.currentTimeMillis() - sleep;
//	    System.out.println("Count "+ count+ " Time "+sleep);
//	    count++;	    
//	}
	
	Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();
        
        IntStream.iterate(1, i -> i + 1)
                 .filter(i -> uniqueNumbers.size() < 100)
                 .limit(100)
                 .forEach(i -> uniqueNumbers.add(random.nextInt(100) + 1));
        
        System.out.println("Unique random numbers: " + uniqueNumbers);
    }
}
