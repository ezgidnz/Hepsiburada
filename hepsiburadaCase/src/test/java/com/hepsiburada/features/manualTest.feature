Feature:  Kullanıcı girişi yapılarak sepete ürün eklenmesi - Manual Test Cases

  @Manual
  @TestCase-001
  Scenario: Successfully login with email address and add products to the basket
    Given Open Hepsiburada webpage and click "Giriş Yap"
    When enter a valid email adress registered on the system
    Then click "Giriş Yap"
    When enter the correct password
    Then Main page should be displayed to the user
    When Type "airpods pro" to the search bar
    Then click and open the first product from the list
    When click "Sepete Ekle" and add the product to the basket
    Then Stay on current product's page and Refresh
    When check "Diğer Satıcılar" part and click "Sepete Ekle" for same product from a different seller
    Then go to Shopping Cart , verify that Sellers are different
    And following information should be displayed on Cart page
     | Sepetim 2 ürün |


  @Manual
  @TestCase-002
  Scenario:Successfully login with the phone number
    Given Open Hepsiburada webpage and click "Giriş Yap"
    When enter a valid phone number
    And Enter validation code that is sent to the mobile phone
    Then enter the correct password
    And Main page should be displayed to the user


  @Manual
  @TestCase-003
  Scenario:Try to login to the system with not registered phone number
    Given Open Hepsiburada webpage and click "Giriş Yap"
    When enter a phone number that is not registered to the system before
    Then following error message should be displayed on the screen
      | Telefon numarası eksik veya hatalı. | Girdiğiniz telefon numarası ile herhangi bir hesabı eşleştiremedik, kontrol edip tekrar deneyin. |


  @Manual
  @TestCase-004
  Scenario:Try to login to the system with noncompleted phone number
    Given Open Hepsiburada webpage and click "Giriş Yap"
    When  enter a nonvalid phone number to the system before like "0539"
    Then following error message should be displayed on the screen
      | Geçerli bir cep telefonu girmelisiniz.  |



  @Manual
  @TestCase-005
  Scenario: Try to login system with correct email but wrong password
    Given Open Hepsiburada webpage and click "Giriş Yap"
    When enter a valid email adress registered on the system
    Then click "Giriş Yap"
    When user enters wrong password
    Then following error message should be displayed on the screen
      | Girdiğiniz şifre eksik veya hatalı. | Kontrol edip tekrar deneyin. |


  @Manual
  @TestCase-006
  Scenario: Try to login system with never registered email address
    Given Open Hepsiburada webpage and click "Giriş Yap"
    When enter an email that is not registered to the system before like "eezgidenizdeniz@gmail.com"
    Then following error message should be displayed on the screen
      | E-posta adresi eksik veya hatalı. | Girdiğiniz bilgiler ile herhangi bir hesabı eşleştiremedik, kontrol edip tekrar deneyin. |


  @Manual
  @TestCase-007
  Scenario: Try to login system with a non-valid email adress
    Given Open Hepsiburada webpage and click "Giriş Yap"
    When enter a not valid email adress like "eezgi"
    Then following error message should be displayed on the screen
      | Geçerli bir e-posta adresi girmelisiniz |


  @Manual
  @TestCase-008
  Scenario: Try to login system with a social media account
    Given Open Hepsiburada webpage and click "Giriş Yap"
    When click "Google ile Giriş yap"
    And Enter your email acocunt information correctly
    Then Main page should be displayed to the user
