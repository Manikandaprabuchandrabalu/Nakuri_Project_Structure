package com.pageobjectmanager;

import com.pageobjectmodel.CareerProfilePage;
import com.pageobjectmodel.EmployeementPage;
import com.pageobjectmodel.ITSkillsPage;
import com.pageobjectmodel.KeySkillsPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.LogoutPage;
import com.pageobjectmodel.PersonalPage;
import com.pageobjectmodel.ProfielSummaryPage;
import com.pageobjectmodel.ProfileUpdatePage;
import com.pageobjectmodel.ProjectsPage;
import com.pageobjectmodel.ResumeHeadLinePage;
import com.pageobjectmodel.ResumeUploadPage;
import com.utility.ExcelUtility;
import com.utility.FileReaderManager;

public class PageObjectManager {
	private static PageObjectManager pageObjectManager;
	private FileReaderManager fileReader;
	private LoginPage loginPage;
	private ProfileUpdatePage profileUpdatePage;
	private ResumeUploadPage resumeUploadPage;
	private ExcelUtility excelUtility;
	private ResumeHeadLinePage resumeHeadLinePage;
	private KeySkillsPage keySkillsPage;
	private EmployeementPage employeementPage;
	private ITSkillsPage iTSkillsPage;
	private ProjectsPage projectsPage;
	private ProfielSummaryPage profielSummaryPage;
	private CareerProfilePage careerProfilePage;
	private LogoutPage logoutPage;
	private  PersonalPage  personalPage;
	
	public PersonalPage getPersonalPage() {
		if (personalPage == null) {
			personalPage = new PersonalPage();
		}
		return personalPage;
	}

	public CareerProfilePage getCareerProfilePage() {
		if (careerProfilePage == null) {
			careerProfilePage = new CareerProfilePage();
		}
		return careerProfilePage;
	}

	public LogoutPage getLogoutPage() {
		if (logoutPage == null) {
			logoutPage = new LogoutPage();
		}
		return logoutPage;
	}

	public ProfielSummaryPage getProfielSummaryPage() {
		if (profielSummaryPage == null) {
			profielSummaryPage = new ProfielSummaryPage();
		}
		return profielSummaryPage;
	}

	public ProjectsPage getProjectsPage() {
		if (projectsPage == null) {
			projectsPage = new ProjectsPage();
		}
		return projectsPage;
	}

	public ITSkillsPage getITSkillsPage() {
		if (iTSkillsPage == null) {
			iTSkillsPage = new ITSkillsPage();
		}
		return iTSkillsPage;
	}

	public EmployeementPage getEmployeementPage() {
		if (employeementPage == null) {
			employeementPage = new EmployeementPage();
		}
		return employeementPage;
	}

	public KeySkillsPage getKeySkillsPage() {
		if (keySkillsPage == null) {
			keySkillsPage = new KeySkillsPage();
		}
		return keySkillsPage;
	}

	public ResumeHeadLinePage getResumeHeadLinePage() {
		if (resumeHeadLinePage == null) {
			resumeHeadLinePage = new ResumeHeadLinePage();
		}
		return resumeHeadLinePage;
	}

	public ResumeUploadPage getResumeUploadPage() {
		if (resumeUploadPage == null) {
			resumeUploadPage = new ResumeUploadPage();
		}
		return resumeUploadPage;
	}

	public ExcelUtility getExcelUtility() {
		if (excelUtility == null) {
			excelUtility = new ExcelUtility();
		}
		return excelUtility;
	}

	public ProfileUpdatePage getProfileUpdatePage() {
		if (profileUpdatePage == null) {
			profileUpdatePage = new ProfileUpdatePage();
		}
		return profileUpdatePage;
	}

	public FileReaderManager getFileReader() {
		if (fileReader == null) {
			fileReader = new FileReaderManager();
		}
		return fileReader;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

	public static PageObjectManager getPageObjectManager() {
		if (pageObjectManager == null) {
			pageObjectManager = new PageObjectManager();
		}
		return pageObjectManager;
	}

}
