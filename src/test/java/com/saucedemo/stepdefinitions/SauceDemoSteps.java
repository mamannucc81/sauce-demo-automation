package com.saucedemo.stepdefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.saucedemo.pages.*;
import com.saucedemo.utils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class SauceDemoSteps {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CarritoPage cartPage;
    private CheckoutPage checkoutPage;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = BrowserFactory.createBrowser(playwright);
        context = browser.newContext();
        page = context.newPage();
        loginPage = new LoginPage(page);
        productsPage = new ProductsPage(page);
        cartPage = new CarritoPage(page);
        checkoutPage = new CheckoutPage(page);
    }

    @After
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }

    @Given("estoy en la pagina de login de Sauce Demo")
    public void iAmOnTheSauceDemoLoginPage() {
        loginPage.navigate();
        assertTrue(loginPage.isOnLoginPage());
    }

    @When("ingreso username {string} y password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @And("hacer click en el boton Login")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("se redirigue a la pagina de productos")
    public void iShouldBeRedirectedToTheProductsPage() {
        assertTrue(productsPage.isOnProductsPage());
    }

    @Then("se recibe un mensaje de error {string}")
    public void iShouldSeeAnErrorMessage(String expectedMessage) {
        assertEquals(expectedMessage, loginPage.getErrorMessage());
    }

    @Given("he iniciado login como {string} con password {string}")
    public void iAmLoggedInAsWithPassword(String username, String password) {
        loginPage.navigate();
        loginPage.enterCredentials(username, password);
        loginPage.clickLogin();
        assertTrue(productsPage.isOnProductsPage());
    }

    @When("agrego el producto {string} al carrito")
    public void iAddTheProductToTheCart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @Then("debe mostrar {string} articulo")
    public void theCartBadgeShouldShowItem(String expectedCount) {
        assertEquals(expectedCount, productsPage.getCartItemCount());
    }

    @Then("el producto {string} deberia estar en el carrito")
    public void theProductShouldBeListedInTheCart(String productName) {
        productsPage.goToCart();
        assertTrue(cartPage.isProductInCart(productName));
    }

    @Given("he añadido el producto {string} al carrito")
    public void iHaveAddedTheProductToTheCart(String productName) {
        productsPage.addProductToCart(productName);
        assertEquals("1", productsPage.getCartItemCount());
    }

    @When("retirar el producto {string} desde carrito")
    public void iRemoveTheProductFromTheCart(String productName) {
        productsPage.removeProductFromCart(productName);
    }

    @Then("el carrito no deberia ser visible")
    public void theCartBadgeShouldNotBeVisible() {
        assertEquals("0", productsPage.getCartItemCount());
    }

    @When("procedo al realizar el pago")
    public void iProceedToCheckout() {
        productsPage.goToCart();
        cartPage.proceedToCheckout();
        assertTrue(checkoutPage.isOnCheckoutPage());
    }

    @And("ingreso la informacion de pago co el nombre {string}, apellido {string}, y el codigo postal {string}")
    public void iEnterCheckoutInformationWithFirstNameLastNameAndZipCode(String firstName, String lastName, String zipCode) {
        checkoutPage.enterCheckoutInformation(firstName, lastName, zipCode);
    }

    @And("continua a la pagina de descripcion general")
    public void iContinueToTheOverviewPage() {
        checkoutPage.continueToOverview();
    }

    @And("completo la compra")
    public void iCompleteThePurchase() {
        checkoutPage.completePurchase();
    }

    @Then("se recibe un mensaje de confirmación {string}")
    public void iShouldSeeTheConfirmationMessage(String expectedMessage) {
        assertEquals(expectedMessage, checkoutPage.getConfirmationMessage());
    }
}
