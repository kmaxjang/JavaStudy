package com.ex13;

public interface Info {

  default <T> T nonNull(T obj, String massage) {
    if (obj == null) {
      throw new IllegalArgumentException(massage);
    }
    return obj;
  }

  String name();

  String path();

  int size();

  int level();
}
