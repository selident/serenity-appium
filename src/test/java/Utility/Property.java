package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Property {

    public static String APPIUM_HOST;
    public static String APPIUM_PORT;
    public static String APPIUM_SERVER;
    public static String APPIUM_PLATFORM;
    public static String DEVICE_NAME;
    public static String UUID;
    public static String APPIUM_LOG_LEVEL;
    public static String NO_RESET;
    public static String APP_FILE;
    public static String EMULATOR_DEVICENAME;
    public static int IMPLICIT_WAIT_TIME;

    public static void initialize(){
        Properties props = new Properties();
        try {
            FileInputStream in = new FileInputStream("serenity.properties");
            props.load(in);
            in.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        APPIUM_SERVER = props.getProperty("server.hub", "");
        APPIUM_PLATFORM = props.getProperty("appium.platformName", "");
        DEVICE_NAME = props.getProperty("appium.deviceName", "");
        UUID = props.getProperty("appium.deviceName", "");
        APPIUM_LOG_LEVEL = props.getProperty("appium.log", "");
        NO_RESET = props.getProperty("no.reset", "");
        APP_FILE = props.getProperty("appium.app", "");
        EMULATOR_DEVICENAME = props.getProperty("emulator.deviceName", "");
        IMPLICIT_WAIT_TIME = Integer.parseInt(props.getProperty("webdriver.timeouts.implicitlywait", ""));

        String appHub = APPIUM_SERVER.replaceFirst("http.*://", "").replaceFirst("/wd/hub$", "");
        APPIUM_HOST = appHub.split(":")[0];
        APPIUM_PORT = appHub.split(":")[1];
    }
}
