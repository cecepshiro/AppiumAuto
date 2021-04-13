package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class LoginScreen  extends BasePOMpage{
	
	@AndroidFindBy(id = "com.mantap.pac:id/btn_masuk")
	private AndroidElement btnLogin;
   
    @AndroidFindBy(id = "com.mantap.pac:id/et_password")
    private AndroidElement txtPassword;
  
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
   
    public void clickLogin()
    {
     
    	btnLogin.click();
    }
   
    public void clickPassword(String password)
    {
     
    	txtPassword.click();
    	driver.getKeyboard().sendKeys(password);
    }
}