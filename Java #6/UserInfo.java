public class UserInfo{
  //globals
  private String userId;
  private String fullName;
  private int version;
  private String company;

  UserInfo(String userId, String fullName, int version, String company){
    this.userId = userId;
    this.fullName = fullName;
    this.version = version;
    this.company = company;
  }

  public String getUserId() {
    return this.userId;
  }

  public String getFullName() {
    return this.fullName;
  }

  public int getVersion() {
    return this.version;
  }

  public String getCompany() {
    return this.company;
  }
}
