import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import loginPage.LoginPage



def page = new LoginPage()
//def locators = new Locators()
page.navigateURL(GlobalVariable.URL)
//WebUI.waitForElementClickable(locators.crossButton(), 10)
//page.clickElement()