package week3_김보라;

import java.util.HashSet;
import java.util.Set;

public class P43162_네트워크 {

	static int n = 3;
	static int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
	
	public static void main(String[] args) {
		int[] net = new int[n];
		
		for(int i = 0; i<n; i++) {
			net[i]=i;
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				if(computers[i][j]==1) {
					int z = net[j];
					for(int k = 0; k<n; k++) {
						if(net[k]==z) {
							net[k]=net[i];
						}
					}
				}
			}
		}//net set end
		
		Set<Integer> cnt = new HashSet<>();
		for(int i = 0; i<n; i++) {
			cnt.add(net[i]);
		}
		System.out.println(cnt.size());
		
	}//main 종료

}
