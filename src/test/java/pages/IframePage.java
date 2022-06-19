package pages;

import static pages.BasePage.driver;

public class IframePage extends BasePage {
//----------------Locators

String locatorSearchwiki="//*[@id=\'searchInput\']",
        locatorButtonSearch="//*[@id='search-form']/fieldset/button";
//ok://*[@id='search-form']/fieldset/button/i
    public IframePage(){super(driver);}

//--------------------------Metodos----------------------------------------

    public void navigateToIframePage() {
navigateTo("https://automatenow.io/sandbox-automation-testing-practice-website/iframes/");
 }

public void enterInIframeWikiSearch() {
    switchToiframe(0);
}
public void enterSearchCriteriaWiki() {
    write(locatorSearchwiki,"washington");
}
public void ClickSearchButtonWiki(){
        clickElement(locatorButtonSearch);
}
}
