package week11.week11_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 가르침 {

	static int N, K, max;
	static boolean[] alpha;
	static String[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		alpha = new boolean[26];
		alpha['a' - 'a'] = true;
		alpha['c' - 'a'] = true; 
		alpha['n' - 'a'] = true; 
		alpha['i' - 'a'] = true; 
		alpha['t' - 'a'] = true; 
		
		arr = new String[N];
		for (int n = 0; n < N; n++) { // 입력받기 
			arr[n] = br.readLine();
		}
		
		if (K < 5) { // 가르쳐야하는 것도 못 가르침 
			System.out.println(0);
			return;
		} else if (K == 26) { // 모든 알파벳 다 읽을 수 있음 
			System.out.println(N);
			return;
		}
		
		subset(0, 0);
		System.out.println(max);
	}

	private static void subset(int idx, int cnt) {
		if (cnt == K - 5) { // 이미 true 한 거 제외 
			int answer = 0;
			for (String str: arr) { // 문장 수 
				boolean read = true;
				for (int c = 0; c < str.length(); c++) {
					if (!alpha[str.charAt(c) - 'a']) {
						read = false;
						break;
					}
				}
				if (read) answer++;
			}
			max = max > answer? max: answer;
		}
		
		for (int i = idx; i < 26; i++) {
			if (!alpha[i]) {
				alpha[i] = true;
				subset(i, cnt + 1);
				alpha[i] = false;
			}
		}
	}

}
