package week4_박건우;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ10819_차이를최대로 {
	static boolean[] visited;
	static int N;
	static int ans = 0;
	static int[] arr;
	
	public static void dfs(int cnt, int bf, int sum) {
		if(cnt == N) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(cnt + 1, arr[i], cnt == 0? 0 : sum + Math.abs(bf-arr[i]));
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] ipt;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		ipt = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(ipt[i]);
		}
		
		dfs(0, 0, 0);
		bw.write(ans + "\n");
		bw.flush();
	}

}
