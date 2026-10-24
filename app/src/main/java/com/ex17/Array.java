package com.ex17;

import com.ex17.ArrayPrint;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Array {

  public static void printArray(Object array) {
    StringBuilder print = new StringBuilder();
    HashSet<Object> loop = new HashSet<Object>();
    printArray(array, 0, print, loop);
    System.out.println(print);
  }

  private static void printArray(Object array, int depth, StringBuilder sb, Set<Object> seen) {

    if (array == null) {
      indent(sb, depth);
      sb.append("null\n");
      return;
    }

    if (!array.getClass().isArray()) {
      indent(sb, depth);
      sb.append(array);
      sb.append(" ");
      return;
    }

    if (seen.contains(array)) {
      indent(sb, depth);
      sb.append("(Loop Array)");
      sb.append("\n");
      return;
    }

    seen.add(array);

    int len = java.lang.reflect.Array.getLength(array);
    String name = array.getClass().getComponentType().getSimpleName();

    indent(sb, depth);
    sb.append("Type " + name + " [" + len + "] {\n");

    for (int i = 0; i < len; i++) {
      Object elem = java.lang.reflect.Array.get(array, i);
      printArray(elem, depth + 1, sb, seen);
    }

    indent(sb, depth);
    sb.append("}\n");
  }

  private static void indent(StringBuilder sb, int length) {
    char[] space = new char[length];
    Arrays.fill(space, ' ');
    sb.append(space);
  }

  public static void main(String[] args) {
    Object[] a = new Object[3];
    int[] sb = {1, 2, 3, 4};
    int[][] b = {{1, 2}, {3}};
    int[] ba = sb;
    a[0] = b;
    a[1] = sb; // 순환 참조
    a[2] = ba;
    printArray(a);
    ArrayPrint.output(a);
  }
}
