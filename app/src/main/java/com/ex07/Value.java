package com.ex07;

public interface Value {

  public String name();

  public Number Max();

  public Number Min();

  public void set(Number number);

  public void setFix(Number number);

  public Number get();

  public void link(Operator operand, Value value);

  public Value output();

  enum Operator {
    ADD,
    SUB,
    DIV,
    MULT;
  }
}
