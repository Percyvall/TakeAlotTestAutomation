package Utility;

import Accelerators.Base;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class utils extends Base {

    private static WebDriver driver = null;
    public static String File_Name = System.getProperty("user.dir") + "//src//test//resources//configs//config.properties";
    public static Properties properties = null;

    static {
        File f = new File(File_Name);
        properties = new Properties();
        FileInputStream in;
        try{
            in = new FileInputStream(f);
            properties.load(in);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String strKey){
            String strValue = null;
            try{
                File f = new File(File_Name);
                if(f.exists()){
                    strValue=properties.getProperty(strKey);
                }else {
                    System.out.println("File not found!");
                }
            }catch (Exception e){
                System.out.println(e);
            }
            return strValue;
    }

    public static String getTestCaseName(String sTestCase) throws Exception{
        String value = sTestCase;
        try{
            int posi = value.indexOf("@");
            value = value.substring(0, posi);
            posi = value.lastIndexOf(".");
            value = value.substring(posi + 1);
            return value;
        }catch (Exception e){
            throw (e);
        }
    }
}
