package week6.week6_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P16234_인구이동 {
	static int N, L, R;
	static int[][] A;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static ArrayList<Node> list; // 인구 이동이 필요한 노드
	
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		N = Integer.parseInt(s[0]); // N*N 땅
		L = Integer.parseInt(s[1]); // L 명 이상 R 명 이하
		R = Integer.parseInt(s[2]);

		A = new int[N][N]; // r 행 c 열
		for (int i = 0; i < N; i++) {
			String[] s1 = bf.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(s1[j]);
			}
		} // 입력 완료

		System.out.println(count());
	} // main end
	
	private static int count() { // 더이상 인구이동이 일어나지 않을때 까지 반복
		int cnt = 0;
		while (true) {
			boolean flag = false;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						int sum = bfs(i,j); // 열릴 수 있는 국경선 확인
						if (list.size()>1) {
							move(sum); // 열린 국경선 내 노드들의 인구 변경
							flag = true;
						}
					}
				}
			}
			if(!flag) return cnt;
			cnt++;
		}
	}

	private static void move(int sum) { // 인구 이동
		int avg = sum / list.size();
		for (Node n : list) {
			A[n.x][n.y] = avg;
		}
	}

	private static int bfs(int x, int y) { // 인구 이동할 총 인구 수 반환
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();
		
		q.offer(new Node(x,y));
		list.add(new Node(x,y));
		visited[x][y] = true;
		
		int sum =  A[x][y];
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
					int dif = Math.abs(A[cur.x][cur.y] - A[nx][ny]);
					if(L<=dif && dif<=R) { // L 이상 R 이하 인 경우
						q.offer(new Node(nx, ny));
						list.add(new Node(nx, ny));
						
						sum += A[nx][ny];
						visited[nx][ny] = true;
					}
				}
			}
		}
		return sum;
	} // bfs end
}

