package week10.week10_박건우;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class BJ2002_추월 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt, key;
        int cnt = 0;

        int N = Integer.parseInt(br.readLine());

        // 입구에서 들어감, 출구에서 나옴을 각각 구현해 줌
        HashMap<String ,Integer> enter = new HashMap<>();
        //HashMap<String ,Integer> out = new HashMap<>();

        for(int i = 1; i <= N; i++){
            enter.put(br.readLine(), i);
        }

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = enter.get(br.readLine());
        }

        for(int i = 0; i < N-1; i++){
            for (int j = i+1; j < N; j++) {
                if(arr[i] > arr[j]) {
                    cnt++;
                    break;
                }
            }
        }


//        // 반복 가능한 iterator를 사용함
//        Iterator<String> keys = enter.keySet().iterator();
//        while(keys.hasNext()){
//            key = keys.next();
//            if(enter.get(key) - out.get(key) > 0) cnt++;
//        }



        System.out.println(cnt);
    }
}
