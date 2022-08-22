package week2_김보라;


//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class P42861_섬연결하기 {
	//크루스칼
//	static int n  = 6;	//섬의 개수
//	static int[][] costs= {{0,1,5},{0,3,2},{0,4,3},{1,4,1},{3,4,10},{1,2,2},{2,5,3},{4,5,4}};	//답 11
	
	static int n = 5;
	static int[][] costs= {{0, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 2, 2}, {0, 4, 100}};	//15
	
	
	public static void main(String[] args) {
		int answer = 0;
		Arrays.sort(costs, Comparator.comparingInt(o1->o1[2]));	//비용순으로 정렬
		int[] group = new int[n];
		
		for(int i = 0 ; i<costs.length; i++) {
			for(int j = 0; j<3; j++) {
				System.out.print(costs[i][j]+" ");
			}System.out.println();
		}
		
		for(int i = 0; i<n; i++) {	//다 각자 따로다로 이어지지 않은 상태
			group[i] = i;
		}
		for(int i = 0; i<costs.length; i++) {
			if(group[costs[i][0]]!=group[costs[i][1]]) {
				int g= group[costs[i][1]];
				for(int j = 0; j<n; j++) {
					if(group[j]==g)
						group[j]=group[costs[i][0]];
				}
				answer+=costs[i][2];
			}
			for(int k = 0; k<n; k++)
				System.out.print(group[k]+" ");
			System.out.println();
		}
		
		System.out.println(answer);
	}
	
	
	/*하하... 직관적으로 풀어보려고 하다가 더 복잡해졌다.. 테케 성공. 히든테케 2개 빼고 실패
	static int n  = 4;
	static int[][] costs= {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
	//costs의 길이는 ((n-1)*n)/2이하입니다.

	static ArrayList<String> complete= new ArrayList<>();
	public static void main(String[] args) {
		int answer=0;
		Arrays.sort(costs,Comparator.comparingInt(o1->o1[2]));	//비용순으로 정렬
		
		//같은 연결은 두 번 주어지지 않습니다!
		for(int i = 0; i<costs.length; i++) {
			
			if(include(costs[i][0])==-1) {
				if(include(costs[i][1])==-1) {//둘 다 아직 이어지지 않은 다리이면
					complete.add(costs[i][0]+","+costs[i][1]+",");	//새 그룹으로 추가
					answer+=costs[i][2];	//비용을 추가해줌(건설함)
					System.out.println("case 1");
				}else {	//앞은 안이어짐 뒤는 이어짐
					complete.add(complete.get(include(costs[i][1])).concat(costs[i][0]+","));	//뒤에 이어진 그룹에 앞에꺼 이어주기
					complete.remove(include(costs[i][1]));
					answer+=costs[i][2];	//건설
					System.out.println("case 2");
				}
			}else {	//앞은 이어짐
				if(include(costs[i][1])==-1) {	//뒤는 안이어짐
					complete.add(complete.get(include(costs[i][0])).concat(costs[i][1]+","));	//앞에 이어진 그룹에 뒤에꺼 이어주기
					complete.remove(include(costs[i][0]));
					answer+=costs[i][2];	//건설
					System.out.println("case 3");
				}else if(include(costs[i][0])== include(costs[i][0])){	//이미 오갈 수 있는 경우
					System.out.println("case 4");
					continue;
				}else{	//여기가 핵심................... 앞도 뒤도 어딘가에 이어져있는 경우.....
					//두 개 합치기
					complete.add(complete.get(include(costs[i][0])).concat(complete.get(include(costs[i][0]))));
					complete.remove(include(costs[i][0]));
					complete.remove(include(costs[i][1]));
					answer+=costs[i][2]; //건설
					System.out.println("case 5");
				}
			}
			if(complete.get(0).split(",").length==costs.length) {	//이미 다 이어져 있으면
				break;
			}
		}
		
		System.out.println(answer);
//		for(int i = 0; i<costs.length;i++) {
//			for(int j = 0; j<3; j++) {
//				System.out.print(costs[i][j]+" ");
//			}System.out.println();
//		}
		
	}
	static int include(int x) {
		for(int i = 0; i<complete.size();i++) {
			if(complete.get(i).contains(x+","))
				return i;
		}
		return -1;	//없음
	}*/

}
