package week2_박건우;

public class P42842 {	// 카펫

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int y = 1; y <= yellow; y++) {	// y가 내부 사격형 가로
        	int x = yellow / y;	// x가 내부 사각형 세로
        	if(x < y)	// 가로가 길어졌으면 멈춤, x, y가 정해진다
        		break;
        
        
	        int total = (x + 2) * (y + 2);	// 해당 외부 사각형의 넓이가 (x + 2) * (y + 2) 이고
	        if(total == yellow + brown) {	// 해당 사각형의 넓이가 두 사각형의 합과 같다면
	        	answer[0] = x + 2;	// 사각형의 가로 길이는 내부 사각형 가로 + 2
	        	answer[1] = y + 2;	// 사각형의 세로 길이는 내부 사각형 세로 + 2
	        }
        }
        return answer;
    }
}