Feature: Api testing

  @Automation
  @TestCase-001
  Scenario: GET - Get Stock - price info from server according to Name of the user
    Given connect to the server for "data/"
    When "name" field is "apple"
    Then "price" should be "3"
    And "stock" should be "100"
    When "name" field is "grapes"
    Then "price" should be "5"
    And "stock" should be "50"


  @Automation
  @TestCase-002
  Scenario: GET - success operation
    Given connect to the server for "data/"
    When status code is "200"
    Then operation is "success"


  @Automation
  @TestCase-003
  Scenario: GET - negative case
    Given connect to the server for "data/"
    When "name" field is "apple"
    Then "price" should not be "2"
    When "name" field is "grapes"
    Then "stock" should not be "55"


  @Automation
  @TestCase-004
  Scenario: GET - endpoint that returns according to name apple
    Given connect to the server for "data?name=apple"
    When "name" field is "apple"
    Then "price" should be "3"
    And "stock" should be "100"
    And "id" should be "1"


  @Automation
  @TestCase-005
  Scenario: GET - endpoint that returns according to name grapes
    Given connect to the server for "data?name=grapes"
    When "name" field is "grapes"
    Then "price" should be "5"
    And "stock" should be "50"
    And "id" should be "2"


  @Automation
  @TestCase-006
  Scenario: GET - negative case with wrong numbers except id
    Given connect to the server for "data?name=grapes"
    When "name" field is "grapes"
    Then "price" should not be "7"
    And "stock" should not be "100"
    And "id" should be "2"

  @Automation
  @TestCase-007
  Scenario: GET - success operation for data?name=grapes this url
    Given connect to the server for "data?name=grapes"
    When status code is "200"
    Then operation is "success"

  @Automation
  @TestCase-008
  Scenario: GET - call a data that is not exist from url
    Given connect to the server for "data?name=cherry"
    When status code is "200"
    Then operation is "success"
    And there should not be any data on returned array


  @Automation
  @TestCase-009
  Scenario: POST - the data to the endpoint
    Given post data to the endpoint "http://localhost:3000/data"
    When create data with name as "watermelon", price as "2", stock as "20"
    Then connect to the server for "data?name=watermelon"
    When "name" field is "watermelon"
    Then "price" should be "2"
    And "stock" should not be "100"
    And "id" should be "3"


#  @Manual
#  @TestCase-010
#  Scenario: Bad Request
#    Given connect to the server for "data/"
#    When status code is "400"
#    Then operation is "Bad Request"#

#  @Manual
#  @TestCase-011
#  Scenario: Not Found Request
#    Given connect to the server for "data/"
#    When status code is "404"
#    Then operation is "Not Found"



