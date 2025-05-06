package examenEK;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


public class examenfinal {
	
	WebDriver driver;
	
  @Test(description="Examen final Erika Kenta")
  public void f() throws InterruptedException {	  
	  // Product 1	  
	  WebElement menu1 = driver.findElement(By.xpath("//a[text()='ESPACIOS DE LA CASA']"));
	  menu1.click();
	  System.out.println("Espera carga Menu1_1");
	  Thread.sleep(5000);
	  System.out.println("Fin espera carga Menu1_1");
	  WebElement menu1_1 = driver.findElement(By.cssSelector("a[href='/espacios-de-la-casa/accesorios-personales/28']"));
	  menu1_1.click();
	  System.out.println("Espera carga Menu1_1_1");
	  Thread.sleep(10000);
	  System.out.println("Fin espera carga Menu1_1_1");
	  WebElement product1 = driver.findElement(By.cssSelector("a[href='/espacios-de-la-casa/accesorios-personales/bolsa-de-agua-con-funda-2-litros-21733']"));
	  product1.click();
	  System.out.println("Espera carga Producto 1");
	  Thread.sleep(10000);
	  System.out.println("Fin espera carga Producto 1");
	  WebElement btnCarrito1 = driver.findElement(By.xpath("//button[text()='AGREGAR AL CARRO']"));
	  btnCarrito1.click();
	  // Carrito
	  List <WebElement> buttons1Carrito = driver.findElements(By.className("no-button"));
	  (buttons1Carrito.get(2)).click();
	  List <WebElement> divsCarrito1 = driver.findElements(By.cssSelector(".card-body.mini-cart"));
	  List <WebElement> divs1Carrito1 = (divsCarrito1.get(0)).findElements(By.cssSelector(".row.mt-2"));
	  List <WebElement> prd1EnCarrito = (divs1Carrito1.get(0)).findElements(By.cssSelector("a"));
	  System.out.println("Prod1...");
	  System.out.println((prd1EnCarrito.get(1)).getText());
	  String prd1 = "BOLSA DE AGUA CON FUNDA 2 LITROS";
	  Assert.assertEquals(prd1, (prd1EnCarrito.get(1)).getText());
	  (buttons1Carrito.get(2)).click();
	  
	  // Product 2
	  WebElement menu1_prd2 = driver.findElement(By.xpath("//a[text()='NUEVO']"));
	  menu1_prd2.click();
	  System.out.println("Espera carga menu1_prd2");
	  Thread.sleep(10000);
	  System.out.println("Fin espera carga menu1_prd2");
	  WebElement menu1_1_prd2 = driver.findElement(By.cssSelector("a[href='/nuevo/maceta-con-diseno-emboss-flores-14-5x12-5-cm-21852']"));
	  menu1_1_prd2.click();
	  System.out.println("Espera carga menu1_1_prd2");
	  Thread.sleep(10000);
	  System.out.println("Fin espera carga menu1_1_prd2");
	  WebElement btnCarrito2 = driver.findElement(By.xpath("//button[text()='AGREGAR AL CARRO']"));
	  btnCarrito2.click();
	  // Carrito
	  List <WebElement> buttons2Carrito = driver.findElements(By.className("no-button"));
	  (buttons2Carrito.get(2)).click();
	  List <WebElement> divsCarrito2 = driver.findElements(By.cssSelector(".card-body.mini-cart"));
	  List <WebElement> divs1Carrito2 = (divsCarrito2.get(0)).findElements(By.cssSelector(".row.mt-2"));
	  List <WebElement> prd2EnCarrito = (divs1Carrito2.get(1)).findElements(By.cssSelector("a"));
	  System.out.println("Prod2...");
	  System.out.println((prd2EnCarrito.get(1)).getText());
	  String prd2 = "MACETA CON DISEÑO EMBOSS FLORES 14,5X12,5 CM";
	  Assert.assertEquals(prd2, (prd2EnCarrito.get(1)).getText());
	  (buttons2Carrito.get(2)).click();
	  
	  // Product 3
	  WebElement menu1_prd3 = driver.findElement(By.xpath("//a[text()='MUEBLES']"));
	  menu1_prd3.click();
	  System.out.println("Espera carga menu1_prd3");
	  Thread.sleep(5000);
	  System.out.println("Fin espera carga menu1_prd3");
	  WebElement product3 = driver.findElement(By.cssSelector("a[href='/muebles/carro-multiuso-45x31x80cm-19115']"));
	  product3.click();
	  System.out.println("Espera carga Producto 3");
	  Thread.sleep(5000);
	  System.out.println("Fin espera carga Producto 3");
	  WebElement btnCarrito3 = driver.findElement(By.xpath("//button[text()='AGREGAR AL CARRO']"));
	  btnCarrito3.click();
	  // Carrito
	  List <WebElement> buttons3Carrito = driver.findElements(By.className("no-button"));
	  (buttons3Carrito.get(2)).click();
	  List <WebElement> divsCarrito3 = driver.findElements(By.cssSelector(".card-body.mini-cart"));
	  //"row mt-2
	  List <WebElement> divs1Carrito3 = (divsCarrito3.get(0)).findElements(By.cssSelector(".row.mt-2"));
	  List <WebElement> prd3EnCarrito = (divs1Carrito3.get(2)).findElements(By.cssSelector("a"));
	  System.out.println("Prod3...");
	  System.out.println((prd3EnCarrito.get(1)).getText());
	  String prd3 = "CARRO MULTIUSO 45X31X80CM";
	  Assert.assertEquals(prd3, (prd3EnCarrito.get(1)).getText());
	  //(buttons3Carrito.get(2)).click();
	  
	  // Suma y total
	  WebElement totalCarrito = (((divsCarrito3).get(0)).findElements(By.cssSelector(".text-price"))).get(0);
	  WebElement subtotal1 = (((divsCarrito3).get(0)).findElements(By.cssSelector(".text-price"))).get(1);
	  WebElement subtotal2 = (((divsCarrito3).get(0)).findElements(By.cssSelector(".text-price"))).get(2);
	  WebElement subtotal3 = (((divsCarrito3).get(0)).findElements(By.cssSelector(".text-price"))).get(3);
	  double total = Float.parseFloat(totalCarrito.getText().replaceFirst("Bs.", ""));
	  double s1 = Float.parseFloat(subtotal1.getText().replaceFirst("Bs.", ""));
	  double s2 = Float.parseFloat(subtotal2.getText().replaceFirst("Bs.", ""));
	  double s3 = Float.parseFloat(subtotal3.getText().replaceFirst("Bs.", ""));
	  Assert.assertEquals(total, (s1+s2+s3));
	  
	  // Completar form compra  
	  System.out.println("b1...");
	  Thread.sleep(5000);
	  //btn btn-sm btn-primary mr-2
	  List <WebElement> buttonsCComp1= driver.findElements(By.cssSelector(".btn.btn-sm.btn-primary.mr-2"));
	  (buttonsCComp1.get(0)).click();
	  Thread.sleep(5000);
	  System.out.println("b2...");
	  List <WebElement> buttonsCComp2= driver.findElements(By.cssSelector(".btn.btn-primary.pagebuilder-column-1"));
	  (buttonsCComp2.get(0)).click();
	  System.out.println("b3...");
	  List <WebElement> buttonsInvitado= driver.findElements(By.cssSelector(".btn.btn-outline-primary.btn-block"));
	  (buttonsInvitado.get(0)).click();	
	  System.out.println("b4...");
	  Thread.sleep(18000);
	  //exponea-close-cross
	  List <WebElement> span1 = driver.findElements(By.cssSelector(".exponea-close-cross"));
	  (span1.get(0)).click();
	  //btnClose
	  //List <WebElement> btnClose = driver.findElements(By.cssSelector(".btnClose"));
	  //(btnClose.get(0)).click();
	  //System.out.println("b4.1...");
	  WebElement txtEmail = driver.findElement(By.id("formemail"));
	  txtEmail.clear();
	  txtEmail.sendKeys("gtgtgt@gmail.com");
	  WebElement txtCI = driver.findElement(By.id("formcode"));
	  txtCI.clear();
	  txtCI.sendKeys("753421869");
	  WebElement txtNombres = driver.findElement(By.id("formfirstname"));
	  txtNombres.clear();
	  txtNombres.sendKeys("Penny");
	  WebElement txtApellido1 = driver.findElement(By.id("formlastname"));
	  txtApellido1.clear();
	  txtApellido1.sendKeys("Smith");
	  WebElement txtApellido2 = driver.findElement(By.id("formlastname2"));
	  txtApellido2.clear();
	  txtApellido2.sendKeys("Gore");
	  WebElement txtCelu = driver.findElement(By.id("formphone"));
	  txtCelu.clear();
	  txtCelu.sendKeys("77794103");
	  Select selCiudad   = new Select(driver.findElement(By.id("formcity")));		
	  selCiudad.selectByIndex(0);
	  Select selTipo   = new Select(driver.findElement(By.id("formtipodoc")));		
	  selTipo.selectByValue("1");
	  WebElement txtIdFact = driver.findElement(By.id("forminvoicenumber"));
	  txtIdFact.clear();
	  txtIdFact.sendKeys("951623478");
	  WebElement txtNomFact = driver.findElement(By.id("forminvoicename"));
	  txtNomFact.clear();
	  txtNomFact.sendKeys("Smith");
	  System.out.println("b5...");
	  List <WebElement> buttonsContinuar1 = driver.findElements(By.cssSelector(".ml-2.btn.btn-md.btn-primary.shipping-form-btn"));
	  (buttonsContinuar1.get(0)).click();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0, 800);");
	  //System.out.println("b6...");
	  //List <WebElement> buttonsContinuar2 = driver.findElements(By.cssSelector(".btn.btn-primary-rigth-button.btn-primary-active"));
	  //(buttonsContinuar2.get(0)).click();
	  Thread.sleep(5000);
	  System.out.println("b7...");
	  WebElement term = driver.findElement(By.id("checkterms_YES"));
	  term.click();
	  WebElement textIndica = driver.findElement(By.id("form_1_additionalShippingInstructions"));
	  textIndica.clear();
	  textIndica.sendKeys("parque sur");
	  System.out.println("b8...");
	  List <WebElement> buttonsContinuar3 = driver.findElements(By.cssSelector(".btn.btn-md.btn-primary.shipping-form-btn"));
	  (buttonsContinuar3.get(0)).click();
	  Thread.sleep(5000);
	  js.executeScript("window.scrollBy(0, 0);");	  	  
	  List <WebElement> chkPagos = driver.findElements(By.name("m1"));
	  chkPagos.get(1).click();
	  js.executeScript("window.scrollBy(0, 0);");	
	  //btn btn-primary text-bold
	  String finMsg = "Finalizar Pedido";
	  System.out.println("b9...");
	  List <WebElement> buttonsFin = driver.findElements(By.name("close"));
	  WebElement buttonFin         = buttonsFin.get(0);
	  System.out.println(buttonFin.getText());
	  Assert.assertEquals(finMsg,buttonFin.getText());
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://www.casaideas.com.bo/");
	  System.out.println("Espera carga menu ciudades");
	  Thread.sleep(20000);
	  System.out.println("Fin de espera carga menu ciudades");
	  WebElement btnLPZ = driver.findElement(By.name("59"));
	  btnLPZ.click();
	  System.out.println("Espera carga Menu1");
	  Thread.sleep(30000);
	  System.out.println("Fin espera carga Menu1"); 
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(5000);
	  //driver.close();
  }

}
