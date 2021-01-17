package com.eomcs.pms;

import java.util.Scanner;

public class game {

  public static void main(String[] args) {

    Scanner scanner= new Scanner(System.in);

    final int LENGTH = 4;
    int i = 0;
    int size = 0;


    String hair[] = new String[LENGTH];
    String sex[] = new String[LENGTH];
    String ace[] = new String[LENGTH];
    int physical[] = new int[LENGTH];
    int kind[] = new int[LENGTH];
    String warrior[]= new String[LENGTH];
    String magician[] = new String[LENGTH];
    String archer[] =  new String[LENGTH];
    String thief[] = new String[LENGTH];


    while(true) {

      System.out.print("직업");
      System.out.print(">");
      String commend = scanner.nextLine();

      switch(commend) {

        case "job":
          for(i = 0; i < LENGTH; i++) {
            System.out.println("1.전사닉네임");
            warrior[i] = scanner.nextLine();
            System.out.println("2.마법사닉네임");
            magician[i] = scanner.nextLine();
            System.out.println("3.궁수닉네임");
            archer[i] = scanner.nextLine();
            System.out.println("4.도적닉네임");
            thief[i] = scanner.nextLine();
            System.out.print(">");;
            System.out.println("1. 전사 2. 마법사 3. 궁수 4. 도적 능력치" );
            kind[i] = scanner.nextInt();
            if(kind[i] > 4) {
              System.out.println("선택하신 캐릭터의 능력치가 없습니다.");
              break;
            }


            switch (kind[i]) {
              case 1 :
                System.out.println("힘: 10, 민첩: 4, 마나: 1, 공격속도: 5");
                break;
              case 2 :
                System.out.println("힘: 3, 민첩: 6, 마나: 10, 공격속도: 3");
                break;
              case 3 :
                System.out.println("힘: 6, 민첩: 6, 마나: 4, 공격속도: 8");
                break;
              case 4 :
                System.out.println("힘: 5, 민첩: 9, 마나: 5, 공격속도: 6");
                break;
            }
            System.out.println();
            scanner.nextLine();
            System.out.print("헤어스타일 >");
            hair[i]= scanner.nextLine();

            System.out.print("성별 > (m/w) ");
            sex[i] = scanner.nextLine();
            if(!sex[i].equalsIgnoreCase("m") || !sex[i].equalsIgnoreCase("w")) { 
              System.out.println("선택하신 성별이 없습니다.");
              break;
            }


            System.out.print("무기 >");
            ace[i] = scanner.nextLine();

            System.out.println("체형: 1.소인 2. 중인 3. 대인");
            System.out.print(">");
            physical[i] = scanner.nextInt();
            scanner.nextLine();
            switch(physical[i]) {
              case 1 :
                System.out.println("소인");
                break;
              case 2 :
                System.out.println("중인");
                break;
              case 3 :
                System.out.println("대인");
                break;
              default : 
                System.out.println("선택된 체형은 없습니다.");
                break;
            }
            size++;

            System.out.println();

            System.out.print("계속 입력하시겠습니까?(y/N) ");
            String str = scanner.nextLine();
            if (!str.equalsIgnoreCase("y")) {
              break;
            }
            System.out.println();
          }
      }
      for(i =0; i < size; i++) {
        System.out.printf(" %d, %s, %s, %s, %d\n", kind[i],hair[i],sex[i],ace[i],physical[i]);
      }
    }
  }
}