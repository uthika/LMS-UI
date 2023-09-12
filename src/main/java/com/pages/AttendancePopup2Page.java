package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.LoggerLoad;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Point;
import java.util.Properties;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Arrays;

public class AttendancePopup2Page {
    public static WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    long endtime, starttime;

    public AttendancePopup2Page() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text()='NewAttendance')]")
    WebElement btnNewAttendance;
    @FindBy(id = "dropdownId")
    WebElement dropdown;
    @FindBy(id = "close-button")
    WebElement closeButton;
    @FindBy(id = "save-button")
    WebElement popupSaveBtn;
    @FindBy(id = "cancel-button")
    WebElement popupCancelBtn;
    @FindBy(xpath = "//label[contains(text(), 'Program name')]")
    WebElement programNameLabel;
    @FindBy(xpath = "//label[contains(text(), 'Class Name')]")
    WebElement classNameLabel;
    @FindBy(xpath = "//label[contains(text(), 'Student Name')]")
    WebElement studentNameLabel;
    @FindBy(xpath = "//label[contains(text(), 'Attendance')]")
    WebElement attendanceLabel;
    @FindBy(xpath = "//label[contains(text(), 'Attendance Date')]")
    WebElement attendanceDateLabel;
    @FindBy(id = "programDropdownId")
    WebElement programDropdown;
    @FindBy(id = "classDropdownId")
    WebElement classDropdown;
    @FindBy(id = "attendanceDropdownId")
    WebElement attendanceDropdown;
    @FindBy(id = "datePicker")
    WebElement datePicker;
    @FindBy(id = ".next-month-arrow")
    WebElement rightArrow;
    @FindBy(id = ".previous-month-arrow")
    WebElement leftArrow;
    @FindBy(id = "datePickerBtn")
    WebElement datePickerBtn;
           public void manageAttendance() {
        String ManageAttendanceURl = prop.getProperty("ManageAttendanceURl");
        driver.get("ManageAttendanceURl");
        LoggerLoad.info("********Opening ManageAttendance LMS Portal********");
        System.out.println("Validating Manage Attendance Page");
        boolean OnManageAttendancePage = driver.getCurrentUrl().equals("ManageAttendanceURl");
    }

    public void clickNewAttendanceButton() {
        btnNewAttendance.click();
    }

    public void checkLabelSpelling() {
        WebElement label = driver.findElement(By.id("labelId"));
        String labelText = label.getText();
        String expectedLabelText = "+A New Attendance";
        assertEquals(expectedLabelText, labelText);
    }

    public void verifyDropdown() {
        if (dropdown.isDisplayed()) {
            System.out.println("Dropdown element is present on the page.");
        } else {
            System.out.println("Dropdown element is not present on the page.");
        }

    }

    public void closeBtninPopup() {
        if (closeButton.isDisplayed()) {
            System.out.println("Close button is visible in the popup window.");
        } else {
            System.out.println("Close button is not visible in the popup window.");
        }
    }

    public void checkCornerCloseBtn() {
        Point closeBtnLocation = closeButton.getLocation();
        assert closeBtnLocation.getX() > 0;
        assert closeBtnLocation.getY() == 0;

    }

    public void verifyFirstDropboxText() {
        WebElement firsttextBox = driver.findElement(By.id("textboxId"));
        String textInTextBox = firsttextBox.getAttribute("value");
        String expectedText = "select a program name";
        if (textInTextBox.contains(expectedText)) {
            System.out.println("Text verification passed!");
        } else {
            System.out.println("Text verification failed!");
        }
    }

    public void verifySecondDropboxText() {
        WebElement secondtextBox = driver.findElement(By.id("textboxId"));
        String textInTextBox = secondtextBox.getAttribute("value");
        String expectedText = "select class name";
        if (textInTextBox.contains(expectedText)) {
            System.out.println("Text verification passed!");
        } else {
            System.out.println("Text verification failed!");
        }
    }

    public void verifyThirdDropboxText() {
        WebElement thirdtextBox = driver.findElement(By.id("textboxId"));
        String textInTextBox = thirdtextBox.getAttribute("value");
        String expectedText = "select students";
        if (textInTextBox.contains(expectedText)) {
            System.out.println("Text verification passed!");
        } else {
            System.out.println("Text verification failed!");
        }
    }

    public void verifyFourthDropboxText() {
        WebElement fourthtextBox = driver.findElement(By.id("textboxId"));
        String textInTextBox = fourthtextBox.getAttribute("value");
        String expectedText = "select attendance";
        if (textInTextBox.contains(expectedText)) {
            System.out.println("Text verification passed!");
        } else {
            System.out.println("Text verification failed!");
        }
    }

    public void verifyTextColor() {
        By elementSelector = By.cssSelector(".gray-text");
        WebElement element = driver.findElement(elementSelector);
        String color = element.getCssValue("color");
        assertEquals("rgba(128, 128, 128, 1)", color);
    }

    public void verifySaveBtn() {
        if (!popupSaveBtn.isDisplayed()) {
            throw new AssertionError();
        }
    }

    public void verifyCancelBtn() {
        if (!popupCancelBtn.isDisplayed()) {
            throw new AssertionError();
        }
    }

    public void checkTextboxLabelOrder() {
        WebElement[] labels = {programNameLabel, classNameLabel, studentNameLabel, attendanceLabel, attendanceDateLabel};
        for (int i = 0; i < labels.length - 1; i++) {
            WebElement currentLabel = labels[i];
            WebElement nextLabel = labels[i + 1];
            int compareResult = currentLabel.getLocation().getY() - nextLabel.getLocation().getY();
            assertEquals(true, compareResult < 0);
        }
    }

    public void clickPrgmDropdown() {
        programDropdown.click();
    }

    public void checkDropdwnPrgmname() {
        WebElement programTable = driver.findElement(By.id("programTableId"));
        List<WebElement> programNamesInTable = programTable.findElements(By.tagName("td"));

        WebElement programDropdown = driver.findElement(By.id("programDropdownId"));
        List<WebElement> programNamesInDropdown = programDropdown.findElements(By.tagName("option"));

        for (WebElement programNameInDropdown : programNamesInDropdown) {
            boolean found = false;
            for (WebElement programNameInTable : programNamesInTable) {
                if (programNameInDropdown.getText().equals(programNameInTable.getText())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new AssertionError("Program name in dropdown does not match with table: " + programNameInDropdown.getText());
            }
        }
    }
    public void clickclassDropdown() {
        classDropdown.click();
    }

    public void checkDropdwnclassname() {
        WebElement classTable = driver.findElement(By.id("classTableId"));
        List<WebElement> classNamesInTable = classTable.findElements(By.tagName("td"));

        WebElement classDropdown = driver.findElement(By.id("classDropdownId"));
        List<WebElement> classNamesInDropdown = classDropdown.findElements(By.tagName("option"));

        for (WebElement classNameInDropdown : classNamesInDropdown) {
            boolean found = false;
            for (WebElement classNameInTable : classNamesInTable) {
                if (classNameInDropdown.getText().equals(classNameInTable.getText())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new AssertionError("class name in dropdown does not match with table: " + classNameInDropdown.getText());
            }
        }
    }
    public void clickattendanceDropdown() {
        attendanceDropdown.click();
    }
    public void checkDropdwnTextSpell(){
        WebElement dropdown = driver.findElement(By.id("dropdown-id")); // Replace with actual element locator
                List<WebElement> options = dropdown.findElements(By.tagName("option"));
                List<String> expectedSpellings = Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4");
              for (int i = 0; i < options.size(); i++) {
            assertEquals(expectedSpellings.get(i), options.get(i).getText());
        }
    }
    public void clickDatePicker(){
            datePicker.click();
    }
    public void verifyDateinAttendanceBox() {
        WebElement attendanceDateTextBox = driver.findElement(By.id("attendanceDate"));
        String selectedDate = attendanceDateTextBox.getAttribute("value");
                String expectedDate = "10/15/2023";
        assertEquals(expectedDate, selectedDate);
           }
    public void verifyDateFormat(){
        WebElement dateElement = driver.findElement(By.id("date-picker-id"));
                String selectedDate = dateElement.getText();
        String expectedDate = "mm/dd/yyyy";
        assertEquals(expectedDate, selectedDate);
    }
    public void clickrightarrow(){
        rightArrow.click();
    }
    public void clickleftarrow(){
        leftArrow.click();
    }
    public void verifyNxtMonthCalender(){
        WebElement nxtMonthCalendar = driver.findElement(By.id("next-month-calendar"));
        assertTrue(nxtMonthCalendar.isDisplayed());
    }
    public void verifyPrvsMonthCalender(){
        WebElement prvsMonthCalendar = driver.findElement(By.id("previous-month-calendar"));
        assertTrue(prvsMonthCalendar.isDisplayed());
    }
    public void clickDatePickerBtn(){
        datePickerBtn.click();
    }
    public void verifyCurrentHighlightedDate() {
                String currentDate = "05/12/2023";
                WebElement crntDateElement = driver.findElement(By.xpath("//td[@class='highlight']"));
        String highlightedDate = crntDateElement.getText();
                if (currentDate.equals(highlightedDate)) {
            System.out.println("Current date is highlighted: " + highlightedDate);
        } else {
            System.out.println("Current date is not highlighted. Expected: " + currentDate + ", Actual: " + highlightedDate);
        }
    }
    public void verifySelectedDate() {
        String SelectDate = "07/30/2023";
        WebElement selectDateElement = driver.findElement(By.xpath("//td[@class='highlight']"));
        String highlightedDate = selectDateElement.getText();
        if (SelectDate.equals(highlightedDate)) {
            System.out.println("Select date is highlighted: " + highlightedDate);
        } else {
            System.out.println("Select date is not highlighted.");
        }
    }
}