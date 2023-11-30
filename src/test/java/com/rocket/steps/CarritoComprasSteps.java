package com.rocket.steps;

import com.rocket.page.CarritoComprasPage;
import com.rocket.page.IniciarSesionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CarritoComprasSteps {
    private WebDriver driver;

    public CarritoComprasSteps(WebDriver driver){
        this.driver = driver;
    }

    public void ingresarOfertas() {
        this.driver.findElement(CarritoComprasPage.ofertasButton).click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
        }
    }

    public void bannerDeOferta() {
        espera(CarritoComprasPage.bannerOferta);

        this.driver.findElement(CarritoComprasPage.bannerOferta).click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
        }

    }
    public void articuloDeOferta() {

        espera(CarritoComprasPage.articuloButton);
        this.driver.findElement(CarritoComprasPage.articuloButton).click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
        }
    }


    public void agregarArticuloAlCarrito() {
        espera(CarritoComprasPage.agregarAlCarritoButton);
        this.driver.findElement(CarritoComprasPage.agregarAlCarritoButton).click();
    }

    public void irAlCarrito() {
        this.driver.findElement(CarritoComprasPage.irAlCarritoButton).click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
        }
    }

    public String getTituloCarrito() {
            return  this.driver.findElement(CarritoComprasPage.tituloCarrito).getText();
        }

    public int getArticulos() {
        List<WebElement> items = this.driver.findElements(CarritoComprasPage.itemsCards);
        return items.size();
    }
    public void espera(By by){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


}

