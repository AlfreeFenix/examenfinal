package testng;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class form {

	WebDriver driver;
	
	@BeforeTest()
	public void before() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver = new ChromeDriver();
		driver.get("https://alfreefenix.github.io/TestingPage/");
	}
	
	@DataProvider(name="dataNumeric")
	public Object[][] dataNumeric (){
		
		return new Object [][] {
			{"Camila", "Romero", "1993-07-04", "Femenino", "Sucre", "Calle B, Nº 37", "Casado", "85746132"},
			{"Andrés", "Castillo", "1984-11-30", "Masculino", "Oruro", "Calle C, Nº 5", "Soltero", "63492057"},
			{"Valeria", "Gutiérrez", "1988-02-28", "Femenino", "Pando", "Calle D, Nº 93", "Casado", "10987564"},
			{"José", "García", "1988-05-23", "Masculino", "Santa Cruz", "Calle B, Nº 17", "Soltero", "58713925"},
			{"María", "Pérez", "1992-09-18", "Femenino", "Cochabamba", "Calle C, Nº 59", "Casado", "40581264"},
			{"Juan", "López", "1983-03-10", "Masculino", "Tarija", "Calle D, Nº 24", "Soltero", "72708469"},
			{"Laura", "Martínez", "1977-11-08", "Femenino", "Pando", "Calle A, Nº 92", "Casado", "20653481"},
			{"Carlos", "Sánchez", "1989-07-30", "Masculino", "La Paz", "Calle E, Nº 83", "Soltero", "14392768"},
			{"Sofía", "Díaz", "1984-02-14", "Femenino", "Oruro", "Calle B, Nº 6", "Casado", "97821546"},
			{"Diego", "Fernández", "1995-10-05", "Masculino", "Sucre", "Calle C, Nº 73", "Soltero", "68873519"},
			{"Ana", "Torres", "1990-06-29", "Femenino", "Beni", "Calle D, Nº 11", "Casado", "51948367"},
			{"Pedro", "Rodríguez", "1980-04-03", "Masculino", "La Paz", "Calle A, Nº 76", "Soltero", "86254937"},
			{"Marta", "Gómez", "1987-08-20", "Femenino", "Santa Cruz", "Calle E, Nº 30", "Casado", "34169875"},
			{"Javier", "Chávez", "1982-12-12", "Masculino", "Tarija", "Calle B, Nº 44", "Soltero", "73961052"},
			{"Elena", "Ruiz", "1979-01-17", "Femenino", "Cochabamba", "Calle C, Nº 78", "Casado", "12643890"},
			{"Gabriel", "Hernández", "1991-05-09", "Masculino", "Santa Cruz", "Calle D, Nº 51", "Soltero", "68092347"},
			{"Fernanda", "Alvarez", "1986-03-26", "Femenino", "Potosí", "Calle A, Nº 88", "Casado", "15476392"},
			{"Luis", "Moreno", "1978-09-11", "Masculino", "La Paz", "Calle E, Nº 19", "Soltero", "39521867"},
			{"Ricardo", "Núñez", "1981-06-15", "Masculino", "Cochabamba", "Calle A, Nº 62", "Soltero", "78301492"},
			{"Paula", "Sosa", "1990-10-19", "Femenino", "Beni", "Calle E, Nº 77", "Casado", "62571934"},
			{"Miguel", "Martínez", "1985-04-12", "Masculino", "La Paz", "Calle B, Nº 16", "Soltero", "29814573"},
			{"Marina", "García", "1989-08-01", "Femenino", "Santa Cruz", "Calle C, Nº 49", "Casado", "50739284"},
			{"Francisco", "Pérez", "1983-01-28", "Masculino", "Tarija", "Calle D, Nº 21", "Soltero", "43682519"},
			{"Julia", "Sánchez", "1986-07-13", "Femenino", "Potosí", "Calle A, Nº 95", "Casado", "91784635"},
			{"Ángel", "Gómez", "1981-12-06", "Masculino", "La Paz", "Calle E, Nº 11", "Soltero", "70493128"},
			{"Carmen", "Rodríguez", "1995-03-03", "Femenino", "Oruro", "Calle B, Nº 29", "Casado", "83216947"},
			{"Lorenzo", "Díaz", "1980-05-27", "Masculino", "Sucre", "Calle C, Nº 72", "Soltero", "16974825"},
			{"Lucía", "Hernández", "1992-11-23", "Femenino", "Santa Cruz", "Calle D, Nº 56", "Casado", "34592081"},
			{"Isaac", "Ruiz", "1977-09-09", "Masculino", "Pando", "Calle A, Nº 82", "Soltero", "52098734"},
			{"Isabel", "Moreno", "1988-12-16", "Femenino", "Cochabamba", "Calle E, Nº 7", "Casado", "78694532"},
			{"Lucas", "Gómez", "1983-06-21", "Masculino", "La Paz", "Calle B, Nº 35", "Soltero", "14986027"},
			{"Carolina", "Fernández", "1986-02-18", "Femenino", "Sucre", "Calle C, Nº 84", "Casado", "36928514"},
			{"Tomás", "Pérez", "1991-08-08", "Masculino", "Tarija", "Calle D, Nº 67", "Soltero", "95410287"},
			{"Valentina", "Chávez", "1980-04-24", "Femenino", "Potosí", "Calle A, Nº 90", "Casado", "73169845"},
			{"Mariano", "Alvarez", "1993-01-10", "Masculino", "La Paz", "Calle E, Nº 39", "Soltero", "68913542"},
			{"Carla", "Romero", "1985-10-05", "Femenino", "Santa Cruz", "Calle B, Nº 22", "Casado", "81736429"},
			{"Alberto", "Martínez", "1984-07-02", "Masculino", "Pando", "Calle C, Nº 68", "Soltero", "26407938"},
			{"Rosa", "Gutiérrez", "1989-03-01", "Femenino", "Cochabamba", "Calle D, Nº 80", "Casado", "50839671"},
			{"Fernando", "Núñez", "1977-06-28", "Masculino", "Sucre", "Calle A, Nº 48", "Soltero", "93687421"},
			{"Raquel", "Sosa", "1992-09-03", "Femenino", "La Paz", "Calle E, Nº 5", "Casado", "78532196"},
			{"Emilio", "Hernández", "1988-12-28", "Masculino", "Santa Cruz", "Calle B, Nº 26", "Soltero", "41970853"},
			{"Beatriz", "Torres", "1981-08-14", "Femenino", "Tarija", "Calle C, Nº 99", "Casado", "53094278"},
			{"Lorenza", "García", "1995-02-25", "Femenino", "Potosí", "Calle D, Nº 33", "Soltero", "87421936"},
			{"Maximiliano", "Sánchez", "1980-11-19", "Masculino", "La Paz", "Calle A, Nº 14", "Casado", "63948712"}
		};
	}
	
	@Test(dataProvider = "dataNumeric")
	public void test(String nombre, String apellido, String fecha, String generoStr, String ciudadStr, String direccion, String estadoCivil, String telefono) {
	    WebElement mnListForm = driver.findElement(By.cssSelector("a[href='/TestingPage/form']"));
	    mnListForm.click();

	 // Obtener los inputs del formulario
	    List<WebElement> inputs = driver.findElements(By.cssSelector("input")); 

		inputs.get(0).sendKeys(nombre);
		inputs.get(1).sendKeys(apellido);
		inputs.get(2).sendKeys(fecha);
		inputs.get(2).sendKeys(Keys.ENTER);
		
		List<WebElement> selects = driver.findElements(By.cssSelector("select")); 
		Select genero = new Select(selects.get(0));
		genero.selectByValue(generoStr);
		
		Select ciudad = new Select(selects.get(1));
		ciudad.selectByValue(ciudadStr);
		
		inputs.get(3).sendKeys(direccion);
		List<WebElement> radios = driver.findElements(By.cssSelector("input[type='radio']"));

		for (WebElement radio : radios) {
		    if (radio.getAttribute("value").equalsIgnoreCase(estadoCivil)) {
		        radio.click();
		        break;
		    }
		}

	    
        inputs.get(6).sendKeys(telefono);
		
		WebElement btnGuardar = driver.findElement(By.cssSelector("button"));
		
		btnGuardar.click();
		String mensaje = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		Assert.assertEquals("Informacion guardada", mensaje);
	}

	@AfterTest()
    public void after() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
}
