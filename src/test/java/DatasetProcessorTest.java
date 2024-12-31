import org.example.model.DatasetProcessor;
import org.example.util.FileIO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DatasetProcessorTest {

    private DatasetProcessor newDatasetProcessor;

    @BeforeEach
    public void setup() {
        FileIO newFileIO = new FileIO();
        newDatasetProcessor = new DatasetProcessor();
        newFileIO.readData("src/test/java/DatasetProcessorTest.csv");
        newDatasetProcessor.dataAnalysis(newFileIO);
    }

    @Test
    public void testNumberOfRowsAfterDataAnalysis() {

        int numberOfRows = newDatasetProcessor.getNumberOfRows();

        assertEquals(5,numberOfRows,"Expected 5, found " + numberOfRows + ".");
    }

    @Test
    public void testNumberOfFeatures() {

        int numberOfFeatures = newDatasetProcessor.getNumberOfFeatures();

        assertEquals(6,numberOfFeatures,"Expected 6, found " + numberOfFeatures + ".");
    }

    @Test
    public void testMeanValueCalculation() {

        Map<String, Double> actualMean = newDatasetProcessor.calculateMean();

        Map<String, Double> expectedMean = new HashMap<>();
        expectedMean.put("income",7000.0);
        expectedMean.put("experience",7.0);
        expectedMean.put("age",54.0);

        assertEquals(expectedMean,actualMean,"Expected {'income'= String.valueOf(7000.0), 'experience'= String.valueOf(7), 'age'=54}, found " + actualMean);
    }
}
