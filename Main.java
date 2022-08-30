import java.util.Scanner; 
import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document; 
import org.jsoup.select.Elements;
import java.util.ArrayList; 

class Main {
  private static ArrayList<Alert> list = new ArrayList<Alert>(); 

  public static void userPrompt(){
    //Create new object 
    //prompt user for information 
    System.out.println("\nType \"YES\" if would like to add an Alert, or type \"NO\" if you are finished with adding Alerts"); 
    Scanner input2 = new Scanner(System.in); 
    String response = input2.nextLine();
    if(response.equals("YES")){ 
      System.out.println("\nPlease enter the ticker");
      Scanner in = new Scanner(System.in); 
      String ticker = in.nextLine();
      System.out.println("\nPlease enter the exchange of the equity:");
      Scanner input1 = new Scanner(System.in); 
      String exchange = input1.nextLine();
      System.out.println("\nPlease enter the target price of the equity when you want to be alerted:");
      Scanner input = new Scanner(System.in); 
      double targetPrice = input.nextDouble();
      Alert alert = new Alert(ticker,exchange,targetPrice); 
      list.add(alert);    
      userPrompt(); 
    } else {
      System.out.println("\nYour alerts have began running at!"); 
      for(int i = 0; i<list.size(); i++){
        list.get(i).run();   
      }
    }
  } 
  
  public static void main(String[] args){
    System.out.println("\nHello, welcome to your Java Alert System!");
    userPrompt(); 
  }
}