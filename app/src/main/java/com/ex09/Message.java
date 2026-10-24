package com.ex09;

/*

기본배열은 Object 으로 인식 Object[]로 캐스팅 할수 없음
int[] != Object[]
다차원 배열은 Object[]로 인식하나 Object[] 캐스팅 안됨
int[][] == Object[]
int[0][] == Object
Object[] = int[] O
int[] = Object[] X
다중배열은 objectA[]=objectB[] 배열에 배열을 담는 형식

getClass().isArray() 배열확인

*/
public interface Message {

public static <T> T cast(Object obj, Class<T> clazz){
if(clazz.isInstance(obj)){
  return clazz.cast(obj);
}
  return null;
}

default void print(Object[] msg){
print("배열");
if(msg == null){
  print("Null");
  return;
}

class Array{
  public void deep(Object[] arr, StringBuilder sb, java.util.Set<Object[]> seen){
  
    if(arr == null){
    sb.append("null");
      return;
    }
    if(seen.contains(arr)){
      sb.append("[...]");
    }
    seen.add(arr);
    for(int a=0; a <arr.length; a++){
      if(arr[a] == null){
        sb.append("null");
      }else if(arr[a].getClass().isArray()){
        if(arr[a] instanceof Object[]){
          deep((Object[])arr[a], sb, seen);
        }else{
        int[] a2 = (int[])arr[a];
        for(int b=0; b < a2.length; b++){
          sb.append(a2[b]);
        }
        sb.append("\n");
        }
      }else{
        sb.append(arr[a].toString());
      }
    }
    sb.append("\n");
  }
};

StringBuilder sb = new StringBuilder();
new Array().deep(msg, sb, new java.util.HashSet<Object[]>());
print(sb.toString());
print(java.util.Arrays.deepToString(msg));
}

default void print(Object msg){
  System.out.print(msg);
}

default void println(Object msg){
  System.out.println(msg);
}

}
