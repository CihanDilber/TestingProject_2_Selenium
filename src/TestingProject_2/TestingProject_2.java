package TestingProject_2;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestingProject_2 extends BaseDriver {


    @Test
    public void Test1() {
        driver.get("http://demowebshop.tricentis.com/");

        Actions actions = new Actions(driver);

        WebElement register = driver.findElement(By.linkText("Register"));
        Action action = actions.moveToElement(register).click().build();
        action.perform();

        WebElement gender = driver.findElement(By.id("gender-male"));
        action = actions.moveToElement(gender).click().build();
        action.perform();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        action = actions.moveToElement(firstName).click().sendKeys("Name").build();
        action.perform();

        WebElement lastName = driver.findElement(By.id("LastName"));
        action = actions.moveToElement(lastName).click().sendKeys("Surname").build();
        action.perform();

        WebElement eMail = driver.findElement(By.id("Email"));
        // Test esnasında her defasında mail değiştirmemek için random mail oluşturma satırı
        action = actions.moveToElement(eMail).click().sendKeys("testing" + ((int) (Math.random() * 10000)) + "@testing.com").build();
        // Normal şartlarda sabit duracak olan mail oluşturma satırı :
        // action = actions.moveToElement(eMail).click().sendKeys("testing@testing.com").build();
        action.perform();

        WebElement password = driver.findElement(By.id("Password"));
        action = actions.moveToElement(password).click().sendKeys("password").build();
        action.perform();

        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        action = actions.moveToElement(confirmPassword).click().sendKeys("password").build();
        action.perform();

        WebElement registerButton = driver.findElement(By.id("register-button"));
        action = actions.moveToElement(registerButton).click().build();
        action.perform();

        WebElement confirmation = driver.findElement(By.className("result"));

        Assert.assertEquals("Your registration completed", confirmation.getText());

        // Test 2'de yeniden register işlemi yapılacağından logout yapıldı.
        WebElement logout = driver.findElement(By.linkText("Log out"));
        action = actions.moveToElement(logout).click().build();
        action.perform();

    }

    @Test
    public void Test2() {
        driver.get("http://demowebshop.tricentis.com/");

        Actions actions = new Actions(driver);

        WebElement register = driver.findElement(By.linkText("Register"));
        Action action = actions.moveToElement(register).click().build();
        action.perform();

        WebElement gender = driver.findElement(By.id("gender-male"));
        action = actions.moveToElement(gender).click().build();
        action.perform();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        action = actions.moveToElement(firstName).click().sendKeys("Name").build();
        action.perform();

        WebElement lastName = driver.findElement(By.id("LastName"));
        action = actions.moveToElement(lastName).click().sendKeys("Surname").build();
        action.perform();

        WebElement eMail = driver.findElement(By.id("Email"));
        action = actions.moveToElement(eMail).click().sendKeys("testing@testing.com").build();
        action.perform();

        WebElement password = driver.findElement(By.id("Password"));
        action = actions.moveToElement(password).click().sendKeys("password").build();
        action.perform();

        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        action = actions.moveToElement(confirmPassword).click().sendKeys("password").build();
        action.perform();

        WebElement registerButton = driver.findElement(By.id("register-button"));
        action = actions.moveToElement(registerButton).click().build();
        action.perform();

        WebElement confirmation = driver.findElement(By.xpath("//li[text()='The specified email already exists']"));

        Assert.assertEquals("The specified email already exists", confirmation.getText());
    }

    @Test
    public void Test3() {
        driver.get("http://demowebshop.tricentis.com/");

        Actions actions = new Actions(driver);

        WebElement login = driver.findElement(By.linkText("Log in"));
        Action action = actions.moveToElement(login).click().build();
        action.perform();

        WebElement eMail = driver.findElement(By.id("Email"));
        action = actions.moveToElement(eMail).click().sendKeys("testing8567@testing.com").build();
        action.perform();

        WebElement password = driver.findElement(By.id("Password"));
        action = actions.moveToElement(password).click().sendKeys("password").build();
        action.perform();

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        action = actions.moveToElement(loginButton).click().build();
        action.perform();

        WebElement logout = driver.findElement(By.linkText("Log out"));

        Assert.assertTrue(logout.isDisplayed());

        // Test 4'de yeniden login işlemi yapılacağından logout yapıldı.
        action = actions.moveToElement(logout).click().build();
        action.perform();
    }

    @Test
    public void Test4() {
        driver.get("http://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.linkText("Log in"));
        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(login).click().build();
        action.perform();

        WebElement eMail = driver.findElement(By.id("Email"));
        // Hatalı mail girişi istendiğinden random mail oluşturma satırı
        action = actions.moveToElement(eMail).click().sendKeys("testing" + ((int) (Math.random() * 10000)) + "@testing.com").build();
        action.perform();

        WebElement password = driver.findElement(By.id("Password"));
        action = actions.moveToElement(password).click().sendKeys("password" + ((int) (Math.random() * 10000))).build();
        action.perform();

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        action = actions.moveToElement(loginButton).click().build();
        action.perform();

        WebElement confirmation = driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));

        Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.", confirmation.getText());
    }

    @Test
    public void Test5() {
        driver.get("http://demowebshop.tricentis.com/");

        Actions actions = new Actions(driver);

        Duration duration=Duration.ofSeconds(30);
        WebDriverWait wait=new WebDriverWait(driver, duration);

        WebElement login = driver.findElement(By.linkText("Log in"));
        Action action = actions.moveToElement(login).click().build();
        action.perform();

        WebElement eMail = driver.findElement(By.id("Email"));
        action = actions.moveToElement(eMail).click().sendKeys("testing8567@testing.com").build();
        action.perform();

        WebElement password = driver.findElement(By.id("Password"));
        action = actions.moveToElement(password).click().sendKeys("password").build();
        action.perform();

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        action = actions.moveToElement(loginButton).click().build();
        action.perform();

        WebElement computers = driver.findElement(By.linkText("COMPUTERS"));
        action = actions.moveToElement(computers).build();
        action.perform();

        WebElement notebooks = driver.findElement(By.linkText("Notebooks"));
        action = actions.moveToElement(notebooks).click().build();
        action.perform();

        WebElement notebook14Inch = driver.findElement(By.xpath("(//div[@class='details']//following::a)[1]"));
        action = actions.moveToElement(notebook14Inch).click().build();
        action.perform();

        WebElement laptopAddToCart = driver.findElement(By.id("add-to-cart-button-31"));
        action = actions.moveToElement(laptopAddToCart).click().build();
        action.perform();

        WebElement confirmation = driver.findElement(By.xpath("//p[text()='The product has been added to your ']"));

        Assert.assertTrue(confirmation.getText().contains("The product has been added to your"));

        WebElement shoppingCart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        action = actions.moveToElement(shoppingCart).click().build();
        action.perform();

        WebElement notebook14InchControl = driver.findElement(By.xpath("(//a[text()='14.1-inch Laptop'])[2]"));

        Assert.assertTrue(notebook14InchControl.getText().contains("14.1-inch Laptop"));

        WebElement agree = driver.findElement(By.id("termsofservice"));
        action = actions.moveToElement(agree).click().build();
        action.perform();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        action = actions.moveToElement(checkoutButton).click().build();
        action.perform();

        WebElement newAddressMenu = driver.findElement(By.id("billing-address-select"));
        Select newAdresSelectMenu = new Select(newAddressMenu);
        newAdresSelectMenu.selectByVisibleText("New Address");

        WebElement countryMenu = driver.findElement(By.name("BillingNewAddress.CountryId"));
        Select countrySelectMenu = new Select(countryMenu);
        countrySelectMenu.selectByValue("77");

        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
        action=actions.moveToElement(city).click().sendKeys("Ankara").build();
        action.perform();

        WebElement address1= driver.findElement(By.id("BillingNewAddress_Address1"));
        action = actions.moveToElement(address1).click().sendKeys("Kavaklıdere").build();
        action.perform();

        WebElement zipCode = driver.findElement(By.name("BillingNewAddress.ZipPostalCode"));
        action=actions.moveToElement(zipCode).click().sendKeys("06000").build();
        action.perform();

        WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        action=actions.moveToElement(phoneNumber).click().sendKeys("060123456789").build();
        action.perform();

        WebElement continueButtonBillingAddress=driver.findElement(By.xpath("(//input[@title='Continue'])[1]"));
        action=actions.moveToElement(continueButtonBillingAddress).click().build();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@title='Continue'])[1]")));
        action.perform();

        WebElement continueButtonShippingAddress=driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
        action=actions.moveToElement(continueButtonShippingAddress).click().build();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='Shipping.save()']")));
        action.perform();

        WebElement continueButtonShippingMethod=driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));
        action=actions.moveToElement(continueButtonShippingMethod).click().build();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='ShippingMethod.save()']")));
        action.perform();

        WebElement moneyOrder=driver.findElement(By.id("paymentmethod_1"));
        action=actions.moveToElement(moneyOrder).click().build();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentmethod_1")));
        action.perform();

        MyFunc.Bekle(3);
        WebElement continueButtonPaymentMethod=driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        action=actions.moveToElement(continueButtonPaymentMethod).click().build();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='PaymentMethod.save()']")));
        action.perform();

        WebElement continueButtonPaymentInformation=driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));
        action=actions.moveToElement(continueButtonPaymentInformation).click().build();
        MyFunc.Bekle(3);
        action.perform();

        WebElement confirmOrderButton=driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        action=actions.moveToElement(confirmOrderButton).click().build();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='ConfirmOrder.save()']")));
        action.perform();

        WebElement lastConfirmation=driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));

        Assert.assertEquals("Your order has been successfully processed!", lastConfirmation.getText());

        BekleKapat();


        //WebElement email = driver.findElement(By.id("Email"));
        //action = actions.moveToElement(email).click().sendKeys("c.kabakkk@gmail.com").build();
        //action.perform();
        //// c.kabakkk@gmail.com


        //WebElement password = driver.findElement(By.id("Password"));
        //action = actions.moveToElement(password).click().sendKeys("123456").build();
        //action.perform();


        //WebElement login2 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        //action = actions.moveToElement(login2).click().build();
        //action.perform();

        //WebElement log_out = driver.findElement(By.linkText("Log out"));
        //System.out.println("confirmation.getText() = " + log_out.getText());

        //Assert.assertTrue(log_out.isDisplayed());

        //action = actions.moveToElement(log_out).click().build();
        //action.perform();
    }

}
