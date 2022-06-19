package pages;

/*
En esta pagina creamos los metodos de las acciones que querramos hacer pero llamando
a los metodos genericos de selenium, y los nombreamos por sus acciones,
por ejemplo el metodo generico clickButton en esta pagina lo llamaremos clickGoogleSearch .


 */

public class GooglePage extends BasePage {

    //---------------Atributos Locators---------- Los locators siempre ban en las Clases de Paginas
    //
    // /* variable que almacena el xpath botón : Buscar con google:  */
    private String searchButton = "//input[@value='Buscar con Google']";

    /* variable que almacena el locator xpath del campo de busqueda: B:  */
    private String searchTextField = "//input[@title='Buscar']";
    private String firstResult = "//h3[text()='Google']";

    //------------------Constructor------------------------------
    public GooglePage() {
        super(driver);
    }
//------------------------------------------------------------------------

    //-----------------Metodos-----------------------------------------

    //-----------Navegar a google
    public void navigateToGoogle() {
        navigateTo("https://www.google.com");

    }

    //------------Dar click en el boton de google search-------------
    public void clickGoogleSearch() {
        clickElement(searchButton);

    }

    //---------------Ingresar un criterio de busqueda-------------
    public void enterSearchCriteria(String criteria) {
        write(searchTextField, criteria);

    }

    public String firstResult() {
        return textFromElement(firstResult);
    }
}

