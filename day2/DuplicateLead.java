package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("rniranjankumar@gmail.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		//Capture name of First Resulting lead
		String leadValue = driver.findElementByXPath("(//a[text()='Niranjan'])[1]").getText();
		System.out.println(leadValue);
		//Click First Resulting lead
		driver.findElementByXPath("(//a[@class='linktext'])[4]").click();
		//Duplicate Lead
		driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
		Thread.sleep(3000);
		//Verify the title as 'Duplicate Lead'
		String gettitle = driver.getTitle();
		if(gettitle.contains("Duplicate Lead"))
		{
			System.out.println("The URL title is confirmed as:" +gettitle );
		}else {
			System.out.println("This is Not correct Title"+gettitle);
		}
		Thread.sleep(3000);
		//Click Create Lead
		driver.findElementByXPath("//input[@value='Create Lead']").click();
		Thread.sleep(3000);
		
		String duplicateName = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();		
				
				if(leadValue.equals(duplicateName)) {
					System.out.println("Name Is Duplicated");
				}else {
					System.out.println("Name is Not Duplicated");
				}
				driver.close();

	}

}
