package week9.week9_박건우;

import java.io.*;

public class BJ17609_회문 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ipt;
        int ans, l, r;
        String word;

        int T = Integer.parseInt(br.readLine());

        for(int rpt = 0; rpt < T; rpt++){
            word = br.readLine();
            l = 0;
            r = word.length() - 1;
            ans = ispal(word, l, r);
            System.out.println(ans);
        }
    }

    public static int ispal(String word, int l, int r){
        String rev, cl, cr;
        sb =  new StringBuilder(word);
        rev = sb.reverse().toString();
        if(word.equals(rev)) return 0;
        else{
            while(l < r){
                if(word.charAt(l) != word.charAt(r)){
                    if(ispseudo(word, l + 1, r) || ispseudo(word, l, r-1)){
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    l += 1;
                    r -= 1;
                }
            }
        }

        return 0;
    }

    public static boolean ispseudo(String word, int l, int r){
        while(l < r){
            if(word.charAt(l) == word.charAt(r)){
                l += 1;
                r -= 1;
            } else{
                return false;
            }
        }
        return true;
    }
}
