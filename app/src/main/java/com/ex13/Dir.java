package com.ex13;

import java.util.Set;
import com.ex13.Top;

public interface Dir extends Top {

  Set<String> getFileList();

  String getFile(String name);

  void add(String file);

  boolean removeFile(String filename);
}
