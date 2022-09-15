package week6.week6_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 에너지드링크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N=0; //드링크 개수
		double max=0;//드링크 중 가장 많은 양을 가진 드링크
		double drink=0;//전체 드링크의 합
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		String st[]=br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			//제일 많이 들어있는 음료에 나머지 음료를 모두 합칠거다.
			//max만 원본 그대로 더하고 나머지 max보다 작은 애들은 1/2해서 더한다
			double now= Integer.parseInt(st[i]);
			if(max<now) {//지금값이 맥스보다 크면 맥스값 갱신 후 원래 맥스에 있던 값은 1/2해서 더하기
				drink+=max/2;//현재 max값->1/2후 더하기
				max=now;//max값 갱신
				continue;//반복
			}
			drink+=now/2;//max값보다 작으면 바로 1/2후 더하기
		}
		drink+=max;//다 돌고나서 남아있는 max값은 원본으로 합치기
		System.out.println(drink);
	}
}
