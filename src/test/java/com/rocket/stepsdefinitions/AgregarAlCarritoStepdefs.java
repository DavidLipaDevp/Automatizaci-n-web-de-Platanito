package com.rocket.stepsdefinitions;

import com.rocket.steps.CarritoComprasSteps;
import com.rocket.steps.IniciarSesionSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgregarAlCarritoStepdefs {

    private WebDriver driver;
    private Scenario scenario;


    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }
    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }
    
    
    @Given("al ingresa a la pagina Platanitos")
    public void alIngresaALaPaginaPlatanitos() {
        driver.get("https://platanitos.com/");
        screenShot();
    }

    @When("hago clic en cuenta")
    public void hagoClicEnCuenta() {
        IniciarSesionSteps iniciarSesionSteps= new IniciarSesionSteps(driver);
        iniciarSesionSteps.clicCuenta();
        screenShot();
    }

    @And("inicia sesion con la cuenta {string} y la contraseña {string}")
    public void iniciaSesionConLaCuentaYLaContraseña(String usuario, String password) {
        IniciarSesionSteps iniciarSesionSteps = new IniciarSesionSteps(driver);
        iniciarSesionSteps.ingresoUsuario(usuario);
        iniciarSesionSteps.ingresoPassword(password);
        iniciarSesionSteps.iniciarSesion();
        screenShot();
    }

    @Then("Valido que deba aparecer el titulo {string}")
    public void validoQueDebaAparecerElTitulo(String titulo) {
        IniciarSesionSteps iniciarSesionSteps = new IniciarSesionSteps(driver);
        String title = iniciarSesionSteps.getTituloPerfil();

        Assert.assertEquals(titulo,title);

    }

    @And("valido que aparescar el nombre del titular {string}")
    public void validoQueAparescarElNombreDelTitular(String titular) {
        IniciarSesionSteps iniciarSesionSteps= new IniciarSesionSteps(driver);
        String titularReal = iniciarSesionSteps.getTitular();
        Assert.assertEquals(titular,titularReal);
        screenShot();
    }

    @When("hago clic en ofertas que se encuentra en destacados")
    public void hagoClicEnOfertasQueSeEncuentraEnDestacados() {
        CarritoComprasSteps carritoComprasSteps= new CarritoComprasSteps(driver);
        carritoComprasSteps.ingresarOfertas();
        screenShot();

    }
    @And("hago click en el banner de las ofertas")
    public void hagoClickEnElBannerDeLasOfertas() {
        CarritoComprasSteps carritoComprasSteps= new CarritoComprasSteps(driver);
        carritoComprasSteps.bannerDeOferta();
        screenShot();
    }

    @And("hago click en un articulo")
    public void hagoClickEnUnArticulo() {
        CarritoComprasSteps carritoComprasSteps= new CarritoComprasSteps(driver);
        carritoComprasSteps.articuloDeOferta();
        screenShot();
    }



    @And("hago click en agregar al carrito")
    public void hagoClickEnAgregarAlCarrito() {
        CarritoComprasSteps carritoComprasSteps= new CarritoComprasSteps(driver);
        carritoComprasSteps.agregarArticuloAlCarrito();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
        }
        screenShot();

    }

    @And("hago click al carrito de compras")
    public void hagoClickAlCarritoDeCompras() {
        CarritoComprasSteps carritoComprasSteps= new CarritoComprasSteps(driver);
        carritoComprasSteps.irAlCarrito();
        screenShot();
    }

    @Then("valido que deba aparecer como titulo {string}")
    public void validoQueDebaAparecerComoTitulo(String titulo) {
        CarritoComprasSteps carritoComprasSteps= new CarritoComprasSteps(driver);
        String tituloCarrito=carritoComprasSteps.getTituloCarrito();
        Assert.assertEquals(titulo,tituloCarrito);
    }

    @And("tambien valido que exista el articulo agregado")
    public void tambienValidoQueExistaElArticuloAgregado() {
        CarritoComprasSteps carritoComprasSteps= new CarritoComprasSteps(driver);
        int Articulos=carritoComprasSteps.getArticulos();
        Assert.assertTrue( "El tamaño de la lista es Articulos: " + Articulos,Articulos > 0);
        screenShot();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


}
