package tasks;

import org.openqa.selenium.WebDriver;
import appObjects.CheckoutAppObjects;

public class CheckoutTasks {
	
	private final CheckoutAppObjects checkout;
	
	public CheckoutTasks (WebDriver driver) {
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
		this.checkout.getProximoButton().click();
	}
	
}
