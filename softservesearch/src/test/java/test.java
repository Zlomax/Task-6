import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {
    WebDriver driver;
    private String inputXpath="/html/body/div[7]/div/div[9]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/a/h3";
    private String getUrl;
    private String checkUrl="https://career.softserveinc.com/uk-ua/learning-and-certification";
    private String searchFieldXpath= "//input[@name='q']";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "browserdriver/chromedriver.exe");
    }
    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }
    @Test
    public void test(){
        WebElement  searchBox = driver.findElement(By.xpath(searchFieldXpath));
        searchBox.sendKeys("softserve learning and certification");
        searchBox.submit();
        driver.findElement(By.xpath(inputXpath)).click();
        getUrl = driver.getCurrentUrl();
        Assert.assertTrue(getUrl.contains(checkUrl),"Not contain");


        driver.quit();

    }
}
