package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.ProjectsInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class ProjectsPage extends Base_Class implements ProjectsInterfaceElements {
	
	@FindBy(className = profilePic_Class)
	private WebElement profile_pic;

	@FindBy(className = updateView_Class)
	private WebElement updateView_Btn;

	@FindBy(xpath = project_Xpath)
	private WebElement project_input;

	@FindBy(id = projectName_Id)
	private WebElement projectName_btn;

	@FindBy(id = input_Id)
	private WebElement input_Field;

	@FindBy(id = clint_Id)
	private WebElement clint_field;

	@FindBy(id = year_Id)
	private WebElement year_field;

	@FindBy(id = month_Id)
	private WebElement month_field;

	@FindBy(id = detail_Id)
	private WebElement detail_field;

	
	@FindBy(id = submit_Btn_Id)
	private WebElement submit_Btn;
	
	
	public ProjectsPage() {
		PageFactory.initElements(driver, this);
	}

	public void ProjectsPageValidation() throws Throwable {
		System.out.println("ProjectsPage -start");
		
		Explicit_Wait(20, profile_pic);
		elementClick(profile_pic);
		Explicit_Wait(20, updateView_Btn);
		elementClick(updateView_Btn);
		Thread.sleep(3000);
		js_Executor("down", 1000);
		elementClick(project_input);
		elementClick(projectName_btn);
		js_Executor_Value(projectName_btn, PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA", "ID", "projectname"));
		elementClick(clint_field);
		js_Executor_Value(clint_field, PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA", "ID", "Clientname"));
		Thread.sleep(3000);
		elementClick( year_field);
		js_Executor_Value( year_field, PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA", "ID", "projectyear"));
		robot_Enter();
		elementClick( month_field);
		js_Executor_Value( month_field, PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA", "ID", "projectmonth"));
		robot_Enter();
		Thread.sleep(3000);
		elementClick(detail_field);
		js_Executor_Value(detail_field, PageObjectManager.getPageObjectManager().getExcelUtility().getCellValue("DATA", "ID", "details"));
		elementClick(submit_Btn);
		System.out.println("ProjectsPage -end");
	}
}