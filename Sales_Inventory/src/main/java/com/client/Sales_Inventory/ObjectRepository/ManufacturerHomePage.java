package com.client.Sales_Inventory.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomePage {
	
	WebDriver driver;
	public ManufacturerHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//section[contains(.,'Welcome')]")
	private WebElement manufactrerWelcomeMsg;
	
	@FindBy(className="submit_button")
	private WebElement logoutBtn;
	
	@FindBy(linkText = "Orders")
	private WebElement ordersLink;
	
	@FindBy(linkText = "Manage Unit")
	private WebElement unit;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(xpath="//table[@class='table_displayData']/tbody/tr/td[3]")
	private List<WebElement> productList;

	public List<WebElement> getProductList() {
		return productList;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getUnit() {
		return unit;
	}

	public WebElement getOrdersLink() {
		return ordersLink;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getManufactrerWelcomeMsg() {
		return manufactrerWelcomeMsg;
	}
	
	public WebElement unitPresent(String unit) {
		return driver.findElement(By.xpath("//table[@class='table_displayData']//child::td[text()=' "+unit+" ']"));
		
	}

}
