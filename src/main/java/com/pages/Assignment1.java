package com.pages;
import org.testng.asserts.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.testng.Assert;
import com.qa.factory.DriverFactory;
import com.qa.util.JSONReader;
import com.qa.util.LoggerLoad;
import com.qa.util.ConfigReader;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.apache.lucene.search.*;

import java.util.List;
import java.util.Properties;
public class Assignment1 {

    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    long endtime, starttime;
    JSONReader jsonreader = new JSONReader();
    String filepath = prop.getProperty("TestdataPath");
    JsonObject jsondata = jsonreader.readJsonData(filepath);


    public Assignment1() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Assignment']")
    WebElement AssignmentButton;
    @FindBy(xpath = "//header[@id='header-id']")
    WebElement Header;
    @FindBy(xpath = "//html/body")
    WebElement body;
    @FindBy(xpath = "//button[text()='Delete']")
    WebElement DeleteIcon;
    @FindBy(xpath = "//button[text()='Search']")
    WebElement SearchBox;
    @FindBy(xpath = "//button[text()='Add new Assignment']")
    WebElement addNewAssignment;
    @FindBy(xpath = "//button[@id='checkbox']")
    WebElement checkbox;
    @FindBy(xpath = "//header[text()='Assignment name']")
    WebElement Assignmentname;
    @FindBy(xpath = "//header[text()='Assignment Description']")
    WebElement AssignmentDescription;
    @FindBy(xpath = "//header[text()='Assignment Date']]")
    WebElement AssignmentDate;
    @FindBy(xpath = "//header[text()='Assignment Grade']") WebElement assignmentGrade;
    @FindBy(xpath = "//button[text()='edit/delete']")
    WebElement editORdelete;
    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
    List<WebElement> columnheaders = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr/th"));
    @FindBy(xpath = "//button[@id='Pagination']") WebElement pagination;
    @FindBy(xpath ="//*[@id ='total assignment']" )WebElement footerMesg;
    @FindBy(xpath = "//*[@id='search-icon']")WebElement SearchIcon;
    @FindBy(xpath = "//td[@class='assignment-name']")WebElement assignmentname;
    @FindBy(xpath = "//td[@class='assignment-description']")WebElement assignDesc;
    @FindBy(xpath = "//table[@id='data-table']/tbody")WebElement Datatable;
    public void dashboard() {
//        String dashboardURL = prop.getProperty("DashBoardURl");
//
//        driver.get("DashBoardURl");
        long starttime = System.currentTimeMillis();
        String mytitle = driver.getTitle();
        String title = "DashboardPage";
        Assert.assertEquals(title, mytitle);

    }

    public void clickAssignmentButton() {
        AssignmentButton.click();
        long endtime = System.currentTimeMillis();
        String Assignmentpage = driver.getTitle();
        String Title = "Manage Assignment Page";
        Assert.assertEquals(Title, Assignmentpage);

    }

    public void ManageURL() {

        String AssignmentURL = driver.getCurrentUrl();
        org.testng.Assert.assertTrue(AssignmentURL.contains("Manage assignment"), "URL should contain Manage ");
    }

    public void validateResponseTime() {
        long responsetime = endtime - starttime;
        System.out.println("Response time: " + responsetime + "milliseconds");
        LoggerLoad.info("The response time is " + responsetime);

    }

    public void verifyHeader() {
        String headerText = Header.getText();
        Assert.assertTrue(headerText.contains("Manage Assignment"), "Header should contain Manage Assignment");

    }

    public void Spellcheck() {
        String portalpage = body.getText();
//        SpellChecker
    }

    public void verifyDeleteicon() {
        boolean iconisdisabled = !DeleteIcon.isEnabled();
        Assert.assertTrue(iconisdisabled, "Delete icon is disabled");
        Assert.assertTrue(DeleteIcon.isDisplayed(), "Disabled Delete icon is not displayed ");
    }

    public void verifySearchBar() {

        Assert.assertTrue(SearchBox.isDisplayed(), "Search box is displayed");
    }

    public void verifyAddNew() {
        Assert.assertTrue(addNewAssignment.isDisplayed(), "addnewAssignment button is displayed");
    }

    public void verifypageheaders() {
        WebElement[] elementstoassert = {checkbox, Assignmentname,AssignmentDescription, AssignmentDate,assignmentGrade,editORdelete };
        for(WebElement element: elementstoassert){
            String elementname= element.getAttribute("name");
            Assert.assertTrue(element.isDisplayed(), "the header" +elementname+ "is displayed");
        }

    }

    public void verifyEditIcon() {

        for (WebElement row : rows) {
            WebElement cellEntry = row.findElement(By.xpath("//td[@class='entry-cell']"));
            String celltext = cellEntry.getText();
            if (!celltext.isEmpty()) {
                WebElement editIcon = row.findElement(By.xpath("//td[@class='edit-icon']"));
              Assert.assertTrue(editIcon.isDisplayed(),"Edit icon is displayed ");
            }
        }
    }

    public void validateEditIcon(){

        for (WebElement row : rows) {
            WebElement cellEntry = row.findElement(By.xpath("//td[@class='entry-cell']"));
            String celltext = cellEntry.getText();
            if (celltext.isEmpty()) {
                WebElement editIcon = row.findElement(By.xpath("//td[@class='edit-icon']"));
                Assert.assertFalse(editIcon.isEnabled(),"Edit icon is not displayed ");
            }
        }

}

public void verifyDeleteIcon(){

    for (WebElement row : rows) {
        WebElement cellEntry = row.findElement(By.xpath("//td[@class='delete-cell']"));
        String celltext = cellEntry.getText();
        if (!celltext.isEmpty()) {
            WebElement deleteIcon = row.findElement(By.xpath("//td[@class='delete-icon']"));
            Assert.assertTrue(deleteIcon.isDisplayed(),"Edit icon is displayed ");
        }
    }
}

public void validateDeleteIcon(){
    for (WebElement row : rows) {
        WebElement cellEntry = row.findElement(By.xpath("//td[@class='entry-cell']"));
        String celltext = cellEntry.getText();
        if (celltext.isEmpty()) {
            WebElement deleteIcon = row.findElement(By.xpath("//td[@class='delete-icon']"));
            Assert.assertFalse(deleteIcon.isEnabled(),"Edit icon is not displayed ");
        }
    }

}

public void validateSortIcon() {

    for (WebElement columnheader : columnheaders) {
        String columnText = columnheader.getText();
        if (!columnText.contains("Edit") && !columnText.contains("Delete")) {
            WebElement sortIcon = columnheader.findElement(By.xpath("//span[@class='sort-icon']"));
            Assert.assertTrue(sortIcon.isDisplayed(), "Sort icon is displayed");
        } else {
            LoggerLoad.info("The Sort icon is not displayed");
        }
    }
}
 public void validatecheckbox(){

    for (WebElement row: rows){
        WebElement cellEntry = row.findElement(By.xpath("//td[@class='entry-cell']"));
        String cellText = cellEntry.getText();
        if(!cellText.isEmpty()){
            WebElement checkbox = row.findElement(By.xpath("//button[@id='checkbox']"));
            Assert.assertTrue(checkbox.isDisplayed(), "Checkbox is displayed");
        }
    }
}
public void validateFooter(){


}
public void pagination(){
        Assert.assertTrue(pagination.isDisplayed(), "Pagination is displayed");

}
public void footermessage(){
        Assert.assertTrue(footerMesg.isDisplayed(), "Total number of assignments are displayed");
        String Message= footerMesg.getText();
        LoggerLoad.info(Message);
}

public void managePage(){
    AssignmentButton.click();
    String mytitle = driver.getTitle();
    String title = "Manage Assignment Page";
    Assert.assertEquals(title, mytitle);
    LoggerLoad.info("Admin is on Manage Assignment Page");
}
 public void SearchAssignName(){

     SearchBox.click();
     JsonArray validDataArray = jsondata.getAsJsonArray("Valid Data");
     JsonObject AssignName= validDataArray.get(0).getAsJsonObject();
     //String assignmentname = AssignName.get("Assignment Name").getAsString();
     SearchBox.sendKeys(AssignName.get("Assignment Name").getAsString());
     SearchIcon.click();
 }

 public void ValidateAssignmentname(){
     String Text = Datatable.getText();
        Assert.assertFalse(Text.isEmpty(), "Assignment data is displayed ");

 }

 public void InvalidAssignmentName(){
     SearchBox.click();
     JsonArray invaliddataArray = jsondata.getAsJsonArray("invalid Data");
     JsonObject AssignName = invaliddataArray.get(0).getAsJsonObject();
     //String InvalidAssignName = AssignName.get("Assignment Name").getAsString();
     SearchBox.sendKeys(AssignName.get("Assignment Name").getAsString());
     SearchIcon.click();
 }

 public void nosearchResults(){
        String Text = Datatable.getText();
     Assert.assertTrue(Text.isEmpty(), "Assignmentname does not exits ");
 }
 public void searchAssignDesc(){
     SearchBox.click();
     JsonArray validdataArray = jsondata.getAsJsonArray("Valid Data");
     JsonObject AssignDesc = validdataArray.get(0).getAsJsonObject();
     String Assgndesc = AssignDesc.get("Assignment Description").getAsString();
     SearchBox.sendKeys(Assgndesc);
     SearchIcon.click();
 }

 public void ValidateAssignDesc(){
     Assert.assertTrue(assignDesc.isDisplayed(), "Assignment data is displayed ");
 }

 public void InvalidAssignDesc(){
     SearchBox.click();
     JsonArray invalidDataArray = jsondata.getAsJsonArray("invalid Data");
     JsonObject invalidAssgnDesc = invalidDataArray.get(0).getAsJsonObject();
     String invalidData = invalidAssgnDesc.get("Assignment Description").getAsString();
     SearchBox.sendKeys(invalidData);
     SearchIcon.click();

 }

 public void searchassignDate(){
     SearchBox.click();
     JsonArray validDateArray = jsondata.getAsJsonArray("Valid Data");
     JsonObject validAssgnDesc = validDateArray.get(0).getAsJsonObject();
     String validDate = validAssgnDesc.get("Assignment Due Date").getAsString();
     SearchBox.sendKeys(validDate);
     SearchIcon.click();

 }

 public void validateassignDate(){

     String Text = Datatable.getText();
     Assert.assertFalse(Text.isEmpty(), "Assignment data is displayed ");
 }

 public void InvalidAssignDate(){
     SearchBox.click();
     JsonArray invalidDateArray = jsondata.getAsJsonArray("invalid Data");
     JsonObject invalidAssgnDesc = invalidDateArray.get(0).getAsJsonObject();
     //String invalidDate = invalidAssgnDesc.get("Assignment Due Date").getAsString();
     SearchBox.sendKeys(invalidAssgnDesc.get("Assignment Due Date").getAsString());
     SearchIcon.click();
 }

 public void searchGrade(){
     SearchBox.click();
     JsonArray VaGradeArray = jsondata.getAsJsonArray("Valid Data");
     JsonObject validgrade = VaGradeArray.get(0).getAsJsonObject();
     SearchBox.sendKeys(validgrade.get("Grade By").getAsString());
     SearchIcon.click();
 }

 public void validateGrade(){
     String Text = Datatable.getText();
     Assert.assertFalse(Text.isEmpty(), "Assignment data is displayed ");
 }
 public void invalidGrade(){
     SearchBox.click();
     JsonArray inVaGradeArray = jsondata.getAsJsonArray("Valid Data");
     JsonObject invalidgrade = inVaGradeArray.get(0).getAsJsonObject();
     SearchBox.sendKeys(invalidgrade.get("Grade By").getAsString());
     SearchIcon.click();
 }
 }
