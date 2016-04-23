import Pages.CoachPageView;
import org.junit.Test;
import Pages.TeamPageView;


public class CoachSearch extends BaseClass {
    private TeamPageView teamPageView;

    @Test
    public void checkThatOleynikIsPresented() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        assertTrue(teamPageView.checkThatPersonIsPresented("Лина Олейник"));
    }

    @Test
    public void checkThatPedorenkoAIsPresented() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        assertTrue(teamPageView.checkThatPersonIsPresented("Анастасия Педоренко"));
    }

    @Test
    public void checkInfaPedorenkoAIsPresented() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        teamPageView.openCoachPage("anastasia-pedorenko");
        CoachPageView coachPage = new CoachPageView(driver);
        assertEquals("Анастасия Педоренко", coachPage.getName());

    }

    @Test
    public void checkInfaOleynikIsPresented() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        teamPageView.openCoachPage("lina-oleynik");
        CoachPageView coachPage = new CoachPageView(driver);
        assertEquals("Лина Олейник", coachPage.getName());

    }

    @Test
    public void checkThatKarpovIsNotPresented() throws Exception {
        teamPageView = new TeamPageView(driver);
        teamPageView.goToTeamPage();
        assertFalse(teamPageView.checkThatPersonIsPresented("Артем Карпов"));
    }


}