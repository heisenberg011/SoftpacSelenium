package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.Click;


public class ModifyAddressPageFactor {
	Select dropdown;
	WebDriver driver;
	Actions builder;

	By address = By.id("tab_menu_3");
	By addressL1 = By.id("Address1");
	By addressL2 = By.id("Address2");
	By state = By.id("state");
	By pincode = By.id("pin");
	By landline = By.id("landline");
	By mobileNo = By.id("mobile");
	By emailId = By.id("email");
	By village = By.id("custcity_chosen");
	By villageSearch = By.cssSelector("#custcity_chosen > div > div > input[type='text']");
	
	public ModifyAddressPageFactor(WebDriver driver,Actions builder)
	{
		this.driver = driver;
		this.builder = builder;
	//	this.builder= builder;
	}

	public void address(String address1,String address2,
			String state1,String pincode1,String landline1,String mobileNo1,
			String emailId1, String village1) throws InterruptedException
	{

		driver.findElement(address).click();
		driver.findElement(addressL1).sendKeys(address1);
		driver.findElement(addressL2).sendKeys(address2);
		Thread.sleep(1000);
		driver.findElement(village).click();
		driver.findElement(villageSearch).sendKeys(village1 + Keys.ENTER);
		driver.findElement(state).sendKeys(state1);
		driver.findElement(pincode).sendKeys(pincode1);
		driver.findElement(landline).sendKeys(landline1);
		driver.findElement(mobileNo).sendKeys(mobileNo1);
		driver.findElement(emailId).clear();
		driver.findElement(emailId).sendKeys(emailId1);	
		
		
	}
	
	By panNo = By.id("pan");
	By addres1 = By.id("tab_menu_2");
	public void nonIndiAddress(String address1,String address2,
			String state1,String pincode1,String landline1,String mobileNo1,
			String emailId1, String village1,String pan1) throws InterruptedException
	{

		driver.findElement(addres1).click();
		driver.findElement(panNo).sendKeys(pan1);
		driver.findElement(addressL1).sendKeys(address1);
		driver.findElement(addressL2).sendKeys(address2);
		Thread.sleep(1000);
		driver.findElement(village).click();
		driver.findElement(villageSearch).sendKeys(village1 + Keys.ENTER);
		driver.findElement(state).sendKeys(state1);
		driver.findElement(pincode).sendKeys(pincode1);
		driver.findElement(landline).sendKeys(landline1);
		driver.findElement(mobileNo).sendKeys(mobileNo1);
		driver.findElement(emailId).clear();
		driver.findElement(emailId).sendKeys(emailId1);	
		
		
	}
	
	
	
	
	
	


}
