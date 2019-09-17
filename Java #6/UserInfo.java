public class UserInfo{
  //globals
  private String userId;
  private String firstName;
  private String lastName;
  private int version;
  private String company;

  UserInfo(String userId, String firstName, String lastName, int version, String company){
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.version = version;
    this.company = company;
  }

  public String getUserId() {
    return this.userId;
  }

  public String getFullName() {
    return (this.firstName + " " + this.lastName);
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public int getVersion() {
    return this.version;
  }

  public String getCompany() {
    return this.company;
  }
}
