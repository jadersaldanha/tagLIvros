package testSuite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tagLivros.Report;
import testCases.AcessarAreadeUsuarioTestCase;
import testCases.CheckoutTestCase;

@RunWith(Suite.class)
@SuiteClasses({
	CheckoutTestCase.class,
	AcessarAreadeUsuarioTestCase.class,
})

public class AssinaturaClubeRegressionTestSuite {
	
	public static void main(String[] args) {
		JUnitCore.runClasses(AssinaturaClubeRegressionTestSuite.class);
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
