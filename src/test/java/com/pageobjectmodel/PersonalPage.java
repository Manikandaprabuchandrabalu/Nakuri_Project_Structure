package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.PersonalDetailsInterfaceelements;

public class PersonalPage extends Base_Class implements PersonalDetailsInterfaceelements {
	@FindBy(xpath = prsonalDetailBtn_Xpath)
	private WebElement prsonalDetailBtn;

	@FindBy(id = personalDetailsaveBtn_Id)
	private WebElement personalDetailsaveBtn;

	public PersonalPage() {
		PageFactory.initElements(driver, this);
	}

	public void PersonalPageValidation() throws Throwable {
		System.out.println("PersonalPage -start");
		Thread.sleep(3000);
		elementClick(prsonalDetailBtn);
		elementClick(personalDetailsaveBtn);
		System.out.println("PersonalPage -end");
	}

}
