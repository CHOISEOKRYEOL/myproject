package com.eomcs.pms;

public class JobHandler {

  static String hair[] = new String[game.LENGTH];
  static String sex[] = new String[game.LENGTH];
  static String ace[] = new String[game.LENGTH];
  static String warrior[] = new String[game.LENGTH];
  static String magician[] = new String[game.LENGTH];
  static String archer[] =  new String[game.LENGTH];
  static String thief[] = new String[game.LENGTH];
  static int size = 0;


  static void set() {

    roof:
      for(int i = 0; i < game.LENGTH; i++) {
        System.out.println("생성하고 싶은 직업을 입력하시오(warrior, magician, archer, thief)");
        switch(game.scanner.nextLine()) {
          case  "warrior" :
            System.out.println("전사닉네임");
            warrior[i] = game.scanner.nextLine();
            break;

          case "magician" :
            System.out.println("마법사닉네임");
            magician[i] = game.scanner.nextLine();
            break;

          case ("archer")  :
            System.out.println("궁수닉네임");
          archer[i] = game.scanner.nextLine();
          break;

          case ("thief") :
            System.out.println("도적닉네임");
          thief[i] = game.scanner.nextLine();
        }

        System.out.println(); 
        System.out.print("헤어스타일 >");
        hair[i]= game.scanner.nextLine();

        System.out.print("성별 > (m/w) ");
        sex[i] = game.scanner.nextLine();

        System.out.print("무기 >");
        ace[i] = game.scanner.nextLine();

        size++;

        System.out.println("계속 입력하시겠습니까? (y/N)");
        if(!game.scanner.nextLine().equalsIgnoreCase("y")) {
          break roof;
        }
      }
  }
  static void view() {
    for(int i =0; i < size; i++) {
      System.out.printf(" %s, %s, %s, %s, %s, %s, %s\n ",
          warrior[i],magician[i],archer[i],thief[i],hair[i],sex[i],ace[i]);
      i++;
    }
  }

}
