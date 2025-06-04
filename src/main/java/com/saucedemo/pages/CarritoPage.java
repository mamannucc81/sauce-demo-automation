package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class CarritoPage {
    private final Page page;
    private final String cartTitle = ".title";
    private final String checkoutButton = "#checkout";
    private final String cartItem = ".cart_item";

    public CarritoPage(Page page){
        this.page = page;
    }

    public boolean isOnCartPage() {
        return page.textContent(cartTitle).equals("Your Cart");
    }

    public boolean isProductInCart(String productName) {
        return page.isVisible("text=" + productName);
    }

    public void proceedToCheckout() {
        page.click(checkoutButton);
    }
}
