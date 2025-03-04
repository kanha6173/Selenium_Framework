package commonLibs.contracts;

public interface IDriver {
	public void navigateToFirstUrl(String url)throws Exception;
    public String getTitle()throws Exception;
    public String getCurrentUrl()throws Exception;
    public String getPageSource()throws Exception;
    public void navigateToUrl(String url)throws Exception;
    public void navigateForword()throws Exception;
    public void navigateBackword()throws Exception;
    public void refresh()throws Exception;
    public void closeBrowser()throws Exception;
    public void closeAllBrowser()throws Exception;
}
