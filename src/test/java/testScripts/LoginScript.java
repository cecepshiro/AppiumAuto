package testScripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClass.BaseClass;
import pages.LoginScreen;

public class LoginScript extends BaseClass {

	private static String password = "Adminadmin1";
	String modulName = "Login";
	
	@Test
	public void setup() throws InterruptedException {
		
		ExtentTest logger = extent.createTest("Login", "Positif Case");
		
		try{
			logger.log(Status.INFO, "Test Dimulai");
			//login
			LoginScreen login = new LoginScreen(driver);
			takeScreenshoot(modulName,"Positif");
			logger.log(Status.PASS, "Masuk Halaman Login");
			
			login.clickLogin();
			logger.log(Status.PASS, "Menekan Menu Login");
			takeScreenshoot(modulName,"Positif");
			
			login.clickPassword(password);
			logger.log(Status.PASS, "Memasukan Password : " + password);
			takeScreenshoot(modulName,"Positif");
			
			login.clickLogin();
			logger.log(Status.PASS, "Menekan Tombol Login");
			
			Thread.sleep(5000);
			takeScreenshoot(modulName,"Positif");
			logger.log(Status.INFO, "Test Selesai");
		}catch(Exception e) {
			logger.log(Status.FAIL, "Error : " + e);
		}
		
	}
}
