package org.example.model;

import org.example.util.FileIO;

import java.util.*;

public class Imputer {

    //    List<Map<String, String>> data = new ArrayList<>();
    List<Map<String, String>> imputedData = new ArrayList<>();

    public List<Map<String, String>> getImputedData() {
        return imputedData;
    }

    public void imputeData(FileIO fileIO, DatasetProcessor datasetProcessor) {
        List<Map<String, String>> data = fileIO.getData();
        Map<String, Double> meanValues = datasetProcessor.calculateMean();
        Set<String> numericalFeatures = datasetProcessor.getNumericalFeatures();

        for (Map<String, String> dataRow : data) {
            Map<String, String> rowMap = new HashMap<>();
            for (Map.Entry<String, String> entry : dataRow.entrySet()) {
                if (numericalFeatures.contains(entry.getKey()) && (entry.getValue() == null || entry.getValue().isEmpty())) {
                    String formattedValue = String.format("%.4f", meanValues.get(entry.getKey()));
                    rowMap.put(entry.getKey(), formattedValue);
                } else {
                    rowMap.put(entry.getKey(), entry.getValue());
                }
            }
            imputedData.add(rowMap);
        }

    }
}