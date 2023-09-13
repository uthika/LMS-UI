package com.pages;

import com.qa.factory.*;
import com.qa.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import com.qa.factory.DriverFactory;
import com.qa.util.LoggerLoad;
import com.qa.util.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class Program1 {


    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    long endtime, starttime;

    public Program1() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Program']")
    WebElement newProgramButton;
    @FindBy(xpath = "//header[@id='header-id']")
    WebElement Header;
    @FindBy(xpath = "//button[@id='Pagination']")
    WebElement pagination;

    @FindBy(xpath = "//footer[@id='footer']")
    WebElement footer;
    @FindBy(xpath = "//button[text()='Delete']")
    WebElement DeleteIcon;
    @FindBy(xpath = "//button@id='radioBtn']")
    WebElement display;
@FindBy(id="program")WebElement description;
    List<WebElement> Headertext = driver.findElements(By.xpath("//table[@id='table01']/thead//th"));
    List<WebElement> TROWS = driver.findElements(By.xpath("//table[@class=table rows]//tbody/tr"));
    //@FindBys(xpath="table[@class=table rows]//tbody/tr") WebElement TCOL;
    List<WebElement> header = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));

    @FindBy(xpath = "//*[@id='next']")
    WebElement checkbox;
    @FindBy(xpath = "//button[text()='edit/delete']")
    WebElement editORdelete;
    @FindBy(xpath = "//button[text()='Search']")
    WebElement SearchBox;
    @FindBy(xpath = "//button[text()='Search']")
    WebElement Searchtext;
    @FindBy(xpath = "//button[text()='Search']")
    WebElement Datatable;
    @FindBy(xpath = "//div/h3[text()='Summary']")
    WebElement landonpage;
    @FindBy(xpath = "//div/h3[text()='Summary']")
    WebElement  statusdisplay;
    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
    @FindBy(xpath = "//button/h3[@text()='ProgramBase']")
    WebElement prog;

    public void clickProgButton() {
        newProgramButton.click();
    }

    public void verifyHeader() {
        String headerText = Header.getText();
        Assert.assertTrue("Header should contain Manage Program", headerText.contains("Manage Program"));
    }

    public String Paginationtext() {
        String ActualText = pagination.getText();
        String ExpectedText = "In total there are 4557 entries";
        Assert.assertEquals(ExpectedText, ActualText);
        return ActualText;
    }

    public String footertext() {
        System.out.println("WebElement for footer is" + footer);
        String FTText = footer.getText();
        System.out.println("Footer Text is :" + FTText);
        return FTText;
    }

    public void verifyDeleteicon() {
        boolean iconisdisabled = !DeleteIcon.isEnabled();
        Assert.assertTrue("Delete icon is disabled", iconisdisabled);
        Assert.assertTrue("Disabled Delete icon is displayed ", DeleteIcon.isDisplayed());
    }

    public String buttondisplay() {
        boolean eleselected = display.isDisplayed();
        return null;
    }

    public void noofrows() {
        int rows = TROWS.size();
        System.out.println("Rows:" + rows);
    }

    public void tableheader() {
        for (WebElement el : Headertext) {
            System.out.println(el.getText());
        }
    }

    public void verifySearchBar() {

        Assert.assertTrue("Search box is displayed", SearchBox.isDisplayed());
    }

    public void validatecheckbox() {

        for (WebElement row : rows) {
            WebElement cellEntry = row.findElement(By.xpath("//td[@class='entry-cell']"));
            String cellText = cellEntry.getText();
            if (!cellText.isEmpty()) {
                WebElement checkbox = row.findElement(By.xpath("//button[@id='checkbox']"));
                Assert.assertTrue("Checkbox is displayed", checkbox.isDisplayed());
            }
        }
    }

    public void manageprognameph() {
        String Text = Datatable.getText();
        Assert.assertFalse(" Program Name Phrase ", Text.isEmpty());
    }

    public void ManageProgramPage() {
        String expectedtext = "Summary";
        String actualtext = landonpage.getText();
        System.out.println(actualtext);

        if (expectedtext.equalsIgnoreCase(actualtext)) {
            System.out.println("User succesfully loggedIN");
        } else {
            System.out.println("Invalid credtendials!!");
        }
    }

    public void searchboxtext() {
        Searchtext.sendKeys();
    }

    public void Progdescription() {
        description.sendKeys();
    }

    public void progstatus() {
        statusdisplay.sendKeys();
    }

    public void statusdisplay() {
        prog.isDisplayed();


    }
}