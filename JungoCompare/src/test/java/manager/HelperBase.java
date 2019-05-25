package manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tests.TestBase.app;

public class HelperBase {

    public static String pathSampleFile = app.detectOsAndPath()[0];
    public static String pathSourceFile = app.detectOsAndPath()[1];

    static List<String[]> dataFromSample;
    static List<String[]> dataFromSource;

    static int indexOfColumn;


    public HelperBase() {
        super();
    }

    //read csv file, splits and returns list of string array
    public static List<String[]> readCsvFile(String fileName) throws IOException {

        List<String[]> values = new ArrayList<String[]>();
        File file = new File(fileName);
        Scanner s = new Scanner(file);
        s.nextLine(); //ignore the first line
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] data = line.split(",");
            values.add(data);
        }
        s.close();
        return values;
    }

    //finds the index of necessary column
    public static int findIndexOfColumn(String fileName, String columnName) throws IOException {
        File file = new File(fileName);
        Scanner s = new Scanner(file);

        String[] arrOfCulumnNames = s.nextLine().split(",");

        int arrOfColumnNamesLength = arrOfCulumnNames.length;
        int columnIndex = -1;

        for(int i=0; i<arrOfColumnNamesLength; i++) {
            if(arrOfCulumnNames[i].equalsIgnoreCase(columnName)) {
                columnIndex = i;
            }
        }
        s.close();

        return columnIndex;
    }

    public static int getIndexOfColumn(String columnName) throws IOException {

        int indexOfColumnFromSample = findIndexOfColumn(pathSampleFile, columnName);
        int indexOfColumnFromSource = findIndexOfColumn(pathSourceFile, columnName);

        if (indexOfColumnFromSample == indexOfColumnFromSource) {
            indexOfColumn = indexOfColumnFromSample;
        } else indexOfColumn = -1;

        return indexOfColumn;

    }

    public static int getQuantityOfFrames() throws Exception {
        int quantityOfFrames = -1;
        int quantityOfFramesFromSample = selectDataFromSample().size();
        int quantityOfFramesFromSource = selectDataFromSource().size();
        if (quantityOfFramesFromSample == quantityOfFramesFromSource) {
            quantityOfFrames = quantityOfFramesFromSample;
        }
        return quantityOfFrames;

    }

    public static List<String[]> selectDataFromSample() throws Exception {
        try {
            //gets List of String from csv
            dataFromSample = readCsvFile(pathSampleFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataFromSample;
    }

    public static List<String[]> selectDataFromSource() throws Exception {
        try {
            //gets List of String from csv
            dataFromSource = readCsvFile(pathSourceFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataFromSource;
    }

    public static boolean validateFramesAndColumns(int indexOfColumn, int numberOfFrames) {
        boolean flag = false;
        if (indexOfColumn == -1) {
            System.out.println("***********************");
            System.out.println("Wrong index of column");
            System.out.println("***********************");
            flag = true;
        } else if (numberOfFrames == -1) {
            System.out.println("***********************");
            System.out.println("Wrong quantity of frames");
            System.out.println("***********************");
            flag = true;
        }
        return flag;
    }
}
