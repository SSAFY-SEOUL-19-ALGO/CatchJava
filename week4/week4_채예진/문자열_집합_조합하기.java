package week4_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 문자열_집합_조합하기 {
	
	static Map<String, Integer> hashMap = new HashMap<>();
	static String[] str;
	static int K;
	
	static void comb(String[] arr, int idx, int cnt, int start) { // 조합 만들기 
		if(cnt == K) { // 조합 끝났을 경우 
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < K; i++) {
				sb.append(str[i]);
			}
			if (hashMap.containsKey(sb.toString())) // hashMap을 사용하여, 기존의 값이 있으면 기존 개수 + 1 
				hashMap.put(sb.toString(), hashMap.get(sb.toString()) + 1);
			else hashMap.put(sb.toString(), 1); // 기존의 값이 없으면 1
			return;
		}

		for (int i = start; i < arr.length; i++) { // 선택지
			// 시도하는 수가 선택되었는지 판단 
			// 선택되지 않았다면 수를 사용
			str[cnt] = arr[i];
			// 다음 수 뽑으러 가기 
			comb(arr, idx, cnt + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] X = br.readLine().split("");
		String[] Y = br.readLine().split("");
		String[] Z = br.readLine().split("");

		K = Integer.parseInt(br.readLine());
		
		str = new String[X.length];
		comb(X, 0, 0, 0);
		str = new String[Y.length];
		comb(Y, 1, 0, 0);
		str = new String[Z.length];
		comb(Z, 2, 0, 0);
		
		// 배열 내부 확인하면서 내용 체크 
		List<String> list = new ArrayList<>();
		
		for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
			if(entry.getValue() >= 2) { // hashMap 안에 있는 값의 사이즈가 2 이상일 경우 
				list.add(entry.getKey());
			}
		}
		
		if (list.size() == 0) { // 아무것도 없으면 0 
			sb.append(-1);
		} else {
			Collections.sort(list); // 오름차순 정렬 
			
			for (String str: list) {
				sb.append(str + "\n");
			}
		}
		
		System.out.println(sb);
	}

}
