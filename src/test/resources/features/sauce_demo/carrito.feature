Feature: Funcionalidad carrito de compras
  Como usuario conectado
  Quiero agregar los productos en mi carrito de compras
  Para poder prepararme para el pago

  Background:
    Given he iniciado login como "standard_user" con password "secret_sauce"

  Scenario: Añadir producto al carrito
    When agrego el producto "Sauce Labs Backpack" al carrito
    Then debe mostrar "1" articulo
    And el producto "Sauce Labs Backpack" deberia estar en el carrito

  Scenario: Quitar el producto desde carrito
    Given he añadido el producto "Sauce Labs Backpack" al carrito
    When retirar el producto "Sauce Labs Backpack" desde carrito
    Then el carrito no deberia ser visible