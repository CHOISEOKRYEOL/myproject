package com.eomcs.pms.Game;

import com.eomcs.util.Prompt;

public class JobHandler {

  static final int LENGTH = 100;
  static Job[] jobs = new Job[Game.LENGTH];
  static int size = 0;


  static class Job {

    String warrior;
    String magician;
    String archer;
    String thief;
    String sex;
    String hair;
    String ace;
  }

  public static void set() {

    Job j = new Job();

    System.out.println("생성하고 싶은 직업을 입력하시오(warrior, magician, archer, thief)");
    switch(Game.scanner.nextLine()) {
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
        j.ace =("longsword");
        break;

      case "magician" :
        j.ace =("wand");
        break;

      case ("archer")  :
        j.ace=("bow");
      break;

      case ("thief") :
        j.ace=("dagger");

    }

    System.out.println("계속 입력하시겠습니까? (y/N)");
    if(!Game.scanner.nextLine().equalsIgnoreCase("y")) {
    }
    jobs[size++] = j;
  }

  public static void view() {
    for(int i =0; i < size; i++) {
      Job j = jobs[i];
      System.out.printf(" %s, %s, %s, %s, %s, %s, %s\n ",
          j.warrior,j.magician,j.archer,j.thief,j.sex,j.hair,j.ace);
    }
  }

  public static void detail() {
    System.out.println("[생성직업 특징 상세보기]");
    System.out.print(">");
    for(int i = 0; i <size; i++) {
      Job j = jobs[i];
      String s =Game.scanner.nextLine();
      if(s.equalsIgnoreCase("warrior")) {
        System.out.printf(" %s, %s, %s, %s\n ",
            j.warrior,j.sex,j.hair,j.ace);
      }else if(s.equalsIgnoreCase("magician")) {
        System.out.printf(" %s, %s, %s, %s\n ",
            j.magician,j.sex,j.hair,j.ace);
      }else if(s.equalsIgnoreCase("archer")) {
        System.out.printf(" %s, %s, %s, %s\n ",
            j.archer,j.sex,j.hair,j.ace);
      }else if(s.equalsIgnoreCase("thief")) {
        System.out.printf(" %s, %s, %s, %s\n ",
            j.thief,j.sex,j.hair,j.ace);
      }else {
        System.out.println("해당 직업의 정보가 없습니다");
      }
    }
  }

  public static void update() {
    int i = 0;
    Job j = jobs[i];
    String sex = null;
    String hair = null;
    System.out.println("[생성직업 특징 변경]");
    System.out.println("[특징 변경할 직업]");
    System.out.print(">");
    for(; i < size; i++) {
      if(Game.scanner.nextLine().equalsIgnoreCase("warrior")) {
        sex = Prompt.inputString(String.format("성별? ", j.sex));
        hair = Prompt.inputString(String.format("헤어스타일? ",j.hair));
      }else if(Game.scanner.nextLine().equalsIgnoreCase("magician")) {
        sex = Prompt.inputString(String.format("성별? ", j.sex));
        hair = Prompt.inputString(String.format("헤어스타일? ",j.hair));
      }else if(Game.scanner.nextLine().equalsIgnoreCase("archer")) {
        sex = Prompt.inputString(String.format("성별? ", j.sex));
        hair = Prompt.inputString(String.format("헤어스타일? ",j.hair));
      }else if(Game.scanner.nextLine().equalsIgnoreCase("thief")) {
        sex = Prompt.inputString(String.format("성별? ", j.sex));
        hair = Prompt.inputString(String.format("헤어스타일? ",j.hair));
      }

    }
  }
}
