import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B20115_에너지드링크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		double[] drink = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		Arrays.sort(drink);
		// System.out.println(Arrays.toString(drink));
		double sum = 0;
		// drink[n-1];
	
		for (int i = n - 1; i >= 0; i--) {
			if (i == n - 1) {
				sum += drink[i];
			} else {
				sum += drink[i] / 2;
			}
//			System.out.println(" ?"+drink[i]);
//			System.out.println(sum);
		}
		System.out.println(sum);
	}
}
