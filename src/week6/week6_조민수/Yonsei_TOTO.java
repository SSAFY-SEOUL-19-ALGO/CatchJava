package week6.week6_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Yonsei_TOTO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] st= br.readLine().split(" ");
		int cls= Integer.parseInt(st[0]);//과목 수
		int point=Integer.parseInt(st[1]);//내 포인트
		int maxclass=0;//들을 최대 과목
		PriorityQueue<Integer> myclass=new PriorityQueue<Integer>();
		PriorityQueue<Integer> curclass=new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i=0;i<cls;i++){
			//현재 과목 포인트 역순 정렬->정원 기준 마지막 번호보다 1점만 더주면 된다.
			st= br.readLine().split(" ");
			int curmem= Integer.parseInt(st[0]);//신청인원
			int curmax= Integer.parseInt(st[1]);//최대정원
			if(curmem<curmax) {//미달 과목일 경우 1포인트만 넣어도 수강 가능
				br.readLine();//한줄 읽고 버리기
				myclass.add(1);
				
			}
			else{
				st= br.readLine().split(" ");
				for(int j=0;j<curmem;j++) {
					curclass.add(Integer.parseInt(st[j]));
					
				}
				for(int j=0;j<curmax-1;j++) {//정원 전까지 빼고 마지막 숫자만 보겠다.
					curclass.poll();
				}
				int cur=curclass.poll();
				myclass.add(cur);//36이면 그대로 추가 아니면 과목 턱걸이 한 포인트 +1
				
				
				
			}
			curclass.clear();
		}
		for(int i=0;i<cls;i++) {
			point-=myclass.poll();
			if(point<0) {//포인트 다 소모하면 
				System.out.println(maxclass);
				return;
			}
			maxclass++;//포인트가 남으면 과목수 +한 뒤 반복
		}
		System.out.println(maxclass);
		return;
	}

}
