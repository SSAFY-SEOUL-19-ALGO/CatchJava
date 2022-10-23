package week11.week11_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1062_가르침 {
	static int N, K, max;
	static String[] word;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = bf.readLine().split(" ");
		N = Integer.parseInt(s[0]); // 단어의 개수
		K = Integer.parseInt(s[1]); // 가르칠 단어
		
		word = new String[N];
		for (int i = 0; i < N; i++) {
			String s2 = bf.readLine();
			s2 =  s2.replace("anta", ""); // 모든 단어의 시작
			s2 =  s2.replace("tica", ""); // 모든 단어의 끝
			word[i] = s2;
		} // 입력완료
		
		if(K<5) { // antic 모든 단어에 공통이 되는 단어 수보다 적으면 .. 못읽어
			System.out.println(0);
		} else if (K==26){ // 모든 알파벳의 개수를 충족하는 경우 .. 다읽어
			System.out.println(N);
		}
		
		visited = new boolean[26]; // 공통 단어 먼저 체크
		visited['a'-'a'] = true;
		visited['n'-'a'] = true;
		visited['t'-'a'] = true;
		visited['i'-'a'] = true;
		visited['c'-'a'] = true;
		
		max = Integer.MIN_VALUE; // 배울 수 있는 최대 단어
		dfs(0,0);
		System.out.println(max);
	}

	private static void dfs(int start, int len) {
		if(len==K-5) {
			int cnt = 0;  // 뽑은 알파벳으로 읽을 수 있는 단어
			for (int i = 0; i < N; i++) { // N 개의 단어를 모두 돌며
				boolean read = true;
				for (int j = 0; j < word[i].length(); j++) {
					if(!visited[word[i].charAt(j)-'a']) {
						read = false;
						break;
					}
				}
				if(read) cnt++; // 읽을 수 있는 단어라면 세어준다
			}
			max = Math.max(max,cnt); // 읽을 수 있는 최대의 경우를 저장
			return;
		}
		
		for (int i = start; i < 26; i++) { // 알파벳 개수를 돌며
			if(visited[i]==false) {
				visited[i] = true;
				
				dfs(i, len+1);
				visited[i] = false;
			}
		}
	}

}
