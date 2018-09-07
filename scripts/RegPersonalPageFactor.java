package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.Click;


public class RegPersonalPageFactor {
	Select dropdown;
	WebDriver driver;
	Actions builder;

	
	By membership=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > a");
	By memberReg=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(1) > a");
	By individual=By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(1) > ul > li:nth-child(1) > a"); 
	By nonIndividual= By.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(1) > ul > li:nth-child(1) > ul > li:nth-child(2) > a");
	By type = By.id("member_types_chosen");
	By indMember= By.cssSelector("#member_types_chosen > div > div > input[type='text']");
	By acctype = By.id("account_type");
	By firstName= By.id("custFirstName");
	By middleName= By.id("custMiddleName");
	By lastName= By.id("custLastName");
	By gender = By.id("custSex");
	By firstNameh1= By.id("custFirstName1");
	By middleNameh1= By.id("custMiddleName1");
	By lastNameh1= By.id("custLastName1");
	By occupation = By.cssSelector("#occupation_chosen");
	//#occupation_chosen
	//*[@id="occupation_chosen"]
	By customerClass = By.cssSelector("#custclass_chosen > div > div > input[type='text']");
	By caste = By.id("caste");
	By nationality = By.id("nationality");
	By father = By.id("father");
	By mother = By.id("mother");
	By landacre = By.id("landacre");
	By DOB = By.id("datepicker");
	
	
	public RegPersonalPageFactor(WebDriver driver,Actions builder)
	{
		this.driver = driver;
		this.builder = builder;
	//	this.builder= builder;
	}
	


	public void individualRegister(String detail, String type,String accType, String first_Name, String middle_Name, 
			String last_Name, String gender1, String first_Nameh1, 
			String middle_Nameh1, String last_Nameh1,String religion1 ,
			String occupation1, String memberClass, String caste1, String nationality1, 
			String fatherName, String motherName, String landacre1,String DOB1) throws InterruptedException {
		
		// TODO Auto-generated method stub
/*		driver.findElement(membership).click();
		driver.findElement(memberReg).click();*/
		
		
			
			//driver.findElement(individual).click();
			System.out.println("Inside individual");
			driver.findElement(By.id("member_types_chosen")).click();
			driver.findElement(indMember).sendKeys(type+Keys.ENTER);/*
			driver.findElement(acctype).click();
			Thread.sleep(1000);*/
			Thread.sleep(1000);
			
			dropdown= new Select(driver.findElement(acctype));
			dropdown.selectByVisibleText(accType);
			dropdown= new Select(driver.findElement(acctype));
			dropdown.selectByVisibleText(accType);
			Thread.sleep(2000);
			driver.findElement(firstName).sendKeys(first_Name);
			driver.findElement(middleName).sendKeys(middle_Name);
			driver.findElement(lastName).sendKeys(last_Name);
			
			
			dropdown= new Select(driver.findElement(By.id("custSex")));
			dropdown.selectByVisibleText(gender1);
			Thread.sleep(1000);
			/*Thread.sleep(500);
			driver.findElement(occupation).click();
			driver.findElement(By.cssSelector("#occupation_chosen > div > div > input[type='text']")).sendKeys(occupation1 + Keys.ENTER);*/
			dropdown= new Select(driver.findElement(By.id("religion")));
			dropdown.selectByVisibleText(religion1);
			Thread.sleep(500);
			dropdown= new Select(driver.findElement(By.id("caste")));
			dropdown.selectByVisibleText(caste1);
			Thread.sleep(500);
			
			System.out.println(occupation1);
			driver.findElement(occupation).click();
			driver.findElement(By.cssSelector("#occupation_chosen > div > div > input[type='text']")).sendKeys(occupation1+ Keys.ENTER);
			Thread.sleep(500);
	
	/*		
			driver.findElement(By.id("custclass_chosen")).click();
			driver.findElement(customerClass).sendKeys(memberClass + Keys.ENTER);*/

			Thread.sleep(1000);
			driver.findElement(nationality).sendKeys(nationality1);
			driver.findElement(father).sendKeys(fatherName);
			driver.findElement(mother).sendKeys(motherName);
			driver.findElement(landacre).clear();
			driver.findElement(landacre).sendKeys(landacre1);
			driver.findElement(DOB).sendKeys(DOB1);
			Thread.sleep(1000);

			driver.findElement(By.id("custclass_chosen")).click();
			driver.findElement(customerClass).sendKeys(memberClass + Keys.ENTER);
			
			
		
				
			if( accType.equals("Joint")){
				System.out.println("Inside Joint");
				Thread.sleep(1000);

				driver.findElement(firstNameh1).sendKeys(first_Nameh1);
				driver.findElement(middleNameh1).sendKeys(middle_Nameh1);
				driver.findElement(lastNameh1).sendKeys(last_Nameh1);
				Thread.sleep(500);
			}
			else
				

			
			switch (type) {
			case "Customer":
				System.out.println("Inside customer");
				
				Thread.sleep(1000);
				break;

			case "Member":
				
				driver.findElement(By.id("custclass_chosen")).click();
				driver.findElement(customerClass).sendKeys(memberClass + Keys.ENTER);
				System.out.println("Inside Member");
				break;
			}
	}		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	By firstname= By.id("name");
	By operator1= By.id("operator");
	By operator2= By.id("operator2");
	By documentation_Details= By.id("details");
	By docName= By.id("document");
	By issuing_Authority= By.id("authority");
	By place= By.id("issue");
	By regno= By.id("register");
	By date= By.id("datepicker");

			
	public void nonIndiRegister(String accType, String firstName1, String operator11, String operator21,
			String constitution1, String documentation_Details1,String docName1, String issuing_Authority1,
			String place1, String regno1, String date1,String firstNameh12) throws InterruptedException{
			driver.findElement(membership).click();
			driver.findElement(memberReg).click();
			driver.findElement(nonIndividual).click();
			System.out.println("GAUDYHFGASUKG");
			Thread.sleep(1000);
			
			dropdown= new Select(driver.findElement(acctype));
			dropdown.selectByVisibleText(accType);
			driver.findElement(firstname).sendKeys(firstName1);
			dropdown= new Select(driver.findElement(By.id("custconstitution")));
			dropdown.selectByVisibleText(constitution1);
			Thread.sleep(500);
			if( accType.equals("Joint")){
				System.out.println("Inside Joint");
				Thread.sleep(1000);

				driver.findElement(firstNameh1).sendKeys(firstNameh12);
	
			}
			
			driver.findElement(operator1).sendKeys(operator11);
			driver.findElement(operator2).sendKeys(operator21);
			driver.findElement(documentation_Details).sendKeys(documentation_Details1);
			driver.findElement(docName).sendKeys(docName1);
			driver.findElement(issuing_Authority).sendKeys(issuing_Authority1);
			driver.findElement(place).sendKeys(place1);
			driver.findElement(date).sendKeys(date1);
			driver.findElement(regno).sendKeys(regno1);
			
			
			
	}
	
	
	
	
	
	


}
