package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import tagLivros.Config;
import tagLivros.CsvDatapool;
import tagLivros.Drivers;
import tagLivros.IDatapool;
import tagLivros.Report;
import tasks.CheckoutTasks;

public class CheckoutTestCase {	
	private static final String SYSTEM_URL = Config.get("environment.taglivros.homolog");
	private static final String DATAPOOL = Config.get("datapool.pasta");
	private WebDriver driver;
	private CheckoutTasks checkout; 
	private IDatapool datapool;

	@Before
	public void setUp() {
		Report.startTest("Procurar Item e tenta adicioná-lo ao carrinho");
		
		this.driver = Drivers.getChromeDriver();
		this.driver.get(SYSTEM_URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		this.checkout = new CheckoutTasks(driver);
		datapool = new CsvDatapool(DATAPOOL);
	}
	
	@Test
	public void testMain() {
		this.checkout.clicarQueroCuradoria();
		this.checkout.planoMensal();
		datapool.reset();
		
		while(datapool.hasNext()) {
			this.checkout.digitarEmail(datapool.getValue("email"));
			Report.log("PASS", "message");
			this.checkout.digitarNome(datapool.getValue("nome"));
			this.checkout.digitarSobrenome(datapool.getValue("sobrenome"));
			this.checkout.digitarCPF(datapool.getValue("cpf"));
			this.checkout.digitarCelular(datapool.getValue("celular"));
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
