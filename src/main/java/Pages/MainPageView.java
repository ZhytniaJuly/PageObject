package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by дима on 14.05.2016.
 */
public class MainPageView {

    private WebDriver driver;
    private static String baseUrl = "http://skillsup.ua";
    private By couching = By.id("menu1078");
    private By courses = By.xpath("//a[contains(text(),'Курсы')]");
    private By title = By.xpath("//div[@class='greenHeader']");
    private WebElement linkElement;
    private By coursesList = By.xpath(".//*[@id='subMenuSubNodes1189']");
    private By coursesTag = By.tagName("li");

    public MainPageView (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToCoursesListPage(){
        driver.navigate().to(baseUrl);
        WebElement hoverElement = driver.findElement(couching);
        WebElement clickElement = driver.findElement(courses);
        Actions openCoursesListPage = new Actions(driver);
        openCoursesListPage.moveToElement(hoverElement).perform();
        openCoursesListPage.moveToElement(clickElement).perform();

    }



    public void openCoursePage(String courseName) {
        List<WebElement> element = driver.findElement(coursesList).findElements(coursesTag);
        for (int i = 1; i <= element.size(); i++) {
            linkElement = driver.findElement(By.xpath(".//*[@id='subMenuSubNodes1189']/li[" + i + "]/a"));
            if(linkElement.getAttribute("text").contains(courseName)){
                linkElement.click();
                break;
            }
        }

    }
}
