package week6.week6_채예진;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 여행경로 {
    static List<String> list;
    static boolean[] visited;

    static void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            list.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) { // 출발지가 인자값일 경우 + 아직 방문하지 않았을 경우
                visited[i] = true; // 선택할경우
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                visited[i] = false; // 선택 안 할 경우
            }
        }
    }

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        list = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0); // 시작해야하는 것, 시작점

        list.sort(Comparator.naturalOrder());
        return list.get(0).split(" ");
    }

    public static void main(String[] args) {
        solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
    }
}