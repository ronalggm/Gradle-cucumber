package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.GridPage;

public class GridTestSteps {
    GridPage grid = new GridPage();

    @Given("^I navigate to the table$")
    public void navigateToGridPage() {
        grid.navigateToGrid();

    }

    //-----------Validaciones------------------------------------------
    @Then("^I can return the value i wanted$")
    public void returnValue() {
        final String value = grid.getValueFromGrid(2, 1);

        Assert.assertEquals("Alfreds Futterkiste", value);

    }

    @Then("^I can validate the table is displayed$")
    public void theTableIsThere() {
        Assert.assertTrue("El elemento esta siendo mostrado", grid.cellStatus());

    }

}
