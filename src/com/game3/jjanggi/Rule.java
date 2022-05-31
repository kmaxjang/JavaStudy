package com.game3.jjanggi;

public class Rule {

	public static final int ROW = 10;
	public static final int COLUM = 9;

	public static final long time = 5 * 60;
	public static final int list_count = 3;
	public static final long list_time = 1 * 60;
	public static final int move_max_counting = 200;

	public static int[] score = {
	    0,
	    10,
	    5,
	    4,
	    3,
	    2,
	    1
	};

	public static String[] group = {
	    "HAN",
	    "CHO"
	};

	public static String[] piece = {
	    "kING",
	    "CHA",
	    "POO",
	    "MA",
	    "SANG",
	    "SA",
	    "JOL"
	};

	public static final String start_group = group[1];

}
