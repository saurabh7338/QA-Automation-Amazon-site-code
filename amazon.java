import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/-/hi/ap/signin?openid.pape.max_auth_age=3600&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fspr%2Freturns%2Fgift&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=amzn_psr_desktop_in&openid.mode=checkid_setup&language=en_IN&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	  WebElement user= driver.findElement(By.id("ap_email"));
	    user.sendKeys("saurabhkamble157@gmail.com");
	  WebElement pass=driver.findElement(By.name("password"));
	    pass.sendKeys("Saurabh@678");
	    driver.findElement(By.id("signInSubmit")).click();
	//find product and add it to the cart
      WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("productToAdd");
      WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
     // Click on the first search result (assuming it's the desired product)
        WebElement productLink = driver.findElement(By.xpath("//div[@data-asin][1]//a"));
        productLink.click();

        // Click on the "Add to Cart" button
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
	 //go back to homepage.
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        amazonLogo.click();
	}
	  private static void verifyCartOnHomePage(WebDriver driver, String productName) {
	        // Locate the cart icon and click it to view the cart
	        WebElement cartIcon = driver.findElement(By.id("nav-cart"));
	        cartIcon.click();

	        // Locate the product in the cart and assert that it matches the added product
	        WebElement cartProduct = driver.findElement(By.xpath("//span[contains(text(), '" + productName + "')]"));
	        assert cartProduct.isDisplayed() : "Product not found in the cart on the home page.";
	    
    }
}
class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public amazon goBackToHomePage() {
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        amazonLogo.click();
        return new amazon();
    }
}