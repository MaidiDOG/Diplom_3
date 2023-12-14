import io.qameta.allure.junit4.DisplayName;

import org.junit.Assert;

import org.junit.Test;

import pages.ConstructorPage;



public class ConstructorTest extends BaseTestWithoutUser {
    @Test
    @DisplayName("Переход к разделу с начинкой")
    public void gotoFillingSectionTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.goToFillingSegment();
        Assert.assertTrue(page.isFillingSegmentDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу соусы из раздела с начинкой")
    public void gotoSauceSectionTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.goToFillingSegment();
        page.goToSauceSegment();
        Assert.assertTrue(page.isSauceSegmentDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу булок из раздела с соусами")
    public void gotoBunSectionTest() {
        ConstructorPage page = new ConstructorPage(driver);
        page.goToSauceSegment();
        page.goToBunSegment();
        Assert.assertTrue(page.isBunSegmentDisplayed());
    }
}
