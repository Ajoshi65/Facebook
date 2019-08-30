package pages;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;


	public class CommonUtility 

	{
		public static WebDriver driver=null;
		public static Properties page1=null;
		
		@Parameters("browser")
		public void setChromeProperties(String browser) throws Exception
		{
		loadProperties();
		//check browser name from textng.xml file
				if (browser.equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\\\AnamikaJoshi\\Desktop\\BaseFramework\\FB\\src\\drivers\\geckodriver.exe");
					CommonUtility.driver=new FirefoxDriver();
					
				}
				else if (browser.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver","C:\\Users\\AnamikaJoshi\\Desktop\\BaseFramework\\FB\\src\\drivers\\chromedriver.exe");
					driver=new ChromeDriver();
				}
				else if (browser.equals("ie"))
				{
					System.setProperty("webdriver.chrome.driver","C:\\Users\\AnamikaJoshi\\Desktop\\BaseFramework\\FB\\src\\drivers\\IEDriverServer.exe");
					driver=new InternetExplorerDriver();
				}
				
			
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
		}
		
		public void dismissPopup() throws Exception
		{
			/*Alert alert=driver.switchTo().alert();
			// Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        Thread.sleep(5000);*/
			
			
			
		}
		
		public void insec()
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		public void sendkeys(String xpath,String value)
		{
			driver.findElement(By.xpath(xpath)).clear();//need to clear the value before sending
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(xpath)).sendKeys(value);
		}
		public void click(String xpath)
		{
			driver.findElement(By.xpath(xpath)).click();
		}
		public void selectFromList (String xpath)
		{
			List<WebElement> element=driver.findElements(By.xpath(xpath));
			int count=element.size();
			for (int i=0;i<count;i++)
			{
				String text=element.get(i).getText();
				System.out.println(text);
			}
			
		}
		public void loadProperties() throws Exception 
		{
			page1=new Properties();
			FileReader file1=new FileReader("C:\\Users\\AnamikaJoshi\\Desktop\\BaseFramework\\FB\\src\\properties\\page1.properties");
			
			page1.load(file1);
					
		}
		
		public void selectDropDown(String xpath, String value)
		{
			WebElement element=CommonUtility.driver.findElement(By.xpath(xpath));
			Select select=new Select(element);
			select.selectByValue(value);		
		
		}
		
		public void captureScreenshot(WebDriver webdriver,String fileWithPath) throws Exception
		{
			TakesScreenshot scrShot=((TakesScreenshot)driver);

			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File(fileWithPath);
			FileUtils.copyFile(SrcFile, DestFile);
		}

}
