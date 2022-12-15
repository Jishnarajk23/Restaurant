package Com.Restaurant.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.Restaurant.Baseclass.BaseClass;

public class ProductPage extends BaseClass{
	WebDriver driver;
	public ProductPage(WebDriver driver2)
	{
		driver=driver2;
		 PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//span[@class='menu-text'][normalize-space()='Product'])[1]")
	
	WebElement Product;
	public WebElement Product()
	{
		return Product;		
	}
	
	@FindBy(xpath="(//div[@id='Addproduct'])")
	WebElement AddProduct;
	public WebElement AddProduct()
	{
		return AddProduct;		
	}
	
	
	@FindBy(xpath="//label[normalize-space()='Product type']")
	WebElement ProductType;
	public WebElement ProductType()
	{
		return ProductType;		
	}
	
	public boolean IsDisplayedProductType() {
		return ProductType.isDisplayed();
	}
	public void clickOnProductPage()
	{
		action.click1(Product, "Clicking on product buton");
	}
	
	@FindBy(xpath="//select[@name='Table_length']")
	WebElement ShowCombo;
	public WebElement ShowCombo()
	{
		return ShowCombo;		
	}
	public void SelectEachElements()
	{
		Select selectNew= new Select(ShowCombo);
	    selectNew.selectByIndex(1);
	    selectNew.selectByIndex(2);
	    selectNew.selectByIndex(3);
	}
	public String IsDisplayedShowElement() 
	{
		Select selectNew= new Select(ShowCombo);
		return selectNew.getFirstSelectedOption().getText();
	}

    }
