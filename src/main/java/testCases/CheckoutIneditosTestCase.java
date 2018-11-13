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

public class CheckoutIneditosTestCase {
	private static final String SYSTEM_URL = Config.get("environment.taglivros.homolog");
	private static final String DATAPOOL = Config.get("datapool.pasta");
	private static final String IMAGEPATH = Config.get("screenshot.pasta");
	private WebDriver driver;
	private CheckoutTasks checkout; 
	private IDatapool datapool;

	@Before
	public void setUp() {
		Report.startTest("Processo de Checkout Inéditos - Clube TagLivros");
		
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
			String screenshotArquivo1 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarEmail(datapool.getValue("email"));
			Screenshot.Tirar(driver, screenshotArquivo1);
			Report.log(Status.PASS, "Digitou e-mail", screenshotArquivo1);
			
			String screenshotArquivo2 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarNome(datapool.getValue("nome"));
			Screenshot.Tirar(driver, screenshotArquivo2);
			Report.log(Status.PASS, "Digitou nome", screenshotArquivo2);
			
			String screenshotArquivo3 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarSobrenome(datapool.getValue("sobrenome"));
			Screenshot.Tirar(driver, screenshotArquivo3);
			Report.log(Status.PASS, "Digitou sobrenome", screenshotArquivo3);
			
			String screenshotArquivo4 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarCPF(datapool.getValue("cpf"));
			Screenshot.Tirar(driver, screenshotArquivo4);
			Report.log(Status.PASS, "Digitou cpf", screenshotArquivo4);
			
			String screenshotArquivo5 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarCelular(datapool.getValue("celular"));
			Screenshot.Tirar(driver, screenshotArquivo5);
			Report.log(Status.PASS, "Digitou celular", screenshotArquivo5);
			
			String screenshotArquivo6 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.clicarProximo();	
			Screenshot.Tirar(driver, screenshotArquivo6);
			Report.log(Status.PASS, "Clicou proximo", screenshotArquivo6);
			
			String screenshotArquivo7 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarRua(datapool.getValue("rua"));
			Screenshot.Tirar(driver, screenshotArquivo7);
			Report.log(Status.PASS, "Digitou rua", screenshotArquivo7);
			
			String screenshotArquivo8 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarNumero(datapool.getValue("numero"));
			Screenshot.Tirar(driver, screenshotArquivo8);
			Report.log(Status.PASS, "Digitou numero", screenshotArquivo8);
			
			String screenshotArquivo9 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarComplemento(datapool.getValue("complemento"));
			Screenshot.Tirar(driver, screenshotArquivo9);
			Report.log(Status.PASS, "Digitou complemento", screenshotArquivo9);
			
			String screenshotArquivo10 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarBairro(datapool.getValue("bairro"));
			Screenshot.Tirar(driver, screenshotArquivo10);
			Report.log(Status.PASS, "Digitou bairro", screenshotArquivo10);
			
			String screenshotArquivo11 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarCidade(datapool.getValue("cidade"));
			Screenshot.Tirar(driver, screenshotArquivo11);
			Report.log(Status.PASS, "Digitou cidade", screenshotArquivo11);
			
			String screenshotArquivo12 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarCep(datapool.getValue("cep"));
			Screenshot.Tirar(driver, screenshotArquivo12);
			Report.log(Status.PASS, "Digitou cep", screenshotArquivo12);
			
			String screenshotArquivo13 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarUf(datapool.getValue("uf"));
			Screenshot.Tirar(driver, screenshotArquivo1);
			Report.log(Status.PASS, "Digitou UF", screenshotArquivo13);
			
			Thread.sleep(5000); //aqui tive que usar uma espera ímplicita e inclusive o thread sleep, tentei de várias formas usar webdriver wait e nao funcionou
			this.checkout.clicarProximo();
			Thread.sleep(5000); 
			String screenshotArquivo15 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarNumeroCartao(datapool.getValue("numerocartao"));
			Screenshot.Tirar(driver, screenshotArquivo15);
			Report.log(Status.PASS, "Digitou numero cartao", screenshotArquivo15);
			
			String screenshotArquivo16 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarValidade(datapool.getValue("mmaa"));
			Screenshot.Tirar(driver, screenshotArquivo16);
			Report.log(Status.PASS, "Digitou mmaa", screenshotArquivo16);
			
			String screenshotArquivo17 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarCVV(datapool.getValue("cvv"));
			Screenshot.Tirar(driver, screenshotArquivo17);
			Report.log(Status.PASS, "Digitou cvv", screenshotArquivo17);
			
			String screenshotArquivo18 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
			this.checkout.digitarNomeTitular(datapool.getValue("nometitular"));
			Screenshot.Tirar(driver, screenshotArquivo18);
			Report.log(Status.PASS, "Digitou nometitular", screenshotArquivo18);
			
			Thread.sleep(5000);
			this.checkout.clicarProximo();
			datapool.next();
		}
		
	}
	
	@After
	public void tearDown() {
		Report.close();
		this.driver.quit();
	}

}
