package MyINFO_emergencyContacts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home_Page {
	WebDriver driver;//For globel decleration
	WebDriverWait wait;
	
	public Home_Page (WebDriver wd) {
		 driver=wd;
		   PageFactory.initElements(driver, this);
	}
   
		 //Repository of an elements//
			 public @FindBy(xpath="//div[@class='orangehrm-login-branding']")WebElement ORANGEHRM;
			 public @FindBy(name="username") WebElement UserName;
			 public @FindBy(name="password") WebElement Password;
			 public @FindBy(xpath="//button[@type='submit']") WebElement Loginbtn;
			 public @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']") WebElement Error;
			 public @FindBy(xpath="//*[@class='oxd-topbar']/descendant::span[1]") WebElement Dashboard;
	         public @FindBy (linkText="My Info") WebElement MyInfo;
	         public @FindBy(xpath="//*[@class='orangehrm-tabs']/descendant::a[3]") WebElement Emergency_Contacts;
	         public @FindBy (xpath="//*[@class='oxd-navbar-nav']/descendant::a[2]")List<WebElement> LeftPanel;		 
	        		 
	public void Nav_Panel() {
		
		Assert.assertFalse(LeftPanel.isEmpty());
		  for(WebElement menu:LeftPanel)
		     {String menuText=menu.getText();
		      System.out.println("--------Navigation Left Panel List--------");
		      System.out.println(menuText);
		      System.out.println();
		     }
	 
		  
	  }
	public void LeftPanel() {
		  Assert.assertTrue(MyInfo.isDisplayed());
		  MyInfo.click();
	}
	}		  

	
	

