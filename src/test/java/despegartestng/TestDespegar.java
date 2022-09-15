package despegartestng;


import java.util.Set; //---> set cambio de foco

import org.junit.Assert;

import org.openqa.selenium.Keys;

import org.openqa.selenium.chrome.ChromeDriver;


//////////////////////////

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestDespegar {
	
	 private WebDriver driver; //--> declaramos el webdriver

	  
	  By imputDestLocator = By.xpath("//div[@class='sbox5-box-container']/div[3]/div[1]/div/div/div/input");
	  
	  By imputCalenEntradaLoc = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div");
	  By imputCalenEntradaLoc2 = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div/div/input");
	  
	  By imputFechaEntradaLoc = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[21]/div");
	  
	  By imputFechaSaliLoc = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[25]/div");
	  
	  By imputAplicarCaleLoc = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button/em");
	  

	  By imputCerrarFaceLoc = By.xpath("/html/body/nav/div[4]/div[1]/i"); //--> locator para cerrar ventana de facebook
	  
	  By imputCerrarCoquiesLoc = By.xpath("//*[@id=\"lgpd-banner\"]/div/a[2]/em"); //--> locator para cerrar ventana de cooquies

	 By imputHabitacionesLoc = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[3]/div/div");
	 
	By imputSumaAdultoLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/button[2]");
	By imputSumaMenorLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/button[2]"); 
	 

	By imputSelectEdadMenorLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/select");
	By imputSelectOchoAñosLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/select/option[10]"); 


	By imputSlectAplicarHabitacion = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[2]/a[1]/em");

	By imputSelectBuscarLoc = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/button"); //--> buscar
	//By imputSelectBuscarLoc = By.className("btn-text"); //--> buscar , pero con class Name


	By imputSelectHotelLoc = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[3]/div[1]/aloha-cluster-container/div/div/div[1]/div/div[2]/div[1]");

	By ValidaTituloLoc = By.xpath("//h1[@class=\"sbox5-title\"]"); //--> valida ttitulo
	By validaTituloDosLoc = By.xpath("/html/body/aloha-app-root/aloha-detail/div/div[3]/div/div/div/aloha-accommodation-name/h1"); //--> valida el titulo de la otra pagina
	 
 
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");  // ubicacion del webdriver
	  driver = new ChromeDriver(); // creo objeto webdriver
	  driver.manage().window().maximize(); // maximiza la ventana
	  driver.get("http://www.despegar.com.ar/hoteles");
  }
  
  
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(5000); //---> espera para que carge ventana emergente de facebook
	  driver.findElement(imputCerrarFaceLoc).click(); //-->  cierra emergente face
	  driver.findElement(imputCerrarCoquiesLoc).click(); //-->  cierra emergente cooquies
	  driver.findElement(imputDestLocator).click(); // clickeamos para ingresar el destino
	  Thread.sleep(1000); // espera
	  driver.findElement(imputDestLocator).sendKeys("Mendoza mendoza argentina"); // sendkeys envia texto con el destino
	  Thread.sleep(1000); // espera
	  driver.findElement(imputDestLocator).sendKeys(Keys.ENTER); // hacemos click enter
	  
	  driver.findElement(imputCalenEntradaLoc2).click(); // hace click en la entrada del calendario
	  Thread.sleep(1000);
	  driver.findElement(imputFechaEntradaLoc).click(); // fecha de entada /////---> 	    
	  Thread.sleep(2000);	 
	  driver.findElement(imputFechaSaliLoc).click(); //--> fecha de salida 
	  Thread.sleep(5000);
	  driver.findElement(imputAplicarCaleLoc).click();  //--> click en aplicar al calendario
	  
	  driver.findElement(imputHabitacionesLoc).click(); //---> click para abrir habitaciones
	  Thread.sleep(1000);
	  driver.findElement(imputSumaAdultoLoc).click(); //--> suma 1 adulto
	  driver.findElement(imputSumaMenorLoc).click(); //--> suma 1 niño 
	  driver.findElement(imputSelectEdadMenorLoc).click(); //--> despliga combo ellecion de edad del menor
	
	  driver.findElement(imputSelectOchoAñosLoc).click();
	  Thread.sleep(1000);
	  driver.findElement(imputSlectAplicarHabitacion).click(); //--> selecciona 8 años
	  Thread.sleep(3000);
	  driver.findElement(imputSelectBuscarLoc).click(); //--> click buscar
	  Thread.sleep(10000);
	  
	  Assert.assertTrue(driver.findElement(ValidaTituloLoc).isDisplayed()); //--> validacion de titulo
	  
	  driver.findElement(imputSelectHotelLoc).click();//--> selecciono la primera opcion de la busqueda
	  Thread.sleep(5000);
	  
	  //--- cambio de foco ---//
	  
	  Set <String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if(!actual.equalsIgnoreCase(driver.getWindowHandle())) {
				driver.switchTo().window(actual);
			
			}
		}
	Thread.sleep(5000);
    Assert.assertTrue(driver.findElement(validaTituloDosLoc).isDisplayed()); //--> validacion de Titulo 
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit(); // cerramos el navegador
  }
  
}