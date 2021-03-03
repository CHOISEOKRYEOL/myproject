package com.eomcs.pms.listener;

import com.eomcs.ApplicationContextListener;

public class AppListener implements ApplicationContextListener {

  @Override
  public void contextInitialized() {
    System.out.println("선수 관리 시스템 시작~~~~~!");
  }

  @Override
  public void contextDestroyed() {
    System.out.println("선수 관리 시스템 종료~~~~~!");
  }

}
