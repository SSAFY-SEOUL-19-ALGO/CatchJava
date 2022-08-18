package week2_김영서;

import java.util.Arrays;

public class P42860_조이스틱 {
	public int solution(String name) {
		int answer = 0;
		int len = name.length();
		int go = len - 1;
		int[] arr = new int[len];
		// A=65 Z=90
		for (int i = 0; i < len; i++) {
			char n = name.charAt(i);
			// 반으로 나눠서 더 가까운 쪽으로 이동
			if (n > 77) {
				arr[i] = 90 - n + 1;
			} else {
				arr[i] = n - 65;
			}

			// 옆으로 이동 : 뒤로 돌아가는게 더 빠른지 확인
			// A가 뭉텅이로있을 때 계산. A의 앞쪽보다 뒷쪽이 짧으면 뒤부터 보고 돌아오는게 이득
			int index = i + 1;
			while (index < len && name.charAt(index) == 'A') {
				index++;
			}
			//앞으로 갈때
			go = (go< i * 2 + len-index) ? go :  i * 2 + len-index;

			//뒤로갈때
			go = (go < (len - index) * 2 + i) ? go : (len - index) * 2 + i;

		}
		// 값구하기
		for (int i : arr) {
			answer += i;
		}
		answer += go;

		return answer;

	}
}