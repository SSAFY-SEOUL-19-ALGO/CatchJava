package week5.week5_조민수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class P21275_폰호석만 {
	static int count=0;//해가 되는 개수파악
	static HashSet<Double> X=new HashSet<Double>();//A로 가능한 X를 저장 후 B로 가능한 X와 비교 
	static double Xnum=0;
	static int A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] st=br.readLine().split(" ");
		long[]XA=new long[st[0].length()];//변환된 A ->int로변환해서 저장예정
		long[]XB=new long[st[1].length()];
		int AStart=0;//A의 시적 진법체크 ->문자중 제일 큰값 기준으로 그밑 진법은 볼 필요 X 
					 //ex)p가 제일큰 문자면 p(26)진법 밑으론 p가 나올 수 없으니 안봐도 됨
		int BStart=0;
		for(int i=0;i<st[0].length();i++) {
			char a=st[0].charAt(i);
			if('0'<=a&&a<='9') {//문자가 숫자다
				XA[i]=a-'0';//숫자값 저장
				if(a-'0'>AStart) {
					AStart=a-'0';
				}
			}
			else {//문자다
				XA[i]=a-'a'+10;//문자 숫자로 변환+10부터 시작
				if(a-'a'+10>AStart) {
					AStart=a-'a'+10;
				}
			}
		}
		for(int i=0;i<st[1].length();i++) {
			char b=st[1].charAt(i);
			if('0'<=b&&b<='9') {//문자가 숫자다
				XB[i]=b-'0';//숫자값 저장
				if(b-'0'>BStart) {
					BStart=b-'0';
				}
			}
			else {//문자다
				XB[i]=b-'a'+10;//문자 숫자로 변환+10부터 시작
				if(b-'a'+10>BStart) {
					BStart=b-'a'+10;
				}
			}
		}
		for(int i=AStart+1;i<=36;i++) {//start 지점 다음부터 끝까지 돌면서 확인
			double num=0;//저장할 X값
			for(int j=0;j<XA.length;j++) {
				num+=XA[XA.length-1-j]*Math.pow(i, j);//입력된값 *자리값 더해주기
			}
			X.add(num);//가능한 X값 저장
		}
		for(int i=BStart+1;i<=36;i++) {//start 지점 다음부터 끝까지 돌면서 확인
			double num=0;//저장할 X값
			for(int j=0;j<XB.length;j++) {
				num+=XB[XB.length-1-j]*Math.pow(i, j);//입력된값 *자리값 더해주기
			}
			if(X.contains(num)) {
				count++;
				Xnum=num;
				B=i;
			}	
		}
		
		//이제 확인 ㄱㄱ count=0->임파서블 / 1-> 유일값 찾았다 / 2-> 멀티플 
		if(count==0) {
			System.out.println("Impossible");
		}
		else if(count>=2) {
			System.out.println("Multiple");
		}
		else {

			for(int i=AStart+1;i<=36;i++) {//start 지점 다음부터 끝까지 돌면서 확인
				double num=0;//저장할 X값
				for(int j=0;j<XA.length;j++) {
					num+=XA[XA.length-1-j]*Math.pow(i, j);//입력된값 *자리값 더해주기
				}
				if(num==Xnum) {
					A=i;
					if(A==B||Xnum>Long.MAX_VALUE) {//A!=B&범위 안쪽;
						System.out.println("Impossible");
						return;
					}
					else {
						long X_Long=(long)Xnum;
						System.out.println(X_Long+" "+A+" "+B);
						return;
					}
					
				}
			}
		}
	}
} 
	
