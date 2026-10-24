package com.ex09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.ex09.GCD;

public final class MainClass implements Message {

  public static final Message me = new MainClass();

  public static void main(String[] args) {

    me.print("JAVA Ex09 2025-02-09");
    int[][] a = {{1, 2}, {3, 4}, {5}};
    int[] b = {1, 2, 3, 4, 5};
    a[0] = b;
    me.print(a);

    Set<Class<?>> primitivetype =
        new HashSet<>(
            Arrays.asList(
                byte.class, // 1byte
                char.class, // 2
                short.class, // 2
                int.class, // 4
                long.class, // 8
                float.class, // 4
                double.class, // 8
                boolean.class // 1
                ) //
            );
    me.print(a.getClass().getComponentType());
    if (primitivetype.contains(a.getClass().getComponentType())) {
      me.print("배열타입");
    }

    me.println("최대공약수" + GCD.gcd(-50, 45));
    me.println("최소공배수" + GCD.lcm(-50, 45));
    // /*
    int number = 10;
    Object objtmp = number; // 자동 캐스팅 Integer.velue(number);
    int reinteger = Integer.class.cast(objtmp);
    reinteger = (int) objtmp;
    reinteger = (Integer) objtmp;

    me.println("숫자" + number);
    me.println("임시" + objtmp);
    me.println("숫자 변환" + reinteger);
    // */
  }
}
