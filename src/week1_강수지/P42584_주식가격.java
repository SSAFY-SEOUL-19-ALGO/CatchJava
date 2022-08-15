package week1_강수지;

public class P42584_주식가격 {
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; // 주식가격만큼
    
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){ // 현재 인덱스부터 n까지 비교
                    answer[i]++;
                if(prices[i]>prices[j]){ // 만약 주식이 떨어졌다면 볼 필요도 없어 ~
                    break;
                }
            }     
        }
        return answer;
    }
}
