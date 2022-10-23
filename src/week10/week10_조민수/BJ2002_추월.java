package week10.week10_조민수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ2002_추월 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();//문자열에 번호를 매겨 저장 
        int ans = 0;

        for(int i=0; i<N; i++) {
            String input = br.readLine();//문자열 입력받기
            map.put(input, i);//번호로 저장
        }
        int[] out = new int[N];

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            out[i] = map.get(input);//저장된 번호를 기준으로 out 배열
        }

        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(out[i]>out[j]) {//아웃배열 기준으로 순서가 바뀌면 추월차량으로 계산 
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}