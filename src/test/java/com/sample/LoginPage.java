package com.sample;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utilities.BaseClass1;
import com.utilities.PojoClass;

public class LoginPage extends BaseClass1 {
	@BeforeMethod
	private void open() {
		launchChrome();
		winMaximize();
		gotUrl("https://stage.outreach.sloovi.com/login");
	}
	@AfterMethod
	private void screen() throws IOException, InterruptedException {
		Thread.sleep(3000);
		takesScreenshot();
		closeTab();
	}
	@Test(dataProvider = "loginData")
	private void login(String s1, String s2) throws IOException, InterruptedException {
		
		PojoClass l = new PojoClass();
		sendKey(l.getUsername(), s1);
		sendKey(l.getPassword(), s2);
		clickReplace(l.getLogin());
	}
	@DataProvider(name = "loginData")
	private Object[][] getData() throws IOException {
		return new Object[][] {
				{ excelRead(1, 0), excelRead(1, 1) },
				{ excelRead(2, 0), excelRead(2, 1) },
				{ excelRead(3, 0), excelRead(3, 1) },
				{ excelRead(4, 0), excelRead(4, 1) },
				{ excelRead(5, 0), excelRead(5, 1) }

		};

	}

}
