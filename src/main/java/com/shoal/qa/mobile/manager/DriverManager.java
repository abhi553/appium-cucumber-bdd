package com.shoal.qa.mobile.manager;

import com.shoal.qa.exceptions.TestFrameworkException;
import com.shoal.qa.mobile.utils.CommonUtils;
import com.shoal.qa.mobile.utils.GlobalParams;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    CommonUtils utils = new CommonUtils();

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();

        try {
            utils.log().info("initializing Appium driver");
            driver = switch (params.getPlatformName()) {
                case "Android" ->
                        new AndroidDriver(new URL("http://192.168.1.182:4723/wd/hub"), new CapabilitiesManager().getCaps());
                case "iOS" ->
                        new IOSDriver(new URL("http://192.168.1.182:4723/wd/hub"), new CapabilitiesManager().getCaps());
                default -> driver;
            };
            if (driver == null) {
                throw new Exception("driver is null. ABORT!!!");
            }
            utils.log().info("Driver is initialized");
            DriverManager.driver.set(driver);
        } catch (IOException e) {
            utils.log().fatal("Driver initialization failure. ABORT !!!!" + e);
            throw new TestFrameworkException("Failed to load capabilities",e);
        }

    }

}
