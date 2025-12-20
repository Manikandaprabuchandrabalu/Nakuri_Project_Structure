package com.pageobjectmodel;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.Base_Class;
import com.interfaceelements.ResumeUploadInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class ResumeUploadPage extends  Base_Class implements ResumeUploadInterfaceElements{
	@FindBy(className = resumeupload_class )
	private WebElement resumeupload_btn;
	
	
	
	public  ResumeUploadPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void resumeUpload() throws Throwable {
		System.out.println("resumeupload -start");
		Thread.sleep(3000);
		Explicit_Wait(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("explicity_wait"), resumeupload_btn);
		elementClick(resumeupload_btn);
		resume_Uploader(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("pdflocation"));
		System.out.println("resumeupload -end");
	}

}
