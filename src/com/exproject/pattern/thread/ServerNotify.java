package com.exproject.pattern.thread;

import com.game.janggi.ex.interfacemod.Event;

public interface ServerNotify {

  public void updata(Event<Piece> event);
  
  public String setting(String masag, PlayCommand command);
	  
}
