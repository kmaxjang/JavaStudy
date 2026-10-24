package com.ex13;

import com.ex13.Dir;
import com.ex13.Top;
import java.util.HashMap;
import java.util.Set;

public class TopClass implements Top {

  private final int level = 0;
  private String name;

  private HashMap<String, Dir> dirlist = new HashMap<>();

  public TopClass(String name) {
    this.name = nonNull(name, "not NULL");
  }
@Override
  public String name() {
    return name;
  }
@Override
  public String path() {
    return name + "//";
  }
@Override
  public int level() {
    return level;
  }
@Override
  public int size() {
    return 0;
  }
  @Override
  public Set<String> getDirList(){
    return dirlist.keySet();
  }
  
@Override
  public Dir getDir(String name){
    return dirlist.get(name);
  }
  
@Override
public void add(Dir dir){
  dirlist.put(dir.name(), dir);
}

@Override
 public boolean removeDir(String name){
   return dirlist.remove(name,getDir(name));
 }
 
@Override  
public int totalSize(){
  int totalsize =0;
  for(Dir dir: dirlist.values()){
    totalsize += dir.totalSize();
  }
  return totalsize;
}
 
}
