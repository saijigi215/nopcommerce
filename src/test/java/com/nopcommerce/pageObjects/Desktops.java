package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;

public class Desktops {
	WebDriver ldriver;

	public  Desktops(WebDriver rdriver )
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this );
	}

	public static String strProductName ="";
	public static String strSKU="";

	@FindBy(xpath="//div[@class='page-title']/h1")
	WebElement txtDesktopTitle;

	@FindBy(xpath="//h2[@class='product-title']//a[contains(text(),'Lenovo IdeaCentre 600 All-in-One PC')]")
	WebElement txtLenovoItem;

	@FindBy(xpath="//*[@id='add-to-cart-button-3' and @data-productid='3']")
	WebElement btnAddToCart;

	@FindBy(xpath="//p[@class='content' and contains(text(),\"The product has been added to your\")]")
	WebElement weAddToCartMessage;

	@FindBy(xpath="//*[@class='product-name']/h1")
	WebElement txtProductName;

	@FindBy(xpath="//*[text()='SKU:']/following-sibling::*[@class='value']")
	WebElement txtProductSKU;

	public void navigatetoProductPageAndVerifyProductDetails()
	{
		Assert.assertTrue(txtDesktopTitle.isDisplayed(), "Desktop Title page is not  displayed");
		Assert.assertTrue(txtLenovoItem.isDisplayed(), "Lenovo    is not  displayed");
		txtLenovoItem.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(txtProductName.getText(), "Lenovo IdeaCentre 600 All-in-One PC", "Failed to land on Lenovo Product Deatils Page.");
		//Product details page values for validation with cart page details
		strProductName = txtProductName.getText() ;
		strSKU= txtProductSKU.getText();			
	}

	public void addProductToCartAndAddedSuccessMessageDisplayed()
	{
		btnAddToCart.click();
		Assert.assertTrue(weAddToCartMessage.isDisplayed(), "add To Cart Message is not  displayed");

	}


}
