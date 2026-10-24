package com.screen;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class MainScreen {

    // 4k
    private final int WIDTH = 40;
    private final int LENGTH = 30;
    private String[][] screen_data = new String[WIDTH][LENGTH];

    private final String wall_mark = "■";
    private final String space_mark = "□";
    private final String[] worm_head = {"▲","◀","▼","▶"};
    private final String bady_mark = "▣";
    private final String[] worm_tail = {"∪","⊃","⊂","∩"};
    private LinkedHashMap<Integer,String> worm_bady = new LinkedHashMap<>();
    
    private StringBuffer view_buffer = new StringBuffer(WIDTH * (LENGTH + 2));

    public MainScreen() {
	reset();
	
    }

    private int way = 0;
    private int move =15;
    public void worm() {
	if(move > 1) {
	    move--;
	}
	screen_data[20][move] = worm_head[way];
	screen_data[21][move] = bady_mark;
	screen_data[22][move] = worm_tail[way];
    }
    
    public void drow() {
	screen();
	worm();
    }

    public void reset() {
	for (int x = 0; x < WIDTH; x++) {
	    for (int y = 0; y < LENGTH; y++) {
		if (x == 0 || y == 0 || x == WIDTH - 1 || y == LENGTH - 1) {
		    screen_data[x][y] = wall_mark;
		} else {
		    screen_data[x][y] = space_mark;
		}
	    }
	}
    }

    public void screen() {
	view_buffer.delete(0, view_buffer.length());
	for (int x = 0; x < screen_data.length; x++) {
	    for (String data :screen_data[x]) {
		view_buffer.append(data);
	    }
	    view_buffer.append("\n");
	}
//	System.out.print("\033[H\033[2J");
//      System.out.flush();       
	System.out.println(view_buffer);	
    }

    public static void main(String[] args) {
	MainScreen ms = new MainScreen();

	int count = 0;
	long sleep = 0;
	while (count < 100000) {
	    sleep = System.currentTimeMillis();
	    ms.drow();
	    sleep = System.currentTimeMillis() - sleep;
	    System.out.println("Count " + count + " Time " + sleep);
	    count++;
	}

	Random random = new Random();
	Set<Integer> uniqueNumbers = new HashSet<>();

	IntStream.iterate(1, i -> i + 1).filter(i -> uniqueNumbers.size() < 100).limit(100)
		.forEach(i -> uniqueNumbers.add(random.nextInt(100) + 1));

	System.out.println("Unique random numbers: " + uniqueNumbers);
    }
}
