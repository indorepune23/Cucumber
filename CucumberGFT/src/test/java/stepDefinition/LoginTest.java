package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	public static WebDriver driver;
	PageObjcts po;
@Given("^Navigate to Home page$")
public void wheniamonhomepage() {
	
	
	System.setProperty("webdriver.chrome.driver","C:\\Drive2\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://10.232.237.143:443/TestMeApp");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	po=new PageObjcts(driver);
	
}
@When("^user enters username and password$")
public void ienteruname() {
	po.SignIn.click();
	po.userName.sendKeys("lalitha");
	po.password.sendKeys("Password123");
	po.Login.click();
	
	
}
@Then("^user logged in successfully$")
public void iamabletologin() {
	System.out.println("Login successfully");
}

@When("^Larry searches below products in the search box:$")
public void larry_searches_below_products_in_the_search_box(DataTable dataTable) {
	
	List<String> product= dataTable.asList(String.class);
	for(String s: product)
	{
		driver.findElement(By.name("products")).sendKeys(s);
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click(); 
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
		
	}
}
@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")

public void entersunamepwd(String uname, String pwd) {
po.SignIn.click();
po.userName.sendKeys(uname);
po.password.sendKeys(pwd);
po.Login.click();

}
@Then("^product should be added in the cart if available$")
public void product_should_be_displayed_if_available_in_TestMeApp() {
	
}

}