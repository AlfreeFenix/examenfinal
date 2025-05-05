package testng;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
import java.util.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TestShop {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    // Para contar los tests:
    int totalProductos = 0;
    int contador = 0;

    @BeforeTest()
    public void before() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-infobars");
        option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver();
        driver.get("https://www.casaideas.com.bo/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        // Selección de una ciudad
        WebElement botonCiudad = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("button[value='59']")));
        botonCiudad.click();

        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState").equals("complete"));
    }

    @DataProvider(name = "productos")
    public Object[][] productos() {
        Object[][] datos = {
            {"add__21016"},
            {"add__19740"},
            {"add__21018"}
        };
        totalProductos = datos.length;
        return datos;
    }

    @Test(dataProvider = "productos", description = "Agregar un producto al carrito")
    public void testAgregarProducto(String nombreBoton) {

        // Abrir menú de productos
        WebElement menuProductos = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[contains(.,'PRODUCTOS')]")));
        actions.moveToElement(menuProductos).perform();

        WebElement buenPrecioLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[span[normalize-space()='Buen Precio']]")));
        buenPrecioLink.click();

        // Agregar el producto actual
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@name='" + nombreBoton + "']")));
        addToCartButton.click();

        WebElement cartMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(text(),'Agregado Correctamente al carro')]")));
        Assert.assertEquals(cartMessage.getText(), "Agregado Correctamente al carro",
            "El producto con botón '" + nombreBoton + "' no se agregó correctamente.");

        // Incrementar contador y, si es el último producto, ir al carrito
        contador++;
        if (contador == totalProductos) {
            abrirCarritoYCompletarCompra();
        }
    }

    private void abrirCarrito() {
        WebElement botonCarrito = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("button.mini-cart-icon")));
        botonCarrito.click();
        
    }

    private void abrirCarritoYCompletarCompra() {
        // Abrir carrito de compras
        abrirCarrito();

        // Hacer clic en el botón para completar la compra
        WebElement botonCompletarCompra = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("button.btn.btn-sm.btn-primary.mr-2")));
        botonCompletarCompra.click();

    }
    
    @Test(dependsOnMethods = "testAgregarProducto", description = "Validar que el subtotal coincide con la suma de productos")
    public void validarSubtotalCarrito() {
        // Esperar y obtener todos los precios individuales
        List<WebElement> precios = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
            By.cssSelector("td.col-text-right[data-title='SUBTOTAL'] span")));

        double sumaCalculada = 0.0;
        for (WebElement precio : precios) {
            String texto = precio.getText().replace("Bs.", "").trim().replace(",", ".");
            sumaCalculada += Double.parseDouble(texto);
        }

        // Obtener subtotal mostrado
        WebElement subtotalFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("div.col-5.flex.items-right.text-right > div > b")));

        String subtotalTexto = subtotalFinal.getText().replace("Bs.", "").trim().replace(",", ".");
        double subtotalEnPagina = Double.parseDouble(subtotalTexto);

        // Validar
        System.out.println("Subtotal mostrado: " + subtotalEnPagina);
        System.out.println("Suma calculada: " + sumaCalculada);

        Assert.assertEquals(sumaCalculada, subtotalEnPagina, 0.01, "El subtotal calculado no coincide con el mostrado");
   
        clickCompletarPago();
        
        validarFormulario();
        
        validarBotonFinalizarPedido();
    }
    
    private void clickCompletarPago() {
        WebElement botonCompletarPago = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("button.btn.btn-primary.pagebuilder-column-1")));
        botonCompletarPago.click();
        
        WebElement botonInvitado = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Continuar como invitado')]")));
            botonInvitado.click();
    }
    
    private void validarFormulario() {
    	String email = "pruebas-cegos@gmail.com";
    	String codigoCliente = "24561311";
    	String nombre = "Paola Andrea";
    	String apellidoPat = "Urquidi";
    	String apellidoMat = "Qa";
    	String celular = "47778562";
    	String ci = "7854785";
    	String complemento = "80";
    	String razonSocial = "CEGOS";
   
    	// Validar campo de email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("formemail")));
        emailField.clear();
        emailField.sendKeys(email);
        
        // Validar campo de código de cliente (CI)
        WebElement codigoClienteField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("formcode")));
        codigoClienteField.clear();
        codigoClienteField.sendKeys(codigoCliente);
        
        // Validar campo de nombre
        WebElement nombreField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("formfirstname")));
        nombreField.clear();
        nombreField.sendKeys(nombre);
        
     // Validar campo de apellido Paterno
        WebElement apellidoPatField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("formlastname")));
        apellidoPatField.clear();
        apellidoPatField.sendKeys(apellidoPat);
        
     // Validar campo de apellido Materno
        WebElement apellidoMatField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("formlastname2")));
        apellidoMatField.clear();
        apellidoMatField.sendKeys(apellidoMat);
        
     // Validar campo de Celular
        WebElement celularField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("formphone")));
        celularField.clear();
        celularField.sendKeys(celular);
        
      // Validar campo tipo de documento "CEDULA DE IDENTIDAD > ID:1":
        WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formtipodoc")));
        Select tipoDocumento = new Select(selectElement);
        tipoDocumento.selectByValue("1");
        
      // Validar campo Numero de Identificacion:
        WebElement CIField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("forminvoicenumber")));
            CIField.clear();
            CIField.sendKeys(ci);
        
      // Validar campo Complemento:
        WebElement complementoField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("formcomplemento")));
            complementoField.clear();
            complementoField.sendKeys(complemento);
                
      // Validar campo Razón Social:
        WebElement razonField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("forminvoicename")));
            razonField.clear();
            razonField.sendKeys(razonSocial);
            
      //Click en el boton Siguiente:
        WebElement botonSiguiente = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.shipping-form-btn")));
            botonSiguiente.click();
            
      //Hacer un check a Terminos y Condiciones:
        WebElement checkboxTerminos = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("checkterms_YES")));
             if (!checkboxTerminos.isSelected()) {
                    checkboxTerminos.click();
                }
            
      //Click en el boton Siguiente despues de Recojo en Tienda:
        WebElement botonRecojoSiguiente = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Siguiente')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonRecojoSiguiente);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botonRecojoSiguiente);  
           
        //Click en el checkbox "Pago al momento de Entrega":
        WebElement radioPagoEntrega = wait.until(ExpectedConditions.elementToBeClickable(
        	    By.cssSelector("input[type='radio'][name='m1'][value='1']")));
        	radioPagoEntrega.click();
        	
    }
    
    private void validarBotonFinalizarPedido() {
            
            WebElement botonFinalizar = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='row']//button[@name='close']")));

            // Verificar si el botón es visible
            Assert.assertTrue(botonFinalizar.isDisplayed(), "El botón 'Finalizar Pedido' no está visible.");
            System.out.println("✅ El botón 'Finalizar Pedido' está visible.");

            // Verificar el texto del botón
            String textoBoton = botonFinalizar.getText();
            Assert.assertEquals(textoBoton, "Finalizar Pedido", "El texto del botón no es correcto.");
            System.out.println("✅ El texto del botón es correcto: " + textoBoton);
            
    }

    @AfterTest()
    public void after() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}

//Examen Final: Paola Andrea Delgado Lopez.


