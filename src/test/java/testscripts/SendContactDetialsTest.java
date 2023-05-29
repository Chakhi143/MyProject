package testscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class SendContactDetialsTest extends BaseClass {
	@Test 
	public void sendContactDetailsTest() {
		SoftAssert soft =new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillraryDemoAppLink();
		web.switchToChildBrowser();
		
		soft.assertTrue(demoapp.getpageHeader().contains("Ecommerce"));
		
		web.scrollTitleElement(demoapp.getcontactUslink());
		demoapp.clickContactUs();
		
		soft.assertTrue(contact.getLogo().isDisplayed());
		
	Map<String, String> map =excel.getDataFromExcel("sheet1");
	contact.sendDetails(map.get("FullName"),map.get("Email"),map.get("Subject"),map.get("Message"));
	
	soft.assertAll();	
		
	}

}
