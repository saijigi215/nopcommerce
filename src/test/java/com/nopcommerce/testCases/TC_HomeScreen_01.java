package com.nopcommerce.testCases;

import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.HomePage;
import com.nopcommerce.pageObjects.CartPage;
import com.nopcommerce.pageObjects.Desktops;


public class TC_HomeScreen_01 extends BaseClass {

	@Test
	public void homePage()

	{

		HomePage hp= new HomePage(driver);
		hp.verifyHomePAgeTitle();
		logger.info("User is on Home page");
		hp.verifyFeaturedProducts();
		logger.info("Home page has 4 featured products");

	}
	@Test
	public void clickOnDesktopsfromComputers()

	{
		driver.get(baseURL);
		HomePage hp= new HomePage(driver);
		hp.hoverToComputersAndClickonDesktops();
		logger.info("User clicked on desktops after hovering on computers icon");
		
	}


	@Test
	public void navigatetoProductsScreen()

	{
		driver.get(baseURL);
		HomePage oHomePage = new HomePage(driver);
		Desktops oDesktops=new Desktops(driver);
		oHomePage.hoverToComputersAndClickonDesktops();
		oDesktops.navigatetoProductPageAndVerifyProductDetails();
		logger.info("User is on products screen");
	}
	
	@Test
	public void addProductToCartAndVerifyAddedMesssage()

	{
		driver.get(baseURL);
		HomePage oHomePage = new HomePage(driver);
		Desktops oDesktops=new Desktops(driver);
		oHomePage.hoverToComputersAndClickonDesktops();
		oDesktops.navigatetoProductPageAndVerifyProductDetails();
		oDesktops.addProductToCartAndAddedSuccessMessageDisplayed();
		logger.info("producis added to cart");
	}
	
	@Test
	public void navigateToShoppingCartPageAndVerifyProductDetailsAndNavigateToCheckoutPage()

	{
		driver.get(baseURL);
		HomePage oHomePage = new HomePage(driver);
		Desktops oDesktops=new Desktops(driver);
		CartPage oCartPage=new CartPage(driver);
		oHomePage.hoverToComputersAndClickonDesktops();
		oDesktops.navigatetoProductPageAndVerifyProductDetails();
		oDesktops.addProductToCartAndAddedSuccessMessageDisplayed();
		oCartPage.navigateShoppingCartPage();
		oCartPage.verifyProductDetailsInShoppingCartPage();
		logger.info("Product details are verified on shopping cart page");
	}
	@Test
	public void navigateOnBillingPageAndEnterAddressDetails()

	{
		driver.get(baseURL);
		HomePage oHomePage = new HomePage(driver);
		Desktops oDesktops=new Desktops(driver);
		CartPage oCartPage=new CartPage(driver);
		oHomePage.hoverToComputersAndClickonDesktops();
		oDesktops.navigatetoProductPageAndVerifyProductDetails();
		oDesktops.addProductToCartAndAddedSuccessMessageDisplayed();
		oCartPage.navigateShoppingCartPage();
		oCartPage.verifyProductDetailsInShoppingCartPage();
		oCartPage.navigateToBillingAddress();
		logger.info("User is on Billing Address page");
		oCartPage.validateMandatoryFields();
		logger.info("User enter valid details in mandatory fields");
	
	}


}




