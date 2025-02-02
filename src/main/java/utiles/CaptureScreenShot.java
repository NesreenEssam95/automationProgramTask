package utiles;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class CaptureScreenShot {
	
	WebDriver browserobject;
	
	public CaptureScreenShot(WebDriver browserobject)
	{
		this.browserobject=browserobject;
	}
	public  void ScreenShot(String pagename) throws IOException
	{
		String FilePath = "src\\test\\resources\\"+ pagename;
		  TakesScreenshot camera = (TakesScreenshot)browserobject;
	      File screenshoot = camera.getScreenshotAs(OutputType.FILE);
	      Files.move(screenshoot , new File(FilePath));
	}


}
