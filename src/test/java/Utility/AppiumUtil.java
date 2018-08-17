package Utility;

import java.io.IOException;
import java.text.MessageFormat;

public final class AppiumUtil {

    public  static void startServer() {
        Runtime runtime = Runtime.getRuntime();
        Property.initialize();
        try {
            String command = MessageFormat.format("cmd.exe /c start cmd.exe /k \"appium -a {0} -p {1} --session-override\"", Property.APPIUM_HOST, Property.APPIUM_PORT);
            runtime.exec(command);
            Thread.sleep(10*1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process proc = runtime.exec("taskkill /F /IM node.exe");
            proc.waitFor();

            proc = runtime.exec("taskkill /F /IM appium.exe");
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
