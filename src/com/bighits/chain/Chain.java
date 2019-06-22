package com.bighits.chain;

public abstract class Chain {

  protected Chain next;
  protected int code;
  private static RootChain root = null;

  public void link(int code) {
    if (this.code == code) {
      toLink();
    } else if (next != null) {
      toLink();
      next.link(code);
    }
  }

  public abstract void toLink();

  public void scr(String str) {
    System.out.println(str);
  }

  public static Chain getChain() {
    if (root == null) {
      root = new RootChain(new SubChain(new EndChain(null)));
    }
    return root;
  }
}

class RootChain extends Chain {

  public RootChain(Chain chain) {
    next = chain;
    code = 0;
  }

  public void toLink() {
    scr("최상위 사슬");
  }
}

class SubChain extends Chain {

  public SubChain(Chain chain) {
    next = chain;
    code = 1;
  }

  public void toLink() {
    scr("중간 사슬");
  }
}

class EndChain extends Chain {

  public EndChain(Chain chain) {
    next = chain;
    code = 2;
  }

  public void toLink() {
    scr("마지막 사슬");
  }
}
