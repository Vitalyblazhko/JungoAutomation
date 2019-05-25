package tests;

import manager.ApplicationManager;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TestBase{

    public static ApplicationManager app = new ApplicationManager();

    File saveFaledResults;
    PrintWriter pw;

    @BeforeSuite
    // run codriver
    public static void runAndExecuteCoDriver(){
        String pathToExcutable = "";

        if(app.os.contains("win")) {
            //pathToExcutable = "C:\\Users\\"+System.getProperty("user.name")+"\\Codriver\\x64\\...";

            pathToExcutable = "C:\\Program Files\\Notep*\\notepad++.exe";

        } else if(app.os.contains("linux") || app.os.contains("fedora")) {
            //pathToExcutable = "/home/"+System.getProperty("user.name")+"/Desktop/...";
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(pathToExcutable);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
// create csv file


//    count quantity of frames

    int quantityOfFrames;
    {
        try {
            quantityOfFrames = app.getHelperBase().getQuantityOfFrames();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
