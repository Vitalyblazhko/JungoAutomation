package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class PitchTest extends TestBase {

    private static final String COLUMN_NAME = "Headpose Pitch (deg)";

    @Test(enabled = true)
    public void testPitch() throws Exception {
        boolean flag = true;
        int indexOfColumn = app.getHelperBase().getIndexOfColumn(COLUMN_NAME);

//      int counter = 0;

        if(!app.getHelperBase().validateFramesAndColumns(indexOfColumn, quantityOfFrames)){
            double[] sample = new double[quantityOfFrames];
            double[] source = new double[quantityOfFrames];

//            saveFaledResults = new File()

            //reads each value of the necessary column
            for (int i = 0; i < quantityOfFrames; i++) {
                source[i] = Double.parseDouble(app.getHelperBase().selectDataFromSource().get(i)[indexOfColumn]);
                sample[i] = Double.parseDouble(app.getHelperBase().selectDataFromSample().get(i)[indexOfColumn]);
            }
//               if(source[i] == 9999 || sample[i] == 9999){
//
//               }
            assertArrayEquals(sample, source, 5);
        } else {
            flag = false;
        }
        assertTrue(flag);
    }
}