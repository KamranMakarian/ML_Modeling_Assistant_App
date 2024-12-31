package org.example.model;

public class PCA extends DimensionalityReductionModel {

    public PCA() {
        super("PCA");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "PCA is an unsupervised dimensionality reduction technique that transforms " +
                "high-dimensional data into a smaller number of orthogonal components while retaining " +
                "the maximum variance. It is ideal for visualization and improving computational " +
                "efficiency but may lose interpretability of features.\n" +
                "\n" +
                "Example Code:\n" +
                "# Import necessary libraries\n" +
                "from sklearn.decomposition import PCA\n" +
                "from sklearn.datasets import load_iris\n" +
                "import matplotlib.pyplot as plt\n" +
                "\n" +
                "# Load the Iris dataset\n" +
                "data = load_iris()\n" +
                "X = data.data\n" +
                "y = data.target\n" +
                "\n" +
                "# Apply PCA to reduce dimensions to 2 for visualization\n" +
                "pca = PCA(n_components=2)\n" +
                "X_pca = pca.fit_transform(X)\n" +
                "\n" +
                "# Plot the PCA result\n" +
                "plt.scatter(X_pca[:, 0], X_pca[:, 1], c=y, cmap='viridis', s=50)\n" +
                "plt.title(\"PCA: Dimensionality Reduction\")\n" +
                "plt.xlabel(\"Principal Component 1\")\n" +
                "plt.ylabel(\"Principal Component 2\")\n" +
                "plt.colorbar(label=\"Target\")\n" +
                "plt.show()\n";
    }
}
