package week3_박윤환;

public class P43162_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] parent = new int[n];  // 각 노드의 부모노드를 기록할 배열

        for(int i=0; i<n; i++) {
            parent[i] = i;  // 초기 부모노드는 자기자신으로 초기화
        }

        for(int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {    // 무향그래프 이므로 절반만 탐색
                if (computers[i][j] == 1) {  // 두 컴퓨터가 연결되어 있으면
                    int tmp = parent[j];    // 값이 for문 반복 중에 바뀔수 있으므로 임시변수에 저장
                    for (int k=0; k<n; k++) {
                        if (parent[k] == tmp) {    // j와 부모가 같은 모든 노드를
                            parent[k] = parent[i];  // i의 부모로 변경
                        }
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(parent[i] == i) {    // 부모가 자기 자신인 노드 개수 = 집합 개수
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P43162_네트워크 sol = new P43162_네트워크();
        int[][] computers = {
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {1, 0, 1, 1}};

        System.out.println(sol.solution(4, computers));
    }
}
