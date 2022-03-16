package com.jjanggi2;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.jjanggi2.server.MainServer;
import com.jjanggi2.server.PlayerAccession;
import com.jjanggi2.server.User;

public class GameStart {

	private MainServer ms= null;
	
	public GameStart() {
		ms = MainServer.start();
		
		Player[] player = new Player[10];
		for(int i=0; i< player.length; i++) {
		PlayerAccession pa = new PlayerAccession();
		
		String id ="��ȿõ";
		String password = id;
		String nickname = id;
		
		if(pa.setID(id))
			if(pa.setPassword(password))
				if(pa.setNickname(nickname))
					pa.setAccession();
		
		player[i]= ms.login(id, password);
		}
		
		System.out.println("====���� ������ ���====");
		Iterator<String> list = ms.getPlayerList().iterator();
		while (list.hasNext()) {
			System.out.println("�̸� : " + list.next());				
		}
		System.out.println("==================");
	}	
	
	
	
	
	
	
	public static void main(String[] arg) {
		new GameStart();
	}
}
