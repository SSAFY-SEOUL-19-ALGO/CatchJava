package week1_김영서;
import java.util.*;

public class P12906_같은숫자는싫어 {
	public int[] solution(int[] arr) {
		int[] answer = {};

		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (s.isEmpty()) {
				s.add(arr[i]);
			} else if (s.peek() != arr[i]) {
				s.add(arr[i]);
			}
		}

		answer = new int[s.size()];
		for (int i = s.size() - 1; i >= 0; i--) {
			answer[i] = s.pop();
		}
		return answer;
	}
}
