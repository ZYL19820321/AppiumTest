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

	/** 输出当前activity */
	public void printActivity(AndroidDriver<WebElement> driver) {
		System.out.println(driver.currentActivity());
	}

	/** 验证activity */
	public boolean verifyActivity(long time, AndroidDriver<WebElement> driver, String activity) {
		for (int i = 0; i < time / 1000; i++) {
			appWait(1000);
			if (driver.currentActivity().equals(activity)) {
				return true;
			}
		}
		return false;
	}

	/** 线程等待方法 */
	public void appWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** 隐式等待 */
	public void implitilyWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * 显式等待，元素出现后就停止等待
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
	 * xpath根据content-desc查找元素
	 * 
	 * @param view的类型
	 * @param         content-desc 的内容
	 * @return
	 */
	public WebElement getViewbyXpathwithContentdesc(String view, String name) {
		return driver.findElementByXPath("//" + view + "[contains(@content-desc,'" + name + "')]");
	}

	/***
	 * xpath根据text查找元素
	 * 
	 * @param view的类型
	 * @param text的内容
	 * @return
	 */
	public WebElement getViewbyXpathwithText(String view, String name) {
		return driver.findElementByXPath("//" + view + "[contains(@text,'" + name + "')]");
	}
	/***
	 * xpath根据id查找元素
	 * 
	 * @param view的类型
	 * @param text的内容
	 * @return
	 */
	public WebElement getViewbyXpathwithId(String view, String id) {
		String str = "//" + view + "[@resoutce-id ='" + id + "']";
		System.out.println(str);
		return driver.findElementByXPath("//" + view + "[@resoutce-id ='" + id + "']");
	}
	/***
	 * 根据UIautomator底层方法得到对应desc的view
	 * 
	 * @param desc名
	 * @return View
	 */
	public WebElement getViewbyUidesc(String name) {
		return driver.findElementByAndroidUIAutomator("new UiSelector().descriptionContains(\"" + name + "\")");
	}

	/***
	 * 根据UIautomator底层方法得到对应text的view
	 * 
	 * @param text名
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
		 * 点击控件附近的位置
		 * 
		 * @param driver
		 * @param by
		 * @param bottom
		 */
	/*
	 * 
	 * public void tapAround(WebElement element, Direction bottom) { Point start =
	 * element.getLocation(); // 获取控件位置 int startX = start.getX(); int startY =
	 * start.getY(); // 获取控件坐标轴差 Dimension q = element.getSize(); int x =
	 * q.getWidth(); int y = q.getHeight(); // 计算出控件结束坐标 int endX = x + startX; int
	 * endY = y + startY; // 计算出控件的中心坐标 int centerX = (endX + startX) / 2; int
	 * centerY = (endY + startY) / 2;
	 * 
	 * switch (bottom) { case UP: driver.tap(1, centerX, startY - 50, 100); break;
	 * case LEFT: driver.tap(1, startX - 50, centerY, 100); break; case RIGHT:
	 * driver.tap(1, endX + 50, centerY, 100); break; case BOTTOM: driver.tap(1,
	 * centerX, endY + 50, 100); break; case CENTER: driver.tap(1, centerX, centerY,
	 * 100); break; } }
	 * 
	 *//**
		 * 元素长按
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
		 * 获取当前页面所有edittext控件
		 * 
		 * @return
		 */
	/*
	 * 
	 * public List<WebElement> findAllEditText() { list =
	 * driver.findElementsByClassName(AndroidClassName.EDITTEXT); return list; }
	 * 
	 *//**
		 * 获取当前页面所有textview控件
		 * 
		 * @return
		 */
	/*
	 * 
	 * public List<WebElement> findAllTextView() { list =
	 * driver.findElementsByClassName(AndroidClassName.TEXTVIEW); return list; }
	 * 
	 *//**
		 * 获取当前页面所有图片控件
		 * 
		 * @return
		 */
	/*
	 * 
	 * public List<WebElement> findAllImageView() { list =
	 * driver.findElementsByClassName(AndroidClassName.IMAGEVIEW); return list; }
	 * 
	 *//**
		 * 获取当前页面所有button控件
		 * 
		 * @return
		 *//*
			 * public List<WebElement> findAllButton() { list =
			 * driver.findElementsByClassName(AndroidClassName.BUTTON); return list; }
			 */
}
