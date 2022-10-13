package week10.week10_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 추월 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0; // 답 
		
		Map<String, Integer> map = new HashMap<>(); // 들어가는 차량 번호와 순서 
		
		int[] arr = new int[N]; // 나오는 차량 배열 
		
		for (int n = 0; n < N; n++) { // 들어가는 차량 입력 받기 
			String input = br.readLine();
			map.put(input, n);
		}
		
		for (int n = 0; n < N; n++) { // 나오는 차량을 순서대로 터널에 들어갔을 때 순서 저장 
			String input = br.readLine();
			arr[n] = map.get(input); // 추월했을 경우, 2번 배열에 4번이었던 차량 들어가고 이런 식. 
		}
		
		for (int i = 0; i < N; i++) { // 모든 차량 
			for (int j = i + 1; j < N; j++) { // 현재보다 뒤에 있는 차 
				if (arr[i] > arr[j]) { // 추월했을 경우 (뒷 차량이 숫자가 작아졌을 경우)
					answer++;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	/*
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		String[] save = new String[N];
		
		Set<String> set = new HashSet<>(); 
		for (int n = 0; n < N; n++) {
			save[n] = br.readLine();
		}
		
		int idx = 0;
		for (int n = 0; n < N; n++) {
			String input = br.readLine();
			if (!save[idx].equals(input)) {
				if (set.contains(input)) { // 이미 추월한 차라면 
					idx++;
				} else {
					set.add(input);
				}
			}
			idx++;
		}
		
		System.out.println(answer);
	}
	*/

}
