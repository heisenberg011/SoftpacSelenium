package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.Click;


public class ModifyUploadPageFactor {
	Select dropdown;
	WebDriver driver;
	Actions builder;
	By uploadNonIndividual = By.id("tab_menu_4");
	By uploadIndividual =  By.id("tab_menu_5");
	By memberID = By.id("M_id_chosen");
	By search = By.cssSelector("#M_id_chosen > div > div > input[type='text']");
	By chooseFileSignature = By.name("file");
	By chooseFilePhoto = By.xpath("//*[@id='tab_content_4']/div[2]/div/input");
	By chooseFileSignatureIndividual = By.name("file");
	By chooseFilePhotoIndividual = By.xpath("//*[@id='tab_content_5']/div[2]/div/input");
	By submit = By.id("submit");
	By document = By.id("doc_chosen");
	By searchDoc = By.cssSelector("#doc_chosen > div > div > input[type='text']");
	By chooseButton = By.id("file_upload");
	By uploadButton = By.cssSelector("#nominee_linkage > div.submit_container > input");
	public ModifyUploadPageFactor(WebDriver driver,Actions builder)
	{
		this.driver = driver;
		this.builder = builder;
	//	this.builder= builder;
	}

	public void uploadModify() throws InterruptedException
	{

		driver.findElement(uploadNonIndividual).click();
		driver.findElement(chooseFileSignature).sendKeys("C:\\test.png");
		Thread.sleep(1000);
	
		
		driver.findElement(chooseFilePhoto).sendKeys("C:\\test.png");

		driver.findElement(submit).click();

		
	}
	public void uploadModifyIndividual() throws InterruptedException
	{

		driver.findElement(uploadIndividual).click();
		driver.findElement(chooseFileSignatureIndividual).sendKeys("C:\\test.png");
		Thread.sleep(1000);
	
		
		driver.findElement(chooseFilePhotoIndividual).sendKeys("C:\\test.png");

		driver.findElement(submit).click();

		
	}
	public void files(){
		
		driver.findElement(memberID).click();
		driver.findElement(search).sendKeys("116681"+ Keys.ENTER);
		driver.findElement(document).click();
		driver.findElement(searchDoc).sendKeys("Age Proof");
		driver.findElement(uploadButton).sendKeys("C:\\test.png");
		driver.findElement(uploadButton).click();
/*		driver.findElement(memberID).click();
		driver.findElement(search).sendKeys("116681"+ Keys.ENTER);
		driver.findElement(document).click();
		driver.findElement(searchDoc).sendKeys("Age Proof");
		driver.findElement(uploadButton).sendKeys("C:\\test.png");
		driver.findElement(uploadButton).click();
		driver.findElement(memberID).click();
		driver.findElement(search).sendKeys("116681"+ Keys.ENTER);
		driver.findElement(document).click();
		driver.findElement(searchDoc).sendKeys("Age Proof");
		driver.findElement(uploadButton).sendKeys("C:\\test.png");
		driver.findElement(uploadButton).click();*/
		
		
	}
	
}
