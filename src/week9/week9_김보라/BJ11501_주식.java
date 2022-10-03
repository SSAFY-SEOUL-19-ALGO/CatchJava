package week9.week9_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11501_주식 {
/* O(n^2)
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String arr[] = br.readLine().split(" ");
			int gap[] = new int[N];
			
			for(int n = 0; n<N-1; n++) {
				gap[n]=Integer.parseInt(arr[n+1])-Integer.parseInt(arr[n]);
			}
//			System.out.println(Arrays.toString(gap));
			int answer = 0;
			for(int i = 0; i<N-1; i++) {
				int[] tmp = new int[N-i];
				tmp[0]=0;
				int num = 0;
				for(int j = i; j<N-1; j++) {
					tmp[num+1]=tmp[num]+gap[j];
					num++;
				}
//				System.out.println(Arrays.toString(tmp));
				Arrays.sort(tmp);
				
				answer+=tmp[tmp.length-1];
			}
		
			System.out.println(answer);
			
		}
	}
	*/
	//long.......ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String arr[] = br.readLine().split(" ");
			int gap[] = new int[N];
			
			long max = 0;
			long answer =0;
			for(int n = N-1; n>=0; n--) {
				if(Integer.parseInt(arr[n])>max) {
					max=Integer.parseInt(arr[n]);
				}
				answer+=max-Integer.parseInt(arr[n]);
			}
			
		
			System.out.println(answer);
			
		}
	}
	/*반례
	 * 1
	 * 10
	 * 1 2 5 4 3 7 6 5 9 8
	 * 
	 * 39
	 * 
	 * 1
	 * 4
	 * 2 2 1 3
	 * 
	 * 4
	 * 
	 * 1
	 * 5
	 * 1 2 3 4 5
	 * 
	 * 10
	 * 
	 */

}
