package Pages;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class TeamPageView {

    private WebDriver driver;

    private static String baseUrl = "http://skillsup.ua";
    private By ourTeam = By.linkText("Наша команда");
    private By nameFieldInsideCard = By.className("name");


    public TeamPageView(WebDriver driver) {
        this.driver = driver;
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    public void goToTeamPage() {
           driver.findElement(ourTeam).click();
       }

    public List<String> getAllCoachNames() {
        List coachCards = new ArrayList();
        List<WebElement> element = driver.findElements(nameFieldInsideCard);
        for (WebElement i : element) {
            coachCards.add(i.getText());
        }
        return coachCards;
    }

    public Boolean checkThatPersonIsPresented(String person) {
        return getAllCoachNames().contains(person);
    }

    public void openCoachPage(String name) {
        List<WebElement> element = driver.findElements(nameFieldInsideCard);
        for (WebElement i : element) {
            if (i.getText().contains(name)) {
                i.click();
                break;
            }
        }

    }






}