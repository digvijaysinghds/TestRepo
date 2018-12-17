package mavenTestRepo.mavenTest;
import com.automation.tests.model.HomePage;
import com.automation.tests.model.Tea;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.basePkg.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestPassionTea extends BaseClass{

    //private WebDriver driver ;
   
    HomePage homePage;


    @BeforeMethod
    public void setUp() {
    	
    	//calling Initialize method
    	try {
			BaseClass.Initialize();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	homePage = new HomePage(); 
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testTeaDetails() {
    	homePage.navigation();
    	homePage.verifyTeaNameHeader();
    	homePage.verifyTeaImage();
    	homePage.verifyTextContained();
    	
    }
    
    
   /* public void passionTeaCheckout() throws InterruptedException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Tea tea = objectMapper.readValue(new File("data.json"), Tea.class);
    }*/
}
