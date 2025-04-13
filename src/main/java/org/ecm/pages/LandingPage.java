package org.ecm.pages;

import org.ecm.components.CurrentStatus;
import org.ecm.selectors.LandingPageSelectors;
import org.ecm.utility.ConfigUtils;
import org.ecm.utility.DriverManagerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LandingPage {

    private WebDriver driver;
    private CurrentStatus currentStatus = new CurrentStatus();

    /**
     * Constructor of this class
     */
    public LandingPage() {
        this.driver = DriverManagerUtility.getInstance().getDriver();
    }

    /**
     * Method used to verify the landing page
     */
    public void verifyLandingPage() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, ConfigUtils.getPropertyByKey("landingPageTitle"));
        System.out.println("Verified page title as : " + actualTitle);
    }

    /**
     * Method used to navigate to given page
     * @param pageName
     */
    public void navigateToPage(String pageName) {
        driver.get(ConfigUtils.getPropertyByKey("servicePageUrl") + "/" + pageName);
        System.out.println("Navigates to " + pageName + " page");
    }

    /**
     * Method used to click on the System Status
     */
    public void clickOnSystemStatus() {
        driver.findElement(By.cssSelector(LandingPageSelectors.SYSTEM_STATUS)).click();
        String currentWindow = driver.getWindowHandle();
        // Switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.findElement(By.cssSelector(LandingPageSelectors.CURRENT_STATUS)).isDisplayed();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, ConfigUtils.getPropertyByKey("systemStatusPageTitle"));
        System.out.println("New window title: " + driver.getTitle());
    }

    /**
     * Method used to Verify the current status
     * @param compName
     * @param expStatus
     */
    public void verifyCurrentStatus(String expStatus, String compName) {
        String actualStatus = currentStatus.getStatusByComponentName(compName);
        Assert.assertEquals(actualStatus, expStatus);
        System.out.println("Current Status for " + compName + " is " + actualStatus);
    }
}
