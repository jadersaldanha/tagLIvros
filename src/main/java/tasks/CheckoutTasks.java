package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appObjects.CheckoutAppObjects;

public class CheckoutTasks {
	
	private final CheckoutAppObjects checkout;
	private WebDriver driver;
	
	public CheckoutTasks (WebDriver driver) {
		this.driver = driver;
		this.checkout = new CheckoutAppObjects(driver); 
	}
	
	public void clicarQueroCuradoria () {
		this.checkout.getQueroCuradoriaButton().click();	
	}
	
	public void planoMensal () {
		this.checkout.getPlanoMensalButton().click();
	}
	
	public void digitarEmail(String email) {
		
		this.checkout.getEmailCadastroTextField().sendKeys(email);
	}
	
	public void digitarNome(String nome) {
		this.checkout.getNomeCadastroTextField().sendKeys(nome);
	}
	
	public void digitarSobrenome(String sobrenome) {
		this.checkout.getSobrenomeTextField().sendKeys(sobrenome);
	}
	
	public void digitarCPF(String cpf) {
		this.checkout.getCpfTextField().sendKeys(cpf);
	}
	
	public void digitarCelular(String celular) {
		this.checkout.getCelularTextField().sendKeys(celular);
	}
	
	public void clicarProximo() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("button__text")));
		this.checkout.getProximoButton().click();
	}
	
	public void clicarProximo2() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("step")));
		this.checkout.getProximo2Button().click();
	}

	public void clicarProximo3() {
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Próximo")));
		//this.checkout.getProximo3Button().click();
		this.checkout.getNumeroTextField().submit();
	}
	
	public void digitarCep(String cep) {
		this.checkout.getCepTextField().sendKeys(cep);
	}
	
	public void digitarRua(String rua) {
		this.checkout.getRuaTextField().sendKeys(rua);
	}
	
	public void digitarNumero(String numero) {
		this.checkout.getNumeroTextField().sendKeys(numero);
	}
	
	public void digitarComplemento(String complemento) {
		this.checkout.getComplementoTextField().sendKeys(complemento);
		//this.checkout.getComplementoTextField().submit();
	}
	
	public void digitarBairro(String bairro) {
		this.checkout.getBairroTextField().sendKeys(bairro);
	}
	
	public void digitarCidade(String cidade) {
		this.checkout.getCidadeTextField().sendKeys(cidade);
	}
	
	public void digitarUf(String uf) {
		this.checkout.getEstadoTextField().click();
		//final Select selectBox = new Select(this.checkout.getEstadoTextField());
		//selectBox.selectByValue(uf);
		//this.checkout.getEstadoTextField().submit();
		//this.checkout.getEstadoTextField().sendKeys(Softkey);.sendKeys(uf);
	}
	
	public void digitarValidade(String validade) {
		this.checkout.getValidadeTextField().sendKeys(validade);
	}
	
	public void digitarCVV(String cvv) {
		this.checkout.getCVVTextField().sendKeys(cvv);
	}
	
	public void digitarNomeTitular(String nometitular) {
		this.checkout.getNomeTitularTextField().sendKeys(nometitular);
	}
	
	public void digitarNumeroCartao(String numerocartao) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(this.checkout.getNumeroCartaoTextField()));
		 //this.checkout.getProximo3Button().click();
		this.checkout.getNumeroCartaoTextField().sendKeys(numerocartao);
	}
	
	public void digitarSenha(String senha) {
		this.checkout.getSenhaTextField().sendKeys(senha);;
	}
}
