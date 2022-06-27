package com.note9;

public interface EditData<D> {
// 삭제
	public boolean delete();

	public boolean delete(int index);

	public boolean delete(int start, int end);

// 삽입
	public boolean insert(D data);

	public boolean insert(D[] data);

	public boolean insert(int index, D data);

	public boolean insert(int index, D[] data);

// 변경
	public boolean change(int index, D data);

	public boolean change(int index, D[] data);

	public boolean change(int start, int end, D data);

	public boolean change(int start, int end, D[] data);

// 파일정보
	public D get();

	public D get(int index);

	public D[] get(int start, int end);

// 포인트정보
	public int getPosition();

	public boolean setPosition(int point);

// 기타
	public long Size();

	public boolean isChange();

	public boolean isSave();
}
