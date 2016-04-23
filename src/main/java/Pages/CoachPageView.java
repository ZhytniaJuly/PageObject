package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by дима on 23.04.2016.
 */
public class CoachPageView {
    private By name = By.xpath("//div[@class='greenHeader']");

    private WebDriver driver;


    public CoachPageView (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getName (){
        return (driver.findElement(name).getText());
    }
}
