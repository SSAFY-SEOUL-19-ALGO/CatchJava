package week5_김영서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P21275_폰호석만 {
	static String xa, xb, x, max;
	static long a, b;
	static int count;
	static int[] arr;

	static String find(int a, String s) {
		int tmp = 0;
		double result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int t = arr[s.charAt(i)];
			result += Math.pow(a, tmp) * t;
			tmp++;
		}
		return String.valueOf(result);
	}

	//입력받은 값보다 작은 경우는 진법을 확인할 필요가 없다. 클 경우만 true리턴
	static boolean check(int a, String s) {
		for (int i = 0; i < s.length(); i++) {
			if (a <= arr[s.charAt(i)]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();

		xa = str[0];
		xb = str[1];
		// x는 0이상, 2^63미만. max는 string값으로 지정
		max = String.valueOf(Math.pow(2, 63));

		System.out.println(xa);
		arr = new int[200];

		// a와 b는 2이상 36이하
		for (int i = 0; i < 9; i++) {
			arr[i + '1'] = i + 1;
		}
		for (int i = 0; i < 26; i++) {
			arr['a' + i] = i + 10;
		}

		System.out.println(Arrays.toString(arr));
		for (int i = 1; i <= 36; i++) {
			for (int j = 1; j <= 26; j++) {
				// a와 b는 같을 수 없다.
				if (i == j)
					continue;
				// xa와 xb보다 작은 진법은 확인할 필요가 없다.
				if (check(i, xa) && check(j, xb)) {
					// 입력받은 두 값과 i,j를 비교해 같은 값이 나왔을 경우
					if (find(i, xa).equals(find(j, xb))) {
						//문제에서 주어진 최대값보다 크면 continue;
						if (find(i, xa).compareTo(max) >= 1)
							continue;
						count++;
						x = find(i, xa);
						a = i;
						b = j;
					}
				}
			}
		} // for문

		// 해당하는 값을 찾지 못했을 경우
		if (count == 0) {
			sb.append("Impposible");
		} else if (count == 1) {
			String answer = x.substring(0, x.length() - 2);
			sb.append(answer).append(" ").append(a).append(" ").append(b);
		} else {
			sb.append("Multiple");
		}
		System.out.println(sb);
	}// main
}
