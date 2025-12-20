package com.testNG;

import org.testng.annotations.Test;

import com.base.BaseClass;

public class CrossBrowserTesting extends BaseClass {

	@Test
	private void edge() {
		launchBrowser("edge");
		launchUrl("https://www.apple.com/in/");
		System.out.println("Browser_ID: " + Thread.currentThread().getId());

	}

	@Test
	private void chrome() {
		launchBrowser("edge");
		launchUrl("https://www.apple.com/in/");
		System.out.println("Browser_ID: " + Thread.currentThread().getId());

	}

	@Test
	private void Firefox() {
		launchBrowser("edge");
		launchUrl("https://www.apple.com/in/");
		System.out.println("Browser_ID: " + Thread.currentThread().getId());

	}

}
