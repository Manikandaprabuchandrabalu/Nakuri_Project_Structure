package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceelements.ProfielSummaryInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class ProfielSummaryPage extends BaseClass implements ProfielSummaryInterfaceElements {

	@FindBy(xpath = profileSummaryBtn_Xpth)
	private WebElement profileSummaryBtn;

	@FindBy(id = profileSummaryInput_Id)
	private WebElement profileSummaryInput;

	@FindBy(xpath = ProfileSummarySaveBtn_Xpath)
	private WebElement ProfileSummarySaveBtn;

	public  ProfielSummaryPage() {
		PageFactory.initElements(driver, this);
	}

	public void profileSummaryValidation() throws Throwable {
		System.out.println("ProfielSummaryPage -start");
		Explicit_Wait(20, profileSummaryBtn);
		js_Executor("down", 1000);
		js_Executor(profileSummaryBtn, "click");
		js_Executor(profileSummaryInput, "click");
		js_Executor_Value(profileSummaryInput, PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA", "ID", "Profile summary"));
		js_Executor(ProfileSummarySaveBtn, "click");
		System.out.println(" ProfielSummaryPage -end");
	}

}
