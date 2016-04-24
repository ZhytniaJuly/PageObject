package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by дима on 24.04.2016.
 */
public class BlogPageView {
    private By title = By.xpath("//div[@class='greenHeader']");
    private static String baseUrl = "http://skillsup.ua";
    private By aboutUs = By.xpath(".//*[@id='menu3039']/a");
    private By blog = By.xpath("//a[contains(text(),'Блог')]");
    private WebDriver driver;

    public BlogPageView (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goToBlogPage() {
        driver.navigate().to(baseUrl);
        WebElement hoverElement = driver.findElement(aboutUs);
        WebElement clickElement = driver.findElement(blog);
        Actions openTeamPage = new Actions(driver);
        openTeamPage.moveToElement(hoverElement).perform();
        openTeamPage.moveToElement(clickElement).click().perform();
    }

    public String getTitle (){
        return (driver.findElement(title).getText());
    }
}

