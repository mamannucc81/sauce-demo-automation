package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";
    private final String errorMessage = "[data-test='error']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("https://www.saucedemo.com");
    }

    public void enterCredentials(String username, String password) {
        page.fill(usernameInput, username);
        page.fill(passwordInput, password);
    }

    public void clickLogin() {
        page.click(loginButton);
    }

    public String getErrorMessage() {
        return page.textContent(errorMessage);
    }

    public boolean isOnLoginPage() {
        return page.isVisible(loginButton);
    }
}
