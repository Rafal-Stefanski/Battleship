import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String input = reader.readLine().trim();
        StringTokenizer counter = new StringTokenizer(input);
        System.out.println(counter.countTokens());
        reader.close();
    }
}