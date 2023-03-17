package com.ex5.server;

public interface Client {

	public String getName();
	
	public boolean end();
	
	public void updata(Event event);
}
