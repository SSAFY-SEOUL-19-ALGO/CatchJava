package week2_박건우;

public class P42883 {	// 큰 수 만들기

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_P42883 sol = new Solution_P42883();
		System.out.println(sol.solution("1924",2));
	}
}

class Solution_P42883 {
    public String solution(String number, int k) {
    	StringBuilder st = new StringBuilder("");
    	int left, max;
    	int start = 0;
        
        while(start < number.length() && st.length() != number.length() - k) {
        	left = k + st.length() + 1;
        	max = 0;
        	for(int i = start; i < left; i++) {
        		if(max < number.charAt(i) - '0') {
        			max = number.charAt(i) - '0';
        			start = i + 1;
        		}
        	}
        	st.append(Integer.toString(max));
        }
        
        return st.toString();
    }
}