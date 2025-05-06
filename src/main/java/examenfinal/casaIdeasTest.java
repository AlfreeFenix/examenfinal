package examenfinal;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class casaIdeasTest {
	WebDriver driver;
	@BeforeTest()
	public void before() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver = new ChromeDriver();
		driver.get("https://www.casaideas.com.bo/");
		Thread.sleep(10000);
	}
	
	@Test()
	public void test() throws InterruptedException {
		// choose la paz
		List<WebElement> dept = driver.findElements(By.cssSelector("button"));
		dept.get(0).click();
		Thread.sleep(8000);
		
		// open nav bar
		WebElement menuBttn = driver.findElement(By.xpath("//a[contains(text(),'ESPACIOS DE LA CASA')]"));
		menuBttn.click();
		Thread.sleep(3000);
		
		// choose cateogry from nav bar 
		WebElement accPersBttn = driver.findElement(By.xpath("//ul[contains(@class,'sub-menu')]//span[contains(text(),'Accesorios Personales')]"));
		accPersBttn.click();
		Thread.sleep(3000);

		
		// choose 3 products
		List<WebElement> preBttns = driver.findElements(By.cssSelector("button"));
		preBttns.get(24).click();
		Thread.sleep(1000);
		preBttns.get(28).click();
		Thread.sleep(1000);
		preBttns.get(32).click();
		Thread.sleep(1000);
		
		// click cart button and go to checkout page
		List<WebElement> postBttns = driver.findElements(By.cssSelector("button"));
		postBttns.get(2).click();
		Thread.sleep(3000);
		postBttns.get(6).click();
		Thread.sleep(5000);
		
		// read info form table
		List<WebElement> row = driver.findElements(By.cssSelector("tbody tr"));
		// first product
		List<WebElement> col1 = row.get(0).findElements(By.cssSelector("td"));
		String productName1 = col1.get(1).getText().split("\n")[0];
		String productPrice1 = col1.get(4).getText().split("Bs.")[1];
		
		// second product
		List<WebElement> col2 = row.get(1).findElements(By.cssSelector("td"));
		String productName2 = col2.get(1).getText().split("\n")[0];
		String productPrice2 = col2.get(4).getText().split("Bs.")[1];		
		
		// third product
		List<WebElement> col3 = row.get(2).findElements(By.cssSelector("td"));
		String productName3 = col3.get(1).getText().split("\n")[0];
		String productPrice3 = col3.get(4).getText().split("Bs.")[1];
			
		// verificar compras son correctas
		Assert.assertEquals(productName1, "BOLSA DE SÍLICA EN FORMA DE ANIMALITO 18X27 CM");
		Assert.assertEquals(productPrice1, "129.00");
		Assert.assertEquals(productName2, "BOLSA DE AGUA CON FUNDA 2 LITROS");
		Assert.assertEquals(productPrice2, "149.00");
		Assert.assertEquals(productName3, "BOLSA DE AGUA CON FUNDA 2 LITROS");
		Assert.assertEquals(productPrice3, "149.00");
		
		// verificar total pedido es correcto
		float totalPedidoEstimado = Float.parseFloat(productPrice1) + Float.parseFloat(productPrice2) + Float.parseFloat(productPrice3);
		System.out.print(Math.round(totalPedidoEstimado));
		
		WebElement total = driver.findElement(By.xpath("//div[@class='row mb-2 mt-3']//b[1]"));
		String totalPedido = total.getText().split("Bs.")[1];
		System.out.print("\n" + Math.round(Float.parseFloat(totalPedido)));
		
		Assert.assertEquals(Math.round(totalPedidoEstimado), Math.round(Float.parseFloat(totalPedido)));
		
		// completar compra
		List<WebElement> cartBttns = driver.findElements(By.cssSelector("button"));
		cartBttns.get(20).click();
		Thread.sleep(5000);
		
		// login 
		WebElement guestBttn = driver.findElement(By.xpath("//button[normalize-space()='Continuar como invitado']"));
		guestBttn.click();
		Thread.sleep(5000);
		
		// completar datos
		List<WebElement> inputs = driver.findElements(By.cssSelector("input"));
		inputs.get(8).sendKeys("testemail@test.com");
		inputs.get(9).sendKeys("00000000");
		inputs.get(10).sendKeys("RAMIRO");
		inputs.get(11).sendKeys("LOPEZ");
		inputs.get(12).sendKeys("LOPEZ");
		inputs.get(13).sendKeys("LP");
		inputs.get(14).sendKeys("69974927");
		
		List<WebElement> selects = driver.findElements(By.cssSelector("select"));
		Select tipoDocumento = new Select(selects.get(1));
		tipoDocumento.selectByIndex(1);
		
		inputs.get(15).sendKeys("11111122");
		inputs.get(16).sendKeys("LP");
		inputs.get(17).sendKeys("PEREZ");
		
		// clickar boton siguiente		
		List<WebElement> cartBttns2 = driver.findElements(By.cssSelector("button"));
		cartBttns2.get(17).click();
		Thread.sleep(5000);
		
		// clickear checkbox
		List<WebElement> inputCheckout = driver.findElements(By.cssSelector("input"));
		inputCheckout.get(20).click();
		
		// clickear boton siguiente
		List<WebElement> cartBttns3 = driver.findElements(By.cssSelector("button"));
		cartBttns3.get(22).click();
	}
	
	@AfterTest()
	public void after() {
		driver.close();
	}

}
