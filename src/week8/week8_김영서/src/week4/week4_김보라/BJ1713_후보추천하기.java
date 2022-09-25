package week4.week4_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ1713_후보추천하기 {
	
	/*
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> q = new ArrayList<>();
		int check = q.size();
		
		String s[] = br.readLine().split(" ");
		
		for(int i = 0; i<M; i++) {
			int n = Integer.parseInt(s[i]);
			
			if(q.size()==N) {
				if(q.contains(n)) {
					q.remove(q.);
					check=q.size();
					q.add(n);
				}else {
					q.remove(0);
					q.add(n);
					check--;
				}
			}else {
				if(!q.contains(n))
					q.add(check++,n);
			}
			System.out.println(q);
		}//for 종료
		
		
		Collections.sort(q);
		System.out.println(q);
		
	}
	

}*/
	
	/*
	 * 3
3
1 1 1
출력1 1 1
답 1 
예외케이스
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		
		ArrayList<int[]> q = new ArrayList<int[]>();
		
		String s[] = br.readLine().split(" ");
		
		for(int i = 0; i<t; i++) {
			int n = Integer.parseInt(s[i]);
			int[] tmp = q.get(0);
			for(int j = 0; j<q.size(); j++) {
				if(q.get(j)[0]==n) {
					q.get(j)[1]+=1;
					break;
				}
				if(tmp[1]>q.get(j)[1]) {
					tmp=q.get(j);
				}
			}
			
			if(q.size()==N) {
				boolean check = false;
				;
				for(int j = 0; j<N; j++) {
					if(q.get(j)[0]==n) {
						q.get(j)[1]+=1;
						check=true;
					}else {
						if(tmp[1]>q.get(j)[1]) {
							tmp=q.get(j);
						}
					}
				}
				if(check==false) {
					q.remove(tmp);
					q.add(new int[] {n, 1});
				}
			}else {
				
			}
			
		}//for 종료
		
		Collections.sort(q,(o1,o2)->(o1[0]-o2[0]));
		
		for(int k = 0; k<q.size(); k++) {
			System.out.print(q.get(k)[0]+" ");
		}System.out.println();
	}
}
	/*
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		
		ArrayList<int[]> q = new ArrayList<int[]>();
		
		String s[] = br.readLine().split(" ");
		
		for(int i = 0; i<t; i++) {
			int n = Integer.parseInt(s[i]);
//			System.out.println(n+" "+q.contains(n));
			
			if(q.size()==N) {
				boolean check = false;
				int[] tmp = q.get(0);
				for(int j = 0; j<N; j++) {
					if(q.get(j)[0]==n) {
						q.get(j)[1]+=1;
						check=true;
					}else {
						if(tmp[1]>q.get(j)[1]) {
							tmp=q.get(j);
						}
					}
				}
				if(check==false) {
					q.remove(tmp);
					q.add(new int[] {n, 1});
				}
			}else {
				boolean contain = false;
				for(int j = 0; j<q.size(); j++) {
					if(q.get(j)[0]==n) {
						contain=true;
						break;
					}
				}
				if(!contain)
					q.add(new int[] {n, 1});
			}
			
		}//for 종료
		
		Collections.sort(q,(o1,o2)->(o1[0]-o2[0]));
		
		for(int k = 0; k<q.size(); k++) {
			System.out.print(q.get(k)[0]+" ");
		}System.out.println();
	}
}*/
	
/*
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		int check = q.size();
		
		String s[] = br.readLine().split(" ");
		
		for(int i = 0; i<M; i++) {
			int n = Integer.parseInt(s[i]);
			
			if(q.size()==N) {
				if(q.contains(n)) {
					check=i;
					q.remove(n);
					q.add(n);
				}else {
					q.poll();
					q.add(n);
				}
			}else {
				if(!q.contains(n))
					q.add(n);
			}
		}//for 종료
		
		
		PriorityQueue<Integer> answer = new PriorityQueue<>();
		while(!q.isEmpty()) {
			answer.add(q.poll());
		}
		while(!answer.isEmpty()){
			System.out.print(answer.poll()+" ");
		}System.out.println();
		
	}
	

}*/


/*
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int N = Integer.parseInt(br.readLine());
	int t = Integer.parseInt(br.readLine());
	
	Queue<int[]> q = new LinkedList<>();
	
	String s[] = br.readLine().split(" ");
	
	for(int i = 0; i<t; i++) {
		int n = Integer.parseInt(s[i]);
//		System.out.println(n+" "+q.contains(n));
		
		if(q.size()==N) {
			boolean check = false;
			int num = q.peek()[0];
			int cnt = q.peek()[1];
			for(int j = 0; j<n; j++) {
				int[] tmp = q.poll();
				if(tmp[0]==n) {
					q.add(new int[] {n,tmp[1]+1});
					check=true;
				}else {
					q.add(tmp);
					if(cnt>tmp[1]) {
						num = tmp[0];
						cnt = tmp[1];
					}
				}
			}
			if(check==false) {
				q.remove(new int[] {num, cnt});
			}
		}else {
			q.add(new int[] {n, 1});
		}
	}//for 종료
	
	System.out.println(q.toString());
	
}


}
*/