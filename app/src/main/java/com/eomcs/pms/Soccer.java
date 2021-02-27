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

  static ArrayList<Member> memberList = new ArrayList<>();
  static ArrayList<Training> trainingList = new ArrayList<>();
  static ArrayList<Food> foodList = new ArrayList<>();
  static ArrayList<Amount> amountList = new ArrayList<>();

  static Stack commandStack  = new Stack();

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws CloneNotSupportedException {

    loadMembers();
    loadTrainings();
    loadFoods();
    loadAmounts();

    Map<String, String> map = new Hashtable<String,String>();
    map.put("soccer", "1111");


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
        Member member = new Member();
        member.setNo(in.readInt());
        member.setName(in.readUTF());
        member.setNationality(in.readUTF());
        member.setPosition(in.readUTF());

        memberList.add(member);
      }
    } catch (Exception e) {
      System.out.println("선수 데이터 로딩 중 오류 발생!");
    }
  }
  static void saveMembers() {
    try(DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("members.data")))) {
      out.writeInt(memberList.size());

      for(Member member : memberList) {
        out.writeInt(member.getNo());
        out.writeUTF(member.getName());
        out.writeUTF(member.getNationality());
        out.writeUTF(member.getPosition());
      }

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
        Training training = new Training();
        training.setName(in.readUTF());
        training.setTitle(in.readUTF());
        training.setContent(in.readUTF());
        training.setStartDate(Date.valueOf(in.readUTF()));
        training.setEndDate(Date.valueOf(in.readUTF()));

        trainingList.add(training);
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

      for(Training training : trainingList) {
        out.writeUTF(training.getName());
        out.writeUTF(training.getTitle());
        out.writeUTF(training.getContent());
        out.writeUTF(training.getStartDate().toString());
        out.writeUTF(training.getEndDate().toString());
      }
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
        Food food = new Food();
        food.setName(in.readUTF());
        food.setCarbohydrate(in.readInt());
        food.setProtein(in.readInt());
        food.setCalcium(in.readInt());
        food.setFat(in.readInt());
        food.setVitamin(in.readInt());

        foodList.add(food);
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

      for(Food food : foodList) {
        out.writeUTF(food.getName());
        out.writeInt(food.getCarbohydrate());
        out.writeInt(food.getProtein());
        out.writeInt(food.getCalcium());
        out.writeInt(food.getFat());
        out.writeInt(food.getVitamin());
      }
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
        Amount amount = new Amount();
        amount.setNumber(in.readInt());
        amount.setFowardprice(in.readInt());
        amount.setMidfielderprice(in.readInt());
        amount.setDefenderprice(in.readInt());

        amountList.add(amount);
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

      for(Amount amount : amountList) {
        out.writeInt(amount.getNumber());
        out.writeInt(amount.getFowardprice());
        out.writeInt(amount.getMidfielderprice());
        out.writeInt(amount.getDefenderprice());
      }
    }catch (Exception e) {
      System.out.println(" 선수 이적료 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }
}
