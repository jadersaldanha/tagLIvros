package testSuite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tagLivros.Report;
import testCases.AcessarAreadeUsuarioTestCase;
import testCases.CheckoutCuradoriaTestCase;
import testCases.CheckoutIneditosTestCase;

@RunWith(Suite.class)
@SuiteClasses({
	CheckoutCuradoriaTestCase.class,
	CheckoutIneditosTestCase.class,
	AcessarAreadeUsuarioTestCase.class,
})

public class AssinaturaClubeTagLivrosRegressionTestSuite {
	
	public static void main(String[] args) {
		JUnitCore.runClasses(AssinaturaClubeTagLivrosRegressionTestSuite.class);
	}
	
	@BeforeClass
	public static void setUp() {
		Report.create("TagLivros", "Assinatura Plano");
	}

	@AfterClass
	public static void tearDown() {
		Report.close();
	}

}
