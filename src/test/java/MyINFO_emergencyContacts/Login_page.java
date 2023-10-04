package MyINFO_emergencyContacts;

import static org.testng.Assert.assertEquals;

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

public class Login_page {
	WebDriver driver;//For globel decleration
	WebDriverWait wait;
	 public  Login_page(WebDriver wd)
	 {
	   driver=wd;
	   PageFactory.initElements(driver, this);
	   wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	 }
	 
	 
	//Repository of an elements//
	  @FindBy(xpath="//div[@class='orangehrm-login-branding']")WebElement ORANGEHRM;
	  @FindBy(name="username") WebElement UserName;
	  @FindBy(name="password") WebElement Password;
	  @FindBy(xpath="//button[@type='submit']") WebElement Loginbtn;
	  @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']") WebElement Error;
	  @FindBy(xpath="//*[@class='oxd-topbar']/descendant::span[1]") WebElement Dashboard;
	
	  public void LaunchURL() throws InterruptedException
	  {
		  driver.manage().window().maximize();
	
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  wait.until(ExpectedConditions.visibilityOf(ORANGEHRM));   
	  
	  }
	  public void Login_Credentials() throws IOException, InterruptedException{
		  Assert.assertTrue(UserName.isDisplayed());
		  Assert.assertTrue(Password.isDisplayed());
		  
		  String filePath="C:\\Deblina_study_personal_doc\\TESTING\\PROJECT_AUTOMATION\\1ST_PROJECT\\data_driven.xlsx";
		  FileInputStream fis=new FileInputStream(filePath);

			XSSFWorkbook workBook=new XSSFWorkbook(fis);

			XSSFSheet sheet=workBook.getSheet("Loginpage");

			int rows=sheet.getLastRowNum();
			//int len=sheet.getLastRowNum();
			//System.out.println(len);
			//int r=1;
			
	        for(int r=1; r<=rows; r++)
			{
	        	XSSFRow row=sheet.getRow(r);
				XSSFCell Username=row.getCell(0);     // to get the value from cell
				XSSFCell Pass=row.getCell(1);
				XSSFCell Result=row.getCell(2);  //  to write in cell
				System.out.println("Username: "+Username+" Password: "+Pass);
                //System.out.println(row);
				//System.out.println(Username);
				//System.out.println(Pass);				
			//	System.out.println(Loginbtn);
				this.UserName.sendKeys(Username.toString());
			    this.Password.sendKeys(Pass.toString());
			
			    Loginbtn.click(); 
         	   //System.out.println(r);
			   // r=r+1;
			   // System.out.println(r);
			    
			    try {wait.until(ExpectedConditions.visibilityOf(Dashboard));
			    	//System.out.println(Error.getText());
			    	//System.out.println(Result.toString());
					assertEquals(Dashboard.getText(),Result.toString());
					
					System.out.println("User is navigated to OrangeHRM Home-Page");
				}
			    catch(Exception e)
				{   // Error message after giving invalid credentials
			    	wait.until(ExpectedConditions.visibilityOf(Error));
			    	//System.out.println(Error.getText());
			    	//System.out.println(Result.toString());
			    	
				assertEquals(Error.getText(),Result.toString());
					System.out.println("Invalid Data");
					//result.setCellValue(ErrorMsg);
					System.out.println("I am in catch statement");
			
				}
		
			    	fis.close();  // close FileInputStream to start FileOutputStream
			  
			    	FileOutputStream fos=new FileOutputStream(filePath);
					workBook.write(fos);// to write in cells
					
				}
		   			
	  }
	  public void Valid_Login()
		 {
		  UserName.sendKeys("Admin");
		  Password.sendKeys("admin123");
		  Loginbtn.click();
		  wait.until(ExpectedConditions.visibilityOf(Dashboard));
		 }	
			
	  }

