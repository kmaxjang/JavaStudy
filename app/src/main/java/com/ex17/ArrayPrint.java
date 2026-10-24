package com.ex17;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public class ArrayPrint {

  private static ArrayPrint printer = null;

  private StringBuilder sb = new StringBuilder();
  private Set<Object> loop = new HashSet<Object>();

  private ArrayPrint() {}

  public static void output(Object[] array) {
    if (array == null) {
      System.out.println("NullPointExCeption");
      return;
    }
    ArrayPrint printer = new ArrayPrint();
    printer.print(0, array);
    printer.screen();
  }

  private void print(int depth, Object array) {

    loop.add(array);
    Class<?> clazz = array.getClass();
    sb.append("Depth: " + depth);
    sb.append(" Type: " + clazz.getComponentType().getSimpleName());
    int length = Array.getLength(array);
    sb.append(" Length : " + length + "\n");
    indent(depth);

    for (int i = 0; i < length; i++) {
      sb.append("<" + depth + i + ">");
      Object element = Array.get(array, i);
      if (element == null) {
        sb.append("null");
      } else if (element.getClass().isArray()) {
        sb.append("\n");
        indent(depth);
        if (loop.contains(element)) {
          sb.append("Loop Array");
        } else {
          print(depth + 1, element);
        }
        sb.append("\n");
        indent(depth);
      } else {
        sb.append(element);
        sb.append(' ');
      }
    }
  }

private void info(Object array){
  
}

  private void indent(int depth) {
    for (int tab = 0; tab < 2 + 2 * depth; tab++) {
      sb.append(' ');
    }
  }

  private void screen() {
    System.out.println(sb);
  }
}
