import java.io.*;
import java.util.*;

public class CrimeFreq {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = readCSV();
        System.out.println(map);
        writeObjects(map);
    }

    private static void writeObjects(Map<String, Integer> map) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("CrimeFreq.dat")));

            
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }


    private static Map<String, Integer> readCSV() throws IOException {
        Map<String, Integer> map = new HashMap<>();
        BufferedReader input = null;
        try  {
            input = new BufferedReader(new FileReader("Crimes.csv"));
            input.readLine();
            String line;
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                String crimeDesc = items[5];
                Integer num = map.get(crimeDesc);
               /* if (num == null) {
                    map.put(crimeDesc, 1);
                } else {
                    map.put(crimeDesc,num + 1);
                } */
                map.put(crimeDesc, num == null ? 1 : num + 1);
            }
            return map;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}
