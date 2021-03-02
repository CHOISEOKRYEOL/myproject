package com.eomcs.Pratice;

public class nestedClassMain {

  public static void main(String[] args) {
    nestedClass a = new nestedClass();

    nestedClass.B b = a.new B();
    b.field1 = 3;
    b.method1();

    nestedClass.C c = new nestedClass.C();
    c.field1 = 3;
    c.method1();
    nestedClass.C.field2 = 3;
    nestedClass.C.method2();

    a.method();
  }

}
