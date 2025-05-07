package examenfinal;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class casa_ideas {
	WebDriver driver;
	
	@BeforeTest
	public void before() throws InterruptedException {
		ChromeOptions chrome  = new ChromeOptions();
		chrome.addArguments("disable-infobars");
		chrome.addArguments("--windows-size=800,800");
		//chrome.AddArguments("--headless");
		chrome.setExperimentalOption("excludeSwitches", new String[]{"enabled-automation"});
		driver = new ChromeDriver( chrome);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.casaideas.com.bo/");

	}
	@Test
	public void test()  throws InterruptedException {
		
		// Elegir ciudad Santa Cruz
		WebElement btnIngresarCiudad = driver.findElement(By.cssSelector("button[name='60']"));
		btnIngresarCiudad.click();  
		
		Actions actions1 = new Actions(driver);
	    WebElement menuProducto = driver.findElement(By.xpath("//a[text()='PRODUCTOS']"));
	    actions1.moveToElement(menuProducto).perform();
	    	
		WebElement subMnProducto_cojines = driver.findElement(By.cssSelector("a[href='/cojines/809']"));
		subMnProducto_cojines.click();	
		WebElement btnAdicionarCarrito_cojin = driver.findElement(By.cssSelector("button[name='add__16855']"));
		btnAdicionarCarrito_cojin.click();  // 229.00
		
		WebElement btnCarritoCompra1 = driver.findElement(By.cssSelector("button[class='no-button mini-cart-icon']"));
		btnCarritoCompra1.click();
		
		WebElement btnCarritoCompletarCompra1 = driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-primary mr-2'])[1]"));
		btnCarritoCompletarCompra1.click();
		
		WebElement btnNombreCompra1 = driver.findElement(By.xpath("//span[text()='COJIN BORDADO BOUCLE 45X45']"));
		String compra1 = btnNombreCompra1.getText();
		Assert.assertEquals(compra1, "COJIN BORDADO BOUCLE 45X45");
		
		Thread.sleep(20000);
		try {
		WebElement btnCerrarAnuncio = driver.findElement(By.cssSelector("span[class='exponea-close-cross']"));
		btnCerrarAnuncio .click();	
		} catch (NoSuchElementException e) {	}
		
		try{
		WebElement btnCerrarAnuncioRegalo = driver.findElement(By.cssSelector("a[class='btnClose']"));
		btnCerrarAnuncioRegalo .click();
		} catch (NoSuchElementException e) {	
			System.out.println("Elemento no encontrado: " + e.getMessage());
		}
		
		
		//	Actions actions2 = new Actions(driver);
	    WebElement menuNuevo = driver.findElement(By.xpath("//a[text()='NUEVO']"));
	    actions1.moveToElement(menuNuevo).perform();
		
		WebElement subMnNuevo_Comedor = driver.findElement(By.cssSelector("a[href='/nuevo/nuevo-de-comedor/315']"));
		subMnNuevo_Comedor.click();
		WebElement btnAdicionarCarrito_bendeja_desayuno = driver.findElement(By.cssSelector("button[name='add__19097']"));
		btnAdicionarCarrito_bendeja_desayuno.click(); // 179.00 BS		
		
		WebElement btnCarritoCompra2 = driver.findElement(By.cssSelector("button[class='no-button mini-cart-icon']"));
		btnCarritoCompra2.click();
		
		WebElement btnCarritoCompletarCompra2 = driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-primary mr-2'])[1]"));
		btnCarritoCompletarCompra2.click();
			
		WebElement btnNombreCompra2 = driver.findElement(By.xpath("//span[text()='BANDEJA DESAYUNO']"));
		String compra2 = btnNombreCompra2.getText();
		Assert.assertEquals(compra2, "BANDEJA DESAYUNO");
		
		Thread.sleep(20000);
		try{
		WebElement btnCerrarAnuncioRegalo1 = driver.findElement(By.cssSelector("a[class='btnClose']"));
		btnCerrarAnuncioRegalo1 .click();
		} catch (NoSuchElementException e) {	
			System.out.println("Elemento no encontrado: " + e.getMessage());
		}
		
		try {
		WebElement btnCerrarAnuncio1 = driver.findElement(By.cssSelector("span[class='exponea-close-cross']"));
		btnCerrarAnuncio1 .click();	
    	} catch (NoSuchElementException e) {
    		System.out.println("Elemento no encontrado: " + e.getMessage());
    	}
		
		//Actions actions3 = new Actions(driver);
	    WebElement menuMuebles = driver.findElement(By.xpath("//a[text()='MUEBLES']"));
	    actions1.moveToElement(menuMuebles).perform();
	    
		WebElement SubMnMuebles_auxiliares = driver.findElement(By.cssSelector("a[href='/muebles/muebles-auxiliares/183']"));
		SubMnMuebles_auxiliares.click();			
		WebElement btnAdicionarCarrito_repisa_madera = driver.findElement(By.cssSelector("button[name='add__16028']"));
		btnAdicionarCarrito_repisa_madera.click(); // 229.00 BS			
		
		// click carrito de compra
		WebElement btnCarritoCompra3 = driver.findElement(By.cssSelector("button[class='no-button mini-cart-icon']"));
		btnCarritoCompra3.click();	

		// completar la compra
		WebElement btnCarritoCompletarCompra = driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-primary mr-2'])[1]"));
		btnCarritoCompletarCompra.click();	

		WebElement btnNombreCompra3 = driver.findElement(By.xpath("//span[text()='REPISA MADERA 2 NIVELES']"));
		String compra3 = btnNombreCompra3.getText();
		Assert.assertEquals(compra3, "REPISA MADERA 2 NIVELES");
		
		// document.getElementsByClassName('product-price')
		String totalProductos = calcularTotalProductos();
		Assert.assertEquals(totalProductos, "637.0");
		
		Thread.sleep(20000);
		try {
		WebElement btnCerrarAnuncio2 = driver.findElement(By.cssSelector("span[class='exponea-close-cross']"));
		btnCerrarAnuncio2.click();			
		} catch (NoSuchElementException e) {
			System.out.println("Elemento no encontrado: " + e.getMessage());
		}
		
		try{
		WebElement btnCerrarAnuncioRegalo2 = driver.findElement(By.cssSelector("a[class='btnClose']"));
		btnCerrarAnuncioRegalo2 .click();
		} catch (NoSuchElementException e) {	
			System.out.println("Elemento no encontrado: " + e.getMessage());
		}
		// completar detalle de la compra
		WebElement btnCarritoCompletarCompraSig = driver.findElement(By.cssSelector("button[class='btn btn-primary pagebuilder-column-1']"));
		btnCarritoCompletarCompraSig.click();			
		
		// continuar como invitado
		WebElement btnContinuarComoInvitado = driver.findElement(By.cssSelector("button[class='btn btn-outline-primary btn-block']"));
		btnContinuarComoInvitado.click();	
		
		// colocar email cmariagomez@gmail.com
		WebElement frmEmail = driver.findElement(By.id("formemail"));
		frmEmail.sendKeys("cmariagomez@gmail.com") ;
		//Código Cliente *     1941779
		WebElement frmFormcode = driver.findElement(By.id("formcode"));
		frmFormcode.sendKeys("1941779");
		// Nombres *     Claudia Maria
		WebElement frmFormfirstname = driver.findElement(By.id("formfirstname"));
		frmFormfirstname.sendKeys("Claudia Maria");		
		// apellido   Gomez
		WebElement frmFormlastname = driver.findElement(By.id("formlastname"));
		frmFormlastname.sendKeys("Gomez");	
		// ap materno  Garcia
		WebElement frmFormlastname2 = driver.findElement(By.id("formlastname2"));
		frmFormlastname2.sendKeys("Garcia");					
		// codigo de area ccelular   591
		WebElement frmFormphonecode = driver.findElement(By.id("formphonecode"));
		frmFormphonecode.sendKeys("591");		
		//Celular *    79070120
		WebElement frmFormphone = driver.findElement(By.id("formphone"));
		frmFormphone.sendKeys("79070120");		
		//Ciudad *
		// por defecto Santa Cruz
		// select tipo doc para los datos de la factura
		Select objTipoDoc = new Select(driver.findElement(By.id("formtipodoc")));
		objTipoDoc.selectByValue("1");
		// nro de identificacion    1941779
		WebElement frmForminvoicenumber = driver.findElement(By.id("forminvoicenumber"));
		frmForminvoicenumber.sendKeys("1941779");	
		// complemento de ci (dejar en blanco)
		//id= formcomplemento
		// razon social   Claudia Maria Gomez Garcia
		WebElement frmForminvoicename = driver.findElement(By.id("forminvoicename"));
		frmForminvoicename.sendKeys("Claudia Maria Gomez Garcia");	
		// Avanzamos  a siguientes paso
		WebElement btnSiguiente = driver.findElement(By.xpath("//button[text()='Siguiente >']"));
		btnSiguiente.click();			
		// Avanzamos  a modo entrega
		WebElement chckRecocjoEnTienda = driver.findElement(By.xpath("//button[text()='Recojo en Tienda']"));
		chckRecocjoEnTienda.click();	
		// aceptar terminos de entrega
		WebElement btnAceptarTerminosEntrega = driver.findElement(By.id("checkterms_YES"));
		btnAceptarTerminosEntrega.click();	
		// avanzamos para cerrar modo de entrega
		WebElement btnCerrarModoEntrega = driver.findElement(By.xpath("//button[text()='Siguiente >']"));
		btnCerrarModoEntrega.click();
		// Metodo de pago
		WebElement btnMetodoPago = driver.findElement(By.cssSelector("label input[value= '1']"));
		btnMetodoPago.click();			
		// terminar el pedido, no darle cerrar

		WebElement btnCerrarPedido = driver.findElement(By.xpath("//button[text()='Finalizar Pedido']"));
		String confirmacionFinal= btnCerrarPedido.getText();
		Assert.assertEquals(confirmacionFinal, "Finalizar Pedido");
	}
	
	@AfterTest()
	public void after() throws InterruptedException{
		driver.close();
	}	
	
	public String calcularTotalProductos()
	{
		Integer cant = driver.findElements(By.xpath("//span[@class='cart-price']")).size();
		String subTotal= "";
		Integer cont = 1;
		Double suma = 0.0 ;
		while (cont <= cant )
		{
			subTotal = driver.findElement(By.xpath("(//span[@class='cart-price'])["+ cont.toString()+"]")).getText();
			String obtenerSubTotal = subTotal.substring(3,9);
			suma = suma  + Double.parseDouble(obtenerSubTotal);
			cont = cont + 1;
		}
		return suma.toString();
	}
	

}
