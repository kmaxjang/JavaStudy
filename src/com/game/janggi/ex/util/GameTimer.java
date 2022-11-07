package com.exproject.janggi.util;

import java.util.Timer;
import java.util.TimerTask;

import com.exproject.janggi.interfacemod.TimeRequester;

public class GameTimer {

	private final int last_count = 0;
	private final int minute = 1;
	private final int sec = 2;

	private int[][] time = { { 3, 5, 0 }, { 3, 5, 0 } }; // COUNTDOWN, MINUTE, SECOND
	private int countdown = 30; // list second	
private boolean turn_flag = false;
	private boolean[] last_flag = { false, false }; // last_count flag
	private int player = 1; // 1 => 초 false  0 => 한 true
	private TimeRequester[] requester = new TimeRequester[2]; // 타임알림 인터페이스

	private Timer timer = new Timer();
	private TimerTask task = new TimerTask() {
		public void run() {
		if(turn_flag){
		player = (player == 0) ? 1 : 0; 
}
turn_flag = false;
			if (last_flag[player]) {
				// Last Count
				if (time[player][sec] > 0) {
					time[player][sec]--;
				} else {
					if (time[player][last_count] > 1) {
						time[player][last_count]--;
					} else {
						timeOver(player); // 타임종료
						return;
					}
					time[player][sec] = countdown;
				}
			} else {
				// Count
				if (time[player][sec] > 0) {
					time[player][sec]--;
				} else {
					if (time[player][minute] > 0) {
						time[player][minute]--;
						time[player][sec] = 59;						
					} else {
						last_flag[player] = true;
						time[player][sec] = countdown;
					}
				}
			}
			updata();
		}
	};

	public GameTimer(TimeRequester requester1, TimeRequester requester2) {
		requester[0] = requester1;
		requester[1] = requester2;		
	}

	public void timerStart(int countdown, int minute, int sec) {
		this.countdown = countdown;
		for (int i = 0; i < time.length; i++) {
			time[i][this.minute] = minute;
			time[i][this.sec] = sec;
		}
		timer.schedule(task, 0, 1);
	}

	public void endOfTurn() {
		synchronized (this) {
		turn_flag = true;
			if (last_flag[player]) {
				time[player][sec] = countdown;
			}
			}
	}

	private void updata() {
		synchronized (this) {
			for (TimeRequester tr : requester) {
				tr.timeUpdata(time);
			}
		}
	}

	private void timeOver(int player) {
		timer.cancel();
		for (TimeRequester tr : requester) {
			tr.timeOver((player == 0) ? true : false);
		}
	}

	public static void main(String[] args) {		
		TimeRequester requester1 = new TimeRequester() {
			private boolean player = true;
			private StringBuffer timestr = new StringBuffer();
			
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
				System.out.println((player == timeover) ? "시간패" : "시간승");
			}
		};
		
		TimeRequester requester2 = new TimeRequester() {
			private boolean player = false;

			@Override
			public void timeUpdata(int[][] time) {
//				System.out.print(time[1][1] + ":" + time[1][2]+"[" + time[1][0] + "]");
//				System.out.println(" [" + time[0][0] + "]" + time[0][1] + ":" + time[0][2]);
			}

			@Override
			public void timeOver(boolean timeover) {
				System.out.println((player == timeover) ? "시간패" : "시간승");
			}
		};
		GameTimer time = new GameTimer(requester1, requester2);
		int t = 1;
		time.timerStart(5, t, 0);
		try{
		  Thread.sleep(10*60*t);
		  
}catch (Exception e){
  
}
System.out.println("종료");
	}
}
