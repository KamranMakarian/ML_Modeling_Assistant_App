package org.example.util;

import org.example.model.MLModel;

import java.util.List;
import java.util.Scanner;

public class UIUtils {

    private Scanner keyboard = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("\n* Main Menu: ");
        System.out.println("1. Analyze Dataset");
        System.out.println("2. Explore models");
        System.out.println("3. Help");
        System.out.println("4. Exit");
    }

    public void menuCase1() {
        System.out.println("\n** Data Analysis Menu: ");
        System.out.println("1. Display Data.");
        System.out.println("2. Display Feature Groups.");
        System.out.println("3. Display Summary Statistics.");
        System.out.println("4. Impute and Save.");
        System.out.println("5. Auto-select a Model.");
        System.out.println("6. Back to Main Menu.");
    }

    public void menuCase2() {
        System.out.println("\n** Model Exploration Menu: ");
        System.out.println("1. View Supervised Models.");
        System.out.println("2. View Unsupervised Models.");
        System.out.println("3. View All Models.");
        System.out.println("4. Back to Main Menu.");
    }

    public int promptUserForInt(String prompt, int lowerBound, int upperBound) {
        boolean inputIsValid = false;
        int userChoiceAsInt = -1;

        while (!inputIsValid) {
            System.out.println(prompt);
            String userChoiceAsString = keyboard.nextLine();
            try {
                userChoiceAsInt = Integer.parseInt(userChoiceAsString);
                if (userChoiceAsInt >= lowerBound && userChoiceAsInt <= upperBound) {
                    inputIsValid = true;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }

        return userChoiceAsInt;
    }

    public String promptUserForString(String prompt) {
        System.out.print(prompt);
        String userName = keyboard.nextLine();
        return userName.trim();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayModelsByType(List<MLModel> allModels, String modelType) {
        System.out.println("\nAvailable " + modelType + " Models:");
        for (MLModel model : allModels) {
            if (model.modelType.equalsIgnoreCase(modelType)) {
                System.out.println("- " + model.modelName + " (Function: " + model.modelFunction + ")");
            }
        }
    }

    public void displayHelp() {
        System.out.println("\n==============================================================================================================================================================================\n" +
                "Welcome to the Machine Learning Assistant Application! \n" +
                "This application is designed to support beginner machine learning practitioners with: \n" +
                "    - Basic Exploratory Data Analysis (EDA) \n" +
                "    - Data imputation for handling missing values \n" +
                "    - Machine Learning (ML) model recommendations \n" +
                "\n" +
                "Using the command line, you can load datasets, analyze their structure, clean missing values, and explore ML model options. \n" +
                "\n" +
                "MAIN FEATURES: \n" +
                "    1. Analyze Dataset: Load your dataset in CSV format, view rows and columns, and calculate summary statistics like mean and standard deviation. \n" +
                "    2. Impute Missing Values: Automatically fill missing numerical data using mean imputation and save the cleaned dataset as a new CSV file. \n" +
                "    3. Auto-select a Model: Based on the data loaded originally and other requirements, the app recommends suitable ML models from a library of popular algorithms. \n" +
                "    4. Explore Models: Learn about ML models, including their use cases, strengths, limitations, and sample Python code for implementation. \n" +
                "\n" +
                "GETTING STARTED: \n" +
                "    - Ensure your dataset is a properly formatted CSV file with a header row indicating column names. \n" +
                "    - Use 'Analyze Dataset' to load and explore your data. \n" +
                "    - Handle missing values using the 'Impute and Save' feature (optional). \n" +
                "    - For ML guidance, use 'Auto-select a Model' or explore available models in the 'Explore Models' menu. \n" +
                "\n" +
                "For additional support or detailed documentation, please contact technical support. \n" +
                "Copyright © 2024, Kamran Makarian, DE, USA. LinkedIn: https://www.linkedin.com/in/kamranmakarian/\n" +
                "==============================================================================================================================================================================\n");
    }

}