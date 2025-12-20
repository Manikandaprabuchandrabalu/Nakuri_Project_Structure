package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.EducationInterfaceElements;
import com.interfaceelements.ProfileUpdateInterfaceElemets;

public class EducationPage extends Base_Class implements EducationInterfaceElements {

	@FindBy(xpath = ui_Xpath)
	private WebElement ui_Btn;

	@FindBy(id = saveBtn_Id)
	private WebElement saveBtn;

	public EducationPage() {
		PageFactory.initElements(driver, this);
	}

	public void EducationPageValidation() throws Throwable {
		System.out.println("EducationPage -start");
		Explicit_Wait(20, ui_Btn);
		elementClick(ui_Btn);
		elementClick(saveBtn);
		System.out.println("EducationPage -end");
	}

}
