package tests;

import manager.ApplicationManager;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class TestBase{

    public static ApplicationManager app = new ApplicationManager();

    File saveFaledResults;
    PrintWriter pw;

    //counts quantity of frames
    int quantityOfFrames;
    {
        try {
            quantityOfFrames = app.getHelperBase().getQuantityOfFrames();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    //Edit codriver_sample_config.yml
//            //
//            // String originalFilePath = "";
//    String newFilePath="";
//    String originalFileContent = "";
//
//        if(os.contains("win")) {
//        originalFilePath = "C:\\Users\\Vital\\eclipse-workspace\\2019-03-02 EditFile\\src\\poem.txt";
//        newFilePath = "C:\\Users\\Vital\\eclipse-workspace\\2019-03-02 EditFile\\src\\poem2.txt";
//    }else if(os.contains("ubuntu") || os.contains("fedora")) {
//        originalFilePath = "/var/ccc";
//        newFilePath = "/var/ccc";
//    }
//
//    BufferedReader reader = null;
//    BufferedWriter writer = null;
//
//	    try {
//
//        reader = new BufferedReader(new FileReader(originalFilePath));
//
//        String currentReadingLine = reader.readLine();
//
//        while (currentReadingLine != null) {
//            originalFileContent = originalFileContent + currentReadingLine + "\n";
//            currentReadingLine = reader.readLine();
//        }
//
//        //replace string in file
//        String modifiedFileContentWithReplacesLines = originalFileContent.replaceAll(STRING_A, STRING_B);
//
//        //select splitter
//        String splitter = "Once in the dark";
//
//        //create array of strings from 2 instances
//        String[] arrayOfStringsWithoutSplitter = modifiedFileContentWithReplacesLines.split(splitter);
//
//        //create new string with empty line after splitter
//        String modifiedFileContentWithReplacesLinesAndInsertedEmptyLine = arrayOfStringsWithoutSplitter[0] + splitter + "\n" + arrayOfStringsWithoutSplitter[1];
//
//        //select splitter2 for insert full string
//        String splitter2 = "He swam with a shark";
//
//        //create array of strings from 2 instances
//        String[] arrayOfStringsWithReplacesLinesAndInsertedEmptyLineAndInsertedString = modifiedFileContentWithReplacesLinesAndInsertedEmptyLine.split(splitter2);
//
//        //create new string with specific line after splitter
//        String modifiedFileContentWithReplacesLinesAndInsertedEmptyLineAndInsertedString = arrayOfStringsWithReplacesLinesAndInsertedEmptyLineAndInsertedString[0] + splitter2 + "\n"+ STRING_C + arrayOfStringsWithReplacesLinesAndInsertedEmptyLineAndInsertedString[1];
//
//
//        writer = new BufferedWriter(new FileWriter(newFilePath));
//
//        writer.write(modifiedFileContentWithReplacesLinesAndInsertedEmptyLineAndInsertedString);
//
//    } catch (IOException e) {
//        //handle exception
//    } finally {
//
//        try {
//            if (reader != null) {
//                reader.close();
//            }
//            if (writer != null) {
//                writer.close();
//            }
//        } catch (IOException e) {
//            //handle exception
//        }
//    }
//}
//runs codriver
    public static void runAndExecuteCoDriver() {
        String pathToExcutable = "";

        if (app.os.contains("win")) {
            pathToExcutable = "C:\\Users\\" + System.getProperty("user.name") + "\\Codriver\\x64\\...";

        } else if (app.os.contains("linux") || app.os.contains("fedora")) {

            File pathBeroreJungoDirectory = new File("/home/" + System.getProperty("user.name") + "/Desktop/");

            String[] directories = pathBeroreJungoDirectory.list(new FilenameFilter() {
                @Override
                public boolean accept(File current, String name) {
                    return new File(current, name).isDirectory();
                }
            });

            pathToExcutable = pathBeroreJungoDirectory.toString();

            int quantityOfDirectories = directories.length;

            for (int i = 0; i < quantityOfDirectories; i++) {
                if (directories[i].contains("Jungo")) {
                    pathToExcutable = pathToExcutable + directories[i];
                }
            }
        }
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(pathToExcutable);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
