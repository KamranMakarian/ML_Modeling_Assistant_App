package org.example.model;

public class DBSCAN extends ClusteringModel {

    public DBSCAN() {
        super("DBSCAN (Density-Based Spatial Clustering)");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "DBSCAN (Density-Based Spatial Clustering of Applications with Noise) is an unsupervised algorithm " +
                "that groups points based on density and identifies noise. It works well for non-linear clusters " +
                "and noisy data but requires tuning parameters like eps and min_samples and struggles with high-dimensional data.\n" +
                "\n" +
                "Code Example:\n" +
                "# Import necessary libraries\n" +
                "from sklearn.cluster import DBSCAN\n" +
                "import numpy as np\n" +
                "import matplotlib.pyplot as plt\n" +
                "from sklearn.datasets import make_moons\n" +
                "\n" +
                "# Generate sample data (moons dataset for visualization)\n" +
                "X, _ = make_moons(n_samples=300, noise=0.05, random_state=42)\n" +
                "\n" +
                "# Fit DBSCAN with chosen parameters\n" +
                "dbscan = DBSCAN(eps=0.2, min_samples=5)\n" +
                "labels = dbscan.fit_predict(X)\n" +
                "\n" +
                "# Plot the clustering result\n" +
                "plt.scatter(X[:, 0], X[:, 1], c=labels, cmap='viridis', s=50)\n" +
                "plt.title(\"DBSCAN Clustering\")\n" +
                "plt.xlabel(\"Feature 1\")\n" +
                "plt.ylabel(\"Feature 2\")\n" +
                "plt.show()\n";
    }

}
