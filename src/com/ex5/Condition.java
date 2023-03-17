package com.ex5;

import com.ex5.player.Player;
import com.ex5.server.Room;

public class Condition {

	public static void main(String[] args) {
		Player p1 = new Player("Player1");
		Player p2 = new Player("Player2");

		Room room = new Room();
		room.createRoom(p1, p2);

		int count = 0;
		while (100 > room.getGuestCount()) {
			String guestname = "Guest" + (count++);
			Player guest = new Player(guestname);
			if(!room.addGuest(guest)) {
				guest.logout();
			}
		}

	}
}

/*
 * playerA playerB playerC....Z
 * 
 * updata
 * 
 */
