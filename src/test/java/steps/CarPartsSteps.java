package steps;

import pages.CarPartsPages;
import utilities.AndroidModel;

public class CarPartsSteps {

    public static final String MERCEDES_BENZ = "Mercedes-Benz";

    public static void rollOutSearchForm() {
        AndroidModel.findElementBy(CarPartsPages.moreParameters).click();
    }

    public static void fillFormSearchWheelsPartsForMecedesBenz() {
        AndroidModel.findElementBy(CarPartsPages.usage).click();
        AndroidModel.findElementByText(CarPartsPages.deliveryTrucksS).click();
        AndroidModel.findElementByText(CarPartsPages.manufacturerS).click();
        AndroidModel.sendText(CarPartsPages.filterManufacturer, "Mercedes");
        AndroidModel.scrollToText(MERCEDES_BENZ).click();
        AndroidModel.swipeDown();
        AndroidModel.findElementByText(CarPartsPages.partTypeS).click();
        AndroidModel.findElementByText(CarPartsPages.wheelsS).click();
    }

    public static void clickSearch() {
        AndroidModel.findElementBy(CarPartsPages.counterAdvertisements).click();
    }
}
