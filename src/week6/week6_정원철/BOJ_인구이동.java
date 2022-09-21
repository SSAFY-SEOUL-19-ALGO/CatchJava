package week6.week6_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_인구이동 {
//	국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
//	위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
//	국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
//	연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
//	연합을 해체하고, 모든 국경선을 닫는다.   

// 보완필요... 일요일에 수정 불가하여, 제출후 다시.. 수정...

		static int N,L,R;
	    static int[][] arr;

	    static int countrySet;
	    static int[][] visited;

	    static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
	    public static void main(String[] args) throws IOException {


	    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        String st[]=br.readLine().split(" ");
	    	N = Integer.parseInt(st[0]);
	        L = Integer.parseInt(st[1]);
	        R = Integer.parseInt(st[2]);
	        // 두 나라 인구 차이가 L명 이상 R명 이하면 국경선 열림

	        arr = new int[N][N];
	        visited = new int[N][N];
	        for(int i=0;i<N;i++) {
	        	 st=br.readLine().split(" ");
	            for(int j=0;j<N;j++)
	                arr[i][j] = Integer.parseInt(st[j]);
	        }


	        int result = 0;
	        // 인구이동 끝까지
	        while(true) {
	            boolean chk = false; // 인구 이동  확인하는 변수
	            countrySet = 0;
	            for(int i=0;i<N;i++) {
	                for(int j=0;j<N;j++) {
	                    // 다른 연합이 아닐 경우만 체크
	                    if(visited[i][j]==0) {
	                        // 인구 이동이 일어났으면 true
	                        if(bfs(i,j))
	                        	chk = true;
	                    }
	                }
	            }
	            if(chk) result++; // 인구 이동 ++
	            else break; // 인구 이동 x => 종료

	            // 다보면 방문 초기화
	            for(int i=0;i<N;i++) {
	                for(int j=0;j<N;j++)
	                    visited[i][j] = 0;
	            }
	        }
	        System.out.println(result);
	    }



	    private static boolean bfs(int x,int y) {
	        Queue<Node> queue = new ArrayDeque();
	        countrySet++; // 각 연합번호
	        queue.add(new Node(x, y));
	        visited[x][y] = countrySet;
	        int population = arr[x][y];
	        int cnt = 1;
	        while(!queue.isEmpty()) {
	            Node t = queue.poll();

	            for(int i=0;i<4;i++) {
	                int tx = t.x+pos[i][0];
	                int ty = t.y+pos[i][1];
	                if(tx<0 || ty<0 || tx>=N || ty>=N) continue;
	                // 방문 체크 & 연합 구별
	                if(visited[tx][ty]!=0) continue;
	                // 두 나라의 차이가 범위안이라면
	                if(check(arr[t.x][t.y], arr[tx][ty])) {
	                    visited[tx][ty] = countrySet;
	                    cnt++; // 연합 수 세기
	                    population+=arr[tx][ty]; // 인구 수 더하기
	                    queue.add(new Node(tx, ty));
	                }
	            }
	        }

	        // 인구 나누기
	        for(int i=0;i<N;i++) {
	            for(int j=0;j<N;j++) {
	                if(visited[i][j]==countrySet) {
	                    arr[i][j] = population/cnt;
	                }
	            }
	        }
	        // cnt가 1보다 크다 -> 인구이동
	        if(cnt>1) return true;
	        else return false;
	    }


	    private static boolean check(int n1,int n2) {
	        int t = Math.abs(n1-n2);
	        // 차이가 l명이상 r명 이하라면
	        if(t>=L&&t<=R) return true;
	        else return false;
	    }

	    static class Node{
	        int x,y;
	        Node(int x,int y){
	            this.x = x;
	            this.y = y;
	        }
	    }
}