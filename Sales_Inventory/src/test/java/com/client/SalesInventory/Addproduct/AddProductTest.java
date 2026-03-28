 package com.client.SalesInventory.Addproduct;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.client.Sales_Inventory.BaseUtility.AdminBaseClass;
import com.client.Sales_Inventory.BaseUtility.UtilityClassObject;
import com.client.Sales_Inventory.ObjectRepository.AddProductPage;
import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;
import com.client.Sales_Inventory.ObjectRepository.LoginPage;
import com.client.Sales_Inventory.ObjectRepository.ManufacturerHomePage;
import com.client.Sales_Inventory.ObjectRepository.RetailerHomePage;
import com.client.Sales_InventoryGenericUtility.ExcelUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

@Listeners(com.client.Sales_Inventory.ListenerUtility.ListenerImpClass.class)
public class AddProductTest extends AdminBaseClass{
	ExcelUtility ex=new ExcelUtility();
	WebDriverUtility wb=new WebDriverUtility();
	@Test(groups="smoke")
	
	public void productPageDisplay(){
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		AddProductPage app=new AddProductPage(driver);
		String Text = app.getPageName().getText();
		assertEquals(Text, "Add Product");
		System.out.println("We have reached on AddProductPage");
		
	}
	@Test(groups="smoke")
	public void addProductTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String product1 = ex.getDataFromExcel("productInfo", 1, 0);
		String price1 = ex.getDataFromExcel("productInfo", 1, 1);
		String desc1 = ex.getDataFromExcel("productInfo", 1, 2);
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product1);
		app.getPrice().sendKeys(price1);
		app.selectUnit("PCS");
		app.selectCategory("Add On Items");
		app.getDescription().sendKeys(desc1);
		app.selectEnable();
		app.getDescription().sendKeys(desc1);
		app.clickAddproduct();
		wb.handleAlert(driver);	
	}
	
	@Test(groups="smoke")
	public void addproductWithoutdesc() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String product2 = ex.getDataFromExcel("productInfo", 2, 0);
		String price2 = ex.getDataFromExcel("productInfo", 2, 1);
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product2);
		app.getPrice().sendKeys(price2);
		app.selectUnit("PCS");
		app.selectCategory("Add On Items");
		app.selectEnable();
		app.clickAddproduct();
		wb.handleAlert(driver);		
		
	}
	
	@Test(groups="integration")
	public void logoutFromProductPage() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		
		String product3 = ex.getDataFromExcel("productInfo", 3, 0);
		String price3 = ex.getDataFromExcel("productInfo", 3, 1);
		String desc3 = ex.getDataFromExcel("productInfo", 3, 2);
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product3);
		app.getPrice().sendKeys(price3);
		app.selectUnit("No");
		app.selectCategory("Add On Items");
		
		app.selectEnable();
		app.getDescription().sendKeys(desc3);
		app.clickAddproduct();
		wb.handleAlert(driver);	
		app.getLogout();			
		
	}
	@Test(groups="integration")
	public void checkAddedProduct() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from excel");
		String product4 = ex.getDataFromExcel("productInfo", 4, 0);
		String price4 = ex.getDataFromExcel("productInfo", 4, 1);
		String desc4 = ex.getDataFromExcel("productInfo", 4, 2);
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product4);
		app.getPrice().sendKeys(price4);
		app.selectUnit("No");
		app.selectCategory("Add On Items");
		
		app.selectEnable();
		app.getDescription().sendKeys(desc4);
		app.clickAddproduct();
		wb.handleAlert(driver);	
		
		app.getProductColoumn().click();
		boolean flag=false;
		List<WebElement> Data = app.getProductList();
		for(WebElement PList:Data) {
			String PrdtList = PList.getText();	
			if(PrdtList.contains(product4)) {
				flag=true;
				break;
			}					
		}
		assertEquals(flag, true);
		System.out.println("Product added successfully"+product4);	
	}
	@Test(groups="smoke")
	public void addProductwithoutEnteringPrice() throws EncryptedDocumentException, IOException {
		String product5 = ex.getDataFromExcel("productInfo", 5, 0);
		String desc5 = ex.getDataFromExcel("productInfo", 5, 2);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product5);
		app.selectUnit("No");
		app.selectCategory("Add On Items");
		app.getDescription().sendKeys(desc5);
		app.clickAddproduct();
		WebElement errorMsg = driver.findElement(By.xpath("//input[@value='Add Product']/following-sibling::span[@class='error_message']"));
		Assert.assertTrue(errorMsg.isDisplayed());
		System.out.println("Product not added without price option — Test Passed");
	}
	@Test(groups="smoke")
	public void addProductwithoutSelectingUnit() throws EncryptedDocumentException, IOException {
		String product5 = ex.getDataFromExcel("productInfo", 5, 0);
		String price5 = ex.getDataFromExcel("productInfo", 5, 1);
		String desc5 = ex.getDataFromExcel("productInfo", 5, 2);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product5);
		app.getPrice().sendKeys(price5);
		app.selectUnit("No");
		app.selectCategory("Add On Items");
		app.getDescription().sendKeys(desc5);
		app.clickAddproduct();
		WebElement errorMsg = driver.findElement(By.xpath("//input[@value='Add Product']/following-sibling::span[@class='error_message']"));
		Assert.assertTrue(errorMsg.isDisplayed());
		System.out.println("Product not added without selecting unit option — Test Passed");
	}	
	@Test(groups="smoke")
	public void addProductwithoutSelectingStock() throws EncryptedDocumentException, IOException {
		String product5 = ex.getDataFromExcel("productInfo", 5, 0);
		String price5 = ex.getDataFromExcel("productInfo", 5, 1);
		String desc5 = ex.getDataFromExcel("productInfo", 5, 2);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product5);
		app.getPrice().sendKeys(price5);
		app.selectUnit("No");
		app.selectCategory("Add On Items");
		app.getDescription().sendKeys(desc5);
		app.clickAddproduct();
		WebElement errorMsg = driver.findElement(By.xpath("//input[@value='Add Product']/following-sibling::span[@class='error_message']"));
		Assert.assertTrue(errorMsg.isDisplayed());
		System.out.println("Product not added without stock management option — Test Passed");
	}
	

	@Test(groups="integration")
	public void checkDeleteProduct() throws EncryptedDocumentException, IOException {
			UtilityClassObject.getTest().log(Status.INFO, "Read the data from excel");
			String product5 = ex.getDataFromExcel("productInfo", 5, 0);
			String price5 = ex.getDataFromExcel("productInfo", 5, 1);
			String desc5 = ex.getDataFromExcel("productInfo", 5, 2);
			AdminHomePage ahp=new AdminHomePage(driver);
			ahp.getAddProduct().click();
			AddProductPage app=new AddProductPage(driver);
			app.getProductName().sendKeys(product5);
			app.getPrice().sendKeys(price5);
			app.selectUnit("No");
			app.selectCategory("Add On Items");
			app.selectEnable();
			app.getDescription().sendKeys(desc5);
			app.clickAddproduct();
			wb.handleAlert(driver);	
			ahp.getProductList().click();
			Actions ac=new Actions(driver);
			ac.scrollToElement(app.getDeleteproduct()).scrollByAmount(0, 50).build().perform();
			app.anyProduct(product5).click();
			app.getDeleteproduct().click();
			wb.handleAlert(driver);
			app.getProductColoumn().click();
			boolean flag=false;
			List<WebElement> Data = app.getProductList();
			for(WebElement PList:Data) {
				String PrdtList = PList.getText();	
				if(PrdtList.contains(product5)) {
					flag=true;
					break;
				}					
			}
			assertEquals(flag, true);
			System.out.println("Product deleted successfully "+product5);			
		}
	
	@Test(groups="integration")
	public void verifyEditProduct() throws EncryptedDocumentException, IOException, InterruptedException {
		String product5 = ex.getDataFromExcel("productInfo",12, 0);
		String desc5 = ex.getDataFromExcel("productInfo",12, 1);
		String price5 = ex.getDataFromExcel("productInfo",12, 2);
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product5);
		app.getPrice().sendKeys(price5);
		app.selectUnit("No");
		app.selectCategory("Add On Items");
		app.selectEnable();
		app.getDescription().sendKeys(desc5);
		app.clickAddproduct();
		wb.handleAlert(driver);	
		ahp.getProductList().click();
		Actions ac=new Actions(driver);
		ac.scrollToElement(app.getDeleteproduct()).scrollByAmount(0, 150).build().perform();
		app.editProduct(product5).click();
		app.selectUnit("PCS");
		app.selectEnable();
		app.getUpdateprod().click();
		wb.handleAlert(driver);
		System.out.println("Product updated successfully");
		
	}
	@Test(groups="system")
	public void displayProductInRetailerLogin() throws EncryptedDocumentException, IOException {
		String product1 = ex.getDataFromExcel("productInfo", 11, 0);
		String price1 = ex.getDataFromExcel("productInfo", 11, 2);
		String desc1 = ex.getDataFromExcel("productInfo", 11, 1);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product1);
		app.getPrice().sendKeys(price1);
		app.selectUnit("PCS");
		app.selectCategory("Add On Items");
		app.getDescription().sendKeys(desc1);
		app.selectEnable();
		app.getDescription().sendKeys(desc1);
		app.clickAddproduct();
		wb.handleAlert(driver);	
		app.getLogout().click();
		LoginPage lp=new LoginPage(driver);
		lp.loginAsRetailerSamshop();
		RetailerHomePage rhp=new RetailerHomePage(driver);
		rhp.getProductsLink().click();
		
		boolean flag=false;
		List<WebElement> Data = rhp.getProductList1();
		for(WebElement PList:Data) {
			String PrdtList = PList.getText();	
			if(PrdtList.contains(product1)) {
				flag=true;
				break;
			}					
		}
		assertEquals(flag, true);
		System.out.println("Product added successfully ");		
		rhp.logOut();
	}
			
	
	@Test(groups="system")
	public void displayProductInManufacturerLogin() throws EncryptedDocumentException, IOException {
		String product1 = ex.getDataFromExcel("productInfo", 10, 0);
		String price1 = ex.getDataFromExcel("productInfo", 10, 2);
		String desc1 = ex.getDataFromExcel("productInfo", 10, 1);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddProduct().click();
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(product1);
		app.getPrice().sendKeys(price1);
		app.selectUnit("PCS");
		app.selectCategory("Add On Items");
		app.getDescription().sendKeys(desc1);
		app.selectEnable();
		app.getDescription().sendKeys(desc1);
		app.clickAddproduct();
		wb.handleAlert(driver);	
		app.getLogout().click();
		LoginPage lp=new LoginPage(driver);
		lp.loginAsManufacturerKhadi();
		ManufacturerHomePage mhp=new ManufacturerHomePage(driver);
		mhp.getProductLink().click();
		
		boolean flag=false;
		List<WebElement> Data = mhp.getProductList();
		for(WebElement PList:Data) {
			String PrdtList = PList.getText();	
			if(PrdtList.contains(product1)) {
				flag=true;
				break;
			}					
		}
		assertEquals(flag, true);
		System.out.println("Product added successfully ");		
		mhp.getLogoutBtn().click();
	}
			
	
}
