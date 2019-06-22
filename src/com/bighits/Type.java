package com.bighits;

public enum Type {

INT(){
private Object data;
  public Object get(){
    return data;
  }
  
  public void set(Object data){
    this.data = data;
  }
};

public abstract Object get();
public abstract void set(Object data);


}
