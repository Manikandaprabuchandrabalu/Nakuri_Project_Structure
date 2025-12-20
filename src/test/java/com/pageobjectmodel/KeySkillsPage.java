package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.Base_Class;
import com.interfaceelements.KeySkillsInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class KeySkillsPage extends Base_Class implements KeySkillsInterfaceElements {
	@FindBy(xpath = keyskill_xpath)
	private WebElement keyskill_btn;

	@FindBy(id = savebtn_Id)
	private WebElement save_btn;

	@FindBy(id = Backend_backend_Id)
	private WebElement Backend_backend_btn;

	public KeySkillsPage() {
		PageFactory.initElements(driver, this);
	}

	@Test
	public void keyskillsValidation() throws Throwable {
		Thread.sleep(3000);
		System.out.println("keyskill_-start");
		Explicit_Wait(20, keyskill_btn);
		js_Executor(keyskill_btn, "view");
		mouse_Actions(keyskill_btn, "move element");
		js_Executor(keyskill_btn, "click");
		Thread.sleep(3000);
		//		js_Executor( Backend_backend_btn, "click");
		// js_Executor_value( resume_Inputfeild
		// ,PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA",
		// "ID", "resumeheadline"));
		js_Executor(save_btn, "click");
		System.out.println("keyskill -end");

	}

}
