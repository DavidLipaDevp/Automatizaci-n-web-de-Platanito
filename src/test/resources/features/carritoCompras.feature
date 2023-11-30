@TestRegresivo
Feature: Carrito de compra de platanito
  @AgregarAlCarrito
  Scenario: Agregar un articulo en el carrito de compras
    Given al ingresa a la pagina Platanitos
    When hago clic en cuenta
    And inicia sesion con la cuenta "cancer123david@Gmail.com" y la contraseña "Lipa_159"
    Then Valido que deba aparecer el titulo "Cuenta"
    And valido que aparescar el nombre del titular "David Rafael Lipa Huarcaya"
    When hago clic en ofertas que se encuentra en destacados
    And hago click en el banner de las ofertas
    And hago click en un articulo
    And hago click en agregar al carrito
    And hago click al carrito de compras
    Then valido que deba aparecer como titulo "Carrito"
    And tambien valido que exista el articulo agregado