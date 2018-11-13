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
	
	public WebElement getQueroIneditosButton () {
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
	
	public WebElement getProximo2Button () {		
		return driver.findElement(By.className("step"));
	}
	
	public WebElement getProximo3Button () {		
		return driver.findElement(By.xpath("//*[@id=\"portal\"]/div/div/div[2]/section/div/div[1]/div[2]/div/div/div/p"));
	}
	
	public WebElement getCepTextField () {
		return driver.findElement(By.name("CEP"));
	}
	
	public WebElement getRuaTextField () {
		return driver.findElement(By.name("Rua"));
	}
	
	public WebElement getNumeroTextField () {
		return driver.findElement(By.name("Número"));
	}
	
	public WebElement getComplementoTextField () {
		return driver.findElement(By.name("Complemento"));
	}
	
	public WebElement getBairroTextField () {
		return driver.findElement(By.name("Bairro"));
	}
	
	public WebElement getCidadeTextField () {
		return driver.findElement(By.name("Cidade"));
	}
	
	public WebElement getEstadoTextField () {
		return driver.findElement(By.className("select__block"));
	}
	
	public WebElement getValidadeTextField () {
		return driver.findElement(By.name("MM/AA"));
	}
	
	public WebElement getCVVTextField () {
		return driver.findElement(By.name("CVV"));
	}
	
	public WebElement getNomeTitularTextField () {
		return driver.findElement(By.name("Nome do Titular"));
	}
	
	public WebElement getNumeroCartaoTextField () {
		return driver.findElement(By.name("Número"));
	}
	
	public WebElement getSenhaTextField () {
		return driver.findElement(By.name("Senha"));
	}
	
	//Senha
	//Email
	//Data de nascimento
	//Senha
	//Número
	//MM/AA
		//CVV
		//Nome do Titular
	
	//CEP campo cep
	/*name="Rua"
	name="Número"
	name="Complemento"
	name="Bairro"
	name="Cidade"
	class="select"
	class="button__text"*/
}
