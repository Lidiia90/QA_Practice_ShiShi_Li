package tests_ui;

import config.ApplicationManager;
import enums.HeaderMenuItemsEn;
import org.testng.annotations.Test;
import pages.BasePage;
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