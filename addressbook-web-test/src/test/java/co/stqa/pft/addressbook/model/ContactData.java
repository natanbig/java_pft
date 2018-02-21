package co.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String midleName;
  private final String lastName;
  private final String title;
  private final String companyName;
  private final String address;
  private final String homeTelephone;
  private final String mobileTelephone;
  private final String workTelephone;
  private final String email;
  private String group;

  public ContactData(String firstName, String midleName, String lastName, String title, String companyName, String address, String homeTelephone, String mobileTelephone, String workTelephone, String email, String group) {
    this.firstName = firstName;
    this.midleName = midleName;
    this.lastName = lastName;
    this.title = title;
    this.companyName = companyName;
    this.address = address;
    this.homeTelephone = homeTelephone;
    this.mobileTelephone = mobileTelephone;
    this.workTelephone = workTelephone;
    this.email = email;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMidleName() {
    return midleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getAddress() {
    return address;
  }

  public String getHomeTelephone() {
    return homeTelephone;
  }

  public String getMobileTelephone() {
    return mobileTelephone;
  }

  public String getWorkTelephone() {
    return workTelephone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }
}
