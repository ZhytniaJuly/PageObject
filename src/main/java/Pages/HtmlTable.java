package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Created by дима on 16.05.2016.
 */
public class HtmlTable {

    private WebDriver driver;
    String baseUrl = "http://www.w3schools.com/html/html_tables.asp";

    private By rows = By.xpath(".//table[@class='w3-table-all']/tbody/tr[position()>1]");
    private By column = By.xpath("td[2]");



    public HtmlTable (WebDriver driver) {
        this.driver = driver;
        driver.get(baseUrl);

        PageFactory.initElements(driver, this);
    }

    public String getTextRowByName(String name){
        List<WebElement> tableRows = driver.findElements(rows);
        WebElement requiredRow = null;

        for (WebElement row : tableRows){
            if (row.findElement(column).getText().contains(name)){
                requiredRow = row;
                break;
            }
        }
        return requiredRow.getText();
    }
}
