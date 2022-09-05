package week2_김영서;

import java.util.Arrays;
import java.util.Comparator;

public class P42861_섬연결하기 {
	static int[]parent;
	//부모노드 찾기
	static int find(int p) {
		if(parent[p] == p) return p;
		return parent[p] = find(parent[p]);
	}
	
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        //cost를 비용 기준으로 오름차순 정렬
        Arrays.sort(costs,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
        });
        //스스로를 부모로 초기화
        for(int i=0;i<n;i++) {
        	parent[i]=i;
        }
        
       // int tmpParent=0;
        for(int[]a:costs) {
        	//시작의 부모노드와 끝나는 부모노드가 같으면 건너뛰기
        	if( find(a[0]) == find(a[1])) {
        		continue;
        	}
        	//다르면 cost더하기
        	answer+= a[2];
        	//부모노드를 새롭게 설정
        	parent[find(a[1])] =find(a[0]);
        
        }
        
        
        return answer;
    }
}