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

public class POM_CreditDebit {

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
	By message_voucher = By.cssSelector("#page > section > article > a");
	By instru_type_message = By
			.xpath("//*[@id='instrumenttype_chosen']/div/ul/li");

	public POM_CreditDebit(WebDriver driver, Actions builder) {
		this.driver = driver;
		this.builder = builder;

	}

	public void transaction(String operation, String Member_id,
			String acc_number, String Transaction_type, String Instrument_type,
			String chequeno, String Transaction_code, String Amount)
			throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		driver.findElement(transaction).click(); // click on transaction
		driver.findElement(transaction_entry).click(); // click on transaction
														// entry
		driver.findElement(reciept).click(); // click on receipt

		driver.findElement(drop_memberid1).click();
		Assert.assertEquals(Member_id.equals(""), false,
				"Member id field is blank");
		driver.findElement(memberid_textbox1).sendKeys(Member_id + Keys.ENTER);

		Thread.sleep(2000);
		driver.findElement(drop_accno1).click();
		Thread.sleep(2000);
		Assert.assertEquals(accno_textbox1.equals(""), false,
				"Account number field is blank");
		driver.findElement(accno_textbox1).sendKeys(acc_number + Keys.ENTER);

		Thread.sleep(2000);
		String initial_bal = driver.findElement(acc_bal).getAttribute("value");
		System.out.println(initial_bal);

		double f_initial_amount = Double.parseDouble(initial_bal);

		System.out.println("Before transaction=" + f_initial_amount);
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
			Assert.assertEquals(amt_textbox.equals(""), false);
			Thread.sleep(2000);
			String credited_amt = Amount;
			Double credit = Double.parseDouble(credited_amt);
			System.out.println("credited amount=" + credited_amt);
			Double expected1 = f_initial_amount + credit;

			driver.findElement(submit).click();

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
			Double actual = Double.parseDouble(amt);
			Assert.assertEquals(actual, expected1);
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
			Double expected2 = f_initial_amount - debit;
			driver.findElement(submit).click();

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