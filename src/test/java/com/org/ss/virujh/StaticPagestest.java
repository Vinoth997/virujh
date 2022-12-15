package com.org.ss.virujh;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StaticPagestest extends Browser{

	StaticPages sp;
	
	@BeforeTest
	public void BrowserLaunch() {
		browseropen();
		sp = new StaticPages(driver);
	}
	
	@Test
	public void TestCase1() throws InterruptedException {
		sp.testcase1();
	}
}
