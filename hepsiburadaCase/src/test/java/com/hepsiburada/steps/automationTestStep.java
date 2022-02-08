package com.hepsiburada.steps;

import com.hepsiburada.App;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;

public class automationTestStep {

    @Before
    public void launchtheWebsite() {

        App.LaunchWebsite("https://www.hepsiburada.com/");
        App.maximizeWindow();
    }

   @Given("set text")
    public void setText() {
        App.setInputByPlaceholder("Ürün, kategori veya marka ara","airpods pro");
    }


    @SneakyThrows
    @Given("Type the product name {string} into placeholder {string} and search")
    public void typeTheProductNameIntoPlaceholderAndSearch(String productName, String placeholder) {
        App.setInputByPlaceholder(placeholder,productName);
        Thread.sleep(5000);
        App.clickByTextToDiv("ARA");
    }

    @SneakyThrows
    @When("click the first product from the list")
    public void clickTheFirstProductFromTheList() {
        Thread.sleep(5000);
        App.clickByid("i0");
        Thread.sleep(5000);
        App.switchToNewTab();
        Thread.sleep(5000);
    }

    @SneakyThrows
    @And("Add the product to the basket")
    public void addTheProductToTheBasket() {
        Thread.sleep(5000);
        App.clickByid("addToCart");
        Thread.sleep(5000);
        App.clickByClassName("checkoutui-Modal-2iZXl",0);
        Thread.sleep(5000);
    }

    @SneakyThrows
    @Then("Add same product from different seller")
    public void addSameProductFromDifferentSeller() {
        Thread.sleep(5000);
        App.refreshThePage();
        App.clickByClassName("add-to-basket button small",0);
        Thread.sleep(6000);
        App.clickByClassName("checkoutui-Modal-2iZXl",0);
        Thread.sleep(5000);

    }

    @SneakyThrows
    @When("open the shopping cart")
    public void openTheShoppingCart() {
        Thread.sleep(5000);
        App.clickByid("shoppingCart");
        Thread.sleep(5000);
    }


    @SneakyThrows
    @Then("there should be {string} products in the basket with the product names {string}")
    public void thereShouldBeProductsInTheBasketWithTheProductNames(String numofProducts, String productName) {
        Thread.sleep(5000);
        App.verifyTextById("basket-item-count",numofProducts);
        Thread.sleep(5000);
        App.verifyByText(productName,Integer.parseInt(numofProducts));
        Thread.sleep(5000);
    }

    @SneakyThrows
    @And("Sellers should be different")
    public void sellersShouldBeDifferent() {
        Thread.sleep(5000);
        App.verifyTextByClassNotEqual();
        Thread.sleep(5000);
    }

    @SneakyThrows
    @Then("list other sellers all products")
    public void listOtherSellersAllProducts() {
        Thread.sleep(5000);
        App.clickByClassName("optionsLength",0);
        Thread.sleep(5000);
    }

    @SneakyThrows
    @When("add {string}. product of the other sellers to the basket")
    public void addProductOfTheOtherSellersToTheBasket(String index) {
        Thread.sleep(5000);
        App.clickByClassName("add-to-basket button",Integer.parseInt(index));
        Thread.sleep(5000);

    }

    @SneakyThrows
    @Then("Click {string}")
    public void click(String buttonName) {
        Thread.sleep(5000);
        App.clickWithContains(buttonName);
        Thread.sleep(5000);
    }

    @When("Back")
    public void back() {
        App.backToPreviousPage();
    }

    @After
    public void close() {
        App.close();
    }

}
