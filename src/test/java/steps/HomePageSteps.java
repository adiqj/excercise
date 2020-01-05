package steps;

import pages.HomeCarsPages;
import utilities.AndroidModel;

public class HomePageSteps {

    public static void goToPartsTabDriver() {
        AndroidModel.findElementByText(HomeCarsPages.czesciBtnName).click();
    }
}
