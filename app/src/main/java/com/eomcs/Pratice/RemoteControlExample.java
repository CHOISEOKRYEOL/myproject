package com.eomcs.Pratice;

public class RemoteControlExample {

  public static void main(String[] args) {
    RemoteControl rc;
    rc = new Television();
    rc = new Audio();
    rc.setVolume(5);
  }

}