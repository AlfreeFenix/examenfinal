package examenfinal;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.*;

public class casaIdeasTest {
	WebDriver driver;
	
	@BeforeTest()
	public void Before() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.casaideas.com.bo/espacios-de-la-casa/bano/24?utm_source=GoogleAds_BR&utm_medium=Search_Troncal_Ba%C3%B1o&utm_campaign=Keywords_Casaideas&gad_source=1&gad_campaignid=22125802313&gbraid=0AAAAACVFJQAH0PEUoP07dlhIOFfAJSWCS&gclid=Cj0KCQjww-HABhCGARIsALLO6XzR5I0fU7UpF8POzpZAbs5NOiPSPSXrkP7FNSR5nvQ4TacLcPdNAlYaAjEdEALw_wcB");	
		
		
	}
	
	@Test()
	public void Test() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement btnDepartamento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='61' and text()='COCHABAMBA']")));
		
		Thread.sleep(3000);
		btnDepartamento.click();
		
		WebElement productosMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='PRODUCTOS']")));
		Actions actions = new Actions(driver);
		actions.moveToElement(productosMenu).perform();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement menuEspacios = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'ESPACIOS DE LA CASA')]")));
		
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(menuEspacios).perform();
		
		WebElement bebeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[span[text()='Bebé']]")));
		bebeLink.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement imagen = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@src, '3108971000405_1_mini.jpg')]")));
		
		if (imagen != null) {
		    imagen.click();
		}
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement botonAgregarAlCarro = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'AGREGAR AL CARRO')]")));

		botonAgregarAlCarro.click();

		//comprano el producto 3
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement productosMenu1 = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'PRODUCTOS')]")));
	    productosMenu1.click();

		Thread.sleep(3000);
		
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement menuEspacios1 = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'ESPACIOS DE LA CASA')]")));
		
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(menuEspacios1).perform();
		
		WebElement comedorLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[span[contains(text(),'Comedor')]]")));
		comedorLink.click();
		
		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement imagenProducto1 = wait7.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@src, '3228217000010_1_mini.jpg')]")));

		if (imagenProducto1 != null) {
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", imagenProducto1);
		    
		    Thread.sleep(2000);
		    
		    imagenProducto1.click();
		    
		}
		
		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement botonAgregarAlCarro1 = wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'AGREGAR AL CARRO')]")));

		botonAgregarAlCarro1.click();
		
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement productosMenu2 = wait9.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'PRODUCTOS')]")));
	    productosMenu2.click();

		Thread.sleep(3000);
		
		
		
		
		
		// para entrar al carrito
		//WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement carritoButton = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='no-button mini-cart-icon']")));

		//carritoButton.click();
			
	}
	    
	@AfterTest()
	public void After() {
		
		
	}

}
