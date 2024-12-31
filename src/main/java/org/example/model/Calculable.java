package org.example.model;

import java.util.Map;

public interface Calculable {
    Map<String, Double> calculateMean();
    Map<String, Double> calculateStdDev();
}
