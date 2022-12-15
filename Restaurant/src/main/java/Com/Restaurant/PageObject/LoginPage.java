package Com.Restaurant.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Restaurant.Baseclass.BaseClass;

public class LoginPage extends BaseClass {
	WebDriver driver;

	public LoginPage(WebDriver driver2) {
		driver = driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement Uname;

	public WebElement UserName() {
		return Uname;
	}

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement PWord;

	public WebElement Password() {
		return PWord;
	}

	public boolean IsLogoDisplayed() {
		return true;
	}

	@FindBy(name = "submit")
	WebElement submit;

	public WebElement Submit() {
		return submit;
	}

	@FindBy(linkText = "https://qalegend.com/restaurant/logout")
	WebElement logOut;

	public WebElement Logout() {
		return logOut;
	}

	public boolean IsLogoutDisplayed() {
		return logOut.isDisplayed();
	}

	public void LogoutFun() {
		action.click1(logOut, "Clicking on logout buton");
	}

	public void Login(String username, String password) {
		action.type(UserName(), username);
		action.type(PWord, password);
		action.click1(submit, "Clicking on login buton");
	}

	public void InvalidLogin(String username, String password) {
		action.type(UserName(), username);
		action.type(PWord, password);
		action.click1(submit, "Clicking on login buton");
	}

}
