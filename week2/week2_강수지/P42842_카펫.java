package week2_강수지;

public class P42842_카펫 {
	    public int[] solution(int brown, int yellow) {
	        int[] answer = new int[2]; // 가로와 세로를 출력하기 위해
	        int area = brown + yellow; // 전체 면적의 넓이
	        
	        // 가로의 길이가 세로보다 길어야한다
	        for(int i=3;i<area;i++){ // 노란색이 가운데 위치하려면 3 이상부터
	            int j = area/i; // 가로
	            
	            if(i>j) continue; // 가로가 더 길어야되니까 안된다
	            
	            if((i-2)*(j-2) == yellow){ // 노란색의 넓이는 x-2 y-2 이므로
	                answer[0] = j;// 더 긴 길이가 가로
	                answer[1] = i; // 더짧은 길이가 세로 !
	                return answer;
	            }
	        }
	        return answer;
	    }
}
