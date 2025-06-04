package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
    private final Page page;
    private final String checkoutTitle = ".title";
    private final String firstNameInput = "#first-name";
    private final String lastNameInput = "#last-name";
    private final String zipCodeInput = "#postal-code";
    private final String continueButton = "#continue";
    private final String finishButton = "#finish";
    private final String confirmationMessage = ".complete-header";

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public boolean isOnCheckoutPage() {
        return page.textContent(checkoutTitle).equals("Checkout: Your Information");
    }

    public void enterCheckoutInformation(String firstName, String lastName, String zipCode) {
        page.fill(firstNameInput, firstName);
        page.fill(lastNameInput, lastName);
        page.fill(zipCodeInput, zipCode);
    }

    public void continueToOverview() {
        page.click(continueButton);
    }

    public void completePurchase() {
        page.click(finishButton);
    }

    public String getConfirmationMessage() {
        return page.textContent(confirmationMessage);
    }
}
