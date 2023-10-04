package HRM_run;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MyINFO_emergencyContacts.Emergency_contacts;
import MyINFO_emergencyContacts.Emergencycontact_attachment;
import MyINFO_emergencyContacts.Home_Page;
import MyINFO_emergencyContacts.Login_page;
import MyINFO_emergencyContacts.My_Info;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HRM_Run_Testcases {
	WebDriver driver;
	Login_page logpg;
	Home_Page  homepg;
	My_Info myinfo;
	Emergency_contacts emergencycontact;
	Emergencycontact_attachment emergencyattach;
	
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		logpg=new Login_page(driver);
		homepg=new Home_Page(driver);
		myinfo=new My_Info(driver);
		emergencycontact=new Emergency_contacts(driver);
		emergencyattach=new Emergencycontact_attachment(driver); 
	}
  @Test
  public void login_cred() throws InterruptedException, IOException {
	  logpg.LaunchURL();
	  logpg.Login_Credentials();
	  
  }
  @Test
  public void dashBoard_Fun() throws InterruptedException, IOException
  {
	  logpg.LaunchURL();
	  logpg.Valid_Login();
	  homepg.Nav_Panel();
	  homepg.LeftPanel();
	 
  }
  @Test
  public void infoPage() throws InterruptedException {
	  logpg.LaunchURL();
	  logpg.Valid_Login(); 
	  homepg.LeftPanel();
	  myinfo.Nav_Panel_list();
	  myinfo.Emergencycontact_click();
	  
	  
  }
  @Test
  public void emergencyContctPge() throws InterruptedException, IOException, AWTException {
	  logpg.LaunchURL();
	  logpg.Valid_Login(); 
	  homepg.LeftPanel();
	  myinfo.Nav_Panel_list();
	  myinfo.Emergencycontact_click();
	  emergencycontact.clickAddButton();
	  emergencycontact.emergencyContact_Info();
	  emergencycontact.click_SaveBtn1();
	
	  
	  
	  
  
  }
  @Test
  public void emergencyContctPge_Attach() throws InterruptedException, IOException, AWTException {
	  logpg.LaunchURL();
	  logpg.Valid_Login(); 
	  homepg.LeftPanel();
	  myinfo.Nav_Panel_list();
	  myinfo.Emergencycontact_click();
	  emergencyattach.Click_attachadd_btn();
	  emergencyattach.Attachfile();
	  emergencyattach.commentsbox();
	  emergencyattach.click_AttachSaveBtn();
	  //emergencyattach.edit_Attch();
	  
  }
}
