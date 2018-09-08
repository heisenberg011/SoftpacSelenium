package scripts;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class createFD_POM {

	Select dropdown;
	WebDriver driver;
	Actions builder;
	public Float damount, currBal1;
	public String currBal, s, str, s1, str1;

	By logout = By.className("logout");
	By termDeposit = By.cssSelector(".nav > li:nth-child(4) > a:nth-child(1)");
	By fixedDeposit = By
			.cssSelector(".nav > li:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)");
	By createFixedDeposit = By
			.cssSelector(".nav > li:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)");

	By selectMemberID = By.xpath("//*[@id='member_chosen']/a/span");
	By searchMemberID = By
			.cssSelector("#member_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");

	By selectSourceAcct = By.xpath("//*[@id='accountnumber_chosen']/a/span");
	By searchSourceAcct = By
			.cssSelector("#accountnumber_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");

	By clickviewBal = By.id("view_bal");
	By viewBal = By.id("show_bal");

	By normalCustType = By.id("customertype1");
	By seniorCustType = By.id("customertype2");

	By fdType = By.id("fdtype1");

	By holderName = By.id("holder_name");
	By selectHolName = By.xpath("//*[@id='holder_relation_chosen']/a/span");
	By searchHolRelation = By
			.cssSelector("#holder_relation_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");

	By nomineeName = By.id("nominee");
	By selectNomName = By.xpath("//*[@id='relation_chosen']/a/span");
	By searchNomRelation = By
			.cssSelector("#relation_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");

	By hidden = By.name("hiddisc");
	By disclose = By.name("hiddisc");

	By depositAmt = By.id("amount");
	By tenureYear = By.id("inyear");
	By tenureMonth = By.id("inmonth");
	By tenureDay = By.id("indays");

	By viewInterestRate = By.id("view_rate");

	By selectInterestSlab = By.xpath("//*[@id='tenure_chosen']/a/span");
	By searchInterestSlab = By
			.cssSelector("#tenure_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");

	By interestRate = By.xpath("//*[@id='intrate']");

	By calMaturityAmt = By.cssSelector("#command > div > div > div.tabGroup > div > div.cal_container > div");
	// #command > div > div > div.tabGroup > div > div.cal_container > div

	By applicableInterestRate = By.id("intapprate");

	public createFD_POM(WebDriver driver) {
		this.driver = driver;
		this.builder = builder;

	}

	void logout() {

		driver.findElement(logout).click();

	}

	public void navigateToCreateFD() throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(termDeposit);

		action.moveToElement(we).build().perform();
		we = driver.findElement(fixedDeposit);
		action.moveToElement(we).click().build().perform();
		Thread.sleep(1000);
		we = driver.findElement(createFixedDeposit);

		action.moveToElement(we).click().build().perform();

	}

	public void selectMemberID(String MemberId) throws InterruptedException {
		driver.findElement(selectMemberID).click();
		driver.findElement(searchMemberID).sendKeys(MemberId);
		driver.findElement(searchMemberID).sendKeys(Keys.ENTER);
		Thread.sleep(1000);

	}

	public void selectSourceAcc(String SourceAccount)
			throws InterruptedException {
		driver.findElement(selectSourceAcct).click();
		driver.findElement(searchSourceAcct).sendKeys(SourceAccount);
		driver.findElement(searchSourceAcct).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	public void viewBalance() throws InterruptedException {
		driver.findElement(clickviewBal).click();
		currBal = driver.findElement(viewBal).getAttribute("value");

		Float currBal1 = Float.parseFloat(currBal);
		System.out.println("\nAccount balance is: " + currBal1);
		Thread.sleep(1000);
	}

	public void customerTypeNormal() throws InterruptedException {
		driver.findElement(normalCustType).click();
		Thread.sleep(1000);
	}

	public void customerTypeSenior() throws InterruptedException {
		driver.findElement(seniorCustType).click();
		Thread.sleep(1000);
	}

	public void fixedDepositType(String HolderName, String H_relation)
			throws InterruptedException {
		driver.findElement(fdType).click();

		if (driver.findElement(fdType).isEnabled()) {

			System.out.print("\nAccount is joint type.");
			driver.findElement(holderName).clear();
			driver.findElement(holderName).sendKeys(HolderName);

			driver.findElement(selectHolName).click();
			driver.findElement(searchHolRelation).sendKeys(H_relation);
			driver.findElement(searchHolRelation).sendKeys(Keys.ENTER);
		} else {
			System.out.print("\nAccount is single type.\n");
		}
		Thread.sleep(1000);
	}

	public void selectNomineeName(String NomineeName, String N_relation)
			throws InterruptedException {
		driver.findElement(nomineeName).clear();
		driver.findElement(nomineeName).sendKeys(NomineeName);
		driver.findElement(selectNomName).click();
		driver.findElement(searchNomRelation).sendKeys(N_relation);
		driver.findElement(searchNomRelation).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	public void nVisibility() throws InterruptedException {
		driver.findElement(hidden).click();
		Thread.sleep(1000);
	}

	public void dAmount(String DepositAmt) throws InterruptedException {
		driver.findElement(depositAmt).clear();
		driver.findElement(depositAmt).sendKeys(DepositAmt);

		damount = Float.parseFloat(DepositAmt);
		System.out.println("\nDeposit amount is: " + damount);

		Assert.assertTrue(isDepositValid(damount));
		System.out.print("Deposite amount greater than hundred\n");
		Thread.sleep(1000);
	}

	public void tenure(String Tenure_Y, String Tenure_M, String Tenure_D)
			throws InterruptedException {
		driver.findElement(tenureYear).clear();
		driver.findElement(tenureYear).sendKeys(Tenure_Y);
		driver.findElement(tenureMonth).clear();
		driver.findElement(tenureMonth).sendKeys(Tenure_M);
		driver.findElement(tenureDay).clear();
		driver.findElement(tenureDay).sendKeys(Tenure_D);
		driver.findElement(viewInterestRate).click();
		Thread.sleep(3000);
		/*
		 * Assert.assertTrue(isBalanceSufficient(currBal1));
		 * System.out.print("Sufficient balance to create FD\n");
		 */
		//Thread.sleep(3000);
	}

	public void selectIntSlab(String Interest) throws InterruptedException {

		System.out.println("\nInside Interest Slab\n");
		driver.findElement(viewInterestRate).click();
		Thread.sleep(1000);
		driver.findElement(selectInterestSlab).click();
		Thread.sleep(1000);
		driver.findElement(searchInterestSlab).sendKeys(Interest);
		Thread.sleep(1000);
		driver.findElement(searchInterestSlab).sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		s = driver.findElement(interestRate).getAttribute("value");
		str = s.replaceAll(".0 %", "");
		System.out.println("Interest rate: " + str);
		Thread.sleep(1000);

	}

	public void calMatAmt() throws InterruptedException {

		driver.findElement(calMaturityAmt).click();
		Thread.sleep(1000);
		s1 = driver.findElement(applicableInterestRate).getAttribute("value");
		str1 = s1.replaceAll(" %", "");
		System.out.println("Applicable interest rate: " + str1);

		Thread.sleep(3000);

		assertEquals(str, str1);

		System.out.println("Assert Passed.");
		Thread.sleep(3000);

	}

	/*
	 * public void goToCreateFD(String MemberId, String SourceAccount, String
	 * HolderName, String H_relation, String NomineeName, String N_relation,
	 * String DepositAmt, String Tenure_Y, String Tenure_M, String Tenure_D,
	 * String Interest) throws InterruptedException {
	 */
	/*
	 * System.out.println("Inside test");
	 * 
	 * Actions action = new Actions(driver); WebElement we =
	 * driver.findElement(termDeposit);
	 * 
	 * action.moveToElement(we).build().perform(); we =
	 * driver.findElement(fixedDeposit);
	 * action.moveToElement(we).click().build().perform(); Thread.sleep(1000);
	 * we = driver.findElement(createFixedDeposit);
	 * 
	 * action.moveToElement(we).click().build().perform();
	 *//*
		 * driver.findElement(selectMemberID).click();
		 * driver.findElement(searchMemberID).sendKeys(MemberId);
		 * driver.findElement(searchMemberID).sendKeys(Keys.ENTER);
		 * Thread.sleep(2000);
		 */

	/*
	 * driver.findElement(selectSourceAcct).click();
	 * driver.findElement(searchSourceAcct).sendKeys(SourceAccount);
	 * driver.findElement(searchSourceAcct).sendKeys(Keys.ENTER);
	 */
	/*
	 * driver.findElement(clickviewBal).click(); String currBal =
	 * driver.findElement(viewBal).getAttribute("value");
	 * 
	 * Float currBal1 = Float.parseFloat(currBal); System.out.println(currBal1);
	 */

	// driver.findElement(normalCustType).click();

	/*
	 * driver.findElement(fdType).click();
	 * 
	 * if(driver.findElement(fdType).isEnabled()) {
	 * 
	 * System.out.print("\nText box First name is enabled. Take your action.");
	 * driver.findElement(holderName).sendKeys(HolderName);
	 * 
	 * driver.findElement(selectHolName) .click();
	 * driver.findElement(searchHolRelation) .sendKeys(H_relation);
	 * driver.findElement(searchHolRelation) .sendKeys(Keys.ENTER); } else {
	 * System.out.print("\nAccount is single type."); }
	 */

	/*
	 * driver.findElement( nomineeName).sendKeys(NomineeName);
	 * driver.findElement(selectNomName).click();
	 * driver.findElement(searchNomRelation).sendKeys(N_relation);
	 * driver.findElement(searchNomRelation).sendKeys(Keys.ENTER);
	 */
	/* driver.findElement(hidden).click(); */

	/*
	 * driver.findElement(depositAmt).sendKeys(DepositAmt);
	 * 
	 * damount = Float.parseFloat(DepositAmt); System.out.println(damount);
	 * 
	 * Assert.assertTrue(isBalanceSufficient(currBal1));
	 * System.out.print("Sufficient balance to create FD\n");
	 * 
	 * Assert.assertTrue(isDepositValid(damount));
	 * System.out.print("Deposite amount greater than hundred\n");
	 */
	/*
	 * driver.findElement(tenureYear).sendKeys(Tenure_Y);
	 * driver.findElement(tenureMonth).sendKeys(Tenure_M);
	 * driver.findElement(tenureDay).sendKeys(Tenure_D);
	 * driver.findElement(viewInterestRate).click();
	 */

	/*
	 * driver.findElement(selectInterestSlab).click();
	 * driver.findElement(searchInterestSlab).sendKeys(Interest);
	 * driver.findElement(searchInterestSlab).sendKeys(Keys.ENTER);
	 */

	// driver.findElement(calMaturityAmt).click();

	/*
	 * String s = driver.findElement(interestRate).getAttribute("value"); String
	 * str = s.replaceAll(".0 %", ""); System.out.println("Interest rate: " +
	 * str);
	 */

	/*
	 * String s1 =
	 * driver.findElement(applicableInterestRate).getAttribute("value"); String
	 * str1 = s1.replaceAll(" %", "");
	 * System.out.println("Applicable interest rate: " + str1);
	 */

	/*
	 * int interestrate = Integer.parseInt(str1); int applicableinterestrate =
	 * Integer.parseInt(str);
	 * 
	 * System.out.println("Assert Passed."); }
	 */

	public boolean isBalanceSufficient(Float currBal1) {
		if (currBal1 > damount) {

			return true;
		} else {
			return false;
		}
	}

	public boolean isDepositValid(Float damount) {
		if (damount >= 100f) {

			return true;
		} else {
			return false;
		}

	}
}
