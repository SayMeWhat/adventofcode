package day2.exo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DayTwoExoOne {

    public static void main() throws IOException {
        File file = new File("C:\\Advent Of Code 2021\\JAVA\\day2\\exo1\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        int xPos = 0;
        int yPos = 0;

        while ((st = br.readLine()) != null) {
            String[] movements = st.split(" ");

            switch (movements[0]) {
                case "forward":
                    xPos += Integer.valueOf(movements[1]);
                    break;
                case "down":
                    yPos += Integer.valueOf(movements[1]);
                    break;
                case "up":
                    yPos -= Integer.valueOf(movements[1]);
                    break;
            }
            
        }
        System.out.println("yPos : " + yPos + " xPos : " + xPos );
        System.out.println("multiply : " + xPos*yPos );
    }

}
