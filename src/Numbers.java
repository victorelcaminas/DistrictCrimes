import java.util.*;

public class Numbers {

    public static final int LOWER = 5;
    public static final int UPPER = 200;

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = getMap(LOWER, UPPER);
        System.out.println(map);
        int number = 0;
        while (number != -1) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter a number between 5 and 200 (-1 to finish):");
                number = input.nextInt();
                if (number != -1) {
                  /*  if (number < LOWER || number > UPPER) {
                        throw new InputMismatchException();
                    } */
                    if (map.get(number) == null) {
                        throw new InputMismatchException();
                    }
                    System.out.println(map.get(number));
                }
            } catch (InputMismatchException ex) {
                //System.out.println("Please enter a number between 5 and 200");
            }
        }

    }

    public static Map<Integer, List<Integer>> getMap(int lowerLimit,
                                                     int upperLimit) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int key = lowerLimit; key <= upperLimit; key++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= key; i++) {
                if (key % i == 0) {
                    list.add(i);
                }
            }
            map.put(key, list);
        }
        return map;
    }
}
