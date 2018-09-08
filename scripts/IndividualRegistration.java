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

public class IndividualRegistration {

	
	WebDriver driver;
	RegPersonalPageFactor personal1;
	RegVerifyPageFactor verify1;
	RegAddressPageFactor address1;
	RegOtherPageFactor other1;
	Actions builder;
	UploadPageFactor upload1;
	HomePagePOM homePage;
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
		personal1=new RegPersonalPageFactor(driver,builder);
		homePage = new HomePagePOM(driver, builder);
		verify1=new RegVerifyPageFactor(driver,builder);
		address1 = new RegAddressPageFactor(driver, builder);
		other1 = new RegOtherPageFactor(driver, builder);
		upload1 = new UploadPageFactor(driver, builder);
		login1 = new LoginPage(driver, builder);
		driver.get("http://205.147.102.59:8080/SoftPac/login");
		
	}
	

	 @DataProvider(name="IndiRegister")
	 public Object[][] createData12() throws IOException
	 {
	      Object[][] retObjArr=getExcelData("test\\resources\\data\\Login.xls","IndiRegister");
	      System.out.println("*****************  Data Accessed *************************");
	      return(retObjArr);
	  }
	 


	@Test(dataProvider = "IndiRegister", priority= 0)
	public void register1(String detail, String type, String accType, String firstName,
			String middleName, String lastName,String gender1, String first_Nameh1, 
			String middle_Nameh1, String last_Nameh1, String religion1 , String occupation1, 
			String memberClass, String caste1, String nationality1, String fatherName, 
			String motherName, String landacre,String DOB1,String pan, String aadhar, 
			String driving, String passport, String voter,String form60, String form61,
			String amount,String assessTax,String wardAddress,String addressL1,
			String addressL2, String village,String state,String pincode,String landline
			,String mobileNo,String emailId,String income, String education, 
			String maritalstatus, String nature) throws InterruptedException
		{
			login1.login();
			homePage.individualRegister();
			Thread.sleep(2000);
			
			personal1.individualRegister(detail,type,accType, firstName, middleName, lastName,
					gender1,first_Nameh1,middle_Nameh1,last_Nameh1, religion1, occupation1,
					memberClass,caste1, nationality1, fatherName, motherName, landacre,DOB1);
			Thread.sleep(2000);
	
			verify1.verify(pan,aadhar, driving, passport,voter, form60,  form61,  amount, assessTax, wardAddress);
			Thread.sleep(2000);
			address1.address( addressL1, addressL2, state, pincode, landline, mobileNo, emailId,  village);
			Thread.sleep(2000);
			other1.other( income,  education,  maritalstatus,  nature);
		}

	
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
