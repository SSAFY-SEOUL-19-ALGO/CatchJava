package week2.week2_박건우;

import java.util.Arrays;
import java.util.Comparator;

public class P42861 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
}

class Solution_P42861 {
	public int findParent(int[] parent, int node) {
		if(parent[node] == node)
			return node;
		return findParent(parent, parent[node]);
	}
	
	public void uf(int[] parent, int node1, int node2) {	//union_find
		int p1 = findParent(parent, node1);
		int p2 = findParent(parent, node2);
		
		if(p1 < p2)
			parent[p2] = p1;
		else
			parent[p1] = p2;
	}
	
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        
        for(int i = 0; i < n; i++) {
        	parent[i] = i;
        }
        Arrays.sort(costs, new Comparator<int[]>() {
        	public int compare(int[] o1, int[] o2) {
    			return o1[2] - o2[2];
    		}
        });
        for(int i = 0; i < costs.length; i++) {
        	if(findParent(parent, costs[i][0]) != findParent(parent, costs[i][1])) {
        		answer += costs[i][2];
        		uf(parent, costs[i][0], costs[i][1]);
        	}
        }
        return answer;
    }
}