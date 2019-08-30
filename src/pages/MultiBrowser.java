package pages;


	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

	public class MultiBrowser 

	{
		CommonUtility objCommon=new  CommonUtility();
		
		@Parameters("browser")
		@BeforeClass
		public void checkBrowser(String browser) throws Exception
		{
			objCommon.loadProperties();
			//check browser name from textng.xml file
			if (browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\AnamikaJoshi\\Desktop\\BaseFramework\\FB\\src\\drivers\\geckodriver.exe");
				CommonUtility.driver=new FirefoxDriver();
				
			}
			else if (browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\AnamikaJoshi\\Desktop\\BaseFramework\\FB\\src\\drivers\\chromedriver.exe");
				CommonUtility.driver=new ChromeDriver();
			}
			else if (browser.equals("ie"))
			{
				System.setProperty("webdriver.ie.driver","C:\\Users\\AnamikaJoshi\\Desktop\\BaseFramework\\FB\\src\\drivers\\IEDriverServer.exe");
				CommonUtility.driver=new InternetExplorerDriver();
			}	
			
		}
		@Test(description="Login To Facebook")
		public void login() 
		{
			//get the URL
		String url=CommonUtility.page1.getProperty("url");
			
		if(url != null) 
			CommonUtility.driver.get(url);
		else 
			throw new RuntimeException("url not specified in the Configuration.properties file.");
		CommonUtility.driver.manage().window().maximize();
		CommonUtility.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		}
