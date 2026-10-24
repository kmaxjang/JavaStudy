package com.game.janggi.ex;

import java.util.ArrayList;
import java.util.List;

import com.game.janggi.ex.interfacemod.Play;
import com.game.janggi.ex.interfacemod.TimeRequester;

public class Player implements TimeRequester {

	private List record = new ArrayList();
	private String name;

	private Play play;

	private String data;
	
	private StringBuffer timestr = new StringBuffer();

	public Player(String name) {
		this.name = name;
	}

	public String getClassName() {
		return name;
	}

	public String[] getInfo() {
		return null;
	}

	public String setGamePlay(String masan, Play play) {
		this.play = play;
		return "3434";
	}

	public void updata(String path) {

	}

	@Override
	public void timeUpdata(int[][] time) {		
		
		number(timestr,time[0][1]).append(':');
		number(timestr,time[0][2]);
		timestr.append('(').append(time[0][0]).append(')');
		
		timestr.append('(').append(time[1][0]).append(')');
		number(timestr,time[1][1]).append(':');
		number(timestr,time[1][2]);

		System.out.println(timestr);
		timestr.delete(0, 20);
		
	}
	
	private StringBuffer number(StringBuffer sb, int number) {
		if(number<10)
			sb.append('0');
		sb.append(number);
		return sb;
	}

	@Override
	public void timeOver(boolean timeover) {		
		
	}
}
