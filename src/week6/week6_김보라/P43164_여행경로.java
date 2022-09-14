package week6_김보라;

import java.util.Arrays;
import java.util.Comparator;

public class P43164_여행경로 {

	public static void main(String[] args) {
//		System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
		System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
	}
	/*
	 * 외판원순회를 써볼까..했는데 모든 항공권을 사용해야된다는 조건이 걸리네
	 */
	static String[] solution(String[][] tickets) {
		Arrays.sort(tickets,Comparator.comparing(o->o[1]));
//		Arrays.sort(tickets,(o1,o2)->o2[1].compareTo(o1[1]));	//역순으로 해야 마지막에 남는 게 알파벳 순..?
		//테케 1 2 실패 3 4 통과.. 왜..?
		//문제에 항공권 정보가 중복되지 않는다는 언급이 없습니다. 동일한 항공권이 여러 장 주어질 수 있음을 감안하고 풀이를 작성해야 합니다.
		//얄밉네요 ㅎㅎ
		
        String[] answer = new String[tickets.length+1];
        answer[0]="ICN";
        String[] result = new String[tickets.length+1];
        result[0]="ICN";
        p(0,tickets,new boolean[tickets.length],result,answer);
        
        return answer;
    }
	static boolean findAnswer = false;
	static void p(int cnt, String[][] tickets, boolean[] selected, String[] result,String[] answer) {
		if(findAnswer) {
			return;
		}
		if(cnt==tickets.length) {
			if(!findAnswer) {
				for(int i = 0; i<=tickets.length; i++) {
					answer[i]=String.valueOf(result[i]);
				}
				findAnswer=true;
			}
			
			return;
		}
		
		for(int i = 0; i<tickets.length; i++) {
			if(!selected[i]&&tickets[i][0].equals(result[cnt])) {
				result[cnt+1] = tickets[i][1];
				selected[i] = true;
				p(cnt + 1, tickets, selected, result,answer);
				selected[i] = false;
			}
		}
	}
}
