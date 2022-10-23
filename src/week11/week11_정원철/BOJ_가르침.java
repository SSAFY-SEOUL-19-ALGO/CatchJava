package week11.week11_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_가르침 {
	static int N, K;
	static int max = 0;
	static boolean visited[] = new boolean[26];
	static String[] wordList;
	


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[]=br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		K = Integer.parseInt(st[1]);
		wordList = new String[N];
		
		// 5개 미만은 아웃 고정이 5개임
		if(K<5) {
			System.out.println("0");
			return;
		}
		
		// 알파벳 26이면 다읽기 가능
		if(K==26) {
			System.out.println(N);
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			wordList[i] = str.substring(4, str.length()-4);
		}
		
		// 5개는 무조건 포함
		K -= 5;
		
		// 고정 다섯개 알파벳 방문 체크
		visited['a' - 97] = true;
		visited['n' - 97] = true;
		visited['t' - 97] = true;
		visited['i' - 97] = true;
		visited['c' - 97] = true;
		

		dfs(0, 0);
		System.out.println(max);
	}
	
	public static void dfs(int start, int cnt) {

		if(cnt == K) {
			int num = 0;
			for(int i=0; i<wordList.length; i++) {
				boolean chk = true;
				for(int j=0; j<wordList[i].length(); j++) {
					
				
					if(!visited[wordList[i].charAt(j) - 97]) {
						chk = false;
						break;
					}
				}
				if(chk)
					num ++;
			}
			max = Math.max(max, num);
			return;
		}
		

		for(int i=start; i<26; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1);
				visited[i] = false;
			}
		}
	}

}
