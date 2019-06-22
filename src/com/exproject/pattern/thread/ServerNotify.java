package com.exproject.pattern.thread;

import com.exproject.janggi.interfacemod.Event;

public interface ServerNotify {

  public void updata(Event<Piece> event);
  
  public String setting(String masag, PlayCommand command);
	  
}
