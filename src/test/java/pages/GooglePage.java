package pages;

public class GooglePage extends BasePage{

    private String googleUrl = "https://www.google.com";
    private String searchButton = "//input[@value='Recherche Google']";
    private String acceptCookiesButton = "//*[@id=\"L2AGLb\"]";
    private String searchTextField = "//*[@id=\"APjFqb\"]";

    public GooglePage() {
        super(driver);
    }

    public void navigateToGoogle() {
        navigateTo(googleUrl);
    }

    public void clickAcceptCookies() {
        clickElement(acceptCookiesButton);
    }
    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }

}
