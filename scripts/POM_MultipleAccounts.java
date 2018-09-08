package scripts;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class POM_MultipleAccounts {

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
	By num_acc = By.cssSelector("#multiple_no");
	By show = By.cssSelector("#hide_multiple");
	By sel_pop1 = By.cssSelector("#select_2_chosen > a > div > b");
	By sel_pop2 = By.cssSelector("#select_3_chosen > a > div > b");
	By search_pop1 = By
			.cssSelector("#select_2_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
	By search_pop2 = By
			.cssSelector("#select_3_chosen > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
	By amt_pop1 = By.cssSelector("#input_2");
	By amt_pop2 = By.cssSelector("#input_3");
	By done = By.cssSelector("#done");

	public POM_MultipleAccounts(WebDriver driver, Actions builder) {
		this.driver = driver;
		this.builder = builder;

	}

	public void transaction(String operation, String Member_id,
			String acc_number, String acc_1, String acc_2, String amt_1,
			String amt_2, String Transaction_type, String Instrument_type,
			String chequeno, String Transaction_code)
			throws InterruptedException {

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

		driver.findElement(instru_select).click();

		Thread.sleep(2000);
		driver.findElement(instru_type_textbox).sendKeys(
				Instrument_type + Keys.ENTER);
		Thread.sleep(2000);
		if (Instrument_type.contains("Cheque")) {
			driver.findElement(cheque_number).sendKeys(chequeno);
		}
		driver.findElement(num_acc).sendKeys("2");
		driver.findElement(show).click();
		driver.findElement(sel_pop1).click();
		driver.findElement(search_pop1).sendKeys(acc_1 + Keys.ENTER);
		driver.findElement(amt_pop1).sendKeys(amt_1);
		driver.findElement(sel_pop2).click();
		driver.findElement(search_pop2).sendKeys(acc_2 + Keys.ENTER);
		driver.findElement(amt_pop2).sendKeys(amt_2);
		driver.findElement(done).click();
		String amount_text = driver.findElement(amt_textbox).getAttribute(
				"value");
		Double a = Double.parseDouble(amount_text);
		Double amountmember1 = Double.parseDouble(amt_1);
		Double amountmember2 = Double.parseDouble(amt_2);
		Double added = (amountmember1 + amountmember2);
		Assert.assertEquals(a, added);
		String amt1 = driver.findElement(acc_bal).getAttribute("value");
		System.out.println(amt1);
		double amountbefore = Double.parseDouble(amt1);

		System.out.println("Before transaction=" + amountbefore);

		switch (operation) {

		case "Debit":
			System.out.println("Debit transaction in progress");
			driver.findElement(transaction_type).click();
			Thread.sleep(2000);
			driver.findElement(transaction_type_textbox).sendKeys(
					Transaction_type + Keys.ENTER);
			Thread.sleep(2000);

			Double debited_amt = added;
			System.out.println("debited amount=" + debited_amt);
			Double expected2 = amountbefore - debited_amt;
			driver.findElement(submit).click();
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
