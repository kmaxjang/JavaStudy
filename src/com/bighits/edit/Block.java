package com.bighits.edit;

import java.util.Iterator;

public interface Block {

  public int getStart();

  public int getEnd();

  public Iterator<Block> getBlock();

  public int blockCount();
}
