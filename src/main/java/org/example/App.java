package org.example;

import org.example.model.*;
import org.example.util.FileIO;
import org.example.util.UIUtils;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileIO fileIO = new FileIO();
        DatasetProcessor datasetProcessor = new DatasetProcessor();
        UIUtils uiUtils = new UIUtils();

        List<MLModel> allModels = new ArrayList<>();

        allModels.add(new DBSCAN());
        allModels.add(new DecisionTreeClassifier());
        allModels.add(new DecisionTreeRegressor());
        allModels.add(new KMeans());
        allModels.add(new LinearRegression());
        allModels.add(new LogisticRegression());
        allModels.add(new NeuralNetworkClassifier());
        allModels.add(new NeuralNetworkRegressor());
        allModels.add(new PCA());
        allModels.add(new RandomForestClassifier());
        allModels.add(new RandomForestRegressor());
        allModels.add(new XGBoostClassifier());
        allModels.add(new XGBoostRegressor());

        boolean maninMenuRunning = true;
        while(maninMenuRunning) {
            uiUtils.mainMenu();

            try {
                int mainMenuChoice = uiUtils.promptUserForInt("Please enter your choice: ", 1, 4);
                switch (mainMenuChoice) {
                    case 1:
                        boolean inputFilePath = true;
                        boolean case1Running = true;
                        String filePath = null;
                        while (inputFilePath) {
                            filePath = uiUtils.promptUserForString("\nPlease enter the file path with extension (q to quit).");
                            if (!filePath.equalsIgnoreCase("q")) {
                                File inputFile = new File(filePath);
                                try (Scanner inputData = new Scanner(inputFile)) {
                                    inputFilePath = false;
                                }
                                catch (Exception e) {
                                    uiUtils.displayMessage("Invalid input. Please try again.");
                                }
                            }
                            else {
                                case1Running = false;
                                break;
                            }
                        }

                        if (case1Running) {
                            fileIO.readData(filePath);
                            datasetProcessor.dataAnalysis(fileIO);
                            uiUtils.displayMessage("File path entered successfully.");
                        }

                        while(case1Running) {
                            try {
                                uiUtils.menuCase1();
                                int case1Choice = uiUtils.promptUserForInt("Please enter your choice: ", 1, 6);
                                try {
                                    switch (case1Choice) {
                                        case 1:
                                            System.out.println("Data: ");
                                            for (int i = 0; i < fileIO.getData().size(); i++) {
                                                System.out.println(fileIO.getData().get(i));
                                            }
                                            break;
                                        case 2:
                                            if (!datasetProcessor.getNumericalFeatures().isEmpty()) {
                                                System.out.println("Numerical Features: " + datasetProcessor.getNumericalFeatures());
                                            }
                                            if (!datasetProcessor.getCategoricalFeatures().isEmpty()) {
                                                System.out.println("Categorical Features: " + datasetProcessor.getCategoricalFeatures());
                                            }
                                            if (!datasetProcessor.getDateTimeFeatures().isEmpty()) {
                                                System.out.println("DateTime Features: " + datasetProcessor.getDateTimeFeatures());
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Number of Features: " + datasetProcessor.getNumberOfFeatures());
                                            System.out.println("Number of Rows: " + datasetProcessor.getNumberOfRows());
                                            if (!datasetProcessor.getRowsWithMissingValue().isEmpty()) {
                                                System.out.println("Rows with Missing Values: " + datasetProcessor.getRowsWithMissingValue());
                                            } else {
                                                uiUtils.displayMessage("No missing value was detected.");
                                            }
                                            System.out.println("Mean of Numerical Features: " + datasetProcessor.calculateMean());
                                            System.out.println("Standard Deviation of Numerical Features: " + datasetProcessor.calculateStdDev());
                                            break;
                                        case 4:
                                            Imputer imputer = new Imputer();
                                            imputer.imputeData(fileIO,datasetProcessor);
                                            String outputFilePath = uiUtils.promptUserForString("Please enter the output file path: ");
                                            String outputFileName = uiUtils.promptUserForString("Please enter the name of the output file: ");
                                            fileIO.createImputedCSV(imputer, datasetProcessor, outputFilePath, outputFileName);
                                            break;
                                        case 5:
                                            boolean targetVariableKnown = false;
                                            if(uiUtils.promptUserForString("Is target variable known? (y/n): ").equalsIgnoreCase("y")) {
                                                targetVariableKnown = true;
                                            }
                                            boolean targetVariableNumerical = false;
                                            if (uiUtils.promptUserForString("Is target variable numerical or categorical? (n/c): ").equalsIgnoreCase("n")) {
                                                targetVariableNumerical = true;
                                            }
                                            MLModel autoSelectedModel = ModelSelector.autoSelectModel(datasetProcessor, targetVariableKnown, targetVariableNumerical);
                                            if (autoSelectedModel == null){
                                                uiUtils.displayMessage("No recommendation is available for this unsupervised learning project.");
                                            } else {
                                                System.out.println("\n" + autoSelectedModel.recommendModel());
                                                System.out.println("\n" + autoSelectedModel.describeModel());
                                            }
                                            break;
                                        case 6:
                                            case1Running = false;
                                            break;
                                        default:
                                            uiUtils.displayMessage("Invalid choice. Please try again.");
                                    }
                                } catch (Exception e) {
                                    uiUtils.displayMessage("Invalid input. Please enter a number from the menu.");
                                }
                            } catch (Exception e) {
                                uiUtils.displayMessage("Invalid input. Please try again.");
                            }
                        }
                        break;
                    case 2:
                        boolean case2Running = true;
                        while (case2Running) {
                            uiUtils.menuCase2();
                            int case2Choice = uiUtils.promptUserForInt("Please enter your choice: ", 1,4);
                            switch (case2Choice) {
                                case 1:
                                    uiUtils.displayModelsByType(allModels,"Supervised");
                                    break;
                                case 2:
                                    uiUtils.displayModelsByType(allModels,"Unsupervised");
                                    break;
                                case 3:
                                    boolean case3Running = true;
                                    while (case3Running) {
                                        uiUtils.displayMessage("\n*** Available Models:");
                                        for (int i = 0; i < allModels.size(); i++) {
                                            uiUtils.displayMessage((i + 1) + ". " + allModels.get(i).modelName + " (" + allModels.get(i).modelType + " " + allModels.get(i).modelFunction + ")");
                                        }
                                        System.out.println((allModels.size() + 1) + ". Back to Model Exploration Menu.");
                                        int modelIndex = uiUtils.promptUserForInt("Please enter your choice: ", 1, (allModels.size() + 1));
                                        if (modelIndex != (allModels.size() + 1)) {
                                            System.out.println("\n" + allModels.get(modelIndex - 1).describeModel());
                                        }
                                        else {
                                            case3Running = false;
                                            break;
                                        }
                                    }
                                    break;
                                case 4:
                                    case2Running = false;
                                    break;
                            }
                        }
                        break;
                    case 3:
                        uiUtils.displayHelp();
                        break;
                    case 4:
                        maninMenuRunning = false;
                        break;
                    default:
                        uiUtils.displayMessage("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                uiUtils.displayMessage("Invalid input. Please enter a number from the menu.");
            }
        }
        sc.close();
    }
}