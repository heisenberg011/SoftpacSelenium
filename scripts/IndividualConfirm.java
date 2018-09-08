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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IndividualConfirm {

	
	WebDriver driver;
	ModifyPersonalPageFactor personalModify;
	ModifyVerifyPageFactor verify1;
	ModifyAddressPageFactor address1;
	ModifyOtherPageFactor other1;
	Actions builder;
	LoginPage login1;
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
		login1 = new LoginPage(driver, builder);
		//upload1 = new UploadPageFactor(driver, builder);
		uploadModify1 = new ModifyUploadPageFactor(driver,builder);
		driver.get("http://205.147.102.59:8080/SoftPac/login");


	}
	

/*	 @DataProvider(name="IndiRegister")
	 public Object[][] createData12() throws IOException
	 {
	      Object[][] retObjArr=getExcelData("test\\resources\\data\\Modify.xls","IndiRegister");
	      System.out.println("*****************  Data Accessed *************************");
	      return(retObjArr);
	  }
	 */

	@Test(dataProvider = "IndiRegister")
	public void modify1() throws InterruptedException
		{	login1.login();
			homePage.individualConfirm();
			driver.findElement(By.id("action_chosen")).click();
			driver.findElement(By.cssSelector("#action_chosen > div > div > input[type='text']")).sendKeys("Confirm"+Keys.ENTER);
			Thread.sleep(1000);

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
