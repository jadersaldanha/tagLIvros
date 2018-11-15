package verificationPoints;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import tagLivros.Config;
import tagLivros.Generator;
import tagLivros.Report;
import tagLivros.Screenshot;

public class ValidarAcessodeUsuarioVerificationPoint {
		
	private final WebDriver driver;
	WebDriverWait aguardar;
	String screenshotArquivo1 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
	private static final String IMAGEPATH = Config.get("screenshot.pasta");
  
    public ValidarAcessodeUsuarioVerificationPoint (WebDriver driver) {
    	this.driver = driver;
    	this.aguardar = new WebDriverWait(driver, 10);
    }
    
    public void validarMensagemErro(String message) {
    	if(message.equals(driver.findElement(By.className("mensageria__block--error")).getText())) {
    		Report.logPass("Exibiu a mensagem corretamente.");
    	} else {
    		Screenshot.Tirar(driver, screenshotArquivo1);
			Report.logFail("Não exibiu a mensagem corretamente.");
    		fail("Não exibiu a mensagem corretamente.");
    	}
    }

}
