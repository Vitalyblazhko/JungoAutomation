package manager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplicationManager {

    static HelperBase helperBase;

    public static HelperBase getHelperBase() {
        return helperBase;
    }

    public ApplicationManager() {super();}

    public static String os = System.getProperty("os.name").toLowerCase();

    //detects OS and set files path
    public static String[] detectOsAndPath(){
        String[] path = new String[3];
        if(os.contains("win")) {
            //network sample path
           // path[0] = "C:\\Users\\"+System.getProperty("user.name")+"\\20190519145342_Demo_vitalyb_OpenCV_Path_person_results.csv";
            path[0] = "C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\GitHub\\JungoAutomation\\JungoCompare\\src\\test\\resources\\doc1.csv";
            //local source path
          //  path[1] = "C:\\Users\\"+System.getProperty("user.name")+"\\20190519145751_Demo_vitalyb_OpenCV_Path_person_results.csv";
            path[1] = "C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\GitHub\\JungoAutomation\\JungoCompare\\src\\test\\resources\\doc2.csv";
            //failed eyewear file path
            path[2] = "C:\\tools\\doc.csv";
        }else if(os.contains("linux") || os.contains("fedora")) {
            //network sample path
            path[0] = "/home/vitalyb/Desktop/20190519145342_Demo_vitalyb_OpenCV_Path_person_results.csv";
            //local source path
            path[1] = "/home/vitalyb/Desktop/20190519145751_Demo_vitalyb_OpenCV_Path_person_results.csv";
            //failed eyewear file path
            path[2] = "/home/vitalyb/Desktop/failed.csv";
        }
        return path;
    }

    //takes current date and time in format yyyyMMddHHmmss
    public static String getDateAndTime(){

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentDateAndTime = df.format(new Date());

        return currentDateAndTime;
    }


}
