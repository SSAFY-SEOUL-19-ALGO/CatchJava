import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {

	static ArrayList<String> answer;
	static Boolean[] visited;

	public String[] solution(String[][] tickets) {
		answer = new ArrayList<>();
		visited = new Boolean[tickets.length + 1];
		Arrays.fill(visited, false);
		String ans = "ICN ";
		dfs("ICN", tickets, ans, 1);
		Collections.sort(answer);
		return answer.get(0).split(" ");
	}

	private static void dfs(String from, String[][] tickets, String ans, int idx) {
		if (idx == tickets.length + 1) {
			answer.add(ans);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && from.equals(tickets[i][0])) {
				visited[i] = true;
				dfs(tickets[i][1], tickets, ans + tickets[i][1] + " ", idx + 1);
				visited[i] = false;
			}
		}
	}
}