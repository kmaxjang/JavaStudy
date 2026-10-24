package com.ex15;

public enum Door {
  OPEN {
    public boolean isOpenDoor() {
      return true;
    }

    public Door open() {
      return this;
    }

    public Door closed() {
      return CLOSED;
    }
  },
  CLOSED {
    public boolean isOpenDoor() {
      return false;
    }

    public Door open() {
      return OPEN;
    }

    public Door closed() {
      return this;
    }
  };

  public abstract boolean isOpenDoor();

  public abstract Door open();

  public abstract Door closed();
}
