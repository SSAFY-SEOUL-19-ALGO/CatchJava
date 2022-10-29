package week11.week11_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BJ1700_멀티탭스케줄링 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		if(N>=K) {
			System.out.println(0);
			return;
		}
		
		int[] prime = new int[K+1];
		int[] check = new int[K+1];
		
		String st[] = br.readLine().split(" ");
		for(int k = 0; k<K; k++) {
			prime[k]=Integer.parseInt(st[k]);
			check[Integer.parseInt(st[k])]++;
		}
		
//		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		
		List<Integer> pq = new ArrayList<>();
		
		int answer = 0;
		for(int n = 0; n<K; n++) {
			//System.out.println(pq.toString()+" "+answer);
			int tmp = Integer.parseInt(st[n]);
			boolean include = false;
			for(int i = 0; i<pq.size(); i++) {
				if(pq.get(i)==tmp) {
					include=true;
					check[tmp]--;
					break;
				}
			}
			if(include) continue;
			
			if(pq.size()<N) {
				pq.add(tmp);
				check[tmp]--;
				continue;
			}
			
			int unplug=0, idx = 0;
			for(int j=0; j<N; j++) {
				int count = 101;
				for(int k=n+1; k<K; k++) {
					if(pq.get(j) == prime[k]) {
						count = k;
						break;
					}
				}
				if(count > idx) {
					unplug = j;
					idx = count;
				}
			}
			answer++;
			pq.remove(unplug);
			pq.add(tmp);
			
//			int idx=-1, max=-1;
//			for(int i = 0; i<N; i++) {
//				int temp = 0;
//				boolean contain = false;
//				for(int j = i+1; j<K; j++) {
//					if(pq.get(i)==prime[j]) {
//						contain = true;
//						temp=j;
//						break;
//					}
//				}
//				if(!contain) {
//					temp=K-i-1;
//				}
//				if(tmp>max) {
//					idx=i;
//					max=temp;
//				}
//			}
////			int idx = -1;
////			for(int i = 0; i<N; i++) {
////				if(check[pq.get(i)]==0) {
////					idx=pq.get(i);
////				}
////			}
//			pq.remove(idx);
////			pq.remove(pq.get(idx));
//			pq.add(tmp);
//			check[tmp]--;
//			answer++;
			
//			if(pq.size()<N) {
//				pq.add(new int[] {tmp,prime[tmp]});
//			}else {
//				Collections.sort(pq,(o1,o2)->o1[1]-o2[1]);
//				pq.remove(0);
//				
//				answer++;
//				
//				pq.add(new int[] {tmp,prime[tmp]});
//			}
		}
		
		
//		for(int n = 0; n<N; n++) {
//			int tmp = Integer.parseInt(st[n]);
//			boolean include = false;
//			for(int i = 0; i<N; i++) {
//				if(pq.get(i)[0]==tmp) {
//					include=true;
//					break;
//				}
//			}
//			prime[tmp]-=1;
//			if(include) continue;
//			
//			pq.add(new int[] {tmp,prime[tmp]});
//		}
//		int answer = 0;
//		for(int n = N; n<K; n++) {
//			int tmp = Integer.parseInt(st[n]);
//			boolean include = false;
//			for(int i = 0; i<N; i++) {
//				if(pq.get(i)[0]==tmp) {
//					include=true;
//					break;
//				}
//			}
//			prime[tmp]-=1;
//			if(include) continue;
//			Collections.sort(pq,(o1,o2)->o1[1]-o2[1]);
//			pq.remove(0);
//			answer++;
//			
//			pq.add(new int[] {tmp,prime[tmp]});
//			
//		}
		System.out.println(answer);
		
	}

}


/*
 3 14
1 4 3 2 5 4 3 2 5 3 4 2 3 4
*/
