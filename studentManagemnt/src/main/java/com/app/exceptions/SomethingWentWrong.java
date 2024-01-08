package com.app.exceptions;

public class SomethingWentWrong extends RuntimeException {
  public SomethingWentWrong(String msg) {
	  super(msg);
  }
}
