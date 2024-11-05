import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // Jeu de données principal
        List<Point> points = new ArrayList<>();
        points.add(new Point(5000, 0, "A1"));       // A1
        points.add(new Point(8500, 4700, "A2"));    // A2
        points.add(new Point(1000, 2000, "A3"));    // A3
        points.add(new Point(2000, 4000, "B1"));    // B1
        points.add(new Point(8900, 10000, "B2"));   // B2
        points.add(new Point(2400, 12000, "B3"));   // B3
        points.add(new Point(9000, 0, "C1"));       // C1
        points.add(new Point(2000, 20000, "C2"));   // C2

        // Test 1 : Différents nombres de clusters (k = 2, 3, 4)
        System.out.println("Test 1 : Nombre de clusters différents");
        for (int k = 2; k <= 4; k++) {
            System.out.println("Nombre de clusters (k) : " + k);
            KMeans kMeans = new KMeans(k, points);
            List<Point> initialCentroids = selectInitialCentroids(points, k);
            kMeans.setInitialCentroids(initialCentroids);
            kMeans.run(100);
            System.out.println();
        }

        // Test 2 : Position initiale des centroids différente
        System.out.println("Test 2 : Position initiale des centroids différente");
        int k = 3;
        KMeans kMeansDifferentCentroids = new KMeans(k, points);
        List<Point> initialCentroidsDifferent = new ArrayList<>();
        initialCentroidsDifferent.add(new Point(0, 0, "D1"));
        initialCentroidsDifferent.add(new Point(10000, 10000, "D2"));
        initialCentroidsDifferent.add(new Point(5000, 20000, "D3"));
        kMeansDifferentCentroids.setInitialCentroids(initialCentroidsDifferent);
        kMeansDifferentCentroids.run(100);

        // Test 3 : Ensemble de points de test plus dense
        System.out.println("Test 3 : Ensemble de points plus dense");
        List<Point> densePoints = new ArrayList<>();
        densePoints.add(new Point(100, 200, "E1"));
        densePoints.add(new Point(150, 300, "E2"));
        densePoints.add(new Point(200, 400, "E3"));
        densePoints.add(new Point(300, 500, "E4"));
        densePoints.add(new Point(350, 600, "E5"));
        densePoints.add(new Point(400, 700, "E6"));
        densePoints.add(new Point(500, 800, "E7"));
        densePoints.add(new Point(600, 900, "E8"));

        KMeans kMeansDense = new KMeans(k, densePoints);
        List<Point> initialCentroidsDense = selectInitialCentroids(densePoints, k);
        kMeansDense.setInitialCentroids(initialCentroidsDense);
        kMeansDense.run(100);
    }

    // Méthode pour sélectionner les centroids initiaux
    private static List<Point> selectInitialCentroids(List<Point> points, int k) {
        List<Point> centroids = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            centroids.add(points.get(i));
        }
        return centroids;
    }
}
