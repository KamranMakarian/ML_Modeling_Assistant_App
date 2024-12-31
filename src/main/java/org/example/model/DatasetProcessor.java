package org.example.model;

import org.example.util.FileIO;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class DatasetProcessor implements Calculable {

    public List<Map<String, String>> data = new ArrayList<>();
    public Set<String> features = new HashSet<>();
    public Set<String> numericalFeatures = new HashSet<>();
    public Set<String> dateTimeFeatures = new HashSet<>();
    public Set<String> categoricalFeatures = new HashSet<>();
    public Set<Integer> rowsWithMissingValue = new HashSet<>();
    public int numberOfRows;
    public int numberOfFeatures;

    public DatasetProcessor() {
    }


    public Set<String> getFeatures() {
        return features;
    }

    public Set<String> getNumericalFeatures() {
        return numericalFeatures;
    }

    public Set<String> getDateTimeFeatures(){
        return dateTimeFeatures;
    }

    public Set<String> getCategoricalFeatures() {
        return categoricalFeatures;
    }

    public Set<Integer> getRowsWithMissingValue(){
        return rowsWithMissingValue;
    }

    public int getNumberOfRows(){
        return numberOfRows;
    }

    public int getNumberOfFeatures() {
        return numberOfFeatures;
    }


    public void dataAnalysis(FileIO fileIO) {

        data = fileIO.getData();
        features.clear();
        numericalFeatures.clear();
        dateTimeFeatures.clear();
        categoricalFeatures.clear();
        rowsWithMissingValue.clear();
        numberOfRows = 0;
        numberOfFeatures = 0;

        Set<Integer> indexWithMissingValue = new HashSet<>();

        for (int i = 0; i < data.size(); i++) {

            for(Map.Entry<String,String> rowMap : data.get(i).entrySet()) {

                features.add(rowMap.getKey());

                if (rowMap.getValue().isEmpty()) {
                    indexWithMissingValue.add(i);
                }
                else if (isNumeric(rowMap.getValue())) {
                    numericalFeatures.add(rowMap.getKey());
                }
                else if (isDateTime(rowMap.getValue())) {
                    dateTimeFeatures.add(rowMap.getKey());
                }
                else if (isCategorical(rowMap.getValue())) {
                    categoricalFeatures.add(rowMap.getKey());
                }
            }
        }
        // sorting rowsWithMissingValues
        rowsWithMissingValue = new TreeSet<>(indexWithMissingValue);

        numberOfFeatures = features.size();
        numberOfRows = data.size();
    }


    @Override
    public Map<String, Double> calculateMean() {
        if (data.isEmpty()) {
            return new HashMap<>();
        }
        return computeMeanValues();
    }

    @Override
    public Map<String, Double> calculateStdDev() {
        if (data.isEmpty()) {
            return new HashMap<>();
        }
        Map<String, Double> meanValues = computeMeanValues();
        Map<String, Double> stdValues = new HashMap<>();

        for (String feat : numericalFeatures) {
            double diffSquaredSum = 0;
            double counter = 0;

            for (Map<String, String> row : data) {
                String value = row.get(feat);
                if (value != null && !value.isEmpty()) {
                    try {
                        double diff = Double.parseDouble(value) - meanValues.get(feat);
                        diffSquaredSum += diff * diff;
                        counter++;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid numerical value for feature " + feat + ": " + value);
                    }
                }
            }
            if (counter > 0) {
                stdValues.put(feat, Math.sqrt(diffSquaredSum / counter));
            }
        }

        return stdValues;
    }

    private Map<String, Double> computeMeanValues() {
        Map<String, Double> meanValues = new HashMap<>();

        for (String feat : numericalFeatures) {
            double featureTotal = 0;
            double counter = 0;
            for (Map<String, String> row : data) {
                String value = row.get(feat);
                if (value != null && !value.isEmpty()) {
                    try {
                        featureTotal += Double.parseDouble(value);
                        counter++;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid numerical value for feature " + feat + ": " + value);
                    }
                }
            }
            if (counter > 0) {
                meanValues.put(feat, featureTotal / counter);
            }
        }
        return meanValues;
    }

    private boolean isNumeric(String value) {
        if (value == null) {
            return false;
        }
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDateTime(String value) {
        if (value == null) {
            return false;
        }
        try {
            LocalDate.parse(value);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    private boolean isCategorical(String value) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }

        if (isNumeric(value) || isDateTime(value)) {
            return false;
        }

        if (value.matches(".*\\d.*") || value.matches(".*[!@#$%^&*()].*")) {
            return false; // Contains digits or special characters, unlikely to be categorical.
        }

        return true;
    }
}
