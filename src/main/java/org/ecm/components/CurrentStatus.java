package org.ecm.components;

import org.ecm.utility.DriverManagerUtility;
import org.ecm.selectors.LandingPageSelectors;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CurrentStatus {

    private WebDriver driver;

    public CurrentStatus() {
        this.driver = DriverManagerUtility.getInstance().getDriver();
    }

    public String getStatusByComponentName(String componentName) {
        List<WebElement> systemRows = driver.findElements(By.cssSelector(LandingPageSelectors.ROW_ITEMS));
        // Row that contains the given component name
        WebElement matchingRow = systemRows.stream()
                .filter(row -> row.findElement(By.cssSelector(LandingPageSelectors.COMPONENT_NAME))
                        .getText().trim().equalsIgnoreCase(componentName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Component not found: " + componentName));
        return matchingRow.findElement(By.cssSelector(LandingPageSelectors.STATUS_ICON)).getText().trim();
    }
}
