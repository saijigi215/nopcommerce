package com.nopcommerce.pageObjects;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nopcommerce.testCases.BaseClass;

public class HomePage  {

	WebDriver ldriver;

	public  HomePage(WebDriver rdriver )
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this );
	}

	@FindBy(xpath="//*[@alt='nopCommerce demo store']")
	WebElement titlePage;

	@FindBy(xpath="//[text()='Featured products']/parent::*/following-sibling::*[@class='item-grid']/*[@class='item-box']")
	WebElement featureProducts;


	@FindBy(xpath="//*[@class='top-menu notmobile']/li/a[contains(text(),'Computers')]")

	WebElement txtComputers;

	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")
	WebElement txtDesktops;

	public void verifyHomePAgeTitle()
	{
		Assert.assertTrue(titlePage.isDisplayed(), "Title page is not displayed");
	}
	
	public void verifyFeaturedProducts()

	{
		List<WebElement> oList=
		ldriver.findElements(By.xpath("//*[text()='Featured products']/parent::*/following-sibling::*[@class='item-grid']/*[@class='item-box']"));
		int size=oList.size();
		Assert.assertEquals(size, 4);
		System.out.println(size);
	}

	public void hoverToComputersAndClickonDesktops()
	{
		Actions action = new Actions(ldriver);
		action.moveToElement(txtComputers).build().perform();
		action.moveToElement(txtDesktops).build().perform();

		txtDesktops.click();


	}




}

