package scripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class POMVoucher {

	Select dropdown;
	WebDriver driver;
	Actions builder;
	By transaction = By
			.cssSelector("body > div.mm-page > div.submenu > nav > ul > li:nth-child(2) > a");
	By transaction_entry = By
			.cssSelector(".nav > li:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)");
	By reciept = By
			.cssSelector(".nav > li:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)");
	By drop_memberid1 = By
			.cssSelector("#member_chosen > a:nth-child(1) > div:nth-child(2) > b:nth-child(1)");
	By memberid_textbox1 = By
			.cssSelector("#member_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
	By drop_accno1 = By
			.cssSelector("#account_chosen > a:nth-child(1) > div:nth-child(2) > b:nth-child(1)");
	By accno_textbox1 = By
			.cssSelector("#account_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
	By transaction_type = By
			.cssSelector("#transaction_chosen > a:nth-child(1) > div:nth-child(2) > b:nth-child(1)");
	By transaction_type_textbox = By
			.cssSelector("#transaction_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
	By instru_select = By
			.cssSelector("#instrumenttype_chosen > a:nth-child(1) > div:nth-child(2) > b:nth-child(1)");
	By instru_type_textbox = By
			.cssSelector("#instrumenttype_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
	By submit = By.cssSelector("#submit");
	By amt_textbox = By.cssSelector("#amount");
	By acc_bal = By.cssSelector("#balance");
	By cheque_number = By.cssSelector("#chequeno");
	By message = By.cssSelector("#notification");
	By msg2 = By.cssSelector("#page > section > article > a");

	public POMVoucher(WebDriver driver, Actions builder) {
		this.driver = driver;
		this.builder = builder;

	}

	public void transaction(String operation, String Member_id,
			String acc_number, String Transaction_type, String Instrument_type,
			String chequeno, String Transaction_code, String Amount)
			throws InterruptedException, IOException {

		// TODO Auto-generated method stub
		driver.findElement(transaction).click();
		driver.findElement(transaction_entry).click();
		driver.findElement(reciept).click();
		driver.findElement(drop_memberid1).click();
		driver.findElement(memberid_textbox1).sendKeys(Member_id + Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(drop_accno1).click();
		Thread.sleep(2000);
		driver.findElement(accno_textbox1).sendKeys(acc_number + Keys.ENTER);
		Thread.sleep(2000);
		String amt1 = driver.findElement(acc_bal).getAttribute("value");
		System.out.println(amt1);

		double amt11 = Double.parseDouble(amt1);

		System.out.println("Before transaction=" + amt11);
		driver.findElement(instru_select).click();
		Thread.sleep(2000);
		driver.findElement(instru_type_textbox).sendKeys(
				Instrument_type + Keys.ENTER);
		Thread.sleep(2000);
		if (Instrument_type.contains("Cheque")) {
			driver.findElement(cheque_number).sendKeys(chequeno);
		}

		switch (operation) {
		case "credit":
			System.out.println("Credit transaction in progress");
			driver.findElement(transaction_type).click();
			Thread.sleep(2000);
			driver.findElement(transaction_type_textbox).sendKeys(
					Transaction_type + Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(amt_textbox).sendKeys(Amount);
			Thread.sleep(2000);
			String credited_amt = Amount;
			Double credit = Double.parseDouble(credited_amt);
			System.out.println("credited amount=" + credited_amt);
			Double expected1 = amt11 + credit;

			driver.findElement(submit).click();
			driver.findElement(msg2).click();
			//
			String MainWindow = driver.getWindowHandle();

			// To handle all new opened window.
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();

			while (i1.hasNext()) {
				String ChildWindow = i1.next();

				if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

					// Switching to Child window
					driver.switchTo().window(ChildWindow);

					driver.findElement(By.xpath("//*[@id='plugin']")).sendKeys(
							Keys.CONTROL + "s");
					Thread.sleep(1000);
					Runtime.getRuntime().exec("D:\\autoit\\script12.exe");
					// Closing the Child Window.
					Thread.sleep(1000);
					driver.close();
				}
			}
			// Switching to Parent window i.e Main Window.
			driver.switchTo().window(MainWindow);

			//

			System.out.println(driver.findElement(message).getText());
			driver.findElement(drop_memberid1).click();
			driver.findElement(memberid_textbox1).sendKeys(
					Member_id + Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(drop_accno1).click();
			Thread.sleep(2000);
			driver.findElement(accno_textbox1)
					.sendKeys(acc_number + Keys.ENTER);
			Thread.sleep(2000);
			String amt = driver.findElement(acc_bal).getAttribute("value");
			System.out.println("After credit=" + amt);
			Double final1 = Double.parseDouble(amt);
			Assert.assertEquals(final1, expected1);
			Thread.sleep(5000);

			break;

		case "Debit":
			System.out.println("Debit transaction in progress");
			driver.findElement(transaction_type).click();
			Thread.sleep(2000);
			driver.findElement(transaction_type_textbox).sendKeys(
					Transaction_type + Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(amt_textbox).sendKeys(Amount);
			Thread.sleep(2000);
			String debited_amt = Amount;
			Double debit = Double.parseDouble(debited_amt);
			System.out.println("debited amount=" + debited_amt);
			Double expected2 = amt11 - debit;
			driver.findElement(submit).click();
			driver.findElement(msg2).click();
			String MainWindow2 = driver.getWindowHandle();

			// To handle all new opened window.
			Set<String> s2 = driver.getWindowHandles();
			Iterator<String> i2 = s2.iterator();

			while (i2.hasNext()) {
				String ChildWindow = i2.next();

				if (!MainWindow2.equalsIgnoreCase(ChildWindow)) {

					// Switching to Child window
					driver.switchTo().window(ChildWindow);

					driver.findElement(By.xpath("//*[@id='plugin']")).sendKeys(
							Keys.CONTROL + "s");
					Runtime.getRuntime().exec("D:\\autoit\\script12.exe");
					// Closing the Child Window.
					driver.close();
				}
			}
			// Switching to Parent window i.e Main Window.
			driver.switchTo().window(MainWindow2);

			//

			System.out.println(driver.findElement(message).getText());
			Thread.sleep(5000);
			driver.findElement(drop_memberid1).click();
			driver.findElement(memberid_textbox1).sendKeys(
					Member_id + Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(drop_accno1).click();
			Thread.sleep(2000);
			driver.findElement(accno_textbox1)
					.sendKeys(acc_number + Keys.ENTER);
			Thread.sleep(2000);
			String db_amt = driver.findElement(acc_bal).getAttribute("value");
			System.out.println("After debit=" + db_amt);
			Double final2 = Double.parseDouble(db_amt);
			Assert.assertEquals(final2, expected2);
			Thread.sleep(5000);
			break;

		}

	}
}