package steps;





import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();


    @Given("^I am on the Google search app$")//Dado que

    public void navigateToGoogle() {

        google.navigateToGoogle();


    }


    @When("^I enter a search criteria$") // cuando (utilizamos para hacer el caso de prueba)
    public void enterSearchCriteria() {

        google.enterSearchCriteria("Google");

    }


    @And("^click on the search button$") //Y (Son los pasos dentro del caso de prueba)
    public void clickSearchButton() {

        google.clickGoogleSearch();


    }


    @Then("^the result match the criteria$")  //Entonces  (Realizamos las validaciones con Junit)
    public void validateResults() {
        Assert.assertEquals("Googles", google.firstResult());

    }

}

