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
import tagLivros.Generator;
import tagLivros.IDatapool;
import tagLivros.Report;
import tagLivros.Screenshot;
import tasks.CheckoutTasks;
import verificationPoints.ValidarAcessodeUsuarioVerificationPoint;

public class AcessarAreadeUsuarioTestCase {
	
	private static final String SYSTEM_URL = Config.get("environment.taglivros.areausuario");
	private static final String DATAPOOL = Config.get("datapool.pasta");
	private static final String IMAGEPATH = Config.get("screenshot.pasta");
	private WebDriver driver;
	private CheckoutTasks checkout; 
	private IDatapool datapool;
	private ValidarAcessodeUsuarioVerificationPoint validar;

	@Before
	public void setUp() {
		Report.startTest("Acesso a Area de Usuario");
		
		this.driver = Drivers.getChromeDriver();
		this.driver.get(SYSTEM_URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		this.checkout = new CheckoutTasks(driver);
		datapool = new CsvDatapool(DATAPOOL);
		this.validar = new ValidarAcessodeUsuarioVerificationPoint(this.driver);
	}
	
	@Test
	public void testMain() throws InterruptedException {
		String screenshotArquivo1 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
		this.checkout.digitarEmail(datapool.getValue("email"));
		Screenshot.Tirar(driver, screenshotArquivo1);
		Report.log(Status.PASS, "Digitou e-amail", screenshotArquivo1);
		this.checkout.digitarSenha(datapool.getValue("senha"));
		String screenshotArquivo2 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
		Screenshot.Tirar(driver, screenshotArquivo2);
		Report.log(Status.PASS, "Digitou senha", screenshotArquivo2);
		this.checkout.clicarProximo();
		validar.validarMensagemErro("Ocorreu um erro de conexão. Por favor, verifique seu dados e tente novamente.");	
	}
	
	@After
	public void tearDown() {
		Report.close();
		this.driver.quit();
	}
}
