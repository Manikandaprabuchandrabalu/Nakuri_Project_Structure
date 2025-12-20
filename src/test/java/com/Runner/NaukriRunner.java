package com.runner;

import com.base.BaseClass;
import com.listner.ExtentReport_Test;
import com.listner.ITestListenerClass;
import com.pageobjectmanager.PageObjectManager;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ITestListenerClass.class)
public class NaukriRunner extends BaseClass {

	@BeforeTest
	private void setupProeprty() throws IOException {
		launchBrowser(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
		launchUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));

	}

	@BeforeClass
	private void validate_Login() throws Throwable {
		ExtentReport_Test.extenttest = extentReports
				.createTest("Naukri Application" + " : "
						+ Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("VALID LOGIN TEST");
		PageObjectManager.getPageObjectManager().getLoginPage().loginValidation();

	}

	@Test(priority = 1)
	private void ProfileUpdate() throws Throwable {
		PageObjectManager.getPageObjectManager().getProfileUpdatePage().profileValidation();
	}

	@Test(priority = 2)
	private void resumeUpload() throws Throwable {
		PageObjectManager.getPageObjectManager().getResumeUploadPage().resumeUpload();
	}

	@Test(priority = 3)
	private void resumeHeadline() throws Throwable {
		PageObjectManager.getPageObjectManager().getResumeHeadLinePage().resumeHeadlineValidation();
	}

	@Test(priority = 4)
	private void keyskills() throws Throwable {
		PageObjectManager.getPageObjectManager().getKeySkillsPage().keyskillsValidation();
	}

	@Test(priority = 5)
	private void employmentPage() throws Throwable {
		PageObjectManager.getPageObjectManager().getEmployeementPage().employeementPageValidation();
	}

	@Test(priority = 6)
	private void itSkills() throws Throwable {
		PageObjectManager.getPageObjectManager().getITSkillsPage().itskillsValidation();
	}

	@Test(priority = 7)
	private void projectPage() throws Throwable {
		PageObjectManager.getPageObjectManager().getProjectsPage().ProjectsPageValidation();
	}

	@Test(priority = 8)
	private void ProfileSummary() throws Throwable {
		PageObjectManager.getPageObjectManager().getProfielSummaryPage().profileSummaryValidation();
	}

	@Test(priority = 9)
	private void careerprofile() throws Throwable {
		PageObjectManager.getPageObjectManager().getCareerProfilePage().CareerProfilePageValidation();
	}

	@Test(priority = 10)
	private void personalPage() throws Throwable {
		PageObjectManager.getPageObjectManager().getPersonalPage().PersonalPageValidation();
	}

	@Test(priority = 11)
	private void logout() throws Throwable {
		PageObjectManager.getPageObjectManager().getLogoutPage().LogoutPageValidation();
	}

	@AfterTest
	private void browserTermination() {
		closeBrowser();
	}

	@BeforeSuite
	private void reportStart() throws IOException {
		extentReportStart(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("reportstart"));

	}

	@AfterSuite
	private void reportEnd() throws IOException {
		extentReportTearDown(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("reportend"));

	}

}
