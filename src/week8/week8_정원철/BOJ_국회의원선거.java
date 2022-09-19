package week8.week8_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_국회의원선거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> que=new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 선언, 내림차순으로 설정
		
		int N=Integer.parseInt(br.readLine());
		int dasom=Integer.parseInt(br.readLine());//기호 1번인 다솜만 따로 변수로 빼놓고		
		for (int i=0; i<N-1; i++) que.add(Integer.parseInt(br.readLine())); // 다른 비교군들을 우선순위큐에 삽입한다.

		int cnt=0; // 매수해야할 투표수를 담을 변수
		
		while(true) {
			
			if(que.size()==0) { // 큐 사이즈가 0개인 경우 => 후보가 하나인경우 처리
				System.out.println(0);
				return;
			}

			if(dasom<=que.peek()) { // 당선이 되려면 동률은 존재해선 안돼
				dasom+=1;			// 다솜보다 크거나 같으면 일단 다솜에게 한표를 주고
				que.add(que.poll()-1); // 해당 비교군에게 한표를 감면하고(매수자) 다시 넣어 그러면 다시 오름차순으로 정렬이돼서 바로 비교가능
				cnt++; // 매수했으니 카운트값 증가
				continue; //바로 다음 실행
			}else { // 제일 큰수가 맨앞으로 오는데 맨앞의 수가 다솜보다 작은 경우는 다솜이 당선되는 경우이기에 이때 매수자수 리턴하면 답
				System.out.println(cnt);
				return;
			}
		}

	}

}
