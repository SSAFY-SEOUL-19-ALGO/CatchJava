package week7.week7_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 빙고 {
	static int[][] board;
	static int bingoScore=0;
	static int []bingoLine;
	static void bingo(int num) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(board[i][j]==num) {
					bingoLine[i+1]++;//해당 숫자가 포함된 가로줄 카운트++
					bingoLine[j+6]++;//해당 숫자가 포함된 세로줄 카운트++
					if(i==j)bingoLine[11]++;//해당 숫자가 좌대각선에 포함이면  좌대각 카운트++
					if(i+j==4)bingoLine[12]++;//해당 숫자가 우대각선에 포함이면  우대각 카운트++
					
					//라인별 빙고여부 확인
					if(bingoLine[i+1]==5) {
						bingoScore++;
						bingoLine[i+1]++;
						//++안해주면 매 for문마다 빙고로 카운트되기 때문에 한번 빙고가 
						//나온 줄은 6으로 만들어 카운트 제외
					}
					if(bingoLine[j+6]==5) {
						bingoScore++;
						bingoLine[j+6]++;
					}
					if(bingoLine[11]==5) {
						bingoScore++;
						bingoLine[11]++;
					}
					if(bingoLine[12]==5) {
						bingoScore++;
						bingoLine[12]++;
					}
				
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] st;
		board=new int[5][5];
		bingoLine=new int[13]; //1~12사용 1-5:가로줄 6-10 세로줄 11 12 대각선
		int cnt=0;//빙고까지 걸리는 횟수 카운트
		for(int i=0;i<5;i++) {
			st= br.readLine().split(" ");
			for(int j=0;j<5;j++) {
				board[i][j]=Integer.parseInt(st[j]);
			}
		}
		
		for(int i=0;i<5;i++) {
			st= br.readLine().split(" ");
			for(int j=0;j<5;j++) {
				cnt++;
				bingo(Integer.parseInt(st[j]));
				if(bingoScore>=3) {//3줄이상 빙고가 완성되면
					System.out.println(cnt);//횟수 출력
					return;
				}
			}
		}
		
	}

}
