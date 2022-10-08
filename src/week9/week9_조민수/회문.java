package week9.week9_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문 {
	static int miss1, miss2, N;// 유사회문인지 비교위해 체크

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split("");
			miss1 = 0;
			miss2 = st.length;
			int result =0;;
			for (int j = 0; j < st.length / 2; j++) {//첫 문장이 회문인지 검사
				if (!st[j].equals(st[st.length - 1- j])) {//회문이 아닐경우
					miss1 = j;//앞쪽 문제가 되는 위치 저장
					miss2 = miss2 - 1 - j;//뒤쪽 문제가 되는 위치 저장
					result=1;
					break;
				}
			}
			if (result == 0) {//회문이라면 출력 후 끝
				System.out.println(result);
				continue;
			} 
			
			else {// 회문이 아니라면 유사회문인지 확인
				//유사회문 확인 : 위에서 문제된 부분(앞 뒤)를 차례로 제거후 비교하여 회문이 가능한지 확인
				miss1++;//앞 단어 제거
				result = checkRePalin(st) + 1;// 회문이 가능이면 0이 나오고 아니면 1이 나오므로
				if (result == 1) {
					System.out.println(result);
					continue;
				}
				miss1--;//앞글자 다시 포함 후
				miss2--;//뒷 글자 제외
				
				result = checkRePalin(st) + 1;// 회문이 가능이면 0이 나오고 아니면 1이 나오므로
				System.out.println(result);
			}
		}
	}

	static int checkRePalin(String[] st) {
		// 처음은 전체 그 다음부턴 자를 범위만 보기->현재 볼 길이
		for (int i = 0; i <(miss2 - miss1+1)/ 2; i++) {
			if (!st[miss1+i].equals(st[miss2 - i])) {
				return 1;
			}
		}
		return 0;// 잘 나왔으면 회문이다.
	}
}
