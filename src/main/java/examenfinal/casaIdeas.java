package examenfinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;
import org.junit.Assert;

public class casaIdeas {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Abrir la página web
        driver.get("https://www.casaideas.com.bo/");
        //driver.manage().window().maximize();
    }

    @Test
    public void testAgregarProductosAlCarrito() throws InterruptedException {
        try {
            // Esperar a que el modal con clase "modal show" esté visible
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal.show")));
            WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.name("60")));
            boton.click();

            // Agregar productos al carrito
            WebElement menuProductos = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//nav[@class='main-menu-navigator']//a[@href='#' and contains(text(),'PRODUCTOS')]")
            ));
            Actions actions = new Actions(driver);
            actions.moveToElement(menuProductos).perform();

            WebElement categoriaBuenPrecio = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//ul[contains(@class, 'mega-menu')]//a[span[text()='Buen Precio']]")
            ));
            categoriaBuenPrecio.click();
            Thread.sleep(3000);

            WebElement botonAgregar = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//button[contains(@name,'add_')])[1]")
            ));
            botonAgregar.click();
            System.out.println("✅ Primer producto agregado al carrito.");
            Thread.sleep(3000);

            // Volver al menú principal
            WebElement menuProductos2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(text(),'PRODUCTOS')]")
            ));
            actions.moveToElement(menuProductos2).perform();

            // Elegir otra categoría
            WebElement categoriaAlfombras = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href, '/alfombras/804')]")
            ));
            categoriaAlfombras.click();
            Thread.sleep(2000);

            WebElement segundoBotonAgregar = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//button[contains(@name,'add_')])[1]")
            ));
            segundoBotonAgregar.click();
            Thread.sleep(2000);
            System.out.println("✅ Segundo producto 'Categoria Alfombras' agregado al carrito.");

            // Validar los productos en el carrito
            WebElement cartIcon = driver.findElement(By.cssSelector("button.no-button.mini-cart-icon"));
            cartIcon.click();
            Thread.sleep(2000);

            WebElement ingresar = driver.findElement(By.cssSelector("button.btn.btn-sm.btn-primary.mr-2"));
            ingresar.click();
            Thread.sleep(2000);

            List<WebElement> productosEnCarrito = driver.findElements(By.cssSelector("span.pro-count.blue"));
            System.out.println("🛒 Cantidad de productos en el carrito: " + productosEnCarrito.size());
            Assert.assertEquals("❌ Error: Se esperaban 2 productos en el carrito", 2, productosEnCarrito.size());
            System.out.println("✅ Verificación exitosa: hay 2 productos en el carrito.");

            // Leer los montos de los productos y sumarlos
            List<WebElement> precios = driver.findElements(By.xpath("//td[@data-title='SUBTOTAL']/span"));
            double suma = 0.0;
            for (WebElement precio : precios) {
                String texto = precio.getText().replace("Bs.", "").replace(",", ".").trim();
                double valor = Double.parseDouble(texto);
                suma += valor;
            }
            System.out.println("🧮 Suma total de productos en el carrito: Bs. " + suma);
        } catch (TimeoutException e) {
            // Manejar excepción si no se encuentran elementos a tiempo
            System.out.println("El modal o el botón no están disponibles dentro del tiempo de espera.");
        }
        
      //4 INGRESAR PARA COMPLETAR LA COMPRA
		
		WebElement completarCompra = driver.findElement(By.cssSelector("button.btn.btn-primary.pagebuilder-column-1"));
		completarCompra.click();
		
		WebElement ingresoInvitado = driver.findElement(By.cssSelector("button.btn.btn-outline-primary.btn-block"));
		ingresoInvitado.click();
		Thread.sleep(3000); 

//ingresar los datos
	
		WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("juan@example.com");
        
        WebElement nombre = driver.findElement(By.name("firstname"));
        nombre.sendKeys("Juan");
        
        WebElement codigoCli = driver.findElement(By.name("code"));
        codigoCli.sendKeys("90439621");

        WebElement apellidoP = driver.findElement(By.name("lastname"));
        apellidoP.sendKeys("Lopez");
        
        WebElement apellidoM = driver.findElement(By.name("lastname2"));
        apellidoM.sendKeys("Gonzales");
		
        WebElement codigo = driver.findElement(By.name("phonecode"));
        codigo.sendKeys("12345");
		
        WebElement celular = driver.findElement(By.name("phone"));
        celular.sendKeys("77606379");
        
       
        WebElement ciudadInput = driver.findElement(By.id("formcity"));
        ciudadInput.click(); 
        ciudadInput.sendKeys("Santa Cruz"); 
        ciudadInput.sendKeys(Keys.ENTER);
        
        WebElement tipoDoc= driver.findElement(By.id("formtipodoc"));
        tipoDoc.click();
        tipoDoc.sendKeys("Cédula de Identidad"); 
        tipoDoc.sendKeys(Keys.ENTER);
		
        WebElement nroIden = driver.findElement(By.name("invoicenumber"));
        nroIden.sendKeys("90439621");
	
        WebElement razonSo = driver.findElement(By.name("invoicename"));
        razonSo.sendKeys("Antonio ZAS");
        
        WebElement botonSiguiente = driver.findElement(By.cssSelector("button.ml-2.btn.btn-md.btn-primary.shipping-form-btn"));
        botonSiguiente.click();
        
        //ENTREGA/ RETIRO
        
        WebElement botonsuc = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.primary-formitem.primary-formitem-active")));
        botonsuc.click();
        
        WebElement indicaciones =driver.findElement(By.xpath("//textarea[@name='additionalShippingInstructions']"));
        //indicaciones.clear(); 
        indicaciones.sendKeys("Por favor entregar entre las 2 y 4 pm. Timbre dañado.");
       
        WebElement checkbox = driver.findElement(By.id("checkterms_YES")); 
        if (!checkbox.isSelected()) {
            checkbox.click(); 
        }
		
        WebElement botonSiguiente2 = driver.findElement(By.cssSelector("button.btn.btn-md.btn-primary.shipping-form-btn"));
        botonSiguiente2.click();
        Thread.sleep(3000); 
		
        //metodo de pago
        WebElement metodoPago = driver.findElement(By.cssSelector("input[type='radio'][value='1']"));
        metodoPago.click();        
        
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        // Cierra el navegador después de unos segundos
        try {
            Thread.sleep(30000); // espera 30 segundos antes de cerrar el navegador
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
