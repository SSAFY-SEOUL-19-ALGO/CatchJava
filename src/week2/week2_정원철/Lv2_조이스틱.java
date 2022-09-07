package week2.week2_정원철;

public class Lv2_조이스틱 {
	
	static public int solution(String name) {
        int answer = 0;
        int cnt = 0;
        int N=name.length();
        // 바꿔야할 가장 가까운 자리를 찾아야한다 좌우에서 A의 개수를 비교해 판단

       //해당 배열에서 A의 위치는 true, 현위치에서 좌우비교후 더 짧은 경로는 true 
        boolean[] cheked = new boolean[N];
       
        
        // 위 아래 키
        for(int i=0; i<N ; i++){
            char chk = name.charAt(i);
            if(chk !='A'){
                if(chk <= 'N'){
                    answer += (chk-'A');
                }else{
                    answer += ('Z'-chk+1);
                }
                ++cnt;
            }else{
                cheked[i] = true;
            }
        }
        
        // 오른쪽 왼쪽 키
        int positon = 0;
        
        
        //A가 아닌 원소 개소만큼 반복문
        
        
        for(int i=0; i<cnt; i++){
            if(cheked[positon]){
                int L_Idx = positon;
                int R_Idx = positon;
                int L = 0;
                int R = 0;
                
                while(cheked[L_Idx]){
                    if(L_Idx == 0)
                        L_Idx = N-1;
                    else
                        --L_Idx;
                    ++L;
                }
                while(cheked[L_Idx]){
                    R_Idx = (R_Idx+1)%N;
                    ++R;
                }
                if(L >= R){
                    positon=R_Idx;
                    answer+=R;
                }else{
                    positon=L_Idx;
                    answer+=L;
                }
            }
            cheked[positon] = true;
        }
        return answer;
    }
	    
	
	public static void main(String[] args) {

		System.out.println(solution("JEROEN"));
		System.out.println(solution("JAN"));
	}

}
