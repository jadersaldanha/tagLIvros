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

public class AcessarAreadeUsuarioTestCase {
	
	private static final String SYSTEM_URL = Config.get("environment.taglivros.areausuario");
	private static final String DATAPOOL = Config.get("datapool.pasta");
	private WebDriver driver;
	private CheckoutTasks checkout; 
	private IDatapool datapool;

	@Before
	public void setUp() {
		Report.startTest("Processo de checkou - Clube Mensal TagLivros");
		
		this.driver = Drivers.getChromeDriver();
		this.driver.get(SYSTEM_URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		this.checkout = new CheckoutTasks(driver);
		datapool = new CsvDatapool(DATAPOOL);
	}
	
	@Test
	public void testMain() throws InterruptedException {
		this.checkout.digitarEmail(datapool.getValue("email"));
		this.checkout.digitarSenha(datapool.getValue("senha"));
		this.checkout.clicarProximo();
	}
	
	@After
	public void tearDown() {
		Report.close();
		this.driver.quit();
	}


}
