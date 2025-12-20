package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceelements.EducationInterfaceElements;
import com.interfaceelements.ProfileUpdateInterfaceElemets;

public class EducationPage extends BaseClass implements EducationInterfaceElements{
	@FindBy(css = profilePic_css)
	private WebElement profile_pic;

	@FindBy(linkText = updateView_LinkText)
	private WebElement updateView_Btn;

	@FindBy(xpath = profilePen_Xpath)
	private WebElement updatePen_Btn;

	@FindBy(xpath = workstatus_Xpath)
	private WebElement experiancedBtn;

	@FindBy(id = experianceYears_Id)
	private WebElement experianceYear;

	@FindBy(id = currentSalary_Id)
	private WebElement currentSalary_Feild;

	@FindBy(id = salaryBreakdown_Id)
	private WebElement salaryBreakdown_btn;


	@FindBy(id = saveBtn_Id)
	private WebElement save_Btn;

	public EducationPage() {
		PageFactory.initElements(driver, this);
	}

	public void EducationPageValidation() throws Throwable {
		System.out.println("profile -start");
		Explicit_Wait(20, profile_pic);
		elementClick(profile_pic);
		
		Explicit_Wait(20, updateView_Btn);
		elementClick(updateView_Btn);
//		Explicit_Wait(20, updatePen_Btn);
//		elementClick(updatePen_Btn);
		
//		Explicit_Wait(20, experiancedBtn);
//		js_Executor(experiancedBtn, "click");
//		Explicit_Wait(20, experianceYear);
//		js_Executor(experianceYear, "click");
//		Explicit_Wait(20, experianceYear);
//		js_Executor_Value(experianceYear, PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA", "ID", "Experience Years"));
//		robot_Enter();
//		Thread.sleep(3000);
//		elementClick(currentSalary_Feild);
//		Thread.sleep(3000);
		
//		js_Executor_Value(currentSalary_Feild, PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA", "ID", "current salary"));
//		Thread.sleep(3000);
//		robot_Enter();
		
//		js_Executor(salaryBreakdown_btn, "click");
//		js_Executor_Value(salaryBreakdown_btn,PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA", "ID", "breakdown"));
//		robot_Enter();
		
//		js_Executor(save_Btn, "click");
		System.out.println("profile -end");
	}

}
