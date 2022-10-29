package week12.week12_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P11559_PuyoPuyo {
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static char[][] map;
	static boolean[][] visited;
	static List<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String s = bf.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		} // 입력 완료
		
		int cnt = 0; // 4개 이상 뿌요가 붙어있는 경우를 찾자 => 연쇄 횟수
		while (true) {
			boolean check = true;
			visited = new boolean[12][6];

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') { // 뿌요라면 ?!
						list = new ArrayList<>();
						bfs(map[i][j], i, j); // 뿌요랑 좌표 담아 탐색으로 보내자

						if (list.size() >= 4) { // 뿌요가 4개 이상 이어져있다면 터트리자
							check = false; // 연쇄 후 더 탐색해야한다
							for (int k = 0; k < list.size(); k++) {
								map[list.get(k).x][list.get(k).y] = '.'; // 터뜨려 !
							}
						}
					}
				}
			}
			if(check) break;
			down(); // 중력 작용
			cnt++;
		}
		System.out.println(cnt); // 연쇄가 몇번 일어났는지
	} // main end

	private static void bfs(char c, int x, int y) { // 뿌요를 탐색
		Queue<Node> q = new LinkedList<>();
		list.add(new Node(x, y));
		q.offer(new Node(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx >=0 && ny >=0 && nx <12 && ny <6 && !visited[nx][ny] && map[nx][ny] ==c) { // 방문한 적 없고 같은 뿌요라면
					visited[nx][ny] = true;
					list.add(new Node(nx, ny));
					q.offer(new Node(nx, ny));
				}
			}
		}
	}
	
	private static void down() { // 중력 작용 받는 뿌요 정렬해주기
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j > 0; j--) {
				if(map[j][i]=='.') { // 만약 터진 자리라면
					for (int k = j-1; k >=0; k--) {
						if(map[k][i] != '.') { // 뿌요가 있으면
							map[j][i] = map[k][i];
							map[k][i] = '.';
							break;
						}
					}
				}
			}
		}
	}

}
