package com.client.Sales_Inventory.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategory {

	WebDriver driver;
	public AddCategory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='+ Add Category']")
	private WebElement addCategorybtn;
	
	@FindBy(id="categoryName")
	private WebElement CName;
	
	@FindBy(id="categoryDetails")
	private WebElement CategoryDetails;
	
	@FindBy(xpath="//input[@value='Add Category']")
	private WebElement addNewC;
	
	@FindBy(xpath="//table[@class=\"table_displayData\"]//td[3]")
	private List<WebElement> table;
	
	@FindBy(xpath="//table[@class='table_displayData']//td[3]/preceding-sibling::td/descendant::input")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement delete;
	
	
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement logout;
	
	@FindBy(xpath = "//input[@value='Update Category']")
	private WebElement updateC;
	
	@FindBy(xpath="//table[@class='table_displayData']/tbody/tr/td[3]")
	private List<WebElement> categoryList;
	
	
	public List<WebElement> getCategoryList() {
		return categoryList;
	}

	public WebElement getUpdateC() {
		return updateC;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getDelete() {
		return delete;
	}

	public List<WebElement> getTable() {
		return table;
	}
	public WebElement getCheckbox(){
		return checkbox;
	}

	public WebElement getAddCategorybtn() {
		return addCategorybtn;
	}

	public WebElement getCName() {
		return CName;
	}

	public WebElement getCategoryDetails() {
		return CategoryDetails;
	}

	public WebElement getAddNewC() {
		return addNewC;
	}

	public WebElement clickCheckBox(String name) {
		return driver.findElement(By.xpath("//table[@class='table_displayData']//td[text()=' "+name+" ']/preceding-sibling::td/descendant::input"));
	}
	public WebElement editInfo(String edit) {
		 return driver.findElement(By.xpath("//table[@class='table_displayData']//td[text()=' "+edit+" ']/following-sibling::td/a"));
	}	
}

	
	


