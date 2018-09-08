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

public class NonIndividualModify {

	
	WebDriver driver;
	
	ModifyVerifyPageFactor verifyModify;
	ModifyAddressPageFactor addressModify;
	ModifyOtherPageFactor otherModify;
	Actions builder;
	HomePagePOM homePage;
	ModifyPersonalPageFactor personalModify;
	ModifyUploadPageFactor uploadModify1;
	LoginPage login1;
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
		verifyModify=new ModifyVerifyPageFactor(driver,builder);
		addressModify = new ModifyAddressPageFactor(driver, builder);
		otherModify = new ModifyOtherPageFactor(driver, builder);
		personalModify=new ModifyPersonalPageFactor(driver,builder);
		uploadModify1 = new ModifyUploadPageFactor(driver,builder);
		login1 = new LoginPage(driver, builder);
		homePage = new HomePagePOM(driver, builder);
		driver.get("http://205.147.102.59:8080/SoftPac/login");
		
	}
	

	 @DataProvider(name="NonIndiRegister")
	 public Object[][] createData4() throws IOException
	 {
	      Object[][] retObjArr=getExcelData("test\\resources\\data\\Login.xls","NonIndiRegister");
	      System.out.println("*****************  Data Accessed *************************");
	      return(retObjArr);
	  }





	@Test(dataProvider = "NonIndiRegister", priority= 0)
	public void register2(String accType, String firstName, String operator1, String operator2,
			String constitution, String documentation_Details,String docName, String issuing_Authority,
			String place, String regno, String date, String firstNameH1,String addressL1,
			String addressL2, String village,String state,String pincode,String landline,String mobileNo,
			String emailId,String pan ,String income, String education, String nature) throws InterruptedException
		{
			login1.login();
			homePage.nonIndividualModify();
			Thread.sleep(2000);
			personalModify.nonIndiModify(firstName, 
					 constitution,  documentation_Details, docName,  issuing_Authority,
					 place,  regno,  date);
			Thread.sleep(2000);
			addressModify.nonIndiAddress(addressL1, addressL2, state, pincode, landline, mobileNo, emailId,  village,pan);
			Thread.sleep(2000);
			otherModify.nonIndiOther( income,  education,  nature);
			Thread.sleep(1000);
			uploadModify1.uploadModify();
		/*	Thread.sleep(2000);
			otherModify.nonIndiOther( income,  education,  nature);
			driver.findElement(By.id("submit")).click();*/
		}
		
	/*
	@Test(dataProvider = "NonIndiAddress", priority= 1)
	public void address1(String addressL1,String addressL2, String village
			,String state,String pincode,String landline,String mobileNo,
			String emailId,String pan) throws InterruptedException
	{
		//driver.get("http://205.147.102.59:8080/SoftPac/login");
		//Thread.sleep(2000);
		address1.nonIndiAddress(addressL1, addressL2, state, pincode, landline, mobileNo, emailId,  village,pan);
			
	}
	
	@Test(dataProvider = "NonIndiOther", priority= 2)
	public void Other(String income, String education, String nature) throws InterruptedException
	{
		//driver.get("http://205.147.102.59:8080/SoftPac/login");
		//Thread.sleep(2000);
		other1.nonIndiOther( income,  education,  nature);
		
			
	}*/
	
	
		
	
	@AfterClass
    public void tearDown() throws InterruptedException
	{
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
