package tests;

import models.FailedEyewear;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import static org.testng.Assert.assertTrue;


public class EyewearTest extends TestBase {

    private static final String COLUMN_NAME = "eyewear";

    @Test
    public void testEyewearCondition() throws Exception {
        boolean flag = true;

        int indexOfColumn = app.getHelperBase().getIndexOfColumn(COLUMN_NAME);

        if(app.getHelperBase().validateFramesAndColumns(indexOfColumn, quantityOfFrames)) {
            flag = false;
        } else {

            saveFaledResults = new File(app.detectOsAndPath()[2]);

            //pw = new PrintWriter(new FileWriter(saveFaledResults, false));
            int counter = 0;

            String eyewearSource = "";
            String eyewearSample = "";

            //reads each value of the necessary column
            for(int i = 0; i < quantityOfFrames; i++) {

                eyewearSource = app.getHelperBase().selectDataFromSource().get(i)[indexOfColumn];
                eyewearSample = app.getHelperBase().selectDataFromSample().get(i)[indexOfColumn];

                if(!eyewearSource.equals(eyewearSample)) {
                    //creates file for failed results and put them into the file
                    //if(!saveFaledResults.exists()) saveFaledResults.createNewFile();
                    pw = new PrintWriter(new FileWriter(saveFaledResults, true));
                    pw.println(new FailedEyewear(i+1, eyewearSource, eyewearSample).toScv());

                    counter++;
                    if (counter == 1) {
                        flag = false;
                        break;
                    }
                    pw.close();
                }
                else counter = 0;
            }
            //pw.close();
        }
        assertTrue(flag);
    }
}