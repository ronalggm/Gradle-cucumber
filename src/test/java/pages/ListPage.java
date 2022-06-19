package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage {

    //-------------------Locators------------------------
    private String searchField = "//body/form[1]/input[1]";  //Locator campo de busqueda
    private String searchResult = "name";// este locator es de tipo name ya que es el mas indicado para este ejemplo

    //-------------Cosntructor-----------------------------
    public ListPage() {
        super(driver);
    }

    //------------Metodos de la pagina---------------------------
    public void navigateToPage() {
        navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }

//----------------Ingresar el criterio de busqueda------------------------------
    public void enterSearchCriteria(String state) throws InterruptedException {
        Thread.sleep(600);
        write(searchField, state);
    }
//--------------Recolectar los textos de la lista de web elements---------------
    public List<String> getALLsearchResult() {
        List<WebElement> list = bringMeAllElements(searchResult);
        List<String> stringsFromList = new ArrayList<String>();
        for (WebElement e : list) {
            stringsFromList.add(e.getText());
        }
        return stringsFromList;
    }

}
