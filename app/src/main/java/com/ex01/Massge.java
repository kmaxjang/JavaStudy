package com.ex01;

import java.lang.reflect.Array;
import java.util.*;

public final class Massge {
  // 기본 줄바꿈 포함
  public static void print(Object obj) {
    print(obj, true);
  }

  // 줄바꿈 여부 선택 가능
  public static void print(Object obj, boolean newline) {
    if (obj == null) {
      printOut("[null]", newline);
      return;
    }

    if (obj.getClass().isArray()) {
      // 배열 처리
      arrayPrint(obj);
    } else if (obj instanceof Collection) {
      // Collection 처리
      collectionPrint(obj);
    } else if (obj instanceof Map) {
      // Map 처리
      mapPrint(obj);
    } else {
      // 기본 출력
      printOut(String.valueOf(obj), newline);
    }
  }

  private static void arrayPrint(Object obj) {
    printOut(
        "[배열 타입: " + obj.getClass().getSimpleName() + ", 길이: " + Array.getLength(obj) + "]", true);
    for (int i = 0; i < Array.getLength(obj); i++) {
      Object element = Array.get(obj, i);
      if (element.getClass().isArray()) {
        print(element, false);
      } else {
        printOut(" " + String.valueOf(element), false);
      }
    }
    print("");
  }

  private static void collectionPrint(Object obj) {
    Collection<?> col = (Collection<?>) obj;
    printOut("[컬렉션 타입: " + obj.getClass().getSimpleName() + ", 크기: " + col.size() + "]", true);
    int i = 0;
    for (Object item : col) {
      System.out.printf("  [%2d] : %s\n", i++, String.valueOf(item));
    }
  }

  private static void mapPrint(Object obj) {
    Map<?, ?> map = (Map<?, ?>) obj;
    printOut("[Map 타입: " + obj.getClass().getSimpleName() + ", 크기: " + map.size() + "]", true);
    for (Map.Entry<?, ?> e : map.entrySet()) {
      System.out.printf("  [%s] => %s\n", String.valueOf(e.getKey()), String.valueOf(e.getValue()));
    }
  }

  private static void printOut(String text, boolean newline) {
    if (newline) {
      System.out.println(text);
    } else {
      System.out.print(text);
    }
  }
}
