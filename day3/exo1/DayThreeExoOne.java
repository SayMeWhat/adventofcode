package day3.exo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayThreeExoOne {

    public static void main() throws IOException {
        File file = new File("C:\\Advent Of Code 2021\\JAVA\\day3\\exo1\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        Map<Integer, char[]> map = new HashMap<>();

        List<List<Integer>> allNumbers = new ArrayList<>();

        // Détermine si on passe pour la 1e fois pour init l'array
        boolean firstTime = true;

        int indexBitOfNumber = 0;

        while ((st = br.readLine()) != null) {
            char[] numbers = st.toCharArray();

            for (char bit : numbers) {

                if (firstTime) {
                    allNumbers.add(new ArrayList<>());
                    allNumbers.get(indexBitOfNumber).add(0);
                    allNumbers.get(indexBitOfNumber).add(0);
                    var bitFound = Character.getNumericValue(bit);
                    if (bitFound == 1) {
                        int oldValue = allNumbers.get(indexBitOfNumber).get(0);
                        allNumbers.get(indexBitOfNumber).set(0, oldValue + 1);
                    } else {
                        int oldValue = allNumbers.get(indexBitOfNumber).get(1);
                        allNumbers.get(indexBitOfNumber).set(1, oldValue + 1);
                    }
                } else {
                    var bitFound = Character.getNumericValue(bit);
                    if (bitFound == 1) {
                        int oldValue = allNumbers.get(indexBitOfNumber).get(0);
                        allNumbers.get(indexBitOfNumber).set(0, oldValue + 1);
                    } else {
                        int oldValue = allNumbers.get(indexBitOfNumber).get(1);
                        allNumbers.get(indexBitOfNumber).set(1, oldValue + 1);
                    }
                }

                if (indexBitOfNumber == 11) {
                    indexBitOfNumber = 0;
                    firstTime = false;
                } else {
                    indexBitOfNumber++;
                }
            }

        }
        List<String> gamma = new ArrayList<>();
        List<String> epsilon = new ArrayList<>();
        allNumbers.forEach((x -> {
            if (x.get(0) > x.get(1)) {
                gamma.add("1");
            } else {
                gamma.add("0");
            }
        }));

        allNumbers.forEach((x -> {
            if (x.get(0) > x.get(1)) {
                epsilon.add("0");
            } else {
                epsilon.add("1");
            }
        }));

        System.out.println(Integer.parseInt(String.join("", gamma), 2) * Integer.parseInt(String.join("", epsilon), 2));
    }
}
