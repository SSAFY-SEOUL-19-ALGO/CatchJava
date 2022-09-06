package week5_조민수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11047_동전0 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] st=br.readLine().split(" ");
		int coin=Integer.parseInt(st[0]);//동전 개수 입력 받음
		int price=Integer.parseInt(st[1]);//목표 금액
		int resultCnt=0;//목표개수
		int[] coins=new int[coin];//coin개수만큼 배열 생성
		
		for(int i=coin-1;i>=0;i--) {//입력을 역순으로 받는다 내림차순
			coins[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0;i<coin;i++) {
			if(price/coins[i]!=0) {//높은순으로 나누어 떨어지는지 확인
				resultCnt+=price/coins[i];//나누어 떨어진 값만큼 동전개수 추가
				price=price%coins[i];//잔액 = 원금에서 사용금액을 나눈 나머지
			}
			if(price==0) {
				System.out.println(resultCnt);
				return;
			}
			
		}
		
		
	}

}
