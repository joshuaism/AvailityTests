import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LISPTest{
  public static void main(String[] args) throws IOException {

    System.out.println("Please enter string for validation");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String testString = reader.readLine();

    int leftParenCount = 0;
    int rightParenCount = 0;
    boolean nestedCorrectly = true;

    for(int i = 0; i < testString.length(); i++){
      String character = testString.substring(i, i+1);

      if(character.equals("(")){
        leftParenCount++;
      } else if (character.equals(")")){
        rightParenCount++;
      }

      if(rightParenCount > leftParenCount){
        nestedCorrectly = false;
      }
    }
    if(!(leftParenCount == rightParenCount) || !nestedCorrectly){
      System.out.println("This fails and is not using parentheses correctly");
    }

  }
}
