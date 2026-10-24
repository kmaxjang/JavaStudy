package com.ex01;

import com.ex01.Record;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Record<T> implements Iterable<T> {

  private final Policy policy;
  private final List<T> list;
  private int nowpoint = 0;

  // ===== 외부 API용 의미 타입 =====
  public enum Mode {
    SEARCH,
    TEST
  }
  
  public Mode mode(){
    return Policy.to(policy);
  }

  // ===== 생성 =====
  public static <T> Record<T> create(Mode mode) {
    return new Record<T>(Policy.from(mode));
  }

  private Record(Policy policy) {
    this.policy = policy;
    list = new ArrayList<>();
  }

  private Record(List<T> list, Policy policy) {
    this.policy = policy;
    this.list = list;
    nowpoint = endPoint();
  }

  public T forward() {
    return hasForward() ? list.get(nowpoint++) : null;
  }

  public List<T> forward(int range) {
    int start = nowpoint;
    int end = Math.min(nowpoint + range, endPoint());
    nowpoint = end;
    return new ArrayList<>(list.subList(start, end));
  }

  public T rewind() {
    return hasRewind() ? list.get(--nowpoint) : null;
  }

  public List<T> rewind(int range) {
    int start = Math.max(nowpoint - range, 0);
    int end = nowpoint;
    nowpoint = start;
    List<T> rewind = new ArrayList<>(list.subList(start, end));
    Collections.reverse(rewind);
    return rewind;
  }

  public boolean hasForward() {
    return nowpoint < endPoint();
  }

  public boolean hasRewind() {
    return nowpoint > 0;
  }

  public void put(T data) {
    policy.write(this, data);
  }

  public void put(Iterable<T> update) {
    for (T data : update) {
      policy.write(this, data);
    }
  }

  public int nowPoint() {
    return nowpoint;
  }

  public int endPoint() {
    return list.size();
  }

  public Record<T> branch(Mode mode) {
    List<T> copy = new ArrayList<>(list.subList(0, nowpoint));
    return new Record<>(copy, Policy.from(mode));
  }

  @Override
  public Iterator<T> iterator() {
    return Collections.unmodifiableList(list).iterator();
  }

  private enum Policy {
    SEARCH {
      @Override
      <T> void write(Record<T> r, T data) {
        r.list.add(data);
        //탐색중이 아니면 최신상태 유지
        if(r.nowpoint == r.endPoint()-1) r.nowpoint++; 
      }
    },

    TEST {
      @Override
      <T> void write(Record<T> r, T data) {
        if (r.nowpoint < r.endPoint()) {
          r.list.subList(r.nowpoint, r.endPoint()).clear();
        }
        r.list.add(data);
        r.nowpoint++;
      }
    };

    abstract <T> void write(Record<T> r, T data);

    static Policy from(Mode mode) {
      return mode != Mode.TEST ? SEARCH : TEST;
    }
    
    static Mode to(Policy policy){
      return policy != Policy.TEST ? Mode.SEARCH : Mode.TEST;
    }
  }
}
