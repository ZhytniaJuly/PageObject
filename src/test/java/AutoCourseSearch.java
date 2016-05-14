import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import Pages.CoursePageView;
import Pages.MainPageView;


/**
 * Created by дима on 14.05.2016.
 */
public class AutoCourseSearch extends BaseClass{

    MainPageView mainPageViewPage;
    CoursePageView coursePage;
    String courseName = "Автоматизация";

    @Test
    public void checkCourseIsPresentAtTheList(){
        mainPageViewPage = new MainPageView(driver);
        mainPageViewPage.goToCoursesListPage();

        try {
            mainPageViewPage.openCoursePage(courseName);
        }catch (NoSuchElementException e) {
            System.err.println("There is no such courses" + e.getMessage());}
    }

    @Test
    public void validateCourseNameIsAutomation(){
        mainPageViewPage = new MainPageView(driver);
        coursePage = new CoursePageView(driver);
        mainPageViewPage.goToCoursesListPage();
        mainPageViewPage.openCoursePage(courseName);
        assertEquals("Course has wrong name","Test Automation (Автоматизация тестирования ПО)",coursePage.CoachCourse());
    }

    @Test
    public void validateCoachNameIsSergey(){
        mainPageViewPage = new MainPageView(driver);
        coursePage = new CoursePageView(driver);
        mainPageViewPage.goToCoursesListPage();
        mainPageViewPage.openCoursePage(courseName);
        assertEquals("Sergey is not the coach","Сергей Ватковский",coursePage.CoachName());
    }

    @Test
    public void applicationPopUpIsPresent() throws Exception {
        mainPageViewPage = new MainPageView(driver);
        coursePage = new CoursePageView(driver);

        mainPageViewPage.goToCoursesListPage();
        mainPageViewPage.openCoursePage(courseName);

        coursePage.clickLeaveApplication();
        coursePage.swithToPopUp(); // focus on pop-up
        assertTrue("Pop up was not shown", coursePage.popUpShown());
    }

    @Test
    public void checkAllFieldsFromPopUp() throws Exception {
        mainPageViewPage = new MainPageView(driver);
        coursePage = new CoursePageView(driver);

        mainPageViewPage.goToCoursesListPage();
        mainPageViewPage.openCoursePage(courseName);

        coursePage.clickLeaveApplication();
        coursePage.swithToPopUp(); // focus on pop-up

        assertEquals("Имя is not field name", "Имя", coursePage.getFieldName(0));
        assertEquals("Фамилия is not field name", "Фамилия", coursePage.getFieldName(1));
        assertEquals("Электронная почта is not field name", "Электронная почта", coursePage.getFieldName(2));
        assertEquals("Телефон is not field name", "Телефон", coursePage.getFieldName(3));
    }
}
