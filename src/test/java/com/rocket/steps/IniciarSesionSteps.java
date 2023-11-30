package com.rocket.steps;

import com.rocket.page.IniciarSesionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IniciarSesionSteps {


    private WebDriver driver;

    public IniciarSesionSteps(WebDriver driver){
        this.driver = driver;
    }


    public  String getTituloPerfil() {
        return  this.driver.findElement(IniciarSesionPage.titleCuenta).getText();
    }
    public  String getTitular() {
        return this.driver.findElement(IniciarSesionPage.titularCuenta).getText();
    }

    public void clicCuenta(){this.driver.findElement(IniciarSesionPage.cuentaButton).click();}

    public void ingresoUsuario(String usuario) {
        WebElement userInputElement = driver.findElement(IniciarSesionPage.usuarioInput);
        userInputElement.sendKeys(usuario);
        espera(IniciarSesionPage.iniciarSesionButton);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
        }
    }

    public void ingresoPassword(String password) {
        this.driver.findElement(IniciarSesionPage.passwordInput).sendKeys(password);
    }

    public void iniciarSesion() {
        try {
            Thread.sleep(1000);
        }catch (Exception e){
        }
        this.driver.findElement(IniciarSesionPage.iniciarSesionButton).click();
    }

    public void espera(By by){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
