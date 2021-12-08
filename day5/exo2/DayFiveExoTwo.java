package day5.exo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayFiveExoTwo {

    public void main() throws IOException {
        File file = new File("C:\\Advent Of Code 2021\\JAVA\\day5\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        List<Coordinate> coordinatesNoDiagonal = new ArrayList<>();
        List<Coordinate> coordinatesDiagonal = new ArrayList<>();

        int xMaxSize = 0;
        int yMaxSize = 0;

        while ((st = br.readLine()) != null) {

            var coordinateSplit = st.split(" -> ");
            var xyOne = coordinateSplit[0].split(",");
            var xyTwo = coordinateSplit[1].split(",");

            if (Integer.parseInt(xyOne[0]) > xMaxSize) {
                xMaxSize = Integer.parseInt(xyOne[0]);
            }

            if (Integer.parseInt(xyTwo[0]) > xMaxSize) {
                xMaxSize = Integer.parseInt(xyTwo[0]);
            }

            if (Integer.parseInt(xyOne[1]) > yMaxSize) {
                yMaxSize = Integer.parseInt(xyOne[1]);
            }
            if (Integer.parseInt(xyTwo[1]) > yMaxSize) {
                yMaxSize = Integer.parseInt(xyTwo[1]);
            }

            if (Integer.parseInt(xyOne[0]) != Integer.parseInt(xyTwo[0])
                    && Integer.parseInt(xyOne[1]) != Integer.parseInt(xyTwo[1])) {
                coordinatesDiagonal
                        .add(new Coordinate(Arrays.asList(Integer.parseInt(xyOne[0]), Integer.parseInt(xyOne[1])),
                                Arrays.asList(Integer.parseInt(xyTwo[0]), Integer.parseInt(xyTwo[1]))));
                continue;
            }

            coordinatesNoDiagonal
                    .add(new Coordinate(Arrays.asList(Integer.parseInt(xyOne[0]), Integer.parseInt(xyOne[1])),
                            Arrays.asList(Integer.parseInt(xyTwo[0]), Integer.parseInt(xyTwo[1]))));

        }

        int[][] grid = new int[xMaxSize + 1][yMaxSize + 1];
        populateGrid(grid, coordinatesNoDiagonal, coordinatesDiagonal);

    }

    public int[][] populateGrid(int[][] grid, List<Coordinate> coordinatesNoDiagonals,
            List<Coordinate> coordinatesDiagonal) {

        int xStart = 0;
        int xEnd = 0;

        int yStart = 0;
        int yEnd = 0;

        // Populate no diagonal
        for (Coordinate coordinate : coordinatesNoDiagonals) {
            xEnd = coordinate.xyOne.get(0) > coordinate.xyTwo.get(0) ? coordinate.xyOne.get(0)
                    : coordinate.xyTwo.get(0);
            xStart = coordinate.xyOne.get(0) > coordinate.xyTwo.get(0) ? coordinate.xyTwo.get(0)
                    : coordinate.xyOne.get(0);

            yEnd = coordinate.xyOne.get(1) > coordinate.xyTwo.get(1) ? coordinate.xyOne.get(1)
                    : coordinate.xyTwo.get(1);
            yStart = coordinate.xyOne.get(1) > coordinate.xyTwo.get(1) ? coordinate.xyTwo.get(1)
                    : coordinate.xyOne.get(1);

            for (int x = xStart; x <= xEnd; x++) {
                for (int y = yStart; y <= yEnd; y++) {
                    grid[x][y]++;
                }
            }
        }

        xStart = 0;
        xEnd = 0;

        yStart = 0;
        yEnd = 0;

        // Populate diagonal
        for (Coordinate coordinate : coordinatesDiagonal) {
            List<Integer> coordX = new ArrayList<>();
            List<Integer> coordY = new ArrayList<>();

            xStart = coordinate.xyOne.get(0);
            xEnd = coordinate.xyTwo.get(0);
            if (coordinate.xyOne.get(0) > coordinate.xyTwo.get(0)) {
                while (xStart > xEnd - 1) {
                    coordX.add(xStart);
                    xStart--;
                }
            }
            if (coordinate.xyOne.get(0) < coordinate.xyTwo.get(0)) {
                while (xStart < xEnd + 1) {
                    coordX.add(xStart);
                    xStart++;
                }
            }

            yStart = coordinate.xyOne.get(1);
            yEnd = coordinate.xyTwo.get(1);
            if (coordinate.xyOne.get(1) > coordinate.xyTwo.get(1)) {
                while (yStart > yEnd - 1) {
                    coordY.add(yStart);
                    yStart--;
                }
            }
            if (coordinate.xyOne.get(1) < coordinate.xyTwo.get(1)) {
                while (yStart < yEnd + 1) {
                    coordY.add(yStart);
                    yStart++;
                }
            }

            for (int i = 0; i < coordX.size(); i++) {
                grid[coordX.get(i)][coordY.get(i)]++;
            }
        }

        int howMany = 0;

        for (int x = grid.length; x < grid.length; x++) {
            for (int y = yStart; y <= yEnd; y++) {
                grid[x][y]++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 1) {
                    howMany++;
                }
            }
        }
        System.out.println(howMany);
        return null;
    }

    public class Coordinate {
        List<Integer> xyOne;
        List<Integer> xyTwo;

        public Coordinate(List<Integer> xyOne, List<Integer> xyTwo) {
            this.xyOne = xyOne;
            this.xyTwo = xyTwo;
        }

        public List<Integer> getXyOne() {
            return xyOne;
        }

        public List<Integer> getXyTwo() {
            return xyTwo;
        }

        public void setXyOne(List<Integer> xyOne) {
            this.xyOne = xyOne;
        }

        public void setXyTwo(List<Integer> xyTwo) {
            this.xyTwo = xyTwo;
        }
    }

    public class Grid {

        int[][] grid;

        public Grid(int[][] grid) {
            this.grid = grid;
        }
    }

}
