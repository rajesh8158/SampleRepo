package com.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiceTest {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		try {
			new DiceTest().runtest();
			
			System.out.println("jeq");
			driver.close();
			driver.quit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("test stop");
			
		}
	}
	public void runtest() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://banglarshiksha.gov.in/Student_update_ep/list_student");
		boolean fl=true;
		for(int i=66;i<=172;i++) {
			//Click on select 100
			waitforclick(By.xpath("//Select[@name='example_length']"));
			Select sel=new Select(driver.findElement(By.xpath("//Select[@name='example_length']")));
			sel.selectByValue("100");
			Thread.sleep(2000);
			if(i>100) {
				waitforclick(By.xpath("//a[contains(.,'Next')]"));
				driver.findElement(By.xpath("//a[contains(.,'Next')]")).click();
				
			}
			
			
		while(fl)
			try {
				try {
					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				waitforclick(By.xpath("//tr/td/p[text()='"+i+"']/parent::td//following-sibling::td[16]"),3);
				
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr/td/p[text()='"+i+"']/parent::td//following-sibling::td[16]/a")));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//tr/td/p[text()='"+i+"']/parent::td//following-sibling::td[16]/a")).click();
				
				}catch (Exception e) {
					// TODO: handle exception
					//
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//tr/td[text()='"+i+"']//following-sibling::td[16]")));
					Thread.sleep(2000);
					driver.findElement(By.xpath("//tr/td[text()='"+i+"']//following-sibling::td[16]/a")).click();
					
				}
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				waitforclick(By.xpath("(//td[contains(.,'Aadhaar Number')]/following-sibling::td)[1]"),60);
				String name=driver.findElement(By.xpath("(//td[contains(.,'Name')]/following-sibling::td)[1]")).getText(); 
				
				String class1=driver.findElement(By.xpath("(//td[contains(.,'Present Class')]/following-sibling::td)[1]")).getText();
				String gender=driver.findElement(By.xpath("(//td[contains(.,'Gender')]/following-sibling::td)[1]")).getText();
				String bplstatus=driver.findElement(By.xpath("(//td[contains(.,'BPL Status')]/following-sibling::td)[1]")).getText();
				
						//(//td[contains(.,'BPL Status')]/following-sibling::td)[1]
				String txt=driver.findElement(By.xpath("(//td[contains(.,'Aadhaar Number')]/following-sibling::td)[1]")).getText();
				if(txt.equalsIgnoreCase("")) {
					System.err.print("SL NO >>" +i+" || Name : "+name+" ||GENDER : "+gender+" || Class : "+class1+" || Aadhar :  No Aadhar" );
				}else {
					System.out.print("SL NO >>" +i+" || Name : "+name+" || GENDER : "+gender+" || Class : "+class1+"|| Aadhar :  "+txt);
				}
				if(bplstatus.equalsIgnoreCase("YES")) {
					String bplno=driver.findElement(By.xpath("(//td[contains(.,'BPL No')]/following-sibling::td)[1]")).getText();
					System.out.println(" || BPL : Yes ||BPL NO : "+bplno);
				}else {
					System.err.println(" || BPL : Yes ||BPL NO : NA");
				}
				//click on back
				//driver.findElement(By.xpath("//a[@data-original-title='Back to previous page']")).click();
				driver.navigate().back();
				//Thread.sleep(10000);
				break;
				
				
			} catch (Exception e) {
				// TODO: handle exception
				///click next
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				waitforclick(By.xpath("//a[contains(.,'Next')]"));
				driver.findElement(By.xpath("//a[contains(.,'Next')]")).click();
				//Thread.sleep(10000);
				
			}
		System.out.println("-----------------------------------");
			
			
			
			
		}
		
		
		
		
		
		
		

	}
	public void waitforclick(By by) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		
	}
	public void waitforclick(By by,int sec) {
		WebDriverWait wait=new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		
	}

}
