package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.LogoutInterfaceElements;

public class LogoutPage extends Base_Class implements LogoutInterfaceElements{

	@FindBy(css = profilePic_css)
	private WebElement profilePic_Btn;

	@FindBy(linkText = logOut_Link)
	private WebElement logOut;

	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}

	public void LogoutPageValidation() throws Throwable {
		System.out.println("start");
		Explicit_Wait(20, profilePic_Btn);
		elementClick(profilePic_Btn);
		Explicit_Wait(20, logOut);
		elementClick(logOut);
		System.out.println("end");
	}

}
