package com.qa.basePkg;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.tests.model.Tea;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseClass {
	
	//global access
	public static WebDriver driver;
	public static Tea tea;
	private static String url = "http://www.practiceselenium.com";
	
	
	public static void Initialize() throws InterruptedException, IOException{
		
	    ObjectMapper objectMapper = new ObjectMapper();
	    tea = objectMapper.readValue(new File("data.json"), Tea.class);
	    
	    //System.out.println(tea.getClass().);
	    //List<TeaDetails> abc = tea.list;
	    //System.out.println(abc.get(1).content) ;
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/DriverExe/chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.get(url);
        //driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	

}
