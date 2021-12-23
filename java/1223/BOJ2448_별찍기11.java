import java.util.*;

public class Main {
	
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
        
		int n = sc.nextInt();
		
		String stars[] = new String[n];
		stars[0] = "  *  ";
		stars[1] = " * * ";
		stars[2] = "*****";
		
		for (int k = 1; 3 * (int)Math.pow(2, k) <= n; ++k) {
			draw(k, stars);
		}
		
		for (int i = 0; i < n; ++i) {
			System.out.println(stars[i]);
		}
	}
	
	private static void draw(int k, String stars[]) {
		int bottom = 3 * (int)Math.pow(2, k);
		int middle = bottom / 2;
		
		for (int i = middle; i < bottom; ++i) {
			stars[i] = stars[i - middle] + " " + stars[i -middle];
		}
		
		String space = "";
		while (space.length() < middle) {
			space += " ";
		}
		for (int i = 0; i < middle; ++i) {
			stars[i] = space + stars[i] + space;
		}
	}
}
