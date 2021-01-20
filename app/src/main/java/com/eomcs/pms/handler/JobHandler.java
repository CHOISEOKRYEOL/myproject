package com.eomcs.pms.handler;

import com.eomcs.pms.game;
import com.eomcs.util.Prompt;

public class JobHandler {

  static class Job {

    String hair;
    String sex;
    String ace;
    String warrior;
    String magician;
    String archer;
    String thief;

  }

  static Job[] jobs = new Job[game.LENGTH];
  static int size = 0;

  public static void set() {

    Job j = new Job();

    roof:
      for(int i = 0; i < game.LENGTH; i++) {
        System.out.println("생성하고 싶은 직업을 입력하시오(warrior, magician, archer, thief)");
        switch(game.scanner.nextLine()) {

          case  "warrior" :
            j.warrior =Prompt.inputString("전사닉네임");
            break;

          case "magician" :
            j.magician =Prompt.inputString("마법사닉네임");
            break;

          case ("archer")  :
            j.archer=Prompt.inputString("궁수닉네임");
          break;

          case ("thief") :
            j.thief=Prompt.inputString("도적닉네임");

        }

        System.out.println(); 

        j.sex = Prompt.inputString("성별 > (m/w) ");

        System.out.println(); 

        switch(Prompt.inputString("헤어스타일")) {
          case ("m"):
            j.hair=("더벅머리");
          break;
          case ("w") :
            j.hair=("생머리");
        }

        System.out.println(); 


        switch(Prompt.inputString("무기")) {

          case  "warrior" :
            j.ace =("검");
            break;

          case "magician" :
            j.ace =("마법봉");
            break;

          case ("archer")  :
            j.ace=("활");
          break;

          case ("thief") :
            j.ace=("표창");

        }

        jobs[size++] = j;


        System.out.println("계속 입력하시겠습니까? (y/N)");
        if(!game.scanner.nextLine().equalsIgnoreCase("y")) {
          break roof;
        }
      }
  }
  public static void view() {
    for(int i =0; i < size; i++) {
      Job j = jobs[i];
      System.out.printf(" %s, %s, %s, %s, %s, %s, %s\n ",
          j.warrior,j.magician,j.archer,j.thief,j.sex,j.hair,j.ace);
    }
  }
}
