package Accelerators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static String sBrowserName;
    public static String sBrowserVersion;

    public static WebDriver OpenBrowser(String sBrowser){

        try{
            if(sBrowserName.equalsIgnoreCase("Chrome")){
                ChromeOptions options = new ChromeOptions();
                DesiredCapabilities capabilities = new DesiredCapabilities();
              // sBrowserVersion = capabilities.getBrowserVersion();
                sBrowserVersion = capabilities.getBrowserVersion();
                options.addArguments("--incognito");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                sBrowserVersion=(String) capabilities.getCapability("version");
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                driver.get(" https://www.takealot.com/");
            }else if (sBrowserName.equalsIgnoreCase("Firefox")){
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return driver;
    }

    public static void CleanUp(){
        driver.quit();
    }
}
