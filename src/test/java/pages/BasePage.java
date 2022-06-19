package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//                           Metodos de acciones genericas de selenium
public class BasePage {

    //-------------------Atributos--------------------------------------------------------
    protected static WebDriver driver;
    private Actions action; //sirve para cliquear sobre elementos de dropdown
    private static WebDriverWait wait;
//-----------------------Bloque Estatico de instanciamiento-------------------------

    static { // Sirve para inicializar chrome options, webDriver en otras clases que extiendan de esta
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));


    }
    //--------------------------------------------------------------------------------------


    //--------------------------Constructor de esta clase----------------------
    public BasePage(WebDriver driver) {  //Constructor de esta Clase

        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));//esepera 10 segundo
    }


    //--------------------------------Metodos Acciones con selenium-----------------------------------

    //--------------- Navegar a una pagina --1
    public static void navigateTo(String url) {

        driver.get(url);
    }

    //---------------Buscar un elemento de la pagina  --2
    //El web element es el que siempre va a tener la mayoria de las acciones
    private WebElement find(String locator) {   //EL Web Element es el que siempre va a tener la mayoria de las
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        /*Espera hasta que encuentre el elemento o sino espera los 10 segundos que le indicamos arriba
        (Es una espera explicita)*/
    }
    //--------------------- Clickear un elemento --3
    public void clickElement(String locator) {
        find(locator).click();
    }
    //----------------------Escribir --4-------------------------
    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }
    //------------------Seleccionar un DropDown (Lista desplegable)----------------------------
    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));


        dropdown.selectByValue(valueToSelect);
    }

    //-----------------------------------------------------------------------------------------
    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(find(locator));


        dropdown.selectByIndex(valueToSelect);
    }
    //---------------------------------------------------------------------------------

    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));

//Este metodo selecciona la posicion del elemento que queremos a través del texto visible
        dropdown.selectByVisibleText(valueToSelect);

    }
//---------------------------------------------------------------------------------------


    public void hoverOverElement(String locator) { //Sirve para pasar el cursor sobre el elemento

        action.moveToElement(find(locator));
    }
//--------------------------------------------------------------------------------------------

    public void doubleClick(String locator) {

        action.doubleClick(find(locator));
    }
//--------------------------------------------------------------------------------------------

    public void rightClick(String locator) {
        action.contextClick(find(locator));

    }
//------------------------------------------------------------------------------------------------

    //Sirve para obtener valores de las tablas
    public String getValueFromTable(String locator, int row, int column) {
        String cellIneed = locator + "/tbody/tr[" + row + "]/td[" + column + "]";
        return find(cellIneed).getText();


    }

    //-----------------------------------------------------------------------------------------------
//Sirve para escribir texto dentro de una celda editable
    public void setValueOnTable(String locator, int row, int column, String StringToSend) {
        String cellToFill = locator + "tbody/tr[" + row + "]/td[" + column + "]";
        find(cellToFill).sendKeys(StringToSend);
    }


    //-------------------------------Iframes-------------------------------------------------
    public void switchToiframe(int iFrameIndex) {

        driver.switchTo().frame(iFrameIndex);
    }
    //----------------------------------------------------------------------------------------------------
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }
    //Metodo para salir del iframe que hayamos seleccionado:
    public void exitFrame(){
        driver.switchTo().defaultContent();
    }
    //---------------------------------Metodo para cerrar Alertas---------------------------------------------------------------------
    public void dismmissAlert() {

        driver.switchTo().alert().dismiss();
    }

    //-------------------------Obtener texto de un webElement------------------------------------
    public String textFromElement(String locator) {
        return find(locator).getText();
    }

    //-------------------Verificadores de elementos-------------------------------------------------
    public boolean elementIsDsiplayed(String locator) {
        return find(locator).isDisplayed();
        // varifica Si el elemento está o no nos devuelve un true, si no esta es un false

    }

    //---------------------------------------------------------------------------------------------------------------
    public boolean elementIsEnabled(String locator) {
        //verifica que un boton se ecuentra habilitado para ser cliqueado

        return find(locator).isEnabled();
    }

    //----------------------------------------------------------------------------------------
    public boolean elementIsSelected(String locator) {
        //Verifica que el elemento esta seleccionado, por ejemplo si un radioButton esta seleccionado
        return find(locator).isSelected();
    }

    //-----------------Obtener todos los WebElements de una lista------------------------
    public List<WebElement> bringMeAllElements(String locator) {
        //Metodo para obtener una lista de WebElements
        return driver.findElements(By.className(locator)); /*Seleccionamos el locator className
         ya que para este ejemplo es el mas indicado*/
    }

    //--------------------Cerrar eL Browser---------------------------------------------
    public static void closeBrowser(){
        driver.quit();
    }
}