Feature: Kullanıcı girişi yapılmadan belirtilen ürünü sepete ekleme

  @Automation
  @TestCase-01
  Scenario: Add the product to the basket without login
    Given Type the product name "airpods pro" into placeholder "Ürün, kategori veya marka ara" and search
    When click the first product from the list
    And Add the product to the basket
    Then Add same product from different seller
    When open the shopping cart
    Then there should be "2" products in the basket with the product names "Apple AirPods"
    And Sellers should be different

  @Automation
  @TestCase-02
  Scenario: Add the product to the basket without login with listing other sellers
    Given Type the product name "airpods pro" into placeholder "Ürün, kategori veya marka ara" and search
    When click the first product from the list
    Then list other sellers all products
    When add "1". product of the other sellers to the basket
    Then Click "Sepete git"
    And there should be "1" products in the basket with the product names "Apple AirPods"
    When Back
    Then Add the product to the basket
    When open the shopping cart
    Then there should be "2" products in the basket with the product names "Apple AirPods"
    And Sellers should be different