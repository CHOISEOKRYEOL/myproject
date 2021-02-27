package com.eomcs.pms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import domain.Amount;
import domain.Food;
import domain.Member;
import domain.Training;
import handler.AmountHandler;
import handler.FoodHandler;
import handler.MemberHandler;
import handler.TrainingHandler;
import util.Prompt;

public class Soccer {

  static LinkedList<Member> memberList = new LinkedList<>();
  static ArrayList<Training> trainingList = new ArrayList<>();
  static ArrayList<Food> foodList = new ArrayList<>();
  static ArrayList<Amount> amountList = new ArrayList<>();

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
    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("members.data")))) {

      int size = in.readInt();

      for(int i = 0; i < size; i++) {
        Member m = new Member();
        m.setNo(in.readInt());
        m.setName(in.readUTF());
        m.setNationality(in.readUTF());
        m.setPosition(in.readUTF());

        memberList.add(m);
      }
      System.out.println("선수 데이터 로딩!");
    } catch (Exception e) {
      System.out.println("선수 데이터 로딩 중 오류 발생!");
    }
  }
  static void saveMembers() {
    try(DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("members.data")))) {

      out.writeInt(memberList.size());

      for(Member m : memberList) {
        out.writeInt(m.getNo());
        out.writeUTF(m.getName());
        out.writeUTF(m.getNationality());
        out.writeUTF(m.getPosition());
      }
      System.out.println("선수 데이터 저장 완료!");
    }catch (Exception e) {
      System.out.println(" 선수 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }
  static void loadTrainings() {
    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("trainings.data")))) {

      int size = in.readInt();

      for(int i = 0; i < size; i++) {
        Training t = new Training();
        t.setName(in.readUTF());
        t.setTitle(in.readUTF());
        t.setContent(in.readUTF());
        t.setStartDate(Date.valueOf(in.readUTF()));
        t.setEndDate(Date.valueOf(in.readUTF()));

        trainingList.add(t);
      }
      System.out.println("선수 훈련 데이터 로딩!");
    } catch (Exception e) {
      System.out.println("선수 훈련 데이터 로딩 중 오류 발생!");
    }
  }
  static void saveTrainings() {
    try(DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("trainings.data")))) {

      out.writeInt(trainingList.size());

      for(Training t : trainingList) {
        out.writeUTF(t.getName());
        out.writeUTF(t.getTitle());
        out.writeUTF(t.getContent());
        out.writeUTF(t.getStartDate().toString());
        out.writeUTF(t.getEndDate().toString());
      }
      System.out.println("선수 훈련 데이터 저장 완료!");
    }catch (Exception e) {
      System.out.println(" 선수 훈련 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }
  static void loadFoods() {
    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("foods.data")))) {

      int size = in.readInt();

      for(int i = 0; i < size; i++) {
        Food f = new Food();
        f.setName(in.readUTF());
        f.setCarbohydrate(in.readInt());
        f.setProtein(in.readInt());
        f.setCalcium(in.readInt());
        f.setFat(in.readInt());
        f.setVitamin(in.readInt());

        foodList.add(f);
      }
      System.out.println("선수 식단 데이터 로딩!");
    } catch (Exception e) {
      System.out.println("선수 식단 데이터 로딩 중 오류 발생!");
    }
  }
  static void saveFoods() {
    try(DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("foods.data")))) {

      out.writeInt(foodList.size());

      for(Food f : foodList) {
        out.writeUTF(f.getName());
        out.writeInt(f.getCarbohydrate());
        out.writeInt(f.getProtein());
        out.writeInt(f.getCalcium());
        out.writeInt(f.getFat());
        out.writeInt(f.getVitamin());
      }
      System.out.println("선수 식단 데이터 저장 완료!");
    }catch (Exception e) {
      System.out.println(" 선수 식단 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }

  static void loadAmounts() {
    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("amounts.data")))) {

      int size = in.readInt();

      for(int i = 0; i < size; i++) {
        Amount a = new Amount();
        a.setNumber(in.readInt());
        a.setFowardprice(in.readInt());
        a.setMidfielderprice(in.readInt());
        a.setDefenderprice(in.readInt());

        amountList.add(a);
      }
      System.out.println("선수 이적료 데이터 로딩!");
    } catch (Exception e) {
      System.out.println("선수 이적료 데이터 로딩 중 오류 발생!");
    }
  }
  static void saveAmounts() {
    try(DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("amounts.data")))) {

      out.writeInt(amountList.size());

      for(Amount a : amountList) {
        out.writeInt(a.getNumber());
        out.writeInt(a.getFowardprice());
        out.writeInt(a.getMidfielderprice());
        out.writeInt(a.getDefenderprice());
      }
      System.out.println("선수 이적료 데이터 저장 완료!");
    }catch (Exception e) {
      System.out.println(" 선수 이적료 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }
}
