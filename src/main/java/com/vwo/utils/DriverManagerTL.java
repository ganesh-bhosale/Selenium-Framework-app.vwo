package com.vwo.utils;


import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.apache.poi.hssf.record.CFHeader12Record;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

public class DriverManagerTL {


    static WebDriver driver;
    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static WebDriver getDriver(){
        return dr.get();
    }

    public static void unload(){
        dr.remove();
    }


    @BeforeSuite
    public static void init() throws Exception {
        if (getDriver() == null) {
            try{
                startBrowser(PropertyReader.readKey("browser"));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static WebDriver startBrowser(String browserName){
        if(browserName.equalsIgnoreCase("edge")){
            EdgeOptions options = new EdgeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            setDriver(new EdgeDriver(options));
            getDriver().manage().window().maximize();
        }
        else if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            setDriver(new ChromeDriver(options));
            getDriver().manage().window().maximize();
        }

        return getDriver();
    }

    @AfterSuite
    public static void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            unload();
        }
    }
}
