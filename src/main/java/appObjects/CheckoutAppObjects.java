package appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutAppObjects {
	
	private WebDriver driver; 
	
	public CheckoutAppObjects (WebDriver driver) {
		this.driver = driver;		
	}

	public WebElement getQueroCuradoriaButton () {
		return driver.findElement(By.className("button__text"));
	}
	
	public WebElement getPlanoMensalButton () {
		return driver.findElement(By.className("button__content"));
	}
	
	public WebElement getEmailCadastroTextField () {
		return driver.findElement(By.name("E-mail"));
	}
	
	public WebElement getNomeCadastroTextField () {
		return driver.findElement(By.name("Nome"));
	}
	
	public WebElement getSobrenomeTextField () {
		return driver.findElement(By.name("Sobrenome"));
	}
	
	public WebElement getCpfTextField () {
		return driver.findElement(By.name("CPF"));
	}
	
	public WebElement getCelularTextField () {
		return driver.findElement(By.name("Celular"));
	}
	
	public WebElement getProximoButton () {
		return driver.findElement(By.className("button__text"));
	}
	
	//CEP campo cep
	/*name="Rua"
	name="Número"
	name="Complemento"
	name="Bairro"
	name="Cidade"
	class="select"
	class="button__text"*/
}
