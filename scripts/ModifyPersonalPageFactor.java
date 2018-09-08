package scripts;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.Click;


public class ModifyPersonalPageFactor {
	Select dropdown;
	WebDriver driver;
	Actions builder;
	By logout= By.className("logout");
	By type = By.id("member_types_chosen");
	By indMember= By.cssSelector("#member_types_chosen > div > div > input[type='text']");
	By indMember1= By.cssSelector("#account_type_chosen > div > div > input[type='text']");
	By acctype = By.id("account_type");
	By firstNameM= By.id("first_name");
	By middleNameM= By.id("middle_name");
	By lastNameM= By.id("last_ame");
	By gender = By.id("custsex");
	By firstNameh1= By.id("custFirstName1");
	By middleNameh1= By.id("custMiddleName1");
	By lastNameh1= By.id("custLastName1");
	By occupation = By.id("occupation1_chosen");
	//#occupation_chosen
	//*[@id="occupation_chosen"]
	By customerClass = By.id("custclass");
	By caste = By.id("custcaste");
	By nationality = By.id("nationality");
	By father = By.id("father");
	By mother = By.id("mother");
	By landacre = By.id("landacre");
	By DOB = By.id("datepicker");
	By action = By.id("action_chosen");
	
	
	public ModifyPersonalPageFactor(WebDriver driver,Actions builder)
	{
		this.driver = driver;
		this.builder = builder;

	}
	

	void logout(){
		
		
		driver.findElement(logout).click();
		
	}

	public void individualModify(String detail, String type,String accType, String first_Name, String middle_Name, 
			String last_Name, String gender1, String first_Nameh1, 
			String middle_Nameh1, String last_Nameh1,String religion1 ,
			String occupation1, String memberClass, String caste1, String nationality1, 
			String fatherName, String motherName, String landacre1,String DOB1) throws InterruptedException {
		
			
			Thread.sleep(2000);
			System.out.println("Inside individual");
			driver.findElement(By.linkText("116145")).click();
			Thread.sleep(1000);
			driver.findElement(action).click();
			driver.findElement(By.cssSelector("#action_chosen > div > div > input[type='text']")).sendKeys("Modify"+Keys.ENTER);
			Thread.sleep(1000);
			driver.findElement(By.id("member_types_chosen")).click();
			driver.findElement(indMember).sendKeys(type+Keys.ENTER);
			Thread.sleep(1000);
			driver.findElement(By.id("account_type_chosen")).click();
			driver.findElement(indMember1).sendKeys(accType+Keys.ENTER);
			Thread.sleep(1000);
		/*	dropdown= new Select(driver.findElement(By.id("custclass")));
			dropdown.selectByVisibleText(gender1);
			Thread.sleep(1000);*/

			//Thread.sleep(2000);
			System.out.println(first_Name);
			driver.findElement(firstNameM).sendKeys(first_Name);
			driver.findElement(middleNameM).sendKeys(middle_Name);
			driver.findElement(lastNameM).sendKeys(last_Name);
			dropdown= new Select(driver.findElement(By.id("custsex")));
			dropdown.selectByVisibleText(gender1);
			Thread.sleep(1000);
			dropdown= new Select(driver.findElement(By.id("custreligion")));
			dropdown.selectByVisibleText(religion1);
			Thread.sleep(500);
			dropdown= new Select(driver.findElement(By.id("custcaste")));
			dropdown.selectByVisibleText(caste1);
			Thread.sleep(500);
			
			System.out.println(occupation1);
			driver.findElement(occupation).click();
			WebElement list1 = driver.findElement(By.cssSelector("#occupation1_chosen > div > ul"));
			List<WebElement> occupationList = list1.findElements(By.cssSelector("#occupation1_chosen > div > ul> li"));
			Iterator< WebElement> itr = occupationList.iterator();
			while(itr.hasNext()){
				if(itr.next().getText().equals(occupation))
					
				Thread.sleep(500);
			
			}
			/*System.out.println(occupation1);
			driver.findElement(occupation).clear();
			driver.findElement(occupation).click();
		
			driver.findElement(By.cssSelector("#occupation1_chosen > div > div > input[type='text']")).sendKeys(occupation1+ Keys.ENTER);
			Thread.sleep(1000);*/
			driver.findElement(nationality).sendKeys(nationality1);
			driver.findElement(father).sendKeys(fatherName);
			driver.findElement(mother).sendKeys(motherName);
			/*driver.findElement(landacre).clear();
			driver.findElement(landacre).sendKeys(landacre1);*/
			//driver.findElement(DOB).clear();
			driver.findElement(DOB).sendKeys(DOB1);
			Thread.sleep(1000);

			/*driver.findElement(By.id("custclass_chosen")).click();
			driver.findElement(customerClass).sendKeys(memberClass + Keys.ENTER);*/
		
			
		
				
			if( accType.equals("Joint")){
				System.out.println("Inside Joint");
				Thread.sleep(1000);

				driver.findElement(firstNameh1).sendKeys(first_Nameh1);
				driver.findElement(middleNameh1).sendKeys(middle_Nameh1);
				driver.findElement(lastNameh1).sendKeys(last_Nameh1);
				Thread.sleep(500);
			}

			
			switch (type) {
			case "Customer":
				System.out.println("Inside customer");
				
				Thread.sleep(1000);
				break;

			case "Member":
				
				dropdown= new Select(driver.findElement(customerClass));
				dropdown.selectByVisibleText(memberClass);
				break;
			}
	}		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	By firstname= By.id("custFirstName");
	By documentation_Details= By.id("details");
	By docName= By.id("document");
	By issuing_Authority= By.id("authority");
	By place= By.id("issue");
	By regno= By.id("register");
	By date= By.id("datepicker");

			
	public void nonIndiModify( String firstName1,
			String constitution1, String documentation_Details1,String docName1, String issuing_Authority1,
			String place1, String regno1, String date1) throws InterruptedException{
			System.out.println("GAUDYHFGASUKG");
			Thread.sleep(1000);
			
			Thread.sleep(2000);
			System.out.println("Inside individual");
			driver.findElement(By.linkText("116356")).click();
			Thread.sleep(1000);
			driver.findElement(action).click();
			driver.findElement(By.cssSelector("#action_chosen > div > div > input[type='text']")).sendKeys("Modify"+Keys.ENTER);
			Thread.sleep(1000);
			driver.findElement(firstname).clear();
			driver.findElement(firstname).sendKeys(firstName1);
			dropdown= new Select(driver.findElement(By.id("custconstitution")));
			dropdown.selectByVisibleText(constitution1);
			Thread.sleep(500);
		
			driver.findElement(documentation_Details).sendKeys(documentation_Details1);
			driver.findElement(docName).sendKeys(docName1);
			driver.findElement(issuing_Authority).sendKeys(issuing_Authority1);
			driver.findElement(place).sendKeys(place1);
			driver.findElement(date).clear();
			driver.findElement(date).sendKeys(date1);
			driver.findElement(regno).sendKeys(regno1);
			
			
			
	}
	
	
	
	
	
	


}
