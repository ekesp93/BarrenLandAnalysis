import java.util.Scanner;

public class BarrenLandAnalysis {

    public static void main(String[] args) {
        // Initialize scanner and main logic class
        Scanner scanner = new Scanner(System.in);
        AreaFinder areaFinder = new AreaFinder();

        // Get input
        System.out.println("Input barren land coordinates: ");
        String input = scanner.nextLine();

        // Get and print output
        System.out.println("Fertile land areas: ");
        System.out.println(areaFinder.findFertileLandArea(Utils.convertInputToIntegerList(input)));
    }
}
