package com.automation.tests.model;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.basePkg.BaseClass;


public class HomePage extends BaseClass {
	
	List<TeaDetails> jsonList = tea.list;
	
	public void navigation() {
		driver.findElement(By.xpath("//a[@href = 'menu.html' and @data-url = 'menu.html']")).click();	
	}
	
	public void verifyTeaNameHeader() {
		//List<WebElement> teaType = driver.findElements(By.xpath("//div[starts-with(@id,'wsb-element')]/div/p/span/span/strong"));
		for (int i = 0; i < 3; i++ ) {
			//Assert.assertTrue(teaType.contains(abc.get(i).name));
			boolean teaName = driver.findElement(By.xpath("//div[starts-with(@id,'wsb-element')]/div/p/span/span/strong[contains(text(),'" +jsonList.get(i).name+ "')]")).isDisplayed();
			Assert.assertTrue(teaName,jsonList.get(i).name+" Tea name not present");
		}
	}
	
	
	public void verifyTeaImage() {
		
		for (int i = 0; i < 3; i++ ) {
			//img[contains(@src,'d9b60092d57a2c793618ab0c6f7d7285')]
			boolean teaImg = driver.findElement(By.xpath("//img[contains(@src,'"+ jsonList.get(i).img +"')]")).isDisplayed();
			Assert.assertTrue(teaImg, jsonList.get(i).img+" not present on UI");
		}
	}
	
	public void verifyTextContained() {
		List<WebElement> teaText = driver.findElements(By.xpath("//div[contains(@id,'wsb-element')]/div/pre/span"));
		for (int i = 0; i < 3; i++ ) {
			boolean flag = false;
			for (int j = 0; j< 3; j++) {
			//System.out.println(teaText.get(i).getText());
			String teaContentUI = teaText.get(i).getText();
			if (teaText.get(i).getText().contains(jsonList.get(j).content)) {
				System.out.println(i+" pass");
				flag = true;
				break;
			}
			}
			Assert.assertTrue(flag, teaText.get(i).getText()+" Text doesnt match");
		}
	}
	
}
