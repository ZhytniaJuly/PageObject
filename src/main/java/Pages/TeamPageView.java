package Pages;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class TeamPageView {

    private WebDriver driver;

    private static String pageUrl = "http://skillsup.ua";

    private By ourTeam = By.linkText("Наша команда");

    private By nameFieldInsideCard = By.className("name");


    public TeamPageView(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
    }

       public TeamPageView goToTeamPage() {
           driver.findElement(ourTeam).click();
           return null;
       }

    public void openCoachPage(String S) {
        String path = "a[href*="+S+"]";
        driver.findElement(By.cssSelector(path)).click();

    }

      public Boolean checkThatPersonIsPresented(String person) {
        return getAllCoachNames().contains(person);
    }

    public List<String> getAllCoachNames() {
        List coachCards = new ArrayList();
        List<WebElement> element = driver.findElements(nameFieldInsideCard);
        for (WebElement i : element) {
            coachCards.add(i.getText());
        }
        return coachCards;
    }


}