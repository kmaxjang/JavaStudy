package com.ex13;

import java.util.Set;
import com.ex13.Info;
import com.ex13.Dir;

public interface Top extends Info {

  Set<String> getDirList();

  Dir getDir(String name);

  void add(Dir dir);

  boolean removeDir(String dirname);

  int totalSize();
}
