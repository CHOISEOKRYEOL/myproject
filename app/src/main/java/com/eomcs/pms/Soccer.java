package com.eomcs.pms;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
import handler.AmountHandler;
import handler.AmountList;
import handler.FoodHandler;
import handler.FoodList;
import handler.MemberHandler;
import handler.MemberList;
import handler.TrainingHandler;
import handler.TrainingList;
import util.Prompt;

public class Soccer {

  static LinkedList<MemberList> memberList = new LinkedList<>();
  static ArrayList<TrainingList> trainingList = new ArrayList<>();
  static ArrayList<FoodList> foodList = new ArrayList<>();
  static ArrayList<AmountList> amountList = new ArrayList<>();

  static Stack commandStack  = new Stack();

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws CloneNotSupportedException {

    Map<String, String> map = new Hashtable<String,String>();
    map.put("soccer", "1111");

    loadMembers();
    loadTrainings();
    loadFoods();
    loadAmounts();

    while(true) {
      System.out.println("아이디와 비밀번호를 입력하세요");
      System.out.print("아이디: ");
      String id = scanner.nextLine();
      System.out.print("비밀번호: ");
      String password = scanner.nextLine();
      System.out.println();
      if(map.containsKey(id)) {
        if(map.get(id).equals(password)) {
          System.out.println("로그인되었습니다.");
          System.out.println();
          break;
        }else {
          System.out.println("비밀번호가 일치하지 않습니다.");
        }
      }else {
        System.out.println("입력하신 아이디가 존재하지 않습니다.");
      }
    }


    loop:
      while (true) {
        System.out.println("명령>");
        String command = scanner.nextLine();

        commandStack.push(command);

        try {
          switch (command) {
            case "/member/add":
              MemberHandler.add();
              break;
            case "/member/list":
              MemberHandler.list();
              break;
            case "/member/detail":
              MemberHandler.detail();
              break;
            case "/member/update":
              MemberHandler.update();
              break;
            case "/member/delete":
              MemberHandler.delete();
              break;
            case "/training/add":
              TrainingHandler.add();
              break;
            case "/training/list":
              TrainingHandler.list();
              break;
            case "/food/add":
              FoodHandler.add();
              break;
            case "/food/list":
              FoodHandler.list();
              break;
            case "/amount/add":
              AmountHandler.add();
              break;
            case "/amount/list":
              AmountHandler.list();
              break;
            case "history" :
              printCommandHistory();
              break;
            case "exit":
              System.out.println("안녕!");
              break loop;
            default:
              System.out.println("실행할 수 없는 명령입니다.");
          }
        } catch(Exception e) {
          System.out.println("--------------------------------------------");
          System.out.printf("명령어 실행 중 오류 발생: %s - %s\n", e.getClass().getName(), e.getMessage());
          System.out.println("--------------------------------------------");
        }finally {
          System.out.println(); 
        }
      }
    saveMembers();
    saveTrainings();
    saveFoods();
    saveAmounts();

    Prompt.close();
  }

  static void printCommandHistory() throws CloneNotSupportedException {
    Stack stack = (Stack) commandStack.clone();

    int count = 0;
    while(stack.size() > 0) {
      System.out.println(stack.pop());
      if((++count % 5) == 0) {
        String input = Prompt.inputString(" : ");
        if(input.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
  static void loadMembers() {
    try (Scanner in = new Scanner(new FileReader("members.csv"))) {
      while(true) {
        try {
          String record = in.nextLine();
          String[] fields = record.split(",");
          MemberList m = new MemberList();
          m.setNo(Integer.parseInt(fields[0]));
          m.setName(fields[1]);
          m.setNationality(fields[2]);
          m.setPosition(fields[3]);

          memberList.add(m);
        } catch(NoSuchElementException e) {
          break;
        }
      }

      System.out.println("선수 데이터 로딩!");
    } catch (Exception e) {
      System.out.println("선수 데이터 로딩 중 오류 발생!");
    }
  }
  static void saveMembers() {
    try(FileWriter out = new FileWriter("members.csv")) {
      for(MemberList m : memberList) {
        out.write(String.format("%d,%s,%s,%s\n",
            m.getNo(),
            m.getName(),
            m.getNationality(),
            m.getPosition()));
      }
      System.out.println("선수 데이터 저장 완료!");
    }catch (Exception e) {
      System.out.println(" 선수 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }
  static void loadTrainings() {
    try (Scanner in = new Scanner(
        new FileReader("trainings.csv"))) {

      while(true) {
        try {
          String[] fields = in.nextLine().split(",");

          TrainingList t = new TrainingList();
          t.setName(fields[0]);
          t.setTitle(fields[1]);
          t.setContent(fields[2]);
          t.setStartDate(Date.valueOf(fields[3]));
          t.setEndDate(Date.valueOf(fields[4]));

          trainingList.add(t);

        } catch (Exception e) {
          break;
        }
      }
      System.out.println("선수 데이터 로딩!");
    }catch (Exception e) {
      System.out.println("선수 데이터 로딩 중 오류 발생!");
    }
  }

  static void saveTrainings() {
    try(FileWriter out = new FileWriter("trainings.csv")) {

      for(TrainingList t : trainingList) {
        out.write(String.format("%s,%s,%s,%s%s\n",
            t.getName(),
            t.getTitle(),
            t.getContent(),
            t.getStartDate().toString(),
            t.getEndDate().toString()));
      }
      System.out.println("선수 훈련 데이터 저장 완료!");
    }catch (Exception e) {
      System.out.println("선수 훈련 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }
  static void loadFoods() {
    try (Scanner in = new Scanner(new FileReader("projects.csv"))) {


      while(true) {
        try {
          String[] fields = in.nextLine().split(",");

          FoodList f = new FoodList();
          f.setName(fields[0]);
          f.setCarbohydrate(Integer.parseInt(fields[0]));
          f.setProtein(Integer.parseInt(fields[0]));
          f.setCalcium(Integer.parseInt(fields[0]));
          f.setFat(Integer.parseInt(fields[0]));
          f.setVitamin(Integer.parseInt(fields[0]));

          foodList.add(f);
        }catch (NoSuchElementException e) {
          break;
        }
      }
      System.out.println("선수 식단 데이터 로딩!");
    } catch (Exception e) {
      System.out.println("선수 식단 데이터 로딩 중 오류 발생!");
    }
  }
  static void saveFoods() {
    try(FileWriter out = new FileWriter("projects.csv")) {

      for(FoodList f : foodList) {
        out.write(String.format("%s,&d,%d,%d,%d,%d", 
            f.getName(),
            f.getCarbohydrate(),
            f.getProtein(),
            f.getCalcium(),
            f.getFat(),
            f.getVitamin()));

      }
      System.out.println("선수 식단 데이터 저장 완료!");
    }catch (Exception e) {
      System.out.println(" 선수 식단 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }

  static void loadAmounts() {
    try (Scanner in = new Scanner(
        new FileReader("amounts.csv"))) {

      while(true) {
        try {
          String[] fields = in.nextLine().split(",");

          AmountList a = new AmountList();
          a.setFowardprice(Integer.parseInt(fields[0]));
          a.setMidfielderprice(Integer.parseInt(fields[0]));
          a.setDefenderprice(Integer.parseInt(fields[0]));

          amountList.add(a);
        } catch (NoSuchElementException e) {
          break;
        }

      }
      System.out.println("선수 이적료 데이터 로딩!");
    } catch (Exception e) {
      System.out.println("선수 이적료 데이터 로딩 중 오류 발생!");
    }
  }
  static void saveAmounts() {
    try(FileWriter out = new FileWriter("tasks.csv")) {

      for(AmountList a : amountList) {
        out.write(String.format("%d,%d,%d\\n",
            a.getFowardprice(),
            a.getMidfielderprice(),
            a.getDefenderprice()));
      }
      System.out.println("선수 이적료 데이터 저장 완료!");
    }catch (Exception e) {
      System.out.println(" 선수 이적료 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }
}
