package com.bighits;

public interface Data {
// 대이터 삭제
public void deleteAll();
public void delete();
public void delete(int index);
public void delete(int start, int end);
// 대이터 삽입
public void insert(Data data);
public void insert(Data[] data);
public void insert(int index, Data data);
public void insert(int index, Data[] data);
// 대이터 수정
public void change(int index, Data data);
public void change(int index, Data[] data);
public void change(int start, int end, Data data);
public void change(int start, int end, Data[] data);

public Data get();
public Data get(int index);
public Data[] get(int start, int end);

public int getPosition();
public boolean setPosition(int point);

public long Size();
public boolean isChange();
public boolean isSave();
}
