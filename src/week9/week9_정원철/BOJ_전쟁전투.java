package week9.week9_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_전쟁전투 {
	static char map[][];
	static int N,M, bCnt, wCnt, totalw, totalb;
	static char color;
	public static void main(String[] args) throws IOException {

	    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	    String st[]=br.readLine().split(" ");
	    N=Integer.parseInt(st[0]); // 크기 입력받음
	    M=Integer.parseInt(st[1]);
	    
	    map=new char[M][N]; // 문자 배열에 넣음
	    for (int i=0; i<M; i++) {
	        String m=br.readLine();
	        for (int j=0; j<N; j++) map[i][j]=m.charAt(j); //다 넣어~
	    } 
	    
	    for (int i=0; i<M; i++) {
	        for (int j=0; j<N; j++) {
	                if(map[i][j]!='0') { // 방문안한곳이라면 들어가!
	                	color=map[i][j]; // 해당 컬러를 미리찍어, 두개를 체크해야하기에 여기서 체크
	                	if( dfs(i, j)==true) { // dfs 빠져나오면 
	                        totalb+=bCnt*bCnt; // 해당 함수내에서 나온 색별 카운터값이 나올거야 만약계속 블루만 체크했으면 
		                    totalw+=wCnt*wCnt; // 하얀색은 0이기에 여기가 계속 작동해도 값에 변화가 없기에 괜찮음
		                    bCnt=0; // 카운터는 다시 초기화
		                    wCnt=0; 
	                	}
	                }
	        }
	    }
	    System.out.println(totalw+" "+totalb);
	}

	static boolean dfs(int x, int y) {
	    if (x <= -1 || x >= M || y <= -1 || y >= N) return false; // 범위 벗어나면 아웃
	    
	    if(map[x][y]==color) { // 위에서 설정한 컬러라면
	        if(color=='B') bCnt++; // 해당 컬러 카운터값 늘림
	        else wCnt++;
	    	map[x][y]='0'; // 해당 위치 방문처리
	        dfs(x-1, y); //상 하 좌 우 탐색 하면서 찾아나감
	        dfs(x, y-1);
	        dfs(x+1, y);
	        dfs(x, y+1);
	        return true;
	    }
	    return false;
	}
	}