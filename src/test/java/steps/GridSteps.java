package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.GridPage;

public class GridSteps {

    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage(){
        grid.navigateToGrid();
    }

    @Then("^I can return the value i wanted$")
    public void returnValue(){
        final String value = grid.getValueFromGrid(2,2);
        Assert.assertEquals("Item 5", value);
    }

    @Then("^I can validate the table is displayed$")
    public void isDisplayed(){
        final boolean isDisplayed = grid.cellStatus();
        Assert.assertTrue("El elemento si esta siendo mostrado!",isDisplayed);
    }
}
