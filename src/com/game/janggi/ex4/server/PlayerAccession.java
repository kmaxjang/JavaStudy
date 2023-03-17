package com.game.janggi.ex4.server;

public final class PlayerAccession {

	private String id;	
	private String password;
	
	private String nickname;
	private int count =0;
	private StringBuffer sb =null;
	private boolean flag = false;
	
	private MainServer ms = MainServer.getInstant();
	
	
	public PlayerAccession() {
		
	}
	
	public boolean setID(String id) {
		if(null != ms && !ms.isIDCheck(id)) {
			this.id = id;
			count++;
			return true;
		}
		return false;
	}
	
	public boolean setPassword(String password) {
		// check
		if(true) {
			this.password = password;
			count++;
			return true;
		}
		return false;
	}
	
	public boolean setNickname(String nickname) {
		if(null != ms && !ms.isNicknameCheck(nickname)) {
			this.nickname = nickname;
			count++;
			return true;
		}
		return false;
	}
	
	public boolean setAccession() {
		if(3 == count) {
			count=0;
			flag = true;
			return ms.setAccession(this);		
		}		
		return false;
	}
	
	public String toString() {
		if(flag) {
			sb = new StringBuffer();
			sb.append(id);
			sb.append(' ');
			sb.append(password);
			sb.append(' ');
			sb.append(nickname);
			System.out.println(sb+"����");
			flag = false;
			return sb.toString();
		}		
		return null;		
	}
}
