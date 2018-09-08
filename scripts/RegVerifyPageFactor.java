package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.thoughtworks.selenium.webdriven.commands.Click;

public class RegVerifyPageFactor {
	Select dropdown;
	WebDriver driver;
	Actions builder;
	By verify = By.id("tab_menu_2");
	By panNo = By.id("pan");
	By aadhar = By.id("aadhar");
	By driving = By.id("driving");
	By passport = By.id("passport");
	By voter = By.id("voter");
	By amount = By.id("amount");
	By yes = By.id("mycheckbox4");
	By no = By.id("mycheckbox5");
	By wardAddress = By.id("wardAddress");
	By yesCheckbox = By.id("mycheckbox4");
	By noCheckbox = By.id("mycheckbox5"); 
	public RegVerifyPageFactor(WebDriver driver,Actions builder)
	{
		this.driver = driver;
		this.builder = builder;
	
	}
	
	public void verify(String pan1, String aadhar1, String driving1, String passport1, String voter1,String form60, String form61, String amount1,String assessTax,String wardAddress1)
	{
		driver.findElement(verify).click();
		driver.findElement(panNo).sendKeys(pan1);
		driver.findElement(aadhar).sendKeys(aadhar1);
		driver.findElement(driving).sendKeys(driving1);
		driver.findElement(passport).sendKeys(passport1);
		driver.findElement(voter).sendKeys(voter1);
		dropdown= new Select(driver.findElement(By.id("type")));
		dropdown.selectByVisibleText(form60);
		driver.findElement(amount).sendKeys(amount1);
		if(assessTax.equals("Yes")){
			driver.findElement(yesCheckbox).click();
			driver.findElement(wardAddress).sendKeys(wardAddress1);
		}
		else 
			driver.findElement(noCheckbox).click();
	
		dropdown= new Select(driver.findElement(By.id("custform61")));
		dropdown.selectByVisibleText(form61);
		
	}


	
}
