package commonLibs.implementation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commonLibs.contracts.IDropDown;

public class IDropControl implements IDropDown {
	private Select getSelect(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	@Override
	public void selectVisibleText(WebElement element, String visibleText) throws Exception {
		getSelect(element).selectByVisibleText(visibleText);
	}

	@Override
	public void selectViaValue(WebElement element, String value) throws Exception {
		getSelect(element).selectByValue(value);

	}

	@Override
	public void selectViaIndex(WebElement element, int index) throws Exception {
		getSelect(element).selectByIndex(index);

	}

	public List<WebElement> getAllOptions(WebElement element) {
		
		return getSelect(element).getOptions();
	}

}
