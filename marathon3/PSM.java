package marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class PSM {
		public ChromeDriver driver;
		public String excelFile;
		@Parameters({"url","username","password"})
		@BeforeMethod
		public void runPSM(String url,String username,String password)
		{
				
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable notifications");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(url);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();

	}
		@AfterMethod
		public void closeProject()
		{
			driver.close();
		}
		
		
		@DataProvider(name="fetchData")
		public String[][] excelData() throws IOException
		{
		String[][] readData = ReadExcel.readData(excelFile);
		return readData;
		}
		

}

