package week2_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

// 크루스칼 알고리즘으로 풀기 
public class 섬_연결하기 {

	static int[] parent;

	static int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2])); // 가중치로 정렬 -> 최소 신장 트리 
        
        parent = new int[costs.length + 1];
        // set 만들기 
        for (int i = 0; i < costs.length; i++) {
        	parent[i] = i;
        }
        
        // 낮은 비용부터 크루스칼 알고리즘 진행 
        for (int i = 0; i < costs.length; i++) {
        	// 사이클이 존재하지 않을 경우에만 간선을 선택한다. 
        	if (find(costs[i][0]) != find(costs[i][1])) { // 부모가 같지 않을 경우 
        		union(costs[i][0], costs[i][1]);
            	answer += costs[i][2];
        	}
        }

        return answer;
    }
    
    static void union(int a, int b) { // 부모가 누구인지 확인하고 부모가 더 큰 쪽에 붙기 
    	a = find(a);
    	b = find(b);
    	
    	if (a > b) {
    		parent[a] = b;
    	} else {
    		parent[b] = a;
    	}
    }
    
    static int find(int x) { // 부모가 누구인지 확인 
    	if (parent[x] == x) return x;
    	else return find(parent[x]);
    }
    
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = sc.nextInt();
		int[][] costs = new int[(n - 1) * n / 2][3];
		
		for (int i = 0; i < 5; i++) {
			String[] s = br.readLine().split(" ");
			costs[i][0] = Integer.parseInt(s[0]);
			costs[i][1] = Integer.parseInt(s[1]);
			costs[i][2] = Integer.parseInt(s[2]);
 		}
		System.out.println(solution(n, costs));
	}

}
