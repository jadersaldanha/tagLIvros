package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import tagLivros.Config;
import tagLivros.CsvDatapool;
import tagLivros.Drivers;
import tagLivros.IDatapool;
import tagLivros.Report;
import tasks.CheckoutTasks;

public class CheckoutIneditosTestCase {
	private static final String SYSTEM_URL = Config.get("environment.taglivros.homolog");
	private static final String DATAPOOL = Config.get("datapool.pasta");
	private WebDriver driver;
	private CheckoutTasks checkout; 
	private IDatapool datapool;

	@Before
	public void setUp() {
		Report.startTest("Processo de checkout - Clube Mensal TagLivros");
		
		this.driver = Drivers.getChromeDriver();
		this.driver.get(SYSTEM_URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		this.checkout = new CheckoutTasks(driver);
		datapool = new CsvDatapool(DATAPOOL);
	}
	
	@Test
	public void testMain() throws InterruptedException {
		this.checkout.clicarQueroIneditos();
		if (datapool.getValue("planomensal").equals("planomensal")) {
			this.checkout.planoMensal();
		}
		else {
			this.checkout.planoAnual();
		}
			
		datapool.reset();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		while(datapool.hasNext()) {
			this.checkout.digitarEmail(datapool.getValue("email"));
			Report.log(Status.PASS, "message");
			this.checkout.digitarNome(datapool.getValue("nome"));
			this.checkout.digitarSobrenome(datapool.getValue("sobrenome"));
			this.checkout.digitarCPF(datapool.getValue("cpf"));
			this.checkout.digitarCelular(datapool.getValue("celular"));
			this.checkout.clicarProximo();			
			this.checkout.digitarRua(datapool.getValue("rua"));
			this.checkout.digitarNumero(datapool.getValue("numero"));
			this.checkout.digitarComplemento(datapool.getValue("complemento"));
			this.checkout.digitarBairro(datapool.getValue("bairro"));
			this.checkout.digitarCidade(datapool.getValue("cidade"));
			this.checkout.digitarCep(datapool.getValue("cep"));
			this.checkout.digitarUf(datapool.getValue("uf"));			
			Thread.sleep(5000); //aqui tive que usar uma espera ímplicita e inclusive o thread sleep, tentei de várias formas usar webdriver wait e nao funcionou
			this.checkout.clicarProximo();
			Thread.sleep(5000); 
			this.checkout.digitarNumeroCartao(datapool.getValue("numerocartao"));
			this.checkout.digitarValidade(datapool.getValue("mmaa"));
			this.checkout.digitarCVV(datapool.getValue("cvv"));
			this.checkout.digitarNomeTitular(datapool.getValue("nometitular"));
			Thread.sleep(5000);
			this.checkout.clicarProximo();
			datapool.next();
		}
		
	}
	
	@After
	public void tearDown() {
		Report.close();
		//this.driver.quit();
	}

}
