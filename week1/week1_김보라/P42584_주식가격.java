package week1_김보라;
 
public class P42584_주식가격 {
	static int[] prices = {1,2,3,2,3};
	public static void main(String[] args) {
		int[] answer = new int[prices.length];
		
		for(int i = 0; i<prices.length; i++) {
			for(int j =i+1; j<prices.length; j++) {
				answer[i]++;
				if(prices[i]>prices[j])
					break;
			}
		}
		
		for(int i = 0; i<prices.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}

}

/*class Solution {
public int[] solution(int[] prices) {
int[] answer = new int[prices.length];

for(int i = 1; i<prices.length; i++) {
	for(int j =0; j<i; j++) {
		if(prices[i]>=prices[j])
			answer[j]++;
	}
}

return answer;
}
}*/

/*class Solution {
public int[] solution(int[] prices) {
int[] answer = new int[prices.length];

for(int i = 0; i<prices.length; i++) {
	for(int j =i+1; j<prices.length; j++) {
		if(prices[i]<=prices[j])
			answer[i]++;
	}
}


return answer;
}
}*/