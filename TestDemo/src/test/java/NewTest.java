import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseSuite;

public class NewTest extends BaseSuite {
  @Test
  public void f() {
//	  au.findByWait(By.xpath("//android.widget.LinearLayout/android.widget.ImageView[@resource-id='com.togo.apps:id/register_logo']"),5000);
	  if(au.isElementPresented(By.xpath("//android.widget.LinearLayout/android.widget.ImageView[@resource-id='com.togo.apps:id/register_logo']"))) {
		  WebElement element1 = au.getViewbyXpathwithText("android.widget.RelativeLayout/android.widget.EditText", "�ֻ���");
		  if(null != element1) {
			  element1.sendKeys("17000000000");
		  }else {
			  System.out.println("1û��");
		  }
		  WebElement element2 = au.getViewbyXpathwithText("android.widget.RelativeLayout/android.widget.EditText", "��֤��");
		  if(null == element2) {
			  System.out.println("2û��");
		  }else {
			  element2.sendKeys("3267");
		  }
		  au.getViewbyXpathwithText("android.widget.TextView", "������֤��").click();
	  }else {
		  System.out.println("û��");
	  }
	  au.appWait(2000);
	 au.getViewbyXpathwithText("android.widget.Button", "��ʼ").click();
	 au.appWait(5000);
  }
}
