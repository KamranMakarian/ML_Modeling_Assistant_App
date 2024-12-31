package org.example.model;

public class KMeans extends ClusteringModel {

    public KMeans() {
        super("KMeans");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "KMeans is an unsupervised clustering algorithm that partitions data into k clusters" +
                " based on feature similarity. It is fast and works well for spherical clusters" +
                " but struggles with noise, outliers, and non-spherical clusters.\n" +
                "\n" +
                "Example Code:\n" +
                "# Import necessary libraries\n" +
                "from sklearn.cluster import KMeans\n" +
                "from sklearn.datasets import make_blobs\n" +
                "import matplotlib.pyplot as plt\n" +
                "\n" +
                "# Generate sample data\n" +
                "X, _ = make_blobs(n_samples=300, centers=4, cluster_std=0.6, random_state=42)\n" +
                "\n" +
                "# Apply KMeans clustering\n" +
                "kmeans = KMeans(n_clusters=4, random_state=42)\n" +
                "labels = kmeans.fit_predict(X)\n" +
                "\n" +
                "# Plot the clustering result\n" +
                "plt.scatter(X[:, 0], X[:, 1], c=labels, cmap='viridis', s=50)\n" +
                "plt.scatter(kmeans.cluster_centers_[:, 0], kmeans.cluster_centers_[:, 1], s=200, c='red', label='Centroids')\n" +
                "plt.title(\"KMeans Clustering\")\n" +
                "plt.xlabel(\"Feature 1\")\n" +
                "plt.ylabel(\"Feature 2\")\n" +
                "plt.legend()\n" +
                "plt.show()\n";
    }
}