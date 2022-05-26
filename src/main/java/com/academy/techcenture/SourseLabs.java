package com.academy.techcenture;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SourseLabs {

    private static final String URL = " https://www.saucedemo.com/";

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //visit the page
        driver.get(URL);

        String title = driver.getTitle();

        if (title.equals("Swag Labs")) {
            System.out.println("Title is correct");
        } else {
            System.out.println("Page title is not correct");
        }

        WebElement loginLogo = driver.findElement(By.className("login_logo"));
        if (loginLogo.isDisplayed()) {
            System.out.println("Login Logo is displayed!");
        } else {
            System.out.println("Login Logo is NOT displayed!");
        }
        WebElement loginBotPicture = driver.findElement(By.className("bot_column"));
        if (loginBotPicture.isDisplayed()) {
            System.out.println("Picture is displayed!");
        } else {
            System.out.println("Picture is NOT displayed!");
        }

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        if(driver.getTitle().equals("Swag Labs")){

        System.out.println( "Log in Title is correct. ");
        }else{
            System.out.println("Log in Title is not correct");
        }


        WebElement titleProducts = driver.findElement(By.className("title"));
        if (driver.findElement(By.className("title")).equals("PRODUCTS")) {
            System.out.println("Products Title is correct");
        } else {
            System.out.println("Product Title is NOT correct");
        }

        driver.findElement(By.id("react-burger-menu-btn")).click();


        List<WebElement> menuItems = driver.findElements(By.xpath("//a[@class='bm-item menu-item']"));
        String[] menuOptions = {"all items", "about", "logout", "reset app state"};
        for (int i = 0; i < menuItems.size(); i++) {
            boolean menuItemCorrect = menuItems.get(i).getText().trim().toLowerCase().equals(menuOptions[i]);
            if (!menuItemCorrect) {
                System.out.println("Incorrect menu item: " + menuOptions[i]);
            }
        }

        driver.findElement(By.id("about_sidebar_link")).click();

        if(driver.getTitle().equals("Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs")){
            System.out.println("The title of the new tab is correct");
        }else{
            System.out.println("The title  of the new tab is NOT correct");
        }
//
        driver.navigate().back();

        WebElement closeMenu = driver.findElement(By.id("react-burger-cross-btn"));
        if(closeMenu.isDisplayed()) {
            closeMenu.click();
        }

        List<WebElement> inventoryElements = driver.findElements(By.className("inventory_item_name"));

        if(inventoryElements.size()==6){
            System.out.println("There are 6 products displayed");
        }else{
            System.out.println("6 products are NOT displayed");
        }

        driver.findElement(By.className("product_sort_container")).click();

        driver.findElement(By.xpath("//option[@value='lohi']")).click();

        List<WebElement> inventoryPrices = driver.findElements(By.className("inventory_item_price"));
            boolean firstPrice = inventoryPrices.get(0).getText().trim().equals("$7.99");
            boolean lastPrice = inventoryPrices.get(inventoryPrices.size()-1).getText().trim().equals("$49.99");
        if(firstPrice && lastPrice){
            System.out.println("The prices of the first and last items are correct");
        }else{
            System.out.println("The prices of the first and last items are NOT correct");
        }

        driver.findElement(By.linkText("Sauce Labs Onesie")).click();

       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        WebElement onesieTitle = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']"));


        WebElement onesieDescription = driver.findElement(By.xpath("//div[@class='inventory_details_desc large_size']"));

        WebElement onesiePrice = driver.findElement(By.xpath("//div[@class='inventory_details_price']"));


        boolean addToCartBtn = driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).isDisplayed();

        if(onesieTitle.getText().equals("Sauce Labs Onesie") && onesieDescription.getText().equals("Rib snap infant onesie for the junior automation engineer in development." +
               " Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.")
                && onesiePrice.isDisplayed() && addToCartBtn){
           System.out.println("All elements are correct");

        }else{
            System.out.println("Elements are NOT correct");
        }

        if(driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText().equals("$7.99")){
            System.out.println("Price is $7.99");
        }else{
            System.out.println("Price is NOT $7.99");
        }

       WebElement clickBtn =  driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));

        clickBtn.click();

        if(clickBtn.getText().equals("REMOVE")){
            System.out.println("ADD Btn has changed to REMOVE Btn");
        }else{
            System.out.println("ADD Btn has NOT changed to REMOVE Btn");
        }

        driver.findElement(By.className("shopping_cart_link")).click();
        if(driver.findElement(By.className("title")).isDisplayed()){
            System.out.println("My cart Header is displayed");
        }else{
            System.out.println("My cart header is NOT displayed");
        }
        if(driver.findElement(By.xpath("//div[@class='cart_quantity']")).getText().equals("1")){
            System.out.println("Quantity is equals to 1");
        }else{
            System.out.println("Quantity is not equal to 1");
        }

        if(driver.findElement(By.id("checkout")).isEnabled()){
            System.out.println("Checkout Btn is enabled");
        }else{
            System.out.println("Checkout Btn is NOT enabled");
        }

        driver.findElement(By.id("checkout")).click();

        Faker faker = new Faker();
        String lastName = faker.name().lastName();
        String firstName = faker.name().firstName();
        String zipCode = faker.address().zipCode().substring(0, 5);

        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);

        WebElement continueBtn = driver.findElement(By.id("continue"));
        if(continueBtn.isEnabled()){
            System.out.println("Continue Btn is enabled");
            continueBtn.click();
        }else{
            System.out.println("Continue Btn is NOT enabled");
        }
        if(driver.findElement(By.className("title")).isDisplayed()){
            System.out.println("Checkout title is displayed");
        }else{
            System.out.println("Checkout title is NOT displayed");
        }

        WebElement paymentInfo = driver.findElement(By.xpath("//div[contains(text(),'SauceCard #31337')]"));
       if(paymentInfo.isDisplayed()){
           System.out.println(paymentInfo.getText());
       }else{
           System.out.println("Payment info is not displayed");
       }

        WebElement deliveryInfo = driver.findElement(By.xpath("//div[contains(text(),'FREE PONY EXPRESS DELIVERY!')]"));

       if(deliveryInfo.equals("FREE PONY EXPRESS DELIVERY!")){
           System.out.println("Shipping info is correct");
       }
       else{
           System.out.println("Shipping info in not correct");
       }





    }
}
