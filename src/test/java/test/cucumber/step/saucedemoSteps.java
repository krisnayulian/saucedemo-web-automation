package test.cucumber.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class saucedemoSteps {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user on login page saucedemo")
    public void user_on_login_page_saucedemo() {
        System.setProperty("webdriver.chrome.driver", "/home/krisna/github/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver (options);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo'][contains(.,'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("user input in field username {string}")
    public void user_input_in_field_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user input in field password {string}")
    public void user_input_in_field_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("user click button login")
    public void user_click_button_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("user successfully login")
    public void user_successfully_login() {
        //assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[@class='app_logo'][contains(.,'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("user see error login message")
    public void userSeeErrorLoginMessage() {
        WebElement element = driver.findElement(By.xpath("//h3[contains(.,'Epic sadface: Username and password do not match any user in this service')]"));
        element.isDisplayed();
    }

    @Given("user on home page")
    public void user_on_home_page() {
        try {
            // Kode yang mungkin menyebabkan NullPointerException
            WebElement element = driver.findElement(By.id("//div[@class='app_logo'][contains(.,'Swag Labs')]"));
            element.isEnabled();
        } catch (NullPointerException e) {
            // Penanganan kesalahan
            System.out.println("Elemen tidak ditemukan atau objek null.");
        }
    }

    @When("user click filter product by price low to high")
    public void userClickFilterProductByPriceLowToHigh() {
        driver.findElement(By.xpath("//select[contains(@class,'product_sort_container')]")).click();
        driver.findElement(By.xpath("//option[@value='lohi'][contains(.,'Price (low to high)')]")).click();
    }

    @Then("user see product from price low to high")
    public void userSeeProductFromPriceLowToHigh() {
        driver.findElement(By.xpath("//div[@class='inventory_item_price'][contains(.,'$7.99')]")).isDisplayed();

    }

    @When("user choose Sauce Labs Onesie")
    public void user_choose_sauce_labs_onesie() {
        WebElement element = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        element.click();
    }

    @And("user choose Sauce Labs Bike Light")
    public void user_choose_sauce_labs_bike_light() {
        try {
            // Kode yang mungkin menyebabkan NullPointerException
            WebElement element = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
            element.click();
        } catch (NullPointerException e) {
            // Penanganan kesalahan
            System.out.println("Elemen tidak ditemukan atau objek null.");
        }
    }

    @And("user choose Sauce Labs Backpack")
    public void user_choose_sauce_labs_backpack() {
        try {
            // Kode yang mungkin menyebabkan NullPointerException
            WebElement element = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            element.click();
        } catch (NullPointerException e) {
            // Penanganan kesalahan
            System.out.println("Elemen tidak ditemukan atau objek null.");
        }
//        WebElement element = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
//        element.click();
    }

    @Then("user see three products in icon basket")
    public void user_see_three_products_in_icon_basket() {
        try {
            // Kode yang mungkin menyebabkan NullPointerException
            WebElement element = driver.findElement(By.xpath("//a[@class='shopping_cart_link'][contains(.,'3')]"));
            element.isDisplayed();
        } catch (NullPointerException e) {
            // Penanganan kesalahan
            System.out.println("Elemen tidak ditemukan atau objek null.");
        }
//        WebElement element = driver.findElement(By.xpath("//a[@class='shopping_cart_link'][contains(.,'3')]"));
//        element.click();
    }

    @When("user remove Sauce Labs Onesie")
    public void userRemoveSauceLabsOnesie() {
        driver.findElement(By.xpath("//button[@name='remove-sauce-labs-onesie']")).click();
    }

    @Then("user see two products in icon basket")
    public void userSeeTwoProductsInIconBasket() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link'][contains(.,'2')]")).isDisplayed();
    }

    @When("user click icon basket")
    public void userClickIconBasket() {
        driver.findElement(By.xpath("//div[@class='shopping_cart_container']")).click();
    }

    @And("user remove Sauce Labs Bike Light")
    public void userRemoveSauceLabsBikeLight() {
        driver.findElement(By.xpath("//button[@name='remove-sauce-labs-bike-light']")).click();
    }

    @And("user remove Sauce Labs Backpack")
    public void userRemoveSauceLabsBackpack() {
        driver.findElement(By.xpath("//button[@name='remove-sauce-labs-backpack']")).click();
    }

    @Then("user click button checkout")
    public void userClickButtonCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("user input in field firstname {string}")
    public void userInputInFieldFirstname(String firstname) {
        driver.findElement(By.id("first-name")).sendKeys(firstname);
    }

    @And("user input in field lastname {string}")
    public void userInputInFieldLastname(String lastname) {
        driver.findElement(By.id("last-name")).sendKeys(lastname);
    }

    @And("user input in field postalcode {string}")
    public void userInputInFieldPostalcode(String postalcode) {
        driver.findElement(By.id("postal-code")).sendKeys(postalcode);
    }

    @And("user see total price")
    public void userSeeTotalPrice() {
        driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).isDisplayed();
    }

    @And("user click button finish")
    public void userClickButtonFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @And("user successfully orders")
    public void userSuccessfullyOrders() {
        driver.findElement(By.xpath("//h2[contains(.,'Thank you for your order!')]")).isDisplayed();
    }

    @And("user click button back home")
    public void userClickButtonBackHome() {
        driver.findElement(By.xpath("//button[contains(.,'Back Home')]")).click();
    }

    @And("user click button continue")
    public void userClickButtonContinue() {
        driver.findElement(By.id("continue")).click();
    }
}
