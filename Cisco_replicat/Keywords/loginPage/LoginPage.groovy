package loginPage

import testDriver.Driver

import loc.Locators
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.exception.StepErrorException
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//import loc.Locators


class LoginPage {

	WebDriver driver = Driver.getDriver()
	Locators locators = new Locators()

	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}



	/**
	 * openBrowser
	 * @param to URL of website
	 */
	@Keyword
	def navigateURL(String URL) {
		try {
			driver.get(URL)
			KeywordUtil.logInfo("Navigating to URL :: "+URL)
			KeywordUtil.markPassed("Navigated Successfully!")
		} catch (StepErrorException e) {
			KeywordUtil.markErrorAndStop("URL is non-responsive")
		} catch (Exception e) {
			KeywordUtil.markErrorAndStop("Fail to load the website")
		}
		//div[@class='_3OO5Xc'])[1]
		driver.findElement(By.xpath("(//div[@class='_3OO5Xc'])[1]")).sendKeys("Mobiles")
	}
	
	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement() {
		try {
			driver.sleep(5000)
			driver.switchTo().frame(0)
			Actions ac = new Actions(driver)
			ac.moveToElement("//div[@id='container']").click().build().perform()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
}