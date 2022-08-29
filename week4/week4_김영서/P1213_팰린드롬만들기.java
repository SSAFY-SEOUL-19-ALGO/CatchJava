package week4_김영서;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class P1213_팰린드롬만들기 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		Comparator<Character> comparator = (c1,c2)->c1.compareTo(c2);
		Map<Character, Integer> map = new TreeMap<>(comparator);
		Stack<Character> stack = new Stack();
		Queue<Character> queue = new LinkedList<>();
		int isOdd = 0;
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
		
		// 홀수인 CHAR가 2개 이상일 경우 실패
		for (char oddCheck : map.keySet()) {
			//System.out.println(oddCheck);
			if (map.get(oddCheck) % 2 == 1) {
				isOdd++;
			}
		}

		if (isOdd > 1) {
			sb.append("I'm Sorry Hansoo");
		} else {
			for (char a : map.keySet()) {
				if (map.get(a) % 2 == 0) {
					for (int i = 0; i < map.get(a) / 2; i++) {
						// 짝수개의 알파벳은 반으로 나눠서 각각 큐와 스택에 넣기
						queue.add(a);
						stack.add(a);
					}
				} else {
					// 홀수인 알파벳은 가운데에 들어가야 함. check에 따로 저장하기
					flag = true;
					check = a;
					// System.out.println(check);
					// 3개 이상의 홀수일 경우 sort된 순서에 맞게 큐와 스택에 넣기
					for (int i = 0; i < map.get(a) / 2; i++) {
						queue.add(a);
						stack.add(a);
					}
				}
			}
			// 큐에 들어있는 알파벳 다 꺼내서 stringbuilder에 붙이기
			while (!queue.isEmpty()) {
				sb.append(queue.poll());
			}
			// 홀수의 경우 check에 담았던 알파벳을 가운데 붙여넣기
			if (flag) sb.append(check);
			// 스택에 들어있는 알파벳 꺼내서 stringbuilder에 붙이기
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
		}

		System.out.println(sb);
	}// main
}// class
