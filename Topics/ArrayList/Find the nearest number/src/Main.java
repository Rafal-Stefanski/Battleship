import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        for (String s : line.split(" ")) {
            list.add(Integer.valueOf(s));
        }
        int n = scanner.nextInt();
        Collections.sort(list);
//        System.out.println(list);
        Integer delta = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            if (Math.abs(i - n) < delta) {
                result.clear();
                result.add(i);
                delta = Math.abs(i - n);
            } else if (Math.abs(i - n) == delta) {
                result.add(i);
            }
        }
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
}
