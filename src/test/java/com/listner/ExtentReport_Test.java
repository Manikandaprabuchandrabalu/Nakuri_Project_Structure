package com.listner;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.base.Base_Class;

public class ExtentReport_Test {
	public static ExtentTest extenttest;

    @BeforeSuite
    public void extentTestReportStartup() throws IOException {
        Base_Class base = new Base_Class() {
        };
        base.extentReportStart(null);
    }

    @AfterSuite
    public void extentReportEnd() throws IOException {
        Base_Class base = new Base_Class() {
        };
        base.extentReportTearDown(null);
    }

}
