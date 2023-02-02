import java.io.*;
import java.util.*;
public class DistrictCrimes {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: DistrictCrimes <filename>");
            System.exit(1);
        }
        String filename = args[0];
        String district = readDistrictFromKeyboard();
        String outputFilename = "CrimesDistrict" + district + ".txt";
        List<String> list = readCSV(district, filename);
        Collections.sort(list);
        writeListToFile(list, outputFilename);
    }

    private static void writeListToFile(List<String> list, String outputFilename) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(outputFilename));
            /* for (String line : list) {
                out.println(line);
            } */
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                out.println(it.next());
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static List<String> readCSV(String selectDistrict, String filename) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(filename));
            input.readLine();
            String line;
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                String crimeDesc = items[5];
                String dateTime = items[0];
                String district = items[2];
                if (district.equals(selectDistrict)) {
                    list.add(crimeDesc + "," + dateTime);
                }
            }
            return list;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    private static String readDistrictFromKeyboard() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter district number:");
        String district = input.nextLine();
        input.close();
        return district;
    }
}
