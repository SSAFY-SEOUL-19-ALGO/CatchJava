package week4_김영서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P25328_문자열집합조합하기 {
	static int k;
	static String X, Y, Z;
	static HashMap<String, Integer> map;

	static void comb(String str, int N, int cnt, int index, char[] path) {
		if (cnt == k) {
			String key = new String(path);

			if (map.containsKey(key)) {
				int val = map.get(key);
				map.put(key, val + 1);
			} else {
				map.put(key, 1);
			}
			return;
		}

		for (int i = index; i < N; i++) {
			path[cnt] = str.charAt(i);
			comb(str, N, cnt + 1, i + 1, path);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		X = br.readLine();
		Y = br.readLine();
		Z = br.readLine();
		k = Integer.parseInt(br.readLine());

		map = new HashMap<>();

		comb(X, X.length(), 0, 0, new char[k]);
		comb(Y, Y.length(), 0, 0, new char[k]);
		comb(Z, Z.length(), 0, 0, new char[k]);

		ArrayList<String> result = new ArrayList<>();
		for (String key : map.keySet()) {
			if (map.get(key) > 1) {
				result.add(key);
			}
		}

		Collections.sort(result);
		if (result.size() == 0) {
			sb.append(-1);
		} else {
			for (int i = 0; i < result.size(); i++) {
				sb.append(result.get(i)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
