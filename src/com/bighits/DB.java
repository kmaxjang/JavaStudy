package com.bighits;

public abstract class DB<T> {

 
  public DB(){
    
  }
  
  public abstract T getData();
  
  public abstract void setData(T data);
  
}
