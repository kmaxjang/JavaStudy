package com.sample.rotation;

public interface Rotation<D> {

	enum Index {
		previous,
		now,
		next
	}

	public boolean isRotation();

	public D getItem(Index index);

	public D getItem(int index);

	public int getNowIndex();

	public int getMaxIndex();

}
