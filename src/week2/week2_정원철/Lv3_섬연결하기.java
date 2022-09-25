package week2.week2_정원철;

public class Lv3_섬연결하기 {

	// 프림알고리즘 -> 최소신장트리를 구현하는 한방법, 정점중심의 문제해결 , 하나의 정점을 정하고 인접 정점중 weight가 낮은 간선을 계속 골라가는 알고리즘
	// 점들은 인접한 정점 중 최소 비용으로 이동가능한 정점을 선택하여 추가하는 방식
	
	static int minNum;
	
	  static public int solution(int n, int[][] costs) {
      int answer = 0;

      
      //1.방문 노드(섬) 확인용 배열 선언
      boolean[] checked = new boolean[n];
      
      //2.시작 인덱스는 default true(방문)로 시작
      checked[0] = true;

      //3. 인덱스를 통해 섬(노드)들의 연결과 건설비용을 담을 배열 선언
      int[][] map = new int[n][n];
      
      //방문한 곳 카운터
      int checkedCnt = 0;

     //ex {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
      //   {섬1, 섬2, 비용}
      
     //4. 양방향의 간선의 cost값을 알기위해서 배열을 사용해 두방향  (a->b, b->a)의 비용을 삽입
  	// example[from][to] example[to][from] => 값에는 비용을 입력
  	// 행에는 from 정점인덱스, to 정점인덱스 <-> 교차
      
      for(int[] cost : costs) { 
    	  //map 인덱스에 섬1, 섬2값 = 비용 
          map[cost[0]][cost[1]]=cost[2];
          //map 인덱스에 섬2, 섬1값 = 비용  
          map[cost[1]][cost[0]]=cost[2];
      }
      
      
      
      //5. 연결된 정점의 개수가 n-1개가 될때까지 아래의 과정을 반복 (최저 비용을 찾기위한 과정)
      while(checkedCnt<n-1) { 
          minNum=Integer.MAX_VALUE; // 각각의 인급 섬에서 최저 cost를 담을 변수
          int checkedIdx = 0; // 확인 인덱스
          for(int i=0; i<n; i++) { //섬의 수만큼 반복 
              if(checked[i]) { // 해당섬(정점)을 방문했더라면 (처음에 걸리겠지)
                  for(int j=0; j<n; j++) { // 그 섬을 기준으로 그와 연결된 섬 탐색
                      if(  !checked[j]&&map[i][j]>0) { // 해당섬이  이전에 방문한 이력이있지 않고, 해당 섬의 연결비용이 0보다 크다면
                          if(minNum > map[i][j]) { // 이전 최저 비용과 비교해 현 비용이 더 낮게 나온다면
                        	  minNum = map[i][j]; // 최저비용을 (weight) 정보를 갱신해줌
                              checkedIdx = j; // 그때의 연결된 섬의(정점) 인덱스 정보를 저장
                          }
                      }
                  }
              }
          }// 과정을 마친후

          
          checkedCnt++; //다음 섬(정점)을 파악할수있게 반복분 인덱스 ++
          answer += minNum; //선택된 섬에서 도출된 최저비용을 결과변수에 누적해서 더하고
          checked[checkedIdx] = true; // 업데이트된 다음 인덱스는 방문처리를 해주고 반복
      }
      // ==> 위 와같은 과정을 통해 하나의 정점을 기준으로 인접 정점의 가중치 (비용)이 낮은 간선을 계속 골라가면서 
      // 모든섬이 통행이 가능하도록 하는 최저비용을 도출하게된다.

      return answer;
  }
	
	public static void main(String[] args) {
	
		int costs[][]={{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(4,costs));
	}

}
