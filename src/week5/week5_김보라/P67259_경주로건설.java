package week5.week5_김보라;

import java.util.LinkedList;
import java.util.Queue;

public class P67259_경주로건설 {
	
	public static void main(String[] args) {
		int[][] Test1={{0,0,0},{0,0,0},{0,0,0}};
		int[][] Test2={{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		int[][] Test3={{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int[][] Test4={{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		
		int[][] Test5= {{0,0,0,0,0},{0,1,1,1,0},{0,0,1,0,0},{1,0,0,0,1},{0,1,1,0,0}};//반례
		System.out.println(solution(Test5));
//		System.out.println(Math.min(bfs(Test2,Test2.length,0,0,1),bfs(Test2,Test2.length,0,0,3)));
	}
	static int dx[] = {-1,1,0,0};//상하좌우
	static int dy[] = {0,0,-1,1};

	static int solution(int[][] board) {
		int N = board.length;
		int[][][] result = new int[N][N][4];

		Queue<int[]> q = new LinkedList<>();

		if (board[0+dx[1]][0+dy[1]] == 0) {//하 1
			result[0+dx[1]][0+dy[1]][1] = 100;
			q.offer(new int[] { 0+dx[1], 0+dy[1], 1 });
		}
		if (board[0+dx[3]][0+dy[3]] == 0) {//우 3
			result[0+dx[3]][0+dy[3]][3] = 100;
			q.offer(new int[] { 0+dx[3], 0+dy[3], 3 });
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll(); // 현재
			int x = cur[0];
			int y = cur[1];
			int d = cur[2];

//			if(x==N-1&&y==N-1) {
//				return price[x][y][d];
//				int answer = Integer.MAX_VALUE;
//	
//				for (int i = 0; i < 4; i++) {
//					if(result[N-1][N-1][i]!=0) {
//						answer=Math.min(result[N-1][N-1][i], answer);
//					}
//				}
//				return answer;
//			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
			
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && board[nx][ny] != 1) {
					int cost = result[x][y][d];

					if (d != i) {
						cost += 600;
					}else {
						cost+=100;
					}
					if (result[nx][ny][i]==0||result[nx][ny][i] >= cost) {
						q.offer(new int[] { nx, ny, i });
						result[nx][ny][i] = cost;
					}
				}
			}
		}

		int answer = Integer.MAX_VALUE;

		for (int i = 0; i < 4; i++) {
			if(result[N-1][N-1][i]!=0) {
				answer=Math.min(result[N-1][N-1][i], answer);
			}
		}
		return answer;
	}

}
	/*
	static int dx[] = {1, 0, 0, -1};
	static int dy[] = {0, 1 ,-1, 0};
	static int solution(int[][] board) {
		Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, -1, 0});
        int N = board.length;
        boolean visited[][][]=new boolean[N][N][4];
        int answer = Integer.MAX_VALUE;
        visited[0][0][0] = visited[0][0][1] = visited[0][0][2] = visited[0][0][3] =true;

        while (!q.isEmpty()) {
            int[] d = q.poll();
            if (d[0] == N-1 && d[1] == N- 1) {	//정답에 도달
                answer = Math.min(answer, d[3]);
                return answer;
            }
            for (int i = 0 ; i < 4 ; i++) {
                int nx = d[0] + dx[i];
                int ny = d[1]+ dy[i];
                if (ny >= 0 && ny < N&& nx >= 0 && nx < N && board[nx][ny] != 1) {//범위 안에 있고 갈 수 있을 때
                    int new_cost = (d[2] == -1 || d[2] == i) ? d[3] + 100 : d[3] + 600;
                    if (!visited[nx][ny][i] || new_cost <= board[nx][ny]) {
                        q.offer(new int[] {nx, ny, i, new_cost});
                        visited[nx][ny][i] = true;
                        board[nx][ny] = new_cost;
                    }

                }
            }
        }
		return answer;
    } 
	}*/
	/*25개 중 8개 실패->반례 Test5
	static int dx[] = {1, 0, 0, -1};
	static int dy[] = {0, 1 ,-1, 0};
	static int cost[][];
	static int MAXSIZE=Integer.MAX_VALUE;
	static int N;

	static int solution(int[][] board) {
	    int ans;
	    Queue<int[]> q=new LinkedList<>();
	    N = board.length;
	    cost=new int[N][N];
	    for(int i=0;i<N;i++) {
	    	for(int j = 0; j<N; j++) {
	    		cost[i][j]=MAXSIZE;
	    	}
	    }
	    q.add(new int[]{0,0,0});
	    cost[0][0] = 0;
	    while(!q.isEmpty())
	    {
	        int[] cur = q.poll();
	        int d = cur[0];
	        int x = cur[1];
	        int y = cur[2];
	        for(int dir=0;dir<4;dir++){
	        	for(int a = 0; a<board.length; a++) {
					for(int b = 0; b<board.length; b++) {
						System.out.print(cost[a][b]+" ");
					}System.out.println();
				}
	            int ny = x + dy[dir];
	            int nx = y + dx[dir];
	            if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
	            if(board[ny][nx]!=0) continue;
	            int val=100;
	            int sta=1;
	            if(d == 1){
	                if(dir==1 || dir==2) {
	                    sta = 2;
	                    val += 500;
	                }
	            }else if(d == 2){
	                if(dir==1 || dir==2){
	                    sta = 2;
	                }else val += 500;
	            }else{
	                if(dir==1 || dir==2) sta=2;
	            }
	            if(cost[ny][nx] < cost[x][y]+val) continue;
	            q.add(new int[] {sta,ny,nx});
	            cost[ny][nx] = cost[x][y]+val;
	        }
	    }
	    ans = cost[N-1][N-1];
	    return ans;
	}}*/
	
	/*
	public static int solution(int[][] board) {
		int dx[] = {-1,1,0,0};//상하좌우
		int dy[] = {0,0,-1,1};
        int answer = 100;
        
        Queue<int[]> q = new LinkedList<>();
		int x = 0, y = 0;
		int[][] visited = new int[board.length][board.length];
		
		q.add(new int[] {0,0,0});
//		if(board[x+dx[3]][y+dy[3]]==0) {
//			visited[x][y]=100;
//			q.add(new int[] {x,y,3});
//		}
//		if(board[x+dx[1]][y+dy[1]]==0) {
//			visited[x][y]=100;
//			q.add(new int[] {x,y,1});
//		}
		int dis = 1;
//		int cnt = 0;
		
		while(!q.isEmpty()) {
			
		
				int[] n = q.poll();
				
				x=n[0];
				y=n[1];
				dis=n[2];
				
						
				for(int i = 0; i<4; i++) {
					if(x+dx[i]>=0&&x+dx[i]<board.length&&y+dy[i]>=0&&y+dy[i]<board.length) {
						
						if(x+dx[i]==board.length-1&&y+dy[i]==board.length-1) {
							for(int a = 0; a<board.length; a++) {
								for(int b = 0; b<board.length; b++) {
									System.out.print(visited[a][b]+" ");
								}System.out.println();
							}
							return visited[x][y];
						}
						if(visited[x+dx[i]][y+dy[i]]==0&&board[x+dx[i]][y+dy[i]]==0) {
							int tmp = 100;
							if(dis==1) {
								if(i==1||i==2) {
									dis=2;
									tmp+=500;
								}
							}else if(dis==2) {
								if(i==1||i==2) {
									dis=2;
								}else {
									tmp+=500;
								}
							}else {
								if(i==1||i==2) {
									dis=2;
								}
							}
							
							if(visited[x+dx[i]][y+dy[i]])
														
							
							q.add(new int[] {(x+dx[i]), (y+dy[i]),i});
						}
						
					}
				}
		
		}
        
        return answer;
    }*/
	
	/*
	public static int solution(int[][] board) {
		int dx[] = {-1,1,0,0};//상하좌우
		int dy[] = {0,0,-1,1};
        int answer = 100;
        
        Queue<int[]> q = new LinkedList<>();
		int x = 0, y = 0;
		int[][] visited = new int[board.length][board.length];
		
		if(board[x+dx[3]][y+dy[3]]==0) {
			visited[x][y]=100;
			q.add(new int[] {x,y,3});
		}
		if(board[x+dx[1]][y+dy[1]]==0) {
			visited[x][y]=100;
			q.add(new int[] {x,y,1});
		}
		int dis = 1;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			
			int size= q.size();
			for(int s = 0; s<size; s++) {
				int[] n = q.poll();
				
				x=n[0];
				y=n[1];
				dis=n[2];
				
						
				for(int i = 0; i<4; i++) {
					if(x+dx[i]>=0&&x+dx[i]<board.length&&y+dy[i]>=0&&y+dy[i]<board.length) {
						
						if(x+dx[i]==board.length-1&&y+dy[i]==board.length-1) {
							for(int a = 0; a<board.length; a++) {
								for(int b = 0; b<board.length; b++) {
									System.out.print(visited[a][b]+" ");
								}System.out.println();
							}
							return visited[x][y];
						}
						if(visited[x+dx[i]][y+dy[i]]==0&&board[x+dx[i]][y+dy[i]]==0) {
							int tmp = visited[x][y];
							
							if(dis==i) {
								tmp+=100;
							}else {
								tmp+=500;
							}
														
							if(visited[x+dx[i]][y+dy[i]]!=0) {
								visited[x+dx[i]][y+dy[i]]=Math.min(visited[x+dx[i]][y+dy[i]], tmp);
							}else {
								visited[x+dx[i]][y+dy[i]]=tmp;
							}
							q.add(new int[] {(x+dx[i]), (y+dy[i]),i});
						}
						
					}
				}
			}
			
			cnt++;
		}
        
        return answer;
    }
	*/	
		
/*
	

	static int dx[] = {-1,1,0,0};//상하좌우
	static int dy[] = {0,0,-1,1};
	static int bfs(int[][] board,int N,int x, int y, int dis) {
		LinkedList<int[]> q = new LinkedList<>();
		
		int[][] visited=new int[N][N];
		visited[x][y]=100;
		q.add(new int[] {x,y,dis});
		
		while(!q.isEmpty()) {
			
	
				int[] n = q.poll();
				
				x=n[0];
				y=n[1];
				dis=n[2];
						
				for(int i = 0; i<4; i++) {
					if(x+dx[i]>=0&&x+dx[i]<board.length&&y+dy[i]>=0&&y+dy[i]<board.length) {
						
						if(x+dx[i]==board.length-1&&y+dy[i]==board.length-1) {
							for(int a = 0; a<board.length; a++) {
								for(int b = 0; b<board.length; b++) {
									System.out.print(visited[a][b]+" ");
								}System.out.println();
							}
							return visited[x][y];
						}
						if(visited[x+dx[i]][y+dy[i]]==0&&board[x+dx[i]][y+dy[i]]==0) {
							int tmp = visited[x][y];
							
							if(dis==i) {
								tmp+=100;
							}else {
								tmp+=500;
							}
							
//							if(dis==i) {
////								System.out.println(x+" "+y+" "+dis+" "+i+" "+"(1)");
//								visited[x+dx[i]][y+dy[i]]+=100;
//							}else {
////								System.out.println(x+" "+y+" "+dis+" "+i+" "+"(2)");
//								visited[x+dx[i]][y+dy[i]]+=500;
//							}
//							visited[x+dx[i]][y+dy[i]]=1;
							if(visited[x+dx[i]][y+dy[i]]!=0) {
								visited[x+dx[i]][y+dy[i]]=Math.min(visited[x+dx[i]][y+dy[i]], tmp);
							}else {
								visited[x+dx[i]][y+dy[i]]=tmp;
							}
							q.add(new int[] {(x+dx[i]), (y+dy[i]),i});
						}
						
					}
				}
		}
		return Integer.MAX_VALUE;
	}*/
	
//	public static int solution(int[][] board) {
//		int dx[] = {-1,1,0,0};//상하좌우
//		int dy[] = {0,0,-1,1};
//        int answer = 100;
//        
//        LinkedList<int[]> q = new LinkedList<>();
//		int x = 0, y = 0;
//		int[][] visited = new int[board.length][board.length];
//		visited[x][y]=100;
//		q.add(new int[] {x,y,1});
//		int dis = 1;
//		int cnt = 0;
//		
//		while(!q.isEmpty()) {
//			
//			int size= q.size();
//			dis=q.peek()[2];
//			for(int s = 0; s<size; s++) {
//				int[] n = q.poll();
//				
//				x=n[0];
//				y=n[1];
//				
//						
//				for(int i = 0; i<4; i++) {
//					if(x+dx[i]>=0&&x+dx[i]<board.length&&y+dy[i]>=0&&y+dy[i]<board.length) {
//						
//						if(x+dx[i]==board.length-1&&y+dy[i]==board.length-1) {
//							for(int a = 0; a<board.length; a++) {
//								for(int b = 0; b<board.length; b++) {
//									System.out.print(visited[a][b]+" ");
//								}System.out.println();
//							}
//							return visited[x][y];
//						}
//						if(visited[x+dx[i]][y+dy[i]]==0&&board[x+dx[i]][y+dy[i]]==0) {
//							int tmp = visited[x][y];
//							
//							if(x==0&&y==0) {
//								dis=i;
//							}
//							
////							if(dis==i) {
//////								System.out.println(x+" "+y+" "+dis+" "+i+" "+"(1)");
////								visited[x+dx[i]][y+dy[i]]+=100;
////							}else {
//////								System.out.println(x+" "+y+" "+dis+" "+i+" "+"(2)");
////								visited[x+dx[i]][y+dy[i]]+=500;
////							}
////							visited[x+dx[i]][y+dy[i]]=1;
//							if(visited[x+dx[i]][y+dy[i]]!=0) {
//								visited[x+dx[i]][y+dy[i]]=Math.min(visited[x+dx[i]][y+dy[i]], tmp);
//							}else {
//								visited[x+dx[i]][y+dy[i]]=tmp;
//							}
//							q.add(new int[] {(x+dx[i]), (y+dy[i]),i});
//						}
//						
//					}
//				}
//			}
//			
//			cnt++;
//		}
//        
//        return answer;
//    }
//	
//}
