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
import java.util.List;

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
public class Emergency_contacts {
	WebDriver driver;//For globel decleration
	WebDriverWait wait;

	public  Emergency_contacts  (WebDriver wd) {
			 driver=wd;
			   PageFactory.initElements(driver, this);
			   wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}		   
			
	//Repository of an elements//
    public @FindBy(xpath="//*[@class='orangehrm-edit-employee-content']/descendant::button[1]") WebElement Addbtn;
	public @FindBy(xpath="//*[@class='orangehrm-edit-employee-content']/descendant::input")WebElement FormElements;
    public @FindBy(xpath="//form[@class='oxd-form']//child::div[1]//child::div[1]//child::div[1]//child::div[1]//child::div[2]//child::input") WebElement name;
	public @FindBy(xpath="//form[@class='oxd-form']//child::div[1]//child::div[1]//child::div[2]//child::div[1]//child::div[2]//child::input") WebElement relationship;
    public @FindBy(xpath="//form[@class='oxd-form']//child::div[2]//child::div[1]//child::div[1]//child::div[1]//child::div[2]//child::input") WebElement HomeTelephone;
	public @FindBy(xpath="//form[@class='oxd-form']//child::div[2]//child::div[1]//child::div[2]//child::div[1]//child::div[2]//child::input") WebElement Mobile;
    public @FindBy(xpath="//form[@class='oxd-form']//child::div[2]//child::div[1]//child::div[3]//child::div[1]//child::div[2]//child::input") WebElement workteleph;
	public @FindBy(xpath="//form[@class='oxd-form']/descendant::button[1]") WebElement infoCancel;
    public @FindBy(xpath="//form[@class='oxd-form']/descendant::button[2]") WebElement infoSave;
    public @FindBy(xpath="//*[@class='orangehrm-edit-employee-content'][1]/descendant::span[1]")WebElement Recordmsg;
    public @FindBy(xpath="//*[@class='oxd-form-row'][2]/descendant::span") WebElement pherrormsg;
    public @FindBy(xpath="//*[@class='oxd-form-row'][1]/descendant::span[1]") WebElement namerrrormsg;
    public @FindBy(xpath="//*[@class='oxd-form-row'][1]/descendant::span[2]") WebElement Relationshiperror;//----------------
	public void clickAddButton() throws IOException, InterruptedException, AWTException{
    
		wait.until(ExpectedConditions.visibilityOf(Addbtn));
        Assert.assertTrue(Addbtn.isDisplayed());//checking Add btn is available or not
        Assert.assertTrue(Addbtn.isEnabled());
        Addbtn.click();
		}	
      public void emergencyContact_Info() throws IOException, AWTException, InterruptedException {
      wait.until(ExpectedConditions.visibilityOfAllElements(FormElements));
      String filePath="C:\\Deblina_study_personal_doc\\TESTING\\PROJECT_AUTOMATION\\1ST_PROJECT\\data_driven.xlsx";// path of the excel sheet
      FileInputStream fis=new FileInputStream(filePath);
      XSSFWorkbook workBook=new XSSFWorkbook(fis);
      XSSFSheet sheet=workBook.getSheet("EmergencyContacts");
      int rows=sheet.getLastRowNum();
                XSSFRow row=sheet.getRow(1);//for row
                XSSFCell Name=row.getCell(0);     // to get the value from cell
				XSSFCell Relation=row.getCell(1);
                XSSFCell Homeph=row.getCell(2);  //  to write in cell
				XSSFCell Mobileph=row.getCell(3);
				XSSFCell Workph=row.getCell(4);
				XSSFCell Result=row.getCell(5);



				System.out.println("Name: "+Name+" Relationship: "+Relation+"Home phone no: "+Homeph+"Mobile no: "+Mobileph+"Work phone no: "+Workph);



				this.name.sendKeys(Name.toString());



			    this.relationship.sendKeys(Relation.toString());



			    this.HomeTelephone.sendKeys(Homeph.toString());



			    this.Mobile.sendKeys(Mobileph.toString());



			    this.workteleph.sendKeys(Workph.toString());

  		    

  		        fis.close();

				workBook.close();// to write in cells

	}

		

		public void click_SaveBtn1()

		{wait.until(ExpectedConditions.visibilityOf(infoSave));

	     Assert.assertTrue(infoSave.isDisplayed());

	     Assert.assertTrue(infoSave.isEnabled());

	     infoSave.click();

	     System.out.println("saved successfully");

		}


				
			}
