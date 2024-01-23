package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;


public class FileUploadUtility {
	public void fileUploadUsingSendKeys(WebElement chooseFile,String url) {

		chooseFile.sendKeys(url);
	}
	

	 public void fileUploadUsingRobotClass(WebElement chooseFile ,String url) throws AWTException {
		
		 StringSelection s = new StringSelection(url);
		 chooseFile.click();
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
	     
	     
	     Robot robot = new Robot();
	 	 robot.delay(250);
	 	 robot.keyPress(KeyEvent.VK_ENTER);
	 	 robot.keyRelease(KeyEvent.VK_ENTER);
	 	 robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_ENTER);        
         robot.delay(250);
         robot.keyRelease(KeyEvent.VK_ENTER);
        
	}
}
