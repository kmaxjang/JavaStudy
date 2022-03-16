package com.note9;

public interface EditData {
// 삭제
	public void delete();

	public void delete(int index);

	public void delete(int start, int end);

// 삽입
	public void insert(EditData data);

	public void insert(EditData[] data);

	public void insert(int index, EditData data);

	public void insert(int index, EditData[] data);

// 변경
	public void change(int index, EditData data);

	public void change(int index, EditData[] data);

	public void change(int start, int end, EditData data);

	public void change(int start, int end, EditData[] data);

// 파일정보
	public EditData get();

	public EditData get(int index);

	public EditData[] get(int start, int end);

// 포인트정보
	public int getPosition();

	public boolean setPosition(int point);

// 기타
	public long Size();

	public boolean isChange();

	public boolean isSave();
}
