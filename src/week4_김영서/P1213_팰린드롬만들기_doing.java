package week4_김영서;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P1213_팰린드롬만들기_doing {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		HashMap<Character, Integer> map = new HashMap<>();
		Stack<Character> stack = new Stack();
		Queue<Character> queue = new LinkedList<>();
		char check = ' ';
		boolean flag = false;
		// 해시맵에 알파벳을 키로, 갯수를 값으로 넣기
		for (int i = 0; i < name.length(); i++) {
			if (map.containsKey(name.charAt(i))) {
				map.replace(name.charAt(i), map.get(name.charAt(i)) + 1);
			} else {
				map.put(name.charAt(i), 1);
			}
		}
		// 키를 기준으로 sort!
		Object[] mapkey = map.keySet().toArray();
		Arrays.sort(mapkey);

		for (char a : map.keySet()) {
			if (map.get(a) % 2 == 0) {
				for (int i = 0; i < map.get(a) / 2; i++) {
					// 짝수개의 알파벳은 각각 큐와 스택에 넣기
					queue.add(a);
					stack.add(a);
				}
			} else {
				if (flag) {
					// 개수가 홀수인 알파벳이 2개 이상이면 못 만든다! 다 지우고 빠져나오기
					stack.clear();
					queue.clear();
					break;
				}
				// 홀수인 알파벳은 가운데에 들어가야 함. check에 따로 저장하기
				check = a;
				flag = true;
				// 3개 이상의 홀수일 경우 sort된 순서에 맞게 큐와 스택에 넣기
				for (int i = 0; i < map.get(a) / 2; i++) {
					queue.add(a);
					stack.add(a);
				}
			}
		}

		// 팰린드롬을 만들수 없는 경우
		if (stack.isEmpty()) {
			sb.append("I'm Sorry Hansoo");
		} else {
			// 큐에 들어있는 알파벳 다 꺼내서 stringbuilder에 붙이기
			while (!queue.isEmpty()) {
				sb.append(queue.poll());
			}
			// 홀수의 경우 check에 담았던 알파벳을 가운데 붙여넣기
			if (flag)
				sb.append(check);
			// 스택에 들어있는 알파벳 꺼내서 stringbuilder에 붙이기
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
		}

		System.out.println(sb);
	}// main
}// class



//