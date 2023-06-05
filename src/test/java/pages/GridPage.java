package pages;

public class GridPage extends BasePage{

    private String cell = "/html[1]/body[1]/p[8]/table[1]";

    public GridPage() {
        super(driver);
    }

    public void navigateToGrid(){
        navigateTo("https://www.uv.es/jac/guia/tablaeje.htm");
    }

    public String getValueFromGrid(int row, int column){
        return getValueFromTable(cell, row, column);
    }
}
