package org.ecm.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ecm.pages.LandingPage;

/**
 * LandingPageSteps : Step definition class contains steps related Landing Page
 *
 * @author Abhishek Arora
 * @since  26-03-2025
 */

public class LandingPageSteps {

    private LandingPage landingPage = new LandingPage();

    /**
     *
     * Step definition used to verify user is on Landing Page
     *
     */
    @Given("^the user is on Landing page$")
    public void userOnLandingPage() {
        landingPage.verifyLandingPage();
    }

    /**
     *
     * Step definition used to navigate to given page
     *
     * @param pageName
     */
    @And("^the user navigates to (.*) page$")
    public void navigateToPage(String pageName) {
        landingPage.navigateToPage(pageName);
    }

    /**
     *
     * Step definition used to click on System Status
     */
    @When("^the user clicks on System Status$")
    public void clickOnSystemStatus() {
        landingPage.clickOnSystemStatus();
    }

    /**
     * Step definition used to verify System Status
     * @param status
     * @param compName
     */
    @Then("^the user verifies the System Status as (.*) for component (.*)$")
    public void VerifyStatus(String status, String compName) {
        landingPage.verifyCurrentStatus(status, compName);
    }
}
