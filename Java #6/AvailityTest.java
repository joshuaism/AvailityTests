import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class AvailityTest{
  public static void main(String[] args){

    HashMap<String, UserInfo> users = ReadInputFile();

    UserInfo[] sortedUsers = users.values().toArray(new UserInfo[0]);

    if(sortedUsers.length > 1) {
      sortedUsers = SortByNames(sortedUsers);
    }

    HashMap<String, ArrayList<UserInfo>> companySortedMap = GetUserCompanies(sortedUsers);

    WriteCompanyFiles(companySortedMap);
  }

  // reads the input file and returns hashmap of data without duplicates
  public static HashMap<String, UserInfo> ReadInputFile(){
    String fileName = "inputCSV.csv";
    File file = new File(fileName);
    HashMap<String, UserInfo> users = new HashMap<>();

    try{
      Scanner inputStream = new Scanner(file);
      while(inputStream.hasNext()){
        String dataLine = inputStream.nextLine();
        String[] lineValues = dataLine.split(",");
        UserInfo userInfo = new UserInfo(lineValues[0].trim(), lineValues[1].trim(), Integer.parseInt(lineValues[2].trim()), lineValues[3].trim());
        String userKey = userInfo.getUserId()+userInfo.getCompany();

        //Removes duplicates for same userId with same insurance company
        if(users.containsKey(userKey)){
          if(users.get(userKey).getVersion() < userInfo.getVersion()){
            users.replace(userKey, userInfo);
          }
        } else {
          users.put(userKey, userInfo);
        }
      }
      inputStream.close();
    } catch(FileNotFoundException e){
      e.printStackTrace();
    }

    return users;
  }


  // sorts users by full name and returns sorted array
  public static UserInfo[] SortByNames(UserInfo[] users){
    boolean sorted = false;
    while(sorted == false){
      sorted = true;
      for(int i=1; i < users.length; i++){
        if(users[i].getFullName().compareTo(users[i-1].getFullName()) < 0){
          sorted = false;
          UserInfo temp = users[i];
          users[i] = users[i-1];
          users[i-1] = temp;
        }
      }
    }

    return users;
  }

  // gets users and returns hashmap with keys of company names and value being arraylist of users for that company
  public static HashMap<String, ArrayList<UserInfo>> GetUserCompanies(UserInfo[] users){
    HashMap<String, ArrayList<UserInfo>> companySorted = new HashMap<>();

    for(int i=0; i< users.length; i++){
      String userCompany = users[i].getCompany();

      if(companySorted.containsKey(userCompany)){
        companySorted.get(userCompany).add(users[i]);
      } else {
        ArrayList<UserInfo> temp = new ArrayList<>();
        temp.add(users[i]);
        companySorted.put(userCompany, temp);
      }
    }

    return companySorted;
  }

  // will write to a file with the company name for each company in map with users
  public static void WriteCompanyFiles(HashMap<String, ArrayList<UserInfo>> users){
    for(String company : users.keySet()){
      try{
        File companyFile = new File((company+".csv").trim());
        FileWriter writer = new FileWriter(companyFile);
        for(UserInfo user : users.get(company)) {
          writer.append(user.getUserId()+","+user.getFullName()+","+user.getVersion()+","+user.getCompany()+"\n");
        }
        writer.close();
      } catch(IOException e){
        e.printStackTrace();
      }
    }
  }
}
