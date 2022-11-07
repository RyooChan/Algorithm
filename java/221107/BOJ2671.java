import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Pattern.matches("(100+1+|01)+" , br.readLine()) ? "SUBMARINE" : "NOISE");
    }
}
