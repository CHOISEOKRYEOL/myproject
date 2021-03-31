package com.eomcs.pms;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.ApplicationContextListener;
import com.eomcs.pms.domain.Amount;
import com.eomcs.pms.domain.Food;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Training;
import com.eomcs.pms.handler.AmountAddHandler;
import com.eomcs.pms.handler.AmountListHandler;
import com.eomcs.pms.handler.Command;
import com.eomcs.pms.handler.FoodAddHandler;
import com.eomcs.pms.handler.FoodListHandler;
import com.eomcs.pms.handler.GoodbyeHandler;
import com.eomcs.pms.handler.HelloHandler;
import com.eomcs.pms.handler.MemberAddHandler;
import com.eomcs.pms.handler.MemberDeleteHandler;
import com.eomcs.pms.handler.MemberDetailHandler;
import com.eomcs.pms.handler.MemberListHandler;
import com.eomcs.pms.handler.MemberUpdateHandler;
import com.eomcs.pms.handler.TrainingAddHandler;
import com.eomcs.pms.handler.TrainingListHandler;
import com.eomcs.pms.listener.AppListener;
import com.eomcs.util.Prompt;

public class Soccer {

  List<ApplicationContextListener> listeners = new ArrayList<>();

  static ArrayDeque<String> commandStack = new ArrayDeque<>();
  static LinkedList<String> commandQueue = new LinkedList<>();

  String serverAddress;
  int port;

  public static LinkedList<Member> memberList = new LinkedList<>();
  public static ArrayList<Training> trainingList = new ArrayList<>();
  public static ArrayList<Food>foodList = new ArrayList<>();
  public static ArrayList <Amount>amountList = new ArrayList<>();

  static File boardFile = new File("boards.json");
  static File memberFile = new File("members.json");
  static File projectFile = new File("projects.json");
  static File taskFile = new File("tasks.json");

  Stack<String> commandStack1  = new Stack<String>();

  Scanner scanner = new Scanner(System.in);

  private List<ApplicationContextListener> commandMap;

  public static void main(String[] args) {

    Soccer soccer = new Soccer();

    soccer.addApplicationContextListener(new AppListener());

    soccer.service();
  }

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  public void service() {

    notifyOnServiceStarted();

    Map<String, String> map = new Hashtable<String,String>();
    map.put("soccer", "1111");

    loadMembers();
    loadTrainings();
    loadFoods();
    loadAmounts();

    HashMap<String,Command> commandMap = new HashMap<>();

    commandMap.put("/member/add", new MemberAddHandler());
    commandMap.put("/member/list", new MemberListHandler(memberList));
    commandMap.put("/member/detail", new MemberDetailHandler(memberList));
    commandMap.put("/member/update", new MemberUpdateHandler(memberList));
    commandMap.put("/member/delete", new MemberDeleteHandler(memberList));

    commandMap.put("/training/add", new TrainingAddHandler(trainingList));
    commandMap.put("/training/list", new TrainingListHandler(trainingList));

    commandMap.put("/food/add", new FoodAddHandler(foodList));
    commandMap.put("/food/list", new FoodListHandler(foodList));

    commandMap.put("/amount/add", new AmountAddHandler(amountList));
    commandMap.put("/amount/list", new AmountListHandler(amountList));

    commandMap.put("/hello", new HelloHandler());
    commandMap.put("/bye", new GoodbyeHandler());

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
        String command = com.eomcs.util.Prompt.inputString("명령>");

        commandStack.push(command);
        commandQueue.offer(command);

        try {
          switch (command) {

            case "history" :
              printCommandHistory();
              break;
            case "exit":
              System.out.println("안녕!");
              break loop;
            default:
              Command commandHandler = commandMap.get(command);

              if(commandHandler == null) {
                System.out.println("실행할 수 없는 명령입니다.");
              }else {
                commandHandler.service();
              }
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

    notifyOnServiceStopped();

    Prompt.close();
  }

  void printCommandHistory() throws CloneNotSupportedException {
    @SuppressWarnings("unchecked")
    Stack<String> stack = (Stack<String>) commandStack1.clone();

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

  void loadMembers() {
    try (Scanner in = new Scanner(new FileReader("members.csv"))) {

      while(true) {
        try {
          String record = in.nextLine();
          String[] fields = record.split(",");
          Member m = new Member();
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
  void saveMembers() {
    try(FileWriter out = new FileWriter("members.csv")) {
      for(Member member : memberList) {
        out.write(String.format("%d,%s,%s,%s\n",
            member.getNo(),
            member.getName(),
            member.getNationality(),
            member.getPosition()));
      }
      System.out.println("선수 데이터 저장 완료!");
    }catch (Exception e) {
      System.out.println(" 선수 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }
  void loadTrainings() {
    try (Scanner in = new Scanner(
        new FileReader("trainings.csv"))) {

      while(true) {
        try {
          String[] fields = in.nextLine().split(",");

          Training t = new Training();
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

  void saveTrainings() {
    try(FileWriter out = new FileWriter("trainings.csv")) {

      for(Training t : trainingList) {
        out.write(String.format("%s,%s,%s,%s,%s\n",
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
  void loadFoods() {
    try (Scanner in = new Scanner(new FileReader("foods.csv"))) {

      while(true) {
        try {
          String[] fields = in.nextLine().split(",");

          Food f = new Food();
          f.setName(fields[0]);
          f.setCarbohydrate(Integer.parseInt(fields[1]));
          f.setProtein(Integer.parseInt(fields[2]));
          f.setCalcium(Integer.parseInt(fields[3]));
          f.setFat(Integer.parseInt(fields[4]));
          f.setVitamin(Integer.parseInt(fields[5]));

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

  void saveFoods() {
    try(FileWriter out = new FileWriter("foods.csv")) {

      for(Food f : foodList) {
        out.write(String.format("%s,%d,%d,%d,%d,%d", 
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

  void loadAmounts() {
    try (Scanner in = new Scanner(
        new FileReader("amounts.csv"))) {

      while(true) {
        try {
          String[] fields = in.nextLine().split(",");

          Amount a = new Amount();
          a.setFowardprice(Integer.parseInt(fields[0]));
          a.setMidfielderprice(Integer.parseInt(fields[1]));
          a.setDefenderprice(Integer.parseInt(fields[2]));

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
  void saveAmounts() {
    try(FileWriter out = new FileWriter("amounts.csv")) {

      for(Amount a : amountList) {
        out.write(String.format("%d,%d,%d\n",
            a.getFowardprice(),
            a.getMidfielderprice(),
            a.getDefenderprice()));
      }
      System.out.println("선수 이적료 데이터 저장 완료!");
    }catch (Exception e) {
      System.out.println(" 선수 이적료 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }

  private void notifyOnServiceStarted() {
    for(ApplicationContextListener listener : listeners) {
      listener.contextInitialized();
    }
  }
  private void notifyOnServiceStopped() {
    for(ApplicationContextListener listener : listeners) {
      listener.contextDestroyed();
    }
  }
}
