package tests;

import org.testng.annotations.Test;
import steps.CarPartsSteps;
import steps.HomePageSteps;
import steps.SearchResultsSteps;
import utilities.BaseTest;

public class PartsTest extends BaseTest {

    @Test
    public void searchValidateResultsForMercedesBenzWheelsParts() {

        /*
        1. open app - home page Cars
        2. Go to Parts
        3. Unroll input fields
        4. Fill form with expected data for search - felgi, Mercedes Benz, track car
        5. Click to show search results
        6. Validate search results - if any results than PASS
         */

        HomePageSteps.goToPartsTabDriver();
        CarPartsSteps.rollOutSearchForm();
        CarPartsSteps.fillFormSearchWheelsPartsForMecedesBenz();
        CarPartsSteps.clickSearch();
        SearchResultsSteps.checkResulst();
    }


}
