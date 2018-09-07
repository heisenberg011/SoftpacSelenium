	 
package transaction_multiple_accounts;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class mul_acc_transaction {
	WebDriver driver;
	 POM_MultipleAccounts object;
	 Actions builder;
	 @BeforeTest
	 public void setup() throws InterruptedException
	 {
		 System.setProperty("webdriver.chrome.driver",
					"test\\resources\\driver\\chromedriver.exe");
			
			driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  builder = new Actions(driver);
	  object=new POM_MultipleAccounts(driver,builder);
	  driver.get("http://205.147.102.59:8080/SoftPac/login");
	  
	  driver.findElement(By.id("user_name")).sendKeys("beta6");
	  
	 
	  driver.findElement(By.id("password")).sendKeys("beta@123");
	  
	  Thread.sleep(1000);
	  
	  driver.findElement(By.cssSelector("#user_login > div.submit_container > input")).click();
	  Thread.sleep(5000);
	 }
	@DataProvider(name="Sheet1")
	  public Object[][] createData12() throws IOException
	  {
	       Object[][] retObjArr=getExcelData("test\\resources\\data\\transaction_multiple_acc.xlsx","Sheet1");
	       System.out.println("*****************  Data Accessed *************************");
	       return(retObjArr);
	   }
	 @Test(dataProvider = "Sheet1")
	 public void register1(String operation,String Member_id,String acc_number,String acc_1,String acc_2,String amt_1,String amt_2,String Transaction_type,String Instrument_type,String chequeno,String Transaction_code) throws InterruptedException
	 {
		object.transaction(operation,Member_id,acc_number,acc_1,acc_2,amt_1,amt_2,Transaction_type,Instrument_type,chequeno,Transaction_code);
	 }
	  
	 
	 @AfterClass
	    public void tearDown() throws InterruptedException
	 {
	  Thread.sleep(2000);
	  
	  java.util.Date date= new java.util.Date();
	  System.out.println("\n\nExecution Log - End Time - " + new Timestamp(date.getTime()));
	  driver.close(); 
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

