Feature: Funcionalidad Login
  Como usuario de Sauce Demo
  Quiero iniciar sesión en la aplicación
  Para poder acceder a la pagina de productos

  Scenario: Login exitoso con credenciales validas
    Given estoy en la pagina de login de Sauce Demo
    When ingreso username "standard_user" y password "secret_sauce"
    And hacer click en el boton Login
    Then se redirigue a la pagina de productos

  Scenario: Login fallido con credenciales invalidas
    Given estoy en la pagina de login de Sauce Demo
    When ingreso username "invalid_user" y password "wrong_password"
    And hacer click en el boton Login
    Then se recibe un mensaje de error "Epic sadface: Username and password do not match any user in this service"

  Scenario: el usuario bloqueado no puede iniciar login
    Given estoy en la pagina de login de Sauce Demo
    When ingreso username "locked_out_user" y password "secret_sauce"
    And hacer click en el boton Login
    Then se recibe un mensaje de error "Epic sadface: Sorry, this user has been locked out."