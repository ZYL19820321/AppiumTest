package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest {
  @Test
  public void f() {
	  
	  System.out.println("可以");
	  System.out.println("可以");
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
