package week4.week4_김영서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10819_차이를최대로 {
	static int num;
	static int[] numlist;
	static int[] changeOrder;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;

	static void dfs(int start) {
		if (start == num) {
			int sum = 0;
			System.out.println(Arrays.toString(changeOrder));
			for (int i = 0; i < changeOrder.length - 1; i++) {
				sum += Math.abs(changeOrder[i] - changeOrder[i + 1]);
			}
			max = Math.max(sum, max);
			return;
		}

		for (int i = 0; i < num; i++) {
			if (!visited[i]) {
				System.out.println(Arrays.toString(changeOrder));
				visited[i] = true;
				changeOrder[start] = numlist[i];
				dfs(start + 1);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 차의 합이 가장 크게
		// 조합구해서 각각의 합 구하기 -> 가장 클 때 return -> dfs로 순서 바꾸면서 풀기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		numlist = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		visited = new boolean[num];
		changeOrder = new int[num];
		dfs(0);
		System.out.println(max);
	}
}
