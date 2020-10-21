import enums.AccountStatus;
import enums.AccountType;

public class Customer {

  private String mobileNumber;
  private String aadhaarNumber;
  private long customerId;
  private String firstName;
  private String lastName;
  private String email;
  private Address address;
  private SavingsAccount savingsAccount;

  public Customer(String mobileNumber, String aadhaarNumber, long customerId, String firstName, String lastName,
      String email, Address address) {
    this.mobileNumber = mobileNumber;
    this.aadhaarNumber = aadhaarNumber;
    this.customerId = customerId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
  }

  public Customer() {
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getAadhaarNumber() {
    return aadhaarNumber;
  }

  public void setAadhaarNumber(String aadhaarNumber) {
    this.aadhaarNumber = aadhaarNumber;
  }

  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Address getAddress() {
    return address;
  }

  public SavingsAccount getSavingsAccount() {
    return savingsAccount;
  }


  public void acceptCustomerDetails() {

  }

  private boolean isValid() {

    return false;

  }

  public void displayCustomerDetails() {
    
  }

  public SavingsAccount openNewSavingsAccount(AccountStatus accountStatus) {
    savingsAccount = new SavingsAccount(1000l, 0.0, accountStatus, AccountType.ACTIVE, new Transaction[100]);

    return savingsAccount;
  }
  
  
  
}