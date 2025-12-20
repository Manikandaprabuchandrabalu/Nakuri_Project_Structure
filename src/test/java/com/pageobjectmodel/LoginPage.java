package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.Base_Class;
import com.interfaceelements.LoginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import com.utlity.ExcelUtility;

public class LoginPage extends Base_Class implements LoginPageInterfaceElements {

	@FindBy(id = loginbtn_Id)
	private WebElement login_Btn;

	@FindBy(xpath = emailid_Xpath)
	private WebElement email_Field;

	@FindBy(xpath = password_Xpath)
	private WebElement password_Field;

	@FindBy(className = loginButton_classname)
	private WebElement acept_Login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void loginValidation() throws Throwable {
		System.out.println("start");
		Explicit_Wait(20, login_Btn);
		elementClick(login_Btn);
		Explicit_Wait(20, email_Field);
		passInput(email_Field, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("email"));
		passInput(password_Field, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
		Explicit_Wait(20, acept_Login);
		elementClick(acept_Login);
		System.out.println("end");
	}

}
