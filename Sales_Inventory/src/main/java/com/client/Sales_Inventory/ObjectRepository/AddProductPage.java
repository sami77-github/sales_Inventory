package com.client.Sales_Inventory.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

public class AddProductPage {
	WebDriverUtility wb=new WebDriverUtility();
	WebDriver driver;
	public AddProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="product:name")
	private WebElement productName;
	
	@FindBy(id="product:price")
	private WebElement price;
	
	@FindBy(id="product:unit")
	private WebElement unitType;
	
	@FindBy(id="product:category")
	private WebElement Pcategory;
		
	@FindBy(xpath="//input[@value='1']")
	private WebElement enable;
	
	@FindBy(xpath="//input[@value='2']")
	private WebElement disable;
	
	@FindBy(id="product:description")
	private WebElement description;
	
	@FindBy(xpath="//input[@value='Add Product']")
	private WebElement add;
	
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement logout;
	
	@FindBy(xpath="//section/h1")
	private WebElement PageName;
	
	
	@FindBy(linkText = "Products")
	private WebElement productColoumn;
	
	@FindBy(xpath="//table[@class='table_displayData']/tbody/tr/td[3]")
	private List<WebElement> productList;
	
	@FindBy(xpath="//select[@id='product:unit']/option")
	private List<WebElement> unitList;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteproduct;
	
	
	@FindBy(xpath="//input[@value='Update Product']")
	private WebElement updateprod;
	
	
	
	public WebElement getUpdateprod() {
		return updateprod;
	}
	public WebElement getDeleteproduct() {
		return deleteproduct;
	}
	public List<WebElement> getProductList() {
		return productList;
	}
	public WebElement getProductColoumn() {
		return productColoumn;
	}
	public WebElement getPageName() {
		return PageName;
	}
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getProductName() {
		return productName;
	}
	public WebElement getPrice() {
		return price;
	}
	public WebElement getDescription() {
		return description;
	}
	public WebElement getUnitType() {
		return unitType;
	}
	public WebElement getPcategory() {
		return Pcategory;
	}

	public WebElement getAdd() {
		return add;
	}

	public WebElement getEnable() {
		return enable;
	}

	public WebElement getDisable() {
		return disable;
	}
	
	
	public void selectEnable() {
		enable.click();
	}
				
	public void selectDisable() {
		disable.click();
	}
	
	public void selectUnit(String unit) {
		wb.select(unitType, unit);
	}
	
	public void selectCategory(String category) {
		wb.select(Pcategory, category);
	}
	
	public void clickAddproduct() {
		getAdd().click();
	}
	
	
	
	public List<WebElement> getUnitList() {
		return unitList;
	}
	
	public WebElement anyProduct(String prodName) {
		
		return driver.findElement(By.xpath("//table[@class='table_displayData']//td[text()=' "+prodName+" ']/preceding-sibling::td/input"));	
	}
	
	public WebElement editProduct(String prodName) {
		return driver.findElement(By.xpath("//table[@class='table_displayData']//td[text()=' "+prodName+" ']/following-sibling::td/a"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
