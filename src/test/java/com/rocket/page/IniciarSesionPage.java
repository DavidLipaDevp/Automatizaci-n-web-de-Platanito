package com.rocket.page;

import org.openqa.selenium.By;

public class IniciarSesionPage {
    public static By cuentaButton = By.id("ImgAccount");
    public static By usuarioInput = By.id("email");//xpath //input[@id='email']
    public static By passwordInput = By.id("password");//xpath //input[@id='password']
    public static By iniciarSesionButton = By.id("btn_submit");//button[@id='btn_submit']
    public static By titleCuenta = By.xpath("//h1[contains(text(),'Cuenta')]");
    public static By titularCuenta= By.xpath("//*[@id=\"body-cuenta\"]//p[@class=\"account-fullname\"]");

}
