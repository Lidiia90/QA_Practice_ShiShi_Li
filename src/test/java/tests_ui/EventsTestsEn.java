package tests_ui;

import config.ApplicationManager;
import helpers.enums.HeaderMenuItemsEn;
import org.testng.annotations.Test;
import pages.EventsPageEn;
import pages.HomePageEn;

import static pages.BasePage.clickButtonsOnHeaderEn;

public class EventsTestsEn extends ApplicationManager {


    @Test
    public void startTest(){
        HomePageEn homePageEn = new HomePageEn(getDriver());
        EventsPageEn eventsPageEn = clickButtonsOnHeaderEn(HeaderMenuItemsEn.ACTIVITIES);
    }
}