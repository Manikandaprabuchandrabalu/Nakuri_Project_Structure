package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.interfaceelements.ITSkillsInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class ITSkillsPage extends BaseClass implements ITSkillsInterfaceElements {
	@FindBy(xpath = additskills_Xpath)
	private WebElement additskills_btn;

	@FindBy(id = skillsName_Id)
	private WebElement skillsName_btn;

	@FindBy(id = skillssave_Id)
	private WebElement skillssave_btn;

	public ITSkillsPage() {
		PageFactory.initElements(driver, this);
	}

	public void itskillsValidation() throws Throwable {
		System.out.println("ITSkillsPage -start");
		Explicit_Wait(20, additskills_btn);
		js_Executor(additskills_btn, "view");
		mouse_Actions(additskills_btn, "move element");
		js_Executor(additskills_btn, "click");
		Explicit_Wait(20, skillsName_btn);
		js_Executor(skillsName_btn, "click");
		js_Executor_Value(skillsName_btn,PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA", "ID", "Skill"));
		mouse_Actions(skillssave_btn, "move element");
		js_Executor(skillssave_btn, "click");
		System.out.println("ITSkillsPage -end");
	}

}
