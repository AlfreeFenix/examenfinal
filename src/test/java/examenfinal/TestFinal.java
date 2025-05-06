package examenfinal;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;


public class TestFinal {
	WebDriver driver = new ChromeDriver();
	String Url="https://www.casaideas.com.bo/";
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	String ventanaActual;
	
	@BeforeTest
	public void before(){
        //ChromeOptions option=new ChromeOptions();        
        driver.get(Url);
        driver.manage().window().maximize();
        
        WebElement acceder=wait.until(ExpectedConditions.elementToBeClickable(By.name("61")));
		acceder.click();	
		
		 ventanaActual=driver.getWindowHandle();
		
    }
	@Test
	public void test() {
		
		
		//Elige opcion muebles menu
				WebElement menuOpcion = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href=\"/muebles/114")));
				new Actions(driver).moveToElement(menuOpcion).perform();
				
				//Elegi una opcion del menu muebles
				WebElement opcionElegida=driver.findElement(By.cssSelector("a[href=\"/muebles/mesas/182"));
				opcionElegida.click();
				
				//Agrega un mueble al carrito
				
				WebElement muebleElegido=wait.until(ExpectedConditions.elementToBeClickable(By.name("add__20761")));
				String elemento1;
				WebElement textoMueble=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div[1]/div[4]/div/div[1]/div/div/div[2]/div/div/div[2]/div[1]/p/a"));
				elemento1=textoMueble.getText();
				//System.out.println(elemento1);
				muebleElegido.click();		    				
				
				WebElement inicio=driver.findElement(By.cssSelector("a[href=\"/"));
				inicio.click();					
				
				//Elige opcion muebles menu nenes
				WebElement menuOpcionNenes =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href=\"/pages/nino")));
				new Actions(driver).moveToElement(menuOpcionNenes).perform();
				
				//Elegi una opcion del menu nenes
				WebElement opcionElegidaNenes=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/nav/ul/li[4]/ul/li[6]/a/span"));
				opcionElegidaNenes.click();
				
				//Agrega un nene al carrito
				WebElement neneElegido=wait.until(ExpectedConditions.elementToBeClickable(By.name("add__11092")));
				String elemento2;
				WebElement textonene=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div[1]/div[4]/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/p/a"));
				elemento2=textonene.getText();
				//System.out.println(elemento2);
				neneElegido.click();
				
				WebElement inicio2=driver.findElement(By.cssSelector("a[href=\"/"));
				inicio2.click();	
				
				//Elige opcion muebles menu 
				WebElement menuOpcionNuevo =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href=\"/nuevo/310")));
				new Actions(driver).moveToElement(menuOpcionNuevo).perform();
				
				//Elegi una opcion del menu 
				WebElement opcionElegidaNuevo=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/nav/ul/li[3]/ul/li[3]/a/span"));
				opcionElegidaNuevo.click();
				
				//Agrega un nene al carrito
				WebElement nuevoElegido=wait.until(ExpectedConditions.elementToBeClickable(By.name("add__22134")));
				String elemento3;
				WebElement textonuevo=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div[1]/div[4]/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/p/a"));
				elemento3=textonuevo.getText();
				//System.out.println(elemento3);
				nuevoElegido.click();
				
				WebElement inicio3=driver.findElement(By.cssSelector("a[href=\"/"));
				inicio3.click();
				
				
				WebElement carritoCompra=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div[5]/button")));
				carritoCompra.click();

				WebElement listaCompra=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/div[5]/div/div/div[2]/div/div/button")));
				listaCompra.click();
				
				
				
				
				
				//Completar la compra
				WebElement completarCompra=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[3]/div/div/div[2]/div[1]/div/div/div[2]/div[2]/button")));
				
				String elemento4;
				WebElement textonuevo4=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[3]/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/div/div/a/span"));
				elemento4=textonuevo4.getText();
				Assert.assertEquals(elemento1, elemento4);
				
				String elemento5;
				WebElement textonuevo5=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[3]/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[2]/td[2]/div/div/a/span"));
				elemento5=textonuevo5.getText();
				Assert.assertEquals(elemento2, elemento5);
				
				String elemento6;
				WebElement textonuevo6=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[3]/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[3]/td[2]/div/div/a/span"));
				elemento6=textonuevo6.getText();
				Assert.assertEquals(elemento3, elemento6);

				String elemento7;
				WebElement textonuevo7=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[3]/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]/span"));
				elemento7=textonuevo7.getText();
				elemento7=elemento7.substring(3);
				
				String elemento8;
				WebElement textonuevo8=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[3]/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[2]/td[3]/span"));
				elemento8=textonuevo8.getText();
				elemento8=elemento8.substring(3);
				
				String elemento9;
				WebElement textonuevo9=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[3]/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[3]/td[3]/span"));
				elemento9=textonuevo9.getText();
				elemento9=elemento9.substring(3);

				Double Final= Double.valueOf(elemento7)+ Double.valueOf(elemento8) + Double.valueOf(elemento9);
				//System.out.println(Final);
				
				String elemento10;
				WebElement textonuevo10=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[3]/div/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/b"));
				elemento10=textonuevo10.getText();
				elemento10=elemento10.substring(3);
				//System.out.println(elemento10);
				Assert.assertEquals(Final,Double.valueOf(elemento10));
				
				WebElement propaganda1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/a/span/span")));
				propaganda1.click();
				
				WebElement propaganda= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/a")));
				propaganda.click();
				
				
				
				
				completarCompra.click();
				
				
				//Continuar como Invitado
				WebElement continuar =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/div/div/div/div[2]/form/div[3]/button")));
				continuar.click();
								
				
				
				
				WebElement completarDatos=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/button")));
				completarDatos.click();
				
			
				
				String formemail="fsadf@fsad.com";
				String formcode="5268719";
				String formfirstname="Fernando";
				String formlastname="Arias";
				String formlastname2="Mendoza";
				String formphonecode="";
				String formphone="72715687";
				String forminvoicenumber="4587459";
				String formcomplemento="";
				String forminvoicename="Arias";
				
				List<WebElement> inputs=driver.findElements(By.cssSelector("input"));
				inputs.get(8).sendKeys(formemail);
				inputs.get(9).sendKeys(formcode);
				inputs.get(10).sendKeys(formfirstname);
				inputs.get(11).sendKeys(formlastname);
				inputs.get(12).sendKeys(formlastname2);
				inputs.get(13).sendKeys(formphonecode);
				inputs.get(14).sendKeys(formphone);
				inputs.get(15).sendKeys(forminvoicenumber);
				inputs.get(16).sendKeys(formcomplemento);
				inputs.get(17).sendKeys(forminvoicename);
				
				List<WebElement> selects=driver.findElements(By.cssSelector("select"));
				Select ci=new Select(selects.get(1));
				ci.selectByIndex(1);
				completarDatos.click();
				
				WebElement completarDatos1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[2]/div/button")));
				completarDatos1.click();
				
				WebElement indicacionesEntrega=driver.findElement(By.xpath("//*[@id=\"form_1_additionalShippingInstructions\"]"));
				indicacionesEntrega.sendKeys("Envolver Bien");
				
				WebElement check=driver.findElement(By.xpath("//*[@id=\"checkterms_YES\"]"));
				check.click();
				
				completarDatos1.click();
				
				//List<WebElement> metodoPago=driver.findElements(By.cssSelector("input"));
				//metodoPago.get(9).click();
				//driver.findElement(By.cssSelector("label input[value=\"1"));
				
				
				
				WebElement metodoPago= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label input[value=\"1")));
				metodoPago.click();
				
				WebElement finalizarPago= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[2]/div/div[3]/div[2]/div/div/button")));
				String resultadoFinal;
				resultadoFinal=finalizarPago.getText();
				System.out.println(resultadoFinal);			
		
	}
	
	
	
	@AfterTest
	  public void after(){
    
    	driver.quit();
    }
}
