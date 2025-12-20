package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.Base_Class;
import com.interfaceelements.EmployeementInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class EmployeementPage extends Base_Class implements EmployeementInterfaceElements {

	@FindBy(xpath = employement_Xpath)
	private WebElement employement_btn;

	public EmployeementPage() {
		PageFactory.initElements(driver, this);
	}

	public void employeementPageValidation() throws Throwable {
		System.out.println("EmployeementPage -start");
		js_Executor(employement_btn, "view");
		Explicit_Wait(20, employement_btn);
		mouse_Actions(employement_btn, "move element");
		js_Executor(employement_btn, "click");
		System.out.println("EmployeementPage -end");

	}

}
