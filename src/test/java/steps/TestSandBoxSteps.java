package steps;




import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.SandBoxPage;

public class TestSandBoxSteps {

    SandBoxPage sandBox = new SandBoxPage();



    @Given("^I navigate to the sandbox page$")

    public void navigateToSandbox() {

        sandBox.navigateToSandBoxPage();
    }

    @And("^select a value from the dropdown$")

    public void SelectCategory() {
sandBox.selectElementOfSandBox();

    }


}
