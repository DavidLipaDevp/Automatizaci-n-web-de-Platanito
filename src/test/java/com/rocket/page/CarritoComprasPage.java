package com.rocket.page;

import org.openqa.selenium.By;

public class CarritoComprasPage {

    public static By ofertasButton = By.xpath("//a[@href=\"/ofertas\"]") ;

    public static By bannerOferta = By.id("banner-principal");
    public static By articuloButton =By.xpath("//a[@data-position=\"2\"]");


    public static By agregarAlCarritoButton = By.id("btn_add_cart_full");
    public static By irAlCarritoButton = By.id("ImgCar");
    public static By tituloCarrito = By.xpath("//h1[contains(text(),'Carrito')]");

    //"//div[@class=\"nd-pr-box__summary\"]//div[@class=\"row\"]//a" //path para localizar nombre de item

    public static By itemsCards = By.xpath("//p[@class=\"fw-semibold\"]"); // nombre de articulo
}
