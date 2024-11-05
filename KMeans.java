import java.util.ArrayList;
import java.util.List;

public class KMeans {
    private int k;
    private List<Point> points;
    private List<Point> centroids;
    private List<List<Point>> clusters;

    public KMeans(int k, List<Point> points) {
        this.k = k;
        this.points = points;
        this.centroids = new ArrayList<>();
        this.clusters = new ArrayList<>();
    }

    public void setInitialCentroids(List<Point> initialCentroids) {
        this.centroids = initialCentroids;
    }

    public void run(int maxIterations) {
        for (int i = 0; i < maxIterations; i++) {
            System.out.println("Iteration " + (i + 1) + ":");

            List<List<Point>> previousClusters = new ArrayList<>(clusters);

            assignPointsToClusters();

            displayClusters();

            List<Point> newCentroids = calculateNewCentroids();

            if (clusters.equals(previousClusters)) {
                System.out.println("Les clusters n'ont pas changé, l'algorithme s'arrête.");
                break;
            }

            centroids = newCentroids;
            System.out.println("Nouveaux Centroides : " + centroids + "\n");
        }
    }

    private void assignPointsToClusters() {
        clusters.clear();
        for (int i = 0; i < k; i++) {
            clusters.add(new ArrayList<>());
        }

        for (Point point : points) {
            int closestCentroidIndex = getClosestCentroidIndex(point);
            clusters.get(closestCentroidIndex).add(point);
        }
    }

    private int getClosestCentroidIndex(Point point) {
        int closestIndex = 0;
        double minDistance = point.distance(centroids.get(0));
        
        for (int i = 1; i < centroids.size(); i++) {
            double distance = point.distance(centroids.get(i));
            if (distance < minDistance) {
                minDistance = distance;
                closestIndex = i;
            }
        }
        
        return closestIndex;
    }

    private List<Point> calculateNewCentroids() {
        List<Point> newCentroids = new ArrayList<>();

        for (List<Point> cluster : clusters) {
            double sumX = 0;
            double sumY = 0;
            for (Point point : cluster) {
                sumX += point.getX();
                sumY += point.getY();
            }
            double avgX = cluster.size() > 0 ? sumX / cluster.size() : 0;
            double avgY = cluster.size() > 0 ? sumY / cluster.size() : 0;
            newCentroids.add(new Point(avgX, avgY,"Centroids"));
        }

        return newCentroids;
    }

    private void displayClusters() {
        for (int i = 0; i < clusters.size(); i++) {
            System.out.println("Cluster " + (i + 1) + ": " + clusters.get(i));
        }
    }

    public List<Point> getCentroids() {
        return centroids;
    }

    public List<List<Point>> getClusters() {
        return clusters;
    }
}
