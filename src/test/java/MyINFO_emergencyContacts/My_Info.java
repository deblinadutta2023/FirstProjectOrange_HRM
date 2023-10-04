package MyINFO_emergencyContacts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class My_Info {
	WebDriver driver;//For global declaration
WebDriverWait wait;

public  My_Info  (WebDriver wd) {
		 driver=wd;
		   PageFactory.initElements(driver, this);
		   wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	
}
		 //Repository of an elements//
//public @FindBy(xpath="//*[contains(@class,'oxd-form')]")List<WebElement> Personal_Details_Elements;
//public @FindBy(xpath="//*[@class='orangehrm-tabs']/descendant::a[2]")WebElement ContactDetails;
public @FindBy(xpath="//*[@class='orangehrm-tabs']/descendant::a[3]")WebElement Emergency_Contacts;
public @FindBy(xpath="//div[@class='orangehrm-tabs-wrapper']/child::a") List<WebElement> full_list;

		   public void Nav_Panel_list() {
			   wait.until(ExpectedConditions.visibilityOfAllElements(full_list));
			   Assert.assertFalse(full_list.isEmpty());
			   Assert.assertTrue(Emergency_Contacts.isDisplayed());
			   System.out.println("--------Navigation Tab List is showing--------");
			    for(WebElement menu:full_list)
				     {
			    	String menuText=menu.getText();
				      //System.out.println("--------Navigation Menulist MyInfo List--------");
				      System.out.println(menuText);
				      System.out.println();
				     }

}

	  public void Emergencycontact_click() {
				  Assert.assertTrue(Emergency_Contacts.isDisplayed());
				  wait.until(ExpectedConditions.visibilityOfAllElements(Emergency_Contacts));
				  Emergency_Contacts.click();
}
}

