package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElementByXPath("//input[@name='USERNAME']").sendKeys("demosalesmanager");
		driver.findElementByXPath("//input[@name='PASSWORD']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@value='Login']").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("123");
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		//Clicking on the Result of the leaads
		WebElement leadsclick = driver.findElementByXPath("(//a[@class='linktext'])[4]");
		leadsclick.click();
		Thread.sleep(3000);
		//Getting the value of company name 
		String GetValue = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		System.out.println(GetValue);
		//Delete Lead
		driver.findElementByXPath("//a[text()='Delete']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@name='id']").sendKeys(GetValue);
		Thread.sleep(3000);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(3000);
		
		//String text = driver.findElementByXPath("//div[text()='No records to display']").getText();		
		
		if(driver.findElementByXPath("//div[text()='No records to display']").isDisplayed() == true ){
			System.out.println("Text is present");
			}else{
			System.out.println("Text is absent");
		
			}
		
		driver.close();

	}

}
