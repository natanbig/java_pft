package co.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
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

  public ContactData(int id, String firstName, String midleName, String lastName, String title, String companyName, String address, String homeTelephone, String mobileTelephone, String workTelephone, String email, String group) {
    this.id=id;
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

  public ContactData(String firstName, String midleName, String lastName, String title, String companyName, String address, String homeTelephone, String mobileTelephone, String workTelephone, String email, String group) {
    this.id=Integer.MAX_VALUE;
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

  public void setId(int id) {
    this.id = id;
  }

  public String getCompanyName() {
    return companyName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    return address != null ? address.equals(that.address) : that.address == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ContactData{");
    sb.append("id='").append(id).append('\'');
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", address='").append(address).append('\'');
    sb.append('}');
    return sb.toString();
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

  public int getId() {
    return id;
  }
}
