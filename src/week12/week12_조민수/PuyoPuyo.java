package week12.week12_조민수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class PuyoPuyo {

	static char[][] board;
	static boolean[][] visit;
	static int boom;// 연쇄 횟수 boom
	static boolean change;// 이전에 변화가 있었는지 체크하는 변수 change
	static int[] dx = { 0, 1, -1, 0 };
	static int[] dy = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		// 1. 탐색 - 같은 색이 4개 이상 있는지? DFS vs BFS
		// 2. 4개 이상을 찾으면 터트리기
		// 3. 모두 터트린 후 내려오기 진행
		// 4. 터지는 게 없을 때 까지 1-3 반복
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new char[12][6];
		change = true;
		boom = 0;
		for (int i = 0; i < 12; i++) {
			String[] st = br.readLine().split("");
			for (int j = 0; j < 6; j++) {
				board[i][j] = st[j].charAt(0);
			}
		} // 입력 끝
		while (true) {// 무한루프
			bfs();
			if (change) {// 변화가 있었으면 연쇄카운트 추가
				boom++;
			} else {// 변화가 없었으면 연쇄 폭발 끝. 결과 출력후 종료
				System.out.println(boom);
				return;
			}
		}
		// 탐색 시작
	}

	private static void bfs() {
		// 전체탐색
		change = false;// false로 두고 변화가 있으면 true변경
		visit = new boolean[12][6];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (board[i][j] != '.' && !visit[i][j]) {// 블록이 있고 방문한적이 없는 블록이다
					isgroup(i, j);// 주변에 같은 블록이 4개이상인지 탐색
				}
			}
		}

		System.out.println("=======================bfsEND=======================");
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		// 탐색이 모두 끝나고 연쇄가 모두 끝나면 중력 작업
		down();
		System.out.println("=======================downEND=======================");
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	private static void isgroup(int i, int j) {
		ArrayDeque<int[]> bfsQ = new ArrayDeque<>();// 주변 사방탐색용 큐
		ArrayDeque<int[]> block = new ArrayDeque<>();// 블럭을 저장 ->4개 이상이 되면 저장된 모든 블록을 .으로 제거

		bfsQ.add(new int[] { i, j });
		block.add(new int[] { i, j });
		while (!bfsQ.isEmpty()) {
			int[] xy = bfsQ.poll();
			int x = xy[0];
			int y = xy[1];
			visit[x][y] = true;
			for (int d = 0; d < 4; d++) {
				if (0 <= x + dx[d] && x + dx[d] < 12 && 0 <= y + dy[d] && y + dy[d] < 6 && !visit[x + dx[d]][y + dy[d]]
						&& board[x][y] == board[x + dx[d]][y + dy[d]]) {// 이동하려는 위치가 범위 안의 값 +방문 X +현재 블록과 같은 종류
					visit[x + dx[d]][y + dy[d]] = true;
					bfsQ.add(new int[] { x + dx[d], y + dy[d] });
					block.add(new int[] { x + dx[d], y + dy[d] });

				}
			}
		} // while end
		if (block.size() >= 4) {// 같은 블록이 4개 이상 모였다 -> 저장된 모든 블록을 .로 초기화
			change = true;// 변화가 있었기때문에 change=true로 변경
			while (!block.isEmpty()) {
				int[] xy = block.poll();
				int x = xy[0];
				int y = xy[1];
				board[x][y] = '.';
			}

		}
	}

	private static void down() {
		// TODO Auto-generated method stub
		for (int i = 5; i >= 0; i--) {// 각 열마다
			for (int j = 11; j >= 0; j--) {// 각 행마다 탐색
				for (int k = 11; k > j; k--) {// 바닥부터 j행까지 빈공간이 있는지 탐색
					if (board[j][i] != '.' && board[k][i] == '.') {// j행이 블록이고 j행 밑에 .인 k행이 있다면 아래로 이동
						board[k][i] = board[j][i];
						board[j][i] = '.';
						break;
					}
				}
			}
		}
	}
}
