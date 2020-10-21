import java.util.Date;

import enums.AccountStatus;
import enums.AccountType;
import enums.TransactionType;

public class SavingsAccount {

  private long accountNo;
  private double balance;
  private AccountStatus status;
  private AccountType type;
  private Transaction[] transactions;

  public SavingsAccount(long accountNo, double balance, AccountStatus status, AccountType type,
      Transaction[] transactions) {
    this.accountNo = accountNo;
    this.balance = balance;
    this.status = status;
    this.type = type;
    this.transactions = transactions;
  }

  public SavingsAccount() {
  }

 public long getAccountNo() {
    return accountNo;
  }

  public double getBalance() {
    return balance;
  }

  public AccountStatus getStatus() {
    return status;
  }

  public AccountType getType() {
    return type;
  }

  public Transaction[] getTransactions() {
    return transactions;
  }

  

  public boolean deposit(double amount) {
    balance = balance+amount;
    Transaction transaction = new Transaction(100000l, new Date(), amount, TransactionType.DEPOSIT);
    for (int i=0;i<transactions.length;i++) {
      if(transactions[i]==null) {
        transactions[i] = transaction;
        break;
      }
    }
    return true;
  }

  public boolean withdraw(double amount) {
    if(amount<balance) {
      balance = balance-amount;
      Transaction transaction = new Transaction(100010l, new Date(), amount, TransactionType.WITHDRAWAL);
      for (int i=0;i<transactions.length;i++) {
        if(transactions[i]==null) {
          transactions[i] = transaction;
          break;
        }
      }
      return true;
    }
    System.out.println("Invalid Transaction!!! Trying to withdraw more than available balance");
    return false;
  }

  private long generateAccountNumber() {
    return 0;
  }

  public void displayAllTransactions() {
    for(Transaction txn:transactions) {
      if(txn!=null) {
      System.out.println(txn.getTransactionId()+"  "+txn.getTransactionDate()+"  "+txn.getAmount()+"  "+
      txn.getTransactionType());
      } else  
          break;
    }
  }

  // public Transaction getLatestTransaction() {

  // }

  // public boolean isAccountActive() {

  // }


  
  
}
