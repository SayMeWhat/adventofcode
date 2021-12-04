package day1.exo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayOneExoTwo {

    public static void main() throws IOException {
        File file = new File("C:\\Advent Of Code 2021\\JAVA\\Day 1\\exo2\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        List<Integer> inputValues = new ArrayList();

        while ((st = br.readLine()) != null) {
            // We add all values in the order's list
            inputValues.add(Integer.valueOf(st));
        }

        int nbIncrease = 0;
        int startSlide = 0;
        int endSlide = startSlide + 2;
        int max = inputValues.size();
        int slideOne = 0;
        int slideTwo = 0;

        boolean shouldContinue = true;

        var nextStartSlide = 0;

        while (shouldContinue) {
            for (int i = startSlide; i <= endSlide; i++) {

                if (i == max || i + 1 == max) {
                    shouldContinue = false;
                    break;
                }

                slideOne += inputValues.get(i);
                slideTwo += inputValues.get(i + 1);
                nextStartSlide = i-1;
            }

            if(shouldContinue){
                nbIncrease += slideTwo > slideOne ? 1 : 0;
                slideOne = 0;
                slideTwo = 0;
                startSlide = nextStartSlide;
                endSlide = nextStartSlide + 2;
            }
        }

        System.out.println("reponse : " + nbIncrease);
    }
}
