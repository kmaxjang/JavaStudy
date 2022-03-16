package com.lotto.tools;

public final class User {

	private final static User USER = new User();
	
	private Session session;
	
	private String id = null;	
	private boolean logincheck = false;
	
	private User(){
		// ���ͳݿ� �����Ͽ� �α��� �غ� �Ѵ�.
		session = new Session("logtime");
		// ���н� ����		
	}
	
	public static User getUser(){
		return USER;
	}

	public boolean Join(String id, String password, String etc){
		// ���̵� üũ (���̵�� �̸���)
		// �佺���� ���� üũ
		// ��Ÿ���� null
		return session.join(id, password, etc);
	}
	
	public boolean Leave(){
		if(logincheck){
			return session.leave();
		}
		return false;
	}
	
	public boolean Login(String id, String password){
		if(!logincheck)
			if(session.login(id, password)){
				session.getData(); // ����� ���
				this.id =id;
				logincheck = true;
				return true;
			};
	
		return false;
	}
	
	public void Logout(){
		logincheck = false;		
	}
	
	public boolean LoginCheck(){		
		return logincheck;
	}
	
	public void setData(String data){
		session.setdata(id, data);
	}
	
	public void getData(){
		
	}
			
	// ���� ���ͳ��� ������
	private class Session{		
		
		public Session(String logtime){
			
		}
		
		public boolean join(String id, String password, String etc){
			// db user check
			return true;
		}
		
		public boolean leave(){
			// db user delete
			return false;
		}
		
		public boolean login(String id, String password){
			// db user check
			// password check
			// logtime
			return true;
		}
		public String getData(){
			// ����� ���
			return null;
		}
		public void setdata(String id, String data){
			
		}
	}	
	
}


