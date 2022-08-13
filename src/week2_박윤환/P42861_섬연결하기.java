package week2_박윤환;

import java.util.Arrays;

public class P42861_섬연결하기 {
    // 섬의 루트섬을 찾는 메소드
    static int findParent(int[] parent, int x) {
        if(parent[x] == x) {
            return x;
        } else {
            return findParent(parent, parent[x]);
        }
    }

    // 크루스칼 알고리즘 사용
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];  // 자신의 루트섬을 저장하는 배열

        for(int i=0; i<n; i++) {
            parent[i] = i;  // 초기 루트섬은 자기 자신으로 초기화
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);  // 다리의 길이 기준 오름차순으로 정렬

        // costs 탐색
        for (int[] cost : costs) {
            // 두 섬의 루트섬을 찾는다
            int a = findParent(parent, cost[0]);
            int b = findParent(parent, cost[1]);

            // 현재 섬들의 루트섬이 다를 경우 연결 가능
            // 루트섬이 서로 같을 경우 다리를 연결하면 사이클이 형성되므로 연결 X
            if (a != b) {
                // 두 섬의 루트섬을 같게 한다.
                parent[b] = a;
                // 다리 길이를 더한다
                answer += cost[2];
            }
        }

        return answer;
    }

}
