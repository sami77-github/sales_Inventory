package com.client.SalesInventory.ManageCategory;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.client.Sales_Inventory.BaseUtility.AdminBaseClass;
import com.client.Sales_Inventory.ObjectRepository.AddCategory;
import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;
import com.client.Sales_InventoryGenericUtility.ExcelUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

public class AddCategoryTest extends AdminBaseClass{
	ExcelUtility ex=new ExcelUtility();
	WebDriverUtility wb=new WebDriverUtility();
	@Test(groups="smoke")
     public void addCategory() throws EncryptedDocumentException, IOException {
	String category1 = ex.getDataFromExcel("manageCt", 1, 0);
	String details1 = ex.getDataFromExcel("manageCt", 1, 1);	
			   AdminHomePage ahp=new AdminHomePage(driver);
			   ahp.getManageCategory().click();   
			   AddCategory adc=new AddCategory(driver);
			   Actions ac=new Actions(driver);
			   ac.scrollToElement(adc.getAddCategorybtn()).scrollByAmount(0, 100).build().perform();	
				adc.getAddCategorybtn().click();	
				adc.getCName().sendKeys(category1);
				adc.getCategoryDetails().sendKeys(details1);		
				adc.getAddNewC().click();
				wb.handleAlert(driver);		
			}
			@Test(groups="smoke")
			public void logoutCategoryPage() throws EncryptedDocumentException, IOException {
				String category2 = ex.getDataFromExcel("manageCt", 3, 0);
				String details2 = ex.getDataFromExcel("manageCt", 3, 1);	
			   AdminHomePage ahp=new AdminHomePage(driver);
			   ahp.getManageCategory().click();   
			   AddCategory adc=new AddCategory(driver);
			   Actions ac=new Actions(driver);
			   ac.scrollToElement(adc.getAddCategorybtn()).scrollByAmount(0, 100).build().perform();	
				adc.getAddCategorybtn().click();	
				adc.getCName().sendKeys(category2);
				adc.getCategoryDetails().sendKeys(details2);		
				adc.getAddNewC().click();
				wb.handleAlert(driver);		
				adc.getLogout().click();
			}
			
			@Test(groups="smoke")
			public void addCategoryWithoutDetails() throws EncryptedDocumentException, IOException {
				String category3 = ex.getDataFromExcel("manageCt", 2, 0);
				
			   AdminHomePage ahp=new AdminHomePage(driver);
			   ahp.getManageCategory().click();   
			   AddCategory adc=new AddCategory(driver);
			   Actions ac=new Actions(driver);
			   ac.scrollToElement(adc.getAddCategorybtn()).scrollByAmount(0, 100).build().perform();	
				adc.getAddCategorybtn().click();	
				adc.getCName().sendKeys(category3);
				adc.getAddNewC().click();
				wb.handleAlert(driver);		
			}
			
			@Test(groups = "smoke")
			public void deleteCategory() {
				AdminHomePage ahp=new AdminHomePage(driver);
				   ahp.getManageCategory().click();   
				   AddCategory adc=new AddCategory(driver);
				   Actions ac=new Actions(driver);
				   ac.scrollToElement(adc.getAddCategorybtn()).scrollByAmount(0, 50).build().perform();
				   WebElement name = adc.clickCheckBox("Colddrink");
				   name.click();
				   adc.getDelete().click();
				   wb.handleAlert(driver);		   	
			}
			
			@Test(dependsOnMethods = "addCategory")
			public void deleteCategory1() {
				AdminHomePage ahp=new AdminHomePage(driver);
				   ahp.getManageCategory().click();   
				   AddCategory adc=new AddCategory(driver);
				   Actions ac=new Actions(driver);
				   ac.scrollToElement(adc.getAddCategorybtn()).scrollByAmount(0, 50).build().perform();
				   WebElement name = adc.clickCheckBox("Formal Shoes");
				   name.click();
				   adc.getDelete().click();
				   wb.handleAlert(driver);		  	
			}	
			
			@Test(groups="smoke")
			public void editcategory() throws EncryptedDocumentException, IOException {
				String details6 = ex.getDataFromExcel("manageCt", 8, 0);
				AdminHomePage ahp=new AdminHomePage(driver);
				   ahp.getManageCategory().click();   
				   AddCategory adc=new AddCategory(driver);
				   Actions ac=new Actions(driver);
				   ac.scrollToElement(adc.getAddCategorybtn()).scrollByAmount(0, 50).build().perform();
				   adc.editInfo("Protein & Supplement").click();
				    adc.getCategoryDetails().clear();
				    adc.getCategoryDetails().sendKeys(details6);
		     	   adc.getUpdateC().click();	
		     	   wb.handleAlert(driver);
			}
			
			@Test(groups="integration")
			public void verifyCategory() throws EncryptedDocumentException, IOException {
				String category8 = ex.getDataFromExcel("manageCt",11, 0);
				String details8 = ex.getDataFromExcel("manageCt",11, 1);
				AdminHomePage ahp=new AdminHomePage(driver);
				ahp.getManageCategory().click();
				AddCategory ac=new AddCategory(driver);
				Actions acc=new Actions(driver);
				acc.scrollToElement(ac.getAddCategorybtn()).scrollByAmount(0, 100).build().perform();
				ac.getAddCategorybtn().click();
				ac.getCName().sendKeys(category8);
				ac.getCategoryDetails().sendKeys(details8);
				ac.getAddNewC().click();
				wb.handleAlert(driver);
				ahp.getManageCategory().click();
				boolean flag=false;
				List<WebElement> ListOfCateg =ac.getCategoryList();
				for(WebElement newList:ListOfCateg) {
					String newList1 = newList.getText();
					if(newList1.contains(category8)) {
						flag=true;
						break;
						}
				}
				assertEquals(flag, true);
				System.out.println("Category has been added successfully");		
			}	
			
			@Test(groups="system")
			public void addAndDeleteCategory() throws EncryptedDocumentException, IOException {
				String category7 = ex.getDataFromExcel("manageCt", 4, 0);
				String details7 = ex.getDataFromExcel("manageCt", 4, 1);
				String details77 = ex.getDataFromExcel("manageCt", 5, 1);
				AdminHomePage ahp=new AdminHomePage(driver);
				ahp.getManageCategory().click();
				AddCategory adc=new AddCategory(driver);
				Actions ac=new Actions(driver);
				ac.scrollToElement(adc.getAddCategorybtn()).scrollByAmount(0, 50).build().perform();
				adc.getAddCategorybtn().click();
				adc.getCName().sendKeys(category7);
				adc.getCategoryDetails().sendKeys(details7);
				adc.getAddNewC().click();
				wb.handleAlert(driver);
				ahp.getManageCategory().click();
				Actions ac1=new Actions(driver);
				ac1.scrollToElement(adc.getAddCategorybtn()).scrollByAmount(0, 50).build().perform();
				adc.editInfo("Handbag").click();
				adc.getCategoryDetails().clear();
				adc.getCategoryDetails().sendKeys(details77);
				adc.getUpdateC().click();
				wb.handleAlert(driver);
			}		
		}

		
		
		
		
	

