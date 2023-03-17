package com.ex5.server;

import java.util.ArrayList;
import java.util.List;

public final class Room {

	private Thread thread = null;	
	private Client[] player= new Client[2];
	private int count= 0;
	private int turn = 0;
	
	private boolean createroom = false;
	private int guestcount =0;
	private List<Client> list = new ArrayList<>();	
	
	public Room() {		
		thread = new Thread(new Runnable() {
			public void run() {
				player[0].updata(null);
				player[1].updata(null);
				
				while(player[turn()].end()) {
					player[turn()].updata(null);
					count();
					player[turn()].updata(null);
					for(Client guest : list) {
						guest.updata(null);
					}
				}
			}
		});
	}
	
	public boolean createRoom(Client p1, Client p2) {
		if(createroom) { 
			return false;
		}
		player[0] = p1;
		player[1] = p2;
		thread.start();
		createroom = true;
		return true;
	}
	
	public synchronized boolean addGuest(Client e) {
		if(!createroom || guestcount > 100) {
			return false;
		}
		
		System.out.println("관중"+e.getName());
		e.updata(null);
		list.add(e);
		guestcount = list.size();
		return true;
	}
	
	public int getGuestCount() {
		System.out.println("관중수"+list.size());
		return list.size();
	}
	
	private void count() {
		count++;
		turn = count%2;		
	}
	
	private int turn() {
		return turn;
	}
	
}
