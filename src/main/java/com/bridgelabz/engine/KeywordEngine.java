package com.bridgelabz.engine;

import com.bridgelabz.base.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class KeywordEngine {
    public WebDriver driver;
    public Properties properties;
    BaseClass baseClass;
    WebElement element;

    public static Workbook workbook;
    public static Sheet sheet;

    public String scenario_sheet_path = System.getProperty("user.dir") + "\\src\\main\\resources\\spotify.xlsx";

    public void starExecution(String sheetName) {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(scenario_sheet_path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = workbook.getSheet(sheetName);

        int c = 0;
        for (int r = 0; r < sheet.getLastRowNum(); r++) {

            try {
                String locatorType = sheet.getRow(r + 1).getCell(c + 1).toString().trim();
                String locatorValue = sheet.getRow(r + 1).getCell(c + 2).toString().trim();
                String action = sheet.getRow(r + 1).getCell(c + 3).toString().trim();
                String value = sheet.getRow(r + 1).getCell(c + 4).toString().trim();

                switch (action) {
                    case "openBrowser":
                        baseClass = new BaseClass();

                        properties = baseClass.initializeProperties();

                        if (value.isEmpty() || value.equals("NA")) {
                            driver = baseClass.launchBrowser(properties.getProperty("browser"));
                        } else {
                            driver = baseClass.launchBrowser(value);
                        }
                        break;
                    case "enterUrl":
                        if (value.isEmpty() || value.equals("NA")) {
                            driver.get(properties.getProperty("url"));
                        } else {
                            driver.get(value);
                        }
                        break;
                    case "quit":
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        driver.quit();
                        break;
                    case "close":
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        driver.close();
                        break;
                    default:
                        break;
                }

                switch (locatorType) {
                    case "id":
                        element = driver.findElement(By.id(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "name":
                        element = driver.findElement(By.name(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "xpath":
                        element = driver.findElement(By.xpath(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "cssSelector":
                        element = driver.findElement(By.cssSelector(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "className":
                        element = driver.findElement(By.className(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "tagName":
                        element = driver.findElement(By.tagName(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }
                        break;
                    case "linkText":
                        element = driver.findElement(By.linkText(locatorValue));
                        if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);
                        }
                        break;
                    case "partialLinkText":
                        element = driver.findElement(By.partialLinkText(locatorValue));
                        if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);
                        }
                        break;
                    default:
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
