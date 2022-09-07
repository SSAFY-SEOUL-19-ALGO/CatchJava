package week5.week5_조민수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {
	static int length;
	static int result;//가능한 결과 저장
	static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		length=Integer.parseInt(br.readLine());
		num=new int[length+1];
		num[1]=1;
		num[2]=1;
		for(int n=3;n<=length;n++){
			num[n]=num[n-1]+num[n-2];
		}
		System.out.println(num[length]);
	}
	

}
