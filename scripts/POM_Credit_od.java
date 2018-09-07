package transaction_credit_Od_Balance;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thoughtworks.selenium.webdriven.commands.Click;
public class POM_Credit_od {
		
	 Select dropdown;
	 WebDriver driver;
	 Actions builder;    
	 
	By transaction=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(2) > a");
	By transaction_entry=By.cssSelector(".nav > li:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)");
	By reciept=By.cssSelector(".nav > li:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)");
	By drop_memberid1=By.cssSelector("#member_chosen > a:nth-child(1) > div:nth-child(2) > b:nth-child(1)");
    By memberid_textbox1=By.cssSelector("#member_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
    By drop_accno1=By.cssSelector("#account_chosen > a:nth-child(1) > div:nth-child(2) > b:nth-child(1)");
    By accno_textbox1=By.cssSelector("#account_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
    By transaction_type=By.cssSelector("#transaction_chosen > a:nth-child(1) > div:nth-child(2) > b:nth-child(1)");
    By transaction_type_textbox=By.cssSelector("#transaction_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
    By instru_select=By.cssSelector("#instrumenttype_chosen > a:nth-child(1) > div:nth-child(2) > b:nth-child(1)");
    By instru_type_textbox=By.cssSelector("#instrumenttype_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
    By submit=By.cssSelector("#submit");
    By amt_textbox=By.cssSelector("#amount");
    By acc_bal=By.cssSelector("#balance");
    By cheque_number=By.cssSelector("#chequeno");
    By message=By.cssSelector("#notification");
    By od=By.cssSelector("#draw");
	public POM_Credit_od(WebDriver driver,Actions builder)
	 {
	  this.driver = driver;
	  this.builder = builder;

	 }
	 
	 public void transaction(String operation1,String operation2,String Member_id,String acc_number,String Transaction_type,String Instrument_type,String chequeno,String Transaction_code,String Credit_Amount
) throws InterruptedException {
	  
	  // TODO Auto-generated method stub
		 driver.findElement(transaction).click();
		 driver.findElement(transaction_entry).click();
		 driver.findElement(reciept).click();
		 driver.findElement(drop_memberid1).click();
		  driver.findElement(memberid_textbox1).sendKeys(Member_id+Keys.ENTER);
		  Thread.sleep(2000);
		  driver.findElement(drop_accno1).click();
		  Thread.sleep(2000);
		  driver.findElement(accno_textbox1).sendKeys(acc_number+Keys.ENTER);
		  Thread.sleep(2000);
		  String initial_bal=driver.findElement(acc_bal).getAttribute("value");
		  
	      double f_initial_bal=Double.parseDouble(initial_bal);
	      System.out.println("Current Balance:"+f_initial_bal);
		 /* String od_bal=driver.findElement(od).getAttribute("value");
		  double od_p=Double.parseDouble(od_bal);
		  System.out.println("Before transaction od bal="+od_p);*/
		  driver.findElement(instru_select).click();
		  Thread.sleep(2000);
		  driver.findElement(instru_type_textbox).sendKeys(Instrument_type+Keys.ENTER);
		  Thread.sleep(2000);
		  if(Instrument_type.contains("Cheque"))
		  {
			  driver.findElement(cheque_number).sendKeys(chequeno);
		  }
		 
		  System.out.println("Debit transaction in progress");
		  driver.findElement(transaction_type).click();
		  Thread.sleep(2000);
		  driver.findElement(transaction_type_textbox).sendKeys(operation2+Keys.ENTER);
		  Thread.sleep(2000);
		  double added=f_initial_bal+1000;
		  int s=(int)added;
		  String debit_amount= String.valueOf(s);
		  
		  driver.findElement(amt_textbox).sendKeys(debit_amount);
		  System.out.println(debit_amount);
		  Thread.sleep(2000);
		  driver.findElement(submit).click();
		  
		  driver.findElement(drop_memberid1).click();
		  driver.findElement(memberid_textbox1).sendKeys(Member_id+Keys.ENTER);
		  Thread.sleep(2000);
		  driver.findElement(drop_accno1).click();
		  Thread.sleep(2000);
		  driver.findElement(accno_textbox1).sendKeys(acc_number+Keys.ENTER);
		  Thread.sleep(2000);
		  
		  String od_db_amt=driver.findElement(od).getAttribute("value");
		  System.out.println("OD After debit="+od_db_amt);
		  Double final2=Double.parseDouble(od_db_amt);
		  Thread.sleep(2000);
		  /*driver.findElement(amt_textbox).sendKeys(Amount);
		  driver.findElement(select3).click();
		  Thread.sleep(2000);
		  */
		  String acc_bald=driver.findElement(acc_bal).getAttribute("value");
		  System.out.println(acc_bald);
		  Double f_acc_bal=Double.parseDouble(acc_bald);
		 if(f_acc_bal==0.0)
		 {
			  driver.findElement(transaction_type).click();
			  Thread.sleep(2000);
	      driver.findElement(transaction_type_textbox).sendKeys(operation1+Keys.ENTER);
	      Thread.sleep(2000);
	      driver.findElement(amt_textbox).sendKeys(Credit_Amount);
	      Thread.sleep(2000);
	      driver.findElement(submit).click();
	      Thread.sleep(2000);
	      driver.findElement(drop_memberid1).click();
		  driver.findElement(memberid_textbox1).sendKeys(Member_id+Keys.ENTER);
		  Thread.sleep(2000);
		  driver.findElement(drop_accno1).click();
		  Thread.sleep(2000);
		  driver.findElement(accno_textbox1).sendKeys(acc_number+Keys.ENTER);
		  Thread.sleep(2000);
		  String amt12=driver.findElement(acc_bal).getAttribute("value");
		  System.out.println("Current Balance:"+amt12);
		  
		  double amt112=Double.parseDouble(amt12);
		  System.out.println("actual balance after credit in od:"+amt112);
		  double expexted_total_balance=amt112+final2;
		  System.out.println("expected balanace after credit in od:"+expexted_total_balance);
		  Assert.assertEquals(amt112, expexted_total_balance);
		  //  Double expected_od=od_p-debit;
		  //  System.out.println("od exp="+expected_od);
		
		   
	 }

	 }}

