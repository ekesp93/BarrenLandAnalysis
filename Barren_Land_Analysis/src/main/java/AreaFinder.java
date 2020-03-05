import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AreaFinder {

    private static final int MAX_WIDTH = 400;
    private static final int MAX_LENGTH = 600;

    private boolean[][] landVisited = new boolean[MAX_WIDTH][MAX_LENGTH];

    /**
     * Iterates through the land and finds the area of each piece of fertile land
     * @param barrenLandCoordinates
     * @return fertileLandArea
     */
    public String findFertileLandArea(List<List<Integer>> barrenLandCoordinates) {
        List<Integer> fertileLandAreaList = new ArrayList<Integer>();

        for (int x = 0; x < MAX_WIDTH; x++) {
            for (int y = 0; y < MAX_LENGTH; y++) {
                if (!landVisited[x][y]) {
                    int fertileArea = countFertileLandArea(barrenLandCoordinates, x, y);
                    if (fertileArea != 0) {
                        fertileLandAreaList.add(fertileArea);
                    }
                }
            }
        }

        return Utils.convertToOutputString(fertileLandAreaList);
    }

    /**
     * Finds the area of a single piece of fertile land
     * @param barrenLandCoordinates
     * @param x
     * @param y
     * @return area of fertile land
     */
    private Integer countFertileLandArea(List<List<Integer>> barrenLandCoordinates, int x, int y) {
        int area = 0;

        Stack<UnitCoordinates> unitStack = new Stack<UnitCoordinates>();
        unitStack.push(new UnitCoordinates(x, y));

        while (!unitStack.isEmpty()) {
            UnitCoordinates unit = unitStack.pop();

            if (isUnitFertileAndUnvisited(barrenLandCoordinates, unit)) {
                area++;
                int xCoordinate = unit.getX();
                int yCoordinate = unit.getY();

                // The following if statements check each unit around the current unit
                if (yCoordinate - 1 >= 0 && !landVisited[xCoordinate][yCoordinate - 1]) {
                    unitStack.push(new UnitCoordinates(xCoordinate, yCoordinate - 1));
                }
                if (yCoordinate + 1 < MAX_LENGTH && !landVisited[xCoordinate][yCoordinate + 1]) {
                    unitStack.push(new UnitCoordinates(xCoordinate, yCoordinate + 1));
                }
                if (xCoordinate - 1 >= 0 && !landVisited[xCoordinate - 1][yCoordinate]) {
                    unitStack.push(new UnitCoordinates(xCoordinate - 1, yCoordinate));
                }
                if (xCoordinate + 1 < MAX_WIDTH && !landVisited[xCoordinate + 1][yCoordinate]) {
                    unitStack.push(new UnitCoordinates(xCoordinate + 1, yCoordinate));
                }
            }
        }

        return area;
    }

    private boolean isUnitFertileAndUnvisited(List<List<Integer>> barrenLandCoordinates, UnitCoordinates unit) {
        int x = unit.getX();
        int y = unit.getY();

        // Check if land is visited, and if it isn't, mark it as visited, as it has now been visited
        if (landVisited[x][y]) {
            return false;
        }
        landVisited[x][y] = true;

        // Check if land is barren
        for (List<Integer> barrenLand : barrenLandCoordinates) {
            if (x >= barrenLand.get(0) && x <= barrenLand.get(2) && y >= barrenLand.get(1) && y <= barrenLand.get(3)) {
                return false;
            }
        }

        return true;
    }
}
