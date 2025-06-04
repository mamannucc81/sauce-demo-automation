Feature: Proceso de pago
  Como usuario con producto en el carrito
  Quiero completar el proceso de pago
  Para poder comprar mis productos seleccionados

  Background:
    Given he iniciado login como "standard_user" con password "secret_sauce"
    And he añadido el producto "Sauce Labs Backpack" al carrito

  Scenario: Completar el proceso de compra
    When procedo al realizar el pago
    And ingreso la informacion de pago co el nombre "Marco", apellido "Mann", y el codigo postal "12345"
    And continua a la pagina de descripcion general
    And completo la compra
    Then se recibe un mensaje de confirmación "Thank you for your order!"