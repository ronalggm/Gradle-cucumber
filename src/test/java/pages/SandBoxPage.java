package pages;

import org.openqa.selenium.WebDriver;

public class SandBoxPage extends BasePage {
//--------------------------Atributos Locators

    private String categoryDropDown = "//select[@name='fields[programming_language]']";
    private String valueOfSandbox = "java";

//-----------------------------------------------------------------------------------------
    public SandBoxPage() {
        super(driver);
    }
//-------------------Metodos------------------

    public void navigateToSandBoxPage() {

        navigateTo("http://elementalselenium.com");
    }

    public void selectElementOfSandBox() {
        selectFromDropdownByValue(categoryDropDown, valueOfSandbox); //seleccion de texto visible

    }


}
