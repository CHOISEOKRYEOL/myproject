package com.eomcs.pms;

import java.util.Scanner;

public class game {

  static Scanner scanner= new Scanner(System.in);

  static final int LENGTH = 4;
  static int i = 0;
  static int size = 0;


  static String hair[] = new String[LENGTH];
  static String sex[] = new String[LENGTH];
  static String ace[] = new String[LENGTH];
  static int physical[] = new int[LENGTH];
  static int kind[] = new int[LENGTH];
  static String warrior[]= new String[LENGTH];
  static String magician[] = new String[LENGTH];
  static String archer[] =  new String[LENGTH];
  static String thief[] = new String[LENGTH];

  static void setcharacter() {
    System.out.println("1.전사닉네임");
    warrior[i] = scanner.nextLine();
    System.out.println("2.마법사닉네임");
    magician[i] = scanner.nextLine();
    System.out.println("3.궁수닉네임");
    archer[i] = scanner.nextLine();
    System.out.println("4.도적닉네임");
    thief[i] = scanner.nextLine();
  }

  static void viewstat() {
    System.out.println("warrior, magician, archer, thief");
    String str = scanner.nextLine();
    if(str.equalsIgnoreCase("warrior")) {
      System.out.println("힘: 10, 민첩: 4, 마나: 1, 공격속도: 5");
    }    
    else if(str.equalsIgnoreCase("magician")) {
      System.out.println("힘: 3, 민첩: 6, 마나: 10, 공격속도: 3");
    }
    else if(str.equalsIgnoreCase("archer")) {
      System.out.println("힘: 6, 민첩: 6, 마나: 4, 공격속도: 8");
    }
    else if(str.equalsIgnoreCase("thief"))
      System.out.println("힘: 5, 민첩: 9, 마나: 5, 공격속도: 6");
  }

  static void viewphysical(){
    System.out.println("소인, 중인, 대인");
    String str1 = scanner.nextLine();
    if(str1.equalsIgnoreCase("소인")) {
      System.out.println("소인");
    }    
    else if(str1.equalsIgnoreCase("중인")) {
      System.out.println("중인");
    }
    else if(str1.equalsIgnoreCase("대인")) {
      System.out.println("대인");
    }
  }

  public static void main(String[] args) {

    while(true) {
      System.out.print("job , stat, pyhsical");
      System.out.print(">");
      String commend = scanner.nextLine();

      switch(commend) {
        case "job": 
          setcharacter();
          break;
        case "stat" :
          viewstat();
          break;
        case "physical" :
          viewphysical();
      }

      System.out.println(); 
      System.out.print("헤어스타일 >");
      hair[i]= scanner.nextLine();

      System.out.print("성별 > (m/w) ");
      sex[i] = scanner.nextLine();


      System.out.print("무기 >");
      ace[i] = scanner.nextLine();

      size++;

      System.out.println();

      for(i =0; i < size; i++) {
        System.out.printf(" %s, %s, %s, %s, %s, %s, %s, %s, %s\n",warrior[i],magician[i],archer[i],thief[i],kind[i],hair[i],sex[i],ace[i],physical[i]);
      }
    }
  }
}

