package week6.week6_박윤환;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P43164_여행경로 {

    static int N;
    static String[] picked;
    static String[][] tickets;
    static boolean[] used;
    static List<String[]> list;

    static void dfs(int idx) {
        if(idx == N) {  // 티켓의 개수만큼 골랐다면
            list.add(Arrays.copyOf(picked, N+1));   // 완성된 루트를 리스트에 저장
            return;
        }

        for(int i=0; i<N; i++) {
            if(picked[idx].equals(tickets[i][0]) && !used[i]) {  // 출발지가 같고 사용하지 않은 티켓이면
                used[i] = true;  // 티켓을 사용처리 하고
                picked[idx+1] = tickets[i][1];  // 목적지를 루트에 기록
                dfs(idx+1); // 다음 루트로 dfs 시작
                used[i] = false;    // 티켓 사용처리 취소
            }
        }
    }

    public String[] solution(String[][] tickets) {
        N = tickets.length;
        this.tickets = tickets;
        picked = new String[N + 1];   // 가능한 경우들을 고를 배열
        used = new boolean[N];   // 티켓의 사용여부를 기록할 배열
        list = new ArrayList<>();   // 가능한 경우를 저장할 리스트

        // 티켓의 목적지들 기준으로 오름차순 정렬 -> 그래야 리스트에 사전순으로 저장
        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));
        picked[0] = "ICN";  // 처음은 무조건 "ICN"
        dfs(0); // dfs 시작

        return list.get(0); // 리스트의 가장 앞이 사전순으로 앞서는 방문
    }

    public static void main(String[] args) {
        P43164_여행경로 sol = new P43164_여행경로();
        String[][] s1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] s2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[][] s3 = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}};
        String[][] s4 = {{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}};
        System.out.println(Arrays.toString(sol.solution(s1)));
        System.out.println(Arrays.toString(sol.solution(s2)));
        System.out.println(Arrays.toString(sol.solution(s3)));
        System.out.println(Arrays.toString(sol.solution(s4)));
    }
}