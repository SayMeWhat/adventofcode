package day6.exo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaySixExoOne {

    public void main() throws IOException {
        File file = new File("C:\\Advent Of Code 2021\\JAVA\\day6\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        HashMap<BigInteger, BigInteger> freq = new HashMap();
        freq.put(BigInteger.valueOf(0), BigInteger.valueOf(0));
        freq.put(BigInteger.valueOf(1), BigInteger.valueOf(0));
        freq.put(BigInteger.valueOf(2), BigInteger.valueOf(0));
        freq.put(BigInteger.valueOf(3), BigInteger.valueOf(0));
        freq.put(BigInteger.valueOf(4), BigInteger.valueOf(0));
        freq.put(BigInteger.valueOf(5), BigInteger.valueOf(0));
        freq.put(BigInteger.valueOf(6), BigInteger.valueOf(0));
        freq.put(BigInteger.valueOf(7), BigInteger.valueOf(0));
        freq.put(BigInteger.valueOf(8), BigInteger.valueOf(0));

        while ((st = br.readLine()) != null) {
            String[] bench = st.split(",");
            for (String lanternFish : bench) {
                freq.put(BigInteger.valueOf(Integer.parseInt(lanternFish)),
                        freq.get(BigInteger.valueOf(Long.parseLong(lanternFish))).add(BigInteger.ONE));
            }
        }

        int nbDays = 0;
        List<Integer> newLantersfishs = new ArrayList();

        while (nbDays < 256) {

            /*
             * for (int i = 0; i < benchOfLanterfishs.size(); i++) {
             * 
             * if (benchOfLanterfishs.get(i) == 0) {
             * benchOfLanterfishs.set(i, 6);
             * newLantersfishs.add(8);
             * continue;
             * }
             * int insideTimer = benchOfLanterfishs.get(i);
             * benchOfLanterfishs.set(i, insideTimer - 1);
             * }
             * benchOfLanterfishs.addAll(newLantersfishs);
             * newLantersfishs.clear();
             */
            BigInteger newFish = BigInteger.ZERO;

            for (HashMap.Entry<BigInteger, BigInteger> element : freq.entrySet()) {
                BigInteger key = element.getKey();
                BigInteger value = element.getValue();

                if (key == BigInteger.valueOf(0)) {
                    if (value != BigInteger.valueOf(0)) {
                        newFish = value;
                    }
                    element.setValue(freq.get(key.add(BigInteger.ONE)));
                } else if (key == BigInteger.valueOf(8)) {
                    continue;
                } else {
                    element.setValue(freq.get(key.add(BigInteger.ONE)));
                }
            }

            freq.put(BigInteger.valueOf(8), newFish);
            freq.put(BigInteger.valueOf(6), freq.get(BigInteger.valueOf(6)).add(newFish));
            newFish = BigInteger.ZERO;
            nbDays++;
        }

        BigInteger response = BigInteger.ZERO;

        for (HashMap.Entry<BigInteger, BigInteger> element : freq.entrySet()) {
            response = response.add(element.getValue());
        }

        System.out.println(response);
    }

}
