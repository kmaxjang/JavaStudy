package com.bighits.edit;

public interface Data<T> {

// 대이터 삭제
	public boolean deleteAll();

	public boolean delete();

	public boolean delete(int index);

	public boolean delete(int start, int end);

// 대이터 삽입
	public boolean insert(T data);

	public boolean insert(T[] data);

	public boolean insert(int index, T data);

	public boolean insert(int index, T[] data);

// 대이터 수정
	public boolean change(T data);

	public boolean change(T[] data);

	public boolean change(int index, T data);

	public boolean change(int index, T[] data);

	public boolean change(int start, int end, T data);

	public boolean change(int start, int end, T[] data);

// 	
	public T get();

	public T get(int index);

	public T[] get(int start, int end);

// 정보	
	public int getPosition();

	public boolean setPosition(int point);

	public long Size();

	public boolean isChange();

	public boolean isSave();
}
