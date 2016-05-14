import Pages.BlogPageView;
import Pages.CoachPageView;
import Pages.MainPageView;
import org.junit.Test;
import Pages.TeamPageView;


public class CoachSearch extends BaseClass {
    private TeamPageView teamPageView;
    private BlogPageView blogPageView;
    private String linaO="Лина Олейник";
    private String nastyaP="Анастасия Педоренко";
    private String artemK="Артем Карпов";
    private String title="Блог";
    //private String spac_linaO="Артем Карпов";
    //private String spac_nastyaP="Артем Карпов";


    //Verify whether Oleynik Lina is present on the Page "Our Team"
    @Test
    public void checkThatOleynikIsPresented() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        assertTrue(teamPageView.checkThatPersonIsPresented(linaO));
    }

    //Verify whether Pedorenko Anastasia is present on the Page "Our Team"
    @Test
    public void checkThatPedorenkoAIsPresented() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        assertTrue(teamPageView.checkThatPersonIsPresented(nastyaP));
    }

    //Verify whether infa about Pedorenko Anastasia is present on the Coach Page
     @Test
    public void checkInfaPedorenkoAIsPresented() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        teamPageView.openCoachPage(nastyaP);
        CoachPageView coachPage = new CoachPageView(driver);
        assertEquals(nastyaP, coachPage.getName());

    }

    //Verify whether infa about Oleynik Lina is present on the Coach Page
    @Test
    public void checkInfaOleynikIsPresented() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        teamPageView.openCoachPage(linaO);
        CoachPageView coachPage = new CoachPageView(driver);
        assertTrue(coachPage.coachNameIsPresentAtPersonalPage(linaO));


    }


    //Verify Karpov Artem isn't present in Our Team
    @Test
    public void checkThatKarpovIsNotPresented() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        assertFalse(teamPageView.checkThatPersonIsPresented(artemK));
    }

    //Verify title of Blog Page with Action class
    @Test
    public void checkThatBlogPageIsPresented() throws Exception {
        blogPageView = new BlogPageView(driver);
        blogPageView.goToBlogPage();
        assertEquals(title, blogPageView.getTitle());
    }



    // must failing
    @Test
    public void waitLol() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        teamPageView.waitToContextIsLoaded();

    }

    @Test
    public void waitAlert() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        teamPageView.waitToAlert();

    }

    @Test
    public void callJavaScriptAlert() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        assertEquals("Ольга Симчак", teamPageView.callJavascriptAlert());
    }

    @Test
    public void alertAccept() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        teamPageView.callJavascript();
        assertEquals("hello world", teamPageView.getTextFromAlert());
        teamPageView.pressOkButtonOnAlert();
    }
}