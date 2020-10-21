package org.example.springjdbcdemo.exception;

public class DAOException extends Exception {
  private String message;

  public DAOException() {
    super();
  }

  public DAOException(String message) {
    super(message);
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
