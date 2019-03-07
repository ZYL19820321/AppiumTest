import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseSuite;

public class NewTest extends BaseSuite {
  @Test
  public void f() {
//	  au.findByWait(By.xpath("//android.widget.LinearLayout/android.widget.ImageView[@resource-id='com.togo.apps:id/register_logo']"),5000);
	  if(au.isElementPresented(By.xpath("//android.widget.LinearLayout/android.widget.ImageView[@resource-id='com.togo.apps:id/register_logo']"))) {
		  WebElement element1 = au.getViewbyXpathwithText("android.widget.RelativeLayout/android.widget.EditText", "手机号");
		  if(null != element1) {
			  element1.sendKeys("17000000000");
		  }else {
			  System.out.println("1没有");
		  }
		  WebElement element2 = au.getViewbyXpathwithText("android.widget.RelativeLayout/android.widget.EditText", "验证码");
		  if(null == element2) {
			  System.out.println("2没有");
		  }else {
			  element2.sendKeys("3267");
		  }
		  au.getViewbyXpathwithText("android.widget.TextView", "发送验证码").click();
	  }else {
		  System.out.println("没有");
	  }
	  au.appWait(2000);
	 au.getViewbyXpathwithText("android.widget.Button", "开始").click();
	 au.appWait(5000);
  }
}
