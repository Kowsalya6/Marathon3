package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Chrome extends PSM{
	@BeforeTest
	public void setUp()
	{
		excelFile="Marathon3";
	}
	@Test(dataProvider="fetchData")
	public void runChrome(String question, String answer) throws InterruptedException {
	
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Content");
		driver.findElement(By.xpath("//mark[text()='Content']")).click();
		WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", chatter);
		String title = driver.getTitle();
		if(title.contains("Chatter Home"))
		{
			System.out.println("Title is correct");
		}
		else
		{
			System.out.println("Title isnot correct");
		}
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys("question");
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(answer);
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_brand')]")).click();
		String text = driver.findElement(By.xpath("(//span[text()='What would you like to have?'])[1]")).getText();
		System.out.println(text);	
		if(text.contains("What would you like to have"))
		{
			System.out.println("Questions is Correct");
		}
		else
		{
			System.out.println("Questions isnot Correct");
		}
	}

}

/*1. Launch https://login.salesforce.com/ 
2. Login to Salesforce with your username and password
3. Click on the App Launcher (dots)
4. Click View All
5. Type Content on the Search box
6. Click Content Link
7. Click on Chatter Tab
8. Verify Chatter title on the page
9. Click Question tab
10. Type Question with data (coming from excel)
11. Type Details with data (coming from excel)
12. Click Ask
13. Confirm the question appears
14. Close the browser
*/