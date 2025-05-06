package examenFinal;

import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class shopping {
	WebDriver driver;
	ChromeOptions options;
	@BeforeTest
	public void before() {
		options = new ChromeOptions();
		options.addArguments("--incognito");
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.casaideas.com.bo/");
		
	}
	
	@Test(description = "Test shopping car")
	public void shoppingTest() throws InterruptedException {
	
		Double subtotal1 = 0.00;
		//Selecciona ciudad
		Thread.sleep(5000);
		WebElement bntciudad= driver.findElement(By.name("60"));
		bntciudad.click();
		
		//Seleccionamos el primer producto
		Thread.sleep(5000);
		WebElement menuCasa = driver.findElement(By.cssSelector("nav.main-menu-navigator > ul > li:nth-child(1)"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuCasa).perform();

		Thread.sleep(1000);
		WebElement sbmenuCocina = driver.findElement(By.cssSelector("ul.sub-menu a[href='/espacios-de-la-casa/cocina/79']"));
		sbmenuCocina.click();
		Thread.sleep(7000);
		
		List<WebElement> producto1T = driver.findElements(By.cssSelector("a[href*='cojin-de-silla-40x40-cm-21943']"));
		String NombrePd1 = producto1T.get(5).getText();
		
		//Agregamos primer producto al carrito
		WebElement bntAddProduct1= driver.findElement(By.cssSelector("button[name='add__21943_C_3118680000450']"));
		bntAddProduct1.click();
		Thread.sleep(1000);
		
		//Ingresamos al carrito
		WebElement bntCart =driver.findElement(By.className("mini-cart-icon"));
		bntCart.click();
		
		List<WebElement> bntcompra= driver.findElements(By.cssSelector("button[class='btn btn-sm btn-primary mr-2']"));
		bntcompra.get(0).click();
		Thread.sleep(4000);
		List<WebElement> tbproductnombres = driver.findElements(By.cssSelector("span.text-bold.text-underline"));
		String cartNombrep1= tbproductnombres.get(0).getText();
		
		Assert.assertEquals(cartNombrep1, NombrePd1);
		
		//Seleccionamos el segundo producto
		WebElement menuNinios = driver.findElement(By.cssSelector("nav.main-menu-navigator > ul > li:nth-child(4)"));
		actions.moveToElement(menuNinios).perform();
		
		Thread.sleep(1000);
		List<WebElement> sbmenuNinios = driver.findElements(By.cssSelector("ul.sub-menu a[href*='cojines-de-nino/191']"));
		sbmenuNinios.get(1).click();
		Thread.sleep(5000);
		
		WebElement producto2T = driver.findElement(By.cssSelector("a[name*='3226402000074_1.jpg']"));
		String NombrePd2 = producto2T.getText();
		
		//Agregamos primer producto al carrito
		WebElement bntAddProduct2= driver.findElement(By.cssSelector("button[name='add__21713']"));
		bntAddProduct2.click();
		Thread.sleep(1000);
		
		//Ingresamos al carrito
		bntCart =driver.findElement(By.className("mini-cart-icon"));
		bntCart.click();
		
		bntcompra= driver.findElements(By.cssSelector("button[class='btn btn-sm btn-primary mr-2']"));
		bntcompra.get(0).click();
		Thread.sleep(4000);
		tbproductnombres = driver.findElements(By.cssSelector("span.text-bold.text-underline"));
		String cartNombrep2= tbproductnombres.get(1).getText();
		
		Assert.assertEquals(cartNombrep2, NombrePd2);
		
		//Seleccionamos el tercer producto
		WebElement menuMuebles = driver.findElement(By.cssSelector("nav.main-menu-navigator > ul > li:nth-child(5)"));
		actions.moveToElement(menuMuebles).perform();
				
		Thread.sleep(1000);
		WebElement sbmenuMuebles = driver.findElement(By.cssSelector("ul.sub-menu a[href='/muebles/sillas/186']"));
		sbmenuMuebles.click();
		Thread.sleep(5000);
				
		WebElement producto3T = driver.findElement(By.cssSelector("a[name*='3222465000020_1.jpg']"));
		String NombrePd3 = producto3T.getText();
				
		//Agregamos primer producto al carrito
		WebElement bntAddProduct3= driver.findElement(By.cssSelector("button[name='add__8920']"));
		bntAddProduct3.click();
		Thread.sleep(1000);
				
		//Ingresamos al carrito
		bntCart =driver.findElement(By.className("mini-cart-icon"));
		bntCart.click();
				
		bntcompra= driver.findElements(By.cssSelector("button[class='btn btn-sm btn-primary mr-2']"));
		bntcompra.get(0).click();
		Thread.sleep(4000);
		tbproductnombres = driver.findElements(By.cssSelector("span.text-bold.text-underline"));
		String cartNombrep3= tbproductnombres.get(2).getText();
				
		Assert.assertEquals(cartNombrep3, NombrePd3);	
		
		List<WebElement> preciosProduct = driver.findElements(By.cssSelector("td[data-title='SUBTOTAL'] span"));
		for (WebElement precio : preciosProduct) {
		    String texto = precio.getText();
		    String soloNumero = texto.replaceAll("Bs.", "");
		    subtotal1 += Double.parseDouble(soloNumero);
		}
		
		//Detalle de la compra
		WebElement subtotal = driver.findElement(By.cssSelector(".col-5.flex.items-right.text-right b:nth-child(1)"));
		String textSubtotal = subtotal.getText().replace("Bs.", "");
		
		Assert.assertEquals(textSubtotal, subtotal1+"0");
		
		//completar compra
		WebElement btnCompletarCompra = driver.findElement(By.cssSelector(".btn.btn-primary.pagebuilder-column-1"));
		btnCompletarCompra.click();
		WebElement btnContinuarComoInvitado = driver.findElement(By.cssSelector(".btn.btn-outline-primary.btn-block"));
		btnContinuarComoInvitado.click();
		Thread.sleep(2000);		
		
		//completar datos de personales
		String email="ed@mail.com";
		String ci= "98253001";
		String nombre = "Pancrasio";
		String apePaterno ="Pan";
		String apeMaterno = "Molido";
		String celular ="60001235";
		
		WebElement bxEmail = driver.findElement(By.name("email"));
		bxEmail.sendKeys(email);
		WebElement bxCodigo = driver.findElement(By.name("code"));
		bxCodigo.sendKeys(ci);
		WebElement bxNombre = driver.findElement(By.name("firstname"));
		bxNombre.sendKeys(nombre);
		WebElement bxApePaterno = driver.findElement(By.name("lastname"));
		bxApePaterno.sendKeys(apePaterno);
		WebElement bxApeMaterno = driver.findElement(By.name("lastname2"));
		bxApeMaterno.sendKeys(apeMaterno);
		WebElement bxCelular = driver.findElement(By.name("phone"));
		bxCelular.sendKeys(celular);
		Select selecOpt = new Select(driver.findElement(By.id("formtipodoc")));
		selecOpt.selectByIndex(1);
		WebElement bxIdentificacion = driver.findElement(By.name("invoicenumber"));
		bxIdentificacion.sendKeys(ci);
		WebElement bxRazonS = driver.findElement(By.name("invoicename"));
		bxRazonS.sendKeys(nombre+" "+apePaterno+" "+apeMaterno);
		
		WebElement btnSiguiente = driver.findElement(By.cssSelector("button[class*='shipping-form-btn']"));
		btnSiguiente.click();
		Thread.sleep(4000);
		
		//Entrega
		WebElement bxIndicaciones = driver.findElement(By.id("form_1_additionalShippingInstructions"));
		bxIndicaciones.sendKeys("Contactar primero al número de referencia");
		WebElement terminos = driver.findElement(By.id("checkterms_YES"));
		terminos.click();
		
		btnSiguiente = driver.findElement(By.cssSelector("button[class*='shipping-form-btn']"));
		btnSiguiente.click();
		Thread.sleep(2000);
		
		//Metodo de pago
		WebElement rtpagoEntrega = driver.findElement(By.cssSelector(".mr-1[value='1']"));
		rtpagoEntrega.click();
		Thread.sleep(4000);
		WebElement btnFinPedido = driver.findElement(By.cssSelector(".btn.btn-primary.text-bold"));
		String textFinPedido = btnFinPedido.getText();
		
		Assert.assertEquals(textFinPedido, "Finalizar Pedido");
		
		
		
		
		
	}

	@AfterTest
	public void after() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
}
