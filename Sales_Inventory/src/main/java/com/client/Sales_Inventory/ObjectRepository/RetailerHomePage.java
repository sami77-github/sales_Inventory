package com.client.Sales_Inventory.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.Sales_InventoryGenericUtility.JavaUtility;

public class RetailerHomePage {
	
	public WebDriver driver;
	JavaUtility jLib=new JavaUtility();
	
	public RetailerHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="submit_button")
	private WebElement logOutBtn;
	
	@FindBy(linkText="New Order")
	private WebElement newOrderLink;
	
	@FindBy(linkText="Edit Profile")
	private WebElement editProfileLink;
	
	@FindBy(linkText="Home")
	private WebElement homeLink;
	
	@FindBy (linkText="Products")
	private WebElement productsLink;
	
	@FindBy (linkText = "My Orders")
	private WebElement myOrdersLink;
	
	@FindBy (linkText = "My Invoices")
	private WebElement myInvoicesLink;
	
	@FindBy (xpath="//td//section[contains(.,'Welcome')]")
	private WebElement retailerWelcomeMsg;
	
	@FindBy (xpath="//a[text()='Details']")
	private WebElement details1;
	
	@FindBy(xpath="//table[@class='table_displayData']/tbody/tr/td[2]")
	private List<WebElement> productList1;
	

	public List<WebElement> getProductList1() {
		return productList1;
	}

	public WebElement getDetails1() {
		try {
		return details1;
		}
		catch (Exception e) {
			return driver.findElement(By.xpath("//a[text()='Details']"));
		}
	}

	public WebElement getRetailerWelcomeMsg() {
		return retailerWelcomeMsg;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	public WebElement getNewOrderLink() {
		return newOrderLink;
	}

	public WebElement getEditProfileLink() {
		return editProfileLink;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMyOrdersLink() {
		return myOrdersLink;
	}

	public WebElement getMyInvoicesLink() {
		return myInvoicesLink;
	}
	
	public void logOut() {
		logOutBtn.click();
	}

}
