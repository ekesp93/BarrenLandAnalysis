import java.util.Scanner;

public class BarrenLandAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AreaFinder areaFinder = new AreaFinder();

        System.out.println("Input barren land coordinates: ");
        String input = scanner.nextLine();

        System.out.println("Fertile land areas: ");
        System.out.println(areaFinder.findFertileLandArea(Utils.convertInputToIntegerList(input)));
    }
}
