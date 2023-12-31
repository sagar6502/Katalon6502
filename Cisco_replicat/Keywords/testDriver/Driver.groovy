package testDriver

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.WebDriver;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Driver {

	static WebDriver driver;

	public static WebDriver getDriver() {
		if(GlobalVariable.OS == "Chrome") {
			return getChromeDriver();
		}

		return null;
	}


	public static WebDriver getChromeDriver() {
		ChromeOptions options = new ChromeOptions();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome")
		capabilities.setCapability("acceptInsecureCerts", true)
		options.merge(capabilities)

		//options.addArguments("--incognito")
		options.addArguments("--start-maximized")
		options.addArguments("--high-dpi-support=1","--force-device-scale-factor=2.0")

		driver = new ChromeDriver(options);

		return driver;
	}

	public static closeDriver() {
		driver.close();
	}
}
