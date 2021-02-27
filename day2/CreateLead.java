package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		//driver.findElement(By.id("username")).sendKeys("");
		driver.findElementByXPath("//input[@name='USERNAME']").sendKeys("demosalesmanager");
		//driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElementByXPath("//input[@name='PASSWORD']").sendKeys("crmsfa");
		//driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElementByXPath("//input[@value='Login']").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		
		//driver.findElementByLinkText("Create Lead").click();
		driver.findElementByXPath("//a[text()='Create Lead']").click();
		
		//driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Conga");
		driver.findElementByXPath("(//input[@name='companyName'])[2]").sendKeys("CongaLAR");
		
		//driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Niranjan");
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Niranjan");
		
		//driver.findElement(By.id("createLeadForm_lastName")).sendKeys("kumar");
		driver.findElementByXPath("(//input[@name='lastName'])[3]").sendKeys("Kumar");
		
		//driver.findElement(By.className("smallSubmit")).click();
		driver.findElementByXPath("//input[@name='submitButton']").click();

	}

}
