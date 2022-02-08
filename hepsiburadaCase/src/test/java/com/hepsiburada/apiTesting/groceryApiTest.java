package com.hepsiburada.apiTesting;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

public class groceryApiTest {


    String jsonBody;
    String name,id,price,stock;
    int counter;
    String responseCode,endpoint;
    String jsonString;


    @Before
    public void runserver() throws IOException, InterruptedException {
        counter=0;
        Runtime.getRuntime().exec("cmd /c json-server --watch db.json");
        System.out.println("Server is started");
        Thread.sleep(5000);

    }


    @SneakyThrows
    @Given("connect to the server for {string}")
    public void connectToTheServerFor(String urlExtension) throws IllegalArgumentException {
        Thread.sleep(5000);
        RestAssured.baseURI= "http://localhost:3000/";

        RequestSpecification httpRequest = given();
        String value = ""+urlExtension;

        Thread.sleep(5000);
        Response response = httpRequest.get(value);
        Thread.sleep(5000);
        ResponseBody body = response.getBody();
        Thread.sleep(5000);
        jsonBody = body.asString();

        Thread.sleep(5000);
        System.out.println("status code is: " + response.getStatusCode());
        responseCode = String.valueOf(response.getStatusCode());

        Thread.sleep(5000);
        System.out.println("status line is: " + response.getStatusLine());

    }



    @SneakyThrows
    @When("{string} field is {string}")
    public void FieldIs(String attributeName,String grocery)  {


        if (attributeName.equals("price")){
            price=grocery;
        }
        else if (attributeName.equals("stock")){
            stock=grocery;
        }
        else if (attributeName.equals("id")){
            id = grocery;
        }
        else if (attributeName.equals("name")){
            name = grocery;
        }

        Thread.sleep(1000);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonBody);
        JSONArray jsonarray = (JSONArray)obj;

        for (int i = 0; i < jsonarray.size(); i++) {
           // System.out.println("jsonarray get("+i+") = "+jsonarray.get(i));

            JSONObject jsonObject = (JSONObject)jsonarray.get(i);
            String value =(String) jsonObject.get("name");

            if (value.equals(grocery)){
                name=  value;
                id =  jsonObject.get("id").toString();

                price = jsonObject.get("price").toString();

                stock= jsonObject.get("stock").toString();
                counter++;
            }

        }
        Thread.sleep(1000);
    }

    @Then("{string} should be {string}")
    public void shouldBe(String attribute, String value) {

        if (attribute.equals("price")){
            apiAutomation.verifyTextByEqual(price,value);

        }
       else if (attribute.equals("stock")){
            apiAutomation.verifyTextByEqual(stock,value);

        }
        else if (attribute.equals("id")){

            apiAutomation.verifyTextByEqual(id,value);

        }
        else if (attribute.equals("name")){

            apiAutomation.verifyTextByEqual(name,value);

        }
    }

    @When("status code is {string}")
    public void statusCodeIs(String code) {
        apiAutomation.verifyTextByEqual(code,responseCode);
    }

    @Then("operation is {string}")
    public void operationIs(String text) {
        if (responseCode.equals("200")){
            apiAutomation.verifyTextByEqual("success",text);
        }
       else if (responseCode.equals("400")){
            apiAutomation.verifyTextByEqual("Bad Request",text);
        }
        else if (responseCode.equals("404")){
            apiAutomation.verifyTextByEqual("Not Found",text);
        }

    }

    @Then("{string} should not be {string}")
    public void shouldNotBe(String attribute, String value) {

        if (attribute.equals("price")){
            apiAutomation.verifyTextByNotEqual(price,value);

        }
        else if (attribute.equals("stock")){
            apiAutomation.verifyTextByNotEqual(stock,value);

        }
        else if (attribute.equals("id")){

            apiAutomation.verifyTextByNotEqual(id,value);

        }
        else if (attribute.equals("name")){
            apiAutomation.verifyTextByNotEqual(name,value);

        }
    }

    @And("there should not be any data on returned array")
    public void thereShouldNotBeAnyDataOnReturnedArray() {
        apiAutomation.verifyTextIsEmpty(jsonBody);
    }


    @Given("create data with name as {string}, price as {string}, stock as {string}")
    public void createDataWithNameAsPriceAsStockAs( String nameVal,  String priceVal,  String stockVal) {

         jsonString = String.format(
                "{\"name\" : \"%1$s\",\"price\" : " + "%2$s" +",\"stock\" : " + "%3$s"+"}",
                nameVal, priceVal,stockVal);

        given()
                .baseUri("http://localhost:3000/data")
                .contentType(ContentType.ANY.JSON)
                .body(jsonString)
                .when()
                .post();

    }

    @Given("post data to the endpoint {string}")
    public void postDataToTheEndpoint(String endpointUrl) {

        endpoint =endpointUrl ;

    }
}
