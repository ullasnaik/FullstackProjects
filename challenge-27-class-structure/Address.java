public class Address {

  private String houseNo;
  private String streetName;
  private String village;
  private String pin;
  private String state;
  private String landmark;

  public Address() {
  }

  public Address(String houseNo, String streetName, String village, String pin, String state, String landmark) {
    this.houseNo = houseNo;
    this.streetName = streetName;
    this.village = village;
    this.pin = pin;
    this.state = state;
    this.landmark = landmark;
  }

  public String getHouseNo() {
    return houseNo;
  }

  public void setHouseNo(String houseNo) {
    this.houseNo = houseNo;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getVillage() {
    return village;
  }

  public void setVillage(String village) {
    this.village = village;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getLandmark() {
    return landmark;
  }

  public void setLandmark(String landmark) {
    this.landmark = landmark;
  }

  public void acceptAddressDetails() {

  }

  private boolean isValidAddress() {
    return false;
  }

  public void displayAddressDetails() {

  }
  
  
}
