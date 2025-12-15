package com.testNG;

import org.testng.annotations.Test;

import com.base.Base_Class;

public class CrossBrowserTesting extends Base_Class {

	@Test
	private void edge() {
		launchBrowser("edge");
		launchUrl("https://www.apple.com/in/");
		System.out.println("Browser_ID: " + Thread.currentThread().getId());

	}

	@Test
	private void chrome() {
		launchBrowser("chrome");
		launchUrl("https://www.apple.com/in/");
		System.out.println("Browser_ID: " + Thread.currentThread().getId());

	}

	@Test
	private void Firefox() {
		launchBrowser("firefox");
		launchUrl("https://www.apple.com/in/");
		System.out.println("Browser_ID: " + Thread.currentThread().getId());

	}

}
