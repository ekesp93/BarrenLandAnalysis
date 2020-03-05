import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static List<List<Integer>> convertInputToIntegerList(String input) {
        // Separate the input string into a string for each rectangle
        String editedInput = input.substring(1, input.length() - 1);
        editedInput = editedInput.replace("\"", "");
        String[] arrayByRectangle = editedInput.split(",");

        // Convert each rectangle into an Integer list and insert that into a larger list of rectangles
        List<List<Integer>> barrenLandCoordinateList = new ArrayList<List<Integer>>();
        for (String rectangle : arrayByRectangle) {
            List<Integer> integerList = new ArrayList<Integer>();
            for (String number : rectangle.split(" ")) {
                integerList.add(Integer.parseInt(number));
            }
            barrenLandCoordinateList.add(integerList);
        }

        return barrenLandCoordinateList;
    }

    public static String convertToOutputString(List<Integer> outputList) {
        StringBuilder outputString = new StringBuilder();
        Collections.sort(outputList);
        for (Integer number : outputList) {
            outputString.append(number)
                        .append(" ");
        }
        return outputString.toString();
    }
}
