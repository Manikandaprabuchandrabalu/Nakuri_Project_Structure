package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceelements.CareerProfileinterfaceElements;

public class CareerProfilePage extends BaseClass implements CareerProfileinterfaceElements {
	@FindBy(xpath = career_Xpath)
	private WebElement careerXpath_btn;

	@FindBy(id = careerSave_Id)
	private WebElement careersave_btn;

	public CareerProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public void CareerProfilePageValidation() throws Throwable {
		System.out.println("CareerProfilePage -start");
//		Thread.sleep(3000);
//		js_Executor(careerXpath_btn, "view");
//		js_Executor(careerXpath_btn, "click");
//		js_Executor(careersave_btn, "click");
		System.out.println("CareerProfilePage -end");
	}

}
