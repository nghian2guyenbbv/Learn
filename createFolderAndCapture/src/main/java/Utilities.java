import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Utilities {

    public static void main(String[] args) {
        captureScreenShotWithFolder("testFunctionName","APPL01398116");
    }

    /** create new folder and capture the screen
     *
     * @param functionName
     */
    public static void captureScreenShotWithFolder(String functionName, String appId){
        File src = new File("D:\\TPFico\\Automation function\\Automation function\\abc.txt");
        try {
            if (functionName != null && !functionName.isEmpty()) {
                if (appId != null && !appId.isEmpty()) {
                    FileUtils.copyFile(src, new File("C:/images/" + functionName + "/" + appId + "/" + appId + "_" + System.currentTimeMillis() + Constant.SCREENSHOT_EXTENSION));

                } else {
                    FileUtils.copyFile(src, new File("C:/images/" + functionName + "/" + System.currentTimeMillis() + Constant.SCREENSHOT_EXTENSION));

                }

            } else {
                FileUtils.copyFile(src, new File("C:/images/" + System.currentTimeMillis() + Constant.SCREENSHOT_EXTENSION));

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
