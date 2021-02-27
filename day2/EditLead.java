package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Niranjan");
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		WebElement leadsclick = driver.findElementByXPath("(//a[@class='linktext'])[4]");
		
		leadsclick.click();
		
		String gettitle = driver.getTitle();
		
		if(driver.getTitle().contains("View Lead"))
		{
			System.out.println("The URL title is confirmed as:" +driver.getTitle() );
		}else {
			System.out.println("This is Not correct Title");
		}
		
		driver.findElementByXPath("//a[text()='Edit']").click();
		driver.findElementByXPath("(//input[@name='companyName'])[2]").clear();
		driver.findElementByXPath("(//input[@name='companyName'])[2]").sendKeys("CongaEdit");
		driver.findElementByXPath("//input[@value='Update']").click();
		WebElement companyName = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']");
		
		
		String ChangedCompanyName = companyName.getText();
		if(companyName.getText().contains("CongaEdit"))
		{
			System.out.println("Company Name is Edited to :"+ ChangedCompanyName);
		}else {
			System.out.println("Company Name change is not done");
		}
		
		
		driver.close();
		
		
		
		

	}

}
