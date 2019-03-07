package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;

public class TestUtil {

	private AndroidDriver<WebElement> driver;

	private List<WebElement> list;

	public TestUtil(AndroidDriver<WebElement> mDriver) {
		this.driver = mDriver;
	}

	/** �����ǰactivity */
	public void printActivity(AndroidDriver<WebElement> driver) {
		System.out.println(driver.currentActivity());
	}

	/** ��֤activity */
	public boolean verifyActivity(long time, AndroidDriver<WebElement> driver, String activity) {
		for (int i = 0; i < time / 1000; i++) {
			appWait(1000);
			if (driver.currentActivity().equals(activity)) {
				return true;
			}
		}
		return false;
	}

	/** �̵߳ȴ����� */
	public void appWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** ��ʽ�ȴ� */
	public void implitilyWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * ��ʽ�ȴ���Ԫ�س��ֺ��ֹͣ�ȴ�
	 * 
	 * @param by
	 * @param time
	 * @return
	 */
	public WebElement findByWait(final By by, long time) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);

			element = wait.until(new ExpectedCondition<WebElement>() {

				public WebElement apply(WebDriver arg0) {
					// TODO Auto-generated method stub
					return driver.findElement(by);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	/***
	 * xpath����content-desc����Ԫ��
	 * 
	 * @param view������
	 * @param         content-desc ������
	 * @return
	 */
	public WebElement getViewbyXpathwithContentdesc(String view, String name) {
		return driver.findElementByXPath("//" + view + "[contains(@content-desc,'" + name + "')]");
	}

	/***
	 * xpath����text����Ԫ��
	 * 
	 * @param view������
	 * @param text������
	 * @return
	 */
	public WebElement getViewbyXpathwithText(String view, String name) {
		return driver.findElementByXPath("//" + view + "[contains(@text,'" + name + "')]");
	}
	/***
	 * xpath����id����Ԫ��
	 * 
	 * @param view������
	 * @param text������
	 * @return
	 */
	public WebElement getViewbyXpathwithId(String view, String id) {
		String str = "//" + view + "[@resoutce-id ='" + id + "']";
		System.out.println(str);
		return driver.findElementByXPath("//" + view + "[@resoutce-id ='" + id + "']");
	}
	/***
	 * ����UIautomator�ײ㷽���õ���Ӧdesc��view
	 * 
	 * @param desc��
	 * @return View
	 */
	public WebElement getViewbyUidesc(String name) {
		return driver.findElementByAndroidUIAutomator("new UiSelector().descriptionContains(\"" + name + "\")");
	}

	/***
	 * ����UIautomator�ײ㷽���õ���Ӧtext��view
	 * 
	 * @param text��
	 * @return View
	 */
	public WebElement getViewbyUitext(String name) {
		return driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"" + name + "\")");
	}
	
	
	public boolean isElementPresented(By by){
	    boolean isDisplay = false;
	    try{
	        isDisplay = driver.findElement(by).isDisplayed();
	    }catch (Exception e){
	        isDisplay =false;
	    }
	    return isDisplay;
	}

	/*
	 * public enum Direction { UP, LEFT, RIGHT, BOTTOM, CENTER }
	 * 
	 *//**
		 * ����ؼ�������λ��
		 * 
		 * @param driver
		 * @param by
		 * @param bottom
		 */
	/*
	 * 
	 * public void tapAround(WebElement element, Direction bottom) { Point start =
	 * element.getLocation(); // ��ȡ�ؼ�λ�� int startX = start.getX(); int startY =
	 * start.getY(); // ��ȡ�ؼ�������� Dimension q = element.getSize(); int x =
	 * q.getWidth(); int y = q.getHeight(); // ������ؼ��������� int endX = x + startX; int
	 * endY = y + startY; // ������ؼ����������� int centerX = (endX + startX) / 2; int
	 * centerY = (endY + startY) / 2;
	 * 
	 * switch (bottom) { case UP: driver.tap(1, centerX, startY - 50, 100); break;
	 * case LEFT: driver.tap(1, startX - 50, centerY, 100); break; case RIGHT:
	 * driver.tap(1, endX + 50, centerY, 100); break; case BOTTOM: driver.tap(1,
	 * centerX, endY + 50, 100); break; case CENTER: driver.tap(1, centerX, centerY,
	 * 100); break; } }
	 * 
	 *//**
		 * Ԫ�س���
		 * 
		 * @param item
		 */
	/*
	 * 
	 * public void longPressElement(WebElement item) { TouchAction action = new
	 * TouchAction(driver); action.longPress(item); action.perform(); }
	 * 
	 * 
	 *//**
		 * ��ȡ��ǰҳ������edittext�ؼ�
		 * 
		 * @return
		 */
	/*
	 * 
	 * public List<WebElement> findAllEditText() { list =
	 * driver.findElementsByClassName(AndroidClassName.EDITTEXT); return list; }
	 * 
	 *//**
		 * ��ȡ��ǰҳ������textview�ؼ�
		 * 
		 * @return
		 */
	/*
	 * 
	 * public List<WebElement> findAllTextView() { list =
	 * driver.findElementsByClassName(AndroidClassName.TEXTVIEW); return list; }
	 * 
	 *//**
		 * ��ȡ��ǰҳ������ͼƬ�ؼ�
		 * 
		 * @return
		 */
	/*
	 * 
	 * public List<WebElement> findAllImageView() { list =
	 * driver.findElementsByClassName(AndroidClassName.IMAGEVIEW); return list; }
	 * 
	 *//**
		 * ��ȡ��ǰҳ������button�ؼ�
		 * 
		 * @return
		 *//*
			 * public List<WebElement> findAllButton() { list =
			 * driver.findElementsByClassName(AndroidClassName.BUTTON); return list; }
			 */
}
