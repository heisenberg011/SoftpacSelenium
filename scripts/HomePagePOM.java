package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.Click;


public class HomePagePOM {
	Select dropdown;
	WebDriver driver;
	Actions builder;

	By logout= By.className("logout");
	By membership=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > a");
	By memberReg=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(1) > a");
	By individual=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(1) > ul > li:nth-child(1) > a"); 
	By nonIndividual= By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(1) > ul > li:nth-child(2) > a");
	By termDeposit = By.xpath("/html/body/div[1]/div[1]/nav/ul/li[4]/a");
	By fixedDeposit = By.xpath("/html/body/div[1]/div[1]/nav/ul/li[4]/ul/li[1]/a");
	By createDeposit = By.xpath("/html/body/div[1]/div[1]/nav/ul/li[4]/ul/li[1]/ul/li[1]/a");
	By transaction=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(2) > a");
	By transaction_entry=By.cssSelector(".nav > li:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)");
	By reciept=By.cssSelector(".nav > li:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)");
	
	By memberModify=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(2) > a");
	By individualModify=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(2) > ul > li:nth-child(1) > a"); 
	By nonIndividualModify= By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(2) > ul > li:nth-child(2) > a");
	By upload=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(3) > a");
	By documents=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(3) > ul > li:nth-child(1) > a");
	By photo = By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(3) > ul > li:nth-child(2) > a");
	By signature = By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(3) > ul > li:nth-child(3) > a");
	By viewDocuments = By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(3) > ul > li:nth-child(4) > a");
	
	
	public HomePagePOM(WebDriver driver,Actions builder)
	{
		this.driver = driver;
		this.builder = builder;
	//	this.builder= builder;
	}
	

	void logout(){
		
		
		driver.findElement(logout).click();
		
	}

	public void individualRegister() throws InterruptedException {
		
		// TODO Auto-generated method stub
		driver.findElement(membership).click();
		driver.findElement(memberReg).click();
		driver.findElement(individual).click();
			
	}		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	


			
	public void nonIndiRegister() throws InterruptedException{
			driver.findElement(membership).click();
			driver.findElement(memberReg).click();
			driver.findElement(nonIndividual).click();
			
			
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			
	}
	public void transaction() throws InterruptedException{
		driver.findElement(transaction).click();
		driver.findElement(transaction_entry).click();
		driver.findElement(reciept).click();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void fixedDeposit() throws InterruptedException{
		driver.findElement(termDeposit).click();
		driver.findElement(fixedDeposit).click();
		driver.findElement(createDeposit).click();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void individualModify() throws InterruptedException {
		
		// TODO Auto-generated method stub
		driver.findElement(membership).click();
		driver.findElement(memberModify).click();
		driver.findElement(individualModify).click();
			
	}	
	public void nonIndividualModify() throws InterruptedException {
		
		// TODO Auto-generated method stub
		driver.findElement(membership).click();
		driver.findElement(memberModify).click();
		driver.findElement(nonIndividualModify).click();
			
	}	
	
	//////////////////////////////////////////////-------------------------------------------/////////////////////////////////////////////
	public void individualConfirm() throws InterruptedException {
		
		// TODO Auto-generated method stub
		driver.findElement(membership).click();
		driver.findElement(memberModify).click();
		driver.findElement(individualModify).click();
			
	}	
	public void nonIndividualConfirm() throws InterruptedException {
		
		// TODO Auto-generated method stub
		driver.findElement(membership).click();
		driver.findElement(memberModify).click();
		driver.findElement(nonIndividualModify).click();
			
	}	
	
	
	//-----------//////////////////////////////////////////////----------------------------------------------///////////////////////
	public void uploadDocuments() throws InterruptedException {
		
		// TODO Auto-generated method stub
		driver.findElement(membership).click();
		driver.findElement(upload).click();
		driver.findElement(documents).click();
			
	}	
	public void uploadPhoto() throws InterruptedException {
		
		// TODO Auto-generated method stub
		driver.findElement(membership).click();
		driver.findElement(upload).click();
		driver.findElement(photo).click();
			
	}	
	public void uploadSignature() throws InterruptedException {
		
		// TODO Auto-generated method stub
		driver.findElement(membership).click();
		driver.findElement(upload).click();
		driver.findElement(signature).click();
			
	}	
	public void viewDocuments(){
		
		driver.findElement(membership).click();
		driver.findElement(upload).click();
		driver.findElement(viewDocuments).click();
		
		
	}
	
	
}
