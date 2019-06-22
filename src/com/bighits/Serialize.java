package com.bighits;


public final class Serialize {
private static final Serialize c = new Serialize();

private long seed_serial= 0L;

private Serialize(){
  
}

public static Serialize get(){
  return c;
}

public Serialize set(Object object){
  
  return c;
}

public SerialNumber getSerialNumber(){

  return new SerialNumber(c, seed_serial++);
}

}

final class SerialNumber{

private Serialize serial;
private long number;
  
  public SerialNumber(Serialize s, long seed){
    serial = s;
    this.number = seed;
  }
  
  public boolean isSerial(){
    return false;
  }
  
  public boolean compare(SerialNumber s){
    return false;
  }
}
