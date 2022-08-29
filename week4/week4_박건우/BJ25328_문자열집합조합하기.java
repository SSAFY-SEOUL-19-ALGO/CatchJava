package week4_박건우;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BJ25328_문자열집합조합하기 {
	static String resStr = "";
	static ArrayList<char[]> ipt = new ArrayList<>();
	static ArrayList<String> res = new ArrayList<>();
	static ArrayList<String> resTemp = new ArrayList<>();
	public static void comb(char[] arr, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					resStr  = resStr.concat(String.valueOf(arr[i]));
				}
			}
			res.add(resStr);
			resStr = "";
			return;
		}

		for(int i = start; i < n; i++) {
			visited[i] = true;
			comb(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new  StringBuilder();
		
		
		
		for(int i = 0; i < 3; i++) {
			ipt.add(br.readLine().toCharArray());
		}
		int k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 3; i++) {
			boolean[] visited = new boolean[ipt.get(i).length];
			comb(ipt.get(i), visited, 0, ipt.get(i).length, k);
		}
		
		Collections.sort(res);
		String t = res.remove(0);
		int dCnt = 1;
		for(int i = 0; i < res.size(); i++) {
			if(t.equals(res.get(i)) && dCnt == 1) {
				resTemp.add(res.get(i));
				dCnt++;
			} else if(t.equals(res.get(i)) == false) {
				dCnt = 1;
				t = res.get(i);
			}
		}
		
		if(resTemp.size() == 0) {
			bw.write(-1 + "\n");
		} else {
			for(int i = 0; i < resTemp.size(); i++) {
				bw.write(resTemp.get(i) + "\n");
			}
		}
		
		bw.flush();
	}
}
