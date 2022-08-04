package 강수지;
import java.util.Arrays;
import java.util.Scanner;

public class P004_SWEA1208_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // test_case
		for(int i=1; i<=T;i++) {
			
			int dump = sc.nextInt();
			int Max_size = 100;
			int[] height = new int[Max_size]; // 가로 길이가 항상  100
			
			for(int j=0;j<Max_size;j++) {
				height[j] = sc.nextInt();
			}
			
			Arrays.sort(height);// 오름 차순 정렬
			
			int dumpchar = 0;
			
			for(int j=0;j<dump;j++) { // 덤프 횟수만큼 돌며
				// 상자를 낮은 부분에 덤프해줌
				height[0]++; // 최저점
				height[height.length-1]--;// 최고점
				
				Arrays.sort(height);// 매번 정렬 ...
				
			}
			dumpchar = height[height.length-1]-height[0];

			System.out.printf("#%d %d\n", i, dumpchar);
		} // test case 종료
	} // main 종료

}
