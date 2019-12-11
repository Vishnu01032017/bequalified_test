package bequalifiedprogramaufgabe;


import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//inputs from command line
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the search engine");
		String search_engine = sc.nextLine();
		System.out.println("Enter the search term");
		String search_term = sc.nextLine();
		System.out.println("Enter the number of results");
		int result_num = sc.nextInt();
		
		// bing search engine
		if (search_engine.equals("bing"))
		{
			System.setProperty("webdriver.chrome.driver","src/bequalifiedprogramaufgabe/chromedriver-2");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.bing.com");
			driver.manage().window().maximize();	
			Thread.sleep(1000); 
			
			WebElement element_bing = driver.findElement(By.id("sb_form_q"));
			element_bing.sendKeys(search_term);
			Thread.sleep(500);
			element_bing.submit();
			
			WebDriverWait wait = new WebDriverWait(driver, 60); 
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b_tween")));
			
		    String results_bing = driver.findElement(By.id("b_tween")).getText().split(" ")[0];
			System.out.println("number of results: " + results_bing); 
			
			List<WebElement> resulturls_bing = driver.findElements(By.xpath("//div[@class='b_title']/h2/a"));
			System.out.println("List of urls: ");
			for(int i=0; i<result_num ; i++) 
			{ 
				String url = resulturls_bing.get(i).getAttribute("href");
				System.out.println(url);
		    }
			driver.close();
		}
    	
		// google search engine
		else if (search_engine.equals("google"))
		{
			System.setProperty("webdriver.chrome.driver","src/bequalifiedprogramaufgabe/chromedriver-2");
			WebDriver driver = new ChromeDriver();
			driver.get("https://google.com");
			driver.manage().window().maximize();	
			Thread.sleep(1000);
			
			WebElement element_google = driver.findElement(By.name("q"));
			element_google.sendKeys(search_term);
			element_google.submit();
			
			WebDriverWait wait = new WebDriverWait(driver, 60); 
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));
			
		    String results_google = driver.findElement(By.id("resultStats")).getText().split(" ")[1];
			System.out.println("number of results: "+ results_google);   
			
			List<WebElement> resulturls_google = driver.findElements(By.xpath("//div[@class='r']/a"));
			System.out.println("List of urls: ");
			for(int i=0; i<result_num ; i++)
			{ 
				String url = resulturls_google.get(2*i).getAttribute("href");
	    		System.out.println(url);
			} 
			driver.close();
		}
		
		else
		{
			System.out.println("Please use either google or bing"); 
		}	
		
}
}

