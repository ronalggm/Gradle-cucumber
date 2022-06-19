package pages;


public class GridPage extends BasePage {

    //--------------Locators------------------
    private String locatorCell = "//table[@id='customers']";

    private String mainTable = "//table[@id='customers']";

    public GridPage() {
        super(driver);
    }


    //--------------Metodos-----------------


    public void navigateToGrid() {
        navigateTo("https://www.w3schools.com/html/html_tables.asp");
    }

    // Obtener valor de la tabla:
    public String getValueFromGrid(int row, int column) {
        return getValueFromTable(locatorCell, row, column);
    }

    public boolean cellStatus() {
        return elementIsDsiplayed(mainTable);
    }



}
