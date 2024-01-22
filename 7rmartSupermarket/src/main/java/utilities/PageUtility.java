package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class PageUtility {
	
	public void scrollBy(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}
	
	public void clickAndHoldOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
	}
	
	public void selectByIndex(WebElement element,int index) {
		Select select =new Select(element);
		select.selectByIndex(index);
		
	}
	
	public void selectByValue(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);;
		
	}
	
	public void selectByVisibleText(WebElement element,String visibleText) {
		Select select =new Select(element);
		select.selectByVisibleText(visibleText);;
		
	}
	
	public void dragAndDrop(WebDriver driver, WebElement draggable , WebElement drop) {
		Actions action=new Actions(driver);
		action.dragAndDrop(draggable, drop).perform();
	}
	
	public void elementClick(WebDriver driver,WebElement element) {
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);

	}
	
	public void waitForClick(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));// explicit
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public String randomPhoneNumberGenerator() {
		Faker faker= new Faker();
		return faker.phoneNumber().cellPhone();
		
	}
	
	public String randomNameGenerator() {
		Faker faker= new Faker();
		return faker.name().firstName();
		
	}
	
	public String randomFullNameGenerator() {
		Faker faker= new Faker();
		return faker.name().fullName();
		
	}
	
	public String randomPasswordGenerator() {
		Faker faker= new Faker();
		return faker.code().asin();
		
	}
}
