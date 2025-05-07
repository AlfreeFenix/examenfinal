import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class examenFinal {

    public class CompraCasaIdeas {

        WebDriver driver;
        WebDriverWait wait;

        double[] precios = new double[3];

        @BeforeMethod
        public void iniciar() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.get("https://www.casaideas.com.bo/");

            seleccionarCiudad("COCHABAMBA", "61");
        }
        @Test
        public void realizarCompraCompleta() {
            try {
                precios[0] = agregarProducto("NIÑOS", "Bebé", "21419_C_3228289000024");
                precios[1] = agregarProducto("NIÑOS", "Juguetería", "19731");
                precios[2] = agregarProducto("MUEBLES", "Mesas", "20583");

                abrirCarrito();
                iniciarCheckout();

                llenarFormularioInvitado();
                seleccionarEntregaEnTienda("Recoger en tienda a nombre del señor: Pepe");
                seleccionarMetodoPago();

                validarTextoBotonFinal("Finalizar Pedido");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        }

        private void seleccionarCiudad(String ciudad, String code) {
            try {
                WebElement btnCiudad = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@name='" + code + "' and text()='" + ciudad + "']")));
                btnCiudad.click();
            } catch (Exception e) {
                System.out.println("Modal de ciudad no apareció.");
            }
        }

        private double agregarProducto(String menu, String subMenu, String nombreProducto) {
            navegarSubMenu(menu, subMenu);
            return obtenerPrecioYAgregar(nombreProducto);
        }

        private void abrirCarrito() {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//img[contains(@alt, 'Shop Cart')]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@class='btn btn-sm btn-primary mr-2']"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formstep1")));
        }

        private void iniciarCheckout() {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.btn.btn-primary.pagebuilder-column-1"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='modal-body']")));

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Continuar como invitado')]"))).click();

            wait.until(ExpectedConditions.urlContains("formstep2"));
        }

        private void llenarFormularioInvitado() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formemail"))).sendKeys("Email_Pepe@gmail.com");
            driver.findElement(By.id("formfirstname")).sendKeys("Pepe Lopez");
            driver.findElement(By.id("formphonecode")).sendKeys("0000");
            driver.findElement(By.id("formphone")).sendKeys("75769854");
            driver.findElement(By.id("forminvoicename")).sendKeys("453454454");

            new Select(driver.findElement(By.id("formtipodoc"))).selectByValue("1");

            driver.findElement(By.id("formcode")).sendKeys("65555555");
            driver.findElement(By.id("formlastname")).sendKeys("maria");
            driver.findElement(By.id("formlastname2")).sendKeys("sanchez");
            driver.findElement(By.id("forminvoicenumber")).sendKeys("657675676");

            driver.findElement(By.xpath("//button[contains(text(),'Siguiente')]")).click();
        }

        private void seleccionarEntregaEnTienda(String referencia) {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Recojo en Tienda')]"))).click();

            driver.findElement(By.id("form_1_additionalShippingInstructions")).sendKeys(referencia);
            driver.findElement(By.id("checkterms_YES")).click();

            driver.findElement(By.xpath("//button[contains(text(),'Siguiente')]")).click();
        }

        private void seleccionarMetodoPago() {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@type='radio' and @value='1']"))).click();
        }

        private void validarTextoBotonFinal(String textoEsperado) {
            WebElement botonFinalizar = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[contains(text(),'" + textoEsperado + "')]")));
            Assert.assertEquals(botonFinalizar.getText(), textoEsperado, "Validación final del flujo completa.");
        }

        private void navegarSubMenu(String menu, String subMenu) {
            try {
                WebElement menuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(menu)));
                new Actions(driver).moveToElement(menuElement).perform();
                WebElement subMenuElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(subMenu)));
                subMenuElement.click();
            } catch (Exception e) {
                System.out.println("Error al seleccionar menú: " + e.getMessage());
            }
        }

        private double obtenerPrecioYAgregar(String nombreProducto) {
            try {
                WebElement agregarBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(@name, 'add__" + nombreProducto + "')]")));
                WebElement precioElement = agregarBtn.findElement(
                        By.xpath(".//preceding::span[@class='product-price'][1]"));
                String precioTexto = precioElement.getText().replace("Bs.", "").trim();
                agregarBtn.click();
                return Double.parseDouble(precioTexto);
            } catch (Exception e) {
                System.out.println("Error al obtener precio: " + e.getMessage());
                return 0;
            }
        }
    }
}
