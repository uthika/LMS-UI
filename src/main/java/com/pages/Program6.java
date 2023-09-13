package com.pages;
import com.qa.factory.*;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import com.qa.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.*;
public class Program6 {
    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();

    List<String> originaldata;
    List<String> expecteddata;
    @FindBy(xpath = "//table[@id='data-table']/tbody/th[text()= 'Assignment Name']")
    WebElement rowHeader;
    WebElement navigationBarElement = driver.findElement(By.cssSelector("ul.navigation-bar"));
    WebElement prognamecol = driver.findElement(By.xpath("//table/th/name"));

    public void navigation() {

        WebElement elementToClick = navigationBarElement.findElement(By.xpath(".//li[contains(text()= elementText "));
        elementToClick.click();
    }

    public void clickToSort() {

        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='data-table']/tbody/th/tr/td[text()= 'Assignment Name']"));
        List<String> celldata = new ArrayList<>();
        for (WebElement cell : cells) {
            celldata.add(cell.getText());
        }
        originaldata = new ArrayList<>(celldata);
        originaldata.sort(Collections.reverseOrder());

        rowHeader.click();
    }
    List<WebElement> sortedcells = driver.findElements(By.xpath("//table[@id='data-table']/tbody/th/tr/td[text()= 'Assignment Name']"));
    public void sortDesc() {

        List<String> sortedcelldata = new ArrayList<>();
        for (WebElement cell : sortedcells) {
            sortedcelldata.add(cell.getText());
        }
        expecteddata = new ArrayList<>(sortedcelldata);
        Assert.assertEquals("The column assignment name is sorted in descending order", expecteddata, originaldata);

    }

    public void validateAsc() {
        List<WebElement> afterData = driver.findElements(By.xpath("//table[@id='data-table']/tbody/th/tr/td[text()= 'Assignment Name']"));
        List<String> afterDatacell = new ArrayList<>();
        for (WebElement cell : afterData) {
            afterDatacell.add(cell.getText());
        }
        List<String> newsorteddata = new ArrayList<>(afterDatacell);
        Collections.sort(expecteddata);

        Assert.assertEquals("The column assignment name is sorted in descending order", expecteddata, newsorteddata);

    }

    public void colinasssnsorted() {
        List<WebElement> sortedcells = driver.findElements(By.xpath("//table[@id='data-table']/tbody/th/tr/td[text()= 'Assignment Name']"));
        List<String> sortedcelldata = new ArrayList<>();
        for (WebElement cell : sortedcells) {
            sortedcelldata.add(cell.getText());
        }
        expecteddata = new ArrayList<>(sortedcelldata);
        Assert.assertEquals("The column assignment name is sorted in asscending order", originaldata, expecteddata);

    }
    public void  validateAscdescription(){

        List<WebElement> sortedcells = driver.findElements(By.xpath("//table[@id='data-table']/tbody/th/tr/td[text()= 'Assignment Name']"));
        List<String> sortdatacol= new ArrayList<>();
        for (WebElement cell : sortedcells) {
            sortdatacol.add(cell.getText());
        }
        expecteddata = new ArrayList<>(sortdatacol);
        Assert.assertEquals("The column assignment name is sorted in descending order", expecteddata, originaldata);

    }


}
