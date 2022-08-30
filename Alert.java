import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document; 
import org.jsoup.select.Elements; 

public class Alert extends Thread {
  private String ticker; 
  private String exchange; 
  private double targetPrice; 

  public Alert(String t,String ex,double tp){
    this.ticker = t; 
    this.exchange = ex; 
    this.targetPrice = tp; 
  }
  
  public String getTicker(){
    return ticker; 
  }
  
  public String getExchange(){
    return exchange; 
  }
  
  public double getTargetPrice(){
    return targetPrice; 
  }

  //Override
  public void run(){
    String t = ""; 
    while(true) { 
      try { 
        final String  url = "https://www.google.com/finance/quote/"+ticker+":" + exchange;
        final Document doc = Jsoup.connect(url).get(); 
        Elements body = doc.select("div.YMlKec.fxKbKc"); // wrong elemtent "Fw(b) Fz(36px) Mb(-4px) D(ib)" 
        String str = body.text(); 
        str = str.replace("$", ""); //The issue was the money sign not the comma 
        str = str.replace(" ", "");
        double d = Double.parseDouble(str); 
        Elements time = doc.select("div.ygUjEc"); // wrong elemtent "Fw(b) Fz(36px) Mb(-4px) D(ib)" 
        t = time.text(); 
        if( d == targetPrice){ 
          break;
    } }catch (Exception e) {
          System.out.println(e);
          }  
        } 
      System.out.println("\nThe target price of $"+ targetPrice + " has been reached for ticker "+ ticker);
  }
}


 