package day2.exo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DayTwoExoTwo {
    
    public static void main() throws IOException {
        File file = new File("C:\\Advent Of Code 2021\\JAVA\\day2\\exo1\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        int xPos = 0;
        int aim = 0;
        int depth = 0;

        while ((st = br.readLine()) != null) {
            String[] movements = st.split(" ");

            switch (movements[0]) {
                case "forward":
                    xPos += Integer.valueOf(movements[1]);
                    if(aim != 0){
                        depth += aim * Integer.valueOf(movements[1]);
                    }
                    break;
                case "down":
                    aim += Integer.valueOf(movements[1]);
                    break;
                case "up":
                    aim -= Integer.valueOf(movements[1]);
                    break;
            }
            
        }
        System.out.println("aim : " + aim + " xPos : " + xPos + " depth : " + depth );
        System.out.println("multiply : " + xPos*depth );
    }
}
