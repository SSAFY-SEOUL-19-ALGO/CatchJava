package week6.week6_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class 인구이동 {
	static int map [][];//나라 인구 저장 배열
	static int open[][];//국경 개방가능여부 확인
	static int N,L,R,day;//맵사이즈N / 인구차이 하한선 L 상향선 R / 일수 day
	static boolean[][] isvisited;
	static int[] dx= {0,1,-1,0};
	static int[] dy= {1,0,0,-1};
	static int group=1;//open을 boolean으로 묶으니까 양옆에 인접한 애들이 값이 꼬임... 각각 분리
	static ArrayDeque<int[]>Q = new ArrayDeque<int[]>();//Q 연합의 시작좌표 + 평균값저장

	static void afterbfs(int i, int j,int g,int value) {//bfs를 돌린 뒤 연합의 시작 좌표를 받아서 좌표부터 다시  bfs 시작,모든 자리값 평균으로 초기화

		ArrayDeque<int[]>curQ = new ArrayDeque<int[]>();
		curQ.add(new int[] {i,j});
		while(!curQ.isEmpty()) {
			int[] xy=curQ.poll();
			int x=xy[0];
			int y=xy[1];
			map[x][y]=value;//평균값으로 초기화
			isvisited[x][y]=true;
			for(int d=0;d<4;d++) {
				if(x+dx[d]>=0&&x+dx[d]<N&&y+dy[d]>=0&&y+dy[d]<N&&open[x+dx[d]][y+dy[d]]==g&&!isvisited[x+dx[d]][y+dy[d]]) {//범위안이고 오픈되어있다
					isvisited[x+dx[d]][y+dy[d]]=true;
					map[x+dx[d]][y+dy[d]]=value;
					curQ.add(new int[] {x+dx[d],y+dy[d]});
				}
				
			}
		}
	}
	
	static void bfs(int i, int j) {//좌표를 받아서 좌표부터 bfs 시작,모든 자리값 평균으로 초기화
		ArrayDeque<int[]>curQ = new ArrayDeque<int[]>();
		curQ.add(new int[] {i,j});
		int union=1;//연합의 수
		int sum=map[i][j];//연합의 인구수 총합
		open[i][j]=group;
		while(!curQ.isEmpty()) {
			int[] xy=curQ.poll();
			int x=xy[0];
			int y=xy[1];
			isvisited[x][y]=true;
			
			for(int d=0;d<4;d++) {
				if(x+dx[d]>=0&&x+dx[d]<N&&y+dy[d]>=0&&y+dy[d]<N&&open[x+dx[d]][y+dy[d]]==0&&!isvisited[x+dx[d]][y+dy[d]]) {//범위안이고 아직 안가봤다.
					int diff=Math.abs(map[x][y]-map[x+dx[d]][y+dy[d]]);
					if(diff>=L&&diff<=R) {
						//방문 가능한 자리고 방문조건도 만족한다
						open[x+dx[d]][y+dy[d]]=group;
						isvisited[x+dx[d]][y+dy[d]]=true;
						curQ.add(new int[] {x+dx[d],y+dy[d]});
						union++;
						sum+=map[x+dx[d]][y+dy[d]];
					}
					
				}
				
			}
		}
		if(union>1) {//연합이 구성된게 있다면
			Q.add(new int[] {i,j,sum/union});//추가
			group++;//연합 하나 추가하고 연합 넘버 ++
		}
		else {
			open[i][j]=0;
		}
		
	}
	
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String [] st= br.readLine().split(" ");
			N=Integer.parseInt(st[0]);
			L=Integer.parseInt(st[1]);
			R=Integer.parseInt(st[2]);
			day=0;
			map=new int[N][N];
			open=new int[N][N];//오픈여부 저장
			isvisited=new boolean[N][N];//방문여부 저장
			for(int i=0;i<N;i++) {
				st= br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st[j]);
				}
			}
			
			
			while(true) {
				group=1;
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(!isvisited[i][j]) {
							isvisited[i][j]=true;//내자리 방문체크
							bfs(i,j);
						}
						
					}
				}
				if(Q.isEmpty()) {//bfs를 돌았느데 Q가 비었다 ->연합이 없으므로 종료
					break;
				}
				for(int i=0;i<N;i++) {
					Arrays.fill(isvisited[i],false);//방문여부 초기화
				}
				group=1;
				while(!Q.isEmpty()) {
					
					int[] q=Q.poll();
					int x=q[0];
					int y=q[1];
					int value=q[2];
					afterbfs(x, y,group, value);
					group++;
				}
				for(int i=0;i<N;i++) {
					System.out.println(Arrays.toString(map[i]));
				}
				System.out.println();
				for(int i=0;i<N;i++) {
					Arrays.fill(open[i],0);//방문여부 초기화
					Arrays.fill(isvisited[i],false);//방문여부 초기화
				}
				
				day++;
				
			}
			System.out.println(day);
		}
	}

