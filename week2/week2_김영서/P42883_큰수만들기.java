package week2_김영서;

import java.util.Arrays;
import java.util.HashSet;

public class P42883_큰수만들기 {
	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		int index = 0;
		int max = 0;
		//순서대로 써야하기 때문에 가능한 가장 큰 애가 첫숫자가 되도록 만들기
		for (int i = 0; i < number.length() - k; i++) {
			max = 0;
			for (int j = index; j <= i + k; j++) {
				if (max < number.charAt(j) - '0') {
					max = number.charAt(j) - '0';
					index = j + 1;
				}
			}
			answer.append(max);
		}
		return answer.toString();
	}
	/*조합시간초과
	 * static int[] check;
	static boolean[] visited;
	static HashSet<Integer> set;
	
	static void comb(int[] arr, int k, int index, HashSet<Integer>set ) {
		if (k == 0) {
			System.out.println(set);
			return;
		}
		for (int i = index; i < 2; i++) {
			set.add(i);
			visited[i] = true;
			comb(arr, k-1,i + 1, set);
			set.remove(i);
		}
	}

	public String solution(String number, int k) {
		String answer = "";
		int len = number.length();
		int[] arr = new int[len];
		visited = new boolean[len];
		check = new int[len];
		set  = new HashSet<>();
		//실제 값?
		for (int i = 0; i < len; i++) {
			arr[i] = number.charAt(i) - '0';
		}
		
		//index 조합구하기?
		for (int i = 0; i < len; i++) {
			check[i]=i;
		}
		
		comb(check, k, 0,set);
		
		return answer;
	}
	 */
}
