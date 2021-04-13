package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePOMpage extends BaseClass{

public AppiumDriver<MobileElement> driver;
   

    public BasePOMpage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
  //fungsi untuk memberi jeda 
  	public void beriJeda(Integer detik ) {
  		driver.manage().timeouts().implicitlyWait(detik, TimeUnit.SECONDS);
  	}
    
  //Function Scroll Berdasarkan parameter
  	public MobileElement scrollToElement(String type, String paramInd, String paramEng) {
  		beriJeda(30);
  		MobileElement element = null;
  		try{
  			element = (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()."+type+"(\""+paramInd+"\").instance(0))");
  		}catch(Exception e){
  			element = (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()."+type+"(\""+paramEng+"\").instance(0))");
  		}
  		return element;
  	}
  	//Function Scroll Tanpa Parameter
  	public void scrollLayar() {

  		//Mencari kordinat X dan Y layar
  		Dimension dimensi = driver.manage().window().getSize();
  		int x = dimensi.getWidth() / 2;
  		int startY = (int) (dimensi.getHeight() * 0.8);
  		int endY = 0;

  		//Scroll Layar
  		TouchAction touchAction = new TouchAction(driver);
  		touchAction.press(PointOption.point(x, startY))
  		.waitAction(WaitOptions.
  				waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(x, endY)).release().perform();
  	}
  	
  //fungsi select Rekening Bank Sultra
  	protected MobileElement pilihRekening(String sumber, String modul) {
  		
  		//kondisi jenis modul
  		MobileElement sumberRek = null;
  		if(modul.equals("transfer")) {
  			sumberRek =  (MobileElement) driver.findElement(By.xpath("//android.view.View/android.view.View[3]"));
  		}else if(modul.equals("pembelian")){
  			sumberRek =  (MobileElement) driver.findElement(By.xpath("//android.view.View/android.view.View[3]"));
  		}else if(modul.equals("pembayaran")){
  			sumberRek =  (MobileElement) driver.findElement(By.xpath("//android.view.View/android.view.View[3]"));
  		}

  		//Pilih sumber
  		sumberRek.click();
  		beriJeda(5);
  		MobileElement itemRek1 =  (MobileElement) driver.findElement(By.xpath("//android.view.View/android.view.View[3]"));
  		MobileElement itemSelected = null;
  		if(sumber.equals(itemRek1.getText())) {
  			MobileElement rekSelected =  (MobileElement) driver.findElement(By.xpath("//android.view.View/android.view.View[5]"));
  			itemSelected = rekSelected;
  		}
  		return itemSelected;
  	}
  	
  //fungsi untuk memberi jeda pada element
  	public WebDriverWait beriJedaElement(String path) {
  		 WebDriverWait wait = new WebDriverWait(driver, 30);
  		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//" + path + "")));
  		 return wait;
  	}
  	
  //Fungsi mengubah Teks Mengandung Rp. String ke integer
  	public static int covertStringKeInteger(String number) {
  		String str = null;
  		if(number.contains(",")) {
  			str = number.replaceAll(",",".");
  		}else {
  			str = number;
  		}
  		String tmp_number = str.substring(0, str.length());
  		return Integer.parseInt(tmp_number.replaceAll("[^0-9]", ""));
  		
  	}
  	
  	//Fungsi mengubah Teks Mengandung titik ke koma
  	public static String covertStringKeInteger2(String number) {
  		String str = null;
  		if(number.contains(".")) {
  			str = number.replaceAll("\\.", ",");
  	        System.out.println(str);
  		}
  		return str;
  	}
  	
  //Fungsi mengubah Teks Mengandung Rp. String ke integer dan menghapus dua digit dibelakang koma
  	public static int covertStringKeInteger3(String number) {
  		String str = null;
  		if(number.contains(",")) {
  			str = number.replaceAll(",",".");
  		}else {
  			str = number;
  		}
//  	untuk menghapus dua digit d belakang 
  		String tmp_number = str.substring(0, str.length() - 2);
  		return Integer.parseInt(tmp_number.replaceAll("[^0-9]", ""));
  		
  	}
  	
  //Fungsi select denom paket data
  	public MobileElement SelectDenomData(String nominal) {
  		//kondisi jenis modul
  		MobileElement denom = null;
  		if(nominal.equals("7,500")) {
  			beriJeda(5);
  			denom =  (MobileElement) driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]"));
  		}else if(nominal.equals("12,500")) {
  			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.view.View")).click();
  			beriJeda(5);
  			denom =  (MobileElement) driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]"));
  		}else if(nominal.equals("17,500")) {
  			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.view.View")).click();
  			beriJeda(5);
  			denom =  (MobileElement) driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]"));
  		}else if(nominal.equals("27,500")) {
  			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[7]/android.view.View")).click();
  			beriJeda(5);
  			denom =  (MobileElement) driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[7]"));
  		}else if(nominal.equals("37,500")) {
  			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[8]/android.view.View")).click();
  			beriJeda(5);
  			denom =  (MobileElement) driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[8]"));
  		}
  		
  		return denom;
  	}
   
}
