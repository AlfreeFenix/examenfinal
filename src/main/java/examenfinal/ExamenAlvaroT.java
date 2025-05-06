package examenfinal;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class ExamenAlvaroT {

	 WebDriver driver;
	    WebDriverWait wait;

	    double precio1 = 0, precio2 = 0, precio3 = 0, precio4 = 0;

	    @BeforeMethod
	    public void iniciar() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        driver.get("https://www.casaideas.com.bo/");

	        // SELECCIÓN DE CIUDAD EN LA VENTANA EMERGENTE
	        try {
	            WebElement btnCochabamba = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("//button[@name='61' and text()='COCHABAMBA']")));
	            btnCochabamba.click();
	        } catch (Exception e) {
	            System.out.println("Modal de ciudad no apareció.");
	        }
	    }

	    @Test
	    public void realizarCompraCompleta() {
	        try {
	            // PRODUCTO 1: TACITA DE SILICONA PARA BEBÉ
	            navegarSubMenu("NIÑOS", "Bebé");
	            precio1 = obtenerPrecioYAgregar("21419_C_3228289000024");

	            // PRODUCTO 2: BOWL DE SILICONA ANTIDESLIZANTE PARA BEBÉ 11,6X4,9 CM
	            navegarSubMenu("NIÑOS", "Bebé");
	            precio2 = obtenerPrecioYAgregar("20933_C_3225657000112");

	            // PRODUCTO 3: SET DE 6 PINCELES DE TÉMPERA 24 ML
	            navegarSubMenu("NIÑOS", "Juguetería");
	            precio3 = obtenerPrecioYAgregar("19731");

	            // PRODUCTO 4: MESA LATERAL 2 NIVELES DE BAMBÚ 40X40X50 CM
	            navegarSubMenu("MUEBLES", "Mesas");
	            precio4 = obtenerPrecioYAgregar("20583");

	            // -------- VERIFICO QUE ESTE EL BOTON DEL CARRITO, PARTE SUPERIOR DER.  ----------
	            WebElement carritoBtn = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//img[contains(@alt, 'Shop Cart')]")));
	            carritoBtn.click();
	            
	            // -------- VERIFICO QUE EL BOTON SEA EL CORRECTO ----------
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//button[@class='btn btn-sm btn-primary mr-2']")));
	            
	            // -------- HACER CLICK EN EL CARRITO, PARTE SUPERIOR DER.  ----------
	            WebElement btnCompletarCompra = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//button[@class='btn btn-sm btn-primary mr-2']")));
	            btnCompletarCompra.click();

	            // -------- DESPUES DE CLIKEAR AL CARRITO, ESPERO EL CARGADO DE LA PAG. SIGUIENTE ----------
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formstep1")));

	            // -------- HAGO CLICK EN EL BOTÓN DE "COMPLETAR LA COMPRA" ----------
	            WebElement btnCompletarCompraCheckout = wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("button.btn.btn-primary.pagebuilder-column-1")));
	            btnCompletarCompraCheckout.click();

	            // -------- ESPERAR AL FORMULARIO EMERGENTE (NO LLENAR CON NADA) ----------
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));  // Esperamos a que aparezca el modal

	            // -------- EN EL FORM. EMERGENTE HAGO CLCIK EN "CONTINUAR COMO INVITADO" ----------
	            WebElement btnContinuarComoInvitado = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//button[contains(text(),'Continuar como invitado')]")));
	            btnContinuarComoInvitado.click();

	            // -------- ESPERO QUE CARGUE LA ULTIMA PAGINA PARA EL "LLENADO DE DATOS" ----------
	            wait.until(ExpectedConditions.urlContains("formstep2"));

	            // -------- LLENO EL FORMULARIO CON MIS DATOS INVENTADOS --------
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formemail"))).sendKeys("Email_Inventado_01@gmail.com");
	            driver.findElement(By.id("formfirstname")).sendKeys("Elvis Itador");
	            driver.findElement(By.id("formphonecode")).sendKeys("0000");
	            driver.findElement(By.id("formphone")).sendKeys("70796581");
	            driver.findElement(By.id("forminvoicename")).sendKeys("563215525");

	            // -------- SELECCIONO CEDULA DE IDENTIDAD EN LA LISTA --------
	            Select tipoDoc = new Select(driver.findElement(By.id("formtipodoc")));
	            tipoDoc.selectByValue("1");
	            
	            // -------- SIGO LLENANDO LOS DATOS QUE FALTAN Y HAGO CLICK EN SIGUIENTE --------
	            driver.findElement(By.id("formcode")).sendKeys("5266987");
	            driver.findElement(By.id("formlastname")).sendKeys("Delgado");
	            driver.findElement(By.id("formlastname2")).sendKeys("Del Castillo");
	            driver.findElement(By.id("forminvoicenumber")).sendKeys("5266987");
	            driver.findElement(By.xpath("//button[contains(text(),'Siguiente')]")).click();

	            
	            // -------- HAGO CLICK EN EL BOTÓN RECOGER EN TIENDA Y COLOCO UNA REFERENCIA PARA EL RECOJO  ----------
	            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Recojo en Tienda')]"))).click();
	            driver.findElement(By.id("form_1_additionalShippingInstructions"))
	                  .sendKeys("Recoger en tienda a nombre del señor: Elvis Itador Delgado Del Castillo");
	            driver.findElement(By.id("checkterms_YES")).click();
	            driver.findElement(By.xpath("//button[contains(text(),'Siguiente')]")).click();

	            // -------- HAGO CLICK EN "PAGO AL MOMENTO DE LA ENTREGA" ----------
	            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='radio' and @value='1']"))).click();

	            // -------- LEYENDO EL TEXTO DEL ULTIMO BOTÓN ANTES DE FINALIZAR LA COMPRA ----------
	            WebElement botonFinalizar = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//button[contains(text(),'Finalizar Pedido')]")));
	            String textoFinal = botonFinalizar.getText();
	            System.out.println("Texto del botón final: " + textoFinal);
	            Assert.assertEquals(textoFinal, "Finalizar Pedido", "Validación final del flujo completa.");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit(); // CIERRE DEL NAVEGADOR
	        }
	    }

	// ------- CADA VEZ QUE NOS DESPLAZAMOS A UN ELEMENTO COMPROBAMOS Y LE DAMOS CLICK -------
	    private void navegarSubMenu(String menu, String subMenu) {
	        try {
	            WebElement menuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(menu)));
	            Actions actions = new Actions(driver);
	            actions.moveToElement(menuElement).perform();
	            WebElement subMenuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(subMenu)));
	            wait.until(ExpectedConditions.elementToBeClickable(subMenuElement)).click();

	        } catch (Exception e) {
	            System.out.println("ERROR INTENTANDO SELECCIONAR: " + e.getMessage());
	        }

	    }
	// ------- ALMACENANDO LOS PRECIOS DE LOS PRODUCTOS PARA COMPARAR -------
	    private double obtenerPrecioYAgregar(String nombreProducto) {
	        try {
	            WebElement agregarBtn = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("//button[contains(@name, 'add__" + nombreProducto + "')]")));
	            WebElement precioElement = agregarBtn.findElement(By.xpath(".//preceding::span[@class='product-price'][1]"));
	            String precioTexto = precioElement.getText().replace("Bs.", "").trim();
	            double precio = Double.parseDouble(precioTexto);
	            agregarBtn.click();
	            return precio;
	        } catch (Exception e) {
	            System.out.println("ERROR AL OBTENER PRECIO Y NAVEGAR EN EL CARRITO: " + e.getMessage());
	            return 0;
	        }
	    }


	}
