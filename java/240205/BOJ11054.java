import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] increasing = new int[N];
        for (int i = 0; i < N; i++) {
            increasing[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && increasing[i] < increasing[j] + 1) {
                    increasing[i] = increasing[j] + 1;
                }
            }
        }

        int[] decreasing = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            decreasing[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i] && decreasing[i] < decreasing[j] + 1) {
                    decreasing[i] = decreasing[j] + 1;
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            int length = increasing[i] + decreasing[i] - 1;
            maxLength = Math.max(maxLength, length);
        }

        System.out.println(maxLength);
    }
}
