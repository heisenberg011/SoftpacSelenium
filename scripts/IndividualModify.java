package scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IndividualModify {

	
	WebDriver driver;
	ModifyPersonalPageFactor personalModify;
	ModifyVerifyPageFactor verify1;
	ModifyAddressPageFactor address1;
	ModifyOtherPageFactor other1;
	Actions builder;
	
	HomePagePOM homePage;
	ModifyUploadPageFactor uploadModify1;
	@BeforeTest
	public void setup() throws InterruptedException
	{
		File pathToBinary = new File("C:\\Users\\AM101_PC20\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		driver = new FirefoxDriver(ffBinary,firefoxProfile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
		personalModify=new ModifyPersonalPageFactor(driver,builder);
		homePage = new HomePagePOM(driver, builder);
		verify1=new ModifyVerifyPageFactor(driver,builder);
		address1 = new ModifyAddressPageFactor(driver, builder);
		other1 = new ModifyOtherPageFactor(driver, builder);
		//upload1 = new UploadPageFactor(driver, builder);
		uploadModify1 = new ModifyUploadPageFactor(driver,builder);
		driver.get("http://205.147.102.59:8080/SoftPac/login");
		driver.findElement(By.id("user_name")).sendKeys("beta6");
		driver.findElement(By.id("password")).sendKeys("beta@123");	
		Thread.sleep(1000);	
		driver.findElement(By.cssSelector("#user_login > div.submit_container > input")).click();

	}
	

	 @DataProvider(name="IndiRegister")
	 public Object[][] createData12() throws IOException
	 {
	      Object[][] retObjArr=getExcelData("test\\resources\\data\\Modify.xls","IndiRegister");
	      System.out.println("*****************  Data Accessed *************************");
	      return(retObjArr);
	  }
	 
/*	 @DataProvider(name="NonIndiRegister")
	 public Object[][] createData4() throws IOException
	 {
	      Object[][] retObjArr=getExcelData("test\\resources\\data\\Login.xls","NonIndiRegister");
	      System.out.println("*****************  Data Accessed *************************");
	      return(retObjArr);
	  }
	 
	 @DataProvider(name="Verify")
	 public Object[][] createData1() throws IOException
	 {
	      Object[][] retObjArr=getExcelData("test\\resources\\data\\Login.xls","IndiVerify");
	      System.out.println("*****************  Data Accessed *************************");
	      return(retObjArr);
	  }
	 
	 @DataProvider(name="Address")
	 public Object[][] createData2() throws IOException
	 {
	      Object[][] retObjArr=getExcelData("test\\resources\\data\\Login.xls","IndiAddress");
	      System.out.println("*****************  Data Accessed *************************");
	      return(retObjArr);
	  }
	 
	 @DataProvider(name="Other")
	 public Object[][] createData3() throws IOException
	 {
	      Object[][] retObjArr=getExcelData("test\\resources\\data\\Login.xls","IndiOther");
	      System.out.println("*****************  Data Accessed *************************");
	      return(retObjArr);
	  }
	 */

	@Test(dataProvider = "IndiRegister", priority= 0)
	public void modify1(String detail, String type, String accType, String firstName,
			String middleName, String lastName,String gender1, String first_Nameh1, 
			String middle_Nameh1, String last_Nameh1, String religion1 , String occupation1, 
			String memberClass, String caste1, String nationality1, String fatherName, 
			String motherName, String landacre,String DOB1,String pan, String aadhar, 
			String driving, String passport, String voter,String form60, String form61,
			String amount,String assessTax,String wardAddress,String addressL1,
			String addressL2, String village,String state,String pincode,String landline
			,String mobileNo,String emailId,String income, String education, String maritalstatus,
			 String nature) throws InterruptedException
		{
			homePage.individualModify();
			personalModify.individualModify(detail, type, accType, firstName, middleName, lastName, gender1, first_Nameh1, middle_Nameh1, last_Nameh1, religion1, occupation1, memberClass, caste1, nationality1, fatherName, motherName, landacre, DOB1);
			Thread.sleep(1000);
			
			System.out.println("kfoajsflkjas");
			
			verify1.verify(pan,aadhar, driving, passport,voter, form60,  form61, assessTax, wardAddress);
			Thread.sleep(2000);
			address1.address( addressL1, addressL2, state, pincode, landline, mobileNo, emailId,  village);
			Thread.sleep(2000);
			other1.other( income,  education, maritalstatus,  nature);
			Thread.sleep(1000);
			uploadModify1.uploadModifyIndividual();
			Thread.sleep(2000);
		}
	
		
		
	
	/*
	@Test(dataProvider = "Verify", priority= 1)
	public void verify(String pan, String aadhar, String driving, String passport, String voter,String form60, String form61, String amount,String assessTax,String wardAddress) throws InterruptedException
	{
		//driver.get("http://205.147.102.59:8080/SoftPac/login");
		verify1.verify(pan,aadhar, driving, passport,voter, form60,  form61,  amount, assessTax, wardAddress);
		//Thread.sleep(2000);
			
	}
	
	@Test(dataProvider = "Address", priority= 2)
	public void address1(String addressL1,String addressL2, String village
			,String state,String pincode,String landline,String mobileNo,
			String emailId) throws InterruptedException
	{
		//driver.get("http://205.147.102.59:8080/SoftPac/login");
		Thread.sleep(2000);
		address1.address( addressL1, addressL2, state, pincode, landline, mobileNo, emailId,  village);
			
	}
	
	@Test(dataProvider = "Other", priority= 3)
	public void Other(String income, String education, String maritalstatus, String nature) throws InterruptedException
	{
		//driver.get("http://205.147.102.59:8080/SoftPac/login");
		Thread.sleep(2000);
		other1.other( income,  education,  maritalstatus,  nature);
		
			
	}*/
	
	
		
	
	@AfterClass
    public void tearDown() throws InterruptedException
	{
		//driver.findElement(By.id("submit")).click();
		//upload1.upload();
		Thread.sleep(2000);
		//driver.quit();
		java.util.Date date= new java.util.Date();
		System.out.println("\n\nExecution Log - End Time - " + new Timestamp(date.getTime()));
    } 
	
	@SuppressWarnings("deprecation")
	public static String[][] getExcelData(String fileName, String sheetName)
			throws IOException {
		String[][] arrayExcelData = null;
		Workbook wb = null;
		try {
			File file = new File(fileName);
			FileInputStream fs = new FileInputStream(file);
			// .xls
			if (fileName.substring(fileName.indexOf(".")).equals(".xlsx")) {

				// If it is xlsx file then create object of XSSFWorkbook class

				wb = new XSSFWorkbook(fs);
			} else if (fileName.substring(fileName.indexOf(".")).equals(".xls")) {
				// If it is xls file then create object of HSSFWorkbook class
				wb = new HSSFWorkbook(fs);
			}
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfRows = sh.getPhysicalNumberOfRows();
			int totalNoOfCols = sh.getRow(0).getPhysicalNumberOfCells();

			System.out.println("totalNoOfRows=" + totalNoOfRows + ","
					+ " totalNoOfCols=" + totalNoOfCols);
			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];
			for (int i = 1; i <= totalNoOfRows - 1; i++) {
				for (int j = 0; j <= totalNoOfCols - 1; j++) {
					sh.getRow(i).getCell(j).setCellType(1);
					arrayExcelData[i - 1][j] = sh.getRow(i).getCell(j)
							.getStringCellValue().toString();
				}
			}
		} catch (Exception e) {
			System.out.println("error in getExcelData()");
		}
		return arrayExcelData;
	}
}
