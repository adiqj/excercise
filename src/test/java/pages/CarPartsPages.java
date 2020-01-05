package pages;

import org.openqa.selenium.By;

public class CarPartsPages {

    public static final By moreParameters = By.id("show_more_filters");
    public static final By usage = By.id("subcategoryChooser");
    public static final By filterManufacturer = By.id("filter");
    public static final By counterAdvertisements = By.id("fragment_search_btn_counter");
    public static final By deliveryTrucks = By.xpath("*//android.widget.CheckedTextView[contains(text(),‘Części do pojazdów dostawczych’)]");

    public static final String deliveryTrucksS = "Części do pojazdów dostawczych";
    public static final String manufacturerS = "Marka pojazdu";
    public static final String partTypeS = "Rodzaj części";
    public static final String wheelsS = "Felgi";
    public static final String searchListS = "search_scroll_view";
    public static final String listManufacturer = "mainlist";

}
