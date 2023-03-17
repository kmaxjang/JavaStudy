package com.game.janggi.ex4.server;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.game.janggi.ex4.Player;

public final class MainServer implements Runnable {

	
	private static MainServer ms = null; 
	// ������ ��� key = id+password value = nickname
	private HashMap<String, String> player_data = new HashMap<String, String>();
	// ������ ��� key = nickname value = ��������
	private HashMap<String,Player> player_online_list = new HashMap<String,Player>();

	enum Kinds{
		KING, SA, ZZU, SSAN, MA, PO, CHA;		
	}
	
	public enum Seat{
		MSMS(4545), MSSM(4554), SMMS(5445), SMSM(5454);
		private int seat;
		
		Seat(int seat) {
			this.seat =seat;
		}
		
		public int get() {
			return seat;
		}
	}
		
	private MainServer() {
		
		
	}
	
// ���μ��� ����
	public static MainServer start() {
		if(null ==ms) {
			ms = new MainServer();
			new Thread(ms).start();
			System.out.println("���μ��� ����");
		}		
		return ms;
	}
	
// ���� ����	
	public static void end() {
		ms = null;
	}
	
// ���� ����	
	public static MainServer getInstant() {
		return ms;
	}

// ���̵� üũ
	public boolean isIDCheck(String id) {
		
		return false;
	}
	
// �г��� üũ
	public boolean isNicknameCheck(String nickname) {
		
		return false;
	}
	public void setBoard(Player player, boolean team, Seat Setting) {
		
	}

// ���̵� ����
	public boolean setAccession(PlayerAccession info) {
		String str = info.toString();
		if(null != str ) {
			String[] data = str.split(" ");
			if(3 == data.length) {
				player_data.put(data[0]+" "+data[1], data[2]);			
				return true;
			}			
		}		
		return false;
	}
	
// �α���	
	private int count=0;
	public Player login(String id, String password) {
		if(player_data.containsKey(id+" "+ password)) {
			Player player = new User(id , player_data.get(id+" "+ password));
			player_online_list.put(player.getNickname(),player);
			System.out.println(player.getNickname()+"���� ���� ����"+count++);
			return player;
		}		
		return null;		
	}
	
	public static void main(String[] arg) {
		System.out.println("JJanggi Server Start.");

		Info info = new Info(1270);
		System.out.println(info.getData());
		info.setPoint(new Point(1, 3));
		System.out.println(info.getData());

	}

	public Set<String> getPlayerList() {
		
		return player_online_list.keySet();
	}

	public void setApply(String player_name) {
		if(player_online_list.containsKey(player_name)) {
			player_online_list.get(player_name).getApply();
		}
		
	}

	public void run() {
		
		System.out.println("����");
		
		
		System.out.println("����");
		
	}

	public void logout(Player player) {
		
		player_online_list.remove(player);
		System.out.println("��������");
	}

	
}
