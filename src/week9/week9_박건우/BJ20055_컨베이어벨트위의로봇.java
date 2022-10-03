package week9.week9_박건우;

import java.io.*;

public class BJ20055_컨베이어벨트위의로봇 {
    public static int N, K;
    public static int[] hp;
    public static boolean[] robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt;
        int cnt = 0;

        ipt = br.readLine().split(" ");
        N = Integer.parseInt(ipt[0]);
        K = Integer.parseInt(ipt[1]);
        hp = new int[2 * N];
        robot = new boolean[N];

        ipt = br.readLine().split(" ");
        for(int i = 0; i < hp.length; i++){
            hp[i] = Integer.parseInt(ipt[i]);
        }

        while(check()){
            int temp = hp[hp.length-1]; // 1. 벨트 한 칸 회전
            for(int i = hp.length-1; i > 0; i--){
                hp[i] = hp[i-1];
            }
            hp[0] = temp;

            // 로봇도 회전시킴
            for(int i = robot.length - 1; i > 0; i--){
                robot[i] = robot[i-1];
            }
            robot[0] = false;

            robot[N-1] = false;
            // 2. 로봇 이동 가능하면 이동하기
            for(int i = N - 1; i > 0; i--){
                if(robot[i-1] && !robot[i] && hp[i] > 0){
                    robot[i] = true;
                    robot[i-1] = false;
                    hp[i]--;
                }
            }

            // 3. 올라가는 로봇 위치에 로봇 올리기
            if(hp[0] > 0){
                robot[0] = true;
                hp[0]--;
            }

            cnt++;
        }
        bw.write(cnt+"\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean check(){
        int cnt = 0;

        for(int i = 0; i < hp.length; i++){
            if(hp[i] == 0){ // 0이 된 곳을 카운트함
                cnt++;
            }
            if(cnt >= K) return false;  // 0이 된 곳이 K개 이상이면 조건 통과 실패
        }
        return true;
    }
}
