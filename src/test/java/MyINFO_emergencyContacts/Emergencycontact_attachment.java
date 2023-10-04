package MyINFO_emergencyContacts;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.plugin.event.Result;
public class Emergencycontact_attachment {
	WebDriver driver;//For globel decleration
	WebDriverWait wait;
	public  Emergencycontact_attachment  (WebDriver wd) {
		 driver=wd;
		   PageFactory.initElements(driver, this);
		   wait = new WebDriverWait(driver,Duration.ofSeconds(30));
}		   
		 //Repository of an elements//
	public @FindBy(xpath="//*[@class='orangehrm-attachment']/descendant::button") WebElement Addattch;
	public @FindBy(xpath="//div[@class='oxd-file-button'][1]") WebElement Browse;
	public @FindBy(xpath="//div[@class='orangehrm-attachment']/descendant::button[1]") WebElement attach_cancel;
	public @FindBy(xpath="//*[@class='oxd-form-row'][2]/descendant::textarea") WebElement Comment;
	//public @FindBy(xpath="//div[@class='orangehrm-attachment']/descendant::button[2]") WebElement Save_attach;
	public @FindBy(xpath="//*[@class='orangehrm-attachment']/descendant::span[1]") WebElement record_found;
	public @FindBy(xpath="//*[@class='orangehrm-attachment']/descendant::span[3]") WebElement checkbox;
	public @FindBy(xpath="//*[@class='orangehrm-container']/descendant::button[1]") WebElement edit;
	public @FindBy(xpath="//*[@class='orangehrm-container']/descendant::button[2]") WebElement delete;

	public @FindBy(xpath="//button[@type='submit']") WebElement Save_attach;
	
		
		public void Click_attachadd_btn() {
			wait.until(ExpectedConditions.visibilityOf(Addattch));
			Assert.assertTrue(Addattch.isDisplayed());//checking Add btn is available or not
			Assert.assertTrue(Addattch.isEnabled());
			Addattch.click();
		}
		
		public void Attachfile() throws IOException, InterruptedException, AWTException{
			
			wait.until(ExpectedConditions.visibilityOf(Browse));
			Browse.click();
		Thread.sleep(2000);
		Robot robo=new Robot();	
		String filePath="C:\\Users\\souro\\Desktop\\calEnder.JPG";
		StringSelection str= new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		//robo.keyPress(KeyEvent.VK_ENTER);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		
		Thread.sleep(2000);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		


}
	public void commentsbox()
	{
		Comment.click();
		Comment.sendKeys("I m in comment section");
		//Save_attach.click();
	}
	
	public void click_AttachSaveBtn() throws InterruptedException

	{wait.until(ExpectedConditions.visibilityOf(Save_attach));

     Assert.assertTrue(Save_attach.isDisplayed());

     Assert.assertTrue(Save_attach.isEnabled());

     //Save_attach.click();

//Thread.sleep(2000);
     //System.out.println("saved successfully");

	}
	/*public void edit_Attch()
	{
		{wait.until(ExpectedConditions.visibilityOf(checkbox));
		 Assert.assertTrue(checkbox.isDisplayed());
		 checkbox.click();
		 System.out.println("checkbox done successfully ");
		edit.click();
		 System.out.println("edit done successfully");
		}
	}*/
	
}