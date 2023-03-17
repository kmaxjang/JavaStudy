package com.exproject.pattern.thread;

import com.exproject.pattern.thread.PlayCommand;
import com.exproject.pattern.thread.ServerNotify;
import com.game.janggi.ex.interfacemod.Event;
import com.game.janggi.ex.util.Point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Server {

	private List<ServerNotify> guestlist = new ArrayList<ServerNotify>();
	private List<Piece> orderlist = new ArrayList<Piece>();
	private List<Piece> nowPath = new ArrayList<Piece>();

	public Server(Guest han, Guest cho) {

		guestlist.add(han);
		guestlist.add(cho);
	}

	public void add(ServerNotify guest) {
		guestlist.add(guest);
	}

	public void remove(ServerNotify guest) {
		guestlist.remove(guest);
	}

	private Event<Piece> getEvent() {
		return new Event<Piece>() {
			public Piece getLastOrder() {
				return null;
			}

			public int getInning() {
				return orderlist.size();
			}

			public Iterator<Piece> getAllOrder() {
				return orderlist.iterator();
			}

			public Iterator<Piece> nowPath() {
				return nowPath.iterator();
			}

			public boolean Turn() {
				return false;
			}
		};
	}

	private void updata() {
		for (ServerNotify sn : guestlist) {
			sn.updata(getEvent());
		}
	}

	private PlayCommand getPlayCommand(final boolean team) {
		return new PlayCommand() {
			private final int teamchack = team ? 1 : 2;
			private Piece piece;

			public boolean pieceMove(Piece piece,Point p) {
				this.piece = piece;
			    return false;
			}

			public Piece getPiece(Point p) {
				return piece;
			}
		};
	}
}
