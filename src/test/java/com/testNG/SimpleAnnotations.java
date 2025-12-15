package com.testNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleAnnotations {
	
	@BeforeSuite
	private void propertySetting() {
		System.out.println("Property Settings: ");
	}
	
	@BeforeTest
	private void browserLaunnch() {
		System.out.println("Browser Launch");

	}
	
	@BeforeClass
	private void urlLaunch() {
		System.out.println("Url launch");

	}
	
	@BeforeMethod
	private void login() {
		System.out.println("Login");

	}
	
	@Test
	private void women() {
		System.out.println("Women");

	}
	
	@Test
	private void men() {
		System.out.println("Men");

	}
	
	@Test
	private void kids() {
		System.out.println("Kids");

	}
	
	@Test
	private void accessories() {
		System.out.println("Accessories");

	}
	
	@AfterMethod
	private void logout() {
		System.out.println("Logout");

	}
	
	@AfterClass
	private void screenshot() {
		System.out.println("Screenshot");

	}
	
	@AfterTest
	private void close() {
		System.out.println("Close");

	}
	
	@AfterSuite
	private void terminat_Browser() {
		System.out.println("Terminate Browser");

	}

}
