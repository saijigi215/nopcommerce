package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.nopcommerce.utilities.ReadConfig;

public class CartPage {
	WebDriver ldriver;
	ReadConfig readconfig= new ReadConfig();
	
	public  CartPage(WebDriver rdriver )
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this );
	}

	@FindBy(xpath="//span[contains(text(),'Shopping cart')]")
	WebElement shoppingCart;

	@FindBy(xpath="//span[@class='close']")
	WebElement btnClose;

	@FindBy(xpath="//h1[normalize-space()='Shopping cart']")
	WebElement txtShoppingcart;

	@FindBy(xpath="//input[@id='termsofservice']")
	WebElement checkboxTermsOfUse;

	@FindBy(xpath="//button[@id='checkout']")
	WebElement btnCheckOut;
	
	@FindBy(xpath="//button[normalize-space()='Checkout as Guest']")
	WebElement btnCheckoutAsGuest;

	@FindBy(xpath="//h2[normalize-space()='Billing address']")
	WebElement txtBillingAddrress;

	@FindBy(xpath="//button[@onclick='Billing.save()']")
	WebElement btnContinue;

	@FindBy(xpath="//span[normalize-space()='First name is required.']")
	WebElement txterrorFirstname;

	@FindBy(xpath="//input[@id='BillingNewAddress_FirstName']")
	WebElement fieldFirstname;

	@FindBy(xpath="//input[@id='BillingNewAddress_LastName']")
	WebElement fieldLastname;

	@FindBy(xpath="//input[@id='BillingNewAddress_Email']")
	WebElement fieldmail;

	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	WebElement fieldcity;

	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
	WebElement fieldAddress;

	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement fieldZipcode;

	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
	WebElement fieldPhoneNumber;

	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	WebElement fieldCountry;

	@FindBy(xpath="//*[@class='product']/a")
	WebElement txtAddedProductName;

	@FindBy(xpath="//*[text()='SKU:']/following-sibling::*[@class='sku-number']")
	WebElement txtAddedProductSKU;

	@FindBy(xpath="//button[@onclick='Billing.save()']")
	WebElement btnContinueInCheckoutPage;
	
	Desktops oDesktops=new Desktops(ldriver);

	public void navigateShoppingCartPage()
	{
		btnClose.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		shoppingCart.click();

	}
	
	public void verifyProductDetailsInShoppingCartPage()
	{
		Assert.assertTrue(txtShoppingcart.isDisplayed(), "Shopping cart txt is not displayed");
		Assert.assertTrue(checkboxTermsOfUse.isDisplayed(), "Checkbox is not displayed");

		{
			String strProductName = txtAddedProductName.getText();
			Assert.assertEquals(strProductName, oDesktops.strProductName, "Added Product Name is NOT matching with Product"
					+ "Nam");

			String strProductSKU = txtAddedProductSKU.getText();
			Assert.assertEquals(strProductSKU, oDesktops.strSKU, "Added Product Name is NOT matching with Product"
					+ "Nam");
		}

		checkboxTermsOfUse.click();
		btnCheckOut.click();
		btnCheckoutAsGuest.click();
	}

	public void navigateToBillingAddress() {
		Assert.assertTrue(txtBillingAddrress.isDisplayed(), " BillingAddrress is not displayed");


	}
	public void validateMandatoryFields() {
		btnContinue.click();
		Assert.assertTrue(txterrorFirstname.isDisplayed(), " Error message is  displayed");
		String firstname=readconfig.getfirstname();
		fieldFirstname.sendKeys(firstname);
		String lastname=readconfig.getlastname();
		fieldLastname.sendKeys(lastname);
		String mail=readconfig.getmail();
		fieldmail.sendKeys(mail);
		String city=readconfig.getcity();
		fieldcity.sendKeys(city);
		String address=readconfig.getaddress();
		fieldAddress.sendKeys(address);
		String zipcode=readconfig.getzipcode();
		fieldZipcode.sendKeys(zipcode);
		String phoneNumber=readconfig.getphoneNumber();
		fieldPhoneNumber.sendKeys(phoneNumber);
		Select dropdown= new Select(fieldCountry);
		dropdown.selectByVisibleText("India");
		btnContinueInCheckoutPage.click();
	}


}
