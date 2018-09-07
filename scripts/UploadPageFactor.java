package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.Click;


public class UploadPageFactor {
	Select dropdown;
	WebDriver driver;
	Actions builder;

	By memberID = By.cssSelector("#M_id_chosen > a");
	By search = By.cssSelector("#M_id_chosen > div > div > input[type='text']");
	By chooseFile = By.id("file_upload");
	By submit = By.cssSelector("#nominee_linkage > div.submit_container > input");
	By membership = By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > a");
	By upload = By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(3) > a");
	By viewDoc = By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(3) > ul > li:nth-child(4) > a");
	By memberID1 = By.cssSelector("#memberid_chosen > a");
	By search1 = By.cssSelector("#memberid_chosen > div > div > input[type='text']");
	By docType = By.cssSelector("#doc_chosen > a > span");
	By docSearch = By.cssSelector("#doc_chosen > div > div > input[type='text']");
	By docSubmit = By.cssSelector("#viewdocuments > div.submit_container > input");
	
	public UploadPageFactor(WebDriver driver,Actions builder)
	{
		this.driver = driver;
		this.builder = builder;
	//	this.builder= builder;
	}

	public void upload() throws InterruptedException
	{


		/*driver.findElement(memberID).click();
		driver.findElement(search).sendKeys("116681"+Keys.ENTER);
		driver.findElement(chooseFile).sendKeys("D:\test.png");
		Thread.sleep(1000);
		driver.findElement(submit).click();
		Thread.sleep(1000);*/
		
	}
	public void viewDocument() throws InterruptedException{
		System.out.println("hasjkfdhajsd");
		driver.findElement(membership).click();
		driver.findElement(upload).click();
		driver.findElement(viewDoc).click();
		Thread.sleep(1000);
		
		driver.findElement(memberID1).click();
		driver.findElement(search1).sendKeys("116681 - Hitansh K"+Keys.ENTER);
		Thread.sleep(1000);
		
		driver.findElement(docType).click();
		driver.findElement(docSearch).sendKeys("Age Proof"+Keys.ENTER);
		Thread.sleep(1000);

		//driver.findElement(docSubmit).click();		
		
	}
}
