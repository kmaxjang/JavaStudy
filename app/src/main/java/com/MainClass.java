package com;

public class MainClass{
  public static void main(String[] age){
    System.out.println("Java Test");
    
     // 자바 런타임 버전
    String javaVersion = System.getProperty("java.version");
    System.out.println("Java Version: " + javaVersion);

    // JVM 버전
    String javaRuntimeVersion = System.getProperty("java.runtime.version");
    System.out.println("Java Runtime Version: " + javaRuntimeVersion);

    // JVM 이름
    String jvmName = System.getProperty("java.vm.name");
    System.out.println("JVM Name: " + jvmName);

    // JVM 버전
    String jvmVersion = System.getProperty("java.vm.version");
    System.out.println("JVM Version: " + jvmVersion);

    // JVM 공급자
    String jvmVendor = System.getProperty("java.vm.vendor");
    System.out.println("JVM Vendor: " + jvmVendor);
  }
}