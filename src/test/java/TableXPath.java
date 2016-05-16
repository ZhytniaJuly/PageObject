import Pages.HtmlTable;
import org.junit.Test;


/**
 * Created by дима on 15.05.2016.
 */
public class TableXPath extends BaseClass {
    private HtmlTable page;

    @Test
    public void checkOutRowByName(){
        page = new HtmlTable(driver);
        String name = "John";
        System.out.println(page.getTextRowByName(name));
    }
}
