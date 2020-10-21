package org.example.springormdemo.exception;

public class ServiceException extends Exception {
  private String message;

  public ServiceException() {
    super();
  }

  public ServiceException(String message) {
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
