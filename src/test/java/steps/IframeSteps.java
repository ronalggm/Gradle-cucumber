package steps;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.IframePage;

public class IframeSteps {
    IframePage iframeWiki=new IframePage();

   @Given("^I navigate to the webPage$")
    public void navigateToPageIframe(){
        iframeWiki.navigateToIframePage();
    }
@When("^I entry to the Iframe wikipedia$")
public void enterOnIframe(){
        iframeWiki.switchToiframe(0);
}
@And("^I enter a search chriteria$")
public void enterSearchCriteriaIframeWiki() {
iframeWiki.enterSearchCriteriaWiki();
    }
    @And("click on the search button of wikipedia")
    public void clickSearchButtonWikiPedia(){
       iframeWiki.ClickSearchButtonWiki();
    }
@Then("^result match the chriteria$")
    public void matchChriteria(){}
}
