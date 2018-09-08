package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.Click;


public class LoginPage {
	Select dropdown;
	WebDriver driver;
	Actions builder;
	By username = By.id("user_name");
	By password = By.id("password");
	By loginButton = By.cssSelector("#user_login > div.submit_container > input");
	By lastSession = By.cssSelector("#page > section > article > div > h2");	
	public  LoginPage(WebDriver driver,Actions builder)
	{
		this.driver = driver;
		this.builder = builder;
	//	this.builder= builder;
	}


	public void login() throws InterruptedException{
		driver.findElement(username).sendKeys("beta6");
		driver.findElement(password).sendKeys("beta@123");	
		driver.findElement(loginButton).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(lastSession).getText());
		
	}

}
