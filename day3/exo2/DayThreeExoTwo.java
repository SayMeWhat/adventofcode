package day3.exo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class DayThreeExoTwo {

    public void main() throws IOException {
        File file = new File("C:\\Advent Of Code 2021\\JAVA\\day3\\exo1\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        List<String> numbersBitOxygen = new ArrayList<>();
        List<String> numbersBitCo2 = new ArrayList<>();

        int positionOfBitNumber = 0;

        int oxygen = 0;
        int co2 = 0;

        while ((st = br.readLine()) != null) {
            numbersBitOxygen.add(st);
            numbersBitCo2.add(st);
        }

        while (numbersBitOxygen.size() != 1) {
            int bitMostCommon = mostCommon(positionOfBitNumber, numbersBitOxygen, true);

            numbersBitOxygen = deleteBitNumber(positionOfBitNumber, bitMostCommon, numbersBitOxygen);

            positionOfBitNumber++;
        }

        oxygen = Integer.parseInt(numbersBitOxygen.get(0), 2);

        positionOfBitNumber = 0;

        while (numbersBitCo2.size() != 1) {
            int bitMostCommon = mostCommon(positionOfBitNumber, numbersBitCo2, false);

            numbersBitCo2 = deleteBitNumber(positionOfBitNumber, bitMostCommon, numbersBitCo2);

            positionOfBitNumber++;
        }

        co2 = Integer.parseInt(numbersBitCo2.get(0), 2);

        System.out.println("oxygen : " + oxygen + " * co2 : " + co2 + " = " + oxygen * co2);
    }

    public int mostCommon(int positionOfBit, List<String> bitNumber, boolean most) {
        // bit 1
        int x = 0;
        // bit 0
        int y = 0;

        for (String bitN : bitNumber) {
            if (Character.getNumericValue(bitN.toCharArray()[positionOfBit]) == 1) {
                x++;
            } else {
                y++;
            }
        }

        if (most) {
            if (x == y) {
                return 1;
            }
            return x > y ? 1 : 0;
        } else {
            if (x == y) {
                return 0;
            }
            return x > y ? 0 : 1;
        }

    }

    public List<String> deleteBitNumber(int positionOfBit, int mostBitCommon, List<String> bitNumber) {
        bitNumber.removeIf(x -> Character.getNumericValue(x.toCharArray()[positionOfBit]) != mostBitCommon);

        return bitNumber;
    }
}
