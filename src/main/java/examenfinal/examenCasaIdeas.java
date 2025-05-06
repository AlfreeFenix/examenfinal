
package examenfinal;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;


public class examenCasaIdeas {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.casaideas.com.bo");
        driver.manage().window().maximize();
        WebElement santaCruzButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("60")));
        santaCruzButton.click();
    }

    @Test(description = "Navegar a la sección Nuevo y agregar productos")
    public void mainTest() {
       
    	//----------------------------Flujo para el producto de Baño----------------------------------------------//
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    	WebElement linkNuevo = driver.findElement(By.cssSelector("a[href*='/nuevo/310']"));
    	linkNuevo.click();
    	
    	WebElement btnBaño = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[1]/div[3]/div/div/div/div[2]/div/div[8]/div/div/div/div/div/div/button")); 
    	btnBaño.click();
    	    	    	
    	WebElement addBaño = driver.findElement(ByName.name("add__21755"));
    	addBaño.click();
    			   	
    	WebElement nombreP = driver.findElement(By.cssSelector("a[target='_self'][name*='manageHref__21755']"));
    	String nombreProducto = nombreP.getText();
    	   	
    	WebElement verCarro = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div[5]/button"));
    	verCarro.click();
    	
    	WebElement btnCompletar = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div[5]/div/div/div[2]/div/div/button"));
    	btnCompletar.click();
    	
    	String NomProdEsperado = "VASO DE RESINA PARA BAÑO";
    	
    	Assert.assertEquals(nombreProducto,NomProdEsperado, "El nombre del producto agregado no coicide");
    	
    	System.out.println("El producto '" + NomProdEsperado + "' se agregó correctamente al carrito.");
    	
    	//--------------------------------Flujo para el producto de Niño---------------------------------------------------------//
    	
		
    	WebElement linkNiño = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/pages/nino']")));//href="/pages/nino"
        linkNiño.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement btnaccesoriosN = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/espacios-de-la-casa/ninos/accesorios-de-temporada/200']")));//href="/espacios-de-la-casa/ninos/accesorios-de-temporada/200"
        btnaccesoriosN.click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));

        WebElement addAccesorioNiño = wait.until(ExpectedConditions.elementToBeClickable(ByName.name("add__21672_C_3229236000029")));
        addAccesorioNiño.click();

        WebElement nombreAccesorioNino =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[target='_self'][name*='manageHref__21672'][href*='cintillo-cubre-orejas']")));
        String prodAcceNino = nombreAccesorioNino.getText();

        WebElement verCarroAcceNino = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div[5]/button")));
        verCarroAcceNino.click();

        WebElement btnCompletarAccesorio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div[5]/div/div/div[2]/div/div/button")));
        btnCompletarAccesorio.click();

        String NombreAccesEsperado = "CINTILLO CUBRE OREJAS 25X11 CM";

        Assert.assertEquals(prodAcceNino,NombreAccesEsperado, "El nombre del producto agregado no coicide");

        System.out.println("El producto '" + NombreAccesEsperado + "' se agregó correctamente al carrito.");
		  
	    	//---------------------------------Flujo para el producto de Mueble ------------------------------------------------------------------//
	    	
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	    	
	    	WebElement btnMueble = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MUEBLES")));
	    	btnMueble.click();
	        

	        WebElement mueblesAuxlink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='183']")));
	        mueblesAuxlink.click();

	        WebElement addMueble = wait.until(ExpectedConditions.elementToBeClickable(ByName.name("add__19549")));
	        addMueble.click();

	        WebElement cajoneraLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[name*='manageHref__19549'][href*='cajonera-bambu']")));
	        String prodMueble = cajoneraLink.getText();

	        WebElement verCarroMueble = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div[5]/button")));
	        verCarroMueble.click();

	        WebElement btnCompletarMueble = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div[5]/div/div/div[2]/div/div/button")));
	        btnCompletarMueble.click();

	        String NombreMuebleEsperado = "CAJONERA BAMBU/MDF 3 CAJONES";

	        Assert.assertEquals(prodMueble,NombreMuebleEsperado, "El nombre del producto agregado no coicide");
	        
	        System.out.println("El producto '" + NombreMuebleEsperado + "' se agregó correctamente al carrito.");
	        

	    	//-------------------------------------Assert Totales-------------------------------------------------------------//
	    	
	    	 //  Localizar y extraer los subtotales de cada producto ---
	        List<WebElement> subtotalElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table shopping-summery clean']/tbody/tr/td[@data-title='SUBTOTAL']/span")));
	        List<Double> subtotales = new ArrayList<>();

	        for (WebElement subtotalElement : subtotalElements) {
	            String textoSubtotalCompleto = subtotalElement.getText();
	            String valorSubtotalNumerico = textoSubtotalCompleto.replace("Bs.", "").trim();
	            try {
	                subtotales.add(Double.parseDouble(valorSubtotalNumerico));
	            } catch (NumberFormatException e) {
	                System.err.println("Error al convertir el subtotal a número: " + valorSubtotalNumerico);
	                Assert.fail("Error al convertir el subtotal a número: " + valorSubtotalNumerico);
	            }
	        }

	        //  Sumar todos los subtotales ---
	        double sumaSubtotales = 0;
	        for (double subtotal : subtotales) {
	            sumaSubtotales += subtotal;
	        }

	        System.out.println("Suma de los subtotales: Bs." + String.format("%.2f", sumaSubtotales));

	        //  Localizar y extraer el "Total del pedido" ---
	        WebElement totalPedidoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//div[@class='mb-2 background-resume-order margin-resume']//div[contains(text(), 'Total del pedido')]/following-sibling::div[@class='col-5 flex items-right text-right']/b")
	        ));
	        String textoTotalPedidoCompleto = totalPedidoElement.getText();
	        String valorTotalPedidoNumerico = textoTotalPedidoCompleto.replace("Bs.", "").trim();
	        double totalPedido = 0;
	        try {
	            totalPedido = Double.parseDouble(valorTotalPedidoNumerico);
	            System.out.println("Total del pedido: Bs." + String.format("%.2f", totalPedido));
	        } catch (NumberFormatException e) {
	            System.err.println("Error al convertir el total del pedido a número: " + valorTotalPedidoNumerico);
	            Assert.fail("Error al convertir el total del pedido a número: " + valorTotalPedidoNumerico);
	        }

	        //  Realizar la aserción ---
	        Assert.assertEquals(sumaSubtotales, totalPedido, 0.01, "La suma de los subtotales no coincide con el total del pedido.");
	        System.out.println("La verificación de la sumatoria total del pedido fue exitosa.");

	        //-------------------Completar la Compra	        
	        
	        WebElement btnCompletarFinal = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div/div[3]/div/div/div[2]/div[1]/div/div/div[2]/div[2]/button"));
	        btnCompletarFinal.click();
	        		
	       // -----------------------------------------------------------------------		
	        		
	        WebElement btnInvitado = driver.findElement(By.xpath("//button[text()='Continuar como invitado']"));
	        btnInvitado.click();
	        
	       //-------------------------------------FORMULARIO------------------------------------------------//
	        
	     
	        WebElement emailInput = driver.findElement(By.id("formemail"));
	        emailInput.sendKeys("mariae.venetucci@gmail.com");

	        WebElement codigoClienteInput = driver.findElement(By.id("formcode"));
	        codigoClienteInput.sendKeys("6897145");

	        WebElement nombresInput = driver.findElement(By.id("formfirstname"));
	        nombresInput.sendKeys("Maria");

	        WebElement apellidoPaternoInput = driver.findElement(By.id("formlastname"));
	        apellidoPaternoInput.sendKeys("Venetucci");

	        WebElement apellidoMaternoInput = driver.findElement(By.id("formlastname2"));
	        apellidoMaternoInput.sendKeys("Ramirez");

	        WebElement celularInput = driver.findElement(By.id("formphone"));
	        celularInput.sendKeys("76658987");

	        // Seleccionar "Santa Cruz" en la lista desplegable de Ciudad
	        Select ciudadSelect = new Select(driver.findElement(By.id("formcity")));
	        ciudadSelect.selectByVisibleText("Santa Cruz");

	        // Seleccionar "Cédula de Identidad de Extranjero" en la lista desplegable de Tipo de Documento
	        Select tipoDocSelect = new Select(driver.findElement(By.id("formtipodoc")));
	        tipoDocSelect.selectByVisibleText("Cédula de Identidad de Extranjero");

	        WebElement numeroIdentificacionInput = driver.findElement(By.id("forminvoicenumber"));
	        numeroIdentificacionInput.sendKeys("6897145");

	        WebElement razonSocialInput = driver.findElement(By.id("forminvoicename"));
	        razonSocialInput.sendKeys("Maria Venetucci");

	        // --- Clic en el botón "Siguiente >" ---
	        WebElement siguienteButton = driver.findElement(By.xpath("//button[text()='Siguiente >']"));
	        siguienteButton.click();
	    																						
	        // ------------------------ Pantalla de Entrega / Retiro ---
	        
	        // Ingresar indicaciones para la entrega
	        WebElement indicacionesEntregaTextarea = driver.findElement(By.id("form_1_additionalShippingInstructions"));
	        indicacionesEntregaTextarea.sendKeys("Llamar antes de armar el pedido");

	        // Marcar la casilla de "He leído y estoy de acuerdo con los Términos y condiciones"
	        WebElement checkTerminos = driver.findElement(By.id("checkterms_YES"));
	        checkTerminos.click();

	        // Hacer clic en el botón "Siguiente >" para continuar
	        WebElement siguienteEntregaRetiroButton = driver.findElement(By.xpath("//div[@class='card items-right']//button[text()='Siguiente >']"));
	        siguienteEntregaRetiroButton.click();
	        
	        // ------------------------- Pantalla de Métodos de Pago --------------------
	   
	        // Seleccionar "Pago al momento de Entrega"
	        WebElement pagoEntregaRadio = driver.findElement(By.xpath("//label[contains(@class, 'h5-responsive') and contains(text(), 'Pago al momento de Entrega')]/input[@type='radio']"));
	        pagoEntregaRadio.click();

	        // Verificar la presencia del botón "Finalizar Pedido"
	        WebElement finalizarPedidoButton = driver.findElement(By.xpath("//button[contains(@class, 'btn-primary') and contains(text(), 'Finalizar Pedido')]"));
	        Assert.assertTrue(finalizarPedidoButton.isDisplayed(), "El botón 'Finalizar Pedido' no se muestra.");

	        System.out.println("Se ha llegado a la pantalla de Métodos de Pago y se verifica el botón 'Finalizar Pedido'.");
		
    }

    @AfterTest
    public void after() throws InterruptedException {
        Thread.sleep(6000);
        driver.close();
    }
}
