package steps;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ListPage;

import java.util.List;

public class ListSteps {
    //Pagina web https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html
    ListPage list = new ListPage();

    @Given("^I navigate to the list page$")
    public void navigateToListWeb(){
        list.navigateToPage();
    }


    @When("^I search (.+) in the list$")
    public void searchTheList(String state) throws InterruptedException {
        list.enterSearchCriteria(state);

    }

@Then("^I can find (.+) city in the list$")
    public void theTableisThere(String city) {
        List<String> lista = list.getALLsearchResult();
        boolean textisThere = lista.contains(city);
        if (textisThere) {
            System.out.println("The text is on the list: PASSED.");
        } else {
            throw new Error("The text is not on the list: FAILED.");
        }



    }


}
