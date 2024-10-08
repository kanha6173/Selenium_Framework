package commonLibs.implementation;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IScreenshot;


public class ScreenshotControl implements IScreenshot{
	private TakesScreenshot camera;
	public ScreenshotControl(WebDriver driver) {
		camera = (TakesScreenshot) driver;
	}
	@Override
	public void captureAndSaveScreenshot(String pathfile) throws Exception {
		
		pathfile =pathfile.trim();
		File imgfile , tmpfile;
		imgfile = new File(pathfile);
		if (imgfile.exists()) {
			throw new Exception("Image with this file already exist..");	
		}
		tmpfile = camera.getScreenshotAs(OutputType.FILE);
	}

}
