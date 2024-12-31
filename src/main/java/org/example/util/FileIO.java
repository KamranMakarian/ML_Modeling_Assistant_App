package org.example.util;

import org.example.model.DatasetProcessor;
import org.example.model.Imputer;

import java.io.*;
import java.util.*;

public class FileIO {

    public List<Map<String, String>> data = new ArrayList<>();

    public List<Map<String, String>> getData() {
        return data;
    }

    public void readData(String filePath) {
        // Clear existing data before analyzing a new dataset
        data.clear();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {

            // Extracting features from header.
            String header = br.readLine();
            String[] feature = header.split(",");

            // Processing the rows of data.
            int rowCount = 0;
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                // Creating a list of rows as maps.
                Map<String, String> rowMap = new HashMap<>();
                String[] rowValues = currentLine.split(",");
                rowCount++;
                // rowMap.put("row",String.valueOf(rowCount));
                for (int i = 0; i < rowValues.length; i++) {
                    rowMap.put(feature[i], rowValues[i]);
                }
                data.add(rowMap);
            }
        } catch (IOException e) {
            System.out.println("File reading unsuccessful: " + e.getMessage());
        }
    }

    public void createImputedCSV(Imputer imputer, DatasetProcessor datasetProcessor, String outputFilePath, String outputFileName) {
        String fullFilePath = outputFilePath + File.separator + outputFileName + ".csv";
        List<Map<String, String>> imputedData = imputer.getImputedData();

        try {
            File csvFile = new File(fullFilePath);

            // Ensure the directory exists
            File directory = new File(outputFilePath);
            if (!directory.exists() && !directory.mkdirs()) {
                System.out.println("Failed to create directory. Exiting.");
                return;
            }

            if (csvFile.exists()) {
                System.out.println("File already exists. Exiting.");
                return;
            } else if (csvFile.createNewFile()) {
                System.out.println("CSV file created: " + csvFile.getAbsolutePath());
            }

            // Write data to the CSV file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, false))) {
                // Write header row
                Set<String> features = datasetProcessor.getFeatures();
                if (features != null && !features.isEmpty()) {
                    writer.write(String.join(",", features));
                    writer.newLine();
                }

                // Write data rows
                for (Map<String, String> row : imputedData) {
                    List<String> rowValues = new ArrayList<>();
                    for (String feature : features) {
                        rowValues.add(row.getOrDefault(feature, ""));
                    }
                    writer.write(String.join(",", rowValues));
                    writer.newLine();
                }
                System.out.println("Data successfully written to the CSV file.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

}
