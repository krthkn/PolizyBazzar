package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.TestBase;
import pages.CarInsurancePage;
import pages.HomePage;
import util.ReadExcel;
import util.Write;

public class CarInsuranceErrorMessageTest extends TestBase {

	public CarInsuranceErrorMessageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	CarInsurancePage carInsurance = new CarInsurancePage();
	HomePage homePage = new HomePage();
	String sheetName = "Sheet1";
    String userDir = System.getProperty("user.dir");
	String filePath = userDir + "\\src\\test\\java\\resources\\testdata\\PolicybazzarExcel.xlsx";

	@BeforeClass(groups= {"Default","Regression"})
	public void setup()throws Exception {
		// initialization();
		driver.navigate().to("https://www.policybazaar.com/");
		
	}
	@Test(priority = 1,groups= {"Default","Smoke","Regression"})
	public void clickCarInsuranceTest() throws Exception{

		homePage.clickCarInsurance();
		logger = report.createTest("Car Insurance Test");
		logger.log(Status.PASS, "Clicking car Insurance");
		Write.updateResult("TC01 Policy Bazaar- To verify whether the car insurance page is loaded", "Pass");
	}

	@Test(priority = 2,groups= {"Default","Regression"})
	public void clickProceedButtonTest()throws Exception {
		carInsurance.clickProceedButton();
		logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Clicking proceed button");
		Write.updateResult("TC02 Policy Bazaar- To verify whether [PROCEED WITHOUT CAR NUMBER] button functionality", "Pass");
	}

	@Test(priority = 3,groups= {"Default","Regression"})
	public void selectCityTest()throws Exception {
		carInsurance.selectCity();
		logger.log(Status.PASS, "TestCase Passed");
		Write.updateResult("TC03 Policy Bazaar- Field validation for city and RTO", "Pass");
	}

	@Test(priority = 4,groups= {"Default","Smoke","Regression"})
	public void selectCarBrandTest() throws Exception{
		carInsurance.selectCarBrand();
		logger.log(Status.PASS, "TestCase Passed");
		Write.updateResult("TC04 Policy Bazaar- Field validation for car brand", "Pass");
		
	}

	@Test(priority = 5,groups= {"Default","Regression"})
	public void selectCarModelTest()throws Exception {
		carInsurance.selectCarModel();
		logger.log(Status.PASS, "TestCase Passed");
		Write.updateResult("TC05 Policy Bazaar- Field validation for car model", "Pass");
		
	}

	@Test(priority = 6,groups= {"Default","Regression"})
	public void chooseFuelTypeTest()throws Exception {
		carInsurance.chooseFuelType();
		logger.log(Status.PASS, "TestCase Passed");
		Write.updateResult("TC06 Policy Bazaar- Field validation for car fuel type", "Pass");
		
	}

	@Test(priority = 7,groups= {"Default","Regression"})
	public void selectCarVariantTest()throws Exception {
		carInsurance.selectCarVariant();
		logger.log(Status.PASS, "TestCase Passed");
		Write.updateResult("TC07 Policy Bazaar- Field validation for car variant", "Pass");
	}

	@Test(priority = 8,groups= {"Default","Regression"})
	public void selectYearTest() throws Exception{
		carInsurance.selectYear();
		logger.log(Status.PASS, "TestCase Passed");
		Write.updateResult("TC08 Policy Bazaar- Field validation for Valid registration year", "Pass");
	}

	@Test(priority = 9,groups= {"Default","Regression"})
	public void fillDetailsTest()throws Exception {
		ReadExcel re = new ReadExcel();

		try {
			carInsurance.fillName(re.readExcel(0, 0, filePath, sheetName));
			carInsurance.fillEmail(re.readExcel(0, 1, filePath, sheetName));
			carInsurance.fillPhone(re.readExcel(0, 2, filePath, sheetName));
			logger.log(Status.PASS, "TestCase Paassed");
			Write.updateResult("TC09 Policy Bazar- To verify [view prices] button functionality with respect to invalid data", "Pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 10,groups= {"Default","Regression"})
	public void takeScreenshotTest()throws Exception {
		boolean flag = carInsurance.takeScreenshot();
		Assert.assertTrue(flag);
		logger.log(Status.PASS, "TestCase Passed");
		Write.updateResult("TC10 Policy Bazar- To verify whether error message screen shot is captured for invalid data", "Pass");
	}
}