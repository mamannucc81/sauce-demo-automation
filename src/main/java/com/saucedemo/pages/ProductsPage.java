package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class ProductsPage {
    private final Page page;
    private final String productTitle = ".title";
    private final String addToCartButton = "button[id^='add-to-cart']";
    private final String removeButton = "button[id^='remove']";
    private final String shoppingCartBadge = ".shopping_cart_badge";
    private final String shoppingCartLink = ".shopping_cart_link";

    public ProductsPage(Page page) {
        this.page = page;
    }

    public boolean isOnProductsPage() {
        return page.textContent(productTitle).equals("Products");
    }

    public void addProductToCart(String productName) {
        String buttonId = "add-to-cart-" + productName.toLowerCase().replace(" ", "-");
        page.click("#" + buttonId);
    }

    public void removeProductFromCart(String productName) {
        String buttonId = "remove-" + productName.toLowerCase().replace(" ", "-");
        page.click("#" + buttonId);
    }

    public String getCartItemCount() {
        return page.isVisible(shoppingCartBadge) ? page.textContent(shoppingCartBadge) : "0";
    }

    public void goToCart() {
        page.click(shoppingCartLink);
    }
}
