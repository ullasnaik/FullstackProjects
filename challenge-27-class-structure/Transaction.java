import java.util.Date;

import enums.TransactionType;

public class Transaction {
  
  private long transactionId;
  private Date transactionDate;
  private double amount;
  private TransactionType transactionType;

  public Transaction(long transactionId, Date transactionDate, double amount, TransactionType transactionType) {
    this.transactionId = transactionId;
    this.transactionDate = transactionDate;
    this.amount = amount;
    this.transactionType = transactionType;
  }

  public Transaction() {
  }

  public long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(long transactionId) {
    this.transactionId = transactionId;
  }

  public Date getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }

  
  
}
