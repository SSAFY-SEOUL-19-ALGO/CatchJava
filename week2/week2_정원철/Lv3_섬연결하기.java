package week2_정원철;

public class Lv3_섬연결하기 {

	static int minNum;
	
	  static public int solution(int n, int[][] costs) {
      int answer = 0;
      boolean[] cheked = new boolean[n];
      cheked[0] = true;

      int[][] map = new int[n][n];
      
      int checkedCnt = 0;

      for(int[] cost : costs) {          
          map[cost[0]][cost[1]]=cost[2];
          map[cost[1]][cost[0]]=cost[2];
      }

      while(checkedCnt<n-1) {
          minNum=Integer.MAX_VALUE;
          int checkedIdx = 0;
          for(int i=0; i<n; i++) {
              if(cheked[i]) {
                  for(int j=0; j<n; j++) {
                      if(  !cheked[j]&&map[i][j]>0) {
                          if(minNum > map[i][j]) {
                        	  minNum = map[i][j];
                              checkedIdx = j;
                          }
                      }
                  }
              }
          }

          checkedCnt++;
          answer += minNum;
          cheked[checkedIdx] = true;
      }

      return answer;
  }
	
	public static void main(String[] args) {
	
		int costs[][]={{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(4,costs));
	}

}
