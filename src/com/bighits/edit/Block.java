package com.bighits.edit;

import java.util.Iterator;

public interface Block<T> {

	public int getStart();

	public int getEnd();

	public Iterator<T> get();

	public int Length();
}
