package com.game.janggi.ex5;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

	private Command command = new Command();
	public HashMap<Integer, Integer> piece_path = new HashMap<>(32);
	private ArrayList<Integer> history = new ArrayList<>(200);
	
	private Player[] player = new Player[2];
	private ArrayList<Player> guest = new ArrayList<>();

	public Room(Player p1, Player p2) {
		player[0] = p1;
		player[1] = p2;
		defaultPath(1, 3);
	}

	private void updata() {
		while (command.isUpdata()) {

		}
	}

	private void defaultPath(int cho, int han) {
		int[] default_piece = { 0, 22, 1, 20, 2, 20, 3, 26, 5, 26, 6, 20, 7, 20, 8, 22, 13, 21, 19, 23, 25, 23, 27, 27,
				29, 27, 31, 27, 33, 27, 35, 27, 54, 17, 56, 17, 58, 17, 60, 17, 62, 17, 64, 13, 70, 13, 76, 11, 81, 12,
				82, 10, 83, 10, 84, 16, 86, 16, 87, 10, 88, 10, 89, 12 };
		
		cho = cho/4 *4;
		han = han/4 *4;
		int[] piece = {
				4,5,4,5,
				5,4,5,4,
				4,5,5,4,
				5,4,4,5
		};
		default_piece[2]+=piece[cho];
		default_piece[3]+=piece[cho+1];
		default_piece[7]+=piece[cho+2];
		default_piece[8]+=piece[cho+3];
		default_piece[19]+=piece[han];
		default_piece[21]+=piece[han+1];
		default_piece[26]+=piece[han+2];
		default_piece[28]+=piece[han+3];
		
		for (int i = 0; i < default_piece.length; i += 2) {
			piece_path.put(default_piece[i], default_piece[i + 1]);
		}
	}
}
