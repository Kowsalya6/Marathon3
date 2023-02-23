package marathon3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Edge extends PSM{
	@BeforeTest
	public void setUp()
	{
		excelFile="Marathon3.1";
	}
	@Test(dataProvider="fetchData")
	public void runEdge(String Name,String Amount) throws InterruptedException
	{
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement click = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		driver.executeScript("arguments[0].click();", click);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(Name);
		driver.findElement(By.xpath("(//button[@role='combobox'])[2]")).click();
		driver.findElement(By.xpath("//span[@title='New Customer']")).click();	
		WebElement findElement = driver.findElement(By.xpath("//span[text()='Additional Information']"));
		Actions action = new Actions(driver);
		action.scrollToElement(findElement).perform();
		WebElement click2 = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[3]"));
		driver.executeScript("arguments[0].click();", click2);
		driver.findElement(By.xpath("//span[@title='Partner Referral']"));
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(Amount);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//span[text()='24']")).click();
		driver.findElement(By.xpath("//button[@role='combobox']")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		WebElement click3 = driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[2]"));
		driver.executeScript("arguments[0].click();", click3);
		driver.findElement(By.xpath("(//span[contains(@class,'slds-listbox__option-text')])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String text = driver.findElement(By.xpath("//span[text()='Mark Stage as Complete']")).getText();
		if(text.contains("Complete"))
		{
			System.out.println("The opportunity is created");
		}
		else
		{
			System.out.println("The opportunity is not created");

		}

	}
}

/* Login to https://login.salesforce.com
2. Click on toggle menu button from the left corner
3. Click view All and click Sales from App Launcher
4. Click View All Key Deals in Key Deals 
6. Click on New
7. Give Opportunity Name  (From Excel)
8. Select Type as New Customer and Lead Source as Partner Referral
9. Give Amount as 75000 (from Excel)
10. Select Close Date as tomorrow
11. Select Stage as Needs Analysis
12. Click in Primary Campaign  Source and Select first option
13. Click Save and Verify the opportunity is created"
14. Close the browser*/