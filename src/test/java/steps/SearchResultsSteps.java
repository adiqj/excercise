package steps;

import pages.SearchResultsPages;
import utilities.AndroidModel;

public class SearchResultsSteps {

    public static void checkResulst() {
        AndroidModel.findElementBy(SearchResultsPages.searchListResults);
    }
}
