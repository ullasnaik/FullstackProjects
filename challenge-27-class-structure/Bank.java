import enums.AccountStatus;

public class Bank {

  public static void main(String[] args) {

    Customer customerA = new Customer("1234567890", "1234 5678 9012", 1, "Sourav", "Sharma", "sourav.sharma@gmail.com",
     new Address("10/1", "Main Road", "Happyville", "400010", "Tamil Nadu", "Near Post Office"));
     customerA.openNewSavingsAccount(AccountStatus.REGULAR);

     // deposit 10000 in the account

     customerA.getSavingsAccount().deposit(10000);
     System.out.println("Updated Customer Account Balance:"+customerA.getSavingsAccount().getBalance());
     customerA.getSavingsAccount().displayAllTransactions();

     //withdraw 5000 from the account

     customerA.getSavingsAccount().withdraw(5000);
     System.out.println("Updated Customer Account Balance:"+customerA.getSavingsAccount().getBalance());
     customerA.getSavingsAccount().displayAllTransactions();


  }
  
}
