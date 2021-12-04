package day1.exo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DayOneExoOne {

    public static void main() throws IOException {
        File file = new File("C:\\Advent Of Code 2021\\JAVA\\Day 1\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        var firstIteration = 0;
        String n1 = "";
        String n2 = "";
        var nbIncrease = 0;

        while ((st = br.readLine()) != null) {

            if (firstIteration == 0) {
                n1 = st;
                firstIteration++;
                continue;
            } else {
                n2 = st;
                if (Integer.valueOf(n2) > Integer.valueOf(n1)) {
                    nbIncrease++;
                }
                n1 = n2;
            }
        }
        System.out.println("reponse : " + nbIncrease);
    }
}
