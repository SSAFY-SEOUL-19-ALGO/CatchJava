package week2_강수지;

import java.util.*;

class P42861_섬연결하기 { // 크루스칼 알고리즘
    static int[] parent;

    public static int getParent(int[] parent, int x){ // 노드의 부모의 값을 확인하기 위해
        if(parent[x] == x){
            return x;
        }
        return getParent(parent, parent[x]);
    }
    
    public static boolean cycle(int[] parent, int a, int b){ // 사이클의 여부를 확인하기 위해
        a = getParent(parent, a);
        b = getParent(parent, b);
        
        if(a==b){
            return false; // 사이클이 만들어지므로 간선끼리 연결하면 안된다
        }else{
            return true;
        }
    }

    public static void union(int[] parent, int a, int b){ // 정점을 합치는 경우
        // 더 작은 값의 부모로 갱신해준다 ( 간선 가중치 합이 최소여야하니까 )
        a = getParent(parent, a);
        b = getParent(parent, b);

        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }

    }

    public int solution(int n, int[][] costs) {

        int answer = 0;
        // 간선의 가중치를 기준으로 오름차순 정렬 > 사이클이 없는 가중치의 합이 최소값인 최소 신장 트리 를 완성하자
        Arrays.sort(costs, (int[] o1,int[] o2) -> o1[2] - o2[2]);

        parent = new int[n]; // 노드의 부모 노드
        for(int i=0;i<n;i++){
            parent[i] = i; // 초기에는 자기 자신을 가리킨다
        }
        
        for(int i=0;i<costs.length;i++){
            if(cycle(parent, costs[i][0], costs[i][1])){
                // 사이클을 만들지 않는 경우
                answer += costs[i][2]; // 가중치 합을 저장
                union(parent, costs[i][0], costs[i][1]); // 부모를 갱신해준다
            }
        }
        return answer;
    }
}