package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by дима on 14.05.2016.
 */
public class CoursePageView {
    private WebDriver driver;
    private By pageHeader = By.className("greenHeader");
    private By coachName = By.xpath("//div[@id='ContentPlaceHolderDefault_content_skillsup.content.products.page_2_TrainersArea']/div/a/span");
    private By popUp = By.id("u11508");
    private By applicationButton = By.className("button");
    private By popUpFields = By.className("header");

    public CoursePageView (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String CoachName() {
        return driver.findElement(coachName).getText();
    }

    public String CoachCourse() {
        return driver.findElement(pageHeader).getText();
    }

    public void clickLeaveApplication(){
        driver.findElement(applicationButton).click();
    }

    public void swithToPopUp() throws Exception {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('u11508').focus();");
    }

    public boolean popUpShown(){
        return driver.findElement(popUp).isDisplayed();
    }

    public List<String> getAllFields (){
        List<WebElement> allFields = driver.findElements(popUpFields);
        List<String> fieldNames = new ArrayList();
        for (WebElement i: allFields){
            fieldNames.add (i.getText());
        }
        return fieldNames;
    }
    public String getFieldName(int fieldNumber){

        return getAllFields().get(fieldNumber);}


}
