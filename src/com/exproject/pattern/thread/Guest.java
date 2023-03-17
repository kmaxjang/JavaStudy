package com.exproject.pattern.thread;

import com.game.janggi.ex.interfacemod.Event;

public class Guest implements ServerNotify {

  private String name;
  private int count = 0;
  private Thread t;
  private boolean exit = true;
  private int r = 0, tmp = 0;

  public Guest(String name) {
    this.name = name;
    thread();
  }
  @Override
  public void updata(Event e) {}

  private synchronized int getCount() {
    count++;
    return count;
  }

  private void thread() {
	t = new Thread(
	    new Runnable(){
		public void run(){
		    System.out.println("T스래드 시작");
		    while( getCount() < 200 ){
			try{
			    r = random(r, 10);
			    if( r > 10 ){
				System.out.println(name + " " + r);
			    }
			    tmp += r;
			    Thread.sleep(10);
			}catch( Exception e ){
			    
			}
		    }
		    exit = false;
		    System.out.println(name + "T스래드 종료" + count + " " + tmp);
		}
	    });
	t.start();
  }

  public boolean exit() {
    return exit;
  }
  
  public int random(int min_number, int length){
    return (int)(Math.random()* length + min_number);
  }

@Override
public String setting(String masag, PlayCommand command) {
	
	return null;
}
}
