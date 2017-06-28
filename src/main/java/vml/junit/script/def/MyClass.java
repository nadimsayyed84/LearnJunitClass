package vml.junit.script.def;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyClass {

	@Test
	public void Sample(){
		System.out.println("Executing Sample");
	   	  final String USERNAME = "nadimsayyed1";
    	  final String AUTOMATE_KEY = "QpkdESb65xok8xBqUoYY";
    	  final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    	    DesiredCapabilities caps = new DesiredCapabilities();
    	    caps.setCapability("browser", "Firefox");
    	    caps.setCapability("browser_version", "47");
    	    caps.setCapability("os", "Windows");
    	    caps.setCapability("os_version", "10");
    	    caps.setCapability("browserstack.debug", "true");
    	    WebDriver driver = null;
			try {
				driver = new RemoteWebDriver(new URL(URL), caps);
			} catch (MalformedURLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
    	    driver.get("http://way2automation.com/way2auto_jquery/");
    		int hr = LocalDateTime.now().getHour();
    		int min = LocalDateTime.now().getMinute();
    		int sec = LocalDateTime.now().getSecond();
    		int mth = LocalDateTime.now().getMonth().getValue();
    		int day = LocalDateTime.now().getDayOfMonth();
    		String unqKey = Integer.toString(hr) + Integer.toString(min) + Integer.toString(sec) + Integer.toString(mth)
    				+ Integer.toString(day);
    		driver.findElement(By.name("name")).sendKeys(unqKey);
    		driver.findElement(By.name("phone")).sendKeys(unqKey);
    		driver.findElement(By.name("email")).sendKeys(unqKey + "@yahoo.com");
    		driver.findElement(By.name("city")).sendKeys("city");
    		driver.findElement(By.xpath("//div[@id='load_box']/form[@id='load_form']/fieldset/input[@name='username']"))
    				.sendKeys(unqKey);
    		driver.findElement(By.xpath("//div[@id='load_box']/form[@id='load_form']/fieldset/input[@name='password']"))
    				.sendKeys(unqKey);
    		driver.findElement(By
    				.xpath("//div[@id='load_box']/form[@id='load_form']/div//input[@type='submit' and @value='Submit' and @class='button']"))
    				.click();
    		
    		WebElement menuItem = driver.findElement(By.partialLinkText("Widget"));
    		Actions action = new Actions(driver);
    		action.moveToElement(menuItem).build().perform();
    		menuItem = driver.findElement(By.partialLinkText("Accordion"));
    		menuItem.click();
    				int size = driver.findElements(By.tagName("iframe")).size();
    		System.out.println("Total Frame count:-" + size);
    		driver.switchTo().frame(0);
    		List<WebElement> gtSec = driver.findElements(By.xpath("//div[@id='accordion']/h3"));
    		System.out.println(gtSec.size());
    		System.out.println("Total sections are: " + gtSec.size());
    		System.out.println("Sections are as mentioned below:-");
    		for (WebElement e : gtSec) {
    			System.out.println(e.getText());
    			try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    		driver.switchTo().defaultContent();
    				driver.switchTo().frame(0);
    		System.out.println("Data inside Sections are mentioned below:-");
    		gtSec = driver.findElements(By.xpath("//div[@id='accordion']/h3"));
    		List<WebElement> gtSecContnt = driver.findElements(By.xpath("//div[@id='accordion']/div"));
    		for (int i = 0; i < gtSec.size(); i++) {
    			String SecClicked = gtSec.get(i).getAttribute("aria-selected");
    			if (SecClicked.equals("false")) {
    				gtSec.get(i).click();
    				try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			}
    			System.out.format("Content for Section %d \n%s\n\n", i + 1, gtSecContnt.get(i).getText());
    			
    		}
    		driver.switchTo().defaultContent();
    		menuItem = driver.findElement(By.partialLinkText("Interaction"));
    		action = new Actions(driver);
    		action.moveToElement(menuItem).build().perform();
    		menuItem = driver.findElement(By.partialLinkText("Droppable"));
    		menuItem.click();
    		size = driver.findElements(By.tagName("iframe")).size();
    		System.out.println("Total Frame count:-" + size);
    		driver.switchTo().frame(0);
    		WebElement gtdrgElmnt = driver
    				.findElement(By.xpath("//p[text()='Drag me to my target']/ancestor::div[@id='draggable']"));
    		WebElement gtdrpElmnt = driver.findElement(By.xpath("//p[text()='Drop here']/ancestor::div[@id='droppable']"));
    		Actions drgdrp=new Actions(driver);
    		drgdrp.dragAndDrop(gtdrgElmnt, gtdrpElmnt).build().perform();
    		driver.switchTo().defaultContent();
    		driver.switchTo().frame(0);
    		try {
    			org.junit.Assert
    					.assertTrue((new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
    						public Boolean apply(WebDriver d) {
    							return d.findElement(By.xpath("//div[@id='droppable']/p")).getText().equals("Dropped!");
    						}
    					}));
    		} catch (Exception e) {
    			org.testng.Assert.fail("Drop Action does not happened. \n" + e.getStackTrace());
    		}
    		;
    		driver.switchTo().defaultContent();
    	    driver.quit();
	}
}
