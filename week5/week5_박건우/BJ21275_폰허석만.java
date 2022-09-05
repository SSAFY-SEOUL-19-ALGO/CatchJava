package week5_박건우;

import java.io.*;

public class BJ21275_폰허석만 {
    static String ax, bx, x, max;
    static long a, b;
    static int cnt;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        cnt = 0;
        ax = s[0];
        bx = s[1];
        max = String.valueOf(Math.pow(2, 63));

        arr = new int[200];

        for(int i = 0; i < 9; i++){
            arr[i+'1'] = i + 1;
        }

        for(int i = 0; i < 26; i++){
            arr[i+'a'] = i + 10;
        }

        solve();

        if(cnt == 0){
            bw.write("Impossible\n");
            bw.flush();
        } else if(cnt == 1){
            bw.write(x.substring(0, x.length() - 2) + " " + a + " " + b + "\n");
            bw.flush();
        } else{
            bw.write("Multiple"+"\n");
            bw.flush();
        }
    }

    public static void solve(){
        for(int i = 1; i <= 36; i++){
            for(int j = 1; j <= 36; j++){
                if(i == j) continue;

                if(check(i, ax) && check(j, bx)){
                    if(find(i, ax).equals(find(j, bx))){
                        if(find(i, ax).compareTo(max)>=1){
                            continue;
                        }
                        cnt++;
                        x=find(i, ax);
                        a=i;
                        b=j;
                    }
                }
            }
        }
    }

    public static String find(int a, String s){
        int temp=0;
        double result=0;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            int t = arr[s.charAt(i)];
            result += Math.pow(a, temp) * t;
            temp++;
        }
        return String.valueOf(result);
    }
    public static boolean check(int a, String s){
        for(int i=0; i<s.length(); i++){
            if(a<=arr[s.charAt(i)]){
                return false;
            }
        }
        return true;
    }
}