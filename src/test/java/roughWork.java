import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class roughWork {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationpractice.techwithjatin.com/");
		driver.manage().window().maximize();
		
		By Signin = By.cssSelector("[title='Log in to your customer account']");
	    driver.findElement(Signin).click();



	}

}
