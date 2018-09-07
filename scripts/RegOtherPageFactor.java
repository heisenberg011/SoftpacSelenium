package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.Click;


public class RegOtherPageFactor {
	Select dropdown;
	WebDriver driver;
	Actions builder;
	
	By other= By.id("tab_menu_4");
	By income= By.id("income");
	
	public RegOtherPageFactor(WebDriver driver,Actions builder)
	{
		this.driver = driver;
		this.builder = builder;
	//	this.builder= builder;
	}

	public void other(String income1, String education1, String maritalstatus1, String actmanu1) throws InterruptedException
	{
		driver.findElement(other).click();
		driver.findElement(income).sendKeys(income1);
		dropdown= new Select(driver.findElement(By.id("custeducation")));
		dropdown.selectByVisibleText(education1);
		dropdown= new Select(driver.findElement(By.id("custmaritalstatus")));
		dropdown.selectByVisibleText(maritalstatus1);
		dropdown= new Select(driver.findElement(By.id("custactmanu")));
		dropdown.selectByVisibleText(actmanu1);
		
		
	}
	
	
	By nonIndOther= By.id("tab_menu_3");
	public void nonIndiOther(String income1, String education1, String actmanu1) throws InterruptedException
	{
		driver.findElement(nonIndOther).click();
		driver.findElement(income).sendKeys(income1);
		dropdown= new Select(driver.findElement(By.id("custeducation")));
		dropdown.selectByVisibleText(education1);

		dropdown= new Select(driver.findElement(By.id("custactmanu")));
		dropdown.selectByVisibleText(actmanu1);
		
		
	}
	
	
	
	
	
	
	
	


}
