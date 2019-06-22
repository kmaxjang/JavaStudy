package com.exproject.pattern.observer;

import com.exproject.pattern.observer.PlayData;

public interface Observer {

	public String[] getPlayerInfo();

	public void update(PlayData data);

}
