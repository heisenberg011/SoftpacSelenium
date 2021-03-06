package scripts;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Cell;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createFD {
	public Float damount;

	WebDriver driver;

	@BeforeTest
	public void SetUp() {

		File pathToBinary = new File("C:\\Users\\AM101_PC20\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		driver = new FirefoxDriver(ffBinary,firefoxProfile);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String BaseUrl = "http://205.147.102.59:8080/SoftPac/login/";
		driver.get(BaseUrl);
		driver.findElement(By.id("user_name")).sendKeys("beta6");
		driver.findElement(By.id("password")).sendKeys("beta@123");
		driver.findElement(By.className("submit")).click();

	}

	@DataProvider(name = "DP1")
	public Object[][] createData1() throws IOException {
		Object[][] retObjArr = getExcelData(
				"test\\resources\\data\\CreateFD.xls", "Sheet1");
		System.out.println("*****************  2 *************************");
		return (retObjArr);
	}

	@Test(dataProvider = "DP1")
	public void Test1(String MemberId, String SourceAccount, String CustType,
			String AccountType, String HolderName, String H_relation,
			String NomineeName, String N_relation, String DepositAmt,
			String Tenure_Y, String Tenure_M, String Tenure_D, String Interest)
			throws InterruptedException {

		createFD_POM cr = new createFD_POM(driver);

		cr.navigateToCreateFD();
		cr.selectMemberID(MemberId);
		cr.selectSourceAcc(SourceAccount);
		cr.viewBalance();

		switch (CustType) {
		case "Normal":
			System.out.println("Inside Normal case");
			cr.customerTypeNormal();
			cr.fixedDepositType(HolderName, H_relation);
			cr.selectNomineeName(NomineeName, N_relation);
			cr.selectIntSlab(Interest);
			cr.dAmount(DepositAmt);

			cr.tenure(Tenure_Y, Tenure_M, Tenure_D);
			cr.calMatAmt();
			System.out
					.println("***********************************************************");
			break;

		case "Senior":
			System.out.println("Inside Senior case");
			cr.selectMemberID(MemberId);
			cr.selectSourceAcc(SourceAccount);
			cr.customerTypeSenior();
			cr.selectNomineeName(NomineeName, N_relation);
			cr.selectIntSlab(Interest);
			cr.dAmount(DepositAmt);
			cr.tenure(Tenure_Y, Tenure_M, Tenure_D);
			//cr.customerTypeSenior();
			cr.calMatAmt();
			System.out
					.println("***********************************************************");
			break;

		default:
			System.out.println("Select proper customer type\n");
		}

		// driver.findElement(By.id("submit")).click();
	}

	@AfterTest
	public void tearDown() {
		// driver.quit();

		java.util.Date date = new java.util.Date();
		System.out.println("\n\nExecution Log - End Time - "
				+ new Timestamp(date.getTime()));
	}

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
