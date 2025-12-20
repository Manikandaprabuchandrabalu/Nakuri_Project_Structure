package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.interfaceelements.ResumeHeadLineInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class ResumeHeadLinePage extends BaseClass implements ResumeHeadLineInterfaceElements {

	@FindBy(xpath = resumeHeadline_Xpath)
	private WebElement resumeHeadline_btn;

	@FindBy(id = resume_Input)
	private WebElement resume_Inputfeild;

	@FindBy(xpath = savebtn_xpath)
	private WebElement savebtn;

	public ResumeHeadLinePage() {
		PageFactory.initElements(driver, this);
	}

	public void resumeHeadlineValidation() throws Throwable {
		System.out.println("ResumeHeadLinePage-start");
		Explicit_Wait(20, resumeHeadline_btn);
		js_Executor(resumeHeadline_btn, "view");
		mouse_Actions(resumeHeadline_btn, "move element");
		js_Executor(resumeHeadline_btn, "click");
		js_Executor_Value(resume_Inputfeild, PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA", "ID", "resumeheadline"));
		js_Executor(savebtn, "click");
		System.out.println("ResumeHeadLinePage-end");

	}

}
